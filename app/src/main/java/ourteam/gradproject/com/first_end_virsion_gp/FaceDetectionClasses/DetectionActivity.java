package ourteam.gradproject.com.first_end_virsion_gp.FaceDetectionClasses;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.vision.CameraSource;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import ourteam.gradproject.com.first_end_virsion_gp.DataBaseSharedPrefrence.MySharedPrefrence;
import ourteam.gradproject.com.first_end_virsion_gp.R;
import ourteam.gradproject.com.first_end_virsion_gp.Sendimagebackend.RespodesFunctions;
import ourteam.gradproject.com.first_end_virsion_gp.Sendimagebackend.RespondeData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetectionActivity extends AppCompatActivity implements CameraSource.PictureCallback{
    public static final int Takeimage = 1,
            MY_PERMISSIONS_REQUEST_USE_CAMER = 1;
    private String pathToImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detection);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.CAMERA)) {

            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CAMERA},
                        MY_PERMISSIONS_REQUEST_USE_CAMER);
            }
        } else {
            Face_Detection face_detection = new Face_Detection(DetectionActivity.this);
            face_detection.start();//start Face detection and facial expression recognition
        }



    }

    @Override
    public void onPictureTaken(byte[] data) {
        Bitmap bitmapPicture = BitmapFactory.decodeByteArray(data, 0, data.length); //get the taken picture
        ByteArrayOutputStream bytes5 = new ByteArrayOutputStream();
        bitmapPicture.compress(Bitmap.CompressFormat.JPEG, 90, bytes5);
        File destination5 = new File(Environment.getExternalStorageDirectory(),
                System.currentTimeMillis() + ".jpg");
        FileOutputStream fo5;
        try {
            destination5.createNewFile();
            fo5 = new FileOutputStream(destination5);
            fo5.write(bytes5.toByteArray());
            fo5.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        pathToImage = destination5.getPath();
        //after add url call function
        // startsend();
    }







    RespodesFunctions service;
    ProgressDialog progressDialog;

    public void startsend() {
        MySharedPrefrence mySharedPrefrence=new MySharedPrefrence(this);
        mySharedPrefrence.saveoperationstatus();
        progressDialog = ProgressDialog.show(this, "", "Loading Please Wait...", true);
        progressDialog.setCancelable(false);
        progressDialog.show();
        service = new Retrofit.Builder().baseUrl("CHANGE_WITH_URL")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(RespodesFunctions.class);
        retrofit2.Call<RespondeData> req = service.send_image(GetImageToUpload(pathToImage));

        req.enqueue(new Callback<RespondeData>() {
            @Override
            public void onResponse(Call<RespondeData> call, Response<RespondeData> response) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(),response.body().result,Toast.LENGTH_LONG).show();


            }

            @Override
            public void onFailure(Call<RespondeData> call, Throwable t) {
                progressDialog.dismiss();

            }
        });

    }
    private MultipartBody.Part GetImageToUpload(String pathtoimageFile) {

        File file = new File(pathtoimageFile);
        MultipartBody.Part Imagebody;


        RequestBody reqFileselect = RequestBody.create(MediaType.parse("image/*"), file);

        Imagebody = MultipartBody.Part.createFormData("image", file.getName(), reqFileselect);

        return Imagebody;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_USE_CAMER: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Face_Detection face_detection = new Face_Detection(DetectionActivity.this);
                    face_detection.start();//start Face detection and facial expression recognition
                }
                break;
            }
        }
    }
}
