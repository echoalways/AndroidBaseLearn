package com.example.recyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder> {

    private List<String> list;
    private Context context;

    public RecycleAdapter(List<String> list, Context applicationContext) {
        this.list=list;
        this.context=applicationContext;
    }

    /**
     * onCreateViewHolder方法创建一个viewHolder，viewholder可以理解为一条数据的展示布局，这里我们自定义类LinearViewHolder创建一个只有TextView的item
     * 这里我们需要创建每条布局使用的layout：recycle_item
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public RecycleAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.textView.setText(list.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,position,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.my_recycler_view);
        }
    }
}
