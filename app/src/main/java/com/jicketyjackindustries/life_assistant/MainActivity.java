package com.jicketyjackindustries.life_assistant;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/*
This has become an experimentation class for trying out different things in Android Studio
 */
public class MainActivity extends AppCompatActivity {

    protected View view;
    private BackgroundColorFlipper bcf;
    private boolean task1Complete = false;
    private SharedPreferences mPrefs;
    private SharedPreferences.Editor mEditor;

    /*
    replaces a constructor, do everything you want to do do on app startup here
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPrefs = getSharedPreferences("label", 0);
        mEditor = mPrefs.edit();


        setContentView(R.layout.activity_main);

        //variable construction
        view = this.getWindow().getDecorView();
        if(mPrefs.getBoolean("task1", true))
            view.setBackgroundResource(R.color.blue);

        bcf = new BackgroundColorFlipper(view);

        Context context;
        context = this.getApplicationContext();
        view.setOnTouchListener(new OnSwipeTouchListener(context) {
            @Override
            public void onSwipeLeft() {
                bcf.flipBackgroundBlue();
            }
            @Override
            public void onSwipeRight(){
                bcf.flipBackgroundGreen();
            }
            @Override
            public void onSwipeUp(){
                bcf.flipBackgroundRed();
            }
        });

    }

    public void redButton(View v){
        bcf.flipBackgroundRed();
        setContentView(R.layout.activity_main2);
    }

    public void activityTwoButton(View v){
        setContentView(R.layout.activity_main);
    }
    public void taskButton1(View v){
        if(!task1Complete)
            v.setBackgroundResource(R.color.green);
        else
            v.setBackgroundResource(R.color.colorPrimary);

        task1Complete = !task1Complete;
        mEditor.putBoolean("task1",task1Complete);
    }

    private void wait(int t){
        long milli = t*1000;
        try {
            Thread.sleep(milli);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
