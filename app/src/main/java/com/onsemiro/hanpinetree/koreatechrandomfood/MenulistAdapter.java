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

import butterknife.BindView;

public class MenulistAdapter extends RecyclerView.Adapter<MenulistAdapter.ViewHolder> {
    private ArrayList<String> mMenuData = null;
    private Context mContext;
    private ArrayList<String> mSelectedMenu = null;

    MenulistAdapter(ArrayList<String> menulist, Context context){
        mMenuData = menulist;
        mContext = context;
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ConstraintLayout mItem;
        TextView mMenuTextView;
        TextView mMenuCountView;

        public ViewHolder(View itemView) {
            super(itemView);
            mItem = itemView.findViewById(R.id.menulist_item);
            mMenuTextView = itemView.findViewById(R.id.menu_textview);
            mMenuCountView = itemView.findViewById(R.id.menu_count_textview);
            mMenuTextView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.menu_textview :
                    isSelected();
            }
        }

        void isSelected(){
            mItem.setBackgroundColor(Color.rgb(255,153,51));
            String menuName = mMenuTextView.getText().toString();
            mSelectedMenu.add(menuName);
            String menuSelectNumber = mMenuCountView.getText().toString();
            int count = Integer.parseInt(menuSelectNumber);
            count++;
            menuSelectNumber = Integer.toString(count);
            mMenuCountView.setText(menuSelectNumber);
        }
    }

    @Override
    public MenulistAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

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
