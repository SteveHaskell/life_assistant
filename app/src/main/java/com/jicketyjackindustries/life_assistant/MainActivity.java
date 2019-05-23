package com.jicketyjackindustries.life_assistant;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
/*
This has become an experimentation class for trying out different things in Android Studio
 */
public class MainActivity extends AppCompatActivity {

    protected View view;
    private boolean isRed;
    private boolean isBlue;
    private boolean isGreen;

    /*
    replaces a constructor, do everything you want to do do on app startup here
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //variable construction
        view = this.getWindow().getDecorView();
        view.setBackgroundResource(R.color.colorPrimary);

        Context context;
        context = this.getApplicationContext();
        view.setOnTouchListener(new OnSwipeTouchListener(context) {
            @Override
            public void onSwipeLeft() {
                flipBackgroundBlue();
            }
            @Override
            public void onSwipeRight(){
                flipBackgroundGreen();
            }
            @Override
            public void onSwipeUp(){
                flipBackgroundRed();
            }
        });
        isRed=false;
        isBlue=false;
        isGreen=false;

    }


    private void flipBackgroundRed(){
        if(isRed){
            isRed=false;
            view.setBackgroundResource(R.color.colorPrimary);
        }
        else{
            isRed=true;
            view.setBackgroundResource(R.color.red);
        }
    }
    private void flipBackgroundBlue(){
        if(isBlue){
            isBlue=false;
            view.setBackgroundResource(R.color.colorPrimary);
        }
        else{
            isBlue=true;
            view.setBackgroundResource(R.color.blue);
        }
    }
    private void flipBackgroundGreen(){
        if(isGreen){
            isGreen=false;
            view.setBackgroundResource(R.color.colorPrimary);
        }
        else{
            isGreen=true;
            view.setBackgroundResource(R.color.green);
        }
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
