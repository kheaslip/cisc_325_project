package com.example.cisc_325_project;

import java.util.ArrayList;

public class EventItem {

    private String mName;
    private String mDetails;
    private int mImageResource;
    private ArrayList<Person> mAttendees;


    public EventItem(String name, String details, int imageResource, ArrayList<Person> attendees) {
        this.mName = name;
        this.mDetails = details;
        this.mImageResource = imageResource;
        this.mAttendees = attendees;
    }

    public String getmName() {
        return mName;
    }

    public String getmDetails() {
        return mDetails;
    }

    public int getmImageResource() {
        return mImageResource;
    }

    public ArrayList<Person> getmAttendees() {
        if (mAttendees != null) {
            return (ArrayList<Person>) mAttendees.clone();
        } else {
            return null;
        }
    }

    public boolean hasImage() {
        return mImageResource != 0;
    }

}
