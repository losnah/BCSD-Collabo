package com.onsemiro.hanpinetree.koreatechrandomfood;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class RestaurantlistAdapter extends RecyclerView.Adapter<RestaurantlistAdapter.ItemViewHolder>{
    private ArrayList<Data> listData = new ArrayList<>();

    @NonNull
    @Override

    public RestaurantlistAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_name,parent,false);
        return new ItemViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.onBind(listData.get(position));
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    void addItem(Data data){
        listData.add(data);
    }


    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView restaurant_name;
        private Data data;

        ItemViewHolder(View itemView) {
            super(itemView);

            restaurant_name = itemView.findViewById(R.id.restaurant_name);
        }

        void onBind(Data data) {
            this.data = data;
            restaurant_name.setText(data.getTitle());
            restaurant_name.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            Context context = v.getContext();
            switch (v.getId()){
                case R.id.restaurant_name:
                    Toast.makeText(context,data.getTitle(),Toast.LENGTH_SHORT).show();
                    //Intent intent = new Intent(v.getContext(),MenuActivity.class);
                    break;
            }
        }
    }
}
