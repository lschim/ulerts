package com.ulerts.mayday;

import android.Manifest;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.telephony.SmsManager;
import android.util.Log;
import android.widget.Toast;

/**
 *  Receiver that get called when an outgoing call is made. If the number matches the emergency number
 *  sends a SMS with GPS location to
 *
 */
public class OutgoingEmergencyCallReceiver extends BroadcastReceiver {
    //TODO: Hardcoded values for now
    private static final String EMERGENCY_NUMBER = "8199891717";
    private static final String SOS_NUMBER = "+18196900685"; //Number at which SOS SMS is sent
    private static final String MESSAGE_TEMPLATE = "+18199441112 IS REQUESTING ASSISTANCE BY CALLING PhilouCartoux FROM POSITION %s %s";
    private static final String TAG = "OutgoingEmergencyCallReceiver";

    public OutgoingEmergencyCallReceiver() {
        Log.e("test", "CREATED");
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        String number = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
        Log.d(TAG, "Detected outgoing call to "+number);

        if(number.equals(EMERGENCY_NUMBER)){

            //This is an emergency call
            Location location = getLocation(context);
            if(location != null) {
                Log.i(TAG, location.toString());
                sendSMS(SOS_NUMBER, String.format(MESSAGE_TEMPLATE, location.getLatitude(), location.getLongitude()));
            }
        }
        Toast.makeText(context,
                "test: " + number,
                Toast.LENGTH_LONG).show();
    }


    /**
     * Retrieves the GPS location based on the latest known position, or null if no relevant position could be found
     * @param context
     * @return
     */
    private Location getLocation(Context context) {

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

    private void sendSMS(String phoneNumber, String message)
    {
        Log.i(TAG,"Sending SMS to "+phoneNumber+" : "+message);
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, message, null, null); //TODO: Fill the intents for errors on retry, and get cb when delivered
    }


}
