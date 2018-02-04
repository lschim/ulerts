package com.ulerts.mayday;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

public class Configuration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);
        Log.e("Outgoing", "BOBBY");
        Context context = getApplicationContext();
        Toast.makeText(context, "CONFIGURATION IS CREATED", Toast.LENGTH_LONG * 10).show();
    }

}
