package com.onsemiro.hanpinetree.koreatechrandomfood;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class RestaurantActivity extends AppCompatActivity {
    private RecyclerAdapter adapter;
    private ArrayList<String> restaurantname = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        init();
        setRestaurantName();


    }
    private void init(){
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);
    }
    private void setRestaurantName(){
            restaurantname.add("한솥");
            restaurantname.add("봉구스");
            restaurantname.add("즐겨찾기");
            restaurantname.add("고릴라밥");
            restaurantname.add("맘스터치");
            restaurantname.add("네네치킨");
            restaurantname.add("킴스돈");
            restaurantname.add("옛날치킨");
            restaurantname.add("홉스");
            restaurantname.add("속없는돼지");
            restaurantname.add("박여사네야식");
            restaurantname.add("열날개");
            restaurantname.add("미친짬뽕");
            restaurantname.add("덕금");
            restaurantname.add("교촌치킨");
            restaurantname.add("마시내탕수육");
            restaurantname.add("태선족발");
            restaurantname.add("거성한식뷔페");
            restaurantname.add("쉐프통닭");
            restaurantname.add("마슬랜");
            restaurantname.add("써니숯불도시락");
            restaurantname.add("티바");
            restaurantname.add("맥시카나");
            for(int i=0;i<restaurantname.size();i++){
                Data data = new Data();
                data.setTitle(restaurantname.get(i));
                adapter.addItem(data);
            }
            adapter.notifyDataSetChanged();

    }
}
