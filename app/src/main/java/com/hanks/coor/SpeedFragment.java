package com.hanks.coor;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by kiya on 2015/11/13.
 */
public class SpeedFragment extends Fragment {
    public static SpeedFragment newInstance() {
        Bundle args = new Bundle();
        SpeedFragment fragment = new SpeedFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_speed, container, false);
        return view;
    }

}
