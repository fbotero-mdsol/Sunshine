package com.francisbotero.android.sunshine;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

public class DetailOnItemClickListener implements AdapterView.OnItemClickListener {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Context context = view.getContext();
        Intent detailIntent = new Intent(context, DetailActivity.class);
        Object itemAtPosition = parent.getItemAtPosition(position);
        detailIntent.putExtra(Intent.EXTRA_TEXT, itemAtPosition.toString());
        context.startActivity(detailIntent);
    }
}
