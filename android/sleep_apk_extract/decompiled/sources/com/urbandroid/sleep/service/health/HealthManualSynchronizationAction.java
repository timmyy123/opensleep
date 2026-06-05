package com.urbandroid.sleep.service.health;

import android.app.Activity;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;
import com.urbandroid.common.ProgressBarJoiner;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.service.SyncShowcaseViewAsyncTask;
import com.urbandroid.sleep.service.google.calendar.api.SleepCalendarNotFoundException;
import com.urbandroid.sleep.service.google.fit.GoogleFitNotAvailableException;
import com.urbandroid.sleep.service.health.HealthSynchronization;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes5.dex */
public abstract class HealthManualSynchronizationAction {
    private final Activity activity;
    private final HealthServiceProvider provider;
    private HealthSynchronization<?> synchronization;
    private AtomicBoolean isRunning = new AtomicBoolean(false);
    private Calendar synchronizationFromDate = Calendar.getInstance();

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.health.HealthManualSynchronizationAction$2, reason: invalid class name */
    public class AnonymousClass2 extends AsyncTask<Void, Progress, Boolean> {
        final /* synthetic */ Snackbar val$cancelSnackbar;
        final /* synthetic */ boolean val$importMode;
        final /* synthetic */ ProgressBar val$progressBar;
        final /* synthetic */ ProgressBarJoiner val$progressBarJoiner;

        public AnonymousClass2(ProgressBar progressBar, boolean z, Snackbar snackbar, ProgressBarJoiner progressBarJoiner) {
            this.val$progressBar = progressBar;
            this.val$importMode = z;
            this.val$cancelSnackbar = snackbar;
            this.val$progressBarJoiner = progressBarJoiner;
        }

        @Override // android.os.AsyncTask
        public Boolean doInBackground(Void... voidArr) {
            Calendar calendar = HealthManualSynchronizationAction.this.synchronizationFromDate;
            HealthSynchronization.ProgressListener progressListener = new HealthSynchronization.ProgressListener() { // from class: com.urbandroid.sleep.service.health.HealthManualSynchronizationAction.2.1
                private int phase = 0;
                private boolean updateProgress = false;

                @Override // com.urbandroid.sleep.service.health.HealthSynchronization.ProgressListener
                public void end(HealthServiceProvider healthServiceProvider, HealthSynchronization.ProgressListener.Event event) {
                    if (this.updateProgress) {
                        int i = 0;
                        AnonymousClass2.this.publishProgress(new Progress(this.phase, -1, i, i));
                        this.updateProgress = false;
                        this.phase++;
                    }
                }

                @Override // com.urbandroid.sleep.service.health.HealthSynchronization.ProgressListener
                public void progress(HealthServiceProvider healthServiceProvider, int i, int i2) {
                    if (this.updateProgress) {
                        AnonymousClass2.this.publishProgress(new Progress(this.phase, i, i2, 0));
                    }
                }

                @Override // com.urbandroid.sleep.service.health.HealthSynchronization.ProgressListener
                public void start(HealthServiceProvider healthServiceProvider, HealthSynchronization.ProgressListener.Event event, int i) {
                    this.updateProgress = HealthManualSynchronizationAction.this.isUpdateProgressEvent(event);
                }

                @Override // com.urbandroid.sleep.service.health.HealthSynchronization.ProgressListener
                public void start(HealthServiceProvider healthServiceProvider) {
                    this.updateProgress = false;
                }

                @Override // com.urbandroid.sleep.service.health.HealthSynchronization.ProgressListener
                public void end(HealthServiceProvider healthServiceProvider) {
                    if (HealthManualSynchronizationAction.this.hideProgressBarAndSnackBarOnEnd()) {
                        HealthManualSynchronizationAction.this.activity.runOnUiThread(new Runnable() { // from class: com.urbandroid.sleep.service.health.HealthManualSynchronizationAction.2.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (AnonymousClass2.this.val$cancelSnackbar.isShown()) {
                                    AnonymousClass2.this.val$cancelSnackbar.dismiss();
                                }
                                AnonymousClass2.this.val$progressBarJoiner.hide();
                            }
                        });
                    }
                }
            };
            Logger.logInfo(HealthManualSynchronizationAction.this.provider.getName() + " starting Sync sessions ...");
            HealthManualSynchronizationAction healthManualSynchronizationAction = HealthManualSynchronizationAction.this;
            if (!healthManualSynchronizationAction.preSynchronization(healthManualSynchronizationAction.activity)) {
                return Boolean.FALSE;
            }
            try {
                HealthManualSynchronizationAction.this.synchronization.synchronize(calendar.getTime(), progressListener);
            } catch (SleepCalendarNotFoundException unused) {
                Logger.logWarning("Google Calendar with name Sleep not found");
                return Boolean.FALSE;
            } catch (GoogleFitNotAvailableException e) {
                Logger.logSevere(HealthManualSynchronizationAction.this.provider.getName() + " sync failure", e);
            } catch (HealthSynchronizationInterruptedException unused2) {
                Logger.logInfo(HealthManualSynchronizationAction.this.provider.getName() + " sync was interrupted");
            } catch (SecurityException e2) {
                Logger.logSevere("S Health security issue.", e2);
                return Boolean.FALSE;
            }
            return Boolean.TRUE;
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            HealthManualSynchronizationAction.this.isRunning.set(false);
            HealthManualSynchronizationAction healthManualSynchronizationAction = HealthManualSynchronizationAction.this;
            if (healthManualSynchronizationAction.postSynchronization(healthManualSynchronizationAction.activity, bool.booleanValue())) {
                HealthManualSynchronizationAction.this.activity.finish();
            }
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            this.val$progressBar.setVisibility(0);
            this.val$progressBar.setIndeterminate(false);
            HealthManualSynchronizationAction healthManualSynchronizationAction = HealthManualSynchronizationAction.this;
            healthManualSynchronizationAction.synchronization = healthManualSynchronizationAction.prepareSynchronization();
            HealthManualSynchronizationAction.this.synchronization.setManual(true);
            HealthManualSynchronizationAction.this.synchronization.setImportMode(this.val$importMode);
            HealthManualSynchronizationAction.this.isRunning.set(true);
        }

        @Override // android.os.AsyncTask
        public void onProgressUpdate(Progress... progressArr) {
            super.onProgressUpdate((Object[]) progressArr);
            ProgressBarJoiner progressBarJoiner = this.val$progressBarJoiner;
            Progress progress = progressArr[0];
            progressBarJoiner.update(progress.phase, progress.value, progress.max);
        }
    }

    public HealthManualSynchronizationAction(Activity activity, HealthServiceProvider healthServiceProvider) {
        this.activity = activity;
        this.provider = healthServiceProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isConnected() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.activity.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sync(boolean z, ProgressBar progressBar, Snackbar snackbar, ProgressBarJoiner progressBarJoiner) {
        snackbar.show();
        new AnonymousClass2(progressBar, z, snackbar, progressBarJoiner).execute(new Void[0]);
    }

    public boolean hideProgressBarAndSnackBarOnEnd() {
        return true;
    }

    public HealthManualSynchronizationAction init() {
        return this;
    }

    public abstract boolean isUpdateProgressEvent(HealthSynchronization.ProgressListener.Event event);

    public boolean postSynchronization(Activity activity, boolean z) {
        return true;
    }

    public boolean preSynchronization(Activity activity) {
        return true;
    }

    public abstract ProgressBarJoiner prepareProgressBarJoiner(ProgressBar progressBar);

    public abstract HealthSynchronization<?> prepareSynchronization();

    public HealthManualSynchronizationAction setIsRunningHolder(AtomicBoolean atomicBoolean) {
        this.isRunning = atomicBoolean;
        return this;
    }

    public void show(SyncShowcaseViewAsyncTask.IntegrationApp integrationApp) {
        if (integrationApp != null) {
            new SyncShowcaseViewAsyncTask(this.activity, integrationApp, this.synchronizationFromDate.getTimeInMillis()).execute(new Void[0]);
        }
        final ProgressBar progressBar = (ProgressBar) this.activity.findViewById(R.id.progress);
        progressBar.setVisibility(8);
        final View viewFindViewById = this.activity.findViewById(R.id.sync);
        viewFindViewById.setVisibility(0);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.service.health.HealthManualSynchronizationAction.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                boolean zIsConnected = HealthManualSynchronizationAction.this.isConnected();
                HealthManualSynchronizationAction healthManualSynchronizationAction = HealthManualSynchronizationAction.this;
                if (!zIsConnected) {
                    Toast.makeText(healthManualSynchronizationAction.activity.getApplicationContext(), R.string.no_connection, 0).show();
                    return;
                }
                final Snackbar action = Snackbar.make(healthManualSynchronizationAction.activity.findViewById(R.id.root_main), R.string.please_wait_long, -2).setAction(R.string.menu_stop, new View.OnClickListener() { // from class: com.urbandroid.sleep.service.health.HealthManualSynchronizationAction.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (HealthManualSynchronizationAction.this.synchronization != null) {
                            HealthManualSynchronizationAction.this.synchronization.interrupt();
                        }
                        HealthManualSynchronizationAction.this.activity.finish();
                    }
                });
                viewFindViewById.setVisibility(8);
                final ProgressBarJoiner progressBarJoinerPrepareProgressBarJoiner = HealthManualSynchronizationAction.this.prepareProgressBarJoiner(progressBar);
                if (SharedApplicationContext.getInstance().getSleepRecordRepository().getSleepRecordsCount() != 0 || (!HealthManualSynchronizationAction.this.provider.isGoogleFit() && !HealthManualSynchronizationAction.this.provider.isSamsungSHealth())) {
                    HealthManualSynchronizationAction.this.sync(false, progressBar, action, progressBarJoinerPrepareProgressBarJoiner);
                } else {
                    HealthManualSynchronizationAction.this.provider.setCachedRecordCount(0);
                    new MaterialAlertDialogBuilder(HealthManualSynchronizationAction.this.activity).setTitle((CharSequence) HealthManualSynchronizationAction.this.activity.getString(R.string.dialog_import_from_service, HealthManualSynchronizationAction.this.activity.getString(HealthManualSynchronizationAction.this.provider.getTitleRes()))).setNegativeButton(R.string.button_cancel, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.service.health.HealthManualSynchronizationAction.1.3
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            viewFindViewById.setVisibility(0);
                        }
                    }).setPositiveButton(R.string.button_ok, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.service.health.HealthManualSynchronizationAction.1.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            HealthManualSynchronizationAction.this.sync(true, progressBar, action, progressBarJoinerPrepareProgressBarJoiner);
                        }
                    }).show();
                }
            }
        });
    }

    public HealthManualSynchronizationAction synchronizationFromDate(Calendar calendar) {
        this.synchronizationFromDate = calendar;
        return this;
    }

    public static class Progress {
        int max;
        int phase;
        int value;

        private Progress(int i, int i2, int i3) {
            this.phase = i;
            this.value = i2;
            this.max = i3;
        }

        public /* synthetic */ Progress(int i, int i2, int i3, int i4) {
            this(i, i2, i3);
        }
    }
}
