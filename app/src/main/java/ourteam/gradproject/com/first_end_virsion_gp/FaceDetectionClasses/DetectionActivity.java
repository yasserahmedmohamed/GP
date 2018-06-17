package ourteam.gradproject.com.first_end_virsion_gp.FaceDetectionClasses;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.vision.CameraSource;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

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
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;

public class DetectionActivity extends AppCompatActivity implements CameraSource.PictureCallback{
    public static final int Takeimage = 1,
            MY_PERMISSIONS_REQUEST_USE_CAMER = 1;
    private String pathToImage;
    String URL = "http://192.168.1.10:8000";
    String s;
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
        Crop_Photo crop_photo=new Crop_Photo(this);
       Bitmap resultBitmap =crop_photo.crop(bitmapPicture);
       ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        resultBitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
      byte[]  byteArrayImage = byteArrayOutputStream.toByteArray();
       String encodedImage = Base64.encodeToString(byteArrayImage, Base64.DEFAULT );

       new socketRecieve(encodedImage,"").execute();

//        ByteArrayOutputStream bytes5 = new ByteArrayOutputStream();
//        bitmapPicture.compress(Bitmap.CompressFormat.JPEG, 90, bytes5);
//        File destination5 = new File(Environment.getExternalStorageDirectory(),
//                System.currentTimeMillis() + ".jpg");
//        FileOutputStream fo5;
//        try {
//            destination5.createNewFile();
//            fo5 = new FileOutputStream(destination5);
//            fo5.write(bytes5.toByteArray());
//            fo5.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        pathToImage = destination5.getPath();
//        finish();
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












    public class socketRecieve extends AsyncTask<Void, Void, String> {

        private String first;
        private String second;
        public socketRecieve(String a, String b) {
            super();
            // do stuff
            first = a;
            second = b;
        }
        @Override
        protected void onPreExecute() {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    if (second == "") {
                        HttpClient httpClient = new DefaultHttpClient();

                        HttpContext httpContext = new BasicHttpContext();

                        // Posting data to specific url..
                        HttpPost httpPost = new HttpPost(URL);
                        MultipartEntityBuilder multipartEntity = MultipartEntityBuilder.create();

                        multipartEntity.addPart("Image", new StringBody(first, ContentType.TEXT_PLAIN));
                       // multipartEntity.addBinaryBody("OSHA",byteArrayImage);
                        httpPost.setEntity(multipartEntity.build());

                        try {
                            httpClient.execute(httpPost);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    else {
                        HttpClient httpClient = new DefaultHttpClient();

                        HttpContext httpContext = new BasicHttpContext();
                        MultipartEntityBuilder multipartEntity = MultipartEntityBuilder.create();
                        // Posting data to specific url..
                        HttpPost httpPost = new HttpPost(URL);
                        multipartEntity.addPart("UserName", new StringBody(first, ContentType.TEXT_PLAIN));
                        multipartEntity.addPart("Password", new StringBody(second, ContentType.TEXT_PLAIN));
                        httpPost.setEntity(multipartEntity.build());

                        try {
                            httpClient.execute(httpPost);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }

        @Override
        protected String doInBackground(Void... voids) {

            ServerSocket serverSocket = null;
            Socket workerSocket = new Socket();
            DataInputStream socketInputStream;

            try {

                if (serverSocket == null) {
                    serverSocket = new ServerSocket(8222);

                    workerSocket = serverSocket.accept();
                }
                // When data are accepted socketInputStream will be invoked.
                socketInputStream = new DataInputStream(workerSocket.getInputStream());

    /* Since data are accepted as byte, all of them will be collected in the
    following byte array which initialised with accepted data length. */
                byte[] temp = new byte[2];
                socketInputStream.read(temp,0,temp.length);
                s = new String(temp);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }



        @Override
        protected void onPostExecute(String response) {
            super.onPostExecute(response);
            Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
            Log.e("result after responde",s);
            //myHandler.sendEmptyMessage(0);
        }

    }
}
