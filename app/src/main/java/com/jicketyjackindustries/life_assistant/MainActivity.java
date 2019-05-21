package com.jicketyjackindustries.life_assistant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    protected View view;
    private boolean isRed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //variable construction
        view = this.getWindow().getDecorView();
        view.setBackgroundResource(R.color.colorPrimary);
        isRed=false;

    }

    public void makeBackgroundRed(View v){
        if(isRed){
            isRed=false;
            view.setBackgroundResource(R.color.colorPrimary);

        }
        else{
            isRed=true;
            view.setBackgroundResource(R.color.red);

        }


    }
}
