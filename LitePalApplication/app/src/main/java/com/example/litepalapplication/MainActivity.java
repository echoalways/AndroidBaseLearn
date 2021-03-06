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
                List<Book> books=DataSupport.findAll(Book.class);//????????????
                for(Book book:books){
                    Log.d("MainActivity",book.getName());
                }
                Book firstBook=DataSupport.findFirst(Book.class);//???????????????
                Book lastBook=DataSupport.findLast(Book.class);//??????????????????
                List<Book> books1=DataSupport.select("name","author").find(Book.class);//?????????????????????
                List<Book> books2=DataSupport.where("pages>?","400").find(Book.class);//????????????
                List<Book> books3=DataSupport.order("price desc").find(Book.class);//?????????????????????asc??????
                List<Book> books4=DataSupport.limit(3).find(Book.class);//???????????????????????????
                List<Book> books5=DataSupport.limit(3).offset(1).find(Book.class);//????????????1?????????????????????????????????2???3???4????????????
                List<Book> books6=DataSupport.select("name","author","pages").where("pages>?","50").order("pages").limit(10).offset(1).find(Book.class);//????????????


            }
        });
    }
}