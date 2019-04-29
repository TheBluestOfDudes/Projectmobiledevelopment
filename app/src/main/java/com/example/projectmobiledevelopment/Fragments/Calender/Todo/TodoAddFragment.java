package com.example.projectmobiledevelopment.Fragments.Calender.Todo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.projectmobiledevelopment.Database.dates;
import com.example.projectmobiledevelopment.Fragments.MainActivity;
import com.example.projectmobiledevelopment.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TodoAddFragment extends Fragment {

    private EditText todoitem;
    private Button btnAdd;
    private MainActivity mainActivity;

    private int year;
    private int month;
    private int day;


    public TodoAddFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_todo_add, container, false);

        mainActivity = (MainActivity) getActivity();

        if(getArguments() != null && getArguments().containsKey("year")) {
            year = getArguments().getInt("year");
            month = getArguments().getInt("month");
            day = getArguments().getInt("day");
        }

        btnAdd = v.findViewById(R.id.btn_todoadd);
        todoitem = v.findViewById(R.id.add_todolist_string);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(getArguments() != null && getArguments().containsKey("year")) {
                    year = getArguments().getInt("year");
                    month = getArguments().getInt("month");
                    day = getArguments().getInt("day");
                }

                dates date = mainActivity.db.getSingleDate(year, month, day);
                if(date == null) {
                    mainActivity.db.insertDate(year, month, day);
                }
                mainActivity.db.insertTodoItem(mainActivity.db.getSingleDate(year,month,day), todoitem.getText().toString());
                Log.d("Hopethisworks", "" + year + " " + month + " " + day + " " + todoitem);
            }
        });


        return v;
    }

}
