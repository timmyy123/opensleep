package com.urbandroid.sleep.service;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.view.View;
import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetView;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;

/* JADX INFO: loaded from: classes4.dex */
public class SyncShowcaseViewAsyncTask extends AsyncTask<Void, Void, Integer> {
    private final Activity activity;
    private final IntegrationApp app;
    private final long synchronizeFromInMillis;

    public enum IntegrationApp {
        Google_Fit,
        Google_Calendar,
        Samsung_SHealth,
        Health_Connect;

        public boolean finishIfNoRecords() {
            return this != Google_Calendar;
        }

        public boolean isFirstLaunch(Context context) {
            Settings settings = new Settings(context);
            if (settings.isFirstUsage(this)) {
                return !settings.isShowCaseShown(name());
            }
            settings.addShowCaseShown(name());
            settings.clearFirstUsage(this);
            return false;
        }
    }

    public SyncShowcaseViewAsyncTask(Activity activity, IntegrationApp integrationApp, long j) {
        this.activity = activity;
        this.app = integrationApp;
        this.synchronizeFromInMillis = j;
    }

    @Override // android.os.AsyncTask
    public Integer doInBackground(Void... voidArr) {
        if (this.app.isFirstLaunch(this.activity.getApplicationContext())) {
            return Integer.valueOf(SharedApplicationContext.getInstance().getSleepRecordRepository().getSleepRecordsCount(this.synchronizeFromInMillis));
        }
        return null;
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Integer num) {
        String string;
        if (num == null) {
            return;
        }
        if (num.intValue() < 1 && this.app.finishIfNoRecords()) {
            Logger.logDebug("No records, finish()");
            this.activity.finish();
            return;
        }
        Resources resources = this.activity.getResources();
        new Settings(this.activity.getApplicationContext()).addShowCaseShown(this.app.name());
        Activity activity = this.activity;
        View viewFindViewById = activity.findViewById(R.id.sync);
        String string2 = resources.getString(R.string.menu_upload_cloud);
        if (num.intValue() == 0) {
            string = "";
        } else {
            string = resources.getString(R.string.synchronize, num + " " + resources.getString(R.string.graphs).toLowerCase());
        }
        TapTargetView.showFor(activity, TapTarget.forView(viewFindViewById, string2, string).dimColor(R.color.transparent_black).outerCircleColor(R.color.tap_target_color).textColor(R.color.primary).tintTarget(false).cancelable(true), new TapTargetView.Listener() { // from class: com.urbandroid.sleep.service.SyncShowcaseViewAsyncTask.1
            @Override // com.getkeepsafe.taptargetview.TapTargetView.Listener
            public void onTargetCancel(TapTargetView tapTargetView) {
                super.onTargetCancel(tapTargetView);
                Logger.logInfo("Cancel");
            }

            @Override // com.getkeepsafe.taptargetview.TapTargetView.Listener
            public void onTargetClick(TapTargetView tapTargetView) {
                super.onTargetClick(tapTargetView);
                Logger.logInfo("Click");
            }
        });
    }
}
