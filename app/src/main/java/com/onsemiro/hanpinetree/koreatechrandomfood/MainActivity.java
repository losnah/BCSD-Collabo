package com.onsemiro.hanpinetree.koreatechrandomfood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.random) Button mRandomButton;
    @BindView(R.id.restaurantButton) Button mRestaurantButton;
    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }



    @OnClick(R.id.random)   // move to RandomActivity.class
    void onRandomClick(){
        mIntent = new Intent(getApplication(), RandomActivity.class);
        startActivity(mIntent);
    }

    @OnClick(R.id.restaurantButton) // move to RestaurantActivity.class
    void onRestaurantClick(){
        mIntent = new Intent(getApplicationContext(), RestaurantActivity.class);
        startActivity(mIntent);
    }
    @OnClick(R.id.activity_main_databaseManager_button)
    void onStartDBManager(){
        mIntent = new Intent(getApplicationContext(), DataBaseManager.class);
        startActivity(mIntent);
    }
}