package com.ibrahim.egyadv_task.util;

import android.app.ProgressDialog;
import android.content.Context;

public class Views {

    public static ProgressDialog getProgressDialog(Context context, String msg) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(msg);
        progressDialog.setCancelable(false);
        return progressDialog;
    }

}
