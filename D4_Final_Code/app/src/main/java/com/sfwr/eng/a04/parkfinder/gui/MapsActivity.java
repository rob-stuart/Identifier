package com.sfwr.eng.a04.parkfinder.gui;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.sfwr.eng.a04.parkfinder.R;
import com.sfwr.eng.a04.parkfinder.blackboard.BlackBoard;
import com.sfwr.eng.a04.parkfinder.parks.Park;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private final static String TAG = "MINE== map";
    private GoogleMap mMap;
    private static LatLng loc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        Park park = (Park) getIntent().getSerializableExtra("park");
        loc = new LatLng(park.getLoc().getLatitude(), park.getLoc().getLongitude());

        Log.d(TAG, "oncreate " + park.getLoc());
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
        mMap = googleMap;
        // Add a marker in Sydney and move the camera
        mMap.addMarker(new MarkerOptions().position(loc).title("Park"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(loc));
    }
}
