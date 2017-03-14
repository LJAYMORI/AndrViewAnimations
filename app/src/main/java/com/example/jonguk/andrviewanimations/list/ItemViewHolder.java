package com.example.jonguk.andrviewanimations.list;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.example.jonguk.andrviewanimations.R;

/**
 * Created by Jonguk on 2017. 3. 14..
 */

public class ItemViewHolder extends AbsItemViewHolder {

    private TextView mTitleView;
    private TextView mInterpolatorView;
    private TextView mDurationView;
    private TextView mPathsView;

    private ItemData mData;

    public ItemViewHolder(final View itemView, @NonNull final OnAnimItemClickListener listener) {
        super(itemView);
        mTitleView = (TextView) itemView.findViewById(R.id.title_anim_view);
        mInterpolatorView = (TextView) itemView.findViewById(R.id.interpolator_name_view);
        mDurationView = (TextView) itemView.findViewById(R.id.duration_name_view);
        mPathsView = (TextView) itemView.findViewById(R.id.paths_view);
        View removeView = itemView.findViewById(R.id.anim_remove);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClickItem(mData.id);
            }
        });
        removeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClickRemove(mData.id);
            }
        });
    }

    @Override
    public void bind(ItemData data) {
        mData = data;

        mTitleView.setText(data.name);
        mInterpolatorView.setText(data.getInterpolatorName());
        mDurationView.setText(data.getDuration());
        mPathsView.setText(data.getPaths());
    }
}
