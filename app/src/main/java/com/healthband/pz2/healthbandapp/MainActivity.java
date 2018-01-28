package com.healthband.pz2.healthbandapp;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private BluetoothAdapter bluetoothAdapter;

    public View.OnClickListener onStartClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //TODO: toast
            if(isScaning)   bluetoothAdapter.cancelDiscovery();
            bluetoothAdapter.startDiscovery();
        }
    }

    private ListView deviceListView;
    private ArrayList<HBDevice> deviceList = new ArrayList<>();
    private boolean isScaning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BluetoothDevice.ACTION_FOUND);
        intentFilter.addAction(BluetoothDevice.ACTION_UUID);
        intentFilter.addAction(BluetoothAdapter.ACTION_DISCOVERY_STARTED);
        intentFilter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
        registerReceiver(bluetoothReceiver, intentFilter);

        Button onStart = findViewById(R.id.onStart);
        onStart.setOnClickListener(onStartClick);

        deviceListView = findViewById(R.id.deviceList);
        deviceListView.setAdapter(new DeviceAdapter(this, deviceList));
    }

    public BroadcastReceiver bluetoothReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            switch(intent.getAction()){
                case BluetoothAdapter.ACTION_DISCOVERY_FINISHED:
                    break;
                case BluetoothAdapter.ACTION_DISCOVERY_STARTED:
                    break;
                case BluetoothDevice.ACTION_FOUND:
                    //TODO: add device to deviceListView;
                    break;
                case BluetoothDevice.ACTION_UUID:
                    break;
            }
        }
    };


}
