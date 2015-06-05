package com.francisbotero.android.sunshine;

public class MetricToImperialTemperatureConverter implements TemperatureConverter {
    public double convert(double metric) {
        return (metric * 1.8) + 32;
    }
}
