package com.saman.rrc.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.child_setting:
                child_setting();
                return true;
            case R.id.command_setting:
                command_setting();
                return true;
            case R.id.system_setting:
                system_setting();
                return true;
            case R.id.about:
                about();
                return true;
            
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void child_setting(){
    	TextView txt = (TextView) findViewById(R.id.textView1);
    	txt.setText("Child Setting!");
    	
        Intent intent = new Intent(this, ChildSettingActivity.class);
        
        startActivity(intent);
        
    }
    public void command_setting(){
    	TextView txt = (TextView) findViewById(R.id.textView1);
    	txt.setText("Command Setting!");
    }
    public void system_setting(){
    	TextView txt = (TextView) findViewById(R.id.textView1);
    	txt.setText("System Setting!");
    }
    public void about(){
    	TextView txt = (TextView) findViewById(R.id.textView1);
    	txt.setText("About");
    }
}
