package com.francisbotero.android.sunshine;

import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MockForecastDataProvider implements ForecastDataProvider {
    List<String> upcomingForecast;

    public MockForecastDataProvider() {
        String[] forecast = {
                "Today - Sunny - 88/63",
                "Tomorrow - Not Sunny - COLD/WET"
        };
        upcomingForecast = Arrays.asList(forecast);
    }

    @Override
    public List<String> getForecast(String postalCode) {
        return upcomingForecast;
    }
}
