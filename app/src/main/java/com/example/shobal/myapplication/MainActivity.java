package com.example.shobal.myapplication;

import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * This activity will be fired to user to insert his profile image. The idea of inserting a profile image is avoid phishing attacks
 *
 *
 */
public class MainActivity extends Activity{
    private static final String TAG = "MainActivity";
    public static int imageFileSize = 0;
    private FileInputStream fis;
    /* Initialize two buttons, one for go forward to web view and other button for upload profile picture
     * (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button loginButton = (Button) findViewById(R.id.btnLogin);//login button to go to web view
        loginButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(MainActivity.this, WebViewActivity.class);
                i.putExtra("self_login", "self_login");
                startActivity(i);
            }

        });
    }
    /*
     * (non-Javadoc)
     * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    /* launch configuration activity to set hostname and port
     * (non-Javadoc)
     * @see android.app.Activity#onMenuItemSelected(int, android.view.MenuItem)
     */
    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_settings:
                Log.v("Menu Clicked", "Menu Setting Clicked");
                Intent intent = new Intent(MainActivity.this, Configuration.class);
                startActivity(intent);
                break;
        }
        return super.onMenuItemSelected(featureId, item);
    }
}

