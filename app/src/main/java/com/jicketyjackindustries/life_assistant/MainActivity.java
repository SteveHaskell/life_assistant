package com.jicketyjackindustries.life_assistant;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/*
This has become an experimentation class for trying out different things in Android Studio
In this file, now legacy, you will find examples of switching layouts, changing button colors,
saving data and other tricks
 */
public class MainActivity extends AppCompatActivity {

    public static final String  PREFS_NAME = "MyPrefsFile";

    private SharedPreferences settings;
    private SharedPreferences.Editor editor;
    private List buttonStates;
    private List buttonIDs;

    /*
    replaces a constructor, do everything you want to do do on app startup here
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // set data members
        settings = getSharedPreferences(PREFS_NAME,0);
        editor = settings.edit();
        buttonStates = new ArrayList();
        buttonIDs = new ArrayList();

        //app logics plays out from here
        createGUI();
        loadData();
        updateGUI();


    }

    /*
    creates the buttons from the list of tasks
     */
    private void createGUI(){
        //create buttons based on task array

        Resources res = getResources();
        String[] taskArray;
        taskArray = res.getStringArray(R.array.fatigue_day_task_list);
        LinearLayout layout1 = findViewById(R.id.linearLayout1);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);

        int i = 0;
        for(String s: taskArray){
            Button myButton = new Button(this);
            myButton.setText(s);
            myButton.setId(i);

            myButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    taskButton(v);
                }
            });
            TextView myTextView = new TextView(this);
            myTextView.setMinHeight(10);
            layout1.addView(myButton,lp);
            layout1.addView(myTextView,lp);

            buttonIDs.add(i);
            i=i+1;
        }
    }
    /*
    retrieve all the variables from our saved data
     */

    private void loadData(){
        for(Integer i=0;i<buttonIDs.size();i++){
            String taskName = "task"+ i.toString();
            boolean taskState = settings.getBoolean(taskName,false);
            buttonStates.add(taskState);
        }
    }

    /*
    sets button colors etc based on the saved data
     */
    private void saveData(){
        for(Integer i=0;i<buttonIDs.size();i++){
            String taskName = "task"+ i.toString();
            boolean taskState = (boolean) buttonStates.get(i);
            editor.putBoolean(taskName,taskState);
            editor.commit();
        }
    }
    private void updateGUI(){
        View buttonView;
        boolean buttonState;
        for(Integer i=0;i<buttonIDs.size();i++){
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
    public void taskButton(View v){
        boolean taskComplete;
        int currentButton = v.getId();
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


    }


