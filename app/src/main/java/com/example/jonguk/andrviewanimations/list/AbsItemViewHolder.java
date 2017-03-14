package com.example.jonguk.andrviewanimations.list;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Jonguk on 2017. 3. 14..
 */

public abstract class AbsItemViewHolder extends RecyclerView.ViewHolder {
    public AbsItemViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bind(ItemData data);
}
