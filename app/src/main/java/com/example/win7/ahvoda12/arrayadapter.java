package com.example.win7.ahvoda12;

import android.widget.ArrayAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Win7 on 7/13/2015.
 */
public class arrayadapter extends ArrayAdapter<Listing> {

     arrayadapter(Context context,int id, Listing[] items){

       super(context,R.layout.adapterview,items);

     }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());

        View adapterview = inflater.inflate(R.layout.adapterview, parent, false);
        TextView Restoname = (TextView)adapterview.findViewById(R.id.view1);
        TextView Title = (TextView)adapterview.findViewById(R.id.view2);
        TextView hourlywage=(TextView)adapterview.findViewById(R.id.view3);



        return adapterview;
    }


}
