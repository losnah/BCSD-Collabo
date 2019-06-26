package com.onsemiro.hanpinetree.koreatechrandomfood;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

// 상점 리스트 출력 -> 각 상점의 전체 메뉴 출력 및 선택 가능
//        선택한 메뉴들을 하나로 모아서 메신저 어플리케이션(카카오톡)으로 공유 가능 ( 공유 할 때 마지막 문장으로 주문자의 계좌 추가 )

public class MenuListActivity extends AppCompatActivity implements View.OnClickListener, RecyclerViewItemSelect{
    private RecyclerView mRecyclerView;
    private MenulistAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Button mCallMenuButton;
    private Button mShareMenuButton;
    private String mRestaurantName;

    private ArrayList<String> mSelectedMenulist;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menulist);

        Intent intent = getIntent();
        mRestaurantName = intent.getStringExtra("restaurant");

        initView();
        upload();
    }

    private void upload() {
        SQLiteDatabase database = openOrCreateDatabase("store.db", MODE_PRIVATE, null);
        String sql = "select menu, price, phone from store where name = '" + mRestaurantName + "'";
        Cursor cursor = database.rawQuery(sql, null);

        ArrayList<String> menulist = new ArrayList<>();
        while(cursor.moveToNext()){
            menulist.add(cursor.getString(0));
            Log.i("menu", cursor.getString(0));
        }

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
            case R.id.menulist_sharing_button :
        }
    }

    @Override
    public void onClickedItem(String itemName, int count) {
        Toast.makeText(this, "아이템 : "+itemName+"클릭 횟수 : "+count, Toast.LENGTH_SHORT).show();
    }
}
