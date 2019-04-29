package com.example.projectmobiledevelopment.Fragments.Calender.Todo;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.projectmobiledevelopment.Classes.RecAdapter;
import com.example.projectmobiledevelopment.Classes.TodoAdapter;
import com.example.projectmobiledevelopment.Fragments.MainActivity;
import com.example.projectmobiledevelopment.R;

import java.time.Year;
import java.util.Calendar;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CalenderTodoFragment extends Fragment {

    private RecyclerView ra;
    private MainActivity mainActivity;
    private TextView date;

    private Button btnAddPage;

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

        // button add page
        btnAddPage = v.findViewById(R.id.btn_todo_add_page);


        // gets the arguments
        if(getArguments() != null && getArguments().containsKey("year")) {
            year = getArguments().getInt("year");
            month = getArguments().getInt("month");
            day = getArguments().getInt("day");
        }


        // gets the mainactivity
        mainActivity = ((MainActivity) getActivity());

    //    mainActivity.todolist = mainActivity.db.getTodoList(year, month, day);

        date.setText("Date: " + day + "/" + month + "/" + year);

        ra = v.findViewById(R.id.recycler_todo);
        ra.setLayoutManager(new LinearLayoutManager(getActivity()));
        final List<String> liste = mainActivity.db.getTodoList(year, month, day);
        TodoAdapter rv = new TodoAdapter(liste);
        ra.setAdapter(rv);

        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
                int position = viewHolder.getAdapterPosition();
                String target = liste.get(position);
                mainActivity.db.deleteTodoItem(year,month,day,target);
                liste.remove(position);
                ra.setAdapter(new TodoAdapter(liste));

            }

        });
        helper.attachToRecyclerView(ra);

        btnAddPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();
                bundle.putInt("year", year);
                bundle.putInt("month", month);
                bundle.putInt("day", day);

                TodoAddFragment input = new TodoAddFragment();
                input.setArguments(bundle);
                FragmentTransaction fragmentTransaction = mainActivity.fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.calender_container, input, null)
                        .commit();
            }
        });

        return v;
    }

}
