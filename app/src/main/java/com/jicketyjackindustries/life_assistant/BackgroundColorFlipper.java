package com.jicketyjackindustries.life_assistant;
import android.view.View;

import com.jicketyjackindustries.life_assistant.R;

public class BackgroundColorFlipper {

    private int currentColor;
    private int primary = R.color.colorPrimary;
    private int red = R.color.red;
    private int blue = R.color.blue;
    private int green = R.color.green;
    protected View view;


    public  BackgroundColorFlipper(View v){
        view = v;
        currentColor = primary;
        //update();

    }
    public void flipBackgroundRed(){
        if(currentColor!= red)
            currentColor = red;
        else if (currentColor == red)
            currentColor = primary;

        update();
    }

    public void flipBackgroundBlue(){
        if(currentColor!= blue)
            currentColor = blue;
        else if (currentColor == blue)
            currentColor = primary;

        update();
    }

    public void flipBackgroundGreen(){
        if(currentColor!= green)
            currentColor = green;
        else if (currentColor == green)
            currentColor = primary;

        update();
    }

    private void update(){
        view.setBackgroundResource(currentColor);
    }

}
