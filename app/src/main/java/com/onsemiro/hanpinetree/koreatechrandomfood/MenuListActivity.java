package com.onsemiro.hanpinetree.koreatechrandomfood;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import java.util.ArrayList;

// 상점 리스트 출력 -> 각 상점의 전체 메뉴 출력 및 선택 가능
//        선택한 메뉴들을 하나로 모아서 메신저 어플리케이션(카카오톡)으로 공유 가능 ( 공유 할 때 마지막 문장으로 주문자의 계좌 추가 )

public class MenuListActivity extends AppCompatActivity implements View.OnClickListener, RecyclerViewItemSelect{
    private RecyclerView mRecyclerView;
    private MenulistAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    // floating button
    private Animation mFloatingOpen, mFloatingClose;
    private Boolean isFloatingOpen = false;
    private FloatingActionButton mBaseButton, mCallButton, mShareButton;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menulist);

        initView();
        upload();
    }

    private void upload() {
        ArrayList<String> hansot = new ArrayList<>();
        hansot.add("동백");
        hansot.add("도련님");
        hansot.add("돈가스도련님");
        hansot.add("빅치킨마요");
        hansot.add("돈가스카레");
        hansot.add("한솥철판볶음밥");
        hansot.add("국화");
        hansot.add("돈가스덮밥");
        hansot.add("치킨제육");

        mAdapter = new MenulistAdapter(hansot, this);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnRecyclerViewItemSelected(this);
    }

    private void initView() {
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerview_menulist);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mFloatingOpen = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.floating_open);
        mFloatingClose = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.floation_close);

//        mBaseButton = (FloatingActionButton)findViewById(R.id.menulist_floating_base);
//        mCallButton = (FloatingActionButton)findViewById(R.id.menulist_floating_call);
//        mShareButton = (FloatingActionButton)findViewById(R.id.menulist_floating_share);

        mBaseButton.setOnClickListener(this);
        mCallButton.setOnClickListener(this);
        mShareButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
//            case R.id.menulist_floating_base:
//                anim();
//                Toast.makeText(this, "Floating Action Button", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.menulist_floating_call:
//                anim();
//                Toast.makeText(this, "Call", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.menulist_floating_share:
//                anim();
//                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
//                break;    // floating button

        }
    }

    private void anim() { // floating button animation method
        if(isFloatingOpen){
            mCallButton.startAnimation(mFloatingClose);
            mShareButton.startAnimation(mFloatingClose);
            mCallButton.setClickable(false);
            mShareButton.setClickable(false);
            isFloatingOpen = false;
        }
        else{
            mCallButton.startAnimation(mFloatingOpen);
            mShareButton.startAnimation(mFloatingOpen);
            mCallButton.setClickable(true);
            mShareButton.setClickable(true);
            isFloatingOpen = true;
        }
    }

    @Override
    public void onClickedItem(String itemName, int count) {
        Toast.makeText(this, "아이템 : "+itemName+"클릭 횟수 : "+count, Toast.LENGTH_SHORT).show();
    }
}
