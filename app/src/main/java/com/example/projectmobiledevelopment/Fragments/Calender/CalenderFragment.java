package com.example.projectmobiledevelopment.Fragments.Calender;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.transition.Scene;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;

import com.example.projectmobiledevelopment.Fragments.MainActivity;
import com.example.projectmobiledevelopment.R;

import java.util.Calendar;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalenderFragment extends Fragment {

    private Button btnNotify;
    private Button btnTodo;
    private Button btnList;
    private CalendarView calendar;

    private Bundle args;

    private MainActivity mainActivity;

    enum FragmentView {
        NOTIFY,
        TODO,
        LIST
    }

    FragmentView scene;


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

        // bundle
        args = new Bundle();

        args.putInt("year", Calendar.getInstance().get(Calendar.YEAR));
        args.putInt("month", Calendar.getInstance().get(Calendar.MONTH));
        args.putInt("day", Calendar.getInstance().get(Calendar.DAY_OF_MONTH));

        // getting the enum for scene
        scene = FragmentView.TODO;

        // getting the activity
        mainActivity = ((MainActivity) getActivity());

        List<String> items = mainActivity.db.getTodoList(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        mainActivity.todolist = items;

        CalenderTodoFragment input = new CalenderTodoFragment();
        input.setArguments(args);

        FragmentTransaction fragmentTransaction = mainActivity.fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.calender_container, input)
                .commit();

        // calendar onchange ...
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {

                // putting the date
                args.putInt("year", year);
                args.putInt("month", month);
                args.putInt("day", dayOfMonth);

                //putting the todolist
               List<String> items = mainActivity.db.getTodoList(year, month, dayOfMonth);
               mainActivity.todolist = items;

               CalenderTodoFragment input = new CalenderTodoFragment();
               input.setArguments(args);

                if (scene == FragmentView.TODO) {
                    FragmentTransaction fragmentTransaction = mainActivity.fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.calender_container, input)
                            .commit();

                } else if(scene != FragmentView.NOTIFY) {

                } else {

                }
            }
        });

        //setting onclick on the buttons
        btnNotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scene = FragmentView.NOTIFY;
                FragmentTransaction fragmentTransaction = mainActivity.fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.calender_container, new NotifyCalenderFragment())
                        .commit();
            }
        });

        btnTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scene = FragmentView.TODO;
                FragmentTransaction fragmentTransaction = mainActivity.fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.calender_container, new CalenderTodoFragment(), null)
                        .commit();
            }
        });
        return v;
    }

}
