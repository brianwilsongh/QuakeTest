package com.example.android.quakereport;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import android.graphics.drawable.GradientDrawable;

/**
 * Created by Brian on 11/25/2016.
 */

public class EventAdapter extends ArrayAdapter<Event> {

    //initialize ArrayAdapter storage for context and arraylist
    //second argument 0 comes from fact that we are not using default single textview obj
    public EventAdapter(Activity context, ArrayList<Event> earthquakes){
        super(context, 0, earthquakes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;

        //see if list item is null, otherwise inflate a view to populate
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.event_item, parent, false);
        }

        // get and name the Event object at this position
        Event thisEvent = getItem(position);

        //get objects from custom view item layout, set values
        double rawMagnitude = thisEvent.getMagnitude();
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        String magnitudeString = decimalFormat.format(rawMagnitude);

        TextView magText = (TextView) listItemView.findViewById(R.id.displayMagnitude);
        magText.setText(magnitudeString);

        //set the background color on magnitude circle for view
        //fetch background from TextView which is GradientDrawable
        GradientDrawable magnitudeCircle = (GradientDrawable) magText.getBackground();
        //get appropriate color
        getMagnitudeColor retriever = new getMagnitudeColor();
        int magnitudeColor = ContextCompat.getColor(getContext(), (retriever.retrieve(thisEvent.getMagnitude())));
        magnitudeCircle.setColor(magnitudeColor);

        //get full location string, will be split in 2 - one for displayLocation, one for displayProximity
        String rawLocation = thisEvent.getLocation();

        //make the proximity string, if no value set it to 'Near the'
        String proximityString;
        if (rawLocation.contains("of")){
            proximityString = rawLocation.substring(0, (rawLocation.indexOf("of") + 3));
        } else {
            proximityString = "Near the";
        }

        //make the location string
        String locationString;
        if (rawLocation.contains("of")){
            locationString = rawLocation.substring((rawLocation.indexOf("of") + 3), rawLocation.length());
        } else {
            locationString = rawLocation;
        }


        //set the textview to their appropriate values
        TextView locationText = (TextView) listItemView.findViewById(R.id.displayLocation);
        locationText.setText(locationString);

        TextView proximityText = (TextView) listItemView.findViewById(R.id.displayProximity);
        proximityText.setText(proximityString);


        //For the date and time, we must convert milliseconds long into date string
        long timeInMilli = thisEvent.getDate();
        Date dateObject = new Date (timeInMilli);

        //format for the date
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM DD, yyyy");
        String dateString = dateFormat.format(dateObject);

        //format for the time
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:SS");
        String timeString = timeFormat.format(dateObject);

        //set the values into the xml layout
        TextView dateText = (TextView) listItemView.findViewById(R.id.displayDate);
        dateText.setText(dateString);

        TextView timeText = (TextView) listItemView.findViewById(R.id.displayTime);
        timeText.setText(timeString);

        return listItemView;


    }
}
