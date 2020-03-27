package com.example.cisc_325_project;

import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.Random;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Context mContext;

    private final ArrayList<Person> people = new ArrayList<Person>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        people.add(new Person("Sasha Beltran", R.drawable.profile_woman_1, "At the gym",44.229444, -76.494350));
        people.add(new Person("Harmony Bennett", R.drawable.profile_woman_2, "Studying",44.225361, -76.498782));
        people.add(new Person("Tori Mcbride", R.drawable.profile_woman_3, "At the dinning hall", 44.224681, -76.496035));
        people.add(new Person("Saniya Hodson", R.drawable.profile_woman_4, "Playing basketball", 44.229316, -76.494139));

        people.add(new Person("Colin Woodard",R.drawable.profile_man_1,"At the dinning hall",44.224096, -76.500638));
        people.add(new Person("Mikhail Sanderson",R.drawable.profile_man_2,"Studying",44.227311, -76.495121));
        people.add(new Person("Blessing Baldwin",R.drawable.profile_man_3,"At conference",44.218255, -76.517759));
        people.add(new Person("Zacharias Phelps",R.drawable.profile_man_4,"Playing Go",44.194878, -76.438305));



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

        final GoogleMap mGoogleMap = googleMap;
        mContext = this;

        googleMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
            @Override
            public void onMapLoaded() {

                mMap = mGoogleMap;

                // units dp to px
                int padding = (int) (16 * Resources.getSystem().getDisplayMetrics().density);
                double lat, lng;
                Marker marker;
                LatLngBounds.Builder builder = new LatLngBounds.Builder();

                // for each person, given them their own pin on the map
                for (Person p : people) {
                    lat = p.getMlocationLat();
                    lng = p.getMlocationLng();
                    LatLng pos = new LatLng(lat, lng);

                    builder.include(pos);
                    marker = mMap.addMarker(new MarkerOptions()
                        .position(pos)
                        .icon(BitmapDescriptorFactory.defaultMarker(new Random().nextInt(360)))

                    );

                    mGoogleMap.setInfoWindowAdapter(
                            new CustomGoogleMapInfoWindowPerson(mContext));

                    marker.setTag(new InfoWindowDataPerson(
                            p.getmResourceImage(),p.getmName(),p.getmStatus())
                    );

                }
                LatLngBounds bounds = builder.build();
                mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds,padding)); // 16dp padding
            }
        });

    }
}
