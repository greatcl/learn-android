package com.greatcl.androidlifecycletest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.greatcl.androidlifecycletest.R;

/**
 * Created by caolei on 15/5/17.
 */
public class MainActivity extends Activity{
    protected static final String TAG = "greatcl";
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main_layout);

        Button normalBtn = (Button) findViewById(R.id.start_normal_activity_btn);
        Button dialogBtn = (Button) findViewById(R.id.start_dialog_activity_btn);

        normalBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, NormalActivity.class);
                startActivity(intent);
            }
        });

        dialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DialogActivity.class);
                startActivity(intent);
            }
        });

        Log.d(TAG, this.getClass().getSimpleName() + " " + Thread.currentThread().getStackTrace()[2].getMethodName());
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG, this.getClass().getSimpleName() + " " + Thread.currentThread().getStackTrace()[2].getMethodName());
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG, this.getClass().getSimpleName() + " " + Thread.currentThread().getStackTrace()[2].getMethodName());
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG, this.getClass().getSimpleName() + " " + Thread.currentThread().getStackTrace()[2].getMethodName());
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d(TAG, this.getClass().getSimpleName() + " " + Thread.currentThread().getStackTrace()[2].getMethodName());
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG, this.getClass().getSimpleName() + " " + Thread.currentThread().getStackTrace()[2].getMethodName());
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d(TAG, this.getClass().getSimpleName() + " " + Thread.currentThread().getStackTrace()[2].getMethodName());
    }
}
