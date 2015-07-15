package com.example.win7.ahvoda12;

/**
 * Created by Win7 on 7/8/2015.
 */




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
        import android.widget.Button;
        import android.view.View;
        import android.widget.TextView;
        import android.widget.ImageButton;
        import android.widget.Toast;

        import com.google.android.gms.maps.UiSettings;

public class Onway extends AppCompatActivity {

   GoogleMap mymap;
   TextView Distance;
   TextView Time;
   LatLng Store;
   ImageButton Call;
   ImageButton Cancel;
   Button Start;
    protected void onCreate(Bundle bundle)
    {

        super.onCreate(bundle);
        setContentView(R.layout.onway);

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map2);

        Distance = (TextView)findViewById(R.id.Distance);
        Time = (TextView)findViewById(R.id.Time);
        Start = (Button)findViewById(R.id.JobButton);
        Store = new LatLng(45.499632,-73.57445);
        Call = (ImageButton)findViewById(R.id.Call);
        Cancel =(ImageButton)findViewById(R.id.Cancel);

        mymap = mapFragment.getMap();
        mymap.setMyLocationEnabled(true);
        mymap.getUiSettings().setMyLocationButtonEnabled(false);
        mymap.addMarker(new MarkerOptions()
                .position(new LatLng(45.499632, -73.57445))
                .title("Brigade Pizza"));
        mymap.animateCamera(CameraUpdateFactory.newLatLngZoom(Store,
                13));


        Distance.setText("Distance: 500m");
        Time.setText("Estimated Time:7min");

        Cancel.setOnClickListener(new android.view.View.OnClickListener() {


            public void onClick(View view) {
                int duration = Toast.LENGTH_SHORT;

                Toast.makeText(getApplicationContext(), "Canceling This job will effect your rankings", duration).show();
                Intent intent = new Intent("com.example.win7.ahvoda12.JOBPAGE");
                startActivity(intent);

            }
        });


        Start.setOnClickListener(new android.view.View.OnClickListener() {
            public void onClick(View view) {
                int duration = Toast.LENGTH_SHORT;

                Intent intent = new Intent("com.example.win7.ahvoda12.TIMER");
                startActivity(intent);

            }
        });    }


}
