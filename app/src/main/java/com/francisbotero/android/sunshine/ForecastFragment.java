package com.francisbotero.android.sunshine;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

public class ForecastFragment extends Fragment {
    ForecastDataUpdater updater;
    ForecastDataProvider refreshDataProvider;
    ArrayAdapter<String> adapter;

    public ForecastFragment() {
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.forecast_fragment, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_refresh) {
            updater.updateUsing(refreshDataProvider);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        setHasOptionsMenu(true);
         adapter =  new ArrayAdapter(
                        getActivity(),
                        R.layout.list_item_forecast,
                        R.id.list_item_forecast_textview);
        updater = new ForecastDataUpdater(adapter);
        AdapterView listView = (AdapterView)rootView.findViewById(R.id.listview_forecast);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new DetailOnItemClickListener());
        Context context = rootView.getContext();
        TemperatureConverterFactory factory = new TemperatureConverterFactory(context);
        WeatherDataParser parser = new WeatherDataParser(factory);
        refreshDataProvider = new OpenWeatherMapForecastDataProvider(parser);

        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        updater.updateUsing(refreshDataProvider);
    }
}
