package com.francisbotero.android.sunshine;

import android.widget.ArrayAdapter;

/**
 * Created by Frankie on 6/4/2015.
 */
public class ForecastDataUpdater {
    private ArrayAdapter adapter;

    public ForecastDataUpdater(ArrayAdapter adapter) {
        this.adapter = adapter;
    }
    public void updateUsing(ForecastDataProvider dataProvider) {
        RefreshForecastDataTask task = new RefreshForecastDataTask(dataProvider, adapter);
        task.execute("94045");
    }
}
