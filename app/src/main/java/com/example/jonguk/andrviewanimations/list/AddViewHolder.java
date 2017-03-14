package com.example.jonguk.andrviewanimations.list;

import android.support.annotation.NonNull;
import android.view.View;

/**
 * Created by Jonguk on 2017. 3. 14..
 */

public class AddViewHolder extends AbsItemViewHolder {

    public AddViewHolder(View itemView, @NonNull final OnAnimItemClickListener listener) {
        super(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClickAdd(getAdapterPosition());
            }
        });
    }

    @Override
    public void bind(ItemData data) {
    }
}
