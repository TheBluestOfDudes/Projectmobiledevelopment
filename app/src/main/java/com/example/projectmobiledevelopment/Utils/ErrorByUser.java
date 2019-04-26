package com.example.projectmobiledevelopment.Utils;

import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class ErrorByUser {

    public boolean registerNotFilledRequiredFields(ViewGroup container) {
        int count = container.getChildCount();
        boolean ok = true;
        for (int i = 0; i < count; i++) {
            View v = container.getChildAt(i);
            if (v instanceof EditText) {
                if (((EditText) v).getText().toString().isEmpty()) {
                    ((EditText) v).setError("Requiered field");
                    ok = false;
                }
            } else if (v instanceof ViewGroup) {
                //recurse through children
                registerNotFilledRequiredFields((ViewGroup) v);
            }
        }
        return ok;
    }
}
