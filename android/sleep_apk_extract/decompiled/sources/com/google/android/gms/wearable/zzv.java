package com.google.android.gms.wearable;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
final class zzv extends com.google.android.gms.internal.wearable.zzq {
    final /* synthetic */ WearableListenerService zza;
    private boolean zzb;
    private final zzu zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzv(WearableListenerService wearableListenerService, Looper looper) {
        super(looper);
        Objects.requireNonNull(wearableListenerService);
        this.zza = wearableListenerService;
        this.zzc = new zzu(wearableListenerService, null);
    }

    private final synchronized void zzc() {
        try {
            if (this.zzb) {
                return;
            }
            if (Log.isLoggable("WearableLS", 2)) {
                Log.v("WearableLS", "bindService: ".concat(String.valueOf(this.zza.zza())));
            }
            WearableListenerService wearableListenerService = this.zza;
            wearableListenerService.bindService(wearableListenerService.zzd(), this.zzc, 1);
            this.zzb = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    private final synchronized void zzd(String str) {
        if (this.zzb) {
            if (Log.isLoggable("WearableLS", 2)) {
                WearableListenerService wearableListenerService = this.zza;
                int length = str.length();
                String strValueOf = String.valueOf(wearableListenerService.zza());
                StringBuilder sb = new StringBuilder(length + 17 + strValueOf.length());
                sb.append("unbindService: ");
                sb.append(str);
                sb.append(", ");
                sb.append(strValueOf);
                Log.v("WearableLS", sb.toString());
            }
            try {
                this.zza.unbindService(this.zzc);
            } catch (RuntimeException e) {
                Log.e("WearableLS", "Exception when unbinding from local service", e);
            }
            this.zzb = false;
        }
    }

    @Override // com.google.android.gms.internal.wearable.zzq
    public final void zza(Message message) {
        zzc();
        try {
            super.zza(message);
            if (hasMessages(0)) {
                return;
            }
            zzd("dispatch");
        } catch (Throwable th) {
            if (!hasMessages(0)) {
                zzd("dispatch");
            }
            throw th;
        }
    }

    public final void zzb() {
        WearableListenerService wearableListenerService = this.zza;
        if (wearableListenerService.zze() == null) {
            getLooper().quit();
        } else {
            wearableListenerService.zze().quitSafely();
            try {
                wearableListenerService.zze().join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                Log.e("WearableLS", "Failed to join serviceHandlerThread", e);
            }
            this.zza.zzf(null);
        }
        zzd("quit");
    }
}
