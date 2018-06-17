package ourteam.gradproject.com.first_end_virsion_gp.Fragments.NerbyATMS;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.LocationSource;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import ourteam.gradproject.com.first_end_virsion_gp.GetNearestPlaces.IGoogleApiService;
import ourteam.gradproject.com.first_end_virsion_gp.GetNearestPlaces.NearestPlaces;
import ourteam.gradproject.com.first_end_virsion_gp.GetNearestPlaces.common;
import ourteam.gradproject.com.first_end_virsion_gp.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback ,GoogleApiClient.ConnectionCallbacks,GoogleApiClient.OnConnectionFailedListener{

    private GoogleMap mMap;
    SupportMapFragment mapFragment;
    GoogleApiClient googleApiClient;
    IGoogleApiService mGoogleApiService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

            } else {
                ActivityCompat.requestPermissions((Activity) this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        0);
            }
        } else {
            mapFragment.getMapAsync(this);


        }
        mGoogleApiService= common.getigooogleApiservice();
       // mGoogleApiService.getnearestplaces()
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        mapFragment.getMapAsync(this);

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    int x=0;
    MarkerOptions marker;
    double latidude,longitude;
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        marker = new MarkerOptions();

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

       // buildgoogleApi();
        mMap.setMyLocationEnabled(true);
        mMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {
            @Override
            public void onMyLocationChange(Location location) {
                if (x==0){
                Toast.makeText(getApplicationContext(),location.getLongitude()+"  "+location.getLatitude(),Toast.LENGTH_LONG).show();
                x=1;
                    marker.position(new LatLng(location.getLatitude(), location.getLongitude()));
                    marker.title("مكانك الحالي");
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(location.getLatitude(), location.getLongitude())));
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(location.getLatitude(), location.getLongitude()), 16.0f));
                    latidude=location.getLatitude();
                    longitude=location.getLongitude();
                    mMap.addMarker(marker);
                    getnearplace();

            }}
        });


    }


    private void getnearplace(){
        String url=geturl(latidude,longitude);
        mGoogleApiService.getnearestplaces(url)
                .enqueue(new Callback<NearestPlaces>() {
                    @Override
                    public void onResponse(Call<NearestPlaces> call, Response<NearestPlaces> response) {
                        if (response.isSuccessful()){
                            List<NearestPlaces.ResultsBean> places=response.body().getResults();
                            for (int i=0;i<places.size();i++){
                                MarkerOptions markerOptions=new MarkerOptions();
                                markerOptions.position(new LatLng(places.get(i).getGeometry().getLocation().getLat(), places.get(i).getGeometry().getLocation().getLng()));
                                markerOptions.title(places.get(i).getName());
                                mMap.addMarker(markerOptions);

                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<NearestPlaces> call, Throwable t) {

                    }
                });
    }

    private String geturl(double latidude,double longitude){
        Log.e("url","https://maps.googleapis.com/maps/api/place/nearbysearch/json?location="+latidude+","+longitude+"&radius=500&types=atm&key=AIzaSyAebxlq7xaKyfWEnpXUAe4NZ6I6YXjEcPk");

        return "maps/api/place/nearbysearch/json?location="+latidude+","+longitude+"&radius=500&types=atm&key=AIzaSyAebxlq7xaKyfWEnpXUAe4NZ6I6YXjEcPk";
    }
  public void buildgoogleApi(){
//        googleApiClient=new GoogleApiClient.Builder(this)
//                .addConnectionCallbacks(this)
//                .addOnConnectionFailedListener(this)
//                .addApi();
  }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
