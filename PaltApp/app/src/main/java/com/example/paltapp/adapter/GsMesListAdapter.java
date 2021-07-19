package com.example.paltapp.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.paltapp.db.Gasto;

public class GsMesListAdapter extends ListAdapter<Gasto, GsMesHolder> {

    public GsMesListAdapter(@NonNull DiffUtil.ItemCallback<Gasto> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public GsMesHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        return GsMesHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull  GsMesHolder holder, int position) {
        Gasto current = getItem(position);
        holder.bind(current.getFecha(), current.getTotal());
    }

    public static class GsMesDiff extends DiffUtil.ItemCallback<Gasto>{

        @Override
        public boolean areItemsTheSame(@NonNull Gasto oldItem, @NonNull  Gasto newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Gasto oldItem, @NonNull  Gasto newItem) {
            return oldItem.getId() == newItem.getId();

        }
    }
}
