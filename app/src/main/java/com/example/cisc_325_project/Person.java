package com.example.cisc_325_project;

import java.io.Serializable;

public class Person implements Serializable {

    private String mName;
    private String mStatus;
    private int mResourceImage;

    public Person(String name, int resourceImage, String status) {
        this.mName = name;
        this.mResourceImage = resourceImage;
        this.mStatus = status;
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
}
