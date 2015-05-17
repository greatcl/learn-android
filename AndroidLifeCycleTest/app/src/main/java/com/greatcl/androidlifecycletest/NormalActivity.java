package com.greatcl.androidlifecycletest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.greatcl.androidlifecycletest.R;

/**
 * Created by caolei on 15/5/17.
 */
public class NormalActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.normal_layout);
    }
}
