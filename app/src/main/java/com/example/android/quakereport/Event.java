package com.example.android.quakereport;

/**
 * Created by Brian on 11/25/2016.
 */

public class Event {

    // set private member variables for the getter and setter methods
    private Double mMagnitude;

    private String mLocation;

    private Long mDate;

    //here is the constructor method, taking in the three params atm
    public Event (Double vMagnitude, String vLocation, Long vDate) {
        mMagnitude = vMagnitude;
        mLocation = vLocation;
        mDate = vDate;

    }

    public Double getMagnitude(){
        return mMagnitude;
    }

    public String getLocation(){
        return mLocation;
    }

    public Long getDate(){
        return mDate;
    }


}
