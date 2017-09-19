package com.example.george.googlemapsprac;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        CheckUserPermsions();

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
    @Override
    public void onMapReady(GoogleMap googleMap) {
        ArrayList<Double> longitu = new ArrayList<>();
        ArrayList<Double> latitu = new ArrayList<>();
        longitu.add(14.5545901);
        longitu.add(120.9981703);
        longitu.add(14.5415112);
        longitu.add(121.002617);
        longitu.add(14.5531756);
        longitu.add(121.0140269);
    try
    {
        for(int i = 0; i<longitu.size();i++)
        {

            mMap = googleMap;
            mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            // Add a marker in Sydney and move the camera
            LatLng sydney = new LatLng(longitu.get(i), longitu.get(i+1));
            mMap.addMarker(new MarkerOptions().position(sydney).
                    title("Marker in Sydney")
                    .snippet("This is where I live").icon(BitmapDescriptorFactory.fromResource(R.drawable.toys)));
            mMap.addCircle(new CircleOptions()
                    .center(sydney)
                    .radius(20)
                    .strokeColor(Color.RED)
                    .fillColor(Color.BLUE));
            mMap.addPolyline(new PolylineOptions()
            .add(sydney)
            .width(25)
            .color(Color.GRAY)
            .geodesic(true));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 13));
        }
    }catch(Exception err)
    {
        //err.printStackTrace();
    }


    }
    //access to permsions
    void CheckUserPermsions(){
        if ( Build.VERSION.SDK_INT >= 23){
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) !=
                    PackageManager.PERMISSION_GRANTED  ){
                requestPermissions(new String[]{
                                android.Manifest.permission.ACCESS_FINE_LOCATION},
                        REQUEST_CODE_ASK_PERMISSIONS);
                return ;
            }
        }

       // getLastLocation();// init the contact list
        loclisten();

    }
    //get acces to location permsion
    final private int REQUEST_CODE_ASK_PERMISSIONS = 123;



    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //    getLastLocation();// init the contact list
                    loclisten();
                } else {
                    // Permission Denied
                    Toast.makeText( this,"your message" , Toast.LENGTH_SHORT)
                            .show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
    class myThread extends Thread
    {
        public void run()
        {
            while(true)
            {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mMap.clear();
                        if(locationlistener.location!=null)
                        {
                            LatLng sydney = new LatLng(locationlistener.location.getLatitude(), locationlistener.location.getLongitude());
                            mMap.addMarker(new MarkerOptions().position(sydney).
                                    title("Makati, Metro Manila")
                                    .snippet("This is where I live").icon(BitmapDescriptorFactory.fromResource(R.drawable.toys)));
                            mMap.addCircle(new CircleOptions()
                                    .center(sydney)
                                    .radius(20)
                                    .strokeColor(Color.RED)
                                    .fillColor(Color.BLUE));
                            mMap.addPolyline(new PolylineOptions()
                                    .add(sydney)
                                    .width(25)
                                    .color(Color.GRAY)
                                    .geodesic(true));
                            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 13));
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"Location not found!",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                try
                {
                    Thread.sleep(1000);
                }catch(Exception err)
                {
                    err.printStackTrace();
                }

            }
        }
    }
    void loclisten()
    {
        locationlistener locc = new locationlistener();
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,3,10,locc);//normal error
        myThread myyy = new myThread();
        myyy.start();
    }
}
