package com.jicketyjackindustries.life_assistant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    protected View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //variable construction
        view = this.getWindow().getDecorView();
    }

    public void makeBackgroundRed(View v){
        view.setBackgroundResource(R.color.red);
        v.setBackgroundResource(R.color.red);
    }
}
