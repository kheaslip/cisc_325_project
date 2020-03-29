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

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

import com.google.android.gms.maps.model.Marker;

/**
 * Used to determine what was clicked on the infoWindow on the google map, and handle the clicking
 */
public abstract class OnInfoWindowElemTouchListener implements View.OnTouchListener {

    private final View mView;
    private final Handler mHandler = new Handler();

    private Marker mMarker;
    private boolean mPressed = false;

    public OnInfoWindowElemTouchListener(View view) {
        this.mView = view;
    }

    public void setMarker(Marker marker) {
        this.mMarker = marker;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        // make sure event is on the screen
        if (0 <= event.getX() && event.getX() <= mView.getWidth() &&
            0 <= event.getY() && event.getY() <= mView.getHeight())
        {
            switch (event.getActionMasked()) {
                case MotionEvent.ACTION_DOWN:
                    startPress(); break;

                case MotionEvent.ACTION_UP:
                    mHandler.postDelayed(confirmClickRunable,150); break;

                case MotionEvent.ACTION_CANCEL:
                    endPress(); break;

                default: break;
            }
        } else {
            endPress();
        }
        return false;
    }

    private void startPress() {
        if (!mPressed) {
            mPressed = true;
            mHandler.removeCallbacks(confirmClickRunable);
            if (mMarker != null) {
                mMarker.showInfoWindow();
            }
        }
    }

    private boolean endPress() {
        if (mPressed) {
            this.mPressed = false;
            mHandler.removeCallbacks(confirmClickRunable);
            if (mMarker != null) {
                mMarker.showInfoWindow();
            }
            return true;
        } else {
            return false;
        }
    }

    private final Runnable confirmClickRunable = new Runnable() {
        @Override
        public void run() {
            if (endPress()) {
                onClickConfirmed(mView, mMarker);
            }
        }
    };

    protected abstract void onClickConfirmed(View v, Marker marker);
}
