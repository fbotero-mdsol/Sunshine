package com.francisbotero.android.sunshine;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Frankie on 6/5/2015.
 */
public class PreferenceRepository {
    Context context;
    public PreferenceRepository(Context context) {
        this.context = context;
    }

    public String getLocation() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        String preferredLocationKey = context.getString(R.string.pref_location_key);
        String defaultLocationValue = context.getString(R.string.pref_location_default);
        return preferences.getString(preferredLocationKey, defaultLocationValue);
    }
}