package com.onsemiro.hanpinetree.koreatechrandomfood;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

// 상점 리스트 출력 -> 각 상점의 전체 메뉴 출력 및 선택 가능
//        선택한 메뉴들을 하나로 모아서 메신저 어플리케이션(카카오톡)으로 공유 가능 ( 공유 할 때 마지막 문장으로 주문자의 계좌 추가 )

public class MenuListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menulist);
    }
}
