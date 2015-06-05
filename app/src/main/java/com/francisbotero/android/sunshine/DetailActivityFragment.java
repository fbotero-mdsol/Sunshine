package com.francisbotero.android.sunshine;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetailActivityFragment extends Fragment {

    public DetailActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        Intent intent = getActivity().getIntent();
        if (intent != null  && intent.hasExtra(Intent.EXTRA_TEXT)) {
            String forecastString = intent.getStringExtra(Intent.EXTRA_TEXT);
            TextView forecastStringView = (TextView)rootView.findViewById(R.id.forecast_string);
            forecastStringView.setText(forecastString);
        }
        return rootView;
    }
}
