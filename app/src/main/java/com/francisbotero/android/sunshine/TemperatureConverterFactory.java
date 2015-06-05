package com.francisbotero.android.sunshine;

import android.content.Context;

public class TemperatureConverterFactory {
    Context context;
    PreferenceRepository preferenceRepository;

    private static TemperatureConverter MetricToImperial = new MetricToImperialTemperatureConverter();
    private static TemperatureConverter MetricNoop = new MetricNoopTemperatureConverter();

    public TemperatureConverterFactory(Context context) {
        this.context = context;
        this.preferenceRepository = new PreferenceRepository(context);
    }

    public TemperatureConverter get() {
        String imperialType = context.getString(R.string.pref_units_imperial);

        TemperatureConverter converter =
                (preferenceRepository.getUnits() == imperialType) ?
                        MetricToImperial :
                        MetricNoop;
        return converter;
    }

}
