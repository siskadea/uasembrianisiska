package com.siska.katalogmovie.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.siska.katalogmovie.R;
import com.siska.katalogmovie.mvp.model.search.ResultsItem;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchViewHolder> {

    private List<ResultsItem> list = new ArrayList<>();

    public SearchAdapter() {
    }

    public void clearAll() {
        list.clear();
        notifyDataSetChanged();
    }

    public void replaceAll(List<ResultsItem> items) {
        list.clear();
        list = items;
        notifyDataSetChanged();
    }

    public void updateData(List<ResultsItem> items) {
        list.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SearchViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.activity_main_item, parent, false
                )
        );
    }

    @Override
    public void onBindViewHolder(SearchViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}