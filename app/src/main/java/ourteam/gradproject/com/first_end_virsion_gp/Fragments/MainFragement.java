package ourteam.gradproject.com.first_end_virsion_gp.Fragments;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.Loader;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ourteam.gradproject.com.first_end_virsion_gp.FaceDetectionClasses.DetectionActivity;
import ourteam.gradproject.com.first_end_virsion_gp.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainFragement.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainFragement#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragement extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    public static final int MY_PERMISSIONS_REQUEST_GET_LOCATION = 1,
            MY_PERMISSIONS_REQUEST_START_GPS = 2,TakeImage=300;
    AlertDialog.Builder alertDialog;


    /// data will be send************************************************************************
    Location current_Location;
    String myDeviceModel;
    String StringcurrentTime;
    ///*******************************************************************************************
    private OnFragmentInteractionListener mListener;

    public MainFragement() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragement.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragement newInstance(String param1, String param2) {
        MainFragement fragment = new MainFragement();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @BindView(R.id.instructions_text)
    LinearLayout instructions_text;
    @BindView(R.id.start_operation)
    Button start_operation;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main_fragement, container, false);
        ButterKnife.bind(this,view);
        get_device_info();
//        TextView testtext = view.findViewById(R.id.testtext);
//        testtext.setText(myDeviceModel);

      get_currnet_location();
        get_current_time();

        return view;
    }

    int y=0;
    @OnClick(R.id.start_operation)
    public void start_operation_button(){
        instructions_text.setVisibility(View.VISIBLE);
        start_operation.setBackground(getContext().getDrawable(R.drawable.redius_white_gray_shape));
        y=1;
        start_operation.setText("البدأ الان");
        if (y==1){
            Intent intent=new Intent(getContext(), DetectionActivity.class);
            startActivity(intent);
        }
    }

    public void get_device_info() {
        myDeviceModel = android.os.Build.MODEL + "\n";

        myDeviceModel += android.os.Build.VERSION.SDK + "\n";    // API Level
        myDeviceModel += Build.BRAND + "\n";        // Device
        myDeviceModel += Build.MANUFACTURER + "\n";        // Model
        myDeviceModel += String.valueOf(android.os.Build.VERSION.SDK_INT) + "\n";// Product
        myDeviceModel += android.os.Build.VERSION.RELEASE;

    }

    public void get_currnet_location() {
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

            } else {
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_GET_LOCATION);
            }
        } else {
            CheckGpsStatus();
        }
    }

    public void get_current_time(){
        DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm");
       StringcurrentTime = df.format(Calendar.getInstance().getTime());
        Toast.makeText(getContext(),StringcurrentTime,Toast.LENGTH_SHORT).show();

    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


    //see if gps is working or not
    public void CheckGpsStatus() {

        LocationManager locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);

        assert locationManager != null;
        boolean GpsStatus = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

        if (GpsStatus) {

            showSettingsAlert();
        } else {
            Location location = getmyLatlang();
            if (location != null) {
                current_Location = location;
                //   if (location.getLongitude()&&location.getLongitude()!=null)
                Toast.makeText(getContext(), location.getLatitude() + " " + location.getLongitude(), Toast.LENGTH_SHORT).show();
            }
        }

    }


    //show alert to ask for open GPS
    public void showSettingsAlert() {
        alertDialog = new AlertDialog.Builder(getContext());

        alertDialog.setTitle("الاعدادات");
        alertDialog.setCancelable(false);
        // Setting Dialog Message
        alertDialog.setMessage("السماح بالوصول للمكان الحالي");

        // Setting Icon to Dialog
        //alertDialog.setIcon(R.drawable.delete);

        alertDialog.setPositiveButton("الاعدادات", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivityForResult(intent, MY_PERMISSIONS_REQUEST_START_GPS);
                //      dialogif.cancel();

            }
        });


        alertDialog.show();

    }

    public Location getmyLatlang() {

        Location lastlocation = null;

        LocationManager locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

        }

        if (locationManager != null) {
            lastlocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        }
        if (lastlocation == null)
            if (locationManager != null) {
                lastlocation = locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);
            }


        return lastlocation;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == MY_PERMISSIONS_REQUEST_START_GPS) {
            String provider = Settings.Secure.getString(getActivity().getContentResolver(), Settings.Secure.LOCATION_PROVIDERS_ALLOWED);
            if (provider != null) {
                Location location = getmyLatlang();
                if (location != null)
                    Toast.makeText(getContext(), location.getLatitude() + " " + location.getLongitude(), Toast.LENGTH_SHORT).show();
            } else {

                showSettingsAlert();
            }
        }



    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {

            case MY_PERMISSIONS_REQUEST_GET_LOCATION: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    CheckGpsStatus();
                }
            }
        }

    }


}
