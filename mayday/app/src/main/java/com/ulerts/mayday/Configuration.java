package com.ulerts.mayday;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class Configuration extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);
        Log.e("Configuration", "createdConfigurationView");
        final Context context = getApplicationContext();


        setTriggerSwitchListener(context);
        setPhoneTextListeners(context);
    }

    /**
     * Set the listeners on the phone edit text of the view
     * @param context
     */
    private void setPhoneTextListeners(final Context context) {
        EditText.OnEditorActionListener listener = new EditText.OnEditorActionListener(){

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH ||
                        actionId == EditorInfo.IME_ACTION_DONE ||
                        event != null &&
                                event.getAction() == KeyEvent.ACTION_DOWN &&
                                event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    if (event == null || !event.isShiftPressed()) {

                        displayConfigurationSaved(context);
                        return false; // consume.
                    }
                }
                return false; // pass on to other listeners.
            }
        };


        ((EditText) findViewById(R.id.sosSendNumber)).setOnEditorActionListener(listener);
        ((EditText) findViewById(R.id.triggerPhoneNumber)).setOnEditorActionListener(listener);

    }
    /**
     * Add the listener on the switch that will hide / display elements of the configuration
     */
    private void setTriggerSwitchListener(final Context context){
        final TextView triggerNumberText = (TextView) findViewById(R.id.triggerNumberText);
        final TextView sosNumberText = (TextView) findViewById(R.id.sosNumberText);
        final EditText triggerNumberEditText = (EditText) findViewById(R.id.triggerPhoneNumber);
        final EditText sosNumberEditText = (EditText) findViewById(R.id.sosSendNumber);
        final View[] phoneBlock = {triggerNumberText, sosNumberText, triggerNumberEditText, sosNumberEditText};

        Switch enableTriggerSwitch = (Switch) findViewById(R.id.enableTrigger);
        enableTriggerSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // do something, the isChecked will be
                // true if the switch is in the On position
                for (View v : phoneBlock) {
                    if (isChecked) {
                        v.setVisibility(View.VISIBLE);
                    } else {
                        v.setVisibility(View.INVISIBLE);
                    }
                }
                displayConfigurationSaved(context);
            }
        });
    }

    private void displayConfigurationSaved(Context context){
        Toast.makeText(context, "Configuration saved", Toast.LENGTH_LONG * 10).show();
    }
}
