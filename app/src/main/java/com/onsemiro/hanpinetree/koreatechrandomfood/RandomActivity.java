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

import java.util.ArrayList;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static java.sql.DriverManager.println;

public class RandomActivity extends AppCompatActivity {

    private int randomnumber=0;
    private ButtonState[] buttonStates = new ButtonState[9];
    private ArrayList restaurantname = new ArrayList();

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);
        ButterKnife.bind(this);
        initView();
        restaurantName();
    }

    private void initView() {
        for(int i=0;i<9;i++){
            buttonStates[i] = new ButtonState(false,false);
        }
    }

    @OnClick(R.id.button)
    void onClinck(){
        if(buttonStates[0].getSteop01() == true && buttonStates[0].getSteop02() == false) {
            SQLiteDatabase database = openOrCreateDatabase("store.db", MODE_PRIVATE, null);
            String sql = "select _id, name, menu, price, phone from store";
            Cursor cursor = database.rawQuery(sql, null);
            int namenumber = (randomnumber / 9) * 9;
            int min = namenumber;
            int max = ((randomnumber / 9) + 1) * 9 - 1;
            int result = (int) (Math.random() * (max - min + 1)) + min;
            for (int i = 0; i < result + 1; i++) {
                cursor.moveToNext();
            }
            Log.i("min", Integer.toString(min));
            Log.i("max", Integer.toString(max));
            Log.i("result", Integer.toString(result));
            String foodname = cursor.getString(2);
            int foodprice = cursor.getInt(3);
            button1.setText(foodname + "\n" + Integer.toString(foodprice) + "원");
            buttonStates[0].setStep02(true);
        }
        else if(buttonStates[0].getSteop01() == false && buttonStates[0].getSteop02() == false){
            button1.setText("?");
        }


    }
    @OnClick(R.id.button2)
    void onClinck2(){
        if(buttonStates[1].getSteop01() == true && buttonStates[1].getSteop02() == false) {
            SQLiteDatabase database = openOrCreateDatabase("store.db", MODE_PRIVATE, null);
            String sql = "select _id, name, menu, price, phone from store";
            Cursor cursor = database.rawQuery(sql, null);
            int namenumber = (randomnumber / 9) * 9;
            int min = namenumber;
            int max = ((randomnumber / 9) + 1) * 9 - 1;
            int result = (int) (Math.random() * (max - min + 1)) + min;
            for (int i = 0; i < result + 1; i++) {
                cursor.moveToNext();
            }
            Log.i("min", Integer.toString(min));
            Log.i("max", Integer.toString(max));
            Log.i("result", Integer.toString(result));
            String foodname = cursor.getString(2);
            int foodprice = cursor.getInt(3);
            button2.setText(foodname + "\n" + Integer.toString(foodprice) + "원");
            buttonStates[1].setStep02(true);
        }
        else if(buttonStates[1].getSteop01() == false && buttonStates[1].getSteop02() == false){
            button2.setText("?");
        }
    }
    @OnClick(R.id.button3)
    void onClinck3(){
        if(buttonStates[2].getSteop01() == true && buttonStates[2].getSteop02() == false) {
            SQLiteDatabase database = openOrCreateDatabase("store.db", MODE_PRIVATE, null);
            String sql = "select _id, name, menu, price, phone from store";
            Cursor cursor = database.rawQuery(sql, null);
            int namenumber = (randomnumber / 9) * 9;
            int min = namenumber;
            int max = ((randomnumber / 9) + 1) * 9 - 1;
            int result = (int) (Math.random() * (max - min + 1)) + min;
            for (int i = 0; i < result + 1; i++) {
                cursor.moveToNext();
            }
            Log.i("min", Integer.toString(min));
            Log.i("max", Integer.toString(max));
            Log.i("result", Integer.toString(result));
            String foodname = cursor.getString(2);
            int foodprice = cursor.getInt(3);
            button3.setText(foodname + "\n" + Integer.toString(foodprice) + "원");
            buttonStates[2].setStep02(true);
        }
        else if(buttonStates[2].getSteop01() == false && buttonStates[2].getSteop02() == false)
            button3.setText("?");
    }
    @OnClick(R.id.button4)
    void onClinck4(){
        if(buttonStates[3].getSteop01() == true && buttonStates[3].getSteop02() == false) {
            SQLiteDatabase database = openOrCreateDatabase("store.db", MODE_PRIVATE, null);
            String sql = "select _id, name, menu, price, phone from store";
            Cursor cursor = database.rawQuery(sql, null);
            int namenumber = (randomnumber / 9) * 9;
            int min = namenumber;
            int max = ((randomnumber / 9) + 1) * 9 - 1;
            int result = (int) (Math.random() * (max - min + 1)) + min;
            for (int i = 0; i < result + 1; i++) {
                cursor.moveToNext();
            }
            Log.i("min", Integer.toString(min));
            Log.i("max", Integer.toString(max));
            Log.i("result", Integer.toString(result));
            String foodname = cursor.getString(2);
            int foodprice = cursor.getInt(3);
            button4.setText(foodname + "\n" + Integer.toString(foodprice) + "원");
            buttonStates[3].setStep02(true);
        }
        else if(buttonStates[3].getSteop01() == false && buttonStates[3].getSteop02() == false)
            button4.setText("?");
    }
    @OnClick(R.id.button5)
    void onClinck5(){
        if(buttonStates[4].getSteop01() == true && buttonStates[4].getSteop02() == false) {
            SQLiteDatabase database = openOrCreateDatabase("store.db", MODE_PRIVATE, null);
            String sql = "select _id, name, menu, price, phone from store";
            Cursor cursor = database.rawQuery(sql, null);
            int namenumber = (randomnumber / 9) * 9;
            int min = namenumber;
            int max = ((randomnumber / 9) + 1) * 9 - 1;
            int result = (int) (Math.random() * (max - min + 1)) + min;
            for (int i = 0; i < result + 1; i++) {
                cursor.moveToNext();
            }
            Log.i("min", Integer.toString(min));
            Log.i("max", Integer.toString(max));
            Log.i("result", Integer.toString(result));
            String foodname = cursor.getString(2);
            int foodprice = cursor.getInt(3);
            button5.setText(foodname + "\n" + Integer.toString(foodprice) + "원");
            buttonStates[4].setStep02(true);
        }
        else if(buttonStates[4].getSteop01() == false && buttonStates[1].getSteop02() == false)
            button5.setText("?");
    }
    @OnClick(R.id.button6)
    void onClinck6(){
        if(buttonStates[5].getSteop01() == true && buttonStates[5].getSteop02() == false) {
            SQLiteDatabase database = openOrCreateDatabase("store.db", MODE_PRIVATE, null);
            String sql = "select _id, name, menu, price, phone from store";
            Cursor cursor = database.rawQuery(sql, null);
            int namenumber = (randomnumber / 9) * 9;
            int min = namenumber;
            int max = ((randomnumber / 9) + 1) * 9 - 1;
            int result = (int) (Math.random() * (max - min + 1)) + min;
            for (int i = 0; i < result + 1; i++) {
                cursor.moveToNext();
            }
            Log.i("min", Integer.toString(min));
            Log.i("max", Integer.toString(max));
            Log.i("result", Integer.toString(result));
            String foodname = cursor.getString(2);
            int foodprice = cursor.getInt(3);
            button6.setText(foodname + "\n" + Integer.toString(foodprice) + "원");
            buttonStates[5].setStep02(true);
        }
        else if(buttonStates[5].getSteop01() == true && buttonStates[5].getSteop02() == false)
            button6.setText("?");
    }
    @OnClick(R.id.button7)
    void onClinck7(){
        if(buttonStates[6].getSteop01() == true && buttonStates[6].getSteop02() == false) {
            SQLiteDatabase database = openOrCreateDatabase("store.db", MODE_PRIVATE, null);
            String sql = "select _id, name, menu, price, phone from store";
            Cursor cursor = database.rawQuery(sql, null);
            int namenumber = (randomnumber / 9) * 9;
            int min = namenumber;
            int max = ((randomnumber / 9) + 1) * 9 - 1;
            int result = (int) (Math.random() * (max - min + 1)) + min;
            for (int i = 0; i < result + 1; i++) {
                cursor.moveToNext();
            }
            Log.i("min", Integer.toString(min));
            Log.i("max", Integer.toString(max));
            Log.i("result", Integer.toString(result));
            String foodname = cursor.getString(2);
            int foodprice = cursor.getInt(3);
            button7.setText(foodname + "\n" + Integer.toString(foodprice) + "원");
            buttonStates[6].setStep02(true);
        }
        else if(buttonStates[6].getSteop01() == false && buttonStates[6].getSteop02() == false)
            button7.setText("?");
    }
    @OnClick(R.id.button8)
    void onClinck8(){
        if(buttonStates[7].getSteop01() == true && buttonStates[7].getSteop02() == false) {
            SQLiteDatabase database = openOrCreateDatabase("store.db", MODE_PRIVATE, null);
            String sql = "select _id, name, menu, price, phone from store";
            Cursor cursor = database.rawQuery(sql, null);
            int namenumber = (randomnumber / 9) * 9;
            int min = namenumber;
            int max = ((randomnumber / 9) + 1) * 9 - 1;
            int result = (int) (Math.random() * (max - min + 1)) + min;
            for (int i = 0; i < result + 1; i++) {
                cursor.moveToNext();
            }
            Log.i("min", Integer.toString(min));
            Log.i("max", Integer.toString(max));
            Log.i("result", Integer.toString(result));
            String foodname = cursor.getString(2);
            int foodprice = cursor.getInt(3);
            button8.setText(foodname + "\n" + Integer.toString(foodprice) + "원");
            buttonStates[7].setStep02(true);
        }
        else if(buttonStates[7].getSteop01() == false && buttonStates[7].getSteop02() == false)
            button8.setText("?");
    }
    @OnClick(R.id.button9)
    void onClinck9(){
        if(buttonStates[8].getSteop01() == true && buttonStates[8].getSteop02() == false) {
            SQLiteDatabase database = openOrCreateDatabase("store.db", MODE_PRIVATE, null);
            String sql = "select _id, name, menu, price, phone from store";
            Cursor cursor = database.rawQuery(sql, null);
            int namenumber = (randomnumber / 9) * 9;
            int min = namenumber;
            int max = ((randomnumber / 9) + 1) * 9 - 1;
            int result = (int) (Math.random() * (max - min + 1)) + min;
            for (int i = 0; i < result + 1; i++) {
                cursor.moveToNext();
            }
            Log.i("min", Integer.toString(min));
            Log.i("max", Integer.toString(max));
            Log.i("result", Integer.toString(result));
            String foodname = cursor.getString(2);
            int foodprice = cursor.getInt(3);
            button9.setText(foodname + "\n" + Integer.toString(foodprice) + "원");
            buttonStates[8].setStep02(true);
        }
        else if(buttonStates[8].getSteop01() == false && buttonStates[8].getSteop02() == false)
            button9.setText("?");
    }


    @OnClick(R.id.activitiy_main_slotbar_imageview)
    void onSlotClick() {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                setInitialButton();
                SQLiteDatabase database = openOrCreateDatabase("store.db",MODE_PRIVATE,null);
                String sql = "select _id, name, menu, price, phone from store";
                Cursor cursor = database.rawQuery(sql, null);
                String name = "0";
                int n;
                for (int i = 0; i < restaurantname.size(); i++) {
                    mRandomTextview.setText(restaurantname.get(i).toString());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Random random = new Random();
                randomnumber = random.nextInt(199);
                for(int i = 0; i < randomnumber; i++){
                    cursor.moveToNext();
                }
                name = cursor.getString(1);

                mRandomTextview.setText(name);
                cursor.close();
                for(int i=0;i<buttonStates.length;i++){
                    buttonStates[i].setStep01(true);
                    buttonStates[i].setStep02(false);
                }

            }
        };
        Thread thread1 = new Thread(runnable);
        thread1.start();


    }

    public void restaurantName() {
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
    }
    public void setInitialButton(){
        button1.setText("?");
        button2.setText("?");
        button3.setText("?");
        button4.setText("?");
        button5.setText("?");
        button6.setText("?");
        button7.setText("?");
        button8.setText("?");
        button9.setText("?");
    }
}

class ButtonState{
    private boolean step01;
    private boolean step02;

    public ButtonState(boolean a,boolean b) {
        this.step01 = a;
        this.step02 = b;
    }
    public void setStep01(boolean b){
        step01 = b;
    }
    public void setStep02(boolean b){
        step02 = b;
    }
    public boolean getSteop01(){
        return step01;
    }
    public boolean getSteop02(){
        return step02;
    }
}
