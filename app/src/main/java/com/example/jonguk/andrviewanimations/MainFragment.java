package com.example.jonguk.andrviewanimations;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jonguk.andrviewanimations.dialog.DurationDialog;
import com.example.jonguk.andrviewanimations.dialog.InterpolatorDialog;
import com.example.jonguk.andrviewanimations.list.ItemAdapter;
import com.example.jonguk.andrviewanimations.list.ItemData;
import com.example.jonguk.andrviewanimations.list.OnAnimItemClickListener;

import java.util.LinkedList;

/**
 * Created by Jonguk on 2017. 3. 12..
 */
public class MainFragment extends Fragment implements OnAnimItemClickListener {

    private CheckedView mObjectView;
    private TextView mPublicInterpolatorView;
    private TextView mPublicDurationView;
    private RecyclerView mRecyclerView;
    private Button mPlayView;

    private ItemAdapter mAdapter;

    private InterpolatorDialog mInterpolatorDialog;
    private DurationDialog mDurationDialog;

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

        // Public interpolator dialog
        mInterpolatorDialog = new InterpolatorDialog(getContext(), type ->
                mPublicInterpolatorView.setText(
                        Html.fromHtml(String.format("Interpolator :<br><b>%s</b>", type.getName()))));
        mPublicInterpolatorView.setOnClickListener(v -> mInterpolatorDialog.show());

        // Public duration dialog
        mDurationDialog = new DurationDialog(getContext(), value ->
                mPublicDurationView.setText(
                        Html.fromHtml(String.format("Duration :<br><b>%s ms</b>", value))));
        mPublicDurationView.setOnClickListener(v -> mDurationDialog.show());

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
        mAdapter.addItem(insertPosition, new ItemData(ItemData.Type.ITEM, "name", new LinkedList<>(), new AccelerateInterpolator(), 300));
    }

    @Override
    public void onClickItem(long id) {
        Toast.makeText(getContext(), "click id : " + id, Toast.LENGTH_SHORT).show();
    }
}
