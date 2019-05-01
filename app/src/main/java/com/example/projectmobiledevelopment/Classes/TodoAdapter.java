package com.example.projectmobiledevelopment.Classes;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.projectmobiledevelopment.R;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.ViewHolder> {

    private List<String> todolist;

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private View todoView;

        public ViewHolder(View itemView){
            super(itemView);
            todoView = itemView;
        }
    }

    public TodoAdapter(List<String> todolist){
        this.todolist = todolist;
    }

    @Override
    public TodoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.todo_list_item, parent, false);

        TodoAdapter.ViewHolder viewHolder = new TodoAdapter.ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TodoAdapter.ViewHolder viewHolder, int position){
        final String item = todolist.get(position);
        ((TextView)viewHolder.todoView.findViewById(R.id.txt_todoitem)).setText("" + item);
        ((TextView)viewHolder.todoView.findViewById(R.id.todo_pos)).setText("" + position);
    }

    @Override
    public int getItemCount(){
        return todolist.size();
    }

}
