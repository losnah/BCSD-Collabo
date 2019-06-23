package com.onsemiro.hanpinetree.koreatechrandomfood;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button randomButton;
    private Button RestaurantButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        randomButton = (Button)findViewById(R.id.random);
        randomButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),RandomActivity.class);
                startActivity(intent);

            }
        }) ;
        RestaurantButton = (Button)findViewById(R.id.restaurantButton);
        RestaurantButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),RestaurantActivity.class);
                startActivity(intent);

            }
        }) ;

    }


}