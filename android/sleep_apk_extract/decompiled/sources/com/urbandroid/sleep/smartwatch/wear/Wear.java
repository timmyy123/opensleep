package com.urbandroid.sleep.smartwatch.wear;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.Wearable;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.smartwatch.IConnectivityCallback;
import com.urbandroid.sleep.smartwatch.IntentBasedConnectivityChecker;
import com.urbandroid.sleep.smartwatch.SmartWatch;
import com.urbandroid.sleep.smartwatch.SmartWatchListener;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
public class Wear implements SmartWatch {
    private WearAccelManager accelManager;
    private Context context;
    private boolean doHrMonitoring;
    private boolean doOximeter;
    private MessageApi.MessageListener messageListener;
    private GoogleApiClient messageReceiveClient;

    public Wear(Context context) {
        this.doHrMonitoring = false;
        this.doOximeter = false;
        this.context = context;
        this.accelManager = new WearAccelManager(context);
        this.doHrMonitoring = new Settings(context).isHrWear();
        this.doOximeter = new Settings(context).isOximeterWatch();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unregisterMessageListener() {
        if (this.messageListener != null) {
            Logger.logInfo("WEAR Unregistering message listener");
            Wearable.MessageApi.removeListener(this.messageReceiveClient, this.messageListener);
            this.messageListener = null;
        }
    }

    public void asyncConnectionCheck(IConnectivityCallback iConnectivityCallback, long j) {
        new IntentBasedConnectivityChecker(this.context, iConnectivityCallback, this, new Runnable() { // from class: com.urbandroid.sleep.smartwatch.wear.Wear.1
            @Override // java.lang.Runnable
            public void run() {
                new SendMessageTemplate(Wear.this.context, "/sleep/checkConnectivity").execute();
            }
        }, "com.ubandroid.sleep.smartwatch.wear.ACTION_HAS_CONNECTIVITY", j, 5000L, TrialFilter.getInstance().isPebble() ? 5000L : 0L);
    }

    public void confirm() {
        new SendMessageTemplate(this.context, "/sleep/confirm").execute();
    }

    public void confirmOnPhone() {
        new SendMessageTemplate(this.context, "/sleep/confirmOnPhone").execute();
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public String getPlatform() {
        return "WEAR";
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void hint(int i) {
        new SendMessageTemplate(this.context, "/sleep/hint").setPayload(new byte[]{(byte) i}).execute();
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void setBatchSize(int i) {
        new SendMessageTemplate(this.context, "/sleep/batchSize").setPayload(new byte[]{(byte) i}).execute();
        if (this.doHrMonitoring) {
            new SendMessageTemplate(this.context, "/sleep/doHrMonitoring").execute();
        }
        if (this.doOximeter) {
            new SendMessageTemplate(this.context, "/sleep/doOximeter").execute();
        }
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void setSuspended(boolean z) {
        new SendMessageTemplate(this.context, "/sleep/suspendStatus").setPayload(new byte[]{z ? (byte) 1 : (byte) 0}).execute();
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void startAlarm(int i) {
        new SendMessageTemplate(this.context, "/sleep/startAlarm").setPayload(ByteBuffer.allocate(4).putInt(i).array()).execute();
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void startTracking(SmartWatchListener smartWatchListener) {
        Logger.logInfo("WEAR Start tracking");
        new SendMessageTemplate(this.context, "/sleep/startWatchApp").execute();
        GoogleApiClient googleApiClientBuild = new GoogleApiClient.Builder(this.context).addApi(Wearable.API).build();
        this.messageReceiveClient = googleApiClientBuild;
        googleApiClientBuild.registerConnectionCallbacks(new GoogleApiClient.ConnectionCallbacks() { // from class: com.urbandroid.sleep.smartwatch.wear.Wear.2
            @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
            public void onConnected(Bundle bundle) {
                Logger.logInfo("WEAR Registering message listener");
                Wear.this.messageListener = new MessageApi.MessageListener() { // from class: com.urbandroid.sleep.smartwatch.wear.Wear.2.1
                    @Override // com.google.android.gms.wearable.MessageApi.MessageListener
                    public void onMessageReceived(MessageEvent messageEvent) {
                    }
                };
                Wearable.MessageApi.addListener(Wear.this.messageReceiveClient, Wear.this.messageListener);
            }

            @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
            public void onConnectionSuspended(int i) {
                Wear.this.unregisterMessageListener();
            }
        });
        if (this.doHrMonitoring) {
            new SendMessageTemplate(this.context, "/sleep/doHrMonitoring").execute();
        }
        if (this.doOximeter) {
            new SendMessageTemplate(this.context, "/sleep/doOximeter").execute();
        }
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void stopAlarm() {
        Logger.logInfo("WEAR: stop alarm");
        new SendMessageTemplate(this.context, "/sleep/stopAlarm").execute();
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void stopTracking() {
        new SendMessageTemplate(this.context, "/sleep/stopWatchApp").execute();
        unregisterMessageListener();
        GoogleApiClient googleApiClient = this.messageReceiveClient;
        if (googleApiClient != null) {
            googleApiClient.disconnect();
        }
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void updateAlarm(long j) {
        new SendMessageTemplate(this.context, "/sleep/alarmTs").setPayload(ByteBuffer.allocate(8).putLong(j).array()).execute();
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void updatePause(long j) {
        new SendMessageTemplate(this.context, "/sleep/suspendTill").setPayload(ByteBuffer.allocate(8).putLong(j).array()).execute();
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public WearAccelManager getAccelManager() {
        return this.accelManager;
    }
}
