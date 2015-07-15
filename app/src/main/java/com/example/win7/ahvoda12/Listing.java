package com.example.win7.ahvoda12;

/**
 * Created by Win7 on 7/14/2015.
 */
public class Listing {




    String restaurantName;
    String position;
    float hourlyPay;

    public Listing(String restaurantName, String position, float hourlyPay){

        this.restaurantName=restaurantName;
        this.position=position;
        this.hourlyPay=hourlyPay;

    }

    public Listing(){}

    public String getRestaurantName(){

        return restaurantName;

    }


    public String getPosition(){
        return position;
    }

    public float getHourlyPay(){
        return hourlyPay;
    }
}
