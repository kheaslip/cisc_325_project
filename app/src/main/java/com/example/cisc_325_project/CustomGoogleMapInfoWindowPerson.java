package com.example.cisc_325_project;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

public class CustomGoogleMapInfoWindowPerson implements GoogleMap.InfoWindowAdapter {

    private Context mContext;

    public CustomGoogleMapInfoWindowPerson(Context context) {
        mContext = context;
    }

    @Override
    public View getInfoContents(Marker marker) {
        return initializeView(marker);
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return initializeView(marker);
    }

    private View initializeView(Marker marker) {
        View view = ((Activity) mContext).getLayoutInflater().inflate(
                R.layout.maps_info_window_person,null);

        InfoWindowDataPerson personTag = (InfoWindowDataPerson) marker.getTag();

        if (personTag != null && view != null) {

            ((ImageView) view.findViewById(R.id.info_window_person_image)).setImageResource(
                    personTag.getmImageResourceID());
            ((TextView) view.findViewById(R.id.info_window_person_name)).setText(
                    personTag.getmName());
            ((TextView) view.findViewById(R.id.info_window_person_status)).setText(
                    personTag.getmStatus());
        }

        return view;
    }
}
