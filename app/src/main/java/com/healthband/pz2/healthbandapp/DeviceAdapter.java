package com.healthband.pz2.healthbandapp;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import java.util.ArrayList;

/**
 * Created by aubuntu on 28.01.18.
 */

public class DeviceAdapter extends ArrayAdapter<HBDevice> {
    public DeviceAdapter(Context context, ArrayList<HBDevice> devicesList) {
        super(context, 0, devicesList);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // Get the data item for this position
        HBDevice device = getItem(i);
        // Check if an existing view is being reused, otherwise inflate the view
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.layout_deivce, viewGroup, false);
        }
        // Lookup view for data population
        //TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
        //TextView tvHome = (TextView) convertView.findViewById(R.id.tvHome);
        // Populate the data into the template view using the data object
        //tvName.setText(user.name);
        //tvHome.setText(user.hometown);
        // Return the completed view to render on screen
        return view;
    }
}
