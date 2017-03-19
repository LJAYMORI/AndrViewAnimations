package com.example.jonguk.andrviewanimations.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jonguk.andrviewanimations.R;

/**
 * Created by Jonguk on 2017. 3. 19..
 */

public class DurationDialog {

    private static final int MAX_DURATION = 5000;

    private Dialog dialog;

    private int mCurrentDuration;

    public DurationDialog(@NonNull Context context, OnOkClickListener listener) {
        dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_duration);

        final TextView valueView = (TextView) dialog.findViewById(R.id.duration_value);
        View cancelView = dialog.findViewById(R.id.duration_cancel);
        View okView = dialog.findViewById(R.id.duration_ok);
        EditText inputView = (EditText) dialog.findViewById(R.id.duration_input);

        valueView.setText("Max duration : " + MAX_DURATION + " ms");
        cancelView.setOnClickListener(v -> dialog.dismiss());
        okView.setOnClickListener(v -> {
            try {
                int duration = Integer.parseInt(inputView.getText().toString());
                mCurrentDuration = duration > MAX_DURATION ? MAX_DURATION : duration;
            } catch (NumberFormatException e) {
                Toast.makeText(context, "Invalid duration", Toast.LENGTH_SHORT).show();
            }
            listener.onOkClick(mCurrentDuration);
            dialog.dismiss();
        });
    }

    public void show() {
        dialog.show();
    }

    public int getCurrentDuration() {
        return mCurrentDuration;
    }

    public interface OnOkClickListener {
        void onOkClick(int value);
    }
}
