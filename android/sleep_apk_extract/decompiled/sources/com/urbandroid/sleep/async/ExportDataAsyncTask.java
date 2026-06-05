package com.urbandroid.sleep.async;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.ShareCompat;
import androidx.core.content.FileProvider;
import com.facebook.internal.NativeProtocol;
import com.facebook.login.LoginFragment$$ExternalSyntheticLambda0;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.persistence.Export;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.util.SleepPermissionCompat;
import java.io.File;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class ExportDataAsyncTask extends AbstractProgressAsyncTask<Void, Void, Void> {
    private Activity context;
    private Export export;
    private boolean zipped;

    public ExportDataAsyncTask(ProgressContext progressContext, Activity activity) {
        super(progressContext, activity);
        this.zipped = false;
        this.export = new Export();
        this.context = activity;
        if (progressContext != null) {
            progressContext.initHorizontalProgress(SharedApplicationContext.getInstance().getSleepRecordRepository().getSleepRecordsCount());
        }
    }

    private File getExportedFile() {
        boolean z = this.zipped;
        Activity activity = this.context;
        return new File(z ? Export.getExportZipFilePath(activity) : Export.getExportFilePath(activity));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$performInBackground$0(int i, SleepRecord sleepRecord) {
        ProgressContext progressContext = this.progressContext;
        if (progressContext != null) {
            progressContext.updateProgress(i);
        }
    }

    @Override // com.urbandroid.sleep.async.AbstractProgressAsyncTask
    public void decorateAfterDialog(MaterialAlertDialogBuilder materialAlertDialogBuilder) {
        super.decorateAfterDialog(materialAlertDialogBuilder);
        final File exportedFile = getExportedFile();
        Logger.logInfo("Export file " + exportedFile);
        if (isSuccess() && exportedFile.exists()) {
            materialAlertDialogBuilder.setNeutralButton(R.string.share_android, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.async.ExportDataAsyncTask.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Uri uriForFile = FileProvider.getUriForFile(ExportDataAsyncTask.this.context, "com.urbandroid.sleep.fileprovider", exportedFile);
                    Intent intentCreateChooser = Intent.createChooser(ShareCompat.IntentBuilder.from(ExportDataAsyncTask.this.context).setStream(uriForFile).setType(ExportDataAsyncTask.this.zipped ? "application/zip" : "text/plain").getIntent().addFlags(1), ExportDataAsyncTask.this.context.getString(R.string.share_android));
                    Iterator<ResolveInfo> it = ExportDataAsyncTask.this.context.getPackageManager().queryIntentActivities(intentCreateChooser, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST).iterator();
                    while (it.hasNext()) {
                        ExportDataAsyncTask.this.context.grantUriPermission(it.next().activityInfo.packageName, uriForFile, 1);
                    }
                    ExportDataAsyncTask.this.context.startActivity(intentCreateChooser);
                }
            });
        }
    }

    @Override // com.urbandroid.sleep.async.AbstractProgressAsyncTask
    public String getFailedString() {
        return getContext().getResources().getString(R.string.export_failed) + " " + getExportedFile();
    }

    @Override // com.urbandroid.sleep.async.AbstractProgressAsyncTask
    public String getMessage() {
        return getContext().getString(R.string.exporting);
    }

    @Override // com.urbandroid.sleep.async.AbstractProgressAsyncTask
    public String getSuccessString() {
        return getContext().getResources().getString(R.string.export_success) + " " + getExportedFile();
    }

    @Override // com.urbandroid.sleep.async.AbstractProgressAsyncTask, android.os.AsyncTask
    public void onPostExecute(Void r1) {
        super.onPostExecute(r1);
        ProgressContext progressContext = this.progressContext;
        if (progressContext != null) {
            progressContext.initIndeterminateProgress();
        }
    }

    @Override // com.urbandroid.sleep.async.AbstractProgressAsyncTask, android.os.AsyncTask
    public void onPreExecute() {
        super.onPreExecute();
        if (Build.VERSION.SDK_INT < 33) {
            SleepPermissionCompat sleepPermissionCompat = SleepPermissionCompat.INSTANCE;
            if (sleepPermissionCompat.isPermissionGranted(this.context, "android.permission.WRITE_EXTERNAL_STORAGE") && sleepPermissionCompat.isPermissionGranted(this.context, "android.permission.READ_EXTERNAL_STORAGE")) {
                return;
            }
            sleepPermissionCompat.requestPermissions(this.context, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 3943);
        }
    }

    @Override // com.urbandroid.sleep.async.AbstractProgressAsyncTask
    public Void performInBackground() {
        this.export.exportData(getContext(), new LoginFragment$$ExternalSyntheticLambda0(this, 25), this.zipped);
        return null;
    }

    public ExportDataAsyncTask zipped() {
        this.zipped = true;
        return this;
    }
}
