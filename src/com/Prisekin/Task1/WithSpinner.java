package com.Prisekin.Task1;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Matrix;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.view.View;

public class WithSpinner extends Activity implements OnItemSelectedListener{
	Spinner spinner; ImageView image; String[] scale_type_names;
	@Override
	public void onCreate(Bundle bund){
		super.onCreate(bund);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		LinearLayout line_lay=new LinearLayout(this);
		line_lay.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
		line_lay.setOrientation(LinearLayout.VERTICAL);
		line_lay.setBackgroundColor(0xffcfcf7f);
		image=new ImageView(this);
		image.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
		image.setBackgroundColor(0xffcf7fcf);
		image.setImageResource(R.drawable.kotik);
		spinner=new Spinner(this);
		spinner.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
		scale_type_names=getResources().getStringArray(R.array.scale_types);
		ArrayAdapter<CharSequence> spinner_adapter=ArrayAdapter.createFromResource(this,R.array.scale_types,android.R.layout.simple_spinner_item);
		spinner_adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		spinner.setAdapter(spinner_adapter);
		spinner.setOnItemSelectedListener(this);
		spinner.setSelection((int)(System.currentTimeMillis()%scale_type_names.length));
		line_lay.addView(spinner);
		line_lay.addView(image);
		setContentView(line_lay);
	}
	@Override
	public void onItemSelected(AdapterView<?> a,View v, int pos,long id){
		ScaleType scale_type=ScaleType.valueOf(scale_type_names[pos]);
		image.setScaleType(scale_type);
		if(scale_type==ScaleType.MATRIX){Matrix matrix=new Matrix(); matrix.postScale(0.4f,0.4f);
		matrix.postRotate(20); matrix.postTranslate(50,10); image.setImageMatrix(matrix);}
	}
	@Override
	public void onNothingSelected(AdapterView<?> a){}
}
