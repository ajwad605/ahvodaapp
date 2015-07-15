package com.example.win7.ahvoda12;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.client.methods.HttpGet;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import android.os.*;

/**
 * Created by Win7 on 7/8/2015.
 */
public class Timer extends AppCompatActivity{

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(R.layout.timer);
        final TextView Timer;
        Timer = (TextView)findViewById(R.id.Timer);
        Button EndButton;
        EndButton = (Button)findViewById(R.id.EndButton);



        new CountDownTimer(10800000, 60000) {

            public void onTick(long millisUntilFinished) {
                Timer.setText("Minutes left at the Job remaining: " + millisUntilFinished / 60000);
            }

            public void onFinish() {
                Timer.setText("done!");
            }
        }.start();


        EndButton.setOnClickListener(new android.view.View.OnClickListener() {


            public void onClick(View view) {

                Intent intent = new Intent("com.example.win7.ahvoda12.FINALACTIVITY");
                startActivity(intent);

            }

        });





    }
}
