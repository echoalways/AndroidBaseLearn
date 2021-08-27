package com.example.uiwidgettest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView imageView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button=(Button) findViewById(R.id.button);
        //imageView=(ImageView) findViewById(R.id.image_view);
        progressBar=(ProgressBar) findViewById(R.id.progress_bar);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:

                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);

                //imageView.setImageResource(R.drawable.bajiao);

                /*设置进度条的可见性
                if(progressBar.getVisibility()==View.GONE){
                    progressBar.setVisibility(View.VISIBLE);
                }else{
                    progressBar.setVisibility(View.GONE);
                }*/

                /*设置进度条进度
                int progress=progressBar.getProgress();
                progress+=10;
                progressBar.setProgress(progress);*/

                /* AlertDialog提示对话框
                AlertDialog.Builder dialog=new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("This is a dialog");
                dialog.setMessage("something important");
                dialog.setCancelable(false);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.show();*/

                /*有进度条的对话框
                ProgressDialog progressDialog=new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("This is a progressDialog");
                progressDialog.setMessage("loading...");
                progressDialog.setCancelable(true);
                progressDialog.show();*/
                break;
            default:
                break;
        }

    }
}