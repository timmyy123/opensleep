package com.urbandroid.sleep.async;

import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.urbandroid.common.logging.Logger;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractProgressAsyncTask<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {
    private Context context;
    protected ProgressContext progressContext;
    private boolean success = true;

    public AbstractProgressAsyncTask(ProgressContext progressContext, Context context) {
        this.context = context.getApplicationContext();
        this.progressContext = progressContext;
        if (progressContext == null || !progressContext.isCancelable()) {
            return;
        }
        progressContext.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.urbandroid.sleep.async.AbstractProgressAsyncTask.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                AbstractProgressAsyncTask.this.cancel(true);
            }
        });
    }

    public void decorateAfterDialog(MaterialAlertDialogBuilder materialAlertDialogBuilder) {
    }

    @Override // android.os.AsyncTask
    public Result doInBackground(Object... objArr) {
        try {
            try {
                return performInBackground();
            } catch (Exception e) {
                Logger.logSevere(e);
                this.success = false;
                if (this.progressContext == null) {
                    return null;
                }
                this.progressContext.updateProgress(0);
                return null;
            }
        } finally {
            ProgressContext progressContext = this.progressContext;
            if (progressContext != null) {
                progressContext.updateProgress(0);
            }
        }
    }

    public String getAfterMessage() {
        if (noMessage()) {
            return null;
        }
        return !this.success ? getFailedString() : getSuccessString();
    }

    public Context getContext() {
        return this.context;
    }

    public String getFailedString() {
        return null;
    }

    public abstract String getMessage();

    public String getSuccessString() {
        return null;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public boolean noMessage() {
        return false;
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Result result) {
        super.onPostExecute(result);
        ProgressContext progressContext = this.progressContext;
        if (progressContext != null) {
            progressContext.stop(this);
        }
        this.progressContext = null;
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        super.onPreExecute();
        ProgressContext progressContext = this.progressContext;
        if (progressContext != null) {
            progressContext.start(this);
        }
    }

    public abstract Result performInBackground();
}
