package com.jicketyjackindustries.life_assistant;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/*
This has become an experimentation class for trying out different things in Android Studio
In this file, now legacy, you will find examples of switching layouts, changing button colors,
saving data and other tricks
 */
public class MainActivity extends AppCompatActivity {


    private SharedPreferences settings;
    private SharedPreferences.Editor editor;
    public static final String  PREFS_NAME = "MyPrefsFile";

    private List buttonStates;
    private List buttonIDs;
    private static Integer NUM_BUTTONS = 8;
    /*
    replaces a constructor, do everything you want to do do on app startup here
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // preference saving!
        settings = getSharedPreferences(PREFS_NAME,0);
        editor = settings.edit();
        buttonStates = new ArrayList();
        buttonIDs = new ArrayList();
        // update buttonID's
        buttonIDs.add(R.id.button0);
        buttonIDs.add(R.id.button1);
        buttonIDs.add(R.id.button2);
        buttonIDs.add(R.id.button3);
        buttonIDs.add(R.id.button4);
        buttonIDs.add(R.id.button5);
        buttonIDs.add(R.id.button6);
        buttonIDs.add(R.id.button7);
        updateData();
        updateGUI();


    }
    /*
    retrieve all the variables from our saved data
     */
    private void updateData(){
        for(Integer i=0;i<NUM_BUTTONS;i++){
            String taskName = "task"+ i.toString();
            boolean taskState = settings.getBoolean(taskName,false);
            buttonStates.add(taskState);
        }
    }
    /*
    sets button colors etc based on the saved data
     */
    private void saveData(){
        for(Integer i=0;i<NUM_BUTTONS;i++){
            String taskName = "task"+ i.toString();
            boolean taskState = (boolean) buttonStates.get(i);
            editor.putBoolean(taskName,taskState);
            editor.commit();
        }
    }
    private void updateGUI(){
        View buttonView;
        boolean buttonState;
        for(Integer i=0;i<NUM_BUTTONS;i++){
            buttonView = this.findViewById((int)buttonIDs.get(i));
            buttonState = (boolean) buttonStates.get(i);
            if(buttonState){
                buttonView.setBackgroundResource(R.color.green);
            }
            else{
                buttonView.setBackgroundResource(R.color.buttonBackground);
            }
        }

    }
    /*
    changes the button color and stores the value of the task state
     */
    public void taskButton(View v, int currentButton){
        boolean taskComplete;


        taskComplete = !(boolean) buttonStates.get(currentButton); //flip the status
        buttonStates.set(currentButton,taskComplete);
        if(taskComplete){
            v.setBackgroundResource(R.color.green);
        }
        else{
            v.setBackgroundResource(R.color.buttonBackground);
        }
        saveData();


    }
    public void taskButton0(View v){
        taskButton(v,0);
    }

    public void taskButton1(View v){
        taskButton(v,1);
    }
    public void taskButton2(View v){
        taskButton(v,2);
    }
    public void taskButton3(View v){
        taskButton(v,3);
    }
    public void taskButton4(View v){
        taskButton(v,4);
    }
    public void taskButton5(View v){
        taskButton(v,5);
    }
    public void taskButton6(View v){
        taskButton(v,6);
    }
    public void taskButton7(View v){
        taskButton(v,7);
    }



    }


