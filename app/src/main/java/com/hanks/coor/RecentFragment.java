package com.hanks.coor;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by kiya on 2015/11/13.
 */
public class RecentFragment extends Fragment {
    private MyAdapter mAdapter;
    private ArrayList dataList = new ArrayList();

    public static RecentFragment newInstance() {
        Bundle args = new Bundle();
        RecentFragment fragment = new RecentFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_speed, container, false);
        return view;
    }

    @Override public void onViewCreated(View view, Bundle savedInstanceState) {
        mAdapter = new MyAdapter();
        RecyclerView recyclerView = (RecyclerView) getView().findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(mAdapter);
    }

    class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

        @Override public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_recent, parent, false);
            return new MyViewHolder(view);
        }

        @Override public void onBindViewHolder(MyViewHolder holder, int position) {

        }

        @Override public int getItemCount() {
            return 100;
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
