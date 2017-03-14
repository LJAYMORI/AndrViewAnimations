package com.example.jonguk.andrviewanimations.list;

import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

import com.example.jonguk.andrviewanimations.R;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Jonguk on 2017. 3. 14..
 */

public class ItemData {

    public enum Type {
        ADD(R.layout.item_add),
        ITEM(R.layout.item_anim);

        int layoutId;

        Type(int layoutId) {
            this.layoutId = layoutId;
        }
    }

    private static final AtomicLong sIdGenerator = new AtomicLong();

    public long id;
    public Type type;
    public String name;
    public List<Float> pathList = new LinkedList<>();
    public Interpolator interpolator = new LinearInterpolator();
    public int duration;

    public ItemData(Type type, String name, List<Float> pathList, Interpolator interpolator, int duration) {
        id = sIdGenerator.getAndIncrement();
        this.type = type;
        this.name = name;
        this.pathList = pathList;
        this.interpolator = interpolator;
        this.duration = duration;
    }

    public int getTypeOrdinal() {
        return type.ordinal();
    }

    public String getInterpolatorName() {
        return interpolator.getClass().getSimpleName();
    }

    public String getDuration() {
        return duration + "ms";
    }

    public String getPaths() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0, size = pathList.size(); i < size; i++) {
            if (i != 0) {
                sb.append(", ");
            }
            sb.append(String.format("%.2f", pathList.get(i)));
        }
        return sb.toString();
    }

}
