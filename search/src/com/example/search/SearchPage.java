package com.example.search;


import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SearchPage extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search_page);
		
		Intent intent = getIntent();
		  final String[] myStrings = intent.getStringArrayExtra("strings");
		  
		  
		  final LinearLayout lm = (LinearLayout) findViewById(R.id.linearMain);
	   
	      LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		  
		  for(int i = 0; i < myStrings.length; i++){
			  
			  final int j = i;
			  
			  LinearLayout ll = new LinearLayout(this);
			  ll.setOrientation(LinearLayout.HORIZONTAL);
			  
			  final Button btn = new Button(this);
			  btn.setId(i+1);
			  btn.setText(myStrings[i]);
			  btn.setLayoutParams(params);
			  
			  final int index = i;
			  
			  btn.setOnClickListener(new OnClickListener() {
				  public void onClick(View v){
					  
					  MainActivity.searchNow(myStrings[j]);
					  
				  }
			  });
			  
			  ll.addView(btn);
			  lm.addView(ll);
			  
		  }
		
		
		
	}
}

