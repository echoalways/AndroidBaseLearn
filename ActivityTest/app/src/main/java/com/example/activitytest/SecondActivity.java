package com.example.activitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("SecondActivity","Task id is"+getTaskId());
        setContentView(R.layout.second_layout);

        /**
         * 在另一活动中取出传递数据。
         * getIntent方法获取用于启动SecondActivity的Intent。
         */
        //Intent intent=getIntent();
        //String data=intent.getStringExtra("extra_data");
        //Log.d("SecondActivity",data);

        Button button2=(Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SecondActivity.this,ThirdActivity.class);
                //intent.putExtra("data_return","hello FirstActivity");
                //setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}