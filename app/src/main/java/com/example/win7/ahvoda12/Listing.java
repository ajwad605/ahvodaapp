package com.example.win7.ahvoda12;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;

/**
 * Created by Win7 on 7/14/2015.
 */
public class Listing implements Parcelable {




    String restaurantName;
    String position;
    float lati;
    float longi;
    String Description;
    float hourlyPay;

    public Listing(String restaurantName, String position, float hourlyPay,int lati,int longi,String Description){

        this.restaurantName=restaurantName;
        this.position=position;
        this.hourlyPay=hourlyPay;
        this.lati=lati;
        this.Description=Description;
        this.longi= longi;


    }

    public Listing(Parcel in){

        restaurantName = in.readString();
        position = in.readString();
        hourlyPay= in.readFloat();
        Description=in.readString();
        lati=in.readFloat();
        longi=in.readFloat();


    }

    public String getRestaurantName(){

        return restaurantName;

    }


    public String getPosition(){
        return position;
    }

    public float getHourlyPay(){
        return hourlyPay;
    }

    public float getLati(){

        return lati;


    }

    public float getLongi(){

        return longi;

    }

    public String getDescription() {
        return Description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel in, int flags) {


        in.writeString(restaurantName);
        in.writeString(position);
        in.writeFloat(hourlyPay);
        in.writeString(Description);
        in.writeFloat(lati);
        in.writeFloat(longi);




    }




}
