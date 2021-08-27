package com.example.activitytest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    /**
     * 添加菜单监听事件
     * @param item
     * @return
     */
    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //设置菜单多个选项按钮
        switch (item.getItemId()){
            case R.id.add_item:
                //Toast方法用于按钮点击后设置短暂文字提醒
                Toast.makeText(this,"you clicked add button",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,"you removed the button",Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    /**
     * 创建菜单按钮
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (requestCode == RESULT_OK) {
                    String returnData = data.getStringExtra("data_return");
                    Log.d("FirstActivity", returnData);
                }
                break;
            default:
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("FirstActivity","Task id is"+getTaskId());
        setContentView(R.layout.first_layout);//引入布局文件
        Button button1=(Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            protected Object clone() throws CloneNotSupportedException {
                return super.clone();
            }

            @Override
            public void onClick(View view) {
                //Toast.makeText(FirstActivity.this,"you clicked button1",Toast.LENGTH_SHORT).show();
                //finish();//活动销毁

                /*通过按钮事件重新开启一个activity，Intent用于启动活动，服务，广播。以下显式构造一个Intent，传入FirstActivity.this作为上下文，SecondActivity.class
                作为目标活动。*/
                //Intent intent=new Intent(FirstActivity.this,SecondActivity.class);

                /*隐式Intent */
                //Intent intent1=new Intent("com.example.activitytest.My_Category");
                //intent1.addCategory("com.example.activity.My_Category1");

                /*跳转外部url*/
                //Intent intent2=new Intent(Intent.ACTION_DIAL);
                //intent2.setData(Uri.parse("tel:10086"));

                /*向下一个活动传输数据*/
                //String data="hello ! secondActivity";
                //Intent intent3=new Intent(FirstActivity.this,SecondActivity.class);
                //intent3.putExtra("extra_data",data);

                /*返回数据给上一个活动*/
                //Intent intent4=new Intent(FirstActivity.this,SecondActivity.class);
                //startActivityForResult(intent4,1); //请求码假设为1

                Intent intent5=new Intent(FirstActivity.this,SecondActivity.class);

                startActivity(intent5);
            }
        });

    }

}