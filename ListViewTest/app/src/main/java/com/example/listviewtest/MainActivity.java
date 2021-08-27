package com.example.listviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private String[] data={"人生若只如初见","何事秋风悲画扇？","等闲变却故人心","却道故人心易变","骊山语罢清宵半","泪雨霖铃终不怨","何如薄幸锦衣郎","比翼连枝当日愿",
            "非关癖爱轻模样","冷处偏佳","别有根芽","不是人间富贵花","谢娘别后谁能惜","漂泊天涯","寒月悲笳","万里西风瀚海沙"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter=new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,data);
        ListView listView=(ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }
}