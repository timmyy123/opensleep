package com.urbandroid.sleep.async;

import android.app.Activity;
import android.content.Context;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.persistence.Export;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ImportDataAsyncTask extends AbstractProgressAsyncTask<Void, Void, Void> {
    private final Context context;
    private final Export export;
    private final Runnable onPostExecute;
    private final List<Export.Type> types;
    private String uri;
    private boolean zipped;

    public ImportDataAsyncTask(ProgressContext progressContext, Context context, Runnable runnable) {
        super(progressContext, context);
        this.zipped = false;
        this.types = new ArrayList(Arrays.asList(Export.Type.Records));
        this.export = new Export();
        this.onPostExecute = runnable;
        this.context = context;
    }

    private void lockScreenOrientation(Activity activity) {
        try {
            if (this.context.getResources().getConfiguration().orientation == 1) {
                activity.setRequestedOrientation(1);
            } else {
                activity.setRequestedOrientation(0);
            }
        } catch (Exception e) {
            Logger.logSevere(e);
        }
    }

    private void unlockScreenOrientation(Activity activity) {
        try {
            activity.setRequestedOrientation(4);
        } catch (Exception e) {
            Logger.logSevere(e);
        }
    }

    @Override // com.urbandroid.sleep.async.AbstractProgressAsyncTask
    public String getFailedString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getContext().getResources().getString(R.string.import_failed));
        sb.append(" ");
        String str = this.uri;
        if (str == null) {
            str = "/sleep-data/sleep-export.csv";
        }
        sb.append(str);
        return sb.toString();
    }

    @Override // com.urbandroid.sleep.async.AbstractProgressAsyncTask
    public String getMessage() {
        return getContext().getString(R.string.importing);
    }

    @Override // com.urbandroid.sleep.async.AbstractProgressAsyncTask
    public String getSuccessString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getContext().getString(R.string.import_success));
        sb.append(" ");
        String strConcat = this.uri;
        if (strConcat == null) {
            strConcat = "/sleep-data/".concat(this.zipped ? "sleep-export.zip" : "sleep-export.csv");
        }
        sb.append(strConcat);
        return sb.toString();
    }

    @Override // com.urbandroid.sleep.async.AbstractProgressAsyncTask
    public boolean noMessage() {
        return false;
    }

    @Override // com.urbandroid.sleep.async.AbstractProgressAsyncTask, android.os.AsyncTask
    public void onPostExecute(Void r3) {
        Context context = this.context;
        if (context instanceof Activity) {
            unlockScreenOrientation((Activity) context);
        }
        ProgressContext progressContext = this.progressContext;
        if (progressContext != null) {
            progressContext.initIndeterminateProgress();
        }
        super.onPostExecute(r3);
        Runnable runnable = this.onPostExecute;
        if (runnable != null) {
            runnable.run();
        }
        zza$$ExternalSyntheticOutline0.m(this.context, "com.urbandroid.sleep.alarmclock.IMPORT_DONE");
    }

    @Override // com.urbandroid.sleep.async.AbstractProgressAsyncTask, android.os.AsyncTask
    public void onPreExecute() {
        try {
            this.progressContext.initHorizontalProgress(this.export.countRecords(this.context, this.uri, this.zipped));
        } catch (IOException e) {
            Logger.logWarning("count record failed", e);
        }
        super.onPreExecute();
        Context context = this.context;
        if (context instanceof Activity) {
            lockScreenOrientation((Activity) context);
        }
    }

    @Override // com.urbandroid.sleep.async.AbstractProgressAsyncTask
    public Void performInBackground() throws Exception {
        Export.ProgressListener progressListener = new Export.ProgressListener() { // from class: com.urbandroid.sleep.async.ImportDataAsyncTask.1
            @Override // com.urbandroid.sleep.persistence.Export.ProgressListener
            public void recordProcessed(int i, SleepRecord sleepRecord) {
                ProgressContext progressContext = ImportDataAsyncTask.this.progressContext;
                if (progressContext != null) {
                    progressContext.updateProgress(i);
                }
            }
        };
        Logger.logDebug("Import background - zipped: " + this.zipped + " uri: " + this.uri);
        boolean z = this.zipped;
        Export export = this.export;
        if (!z) {
            export.importRecordCsvData(this.context, this.uri, progressListener);
            this.export.importNoise(this.context);
            return null;
        }
        if (export.importZipData(this.context, this.uri, this.types, progressListener)) {
            return null;
        }
        Logger.logSevere("Import failed");
        throw new Exception("Import failed");
    }

    public ImportDataAsyncTask withTypes(List<Export.Type> list) {
        this.types.clear();
        this.types.addAll(list);
        return this;
    }

    public ImportDataAsyncTask withUri(String str) {
        this.uri = str;
        return this;
    }

    public ImportDataAsyncTask zipped() {
        this.zipped = true;
        return this;
    }
}
