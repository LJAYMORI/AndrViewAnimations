package com.example.jonguk.andrviewanimations;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Jonguk on 2017. 3. 12..
 */
public class MainFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final CheckedView bounceView = (CheckedView) view.findViewById(R.id.bounce_view);
        bounceView.setOnViewCheckedChangeListener(new CheckedView.OnViewCheckedChangeListener() {
            @Override
            public void onChecked(boolean isChecked) {
                if (isChecked) {
                    AnimatorUtils.animateBounce(bounceView);
                }
            }
        });

    }
}
