package com.example.cisc_325_project;

import java.util.ArrayList;
import java.util.Date;

public class EventItem {

    private String mName;
    private Date mStartDate;
    private Date mEndDate;
    private String mLocation;
    private String mDetails;
    private int mImageResource;
    private ArrayList<Person> mAttendees;

    public EventItem(String name, Date start, Date end, String location, String details,
                     int imageResource, ArrayList<Person> attendees) {
        this.mName = name;
        this.mStartDate = start;
        this.mEndDate = end;
        this.mLocation = location;
        this.mDetails = details;
        this.mImageResource = imageResource;
        this.mAttendees = attendees;
    }

    public String getmName() {
        return mName;
    }

    public Date getmStartDate() {
        return new Date(mStartDate.toString());
    }

    public Date getmEndDate() {
        return new Date(mEndDate.toString());
    }

    public String getmLocation() {
        return mLocation;
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
