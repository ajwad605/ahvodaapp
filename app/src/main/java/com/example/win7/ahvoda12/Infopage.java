// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.example.win7.ahvoda12;

import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.view.View;
import android.widget.TextView;
import android.widget.ImageButton;
import com.google.android.gms.maps.UiSettings;

public class Infopage extends AppCompatActivity
{
    GoogleMap mymap;
    TextView JobDescription;
    ImageButton acceptButton;
    TextView JobPosition;
    LatLng Store;
    TextView Rating;
    TextView Rate;

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(R.layout.infopage);
        Intent startingintent= getIntent();
        Listing listingValue = (Listing)startingintent.getSerializableExtra("passObject");


        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);

         JobDescription = (TextView)findViewById(R.id.textView4);
         acceptButton = (ImageButton)findViewById(R.id.imageButton1);
         JobPosition = (TextView)findViewById(R.id.JobPosition);
 //        Store = new LatLng(45.499632,-73.57445);
         Store = listingValue.getLocation();
         Rating = (TextView)findViewById(R.id.Rating);
         Rate = (TextView)findViewById(R.id.HourlyRate);

        mymap = mapFragment.getMap();
        mymap.setMyLocationEnabled(true);
        mymap.getUiSettings().setMyLocationButtonEnabled(false);
        mymap.addMarker(new MarkerOptions()
                .position(Store));
        mymap.animateCamera(CameraUpdateFactory.newLatLngZoom(Store,
                13));

        JobPosition.setText(listingValue.getPosition());
        Rating.setText("80");
        Rate.setText(String.valueOf(listingValue.getHourlyPay()));

        JobDescription.setText(listingValue.getDescription()+"Distance:500m"+"\n"+"Time:7min");


        acceptButton.setOnClickListener(new android.view.View.OnClickListener() {


            public void onClick(View view) {

                Intent intent = new Intent("com.example.win7.ahvoda12.ONWAY");
                startActivity(intent);

            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == R.id.action_settings)
        {
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }
}
