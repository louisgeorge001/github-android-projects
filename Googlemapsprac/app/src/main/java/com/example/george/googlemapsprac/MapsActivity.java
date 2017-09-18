package com.example.george.googlemapsprac;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

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
}
