package com.example.jonguk.andrviewanimations.utils;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.view.View;

/**
 * Created by Jonguk on 2017. 3. 12..
 */

public class AnimatorUtils {
    private static final String TAG = "AnimatorUtils";

    public static final String SCALE_X = "scaleX";
    public static final String SCALE_Y = "scaleY";
    public static final String TRANSLATION_X = "translationX";
    public static final String TRANSLATION_Y = "translationY";
    public static final String ROTATION = "rotation";
    public static final String ROTATION_X = "rotationX";
    public static final String ROTATION_Y = "rotationY";
    public static final String ALPHA = "alpha";

    public static void animateBounce(@NonNull final View view) {
        AnimatorSet set = new AnimatorSet();
//        set.setInterpolator(new BounceInterpolator());
        set.setDuration(300);
        set.playTogether(
                ObjectAnimator.ofFloat(view, SCALE_X, 1f, 1.3f, 0.95f, 1f),
                ObjectAnimator.ofFloat(view, SCALE_Y, 1f, 1.3f, 0.95f, 1f)
        );
        set.start();
    }

    public static void reset(@NonNull View view) {
        ViewCompat.setAlpha(view, 1);
        ViewCompat.setScaleX(view, 1);
        ViewCompat.setScaleY(view, 1);
        ViewCompat.setTranslationX(view, 0);
        ViewCompat.setTranslationY(view, 0);
        ViewCompat.setRotation(view, 0);
        ViewCompat.setRotationY(view, 0);
        ViewCompat.setRotationX(view, 0);
    }
}
