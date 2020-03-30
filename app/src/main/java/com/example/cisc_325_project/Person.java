package com.example.cisc_325_project;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Person implements Serializable {

    private String mName;
    private String mStatus;
    private int mResourceImage;
    private double mlocationLat;
    private double mlocationLng;

    public Person(String name, int resourceImage, String status) {
        this.mName = name;
        this.mResourceImage = resourceImage;
        this.mStatus = status;
    }

    public Person(String name, int resourceImage, String status, double latitude, double longitude) {
        this(name, resourceImage, status);
        mlocationLat = latitude;
        mlocationLng = longitude;
    }

    public int getmResourceImage() {
        return mResourceImage;
    }

    public String getmName() {
        return mName;
    }

    public String getmStatus() {
        return mStatus;
    }

    public boolean hasImage() {
        return mResourceImage != 0;
    }

    public double getMlocationLat() {
        return mlocationLat;
    }

    public double getMlocationLng() {
        return mlocationLng;
    }

    @NonNull
    @Override
    protected Object clone() {
        return new Person(mName, mResourceImage, mStatus, mlocationLat, mlocationLng);
    }
}
