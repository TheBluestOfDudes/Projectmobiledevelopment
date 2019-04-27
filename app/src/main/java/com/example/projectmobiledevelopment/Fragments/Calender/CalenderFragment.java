package com.example.projectmobiledevelopment.Fragments.Calender;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;

import com.example.projectmobiledevelopment.Fragments.MainActivity;
import com.example.projectmobiledevelopment.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalenderFragment extends Fragment {

    private Button btnNotify;
    private Button btnTodo;
    private Button btnList;
    private CalendarView calendar;

    private MainActivity mainActivity;


    public CalenderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_calender, container, false);

        // gets the buttons
        btnNotify = v.findViewById(R.id.btn_calender_notify);
        btnTodo = v.findViewById(R.id.btn_calender_todo);

        // getting the calender view
        calendar = v.findViewById(R.id.calendarView);

        // getting the activity
        mainActivity = ((MainActivity) getActivity());

        // calendar onchange ...
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {

            }
        });

        //setting onclick on the buttons
        btnNotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = mainActivity.fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.calender_container, new NotifyCalenderFragment())
                        .commit();
            }
        });

        btnTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = mainActivity.fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.calender_container, new CalenderTodoFragment(), null)
                        .commit();
            }
        });
        return v;
    }

}
