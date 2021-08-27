package com.example.litepalapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.ColorSpace;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button createDatabase=(Button) findViewById(R.id.create_database);
        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Connector.getDatabase();
            }
        });

        Button addData=(Button) findViewById(R.id.add_data);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book=new Book();
                book.setName("xxx");
                book.setAuthor("xxx");
                book.setPages(22);
                book.setPrice(56);
                book.save();
            }
        });

        Button updateData=(Button) findViewById(R.id.update_data);
        updateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book=new Book();
                book.setPrice(23);
                book.updateAll("name=? and author=? ","xxx","xxx");
            }
        });

        Button deleteData=(Button) findViewById(R.id.delete_data);
        deleteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataSupport.deleteAll(Book.class,"price<?","15");
            }
        });

        Button queryData=(Button) findViewById(R.id.query_data);
        queryData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Book> books=DataSupport.findAll(Book.class);//查询所有
                for(Book book:books){
                    Log.d("MainActivity",book.getName());
                }
                Book firstBook=DataSupport.findFirst(Book.class);//查询第一行
                Book lastBook=DataSupport.findLast(Book.class);//查询最后一行
                List<Book> books1=DataSupport.select("name","author").find(Book.class);//查询指定列数据
                List<Book> books2=DataSupport.where("pages>?","400").find(Book.class);//条件查询
                List<Book> books3=DataSupport.order("price desc").find(Book.class);//结果降序排列，asc升序
                List<Book> books4=DataSupport.limit(3).find(Book.class);//只查表中前三条数据
                List<Book> books5=DataSupport.limit(3).offset(1).find(Book.class);//查询偏移1位的三条连续数据，即第2、3、4条数据。
                List<Book> books6=DataSupport.select("name","author","pages").where("pages>?","50").order("pages").limit(10).offset(1).find(Book.class);//组合查询


            }
        });
    }
}