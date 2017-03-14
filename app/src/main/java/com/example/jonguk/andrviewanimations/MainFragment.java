package com.example.jonguk.andrviewanimations;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jonguk.andrviewanimations.list.ItemAdapter;
import com.example.jonguk.andrviewanimations.list.ItemData;
import com.example.jonguk.andrviewanimations.list.OnAnimItemClickListener;

import java.util.LinkedList;

/**
 * Created by Jonguk on 2017. 3. 12..
 */
public class MainFragment extends Fragment implements OnAnimItemClickListener {

    public static final int KEY_ITEM_ID = 1234;

    private CheckedView mObjectView;
    private TextView mPublicInterpolatorView;
    private TextView mPublicDurationView;
    private RecyclerView mRecyclerView;
    private Button mPlayView;

    private ItemAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mObjectView = (CheckedView) view.findViewById(R.id.object_view);
        mPublicInterpolatorView = (TextView) view.findViewById(R.id.public_interpolator);
        mPublicDurationView = (TextView) view.findViewById(R.id.public_duration);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new ItemAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onClickRemove(long id) {
        mAdapter.removeFromId(id);
    }

    @Override
    public void onClickAdd(int insertPosition) {
        mAdapter.addItem(insertPosition, new ItemData(ItemData.Type.ITEM, "name", new LinkedList<Float>(), new AccelerateInterpolator(), 300));
    }

    @Override
    public void onClickItem(long id) {
        Toast.makeText(getContext(), "click id : " + id, Toast.LENGTH_SHORT).show();
    }
}
