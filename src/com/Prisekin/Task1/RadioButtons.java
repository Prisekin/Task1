package com.Prisekin.Task1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.content.pm.ActivityInfo;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.graphics.Matrix;
//import java.util.Random;

public class RadioButtons extends Activity implements RadioGroup.OnCheckedChangeListener{
	ImageView image; String[] scale_type_names;
	@Override
	public void onCreate(Bundle bund){
		super.onCreate(bund);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		ScrollView scroller=new ScrollView(this);
		scroller.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
		LinearLayout line_lay=new LinearLayout(this);
		line_lay.setOrientation(LinearLayout.VERTICAL);
		line_lay.setBackgroundColor(0xffcfcf7f);
		image=new ImageView(this);
		image.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
		image.setBackgroundColor(0xffcf7fcf);
		image.setImageResource(R.drawable.kotik);
		RadioGroup radio_group=new RadioGroup(this);
		radio_group.setOnCheckedChangeListener(this);
		scale_type_names=getResources().getStringArray(R.array.scale_types);
		int random_check=(int)(System.currentTimeMillis()%scale_type_names.length);
		for(int i=0;i<scale_type_names.length;i++){
		 RadioButton radio_button=new RadioButton(this);
		 radio_button.setText(scale_type_names[i]);	//CENTER_CROP,CENTER_INSIDE,FIT_CENTER,FIT_END,FIT_START,FIT_XY
		 radio_button.setId(i);
		 if(i==random_check){radio_button.setChecked(true);}
		 radio_group.addView(radio_button);
		}
		line_lay.addView(image);
		line_lay.addView(radio_group);
		scroller.addView(line_lay);
		setContentView(scroller);
	}
	@Override
	public void onCheckedChanged(RadioGroup group, int pos){
		ScaleType scale_type=ScaleType.valueOf(scale_type_names[pos]);
		image.setScaleType(scale_type);
		if(scale_type==ScaleType.MATRIX){Matrix matrix=new Matrix(); matrix.postScale(0.4f,0.4f);
		matrix.postRotate(20); matrix.postTranslate(50,10); image.setImageMatrix(matrix);}
	}
}
