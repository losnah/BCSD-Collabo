package com.onsemiro.hanpinetree.koreatechrandomfood;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static java.sql.DriverManager.println;

public class RandomActivity extends AppCompatActivity implements View.OnClickListener{
    private Context mContext;


    private ImageView mImage_front; // front : koreatech badge
    private ImageView mImage_back;  // back : food menu
    private int randomnumber=0;
    private Animation mSlotAnim;
    /*슬롯 애니메이션 관련 변수*/
    @BindView(R.id.activity_main_random_textview) TextView mRandomTextview;
    @BindView(R.id.button) Button button1;
    @BindView(R.id.button2) Button button2;
    @BindView(R.id.button3) Button button3;
    @BindView(R.id.button4) Button button4;
    @BindView(R.id.button5) Button button5;
    @BindView(R.id.button6) Button button6;
    @BindView(R.id.button7) Button button7;
    @BindView(R.id.button8) Button button8;
    @BindView(R.id.button9) Button button9;


    private ScaleAnimation sato0 = new ScaleAnimation(1, 0, 1, 1, Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, 0.5f);
    private ScaleAnimation sato1 = new ScaleAnimation(0, 1, 1, 1, Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, 0.5f);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);
        ButterKnife.bind(this);
        initView();


    }
    private void initView() {

        mSlotAnim = AnimationUtils.loadAnimation(this, R.anim.slot);
        mContext = getApplicationContext();
        //mImage_front = (ImageView)findViewById(R.id.imageview_front_card_00);
        //mImage_front.setOnClickListener(this);
        //mImage_back = (ImageView)findViewById(R.id.imaggeview_back_card_00);
        //mImage_back.setOnClickListener(this);
       // showImageFront();
        //sato0.setDuration(500);
        //sato1.setDuration(500);
/*
        sato0.setAnimationListener(new Animation.AnimationListener(){

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if(mImage_front.getVisibility() == View.VISIBLE){
                    mImage_front.setAnimation(null);
                    showImageBack();
                    mImage_back.startAnimation(sato1);
                }
                else{
                    mImage_back.setAnimation(null);
                    showImageFront();
                    mImage_front.startAnimation(sato1);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        */
    }

    @OnClick(R.id.button)
    void onClinck(){
        SQLiteDatabase database = openOrCreateDatabase("store.db",MODE_PRIVATE,null);
        String sql = "select _id, name, menu, price, phone from store";
        Cursor cursor = database.rawQuery(sql, null);
        int namenumber = (randomnumber/9)*9;
        int min = namenumber;
        int max = ((randomnumber/9)+1)*9-1;
        int result = (int) (Math.random()*(max-min+1))+min;
        for(int i = 0; i < result; i++){
            cursor.moveToNext();
        }
        Log.i("min",Integer.toString(min));
        Log.i("max",Integer.toString(max));
        Log.i("result",Integer.toString(result));
        String foodname = cursor.getString(2);
        int foodprice = cursor.getInt(3);
        button1.setText(foodname+"\n"+Integer.toString(foodprice)+"원");

    }
    @OnClick(R.id.button2)
    void onClinck2(){
        SQLiteDatabase database = openOrCreateDatabase("store.db",MODE_PRIVATE,null);
        String sql = "select _id, name, menu, price, phone from store";
        Cursor cursor = database.rawQuery(sql, null);
        int namenumber = (randomnumber/9)*9;
        int min = namenumber;
        int max = ((randomnumber/9)+1)*9-1;
        int result = (int) (Math.random()*(max-min+1))+min;
        for(int i = 0; i < result; i++){
            cursor.moveToNext();
        }
        Log.i("min",Integer.toString(min));
        Log.i("max",Integer.toString(max));
        Log.i("result",Integer.toString(result));
        String foodname = cursor.getString(2);
        int foodprice = cursor.getInt(3);
        button2.setText(foodname+"\n"+Integer.toString(foodprice)+"원");
    }
    @OnClick(R.id.button3)
    void onClinck3(){
        SQLiteDatabase database = openOrCreateDatabase("store.db",MODE_PRIVATE,null);
        String sql = "select _id, name, menu, price, phone from store";
        Cursor cursor = database.rawQuery(sql, null);
        int namenumber = (randomnumber/9)*9;
        int min = namenumber;
        int max = ((randomnumber/9)+1)*9-1;
        int result = (int) (Math.random()*(max-min+1))+min;
        for(int i = 0; i < result; i++){
            cursor.moveToNext();
        }
        Log.i("min",Integer.toString(min));
        Log.i("max",Integer.toString(max));
        Log.i("result",Integer.toString(result));
        String foodname = cursor.getString(2);
        int foodprice = cursor.getInt(3);
        button3.setText(foodname+"\n"+Integer.toString(foodprice)+"원");
    }
    @OnClick(R.id.button4)
    void onClinck4(){
        SQLiteDatabase database = openOrCreateDatabase("store.db",MODE_PRIVATE,null);
        String sql = "select _id, name, menu, price, phone from store";
        Cursor cursor = database.rawQuery(sql, null);
        int namenumber = (randomnumber/9)*9;
        int min = namenumber;
        int max = ((randomnumber/9)+1)*9-1;
        int result = (int) (Math.random()*(max-min+1))+min;
        for(int i = 0; i < result; i++){
            cursor.moveToNext();
        }
        Log.i("min",Integer.toString(min));
        Log.i("max",Integer.toString(max));
        Log.i("result",Integer.toString(result));
        String foodname = cursor.getString(2);
        int foodprice = cursor.getInt(3);
        button4.setText(foodname+"\n"+Integer.toString(foodprice)+"원");
    }
    @OnClick(R.id.button5)
    void onClinck5(){
        SQLiteDatabase database = openOrCreateDatabase("store.db",MODE_PRIVATE,null);
        String sql = "select _id, name, menu, price, phone from store";
        Cursor cursor = database.rawQuery(sql, null);
        int namenumber = (randomnumber/9)*9;
        int min = namenumber;
        int max = ((randomnumber/9)+1)*9-1;
        int result = (int) (Math.random()*(max-min+1))+min;
        for(int i = 0; i < result; i++){
            cursor.moveToNext();
        }
        Log.i("min",Integer.toString(min));
        Log.i("max",Integer.toString(max));
        Log.i("result",Integer.toString(result));
        String foodname = cursor.getString(2);
        int foodprice = cursor.getInt(3);
        button5.setText(foodname+"\n"+Integer.toString(foodprice)+"원");
    }
    @OnClick(R.id.button6)
    void onClinck6(){
        SQLiteDatabase database = openOrCreateDatabase("store.db",MODE_PRIVATE,null);
        String sql = "select _id, name, menu, price, phone from store";
        Cursor cursor = database.rawQuery(sql, null);
        int namenumber = (randomnumber/9)*9;
        int min = namenumber;
        int max = ((randomnumber/9)+1)*9-1;
        int result = (int) (Math.random()*(max-min+1))+min;
        for(int i = 0; i < result; i++){
            cursor.moveToNext();
        }
        Log.i("min",Integer.toString(min));
        Log.i("max",Integer.toString(max));
        Log.i("result",Integer.toString(result));
        String foodname = cursor.getString(2);
        int foodprice = cursor.getInt(3);
        button6.setText(foodname+"\n"+Integer.toString(foodprice)+"원");
    }
    @OnClick(R.id.button7)
    void onClinck7(){
        SQLiteDatabase database = openOrCreateDatabase("store.db",MODE_PRIVATE,null);
        String sql = "select _id, name, menu, price, phone from store";
        Cursor cursor = database.rawQuery(sql, null);
        int namenumber = (randomnumber/9)*9;
        int min = namenumber;
        int max = ((randomnumber/9)+1)*9-1;
        int result = (int) (Math.random()*(max-min+1))+min;
        for(int i = 0; i < result; i++){
            cursor.moveToNext();
        }
        Log.i("min",Integer.toString(min));
        Log.i("max",Integer.toString(max));
        Log.i("result",Integer.toString(result));
        String foodname = cursor.getString(2);
        int foodprice = cursor.getInt(3);
        button7.setText(foodname+"\n"+Integer.toString(foodprice)+"원");
    }
    @OnClick(R.id.button8)
    void onClinck8(){
        SQLiteDatabase database = openOrCreateDatabase("store.db",MODE_PRIVATE,null);
        String sql = "select _id, name, menu, price, phone from store";
        Cursor cursor = database.rawQuery(sql, null);
        int namenumber = (randomnumber/9)*9;
        int min = namenumber;
        int max = ((randomnumber/9)+1)*9-1;
        int result = (int) (Math.random()*(max-min+1))+min;
        for(int i = 0; i < result; i++){
            cursor.moveToNext();
        }
        Log.i("min",Integer.toString(min));
        Log.i("max",Integer.toString(max));
        Log.i("result",Integer.toString(result));
        String foodname = cursor.getString(2);
        int foodprice = cursor.getInt(3);
        button8.setText(foodname+"\n"+Integer.toString(foodprice)+"원");
    }
    @OnClick(R.id.button9)
    void onClinck9(){
        SQLiteDatabase database = openOrCreateDatabase("store.db",MODE_PRIVATE,null);
        String sql = "select _id, name, menu, price, phone from store";
        Cursor cursor = database.rawQuery(sql, null);
        int namenumber = (randomnumber/9)*9;
        int min = namenumber;
        int max = ((randomnumber/9)+1)*9-1;
        int result = (int) (Math.random()*(max-min+1))+min;
        for(int i = 0; i < result; i++){
            cursor.moveToNext();
        }
        Log.i("min",Integer.toString(min));
        Log.i("max",Integer.toString(max));
        Log.i("result",Integer.toString(result));
        String foodname = cursor.getString(2);
        int foodprice = cursor.getInt(3);
        button9.setText(foodname+"\n"+Integer.toString(foodprice)+"원");
    }


    @OnClick(R.id.activitiy_main_slotbar_imageview)
    void onSlotClick() {
        SQLiteDatabase database = openOrCreateDatabase("store.db",MODE_PRIVATE,null);
        String sql = "select _id, name, menu, price, phone from store";
        Cursor cursor = database.rawQuery(sql, null);
        String name = "0";
        Random random = new Random();
        randomnumber = random.nextInt(199);
        for(int i = 0; i < randomnumber; i++){
            cursor.moveToNext();
            }
        name = cursor.getString(1);

        mRandomTextview.setText(name);
        cursor.close();
        Log.i("randomnumber",Integer.toString(randomnumber));
        //mRandomTextview.startAnimation(mSlotAnim);

    }

    private void showImageFront() {
        mImage_front.setVisibility(View.VISIBLE);
        mImage_back.setVisibility(View.INVISIBLE);
    }

    private void showImageBack() {
        mImage_front.setVisibility(View.INVISIBLE);
        mImage_back.setVisibility(View.VISIBLE);
    }
    @Override
    public void onClick(View v) {
        if(mImage_front.getVisibility()==View.VISIBLE){
            mImage_front.startAnimation(sato0);
        }
        else{
            mImage_back.startAnimation(sato0);
        }
    }
}
