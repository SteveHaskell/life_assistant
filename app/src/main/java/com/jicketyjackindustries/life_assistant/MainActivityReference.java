package com.jicketyjackindustries.life_assistant;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/*
This has become an experimentation class for trying out different things in Android Studio
In this file, now legacy, you will find examples of switching layouts, changing button colors,
saving data and other tricks
 */
public class MainActivityReference extends AppCompatActivity {

    protected View view;
    private BackgroundColorFlipper bcf;
    private boolean task1Complete = false;
    private SharedPreferences settings;
    private SharedPreferences.Editor editor;
    public static final String  PREFS_NAME = "MyPrefsFile";
    /*
    replaces a constructor, do everything you want to do do on app startup here
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        //variable construction
        view = this.getWindow().getDecorView();
        bcf = new BackgroundColorFlipper(view);
        //attempt to get button view
        View buttonView;
        buttonView = this.findViewById(R.id.button1);

        // preference saving!
        settings = getSharedPreferences(PREFS_NAME,0);
        editor = settings.edit();
        if(settings.getBoolean("task1",false))
            buttonView.setBackgroundResource(R.color.blue);
        else
            buttonView.setBackgroundResource(R.color.colorPrimary);

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

        editor.putBoolean("task1",task1Complete);
        editor.commit();

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
