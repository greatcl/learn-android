package com.greatcl.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
/**
 * Created by caolei on 15/5/14.
 */
public class FirstActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceStace){
        super.onCreate(savedInstanceStace);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.first_layout);

        Button button1 = (Button) findViewById(R.id.button_1);
        Button telButton = (Button) findViewById(R.id.button_call);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // finish();
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                intent.putExtra("extra_string", "Hello SecondActivity");

//                Intent intent = new Intent("com.greatcl.activitytest.ACTION_START");
//                intent.addCategory("com.greatcl.activitytest.MY_CATEGORY");

//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("http://www.baidu.com"));

//                startActivity(intent);
                startActivityForResult(intent, 1);
            }
        });

        telButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
            }
        });

        Log.d("greatcl", this.getClass().getSimpleName() );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        switch (requestCode){
            case 1:
                if (resultCode == RESULT_OK){
                    String returnedData = data.getStringExtra("return_data");
                    Log.d("greatcl", returnedData);
                }
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this, "You clicked add", Toast.LENGTH_LONG).show();
                break;
            case R.id.delete_item:
                Toast.makeText(this, "You clicked delete", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this, "You clicked other", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}
