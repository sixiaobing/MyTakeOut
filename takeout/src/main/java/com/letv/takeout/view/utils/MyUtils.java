package com.letv.takeout.view.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by 10198 on 2017/6/15.
 */

public class MyUtils {
    public static Toast mToast;
    public static void showToast(Context context, String msg, int duration) {
        if (mToast == null) {
            mToast = Toast.makeText(context, msg, duration);
        } else {
            mToast.setText(msg);
        }
        mToast.show();
    }
}

