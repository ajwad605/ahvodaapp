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
import android.widget.Toast;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

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

import java.net.URL;

public class MainActivity extends ActionBarActivity
{

    ProgressDialog Dialog;
    EditText InputPassword;
    EditText InputUsername;
    Button LoginButton;
    Button RegisterButton;



    protected void onCreate(Bundle bundle)
    {
        StrictMode.setThreadPolicy((new android.os.StrictMode.ThreadPolicy.Builder()).permitAll().build());
        super.onCreate(bundle);
        setContentView(R.layout.login);
        Dialog = new ProgressDialog(this);
        Dialog.setCancelable(false);
        InputUsername = (EditText)findViewById(R.id.Username);
        InputPassword = (EditText)findViewById(R.id.Password);
        LoginButton = (Button)findViewById(R.id.LoginButton);
        RegisterButton = (Button)findViewById(R.id.RegisterButton);
        LoginButton.setOnClickListener(new android.view.View.OnClickListener() {


            public void onClick(View view) {
                String Username = InputUsername.getText().toString().trim();
                String Password = InputPassword.getText().toString();
                // This is the cheat in the system
                if (Username.trim().length() > 0 && Password.trim().length() > 0) {



                    Log.v("its fine", "YO yo");

                    try {
                        // Log.v("Login: Response", EntityUtsils.toString((new DefaultHttpClient()).execute(httpget).getEntity()));

                        String Url = "http://www.ahvoda.com:5000/api/employees/test-employee";

                        HttpURLConnection connection = (HttpURLConnection) new URL(Url).openConnection();
                        String message = Username + ":" + Password;

                        String view1 = "Basic "+Base64.encodeToString(message.getBytes(), Base64.NO_WRAP);

                        Log.v("its fine", "YO yo");
                        connection.setRequestProperty("Authorization", view1);
                        Log.v("its fine", "YO yo");

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


                        Intent intent = new Intent("com.example.win7.ahvoda12.JOBPAGE");
                        intent.putExtra("Authinfo",view1);
                        startActivity(intent);

                        Log.v("Track", "it worked?");
                        Log.v("Track", "next page ");

                    }
                    // Misplaced declaration of an exception variable
                    catch (Exception e) {
                        Log.v("Track", ("Error: " + e));

                        int duration = Toast.LENGTH_SHORT;

                        Toast.makeText(getApplicationContext(), "Please Try Again", duration).show();

                    }


                } else {

                    int duration = Toast.LENGTH_SHORT;

                    Toast.makeText(getApplicationContext(), "Please enter all the credentials!", duration).show();

                }
            }


            {
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