package com.Prisekin.Task1;

import android.os.Bundle;
import android.app.Activity;
//import android.view.Menu;
import android.view.View;
import android.content.Intent;

public class Task1 extends Activity {
	Intent radio_intent,spinner_intent;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        radio_intent=new Intent(this,RadioButtons.class);
        spinner_intent=new Intent(this,WithSpinner.class);
        setContentView(R.layout.task1);
    }
    public void RunActivity(View view){
    	switch(view.getId()){
    	case R.id.radio_activity: startActivity(radio_intent); break;
    	case R.id.spinner_activity: startActivity(spinner_intent); break;
    	}
    }
    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.task1, menu);
        return true;
    }*/
}
