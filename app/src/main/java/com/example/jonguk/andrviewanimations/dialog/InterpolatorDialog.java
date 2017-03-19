package com.example.jonguk.andrviewanimations.dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.widget.ArrayAdapter;

import com.example.jonguk.andrviewanimations.InterpolatorType;

/**
 * Created by Jonguk on 2017. 3. 19..
 */

public class InterpolatorDialog {

    private InterpolatorType mCurrentInterpolator = InterpolatorType.LINEAR;
    private AlertDialog.Builder dialogBuilder;

    public InterpolatorDialog(@NonNull Context context, OnItemClickListener listener) {
        dialogBuilder = new AlertDialog.Builder(context);
        dialogBuilder.setTitle("Select Interpolator");

        // init dialog items
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(context, android.R.layout.select_dialog_item);
        InterpolatorType[] values = InterpolatorType.values();
        for (InterpolatorType value : values) {
            arrayAdapter.add(value.getName());
        }
        dialogBuilder.setAdapter(arrayAdapter, (dialog, which) -> {
            InterpolatorType type = InterpolatorType.values()[which];
            mCurrentInterpolator = type;
            if (listener != null) {
                listener.onItemClick(type);
            }
        });

    }

    public void show() {
        dialogBuilder.show();
    }

    public InterpolatorType getmCurrentInterpolator() {
        return mCurrentInterpolator;
    }

    // Item Click Listener
    public interface OnItemClickListener {
        void onItemClick(InterpolatorType type);
    }
    private OnItemClickListener mOnItemClickListener;
    public void setOnItemClickListener(OnItemClickListener listener) {
        mOnItemClickListener = listener;
    }
}
