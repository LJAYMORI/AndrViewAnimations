package com.example.jonguk.andrviewanimations;

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

    public static void animateBounce(@NonNull final View view) {
        AnimatorSet set = new AnimatorSet();
//        set.setInterpolator(new BounceInterpolator());
        set.setDuration(300);
        set.playTogether(
                ObjectAnimator.ofFloat(view, "scaleX", 1f, 1.3f, 0.95f, 1f),
                ObjectAnimator.ofFloat(view, "scaleY", 1f, 1.3f, 0.95f, 1f)
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
