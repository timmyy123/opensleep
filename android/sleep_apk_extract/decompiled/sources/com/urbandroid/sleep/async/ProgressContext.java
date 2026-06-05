package com.urbandroid.sleep.async;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.gui.dialog.DialogUtil;
import java.util.Stack;

/* JADX INFO: loaded from: classes4.dex */
public class ProgressContext {
    private Activity activity;
    private boolean activityStopped;
    private AlertDialog afterDialog;
    private final boolean cancellable;
    private Context context;
    private Stack<String> messageStack;
    private ProgressDialog progressDialog;
    private int runningTasks;

    public ProgressContext(Activity activity, boolean z) {
        this.runningTasks = 0;
        this.messageStack = new Stack<>();
        this.activityStopped = false;
        this.context = activity.getApplicationContext();
        this.activity = activity;
        this.cancellable = z;
        ProgressDialog progressDialog = new ProgressDialog(activity);
        this.progressDialog = progressDialog;
        progressDialog.setOwnerActivity(activity);
        this.progressDialog.setCancelable(z);
        this.progressDialog.setIndeterminate(true);
    }

    public synchronized void activityStop() {
        try {
            this.activityStopped = true;
            this.runningTasks = 0;
            ProgressDialog progressDialog = this.progressDialog;
            if (progressDialog != null && progressDialog.isShowing()) {
                this.progressDialog.dismiss();
            }
            AlertDialog alertDialog = this.afterDialog;
            if (alertDialog != null && alertDialog.isShowing()) {
                this.afterDialog.dismiss();
            }
            this.progressDialog = null;
            this.afterDialog = null;
            this.messageStack.clear();
            this.context = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public void initHorizontalProgress(int i) {
        ProgressDialog progressDialog = this.progressDialog;
        if (progressDialog != null) {
            progressDialog.setProgressStyle(1);
            this.progressDialog.setIndeterminate(false);
            this.progressDialog.setProgress(0);
            this.progressDialog.setMax(i);
        }
    }

    public void initIndeterminateProgress() {
        ProgressDialog progressDialog = this.progressDialog;
        if (progressDialog != null) {
            progressDialog.setIndeterminate(true);
        }
    }

    public boolean isCancelable() {
        return this.cancellable;
    }

    public void setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        this.progressDialog.setOnCancelListener(onCancelListener);
    }

    public synchronized void start(AbstractProgressAsyncTask abstractProgressAsyncTask) {
        try {
            if (this.activityStopped) {
                return;
            }
            this.messageStack.push(abstractProgressAsyncTask.getMessage());
            if (this.runningTasks == 0) {
                this.progressDialog.show();
            }
            this.progressDialog.setMessage(abstractProgressAsyncTask.getMessage());
            this.runningTasks++;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void stop(AbstractProgressAsyncTask abstractProgressAsyncTask) {
        if (this.activityStopped) {
            return;
        }
        this.messageStack.remove(abstractProgressAsyncTask.getMessage());
        int i = this.runningTasks - 1;
        this.runningTasks = i;
        ProgressDialog progressDialog = this.progressDialog;
        if (i < 1) {
            if (progressDialog != null && progressDialog.isShowing()) {
                try {
                    this.progressDialog.dismiss();
                } catch (Exception e) {
                    Logger.logSevere(e);
                }
            }
        }
        if (progressDialog != null && progressDialog.isShowing()) {
            this.progressDialog.setMessage(this.messageStack.peek());
        }
        if (abstractProgressAsyncTask.getAfterMessage() != null) {
            MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(this.activity);
            materialAlertDialogBuilder.setPositiveButton(R.string.button_ok, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.async.ProgressContext.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                }
            });
            abstractProgressAsyncTask.decorateAfterDialog(materialAlertDialogBuilder);
            AlertDialog alertDialogCreate = materialAlertDialogBuilder.create();
            this.afterDialog = alertDialogCreate;
            alertDialogCreate.setOwnerActivity(this.activity);
            this.afterDialog.setMessage(abstractProgressAsyncTask.getAfterMessage());
            if (!this.afterDialog.isShowing()) {
                try {
                    this.afterDialog.show();
                    DialogUtil.fixDivider(this.afterDialog);
                } catch (Exception e2) {
                    Logger.logSevere(e2);
                }
            }
        }
    }

    public void updateProgress(int i) {
        ProgressDialog progressDialog = this.progressDialog;
        if (progressDialog != null) {
            progressDialog.setProgress(i);
        }
    }

    public ProgressContext(Activity activity) {
        this(activity, false);
    }
}
