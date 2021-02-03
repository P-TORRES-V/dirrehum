package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;


public class IntroActivity extends AppCompatActivity {

    private ViewPager screenPager;
    IntroViewPagerAdapter introViewPagerAdapter;
    Button btnGetStarted;
    ImageButton imbNext;
    int position = 0;
    Animation btnAnim;

//    TableLayout tabIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);

        if (restorePrefData()) {
            Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(mainActivity);
            finish();

        }

        setContentView(R.layout.activity_intro);

//        getSupportActionBar().hide();

//        tabIndicator = findViewById(R.id.tab_indicator);
        btnGetStarted = findViewById(R.id.btn_get_started);
        imbNext = findViewById(R.id.imbNext);
        btnAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.button_animation);


        List<ScreenItem> mList = new ArrayList<>();
        mList.add(new ScreenItem("", "", R.drawable.hilux));
        mList.add(new ScreenItem("", "", R.drawable.hiluxx));
        mList.add(new ScreenItem("", "", R.drawable.hiluxxx));


        screenPager = findViewById(R.id.screen_Viewpager);
        introViewPagerAdapter = new IntroViewPagerAdapter(this, mList);
        screenPager.setAdapter(introViewPagerAdapter);

        imbNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = screenPager.getCurrentItem();
                if (position < mList.size()) {
                    position++;
                    screenPager.setCurrentItem(position);
                }

                if (position == mList.size() - 1) {

                 laodLastScreen();
////                    Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
////                    startActivity(mainActivity);
////
//                 savePrefsData();
//                    finish();
                }
            }
        });


        btnGetStarted.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(mainActivity);

        savePrefsData();
        finish();
    }


    });

}


    private boolean restorePrefData() {

        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        Boolean isIntroActivityOpnendBefore = pref.getBoolean("isIntroOpend", false);
        return  isIntroActivityOpnendBefore;
    }

    private void savePrefsData() {

        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isIntroOpend",true);
        editor.commit();
    }

    private void laodLastScreen(){
        imbNext.setVisibility(View.INVISIBLE);
        btnGetStarted.setVisibility(View.VISIBLE);

        btnGetStarted.setAnimation(btnAnim);



    }

}