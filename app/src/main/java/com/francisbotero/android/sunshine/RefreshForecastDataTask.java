package com.francisbotero.android.sunshine;

import android.os.AsyncTask;
import android.widget.ArrayAdapter;

import java.util.List;

public class RefreshForecastDataTask extends AsyncTask<String, Void, List<String>> {

    ForecastDataProvider dataProvider;
    ArrayAdapter adapter;

    public RefreshForecastDataTask(ForecastDataProvider dataProvider, ArrayAdapter adapter) {
        this.dataProvider = dataProvider;
        this.adapter = adapter;
    }

    @Override
    protected List<String> doInBackground(String... params) {
        String postalCode = params[0];
        return dataProvider.getForecast(postalCode);
    }

    @Override
    protected void onPostExecute(List<String> result) {
        if (result != null) {
            this.adapter.clear();
            for (String forecast : result) {
                this.adapter.add(forecast);
            }
        }
    }
}
