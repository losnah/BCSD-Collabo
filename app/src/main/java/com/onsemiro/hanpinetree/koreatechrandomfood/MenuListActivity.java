package com.onsemiro.hanpinetree.koreatechrandomfood;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MenuListActivity extends AppCompatActivity implements View.OnClickListener, RecyclerViewItemSelect{
    private RecyclerView mRecyclerView;
    private MenulistAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Button mCallMenuButton;
    private Button mShareMenuButton;
    private String mRestaurantName;
    private String mRestaurantPhone;

    private Map<String, Integer> mSelectedMenulist;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menulist);

        Intent intent = getIntent();
        mRestaurantName = intent.getStringExtra("restaurant");
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(mRestaurantName);
        }

        initView();
        upload();
    }

    private void upload() {
        SQLiteDatabase database = openOrCreateDatabase("store.db", MODE_PRIVATE, null);
        String sql = "select menu, price, phone from store where name = '" + mRestaurantName + "'";
        Cursor cursor = database.rawQuery(sql, null);

        ArrayList<String> menulist = new ArrayList<>();
        while(cursor.moveToNext()){ // moveToNext는 -1부터 시작된다.
            mRestaurantPhone = cursor.getString(2);
            menulist.add(cursor.getString(0));
        }

        cursor.close();

        mAdapter = new MenulistAdapter(menulist, this);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnRecyclerViewItemSelected(this);
    }

    private void initView() {
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerview_menulist);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mCallMenuButton = (Button)findViewById(R.id.menulist_call_button);
        mShareMenuButton = (Button)findViewById(R.id.menulist_sharing_button);
        mCallMenuButton.setOnClickListener(this);
        mShareMenuButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.menulist_call_button :
                callMenu();
                break;
            case R.id.menulist_sharing_button :
                shareMenu();
                break;
        }
    }

    private void shareMenu() {
    }

    private void callMenu() {
    }

    @Override
    public void onClickedItem(String itemName, int count) {
        mSelectedMenulist = new HashMap<>();
        Toast.makeText(this, "아이템 : "+itemName+"클릭 횟수 : "+count, Toast.LENGTH_SHORT).show();
        mSelectedMenulist.put(itemName, count);
    }
}
