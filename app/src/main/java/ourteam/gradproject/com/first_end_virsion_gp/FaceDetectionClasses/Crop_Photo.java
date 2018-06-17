package ourteam.gradproject.com.first_end_virsion_gp.FaceDetectionClasses;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.SparseArray;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;
import com.google.android.gms.vision.face.Landmark;

public class Crop_Photo {
    Activity activity;
    final private static int width = 140;
    final private static int height = 180;

    public Crop_Photo(Activity activity1) {
        activity = activity1;
    }

    public Bitmap crop(Bitmap image) {
        FaceDetector faceDetector = new FaceDetector.Builder(activity)
                .setTrackingEnabled(false)
                .setLandmarkType(FaceDetector.ALL_LANDMARKS)
                .build();

        Frame frame = new Frame.Builder().setBitmap(image).build(); //get one frame from image
        SparseArray<Face> sparseArray = faceDetector.detect(frame);//put taken frame and detect all faces in it

        Face face = sparseArray.valueAt(0);
        float left = face.getPosition().x;
        float top = face.getPosition().y;
        Point start = start_Point(face,left,top);

        int right,bottom;
        right = (int)face.getWidth()+start.x;
        bottom = (int)face.getHeight()+start.y;

        Point end = end_Point(face,right,bottom);

        Rect src = new Rect( start.x, start.y, end.x, end.y);
        Rect dst = new Rect(0, 0, Math.abs(end.x - start.x), Math.abs( end.y - start.y));
        Bitmap cutBitmap = Bitmap.createBitmap(Math.abs(end.x - start.x),Math.abs( end.y - start.y), Bitmap.Config.RGB_565);

        Canvas canvas = new Canvas(cutBitmap);
        canvas.drawBitmap(image, src, dst, null);
        Bitmap newBitmap = RescaleBitmap(cutBitmap,height,width);
        return newBitmap;
    }

    public Bitmap RescaleBitmap(Bitmap bm, int newHeight, int newWidth) {
        int width = bm.getWidth();
        int height = bm.getHeight();
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        // CREATE A MATRIX FOR THE MANIPULATION
        Matrix matrix = new Matrix();
        // RESIZE THE BIT MAP
        matrix.postScale(scaleWidth, scaleHeight);
        // RECREATE THE NEW BITMAP
        Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, false);
        return resizedBitmap;

    }

    private Point end_Point(Face face, int right, int bottom) {
        int cx = 0,cy = 0;
        for (Landmark landmark : face.getLandmarks()) {
            if (landmark.getType() == Landmark.LEFT_EYE) //left ear
            {
                cx = (int) (landmark.getPosition().x);
                cx = (cx + right) / 2; //get average of start of photo and the eye
            }
            if (landmark.getType() == Landmark.BOTTOM_MOUTH)
            {
                cy = (int) (landmark.getPosition().y);
                cy = (cy + bottom) / 2;
            }

        }
        return new Point(cx,cy);
    }

    public Point start_Point(Face face,float left,float top) {
        int cx = 0,cy = 0;
        for (Landmark landmark : face.getLandmarks()) {
            if (landmark.getType() == Landmark.RIGHT_EYE) //left ear
            {
                cx = (int) (landmark.getPosition().x);
                cx = (cx+(int)left) / 2; //get average of start of photo and the eye
                cy = (int) (landmark.getPosition().y);
            }
            if (landmark.getType() == Landmark.LEFT_EYE) //left ear
            {
                cy = Math.max(cy,(int)(landmark.getPosition().y)); //get highest eye
                cy = (cy+(int)top) / 2;//average start of photo with highest eye
            }
        }
        return new Point(cx,cy);
    }

}
