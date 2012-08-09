package com.saman.rrc.app;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class ChildSettingActivity extends Activity {

	private List<Child> childs;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_setting);
        spinMake();
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_child_setting, menu);
        return true;
    }
    
    public void newChild(View view){
    	Spinner sp = (Spinner) findViewById(R.id.spinner1);
    	EditText nameTxt = (EditText) findViewById(R.id.editText1);
    	EditText codeTxt = (EditText) findViewById(R.id.editText2);
    	DatabaseHandler db = new DatabaseHandler(this);
    	
    	String name = nameTxt.getText().toString();
    	String codet = codeTxt.getText().toString();
    	int code = Integer.parseInt(codet);
    	
    	if(sp.getSelectedItemPosition() != -1){
    		Child tempch = new Child( 1, code, name);    		
    		db.addChild(tempch);
    	}
    	spinMake();
    	nameTxt.setText("");
    	codeTxt.setText("");
    }
    
    public void editChild(View view){
    	Spinner sp = (Spinner) findViewById(R.id.spinner1);
    	EditText nameTxt = (EditText) findViewById(R.id.editText1);
    	EditText codeTxt = (EditText) findViewById(R.id.editText2);
    	DatabaseHandler db = new DatabaseHandler(this);
    	
    	String name = nameTxt.getText().toString();
    	String codet = codeTxt.getText().toString();
    	int code = Integer.parseInt(codet);
    	
    	if(sp.getSelectedItemPosition() != -1){
    		Child tempch = childs.get(sp.getSelectedItemPosition()-1);
    		tempch.setName(name);
    		tempch.setCode(code);
    		db.updateChild(tempch);
    	}
    	spinMake();
    	nameTxt.setText("");
    	codeTxt.setText("");
    }
    
    public void delChild(View view){
    	Spinner sp = (Spinner) findViewById(R.id.spinner1);
    	DatabaseHandler db = new DatabaseHandler(this);
    	
    	if(sp.getSelectedItemPosition() != -1){
    		Child tempch = childs.get(sp.getSelectedItemPosition()-1);
    		db.deleteChild(tempch);    		
    	}
    	spinMake();

    }
    
    private void spinMake(){
    	DatabaseHandler db = new DatabaseHandler(this);
    	Spinner sp = (Spinner) findViewById(R.id.spinner1);
    	
    	childs = db.getAllChilds();
    	ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this,   android.R.layout.simple_spinner_item);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down vieww
        
        spinnerArrayAdapter.add("--یکی را انتخاب نمایید---");
        for (Child cn : childs) {
            String txt = "Name :" + cn.getName() + " |Code :" + cn.getCode();
            spinnerArrayAdapter.add(txt);            
            }
        
        sp.setAdapter(spinnerArrayAdapter);
    }
    
}
