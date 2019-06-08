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
import android.widget.Toast;

import butterknife.BindView;
import butterknife.OnClick;

public class DataBaseManager extends AppCompatActivity {

    public EditText mDatabaseName;
    public EditText mTableName;
    public EditText mPrimaryKey;
    public EditText mMenuName;
    public EditText mPrice;
    public EditText mPhoneNum;

    public Button mOpenButton;
    public Button mTableButton;
    public Button mPlusButton;

    public TextView mConsoleText; //console용 텍스트뷰


    public Context mContext;
    public SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base_manager);
        init();
    }

    void init(){
        mContext = getApplicationContext();
        mDatabaseName = (EditText)findViewById(R.id.activity_data_base_manager_databasename_edittext);//버터나이프 getText()안됨
        mTableName = (EditText)findViewById(R.id.activity_data_base_manager_tablename_edittext);

        mPrimaryKey = (EditText)findViewById(R.id.activity_data_base_manager_datanumber_edittext);
        mMenuName = (EditText)findViewById(R.id.activity_data_base_manager_foodname_edittext);
        mPrice = (EditText)findViewById(R.id.activity_data_base_manager_price_edittext);
        mPhoneNum = (EditText)findViewById(R.id.activity_data_base_manager_phonenum_edittext);

        mOpenButton = (Button)findViewById(R.id.activity_data_base_manager_openDB_button); //OnClick안먹어서 다시 바인딩
        mTableButton = (Button)findViewById(R.id.activity_data_base_manager_create_table_button);
        mPlusButton = (Button)findViewById(R.id.activity_data_base_manager_insert_data_button);

        mConsoleText = (TextView)findViewById(R.id.activity_data_base_manager_console_textview); //버터나이프로 append안먹음 ㅠ

        mOpenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                println("openOrCreateDataBase()호출");
                database = openOrCreateDatabase(mDatabaseName.getText().toString(),MODE_PRIVATE, null);

                if(database != null){
                    println("데이터베이스를 열었습니다.");
                }
            }
        });

        mTableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                println("테이블 생성... ");
                if(database != null){
                    String sql = "create table if not exists " + mTableName.getText().toString() + "("
                            + " _id integer PRIMARY KEY autoincrement, "
                            + " name text, "
                            + " price integer, "
                            + " phone text);";
                    database.execSQL(sql);
                    println("완료... ");
                }else{
                    simpleToast("먼저 데이터베이스를 실행시켜주세요.");
                }
            }
        });

        mPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int DBkey = Integer.parseInt(mPrimaryKey.getText().toString().trim());
                String menu = mMenuName.getText().toString().trim();
                int price = Integer.parseInt(mPrice.getText().toString().trim());
                String phone = mPhoneNum.getText().toString().trim();

                //데이터를 추가해줍니다.
                println("데이터를 추가하기 시작..");
                if(database != null ){
                    String sql = "insert into store(_id, name, price, phone) values( ?, ?, ?, ?)";
                    Object[] params = { DBkey, menu, price,phone};
                    database.execSQL(sql,params);
                    println("완료");
                }else{
                    simpleToast("데이터베이스를 먼저 열어주세요");
                }

            }
        });
    }

    public void simpleToast(String message){
        Toast.makeText(mContext,message,Toast.LENGTH_SHORT).show();
    }
    public void println(String data){
        mConsoleText.append(data+"\n");
    }

}
