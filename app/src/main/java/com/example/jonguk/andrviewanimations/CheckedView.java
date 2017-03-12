package com.example.jonguk.andrviewanimations;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;

/**
 * Created by Jonguk on 2017. 3. 12..
 */

public class CheckedView extends View implements Checkable {
    public static final int[] STATE_SET_CHECKED = {android.R.attr.state_checked};

    private boolean mIsChecked;

    public CheckedView(Context context) {
        this(context, null);
    }

    public CheckedView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CheckedView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setClickable(true);
    }

    @Override
    public void setChecked(boolean checked) {
        if (mIsChecked == checked) return;
        mIsChecked = checked;
        refreshDrawableState();
        if (mCheckedListener != null) {
            mCheckedListener.onChecked(checked);
        }
    }

    @Override
    public boolean isChecked() {
        return mIsChecked;
    }

    @Override
    public void toggle() {
        setChecked(!mIsChecked);
    }

    @Override
    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    public int[] onCreateDrawableState(int extraSpace) {
        if (isChecked()) {
            final int[] drawableState = super.onCreateDrawableState(extraSpace + 1);
            mergeDrawableStates(drawableState, STATE_SET_CHECKED);
            return drawableState;
        } else {
            return super.onCreateDrawableState(extraSpace);
        }
    }

    @Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        super.onInitializeAccessibilityEvent(event);
        event.setClassName(CheckedView.class.getName());
        event.setChecked(mIsChecked);
    }

    @Override
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        info.setClassName(CheckedView.class.getName());
        info.setCheckable(true);
        info.setChecked(mIsChecked);
    }

    public interface OnViewCheckedChangeListener {
        void onChecked(boolean isChecked);
    }
    public void setOnViewCheckedChangeListener(OnViewCheckedChangeListener listener) {
        mCheckedListener = listener;
    }
    private OnViewCheckedChangeListener mCheckedListener;
}
