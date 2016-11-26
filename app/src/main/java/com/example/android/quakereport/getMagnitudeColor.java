package com.example.android.quakereport;

import java.text.DecimalFormat;

import static android.R.attr.format;

/**
 * Created by Brian on 11/26/2016.
 */

public class getMagnitudeColor {
    private int mMagnitudeInput;
    public int theColor;

    public getMagnitudeColor (){

    }

    public int retrieve(double mag){

        DecimalFormat formatter = new DecimalFormat("0");
        String output = formatter.format(mag);
        mMagnitudeInput = Integer.parseInt(output);
        switch (mMagnitudeInput) {
            case 0:
            case 1:
                theColor = R.color.magnitude1;
                break;
            case 2:
                theColor = R.color.magnitude2;
                break;
            case 3:
                theColor = R.color.magnitude3;
                break;
            case 4:
                theColor = R.color.magnitude4;
                break;
            case 5:
                theColor = R.color.magnitude5;
                break;
            case 6:
                theColor = R.color.magnitude6;
                break;
            case 7:
                theColor = R.color.magnitude7;
                break;
            case 8:
                theColor = R.color.magnitude8;
                break;
            case 9:
                theColor = R.color.magnitude9;
                break;
            default:
                theColor = R.color.magnitude10plus;
                break;
        }
        return theColor;
    }

}
