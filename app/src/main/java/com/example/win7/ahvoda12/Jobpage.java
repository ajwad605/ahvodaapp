// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.example.win7.ahvoda12;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import org.json.*;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Jobpage extends AppCompatActivity
{



    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(R.layout.jobpage);
        ListView list = (ListView)findViewById(R.id.JobList);
/*        Intent startingIntent = getIntent();
        String Authenticationinfo = startingIntent.getStringExtra("Authinfo");



        arrayadapter adapter;


        try {

            String Url = "http://www.ahvoda.com:5000/api/listings";

            HttpURLConnection connection = (HttpURLConnection) new URL(Url).openConnection();
            connection.setRequestProperty("Authorization", Authenticationinfo);

            connection.setRequestMethod("GET");
            Log.v("its fine", "YO yo");


            InputStream result = connection.getInputStream();

            InputStreamReader InputResult= new InputStreamReader(result);

            int numCharsRead;
            char[] charArray = new char[1024];
            StringBuffer sb = new StringBuffer();

            while ((numCharsRead = InputResult.read(charArray)) > 0) {
                sb.append(charArray, 0, numCharsRead);
            }

            String postresult = sb.toString();

            Log.d("TAG", postresult);

            JSONObject jsonRootObject = new JSONObject(postresult);

            System.out.print(jsonRootObject+"    At Least this is fine");

            JSONArray jsonArray = jsonRootObject.getJSONArray("listings");

            System.out.println(jsonArray);




            try{

               int a = jsonArray.length();
                System.out.println(a+" This is the amount ");
               Listing[] ListingArray = new Listing[a];

                for (int i=0;i<jsonArray.length();i++){
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    ListingArray[i].restaurantName = jsonObject.getJSONObject("business").getJSONObject("location").getJSONObject("name").toString();
                    System.out.print(ListingArray[i].restaurantName);
                    ListingArray[i].position = jsonObject.getJSONObject("business").getJSONObject("position").getJSONObject("name").toString();
                    System.out.print(ListingArray[i].position);
                    ListingArray[i].hourlyPay = Float.parseFloat(jsonObject.getJSONObject("business").getJSONObject("position").toString());
                }


                adapter = new  arrayadapter(this,R.layout.adapterview,ListingArray);
                list.setAdapter(adapter);


            }catch(JSONException e){


                Log.v("Track", ("JSONError: " + e));

                int duration = Toast.LENGTH_SHORT;

                Toast.makeText(getApplicationContext(), "Something wrong with JSON", duration).show();


            }




            Log.d("TAG", postresult);

        }
        catch (Exception e){


            int duration = Toast.LENGTH_SHORT;


            Toast.makeText(getApplicationContext(), "Please Try Again", duration).show();

            Log.v("Track", ("Error: " + e));


        } */


        String as[] = new String[2];
        as[0] = "Brigade      DishWasher                $15/h";
        as[1] = "Brigade      DishWasher                $15/h";

        ArrayList arraylist = new ArrayList();


        for (int i = 0; i < as.length; ++i) {
            arraylist.add(as[i]);
        }

        final ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, arraylist);
        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {


                Intent intent = new Intent("com.example.win7.ahvoda12.INFOPAGE");
                startActivity(intent);


            }



        });



    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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
