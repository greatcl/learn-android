package com.greatcl.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by caolei on 15/5/14.
 */
public class SecondActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        Intent intent = getIntent();
        String str = intent.getStringExtra("extra_string");

        Log.d("greatcl", str);

        Button button2 = (Button) findViewById(R.id.button_2);
        button2.setText(str);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("return_data", "String from Second Activity");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent();
        intent.putExtra("return_data", "From SecondActivity By Press Back");
        setResult(RESULT_OK, intent);
        finish();
    }
}
