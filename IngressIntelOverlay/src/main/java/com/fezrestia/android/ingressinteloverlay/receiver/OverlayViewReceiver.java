package com.fezrestia.android.ingressinteloverlay.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.fezrestia.android.ingressinteloverlay.Constants;
import com.fezrestia.android.ingressinteloverlay.activity.UserPreferenceActivity;
import com.fezrestia.android.ingressinteloverlay.control.OverlayViewController;
import com.fezrestia.android.ingressinteloverlay.util.Log;

public class OverlayViewReceiver extends BroadcastReceiver {
    // Log tag.
    private static final String TAG = OverlayViewReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Log.IS_DEBUG) Log.logDebug(TAG, "onReceive()");

        String action = intent.getAction();
        if (Log.IS_DEBUG) Log.logDebug(TAG, "ACTION = " + action);

        if (action == null) {
            if (Log.IS_DEBUG) Log.logDebug(TAG, "ACTION is NULL.");
            // NOP.
        } else if (Constants.INTENT_ACTION_START_PREFERENCE_ACTIVITY.equals(action)) {
            // Start preference activity.
            Intent startPreference = new Intent(Intent.ACTION_MAIN);
            startPreference.setClass(context, UserPreferenceActivity.class);
            startPreference.addFlags(0 // dummy
                    | Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(startPreference);
        } else {
            // Unexpected Action.
            throw new IllegalArgumentException("Unexpected Action : " + action);
        }
    }
}
