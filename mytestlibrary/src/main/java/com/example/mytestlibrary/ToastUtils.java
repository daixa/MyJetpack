package com.example.mytestlibrary;

import android.content.Context;
import android.widget.Toast;

public class ToastUtils {
    private static Toast toast;

    public static void ShowToast(Context context, CharSequence charSequence) {
        if (toast == null) {
            toast = Toast.makeText(context, charSequence, Toast.LENGTH_SHORT);
        } else {
            toast.setText(charSequence);
        }
        toast.show();
    }
}
