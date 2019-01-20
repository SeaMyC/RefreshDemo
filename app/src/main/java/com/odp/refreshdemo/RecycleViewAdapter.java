package com.odp.refreshdemo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author odp
 **/
public class RecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<String> datas = new ArrayList<>();

    void updateData(List<String> stringList) {
        if (stringList.size() > 0) {
            datas.addAll(stringList);
            notifyDataSetChanged();
        }
    }

    void insertData(List<String> stringList) {
        if (stringList.size() > 0) {
            for (int i = 0; i < stringList.size(); i++) {
                datas.add(i, stringList.get(i));
                notifyItemInserted(i);
            }
        }
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.fragment_test_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((ViewHolder) viewHolder).bindData(i);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        void bindData(int i) {
            TextView tv = itemView.findViewById(R.id.tv);
            tv.setText(String.valueOf(datas.get(i) + "  " + i));
        }
    }
}
