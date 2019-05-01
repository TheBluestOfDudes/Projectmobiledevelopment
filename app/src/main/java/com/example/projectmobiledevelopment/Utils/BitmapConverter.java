package com.example.projectmobiledevelopment.Utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

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

            Bitmap bitmap = (BitmapFactory.decodeByteArray(b, 0, b.length));
            Bitmap im = bitmap.copy(bitmap.getConfig(),true);
            return im;
        }
        else{
            return null;
        }
    }
}
