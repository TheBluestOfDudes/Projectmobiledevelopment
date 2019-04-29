package com.example.projectmobiledevelopment.Fragments.Calender;


import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.projectmobiledevelopment.Fragments.MainActivity;
import com.example.projectmobiledevelopment.NotificationReceiver;
import com.example.projectmobiledevelopment.R;
import com.example.projectmobiledevelopment.Utils.ErrorByUser;

import java.util.Calendar;
import java.util.Date;

import static com.example.projectmobiledevelopment.BaseApplication.app.CHANNEL_1_ID;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotifyCalenderFragment extends Fragment {

    private NotificationManagerCompat notificationManager;
    private Button channel1;

    private EditText title;
    private EditText description;
    private EditText hours;
    private EditText minuttes;

    private TextView header;

    private MainActivity mainActivity;
    private ErrorByUser error;

    private int year;
    private int month;
    private int day;


    public NotifyCalenderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View v = inflater.inflate(R.layout.fragment_notify_calender, container, false);

        mainActivity = (MainActivity) getActivity();
        error = new ErrorByUser();

        title = v.findViewById(R.id.notify_title);
        description = v.findViewById(R.id.notify_description);
        hours = v.findViewById(R.id.notify_hours);
        minuttes = v.findViewById(R.id.notify_minuttes);
        header = v.findViewById(R.id.textview_notification);

        if(getArguments() != null && getArguments().containsKey("year")) {
            year = getArguments().getInt("year");
            month = getArguments().getInt("month");
            day = getArguments().getInt("day");
        }

        channel1 = v.findViewById(R.id.btn_channel1);
        header.setText("Set Notification for:" + year + "/" + month + "/" + day);

        channel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View l) {
                Boolean ok = true;
                if(error.registerNotFilledRequiredFields((ViewGroup) v)) {
                    scheduleNotification(sendOnChannel1());
                }
            }
        });

        notificationManager = NotificationManagerCompat.from(getContext());
        return v;
    }

    public Notification sendOnChannel1() {
        Notification notification = new NotificationCompat.Builder(getActivity(), CHANNEL_1_ID)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle(title.getText().toString())
                .setContentText(description.getText().toString())
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        return notification;
    }

    public void scheduleNotification(Notification notification) {
        Intent notificationIntent = new Intent(getActivity(), NotificationReceiver.class);
        notificationIntent.putExtra("test", notification);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getActivity(), 1, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);


        Calendar g = Calendar.getInstance();
        g.set(year,month, day, Integer.parseInt(hours.getText().toString()),Integer.parseInt(minuttes.getText().toString()));

        long diff = g.getTime().getTime() - System.currentTimeMillis();
        long realdate = System.currentTimeMillis() + diff;
        Log.d("miliiii", "scheduleNotification: " + diff + " | " + realdate + " | " + g.getTime().getTime() + " | " + System.currentTimeMillis());

        AlarmManager alarmManager = (AlarmManager)mainActivity.getSystemService(Context.ALARM_SERVICE);
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, realdate, pendingIntent);

    }

}
