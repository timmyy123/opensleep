package com.urbandroid.sleep.share;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import com.urbandroid.common.connectivity.IProgress;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.Environment;
import com.urbandroid.sleep.PendingIntentBuilder;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.notification.NotificationsKt;
import com.urbandroid.util.ColorUtil;
import java.io.IOException;
import java.net.Socket;

/* JADX INFO: loaded from: classes5.dex */
public abstract class WaitForConnectivityService extends Service {
    private BroadcastReceiver cancelReceiver;
    private NotificationCompat.Builder notificationBuilderProgress;
    private Intent startIntent;
    private boolean connectivity = false;
    private boolean cancelled = false;
    private boolean progressReceiverRegistered = false;
    BroadcastReceiver progressReceiver = new BroadcastReceiver() { // from class: com.urbandroid.sleep.share.WaitForConnectivityService.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || !WaitForConnectivityService.this.getProgressIntent().equals(intent.getAction()) || WaitForConnectivityService.this.notificationBuilderProgress == null) {
                return;
            }
            WaitForConnectivityService.this.parseProgressIntent(intent);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void cancelOperation() {
        this.cancelled = true;
        removeCancelReceiver();
        onCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkInternetReachable() throws Throwable {
        Socket socket;
        Throwable th;
        Socket socket2 = null;
        try {
            socket = new Socket("www.google.com", 80);
            try {
                Logger.logInfo("Reachability confirmed");
                try {
                    socket.close();
                } catch (IOException unused) {
                }
                return true;
            } catch (Exception unused2) {
                socket2 = socket;
                if (socket2 != null) {
                    try {
                        socket2.close();
                    } catch (IOException unused3) {
                    }
                }
                Logger.logInfo("Internet not reachable.");
                return false;
            } catch (Throwable th2) {
                th = th2;
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception unused5) {
        } catch (Throwable th3) {
            socket = null;
            th = th3;
        }
    }

    public static boolean isRequiredNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable() || !activeNetworkInfo.isConnected() || activeNetworkInfo.isRoaming()) {
            return false;
        }
        if (activeNetworkInfo.getType() == 1 || Environment.isIcsOrGreater()) {
            return true;
        }
        return connectivityManager.getBackgroundDataSetting();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performRechabilityCheck() {
        final Context applicationContext = getApplicationContext();
        new AsyncTask<Void, Void, Boolean>() { // from class: com.urbandroid.sleep.share.WaitForConnectivityService.3
            @Override // android.os.AsyncTask
            public Boolean doInBackground(Void... voidArr) {
                try {
                    Thread.sleep(1000L);
                    return Boolean.valueOf(WaitForConnectivityService.this.checkInternetReachable());
                } catch (InterruptedException unused) {
                    return Boolean.FALSE;
                }
            }

            @Override // android.os.AsyncTask
            public void onPostExecute(Boolean bool) {
                Intent intent = new Intent("com.urbandroid.common.connectivity.AVAILABILITY_CHECK");
                intent.putExtra("STATUS", bool);
                applicationContext.sendBroadcast(intent);
            }
        }.execute(new Void[0]);
    }

    private void removeCancelReceiver() {
        BroadcastReceiver broadcastReceiver = this.cancelReceiver;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
            this.cancelReceiver = null;
        }
    }

    private void startForeground() {
        startForeground(394720902, new NotificationCompat.Builder(this, "servicesChannel").setSmallIcon(getNotificationIcon()).setColor(getNotificationColor()).setContentIntent(PendingIntentBuilder.get(this, 0, new Intent("com.urbandroid.common.connectivity.CANCEL_NETWORK_WAITING"), 0).getExplicitBroadcast()).setContentTitle(getNotificationTitleMessage()).setContentText(getNotificationWaitingMessage()).build());
        Logger.logDebug("ForegroundService[" + getClass().getSimpleName() + "]: startForeground called with id: 394720902");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateToProgressNotification() {
        int notificationIcon = getNotificationIcon();
        String progressIntent = getProgressIntent();
        if (progressIntent != null) {
            this.progressReceiverRegistered = true;
            ContextCompat.registerReceiver(this, this.progressReceiver, new IntentFilter(progressIntent), 2);
        }
        NotificationCompat.Builder progress = new NotificationCompat.Builder(this, "servicesChannel").setSmallIcon(notificationIcon).setColor(getNotificationColor()).setContentIntent(PendingIntentBuilder.get(this, 0, new Intent("com.urbandroid.common.connectivity.CANCEL_NETWORK_WAITING"), 0).getExplicitBroadcast()).setContentTitle(getNotificationTitleMessage()).setContentText(getNotificationProgressMessage()).setProgress(100, 0, true);
        this.notificationBuilderProgress = progress;
        NotificationsKt.notify(this, 394720902, progress.build());
    }

    public int getNotificationColor() {
        return ColorUtil.i(this, R.color.tint_notification);
    }

    public abstract int getNotificationIcon();

    public abstract String getNotificationProgressMessage();

    public abstract String getNotificationTitleMessage();

    public abstract String getNotificationWaitingMessage();

    public String getProgressIntent() {
        return null;
    }

    public synchronized boolean hasConnectivity() {
        return this.connectivity;
    }

    public void initializeContextIfNeeded() {
    }

    public boolean isConnectivityNeeded() {
        return true;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCancelled() {
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        Logger.logInfo("Destroying back-up service");
        if (this.progressReceiverRegistered) {
            unregisterReceiver(this.progressReceiver);
        }
        removeCancelReceiver();
    }

    @Override // android.app.Service
    public void onStart(final Intent intent, int i) {
        super.onStart(intent, i);
        this.startIntent = intent;
        initializeContextIfNeeded();
        if (shouldIgnoreRequest()) {
            Logger.logInfo("Ignoring wait for connectivity request.");
            return;
        }
        this.cancelled = false;
        if (!isConnectivityNeeded()) {
            stopSelf();
            return;
        }
        Logger.logSevere("Starting wait for connectivity service");
        startForeground();
        final IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("com.urbandroid.common.connectivity.CANCEL_NETWORK_WAITING");
        intentFilter.addAction("com.urbandroid.common.connectivity.AVAILABILITY_CHECK");
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.urbandroid.sleep.share.WaitForConnectivityService.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent2) {
                if (WaitForConnectivityService.this.hasConnectivity()) {
                    return;
                }
                if (intent2.getAction().equals("com.urbandroid.common.connectivity.CANCEL_NETWORK_WAITING")) {
                    WaitForConnectivityService.this.setConnectivity();
                    WaitForConnectivityService.this.unregisterReceiver(this);
                    WaitForConnectivityService.this.stopSelf();
                    return;
                }
                if (!intent2.getAction().equals("com.urbandroid.common.connectivity.AVAILABILITY_CHECK") || !intent2.getBooleanExtra("STATUS", false)) {
                    if (WaitForConnectivityService.isRequiredNetworkAvailable(context)) {
                        WaitForConnectivityService.this.performRechabilityCheck();
                        return;
                    }
                    return;
                }
                Logger.logInfo("Connectivity available doing job. Unregistering receiver.");
                WaitForConnectivityService.this.updateToProgressNotification();
                WaitForConnectivityService.this.setConnectivity();
                if (WaitForConnectivityService.this.cancelReceiver == null) {
                    WaitForConnectivityService.this.cancelReceiver = new BroadcastReceiver() { // from class: com.urbandroid.sleep.share.WaitForConnectivityService.1.1
                        @Override // android.content.BroadcastReceiver
                        public void onReceive(Context context2, Intent intent3) {
                            if (intent3.getAction().equals("com.urbandroid.common.connectivity.CANCEL_NETWORK_WAITING")) {
                                WaitForConnectivityService.this.cancelOperation();
                            }
                        }
                    };
                    WaitForConnectivityService waitForConnectivityService = WaitForConnectivityService.this;
                    ContextCompat.registerReceiver(waitForConnectivityService, waitForConnectivityService.cancelReceiver, intentFilter, 2);
                }
                WaitForConnectivityService.this.unregisterReceiver(this);
                new Thread() { // from class: com.urbandroid.sleep.share.WaitForConnectivityService.1.2
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        WaitForConnectivityService.this.performWork(intent);
                    }
                }.start();
            }
        };
        Logger.logInfo("Registering wait for network receiver");
        ContextCompat.registerReceiver(this, broadcastReceiver, intentFilter, 2);
    }

    public IProgress parseProgressIntent(Intent intent) {
        return null;
    }

    public abstract void performWork(Intent intent);

    public synchronized void setConnectivity() {
        this.connectivity = true;
    }

    public boolean shouldIgnoreRequest() {
        return false;
    }
}
