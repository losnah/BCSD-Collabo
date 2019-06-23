package com.onsemiro.hanpinetree.koreatechrandomfood;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.random) Button mRandomButton;
    @BindView(R.id.restaurantButton) Button mRestaurantButton;
    private Intent mIntent;
    public SQLiteDatabase database;

    Button testButton;

    static ArrayList<ArrayList<String>> restaurant = new ArrayList<ArrayList<String>>();
    static ArrayList<String> restaurantname = new ArrayList<String>();
    static ArrayList<String> hansot = new ArrayList<String>();
    static ArrayList<String> bonggus = new ArrayList<String>();
    static ArrayList<String> jlgumuckgi = new ArrayList<String>();
    static ArrayList<String> gorilabob = new ArrayList<String>();
    static ArrayList<String> momstouch = new ArrayList<String>();
    static ArrayList<String> nenechicken = new ArrayList<String>();
    static ArrayList<String> kimsdon = new ArrayList<String>();
    static ArrayList<String> yetnaltongdak = new ArrayList<String>();
    static ArrayList<String> hops = new ArrayList<String>();
    static ArrayList<String> bakyusaneyasik = new ArrayList<String>();
    static ArrayList<String> sokupndaeji = new ArrayList<String>();
    static ArrayList<String> yulnalgae = new ArrayList<String>();
    static ArrayList<String> michinjjambbong = new ArrayList<String>();
    static ArrayList<String> duckgm = new ArrayList<String>();
    static ArrayList<String> guchonchicken = new ArrayList<String>();
    static ArrayList<String> masinetangsuyuk = new ArrayList<String>();
    static ArrayList<String> taesunjokbal = new ArrayList<String>();
    static ArrayList<String> gusunghansikvife = new ArrayList<String>();
    static ArrayList<String> cheftongdak = new ArrayList<String>();
    static ArrayList<String> maslan = new ArrayList<String>();
    static ArrayList<String> sunny = new ArrayList<String>();
    static ArrayList<String> tiba = new ArrayList<String>();
    static ArrayList<String> mexicanna = new ArrayList<String>();

    /*가격정보*/
    ArrayList<String> hansotprice = new ArrayList<>();
    ArrayList<String> bonggusprice = new ArrayList<>();
    ArrayList<String> jlgumuckgiprice = new ArrayList<>();
    ArrayList<String> gorilabobprice = new ArrayList<>();
    ArrayList<String> momstouchprice = new ArrayList<>();
    ArrayList<String> nenechickenprice = new ArrayList<>();
    ArrayList<String> kimsdonprice = new ArrayList<>();
    ArrayList<String> yetnaltongdakprice = new ArrayList<>();
    ArrayList<String> hopsprice = new ArrayList<>();
    ArrayList<String> bakyusaneyasikprice = new ArrayList<>();
    ArrayList<String> sokupndaejiprice = new ArrayList<>();
    ArrayList<String> yulnalgaeprice = new ArrayList<>();
    ArrayList<String> michinjjambbongprice = new ArrayList<>();
    ArrayList<String> duckgmprice = new ArrayList<>();
    ArrayList<String> guchonchickenprice = new ArrayList<>();
    ArrayList<String> masinetangsuyukprice = new ArrayList<>();
    ArrayList<String> taesunjokbalprice = new ArrayList<>();
    ArrayList<String> gusunghansikvifeprice = new ArrayList<>();
    ArrayList<String> cheftongdakprice = new ArrayList<>();
    ArrayList<String> maslanprice = new ArrayList<>();
    ArrayList<String> sunnyprice = new ArrayList<>();
    ArrayList<String> tibaprice = new ArrayList<>();
    ArrayList<String> mexicannaprice = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testButton = (Button)findViewById(R.id.main_activity_test);


        ButterKnife.bind(this);
        File f = new File(getFilesDir() + "test.txt");
        if (!f.isFile()) {
            createDB();
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(getFilesDir() + "test.txt", true));
                PrintWriter pw = new PrintWriter(bw, true);
                pw.write("once");
                pw.close();
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "예외발생 ", Toast.LENGTH_LONG).show();
            }
        }

        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DataBaseManager.class);
                startActivity(intent);
            }
        });

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
//    @OnClick(R.id.activity_main_databaseManager_button)
//    void onStartDBManager(){
//        mIntent = new Intent(getApplicationContext(), DataBaseManager.class);
//        startActivity(mIntent);
//    }

    public void createDB(){
        addHansotMenu();
        addBonggusMenu();
        addJlgumuckgiMenu();
        addGorilabobMenu();
        addMomstouchMenu();
        addNeneChickenMenu();
        addKimsdonMenu();
        addYetnaltongdakMenu();
        addHopsMenu();
        addBakyusaneyasikMenu();
        addSokupndajiMenu();
        addYulnalgaeMenu();
        addMichinjjambbongMenu();
        addDuckgmMenu();
        addGuchonchickenMenu();
        addMasinetangsuyukMenu();
        addTaesunjokbalMenu();
        addGusunghansikvifeMenu();
        addCheftondakMenu();
        addMaslanMenu();
        addSunnyMenu();
        addTibaMenu();
        addMaxicannaMenu();
        addRestaurant();
        restaurantName();
        /**/
        addHansotMenuPrice();
        addBonggusMenuPrice();
        addJlgumuckgiMenuPrice();
        addGorilabobMenuPrice();
        addMomstouchMenuPrice();
        addNeneChickenMenuPrice();
        addKimsdonMenuPrice();
        addYetnaltongdakMenuPrice();
        addHopsMenuPrice();
        addBakyusaneyasikMenuPrice();
        addSokupndajiMenuPrice();
        addYulnalgaeMenuPrice();
        addMichinjjambbongMenuPrice();
        addDuckgmMenuPrice();
        addGuchonchickenMenuPrice();
        addMasinetangsuyukMenuPrice();
        addTaesunjokbalMenuPrice();
        addGusunghansikvifeMenuPrice();
        addCheftondakMenuPrice();
        addMaslanMenuPrice();
        addSunnyMenuPrice();
        addTibaMenuPrice();
        addMaxicannaMenuPrice();
        //데이터베이스 열기

        database = openOrCreateDatabase("store.db",MODE_PRIVATE, null);

        //데이터베이스 테이블 만들기
        String sql = "create table if not exists " + "store" + "("
                + " _id integer PRIMARY KEY autoincrement, "
                + " name text, "
                + " menu text,"
                + " price integer, "
                + " phone text);";
        database.execSQL(sql);

        //데이터추가하기
        sql = "insert into store(_id, name, menu, price, phone) values( ?, ?, ?, ?, ?)";

        int sum = 0;
        for(int i = 0; i < hansot.size(); i++) {
            Object[] params1 = {i, "한솥", hansot.get(i), Integer.parseInt(hansotprice.get(i)) , "041-523-1124"};
            database.execSQL(sql, params1);
        }
        for(int i = 0; i < bonggus.size(); i++) {
            Object[] params1 = {i+hansot.size(), "봉구스", bonggus.get(i),  Integer.parseInt(bonggusprice.get(i)), "041-523-5949"};
            database.execSQL(sql, params1);
        }
        for(int i = 0; i < jlgumuckgi.size(); i++) {
            Object[] params1 = {i+hansot.size()+bonggus.size(), "즐겨먹기", jlgumuckgi.get(i),  Integer.parseInt(jlgumuckgiprice.get(i)), "041-522-0122"};
            database.execSQL(sql, params1);
        }
        for(int i = 0; i < gorilabob.size(); i++) {
            Object[] params1 = {i+hansot.size()+bonggus.size()+jlgumuckgi.size(), "고릴라밥", gorilabob.get(i),  Integer.parseInt(gorilabobprice.get(i)), "041-555-6098"};
            database.execSQL(sql, params1);
        }
        for(int i = 0; i < momstouch.size(); i++) {
            Object[] params1 = {i+hansot.size()+bonggus.size()+jlgumuckgi.size()+gorilabob.size(), "맘스터치", momstouch.get(i),  Integer.parseInt(momstouchprice.get(i)), "041-558-5385"};
            database.execSQL(sql, params1);
        }
        for(int i = 0; i < nenechicken.size(); i++) {
            Object[] params1 = {i+hansot.size()+bonggus.size()+jlgumuckgi.size()+gorilabob.size()+momstouch.size(), "네네치킨", nenechicken.get(i), Integer.parseInt(nenechickenprice.get(i)), "041-568-9285"};
            database.execSQL(sql, params1);
        }
        for(int i = 0; i < kimsdon.size(); i++) {
            Object[] params1 = {i+hansot.size()+bonggus.size()+jlgumuckgi.size()+gorilabob.size()+momstouch.size()+nenechicken.size(), "킴스돈", kimsdon.get(i), Integer.parseInt(kimsdonprice.get(i)), "041-568-1500"};
            database.execSQL(sql, params1);
        }
        for(int i = 0; i < yetnaltongdak.size(); i++) {
            Object[] params1 = {i+hansot.size()+bonggus.size()+jlgumuckgi.size()+gorilabob.size()+momstouch.size()+nenechicken.size()+kimsdon.size(), "옛날통닭", yetnaltongdak.get(i), Integer.parseInt(yetnaltongdakprice.get(i)), "010-9988-0127"};
            database.execSQL(sql, params1);
        }
        for(int i = 0; i < hops.size(); i++) {
            Object[] params1 = {i+hansot.size()+bonggus.size()+jlgumuckgi.size()+gorilabob.size()+momstouch.size()+nenechicken.size()+kimsdon.size()+yetnaltongdak.size(), "홉스", hops.get(i), Integer.parseInt(hopsprice.get(i)), "041-555-6295"};
            database.execSQL(sql, params1);
        }

        for(int i = 0; i < bakyusaneyasik.size(); i++) {
            Object[] params1 = {i+hansot.size()+bonggus.size()+jlgumuckgi.size()+gorilabob.size()+momstouch.size()+nenechicken.size()+kimsdon.size()+yetnaltongdak.size()+hops.size(), "박여사네야식", bakyusaneyasik.get(i),  Integer.parseInt(bakyusaneyasikprice.get(i)), "041-522-2920"};
            database.execSQL(sql, params1);
        }
        for(int i = 0; i < sokupndaeji.size(); i++) {
            Object[] params1 = {i+hansot.size()+bonggus.size()+jlgumuckgi.size()+gorilabob.size()+momstouch.size()+nenechicken.size()+kimsdon.size()+yetnaltongdak.size()+hops.size()+bakyusaneyasik.size(), "속없는돼지", sokupndaeji.get(i),  Integer.parseInt(sokupndaejiprice.get(i)), "041-555-7525"};
            database.execSQL(sql, params1);
        }
        for(int i = 0; i < yulnalgae.size(); i++) {
            Object[] params1 = {i+hansot.size()+bonggus.size()+jlgumuckgi.size()+gorilabob.size()+momstouch.size()+nenechicken.size()+kimsdon.size()+yetnaltongdak.size()+hops.size()+bakyusaneyasik.size()+sokupndaeji.size(), "열날개", yulnalgae.get(i),  Integer.parseInt(yulnalgaeprice.get(i)), "041-556-9982"};
            database.execSQL(sql, params1);
        }
        for(int i = 0; i < michinjjambbong.size(); i++) {
            Object[] params1 = {i+hansot.size()+bonggus.size()+jlgumuckgi.size()+gorilabob.size()+momstouch.size()+nenechicken.size()+kimsdon.size()+yetnaltongdak.size()+hops.size()+bakyusaneyasik.size()+sokupndaeji.size()+yulnalgae.size(), "미친짬뽕", michinjjambbong.get(i),  Integer.parseInt(michinjjambbongprice.get(i)), "041-557-4317"};
            database.execSQL(sql, params1);
        }
        sum = hansot.size()+bonggus.size()+jlgumuckgi.size()+gorilabob.size()+momstouch.size()+nenechicken.size()+kimsdon.size()+yetnaltongdak.size()+hops.size()+bakyusaneyasik.size()+sokupndaeji.size()+yulnalgae.size();
        for(int i = 0; i < duckgm.size(); i++) {
            Object[] params1 = {i+sum+ michinjjambbong.size(), "덕금", duckgm.get(i), Integer.parseInt(duckgmprice.get(i)), "041-566-4590"};
            database.execSQL(sql, params1);
        }
        for(int i = 0; i < guchonchicken.size(); i++) {
            Object[] params1 = {i+sum+ michinjjambbong.size()+duckgm.size(), "교촌치킨", guchonchicken.get(i), Integer.parseInt(guchonchickenprice.get(i)), "041-567-7272"};
            database.execSQL(sql, params1);
        }
        for(int i = 0; i < taesunjokbal.size(); i++) {
            Object[] params1 = {i+sum+ michinjjambbong.size()+duckgm.size()+guchonchicken.size(), "태선족발", taesunjokbal.get(i), Integer.parseInt(taesunjokbalprice.get(i)), "041-555-9588"};
            database.execSQL(sql, params1);
        }
        sum += michinjjambbong.size()+duckgm.size()+guchonchicken.size();
        for(int i = 0; i < masinetangsuyuk.size(); i++) {
            Object[] params1 = {i+sum+taesunjokbal.size(), "마시내탕수육", masinetangsuyuk.get(i), Integer.parseInt(masinetangsuyukprice.get(i)), "041-552-99982"};
            database.execSQL(sql, params1);
        }
        //OK
        for(int i = 0; i < gusunghansikvife.size(); i++) {
            Object[] params1 = {i+sum+taesunjokbal.size()+michinjjambbong.size(), "거성한식뷔페", gusunghansikvife.get(i), Integer.parseInt(gusunghansikvifeprice.get(i)), "041-552-3935"};
            database.execSQL(sql, params1);
        }
        for(int i = 0; i < cheftongdak.size(); i++) {
            Object[] params1 = {i+sum+taesunjokbal.size()+michinjjambbong.size()+gusunghansikvife.size(), "쉐프통닭", cheftongdak.get(i), Integer.parseInt(cheftongdakprice.get(i)), "010-4667-6020"};
            database.execSQL(sql, params1);
        }
        for(int i = 0; i < maslan.size(); i++) {
            Object[] params1 = {i+sum+taesunjokbal.size()+michinjjambbong.size()+gusunghansikvife.size()+cheftongdak.size(), "마슬랜", maslan.get(i), Integer.parseInt(maslanprice.get(i)), "041-566-9949"};
            database.execSQL(sql, params1);
        }

        for(int i = 0; i < sunny.size(); i++) {
            Object[] params1 = {i+sum+taesunjokbal.size()+michinjjambbong.size()+gusunghansikvife.size()+cheftongdak.size()+maslan.size(), "써니숯불도시락", sunny.get(i), Integer.parseInt(sunnyprice.get(i)), "041-554-8951"};
            database.execSQL(sql, params1);
        }
        for(int i = 0; i < tiba.size(); i++) {
            Object[] params1 = {i+sum+taesunjokbal.size()+michinjjambbong.size()+gusunghansikvife.size()+cheftongdak.size()+maslan.size()+sunny.size(), "티바", tiba.get(i), Integer.parseInt(tibaprice.get(i)), "070-4215-7499"};
            database.execSQL(sql, params1);
        }
        for(int i = 0; i < mexicanna.size(); i++) {
            Object[] params1 = {i+sum+taesunjokbal.size()+michinjjambbong.size()+gusunghansikvife.size()+cheftongdak.size()+maslan.size()+sunny.size()+tiba.size(), "맥시카나", mexicanna.get(i), Integer.parseInt(mexicannaprice.get(i)), "041-522-1282"};
            database.execSQL(sql, params1);
        }

        Toast.makeText(getApplicationContext(),"SQL삽입 완료",Toast.LENGTH_SHORT).show();
    }
    public void addRestaurant() {
        restaurant.add(hansot);
        restaurant.add(bonggus);
        restaurant.add(jlgumuckgi);
        restaurant.add(gorilabob);
        restaurant.add(momstouch);
        restaurant.add(nenechicken);
        restaurant.add(kimsdon);
        restaurant.add(yetnaltongdak);
        restaurant.add(hops);
        restaurant.add(sokupndaeji);
        restaurant.add(bakyusaneyasik);
        restaurant.add(yulnalgae);
        restaurant.add(michinjjambbong);
        restaurant.add(duckgm);
        restaurant.add(guchonchicken);
        restaurant.add(masinetangsuyuk);
        restaurant.add(taesunjokbal);
        restaurant.add(gusunghansikvife);
        restaurant.add(cheftongdak);
        restaurant.add(maslan);
        restaurant.add(sunny);
        restaurant.add(tiba);
        restaurant.add(mexicanna);
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
    public void addHansotMenu() {
        hansot.add("동백");
        hansot.add("도련님");
        hansot.add("돈가스도련님");
        hansot.add("빅치킨마요");
        hansot.add("돈가스카레");
        hansot.add("한솥철판볶음밥");
        hansot.add("국화");
        hansot.add("돈가스덮밥");
        hansot.add("치킨제육");
    }
    public void addBonggusMenu() {
        bonggus.add("봉구스밥버거");
        bonggus.add("봉순이밥버거");
        bonggus.add("햄치즈밥버거");
        bonggus.add("치즈닭갈비밥버거");
        bonggus.add("김치떡갈비밥버거");
        bonggus.add("마요떡갈비밥버거");
        bonggus.add("봉구킹");
        bonggus.add("봉구퀸");
        bonggus.add("김치제육밥버거");
    }
    public void addJlgumuckgiMenu() {
        jlgumuckgi.add("새우볶음밥");
        jlgumuckgi.add("김치볶음밥");
        jlgumuckgi.add("햄볶음밥");
        jlgumuckgi.add("김치찌개");
        jlgumuckgi.add("부대찌개");
        jlgumuckgi.add("된장찌개");
        jlgumuckgi.add("오므라이스");
        jlgumuckgi.add("콩나물불고기");
        jlgumuckgi.add("일식돈가스");
    }
    public void addGorilabobMenu() {
        gorilabob.add("닭볶음탕");
        gorilabob.add("닭갈비");
        gorilabob.add("김치찌개");
        gorilabob.add("알탕");
        gorilabob.add("고추장불고기");
        gorilabob.add("간장불고기");
        gorilabob.add("고추장삽겹살");
        gorilabob.add("뼈해장국");
        gorilabob.add("돈까스");
    }
    public void addMomstouchMenu() {
        momstouch.add("치킨커틀렛버거");
        momstouch.add("딥치즈버거");
        momstouch.add("화이트갈릭버거");
        momstouch.add("리샐버거");
        momstouch.add("통새우버거");
        momstouch.add("싸이버거");
        momstouch.add("불싸이버거");
        momstouch.add("디럭스불고기버거");
        momstouch.add("휠렛버거");
    }
    public void addNeneChickenMenu() {
        nenechicken.add("포테이토짜용치킨");
        nenechicken.add("소이갈릭치킨");
        nenechicken.add("스노윙치킨");
        nenechicken.add("크리미언치킨");
        nenechicken.add("핫블링치킨");
        nenechicken.add("쇼킹핫양념치킨");
        nenechicken.add("후라이드");
        nenechicken.add("양념치킨");
        nenechicken.add("오리엔탈파닭");
    }
    public void addKimsdonMenu() {
        kimsdon.add("국물떡볶이");
        kimsdon.add("닭볶음탕");
        kimsdon.add("닭 떡볶이세트");
        kimsdon.add("SET1");
        kimsdon.add("SET2");
        kimsdon.add("SET3");
        kimsdon.add("SET4");
        kimsdon.add("낙곱새");
        kimsdon.add("납작만두");
    }
    public void addYetnaltongdakMenu() {
        yetnaltongdak.add("옛날통닭");
        yetnaltongdak.add("불닭");
        yetnaltongdak.add("닭강정");
        yetnaltongdak.add("닭똥집");
        yetnaltongdak.add("순살후라이드");
        yetnaltongdak.add("순살양념치킨");
        yetnaltongdak.add("순살간장치킨");
        yetnaltongdak.add("순살마늘간장치킨");
        yetnaltongdak.add("순살파닭");
    }
    public void addHopsMenu() {
        hops.add("국물떡볶이");
        hops.add("허니갈릭프라이");
        hops.add("치즈떡볶이");
        hops.add("불고기치즈프라이");
        hops.add("매콤크림떡스타");
        hops.add("홉스순살치킨");
        hops.add("참치오코노미야끼");
        hops.add("홉스양념치킨");
        hops.add("홉스텐더플래터");
    }
    public void addBakyusaneyasikMenu() {
        bakyusaneyasik.add("오리주물럭");
        bakyusaneyasik.add("곱창전골");
        bakyusaneyasik.add("육개장");
        bakyusaneyasik.add("낙지볶음");
        bakyusaneyasik.add("오삼불고기");
        bakyusaneyasik.add("알탕");
        bakyusaneyasik.add("고추장찌개");
        bakyusaneyasik.add("쭈꾸미볶음");
        bakyusaneyasik.add("닭발");
    }
    public void addSokupndajiMenu() {
        sokupndaeji.add("김치찌개");
        sokupndaeji.add("고추장찌개");
        sokupndaeji.add("파고추장삼겹");
        sokupndaeji.add("제육볶음");
        sokupndaeji.add("소갈비살비빔밥");
        sokupndaeji.add("소불고기덮밥");
        sokupndaeji.add("김치볶음밥");
        sokupndaeji.add("된장찌개");
        sokupndaeji.add("돈까스");
    }
    public void addYulnalgaeMenu() {
        yulnalgae.add("불날개");
        yulnalgae.add("불닭발");
        yulnalgae.add("불닭");
        yulnalgae.add("불오돌뼈");
        yulnalgae.add("계란찜");
        yulnalgae.add("파닭");
        yulnalgae.add("양념치킨");
        yulnalgae.add("간장치킨");
        yulnalgae.add("주먹밥");
    }
    public void addMichinjjambbongMenu() {
        michinjjambbong.add("짜장면");
        michinjjambbong.add("간짜장");
        michinjjambbong.add("짬뽕");
        michinjjambbong.add("삼선짬뽕");
        michinjjambbong.add("볶음밥");
        michinjjambbong.add("육계장");
        michinjjambbong.add("제육덮밥");
        michinjjambbong.add("매운짜장");
        michinjjambbong.add("새우볶음밥");
    }
    public void addDuckgmMenu() {
        duckgm.add("간장찜닭");
        duckgm.add("맵닭맵닭");
        duckgm.add("크림찜닭");
        duckgm.add("닭볶음탕");
    }
    public void addGuchonchickenMenu() {
        guchonchicken.add("교촌허니오리지날");
        guchonchicken.add("교촌허니스틱");
        guchonchicken.add("교촌허니콤보");
        guchonchicken.add("교촌살살치킨");
        guchonchicken.add("소이살살치킨");
        guchonchicken.add("교촌 오리지날");
        guchonchicken.add("교촌 콤보");
        guchonchicken.add("교촌 레드 오리지날");
        guchonchicken.add("교촌 후라이드");
    }
    public void addMasinetangsuyukMenu() {
        masinetangsuyuk.add("허니골드탕수육");
        masinetangsuyuk.add("깐풍기");
        masinetangsuyuk.add("불피탕수육");
        masinetangsuyuk.add("피자탕수육");
        masinetangsuyuk.add("눈꽃탕수육");
        masinetangsuyuk.add("눈꽃치킨");
        masinetangsuyuk.add("후라이드파닭");
        masinetangsuyuk.add("양념탕수육");
        masinetangsuyuk.add("간장탕수육육");
    }
    public void addTaesunjokbalMenu() {
        taesunjokbal.add("따뜻한족발");
        taesunjokbal.add("매운족발");
        taesunjokbal.add("냉채족발");
        taesunjokbal.add("반반족발");
        taesunjokbal.add("달콤한탕수육");
        taesunjokbal.add("족발덮밥(간장)");
        taesunjokbal.add("족발덮밥(매운)");
        taesunjokbal.add("알뜰한2인세트");
    }
    public void addGusunghansikvifeMenu() {
        gusunghansikvife.add("소불고기");
        gusunghansikvife.add("된장찌개");
        gusunghansikvife.add("제육볶음");
        gusunghansikvife.add("김치찌개");
        gusunghansikvife.add("짜장덮밥");
        gusunghansikvife.add("카레덮밥");
        gusunghansikvife.add("백반");
    }
    public void addCheftondakMenu() {
        cheftongdak.add("후라이드");
        cheftongdak.add("양념");
        cheftongdak.add("매운양념");
        cheftongdak.add("매콤간장");
        cheftongdak.add("마늘치킨");
        cheftongdak.add("파닭");
        cheftongdak.add("순살치즈스노윙");
        cheftongdak.add("순살화이트어니언");
        cheftongdak.add("순살타꼬야끼");
    }
    public void addMaslanMenu(){
        maslan.add("후라이드");
        maslan.add("피자치탕");
        maslan.add("감자피자치탕");
        maslan.add("고구마피자치탕");
        maslan.add("김치피자치탕");
        maslan.add("만두피자치탕");
        maslan.add("데리야끼치탕");
        maslan.add("불피치탕");
        maslan.add("껫잎특대");
    }
    public void addSunnyMenu(){
        sunny.add("돼지김치찌개");
        sunny.add("우삼겹된장찌개");
        sunny.add("규동");
        sunny.add("우삼겹숙주덮밥");
        sunny.add("불닭볶음밥");
        sunny.add("우삼겹볶음밥");
        sunny.add("제육컵밥");
        sunny.add("숯불고기샐비");
        sunny.add("우삼겹샐비");
    }
    public void addTibaMenu(){
        tiba.add("콤보바이트");
        tiba.add("핫치킨바이트");
        tiba.add("리치골드");
        tiba.add("포테이토바이트");
        tiba.add("불고기골드");
        tiba.add("치즈스노우퀸");
        tiba.add("양념치킨");
        tiba.add("순살고추파닭");
        tiba.add("후라이드치킨");
    }
    public void addMaxicannaMenu(){
        mexicanna.add("후라이드");
        mexicanna.add("양념치킨");
        mexicanna.add("순살크런키");
        mexicanna.add("순살허브치킨");
        mexicanna.add("골드윙");
        mexicanna.add("매운양념치킨");
        mexicanna.add("땡초치킨");
        mexicanna.add("멕시윙");
        mexicanna.add("파닭");
    }

    /*가격*/

    public void addYetnaltongdakMenuPrice() {
        yetnaltongdakprice.add("7000");
        yetnaltongdakprice.add("11000");
        yetnaltongdakprice.add("12000");
        yetnaltongdakprice.add("11000");
        yetnaltongdakprice.add("12000");
        yetnaltongdakprice.add("13000");
        yetnaltongdakprice.add("13000");
        yetnaltongdakprice.add("13000");
        yetnaltongdakprice.add("15000");
    }
    public void addHopsMenuPrice() {
        hopsprice.add("6000");
        hopsprice.add("6000");
        hopsprice.add("7000");
        hopsprice.add("9000");
        hopsprice.add("16000");
        hopsprice.add("18000");
        hopsprice.add("9000");
        hopsprice.add("19000");
        hopsprice.add("12000");
    }
    public void addBakyusaneyasikMenuPrice() {
        bakyusaneyasikprice.add("30000");
        bakyusaneyasikprice.add("30000");
        bakyusaneyasikprice.add("8000");
        bakyusaneyasikprice.add("20000");
        bakyusaneyasikprice.add("20000");
        bakyusaneyasikprice.add("20000");
        bakyusaneyasikprice.add("7000");
        bakyusaneyasikprice.add("15000");
        bakyusaneyasikprice.add("15000");
    }
    public void addSokupndajiMenuPrice() {
        sokupndaejiprice.add("11000");
        sokupndaejiprice.add("11000");
        sokupndaejiprice.add("13000");
        sokupndaejiprice.add("11000");
        sokupndaejiprice.add("6000");
        sokupndaejiprice.add("6000");
        sokupndaejiprice.add("6000");
        sokupndaejiprice.add("5000");
        sokupndaejiprice.add("7000");
    }
    public void addYulnalgaeMenuPrice() {
        yulnalgaeprice.add("8500");
        yulnalgaeprice.add("8500");
        yulnalgaeprice.add("16000");
        yulnalgaeprice.add("14000");
        yulnalgaeprice.add("6000");
        yulnalgaeprice.add("15000");
        yulnalgaeprice.add("16000");
        yulnalgaeprice.add("17000");
        yulnalgaeprice.add("2000");
    }
    public void addMichinjjambbongMenuPrice() {
        michinjjambbongprice.add("5000");
        michinjjambbongprice.add("6000");
        michinjjambbongprice.add("7000");
        michinjjambbongprice.add("8000");
        michinjjambbongprice.add("6000");
        michinjjambbongprice.add("7000");
        michinjjambbongprice.add("7500");
        michinjjambbongprice.add("7000");
        michinjjambbongprice.add("8000");
    }
    public void addDuckgmMenuPrice() {
        duckgmprice.add("20000");
        duckgmprice.add("20000");
        duckgmprice.add("20000");
        duckgmprice.add("20000");
    }
    public void addGuchonchickenMenuPrice() {
        guchonchickenprice.add("15000");
        guchonchickenprice.add("18000");
        guchonchickenprice.add("18000");
        guchonchickenprice.add("16000");
        guchonchickenprice.add("16000");
        guchonchickenprice.add("15000");
        guchonchickenprice.add("17000");
        guchonchickenprice.add("16000");
        guchonchickenprice.add("15000");
    }
    /**/
    public void addHansotMenuPrice() {
        hansotprice.add("5000");
        hansotprice.add("3700");
        hansotprice.add("3900");
        hansotprice.add("3500");
        hansotprice.add("3900");
        hansotprice.add("3700");
        hansotprice.add("4000");
        hansotprice.add("3600");
        hansotprice.add("4400");
    }
    public void addBonggusMenuPrice() {
        bonggusprice.add("1800");
        bonggusprice.add("2000");
        bonggusprice.add("2800");
        bonggusprice.add("3000");
        bonggusprice.add("2300");
        bonggusprice.add("2500");
        bonggusprice.add("4500");
        bonggusprice.add("4500");
        bonggusprice.add("2600");
    }

    public void addJlgumuckgiMenuPrice() {
        jlgumuckgiprice.add("11000");
        jlgumuckgiprice.add("11000");
        jlgumuckgiprice.add("11000");
        jlgumuckgiprice.add("11000");
        jlgumuckgiprice.add("14000");
        jlgumuckgiprice.add("11000");
        jlgumuckgiprice.add("13000");
        jlgumuckgiprice.add("12000");
        jlgumuckgiprice.add("6000");
    }
    public void addGorilabobMenuPrice() {
        gorilabobprice.add("22000");
        gorilabobprice.add("6000");
        gorilabobprice.add("6000");
        gorilabobprice.add("6000");
        gorilabobprice.add("6000");
        gorilabobprice.add("6000");
        gorilabobprice.add("6000");
        gorilabobprice.add("7000");
        gorilabobprice.add("6000");
    }
    public void addMomstouchMenuPrice() {
        momstouchprice.add("5400");
        momstouchprice.add("6000");
        momstouchprice.add("6100");
        momstouchprice.add("6100");
        momstouchprice.add("4900");
        momstouchprice.add("5600");
        momstouchprice.add("5600");
        momstouchprice.add("6200");
        momstouchprice.add("5800");
    }
    public void addNeneChickenMenuPrice() {
        nenechickenprice.add("17000");
        nenechickenprice.add("17000");
        nenechickenprice.add("17000");
        nenechickenprice.add("17000");
        nenechickenprice.add("17000");
        nenechickenprice.add("17000");
        nenechickenprice.add("15000");
        nenechickenprice.add("16000");
        nenechickenprice.add("17000");
    }
    public void addKimsdonMenuPrice() {
        kimsdonprice.add("15000");
        kimsdonprice.add("21000");
        kimsdonprice.add("20000");
        kimsdonprice.add("18000");
        kimsdonprice.add("20000");
        kimsdonprice.add("23000");
        kimsdonprice.add("27000");
        kimsdonprice.add("25000");
        kimsdonprice.add("3000");
    }
    /**/

    public void addMasinetangsuyukMenuPrice() {
        masinetangsuyukprice.add("22000");
        masinetangsuyukprice.add("22000");
        masinetangsuyukprice.add("23000");
        masinetangsuyukprice.add("23000");
        masinetangsuyukprice.add("22000");
        masinetangsuyukprice.add("18000");
        masinetangsuyukprice.add("17000");
        masinetangsuyukprice.add("22000");
        masinetangsuyukprice.add("22000");
    }
    public void addTaesunjokbalMenuPrice() {
        taesunjokbalprice.add("27000");
        taesunjokbalprice.add("29000");
        taesunjokbalprice.add("29000");
        taesunjokbalprice.add("34000");
        taesunjokbalprice.add("15000");
        taesunjokbalprice.add("7000");
        taesunjokbalprice.add("7000");
        taesunjokbalprice.add("19000");
    }
    public void addGusunghansikvifeMenuPrice() {
        gusunghansikvifeprice.add("6000");
        gusunghansikvifeprice.add("6000");
        gusunghansikvifeprice.add("6000");
        gusunghansikvifeprice.add("6000");
        gusunghansikvifeprice.add("6000");
        gusunghansikvifeprice.add("6000");
        gusunghansikvifeprice.add("6000");
    }
    public void addCheftondakMenuPrice() {
        cheftongdakprice.add("15000");
        cheftongdakprice.add("15000");
        cheftongdakprice.add("16000");
        cheftongdakprice.add("15000");
        cheftongdakprice.add("15000");
        cheftongdakprice.add("15000");
        cheftongdakprice.add("17000");
        cheftongdakprice.add("17000");
        cheftongdakprice.add("17000");
    }
    public void addMaslanMenuPrice(){
        maslanprice.add("17000");
        maslanprice.add("16000");
        maslanprice.add("16000");
        maslanprice.add("16000");
        maslanprice.add("16000");
        maslanprice.add("16000");
        maslanprice.add("16000");
        maslanprice.add("16000");
        maslanprice.add("27000");
    }
    public void addSunnyMenuPrice(){
        sunnyprice.add("5500");
        sunnyprice.add("6000");
        sunnyprice.add("5500");
        sunnyprice.add("5500");
        sunnyprice.add("4500");
        sunnyprice.add("5000");
        sunnyprice.add("4500");
        sunnyprice.add("4000");
        sunnyprice.add("4500");
    }
    public void addTibaMenuPrice(){
        tibaprice.add("12900");
        tibaprice.add("12900");
        tibaprice.add("11900");
        tibaprice.add("13900");
        tibaprice.add("11900");
        tibaprice.add("16000");
        tibaprice.add("15000");
        tibaprice.add("17000");
        tibaprice.add("14000");
    }
    public void addMaxicannaMenuPrice(){
        mexicannaprice.add("15000");
        mexicannaprice.add("16000");
        mexicannaprice.add("16000");
        mexicannaprice.add("16500");
        mexicannaprice.add("17000");
        mexicannaprice.add("17000");
        mexicannaprice.add("17000");
        mexicannaprice.add("17000");
        mexicannaprice.add("17000");
    }
}