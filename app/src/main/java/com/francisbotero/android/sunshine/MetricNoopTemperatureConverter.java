package com.francisbotero.android.sunshine;

public class MetricNoopTemperatureConverter implements TemperatureConverter {
    @Override
    public double convert(double metric) {
        return metric;
    }
}
