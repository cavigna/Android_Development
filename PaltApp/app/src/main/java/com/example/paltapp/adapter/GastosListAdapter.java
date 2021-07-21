package com.example.paltapp.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.paltapp.db.Gasto;
import com.example.paltapp.holder.GsRecyclerViewHolder;


public class GastosListAdapter extends ListAdapter<Gasto, GsRecyclerViewHolder> {


    public GastosListAdapter(@NonNull  DiffUtil.ItemCallback<Gasto> diffCallback) {
        super(diffCallback);
    }

    @NonNull

    @Override
    public GsRecyclerViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        return GsRecyclerViewHolder.create(parent);

    }

    @Override
    public void onBindViewHolder(@NonNull GsRecyclerViewHolder holder, int position) {
        Gasto current = getItem(position);
        holder.bindCategoria(current.getNombre());
        holder.bindMonto(current.getMonto());
        holder.bindImage(current.getCategoria());
    }

    public static class GsDiff extends DiffUtil.ItemCallback<Gasto>{

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



