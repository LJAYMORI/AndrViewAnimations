package com.example.jonguk.andrviewanimations.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jonguk on 2017. 3. 14..
 */

public class ItemAdapter extends RecyclerView.Adapter<AbsItemViewHolder> {

    private final List<ItemData> mItems = new ArrayList<>();
    private final OnAnimItemClickListener mClickListener;

    public ItemAdapter(OnAnimItemClickListener listener) {
        setHasStableIds(true);
        addItem(0, new ItemData(ItemData.Type.ADD, null, null, null, 0));
        mClickListener = listener;
    }

    public void addItem(int position, ItemData item) {
        mItems.add(position, item);
        notifyDataSetChanged();
    }

    @Override
    public long getItemId(int position) {
        return mItems.get(position).id;
    }

    @Override
    public int getItemViewType(int position) {
        return mItems.get(position).getTypeOrdinal();
    }

    @Override
    public AbsItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemData.Type type = ItemData.Type.values()[viewType];
        View v = LayoutInflater.from(parent.getContext()).inflate(type.layoutId, parent, false);
        switch (type) {
            case ADD:
                return new AddViewHolder(v, mClickListener);
            case ITEM:
                return new ItemViewHolder(v, mClickListener);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(AbsItemViewHolder holder, int position) {
        holder.bind(mItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void removeFromId(long id) {
        for (int i = 0, size = mItems.size(); i < size; i++) {
            if (id == mItems.get(i).id) {
                mItems.remove(i);
                notifyDataSetChanged();
                break;
            }
        }
    }
}