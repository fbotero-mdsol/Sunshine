package com.francisbotero.android.sunshine;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

public class ToastOnItemClickListener implements AdapterView.OnItemClickListener {
    private Toast previousToast;

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Object itemAtPosition = parent.getItemAtPosition(position);
        if (previousToast != null) {
            previousToast.cancel();
        }
        Toast toast = Toast.makeText(view.getContext(), itemAtPosition.toString(), Toast.LENGTH_SHORT);
        toast.show();
        previousToast = toast;
    }
}
