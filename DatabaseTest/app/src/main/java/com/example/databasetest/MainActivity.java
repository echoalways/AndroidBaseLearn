package com.example.databasetest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private MyDatabaseHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper=new MyDatabaseHelper(this,"BookStore.db",null,2);//需要更改，版本设置为2
        Button createDatabase=(Button) findViewById(R.id.create_database);
        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.getWritableDatabase();
            }
        });

        Button addData=(Button) findViewById(R.id.add_data);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db=dbHelper.getWritableDatabase();
                ContentValues values=new ContentValues();
                values.put("name","细雨湿流光");
                values.put("author","jun");
                values.put("price",34);
                values.put("pages",344);
                db.insert("Book",null,values);
                values.clear();
            }
        });

        Button updateData=(Button) findViewById(R.id.update_data);
        updateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db=dbHelper.getWritableDatabase();
                ContentValues values=new ContentValues();
                values.put("name","时光笔迹"); //将作者为jun的这行数据更新书名为“时光笔迹”
                db.update("Book",values,"author=?",new String[]{"jun"});
            }
        });

        Button deleteData=(Button) findViewById(R.id.delete_data);
        deleteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db=dbHelper.getWritableDatabase();
                db.delete("Book","pages>?",new String[]{"400"});
            }
        });

        Button queryData=(Button) findViewById(R.id.query_data);
        queryData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db=dbHelper.getWritableDatabase();
                //查询Book表中的所有数据
                Cursor cursor=db.query("Book",null,null,null,null,null,null);
                if(cursor.moveToFirst()){//将数据指针移到第一行的位置。
                    do{
                        String name=cursor.getString(cursor.getColumnIndex("name"));
                        String author=cursor.getString(cursor.getColumnIndex("author"));
                        int pages=cursor.getInt(cursor.getColumnIndex("pages"));
                        double price=cursor.getDouble(cursor.getColumnIndex("price"));

                        Log.d("MainActivity",name);
                        Log.d("MainActivity",author);
                        Log.d("MainActivity", String.valueOf(pages));
                        Log.d("MainActivity", String.valueOf(price));
                    }while (cursor.moveToNext());
                }
                cursor.close();
            }
        });
    }
}