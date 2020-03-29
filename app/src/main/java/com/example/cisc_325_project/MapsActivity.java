package com.example.cisc_325_project;

/**
* Rough tutorial for how to create map with custom marker info windows with clickable elements
* provided by <a href="https://stackoverflow.com/users/1970966/chose007">chose007</a> and
* <a href="https://stackoverflow.com/users/4613320/maddy">Maddy</a> in this
* <a href="https://stackoverflow.com/a/15040761/4696389">StackOverFlow page</a>
*
* Files based on this tutorial include:
* <ul>
*   <li>MapsActivity.java</li>
*   <li>MapWrapperLayout.java</li>
*   <li>OnInfoWindowElemTouchListener.java</li>
*   <li>activity_maps.xml</li>
*   <li>maps_info_window_person.xml</li>
* </ul>
*
* */

import android.content.res.Resources;
import android.os.Bundle;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
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

    private ViewGroup mInfoWindow;
    private ImageView mInfoImage;
    private TextView mInfoTitle;
    private TextView mInfoSnippet;
    private Button mInfoButton;
    private OnInfoWindowElemTouchListener mInfoButtonListener;

    private final ArrayList<Person> mPeople = new ArrayList<Person>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        // the people on the map
        {
            mPeople.add(new Person("Sasha Beltran", R.drawable.profile_woman_1, "At the gym",44.229444, -76.494350));
            mPeople.add(new Person("Harmony Bennett", R.drawable.profile_woman_2, "Studying",44.225361, -76.498782));
            mPeople.add(new Person("Tori Mcbride", R.drawable.profile_woman_3, "At the dinning hall", 44.224681, -76.496035));
            mPeople.add(new Person("Saniya Hodson", R.drawable.profile_woman_4, "Playing basketball", 44.229316, -76.494139));

            mPeople.add(new Person("Colin Woodard",R.drawable.profile_man_1,"At the dinning hall",44.224096, -76.500638));
            mPeople.add(new Person("Mikhail Sanderson",R.drawable.profile_man_2,"Studying",44.227311, -76.495121));
            mPeople.add(new Person("Blessing Baldwin",R.drawable.profile_man_3,"At conference",44.218255, -76.517759));
            mPeople.add(new Person("Zacharias Phelps",R.drawable.profile_man_4,"Playing Go",44.194878, -76.438305));
        }

    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {

        mMap = googleMap;
        mContext = this;

        final MapWrapperLayout mapWrapperLayout = (MapWrapperLayout) findViewById(R.id.map_layout);

        mapWrapperLayout.init(googleMap, getPixelsFromDp(this, 39 + 20));

        // get the xml elements of the infoWindow
        this.mInfoWindow = (ViewGroup)getLayoutInflater().inflate(R.layout.maps_info_window_person, null);
        this.mInfoTitle = (TextView) mInfoWindow.findViewById(R.id.info_window_person_name);
        this.mInfoSnippet = (TextView) mInfoWindow.findViewById(R.id.info_window_person_status);
        this.mInfoButton = (Button) mInfoWindow.findViewById(R.id.info_window_button_chat);
        this.mInfoImage = (ImageView) mInfoWindow.findViewById(R.id.info_window_person_image);

        // set OnTouchListener that handles the checking for what was pressed
        this.mInfoButtonListener = new OnInfoWindowElemTouchListener(mInfoButton,
                getResources().getDrawable(R.drawable.common_google_signin_btn_icon_light_normal),
                getResources().getDrawable(R.drawable.common_google_signin_btn_icon_light_focused))
        {
            @Override
            protected void onClickConfirmed(View v, Marker marker) {

                Toast.makeText(MapsActivity.this, marker.getTitle() + "'s button clicked!", Toast.LENGTH_SHORT).show();
            }
        };
        this.mInfoButton.setOnTouchListener(mInfoButtonListener);


        // define how the infoWindow is populated
        googleMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker marker) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {

                InfoWindowDataPerson personData = (InfoWindowDataPerson) marker.getTag();

                // Setting up the infoWindow with current's marker info
                mInfoTitle.setText(personData.getmName());
                mInfoSnippet.setText(personData.getmStatus());
                mInfoButtonListener.setMarker(marker);
                mInfoImage.setImageResource(personData.getmImageResourceID());

                // set the current marker and infoWindow references to the MapWrapperLayout
                mapWrapperLayout.setMarkerWithInfoWindow(marker, mInfoWindow);
                return mInfoWindow;

            }
        });

        // units dp to px
        int padding = (int) (16 * Resources.getSystem().getDisplayMetrics().density);
        double lat, lng;
        Marker marker;
        LatLngBounds.Builder builder = new LatLngBounds.Builder();

        // for each person, given them their own pin on the map
        for (Person p : mPeople) {
            lat = p.getMlocationLat();
            lng = p.getMlocationLng();
            LatLng pos = new LatLng(lat, lng);

            builder.include(pos);
            marker = googleMap.addMarker(new MarkerOptions()
                    .position(pos)
                    .icon(BitmapDescriptorFactory.defaultMarker(new Random().nextInt(360)))

            );

            marker.setTag(new InfoWindowDataPerson(
                    p.getmResourceImage(),p.getmName(),p.getmStatus())
            );

        }
        LatLngBounds bounds = builder.build();
        googleMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds,
                getResources().getDisplayMetrics().widthPixels,
                getResources().getDisplayMetrics().heightPixels, padding));

    }

    public static int getPixelsFromDp(Context context, float dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int)(dp * scale);
    }
}
