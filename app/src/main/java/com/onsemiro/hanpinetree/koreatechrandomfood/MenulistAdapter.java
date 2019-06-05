package com.onsemiro.hanpinetree.koreatechrandomfood;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MenulistAdapter extends RecyclerView.Adapter<MenulistAdapter.ViewHolder> {
    private ArrayList<String> mMenuData = null;
    private Context mContext;
    private ArrayList<String> mSelectedMenu = null;
    private RecyclerViewItemSelect mRecyclerViewItemSelect;

    MenulistAdapter(ArrayList<String> menulist, Context context) {
        mSelectedMenu = new ArrayList<>();
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

        public ViewHolder(View itemView) {
            super(itemView);
            mItemConstraintLayout = itemView.findViewById(R.id.menulist_item);
            mMenuTextView = itemView.findViewById(R.id.menu_textview);
            mMenuCountView = itemView.findViewById(R.id.menu_count_textview);
            mMenuTextView.setOnClickListener(this);
            mItemConstraintLayout.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
                    isSelected();
        }

        void isSelected() {
            mItemConstraintLayout.setBackgroundColor(Color.rgb(255, 153, 51));
            String menuName = mMenuTextView.getText().toString();
            mSelectedMenu.add(menuName);
            String menuSelectNumber = mMenuCountView.getText().toString();
            int count = Integer.parseInt(menuSelectNumber);
            count++;
            menuSelectNumber = Integer.toString(count);
            mMenuCountView.setText(menuSelectNumber);
            if (mRecyclerViewItemSelect != null)
                mRecyclerViewItemSelect.onClickedItem(menuName, count);
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
