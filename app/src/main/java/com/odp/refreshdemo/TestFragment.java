package com.odp.refreshdemo;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @author odp
 **/
public class TestFragment extends Fragment {
    private SmartRefreshLayout smartRefreshLayout;
    private RecyclerView recyclerView;
    private RecycleViewAdapter recycleViewAdapter;
    private List<String> stringList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragment_test, container, false);
        init(view);
        return view.getRootView();
    }

    private void init(View view) {
        smartRefreshLayout = view.findViewById(R.id.simple_refresh);
        smartRefreshLayout.setRefreshHeader(new ClassicsHeader(view.getContext()));
        smartRefreshLayout.setRefreshFooter(new ClassicsFooter(view.getContext()));
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                List<String> insertStrs = new ArrayList<>();
                insertStrs.add("Insert Data");
                recycleViewAdapter.insertData(insertStrs);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        smartRefreshLayout.finishRefresh();
                        recycleViewAdapter.notifyDataSetChanged();
                    }
                }, 1000);
            }
        });
        smartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                List<String> strs = new ArrayList<>();
                strs.add("Load Data");
                recycleViewAdapter.updateData(strs);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        smartRefreshLayout.finishLoadMore();
                        recycleViewAdapter.notifyDataSetChanged();
                        if (recycleViewAdapter.getItemCount() >= 20)
                            smartRefreshLayout.finishLoadMoreWithNoMoreData();
                    }
                }, 1000);
            }
        });
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycleViewAdapter = new RecycleViewAdapter();
        recyclerView.setAdapter(recycleViewAdapter);

        initData();
    }


    private void initData() {
        for (int i = 0; i < 10; i++) {
            stringList.add(String.format("I am  %s  data", i));
        }
        recycleViewAdapter.updateData(stringList);
    }
}
