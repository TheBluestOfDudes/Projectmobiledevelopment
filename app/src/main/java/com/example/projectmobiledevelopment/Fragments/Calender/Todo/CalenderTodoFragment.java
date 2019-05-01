package com.example.projectmobiledevelopment.Fragments.Calender.Todo;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorSpace;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
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

            @Override
            public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
                if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
                    // Get RecyclerView item from the ViewHolder
                    View itemView = viewHolder.itemView;

                    Paint p = new Paint();
                    if (dX > 0) {
                        /* Set your color for positive displacement */
                        p.setColor(Color.parseColor("#ff0000"));
                        // Draw Rect with varying right side, equal to displacement dX
                        c.drawRect((float) itemView.getLeft(), (float) itemView.getTop(), dX,
                                (float) itemView.getBottom(), p);
                        Drawable d = getResources().getDrawable(R.drawable.ic_swipe_delete, null);
                        if (dX < 140 ){
                            c.drawRect((float) itemView.getLeft(), (float) itemView.getTop(), dX,
                                    (float) itemView.getBottom(), p);
                            d.setBounds(itemView.getLeft(), itemView.getTop(), (int)dX, itemView.getBottom());
                        } else {
                            d.setBounds(itemView.getLeft(), itemView.getTop(), 140, itemView.getBottom());
                        }
                        d.draw(c);
                    } else {
                        /* Set your color for negative displacement */
                        p.setColor(Color.parseColor("#ff0000"));

                        // Draw Rect with varying left side, equal to the item's right side plus negative displacement dX
                        c.drawRect((float) itemView.getRight() + dX, (float) itemView.getTop(),
                                (float) itemView.getRight(), (float) itemView.getBottom(), p);
                    }

                    super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
                }
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
