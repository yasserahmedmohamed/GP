using Android.App;
using Android.Widget;
using Android.OS;
using Android.Graphics;
using Android.Gms.Vision.Faces;
using Android.Gms.Vision;
using Android.Util;
using Android.Graphics.Drawables;
using Android.Support.V7.App;
using Android.Views;
using Android.Runtime;
using Android.Support.V4.App;
using Android;
using System;
using Android.Content.PM;
using static Android.Gms.Vision.Detector;
using static Android.Gms.Vision.CameraSource;
using Android.Content;

namespace GP1
{//,
    [Activity(Label = "GP1", MainLauncher = true, Theme = "@style/Theme.AppCompat.Light.NoActionBar")]
    public class MainActivity : Activity,ISurfaceHolderCallback,IProcessor,IPictureCallback
    {
        SurfaceView sv;
        CameraSource cameraSource;
        FaceDetector face;
        TextView txt;
        const int RequestCameraID = 1001;
        bool captured = true,closed_eyes = false;
        ImageView iv;


        public override void OnRequestPermissionsResult(int requestCode, string[] permissions, [GeneratedEnum] Permission[] grantResults)
        {
            switch (requestCode)
            {
                case RequestCameraID:
                    {
                        if (grantResults[0] == Permission.Granted)
                        {
                            if (ActivityCompat.CheckSelfPermission(ApplicationContext, Manifest.Permission.Camera) != Android.Content.PM.Permission.Granted)
                            {
                                //Notlob permission
                                ActivityCompat.RequestPermissions(this, new string[] { Manifest.Permission.Camera }, RequestCameraID);
                                return;
                            }
                            try
                            {
                                cameraSource.Start(sv.Holder);
                            }
                            catch (InvalidOperationException)
                            {

                            }
                        }
                    }
                    break;
            }
        }


        protected override void OnCreate(Bundle savedInstanceState)
        {
            base.OnCreate(savedInstanceState);

            // Set our view from the "main" layout resource
            SetContentView(Resource.Layout.Main);
            sv = FindViewById<SurfaceView>(Resource.Id.campreview);
            txt = FindViewById<TextView>(Resource.Id.txt);
            iv = FindViewById<ImageView>(Resource.Id.img);
                 face = new FaceDetector.Builder(ApplicationContext)
                .SetTrackingEnabled(true)
                .SetLandmarkType(LandmarkDetectionType.All)
                .SetClassificationType(ClassificationType.All)
                .SetMode(FaceDetectionMode.Fast)
                .Build();

            

            cameraSource = new CameraSource.Builder(this, face)
                .SetRequestedPreviewSize(640, 480)
                .SetFacing(CameraFacing.Front)
                .SetRequestedFps(3)
                .Build();
            

            sv.Holder.AddCallback(this);

            face.SetProcessor(this);

            

        }
        
        //for camera surface options 
        public void SurfaceChanged(ISurfaceHolder holder, [GeneratedEnum] Format format, int width, int height)
        {
            

        }

        public void SurfaceCreated(ISurfaceHolder holder)
        {
            if (ActivityCompat.CheckSelfPermission(ApplicationContext, Manifest.Permission.Camera) != Android.Content.PM.Permission.Granted)
            {
                //Notlob permission
                ActivityCompat.RequestPermissions(this, new string[] { Manifest.Permission.Camera }, RequestCameraID);
                return;
            }
            try
            {
                cameraSource.Start(sv.Holder);
            }
            catch (InvalidOperationException)
            {

            }
           
        }

        public void SurfaceDestroyed(ISurfaceHolder holder)
        {
            cameraSource.Stop();
        }



        public void ShowToast(string text, bool IsLengthShort = false)
        {
            Handler mainHandler = new Handler(Looper.MainLooper);
            Java.Lang.Runnable runnableToast = new Java.Lang.Runnable(() =>
            {
                var duration = IsLengthShort ? ToastLength.Short : ToastLength.Long;
                Toast.MakeText(this, text, duration).Show();
            });

            mainHandler.Post(runnableToast);
        }


        //for detection faces
        public void func() {
        }
        public void ReceiveDetections(Detections detections)
        {
            SparseArray detectedfaces = detections.DetectedItems;

            //PictureCallback pictureCallback = new PictureCallback();
            

            if (detectedfaces.Size() != 0)
            {
                
                for (int i = 0; i < detectedfaces.Size(); i++)
                {
                    Face face = (Face)detectedfaces.ValueAt(i);

                    //ShowToast(" Blinked ", true);
                    txt.Post(() => {
                        txt.Text = face.IsLeftEyeOpenProbability.ToString() + "   " + face.IsRightEyeOpenProbability.ToString() ;
                    });
                    if ((face.IsLeftEyeOpenProbability + face.IsRightEyeOpenProbability)/2.0f< 0.3   && face.IsLeftEyeOpenProbability > 0 && face.IsRightEyeOpenProbability > 0)
                    {
                        closed_eyes = true;
                    }
                    if (closed_eyes)
                    {
                        if ((face.IsLeftEyeOpenProbability + face.IsRightEyeOpenProbability) / 2.0f >= 0.6 && face.IsLeftEyeOpenProbability > 0 && face.IsRightEyeOpenProbability > 0)
                        {
                            if (captured)
                            {
                                cameraSource.TakePicture(null, this);
                                captured = false;
                            }
                        }
                    }
                }
            }
           
        }

        public void Release()
        {
            
        }

        public void OnPictureTaken(byte[] data)
        {
           Bitmap bitmapPicture = BitmapFactory.DecodeByteArray(data, 0, data.Length);
            //  iv.SetImageBitmap(bitmapPicture);
            Intent intent = new Intent(this, typeof(PhotoActivity));
            intent.PutExtra("img", data);
            StartActivity(intent);
            Finish();
        }

        
    }

    
}

