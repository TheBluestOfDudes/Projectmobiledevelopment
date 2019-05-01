package com.example.projectmobiledevelopment.Utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;

public class BitmapConverter {

    public static byte[] toBytes(Bitmap b){
        if(b != null){
            ByteArrayOutputStream s = new ByteArrayOutputStream();
            b.compress(Bitmap.CompressFormat.JPEG,100, s);
            return s.toByteArray();
        }
        else{
            return null;
        }
    }

    public static Bitmap toBitmap(byte[] b){
        if(b != null){
            return BitmapFactory.decodeByteArray(b, 0, b.length);
        }
        else{
            return null;
        }
    }
}
