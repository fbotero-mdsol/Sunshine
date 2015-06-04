package com.francisbotero.android.sunshine;

import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by Frankie on 6/2/2015.
 */
public interface ForecastDataProvider {
    List<String> getForecast(String postalCode);
}
