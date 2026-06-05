package com.google.android.gms.wearable;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.ChannelApi;
import com.google.android.gms.wearable.ChannelClient;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.MessageClient;
import com.google.android.gms.wearable.internal.zzba;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class WearableListenerService extends Service implements DataApi.DataListener, MessageApi.MessageListener, CapabilityApi.CapabilityListener, ChannelApi.ChannelListener, MessageClient.RpcService {
    private ComponentName zza;
    private zzv zzb;
    private IBinder zzc;
    private Intent zzd;
    private HandlerThread zze;
    private boolean zzg;
    private final Object zzf = new Object();
    private final zzba zzh = new zzba(new zzt(this, null));

    public Looper getLooper() {
        if (this.zze == null) {
            HandlerThread handlerThread = new HandlerThread("WearableListenerService");
            handlerThread.start();
            this.zze = handlerThread;
        }
        return this.zze.getLooper();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0018, code lost:
    
        if (r0.equals("com.google.android.gms.wearable.BIND_LISTENER") != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0021, code lost:
    
        if (r0.equals("com.google.android.gms.wearable.CHANNEL_EVENT") != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002a, code lost:
    
        if (r0.equals("com.google.android.gms.wearable.DATA_CHANGED") != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0033, code lost:
    
        if (r0.equals("com.google.android.gms.wearable.NODE_MIGRATED") != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003c, code lost:
    
        if (r0.equals("com.google.android.gms.wearable.MESSAGE_RECEIVED") != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0045, code lost:
    
        if (r0.equals("com.google.android.gms.wearable.REQUEST_RECEIVED") != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004e, code lost:
    
        if (r0.equals("com.google.android.gms.wearable.CAPABILITY_CHANGED") != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0052, code lost:
    
        return r2.zzc;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // android.app.Service
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final IBinder onBind(Intent intent) {
        String action;
        if (intent == null || (action = intent.getAction()) == null) {
            return null;
        }
        switch (action.hashCode()) {
            case -1487371046:
                break;
            case -1140095138:
                break;
            case -786751258:
                break;
            case 705066793:
                break;
            case 915816236:
                break;
            case 1003809169:
                break;
            case 1460975593:
                break;
            default:
                if (!Log.isLoggable("WearableLS", 3)) {
                    return null;
                }
                String string = intent.toString();
                StringBuilder sb = new StringBuilder(string.length() + 46);
                sb.append("onBind: Provided bind intent (");
                sb.append(string);
                sb.append(") is not allowed");
                Log.d("WearableLS", sb.toString());
                return null;
        }
    }

    @Override // com.google.android.gms.wearable.CapabilityApi.CapabilityListener
    public void onCapabilityChanged(CapabilityInfo capabilityInfo) {
    }

    @Override // com.google.android.gms.wearable.ChannelApi.ChannelListener
    public void onChannelClosed(Channel channel, int i, int i2) {
    }

    @Override // com.google.android.gms.wearable.ChannelApi.ChannelListener
    public void onChannelOpened(Channel channel) {
    }

    public void onConnectedNodes(List<Node> list) {
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.zza = new ComponentName(this, getClass().getName());
        if (Log.isLoggable("WearableLS", 3)) {
            Log.d("WearableLS", "onCreate: ".concat(String.valueOf(this.zza)));
        }
        this.zzb = new zzv(this, getLooper());
        Intent intent = new Intent("com.google.android.gms.wearable.BIND_LISTENER");
        this.zzd = intent;
        intent.setComponent(this.zza);
        this.zzc = new zzai(this);
    }

    @Override // com.google.android.gms.wearable.DataApi.DataListener
    public void onDataChanged(DataEventBuffer dataEventBuffer) {
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (Log.isLoggable("WearableLS", 3)) {
            Log.d("WearableLS", "onDestroy: ".concat(String.valueOf(this.zza)));
        }
        synchronized (this.zzf) {
            this.zzg = true;
            zzv zzvVar = this.zzb;
            if (zzvVar == null) {
                String strValueOf = String.valueOf(this.zza);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 111);
                sb.append("onDestroy: mServiceHandler not set, did you override onCreate() but forget to call super.onCreate()? component=");
                sb.append(strValueOf);
                throw new IllegalStateException(sb.toString());
            }
            zzvVar.zzb();
        }
        super.onDestroy();
    }

    public void onEntityUpdate(zza zzaVar) {
    }

    @Override // com.google.android.gms.wearable.ChannelApi.ChannelListener
    public void onInputClosed(Channel channel, int i, int i2) {
    }

    @Override // com.google.android.gms.wearable.MessageApi.MessageListener
    public void onMessageReceived(MessageEvent messageEvent) {
    }

    public void onNodeMigrated(String str, DataItemBuffer dataItemBuffer) {
    }

    public void onNotificationReceived(zzb zzbVar) {
    }

    @Override // com.google.android.gms.wearable.ChannelApi.ChannelListener
    public void onOutputClosed(Channel channel, int i, int i2) {
    }

    public void onPeerConnected(Node node) {
    }

    public void onPeerDisconnected(Node node) {
    }

    @Override // com.google.android.gms.wearable.MessageClient.RpcService
    public Task<byte[]> onRequest(String str, String str2, byte[] bArr) {
        return null;
    }

    public final /* synthetic */ ComponentName zza() {
        return this.zza;
    }

    public final /* synthetic */ zzv zzb() {
        return this.zzb;
    }

    public final /* synthetic */ IBinder zzc() {
        return this.zzc;
    }

    public final /* synthetic */ Intent zzd() {
        return this.zzd;
    }

    public final /* synthetic */ HandlerThread zze() {
        return this.zze;
    }

    public final /* synthetic */ void zzf(HandlerThread handlerThread) {
        this.zze = null;
    }

    public final /* synthetic */ Object zzg() {
        return this.zzf;
    }

    public final /* synthetic */ boolean zzh() {
        return this.zzg;
    }

    public final /* synthetic */ zzba zzi() {
        return this.zzh;
    }

    public void onChannelClosed(ChannelClient.Channel channel, int i, int i2) {
    }

    public void onChannelOpened(ChannelClient.Channel channel) {
    }

    public void onInputClosed(ChannelClient.Channel channel, int i, int i2) {
    }

    public void onOutputClosed(ChannelClient.Channel channel, int i, int i2) {
    }
}
