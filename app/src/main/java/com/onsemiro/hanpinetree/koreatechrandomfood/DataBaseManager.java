package com.onsemiro.hanpinetree.koreatechrandomfood;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DataBaseManager extends AppCompatActivity {

    EditText mEditText;
    EditText mEditText2;
    EditText mEditText3;
    EditText mEditText4;
    EditText mEditText5;

    TextView mTextView;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base_manager);

        init();
    }

    void init(){
        mEditText = (EditText)findViewById(R.id.editText);
        mEditText2 = (EditText)findViewById(R.id.editText2);
        mEditText3= (EditText)findViewById(R.id.editText3);
        mEditText4= (EditText)findViewById(R.id.editText4);
        mEditText5= (EditText)findViewById(R.id.editText5);

        mTextView = (TextView)findViewById(R.id.textView4);

        Button mButton = (Button)findViewById(R.id.button2);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String databaseName = mEditText.getText().toString();
//                Toast.makeText(getApplicationContext(),"흠",Toast.LENGTH_SHORT).show();
                openDatabase(databaseName);
            }
        });

        Button mButton2 = (Button)findViewById(R.id.button3);
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tableName = mEditText2.getText().toString();
                createTable(tableName);
            }
        });
        Button mButton3 = (Button)findViewById(R.id.button4);
        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mEditText3.getText().toString().trim();
                String ageStr = mEditText4.getText().toString().trim();
                String mobile = mEditText5.getText().toString().trim();

                int age = -1;
                try {
                    age = Integer.parseInt(ageStr);
                }catch (Exception e){
                    e.printStackTrace();
                }
                insertData(name, age, mobile);
            }
        });

        Button mButton4 = (Button)findViewById(R.id.button10);
        mButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tableName = mEditText2.getText().toString();
                selectData(tableName);
            }
        });

    }

    public void openDatabase(String databaseName){
        println("openDatabase() 호출됨");
        database = openOrCreateDatabase(databaseName, MODE_PRIVATE, null);
        //보안때문에 MODE_PRIVATE를 주로 많이 씁니다.
        if(database != null){
            println("데이터베이스 오픈");
        }
    }
    public void createTable(String tableName){
        println("createTable() 호출됨");
        if(database != null) {
            String sql = "create table if not exists " + tableName + "("
                    + " _id integer PRIMARY KEY autoincrement, "
                    + " name text, "
                    + " age integer, "
                    + " phone text);";
            database.execSQL(sql);
            println("테이블 생성됨");
        }else{
            println("먼제 데이터베이스를 열어주세요");
        }
    }

    public void insertData(String name, int age, String mobile){
        println("insertData() 호출됨");

        if(database != null){
            String sql = "insert into customer(name, age, mobile) values( ?, ?, ?)";
            Object[] params = { name, age, mobile};

            database.execSQL(sql,params);
            println("데이터 추가함");
        }else {
            println("데이터베이스 먼저 오픈하세요");
        }
    }

    public void selectData(String tableName){
        println("selectData() 호출됨");

        if( database != null ){
            String sql = "select name, age, mobile from "+tableName;
            Cursor cursor = database.rawQuery(sql, null);//반환값이 있습니다 ㅎㅎ
            println("조회된 데이터 갯수 : "+ cursor.getCount());

            for(int i = 0; i < cursor.getCount(); i++){
                cursor.moveToNext();
                String name = cursor.getString(0);
                int age = cursor.getInt(1);
                String mobile = cursor.getString(2);

                println("#"+ i + "->" + name + ", " + age + ", " + mobile);
            }
        }

    }
    public void println(String data){
        mTextView.append(data +"\n");
    }


}
