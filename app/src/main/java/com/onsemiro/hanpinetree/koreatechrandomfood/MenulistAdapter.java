package com.onsemiro.hanpinetree.koreatechrandomfood;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MenulistAdapter extends RecyclerView.Adapter<MenulistAdapter.ViewHolder> {
    private ArrayList<String> mMenuData = null;
    private RecyclerViewItemSelect mRecyclerViewItemSelect;
    private Context mContext;

    MenulistAdapter(ArrayList<String> menulist, Context context) {
        mMenuData = menulist;
        mContext = context;
    }

    public void setOnRecyclerViewItemSelected(RecyclerViewItemSelect recyclerViewItemSelected) {
        this.mRecyclerViewItemSelect = recyclerViewItemSelected;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ConstraintLayout mItemConstraintLayout;
        TextView mMenuTextView;
        TextView mMenuCountView;
        Button mIncreaseCount;
        Button mDecreaseCount;

        public ViewHolder(View itemView) {
            super(itemView);
            mItemConstraintLayout = itemView.findViewById(R.id.menulist_item);
            mMenuTextView = itemView.findViewById(R.id.menu_textview);
            mMenuCountView = itemView.findViewById(R.id.menu_count_textview);
            mIncreaseCount = itemView.findViewById(R.id.menulist_add_button);
            mIncreaseCount.setOnClickListener(this);
            mDecreaseCount = itemView.findViewById(R.id.menulist_subtract_button);
            mDecreaseCount.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            String menuName = mMenuTextView.getText().toString();
            int menuCountNumber = Integer.parseInt(mMenuCountView.getText().toString());

            switch(v.getId()){
                case R.id.menulist_add_button :
                    setItem(menuName, ++menuCountNumber);
                    break;
                case R.id.menulist_subtract_button :
                    if(menuCountNumber != 0) setItem(menuName, --menuCountNumber);
                    break;
            }
        }

        void setItem(String menuName, int countNumber) {
            if(countNumber > 0)
                mItemConstraintLayout.setBackgroundColor(Color.rgb(255, 153, 51));
            else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    mItemConstraintLayout.setBackground(ContextCompat.getDrawable(mContext, R.drawable.all_edge_orange));
                } else {
                    mItemConstraintLayout.setBackgroundDrawable(ContextCompat.getDrawable(mContext, R.drawable.all_edge_orange));
                }
            }
            mMenuCountView.setText(Integer.toString(countNumber));
        }
    }

    @Override
    public MenulistAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.menulist_recyclerview_item, viewGroup, false);
        MenulistAdapter.ViewHolder vh = new MenulistAdapter.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MenulistAdapter.ViewHolder viewHolder, int position) {
        String menu = mMenuData.get(position);
        viewHolder.mMenuTextView.setText(menu);
    }

    @Override
    public int getItemCount() {
        return mMenuData.size();
    }
}
