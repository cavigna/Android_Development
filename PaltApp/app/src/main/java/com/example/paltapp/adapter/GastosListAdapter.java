package com.example.paltapp.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.paltapp.db.Gasto;


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
        holder.bindCategoria(current.getCategoria());
        holder.bindMonto(current.getMonto());
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



//package com.example.paltapp.adapter;
//
//        import android.content.Context;
//        import android.view.LayoutInflater;
//        import android.view.View;
//        import android.view.ViewGroup;
//        import android.widget.TextView;
//
//        import androidx.annotation.NonNull;
//
//        import androidx.lifecycle.LiveData;
//
//        import androidx.recyclerview.widget.RecyclerView;
//
//        import com.example.paltapp.R;
//        import com.example.paltapp.db.Gasto;
//
//        import java.util.List;
//        import java.util.Objects;
//
//
//public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
//    private Context c;
//    private List<Gasto> gastos;
//    private LiveData<List<Gasto>> liveDataGasto;
//
//    public RecyclerAdapter(Context c) {
//        this.c = c;
//
//    }
//
//    public void setGastos(List<Gasto> gastos) {
//        this.gastos = gastos;
//        notifyDataSetChanged();
//    }
//
//    public void setLiveDataGasto(LiveData<List<Gasto>> liveDataGasto) {
//        this.liveDataGasto = liveDataGasto;
//    }
//
//    public class MyViewHolder extends RecyclerView.ViewHolder {
//        TextView textView_categoria, textView_monto;
//
//        public MyViewHolder(@NonNull  View itemView) {
//            super(itemView);
//            textView_categoria = itemView.findViewById(R.id.textView_categoria_list);
//            textView_monto = itemView.findViewById(R.id.textView_monto_item);
//        }
//    }
//
//    @NonNull
//    @Override
//    public RecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(
//                R.layout.row_item, parent, false);
//        return new MyViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull  RecyclerAdapter.MyViewHolder holder, int position) {
//        holder.textView_categoria.setText((CharSequence) this.liveDataGasto.getValue().get(position));
//
//        //holder.textView_categoria.setText(this.gastos.get(position).getCategoria());
//
//        //Gasto g = gastos.get(position);
//        //holder.textView_categoria.setText(g.getCategoria());
//        //holder.textView_monto.setText(Double.toString(gasto.getMonto()));
//    }
//
//    @Override
//    public int getItemCount() {
//        //return this.gastos.size();
//        return 3;
//        //return gastos.size();
//        //return Objects.requireNonNull(gastos.getValue()).size();
//    }
//
//
//}
//
