package com.example.cisc_325_project;

public class InfoWindowDataPerson {

    private int mImageResourceID;
    private String mName;
    private String mStatus;

    public InfoWindowDataPerson(int imageResourceID,String name,String status) {
        mImageResourceID = imageResourceID;
        mName = name;
        mStatus = status;
    }

    public int getmImageResourceID() {
        return mImageResourceID;
    }

    public String getmName() {
        return mName;
    }

    public String getmStatus() {
        return mStatus;
    }
}
