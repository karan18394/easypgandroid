package com.example.googlesigninapi;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.app.Fragment;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.Build;
import android.os.Bundle;

import android.app.FragmentManager;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.Locale;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerDragListener {
    GoogleMap map;
    Marker marker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Layout is", R.layout.activity_map+"");
        setContentView(R.layout.activity_map);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        Log.d("mapFragment is",mapFragment+"");

        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        LatLng Delhi = new LatLng(28.547468, 77.272087);
        marker= map.addMarker(new MarkerOptions()
                .position(Delhi)

                .draggable(true)
                .title("Delhi")
        );
        map.setOnMarkerDragListener(this);



//        map.getUiSettings().setZoomControlsEnabled(true);
////        map.addMarker(new MarkerOptions().position(Delhi).title("Delhi"));
////        map.moveCamera(CameraUpdateFactory.newLatLng(Delhi));
//        map.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() {
//            @Override
//            public void onMarkerDragStart(Marker marker) {
//            }
//
//            @Override
//            public void onMarkerDrag(Marker marker) {
//            }
//
//            @Override
//            public void onMarkerDragEnd(Marker marker) {
//                LatLng latLng = marker.getPosition();
//                Geocoder geocoder = new Geocoder(getApplicationContext(),
//                        Locale.getDefault());
//                try {
//                    Address address = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1).get(0);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
        map.moveCamera(CameraUpdateFactory.newLatLng(Delhi));



    }

//    @Override
//    public boolean onMarkerClick(Marker marker) {
//
//        Toast.makeText(this,"My_position:"+marker.getPosition(),Toast.LENGTH_LONG).show();
//
//        return false;
//    }

    @Override
    public void onMarkerDragStart(Marker marker) {
        Toast.makeText(this,"My_position:"+marker.getPosition(),Toast.LENGTH_LONG).show();


    }

    @Override
    public void onMarkerDrag(Marker marker) {

    }

    @Override
    public void onMarkerDragEnd(Marker marker) {
        Toast.makeText(this,"My_position:"+marker.getPosition(),Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Search_Filter.latitude_edit.setText(marker.getPosition().latitude+"");
        Search_Filter.longitude_edit.setText(marker.getPosition().longitude+"");
    }
}