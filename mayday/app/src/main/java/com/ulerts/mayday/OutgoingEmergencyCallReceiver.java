package com.ulerts.mayday;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.widget.Toast;

/**
 *  Receiver that get called when an outgoing call is made. If the number matches the emergency number
 *  sends a SMS with GPS location to
 *
 */
public class OutgoingEmergencyCallReceiver extends BroadcastReceiver {

    private static final String TAG = "OutgoingEmergencyCallReceiver";

    public OutgoingEmergencyCallReceiver() {
        Log.e("test", "CREATED");
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.d(TAG, "Detected outgoing call");
        String number = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
        if(number.equals("5819963350")){ //TODO: Hardcoded for now
            //This is an emergency call
            Location location = getCoord(context);
        }
        Toast.makeText(context,
                "test: " + number,
                Toast.LENGTH_LONG).show();
    }


    /**
     * Retrieves the GPS location
     * @param context
     * @return
     */
    private Location getCoord(Context context) {

        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Log.e(TAG, "Unable to retrieve location");
            return null;
        }
        //TODO: Check the GPS position is relevant
        if(locationManager != null) {
            Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if(location == null){
                location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            }
            if(location==null){
                location = locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);
            }
            return location;
        }
        return null;
    }


}
