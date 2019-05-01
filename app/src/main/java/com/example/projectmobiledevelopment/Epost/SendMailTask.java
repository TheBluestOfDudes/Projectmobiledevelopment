package com.example.projectmobiledevelopment.Epost;

import android.os.AsyncTask;

import java.util.List;

import android.app.Activity;
import android.util.Log;

public class SendMailTask extends AsyncTask {

    private Activity sendMailActivity;

    public SendMailTask(Activity activity) {
        sendMailActivity = activity;

    }

    protected void onPreExecute() {

    }

    @Override
    protected Object doInBackground(Object... args) {
        try {
            Log.i("SendMailTask", "About to instantiate GMail...");
            GMail androidEmail = new GMail(args[0].toString(),
                    args[1].toString(), args[2].toString(), args[3].toString(),
                    args[4].toString());
            androidEmail.createEmailMessage();
            androidEmail.sendEmail();
            Log.i("SendMailTask", "Mail Sent.");
        } catch (Exception e) {
            Log.e("SendMailTask", e.getMessage(), e);
        }
        return null;
    }


}
