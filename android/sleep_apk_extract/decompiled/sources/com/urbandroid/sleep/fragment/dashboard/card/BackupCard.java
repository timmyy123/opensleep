package com.urbandroid.sleep.fragment.dashboard.card;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.alarmclock.AlarmClock;
import com.urbandroid.sleep.async.ImportDataAsyncTask;
import com.urbandroid.sleep.async.ProgressContext;
import com.urbandroid.sleep.fragment.dashboard.card.DashboardCard;
import com.urbandroid.sleep.persistence.Export;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public class BackupCard extends DashboardCard<BackupViewHolder> {

    public class BackupViewHolder extends LayeredViewHolder {
        public BackupViewHolder(View view) {
            super(view);
        }
    }

    public interface ImportFinishListener {
        void onFinished();
    }

    public BackupCard(Activity activity) {
        super(activity, DashboardCard.Type.BACKUP, R.layout.card_backup);
    }

    public static void importData(Activity activity, ImportFinishListener importFinishListener) {
        TrialFilter.getInstance().reevaluate();
        if (!TrialFilter.getInstance().isAddonImport()) {
            importDataLocally(activity, importFinishListener);
            return;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setComponent(new ComponentName("com.urbandroid.sleep.addon.port", "com.urbandroid.sleep.addon.port.PullActivity"));
        try {
            activity.startActivityForResult(intent, 765);
        } catch (Exception e) {
            importDataLocally(activity, importFinishListener);
            Logger.logSevere(e);
        }
    }

    private static void importDataLocally(Activity activity, final ImportFinishListener importFinishListener) {
        if (!TrialFilter.getInstance().isTrial() || TrialFilter.getInstance().getVersion() == TrialFilter.Version.FULL || TrialFilter.getInstance().isAddonImport()) {
            new ImportDataAsyncTask(new ProgressContext(activity), activity, new Runnable() { // from class: com.urbandroid.sleep.fragment.dashboard.card.BackupCard.2
                @Override // java.lang.Runnable
                public void run() {
                    ImportFinishListener importFinishListener2 = importFinishListener;
                    if (importFinishListener2 != null) {
                        importFinishListener2.onFinished();
                    }
                }
            }).zipped().execute(new Void[0]);
        } else if (activity instanceof AlarmClock) {
            ((AlarmClock) activity).showPurchaseDialog();
        }
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void bindView(final BackupViewHolder backupViewHolder) {
        TrialFilter.getInstance().reevaluate();
        if (TrialFilter.getInstance().isAddonImport()) {
            ((TextView) backupViewHolder.itemView.findViewById(R.id.text)).setText(R.string.menu_download_cloud);
        } else {
            setCardVisibility(getContext(), (ViewGroup) backupViewHolder.itemView, false);
            new AsyncTask<Void, Void, Integer>() { // from class: com.urbandroid.sleep.fragment.dashboard.card.BackupCard.3
                @Override // android.os.AsyncTask
                public Integer doInBackground(Void... voidArr) {
                    try {
                        return Integer.valueOf(new Export().countRecords(BackupCard.this.getContext()));
                    } catch (IOException e) {
                        Logger.logSevere(e);
                        return 0;
                    }
                }

                @Override // android.os.AsyncTask
                public void onPostExecute(Integer num) {
                    if (num.intValue() > 0) {
                        BackupCard backupCard = BackupCard.this;
                        backupCard.setCardVisibility(backupCard.getContext(), (ViewGroup) backupViewHolder.itemView, true);
                        ((TextView) backupViewHolder.itemView.findViewById(R.id.text)).setText(BackupCard.this.getContext().getString(R.string.menu_import) + " (" + BackupCard.this.getContext().getString(R.string.displaying_records_count, num) + ")");
                    }
                }
            }.execute(new Void[0]);
        }
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public BackupViewHolder createViewHolder(View view) {
        return new BackupViewHolder(view);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public int getNameResource() {
        return R.string.backup;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public boolean isThemeCard() {
        return false;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void onCardClicked(View view) {
        importData(getContext(), new ImportFinishListener() { // from class: com.urbandroid.sleep.fragment.dashboard.card.BackupCard.1
            @Override // com.urbandroid.sleep.fragment.dashboard.card.BackupCard.ImportFinishListener
            public void onFinished() {
                BackupCard.this.reloadAll();
            }
        });
    }
}
