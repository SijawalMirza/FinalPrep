package com.example.sijaw.finalprep;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;


public class MainActivity extends Activity {
    String TAG="MTAG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyDb myDb=new MyDb(this);
        myDb.insertdata(5);
        Log.d(TAG, "onCreate: "+myDb.getdata());

    }
}
