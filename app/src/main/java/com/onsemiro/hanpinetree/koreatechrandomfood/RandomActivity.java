package com.onsemiro.hanpinetree.koreatechrandomfood;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RandomActivity extends AppCompatActivity implements View.OnClickListener{
    private Context mContext;

    private ImageView mImage_front; // front : koreatech badge
    private ImageView mImage_back;  // back : food menu

    private Animation mSlotAnim;
    /*슬롯 애니메이션 관련 변수*/
    @BindView(R.id.activity_main_random_textview) TextView mRandomTextview;

    private ScaleAnimation sato0 = new ScaleAnimation(1, 0, 1, 1, Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, 0.5f);
    private ScaleAnimation sato1 = new ScaleAnimation(0, 1, 1, 1, Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, 0.5f);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);
        initView();
    }
    private void initView() {
        ButterKnife.bind(this);
        mSlotAnim = AnimationUtils.loadAnimation(this, R.anim.slot);
        mContext = getApplicationContext();

        mImage_front = (ImageView)findViewById(R.id.imageview_front_card_00);
        mImage_front.setOnClickListener(this);
        mImage_back = (ImageView)findViewById(R.id.imaggeview_back_card_00);
        mImage_back.setOnClickListener(this);
        showImageFront();
        sato0.setDuration(500);
        sato1.setDuration(500);

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
    }

    @OnClick(R.id.activitiy_main_slotbar_imageview)
    void onSlotClick() {
        mRandomTextview.startAnimation(mSlotAnim);
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
