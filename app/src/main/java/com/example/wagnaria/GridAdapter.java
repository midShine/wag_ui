package com.example.wagnaria;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.GridViewHolder> {

    private ArrayList<FoodDataset> listFood;
    private OnListClick onListClicks;

    private GridAdapter(ArrayList<FoodDataset> list){
        this.listFood = list;
    }

    private void setOnListClick(OnListClick onListClick){
        this.onListClicks = onListClick;
    }

    @NonNull
    @Override
    public GridAdapter.GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_grid_item, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final GridAdapter.GridViewHolder holder, int position) {

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onListClicks.onItemClick(listFood.get(holder.getAdapterPosition()));
            }
        });

        Glide.with(holder.itemView.getContext())
                .load(getResImg(listFood.get(position).getPhoto(),R.drawable.class))
                .apply(new RequestOptions().override(250,250))
                .into(holder.imgFood);
        holder.txtPrice.setText(listFood.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return listFood.size();
    }

    public static int getResImg(String res, Class<?> c){
        try{
            Field id = c.getDeclaredField(res);
            return id.getInt(id);
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    public class GridViewHolder extends RecyclerView.ViewHolder{

        ImageView imgFood;
        TextView txtPrice;
        public GridViewHolder(@NonNull View itemView){
            super(itemView);
            txtPrice = itemView.findViewById(R.id.txt_price);
            imgFood = itemView.findViewById(R.id.list_item);
        }
    }

    public interface OnListClick{
        void onItemClick(FoodDataset foodDataset);
    }
}
