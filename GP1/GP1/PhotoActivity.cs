using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

using Android.App;
using Android.Content;
using Android.Graphics;
using Android.OS;
using Android.Runtime;
using Android.Views;
using Android.Widget;

namespace GP1
{
    [Activity(Label = "PhotoActivity")]
    public class PhotoActivity : Activity
    {
        protected override void OnCreate(Bundle savedInstanceState)
        {
            base.OnCreate(savedInstanceState);

            // Create your application here
            SetContentView(Resource.Layout.TakenPhoto);
            ImageView imageView = FindViewById<ImageView>(Resource.Id.myimg);
            byte[] b = Intent.GetByteArrayExtra("img");
            Bitmap bitmap = BitmapFactory.DecodeByteArray(b, 0, b.Length);

            imageView.SetImageBitmap(bitmap);

        }
    }
}