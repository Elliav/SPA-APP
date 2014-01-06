package com.s_care.spa;

import utils.Constants;
import utils.MemoryManager;

import com.example.s_care.R;

import controller.Controller;
import interfaces.group.InterfaceQuestionEvaluation;
import android.os.Bundle;
import android.view.Menu;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity {
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize First Questionnaire
        MemoryManager.currentQuestionnaire = Constants.QuestionnaireType.BASDAI_TYPE;
        Controller.StartQuestionnaire(this.getBaseContext());

       
		Intent intent = new Intent(MainActivity.this, InterfaceQuestionEvaluation.class);		            
		startActivity(intent);	

//common
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}