package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbhu {
    zzbem zza;
    boolean zzb;
    private final ExecutorService zzc;

    public zzbhu(final Context context) {
        ExecutorService executorService = com.google.android.gms.ads.internal.util.client.zzb.zzb;
        this.zzc = executorService;
        executorService.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbhq
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzge)).booleanValue();
                Context context2 = context;
                zzbhu zzbhuVar = this.zza;
                if (zBooleanValue) {
                    try {
                        zzbhuVar.zza = (zzbem) com.google.android.gms.ads.internal.util.client.zzs.zza(context2, "com.google.android.gms.ads.clearcut.DynamiteClearcutLogger", zzbhr.zza);
                        zzbhuVar.zza.zze(ObjectWrapper.wrap(context2), "GMA_SDK");
                        zzbhuVar.zzb = true;
                    } catch (RemoteException | com.google.android.gms.ads.internal.util.client.zzr | NullPointerException unused) {
                        com.google.android.gms.ads.internal.util.client.zzo.zzd("Cannot dynamite load clearcut");
                    }
                }
            }
        });
    }

    public final /* synthetic */ ExecutorService zza() {
        return this.zzc;
    }

    public zzbhu() {
        this.zzc = com.google.android.gms.ads.internal.util.client.zzb.zzb;
    }
}
