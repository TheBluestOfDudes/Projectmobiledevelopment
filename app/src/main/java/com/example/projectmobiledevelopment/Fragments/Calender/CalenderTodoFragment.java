package com.example.projectmobiledevelopment.Fragments.Calender;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.projectmobiledevelopment.Classes.RecAdapter;
import com.example.projectmobiledevelopment.Classes.TodoAdapter;
import com.example.projectmobiledevelopment.Fragments.MainActivity;
import com.example.projectmobiledevelopment.R;

import java.util.Calendar;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CalenderTodoFragment extends Fragment {

    private RecyclerView ra;
    private MainActivity mainActivity;
    private TextView date;

    private int year;
    private int month;
    private int day;

    public CalenderTodoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_calender_todo, container, false);

        // init the textview
        date = v.findViewById(R.id.todo_date);


        // gets the arguments
        if(getArguments() != null && getArguments().containsKey("year")) {
            year = getArguments().getInt("year");
            month = getArguments().getInt("month");
            day = getArguments().getInt("day");
        }

        // gets the mainactivity
        mainActivity = ((MainActivity) getActivity());

        date.setText("Date: " + day + "/" + month + "/" + year);

        ra = v.findViewById(R.id.recycler_todo);
        ra.setLayoutManager(new LinearLayoutManager(getActivity()));
        TodoAdapter rv = new TodoAdapter(mainActivity.todolist);
        ra.setAdapter(rv);

        return v;
    }

}
