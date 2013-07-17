package com.example.cloudlabs;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class Second extends Activity  {
	
	public  String[] exp;
       
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent intent = getIntent();
		setContentView(R.layout.activity_second);
		
		 Spinner spinner = (Spinner) findViewById(R.id.spinner);
	        
	        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
	                this, R.array.exp, android.R.layout.simple_spinner_item);

	        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	        spinner.setAdapter(adapter);
	        
	        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

	            public void onItemSelected(AdapterView<?> arg0, View arg1,
	                    int arg2, long arg3) {
	                
	                int index = arg0.getSelectedItemPosition();
	                exp = getResources().getStringArray(R.array.exp);
                    
	               // Toast.makeText(getBaseContext(), "You have selected : " +exp[index], 
	                       // Toast.LENGTH_SHORT).show();
	                if(arg2==1)
	                {
	                Intent third = new Intent(Second.this,Third.class);
                    startActivity(third);
	                }
	                
	            }

	            public void onNothingSelected(AdapterView<?> arg0) {
	                // do nothing
	                
	            }
	                      
	        });     
	        
	    }

	

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
		return true;
	}

}
