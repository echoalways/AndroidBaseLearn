package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button linearBT,gridBT,waterfallBT;
    private RecyclerView recyclerView;
    private RecycleAdapter recycleAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearBT=(Button) findViewById(R.id.LinearLayout);
        gridBT=(Button) findViewById(R.id.gridLayout);
        waterfallBT=(Button) findViewById(R.id.waterfallLayout);
        //1、获取RecycleView对象
        recyclerView=(RecyclerView) findViewById(R.id.my_recycler_view);

        linearBT.setOnClickListener(this);
        gridBT.setOnClickListener(this);
        waterfallBT.setOnClickListener(this);

        initData();
    }

    private void initData(){
        list=new ArrayList<>();
        for(int i=0;i<18;i++){
            list.add("Item"+i);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.LinearLayout:
                layoutManager=new LinearLayoutManager(getApplicationContext());
                break;
            case R.id.gridLayout:
                layoutManager=new GridLayoutManager(getApplicationContext(),4);//4列
                break;
            case R.id.waterfallLayout:
                layoutManager=new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL);
                break;
            default:
                break;
        }
        //2、设置布局管理器
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(),DividerItemDecoration.VERTICAL));
        //3、添加适配器
        recycleAdapter=new RecycleAdapter(list,getApplicationContext());
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
}