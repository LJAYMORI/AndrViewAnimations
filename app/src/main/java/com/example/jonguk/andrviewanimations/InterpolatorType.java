package com.example.jonguk.andrviewanimations;

import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;

public enum InterpolatorType {
        // https://developer.android.com/reference/android/view/animation/Interpolator.html
        ACCELERATEDECELERATE(new AccelerateDecelerateInterpolator(), "AccelerateDecelerate"),
        ACCELERATE(new AccelerateInterpolator(), "Accelerate"),
        ANTICIPATE(new AnticipateInterpolator(), "Anticipate"),
        ANTICIPATEOVERSHOOT(new AnticipateOvershootInterpolator(), "AnticipateOvershoot"),
        //        BASEINTERPOLATOR(new BaseInterpolator()),
        BOUNCE(new BounceInterpolator(), "Bounce"),
        CYCLE(new CycleInterpolator(1.f), "Cycle"),
        DECELERATE(new DecelerateInterpolator(), "Decelerate"),
        FASTOUTLINEARIN(new FastOutLinearInInterpolator(), "FastOutLinearIn"),
        FASTOUTSLOWIN(new FastOutSlowInInterpolator(), "FastOutSlowIn"),
        LINEAR(new LinearInterpolator(), "LinearInter"),
        LINEAROUTSLOWIN(new LinearOutSlowInInterpolator(), "LinearOutSlowIn"),
        OVERSHOOT(new OvershootInterpolator(), "OvershootInter"),
//        PATH(new PathInterpolator(), "Path"),
        ;

        private Interpolator interpolator;
        private String name;

        InterpolatorType(Interpolator interpolator, String name) {
            this.interpolator = interpolator;
            this.name = name;
        }

        public Interpolator getInterpolator() {
            return interpolator;
        }

        public String getName() {
            return name;
        }
    }