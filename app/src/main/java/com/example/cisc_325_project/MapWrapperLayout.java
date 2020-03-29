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

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

public class MapWrapperLayout extends RelativeLayout {

    private GoogleMap mMap;
    private int mBottomOffsetPixels;
    private Marker mMarker;
    private View mInfoWindow;

    public MapWrapperLayout(Context context) {
        super(context);
    }

    public MapWrapperLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MapWrapperLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    /**
     * Must be called before we can route the touch events
     */
    public void init(GoogleMap map, int bottomOffsetPixels) {
        this.mMap = map;
        this.mBottomOffsetPixels = bottomOffsetPixels;
    }

    /**
     * Best to be called from either the InfoWindowAdapter.getInfoContents
     * or InfoWindowAdapter.getInfoWindow.
     */
    public void setMarkerWithInfoWindow(Marker marker, View infoWindow) {
        this.mMarker = marker;
        this.mInfoWindow = infoWindow;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        boolean ret = false;
        // Make sure that the infoWindow is shown and we have all the needed references
        if (mMarker != null && mMarker.isInfoWindowShown() && mMap != null && mInfoWindow != null) {
            // Get a marker position on the screen
            Point point = mMap.getProjection().toScreenLocation(mMarker.getPosition());

            // Make a copy of the MotionEvent and adjust it's location
            // so it is relative to the infoWindow left top corner
            MotionEvent copyEv = MotionEvent.obtain(ev);
            copyEv.offsetLocation(
                    -point.x + (mInfoWindow.getWidth() / 2),
                    -point.y + mInfoWindow.getHeight() + mBottomOffsetPixels);

            // Dispatch the adjusted MotionEvent to the infoWindow
            ret = mInfoWindow.dispatchTouchEvent(copyEv);
        }
        // If the infoWindow consumed the touch event, then just return true.
        // Otherwise pass this event to the super class and return it's result
        return ret || super.dispatchTouchEvent(ev);
    }
}
