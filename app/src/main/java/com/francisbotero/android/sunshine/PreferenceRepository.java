package com.francisbotero.android.sunshine;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Frankie on 6/5/2015.
 */
public class PreferenceRepository {
    Context context;
    SharedPreferences preferences;
    public PreferenceRepository(Context context) {
        this.context = context;
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public String getLocation() {
        String preferenceKey = context.getString(R.string.pref_location_key);
        String defaultValue = context.getString(R.string.pref_location_default);
        return preferences.getString(preferenceKey, defaultValue);
    }

    public String getUnits() {
        String preferenceKey = context.getString(R.string.pref_units_key);
        String defaultValue = context.getString(R.string.pref_units_imperial);
        return preferences.getString(preferenceKey, defaultValue);
    }
}
