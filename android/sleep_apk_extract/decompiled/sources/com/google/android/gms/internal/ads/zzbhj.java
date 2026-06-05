package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzbhj implements BaseGmsClient.BaseConnectionCallbacks {
    final /* synthetic */ zzbhb zza;
    final /* synthetic */ zzcfw zzb;
    final /* synthetic */ zzbhl zzc;

    public zzbhj(zzbhl zzbhlVar, zzbhb zzbhbVar, zzcfw zzcfwVar) {
        this.zza = zzbhbVar;
        this.zzb = zzcfwVar;
        Objects.requireNonNull(zzbhlVar);
        this.zzc = zzbhlVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        zzbhl zzbhlVar = this.zzc;
        synchronized (zzbhlVar.zzf()) {
            try {
                if (zzbhlVar.zzd()) {
                    return;
                }
                zzbhlVar.zze(true);
                final zzbha zzbhaVarZzc = zzbhlVar.zzc();
                if (zzbhaVarZzc == null) {
                    return;
                }
                zzhcg zzhcgVar = zzcfr.zza;
                final zzbhb zzbhbVar = this.zza;
                final zzcfw zzcfwVar = this.zzb;
                final ListenableFuture listenableFutureZza = zzhcgVar.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbhi
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzcfw zzcfwVar2 = zzcfwVar;
                        zzbha zzbhaVar = zzbhaVarZzc;
                        zzbhj zzbhjVar = this.zza;
                        try {
                            zzbhd zzbhdVarZzq = zzbhaVar.zzq();
                            boolean zZzp = zzbhaVar.zzp();
                            zzbhb zzbhbVar2 = zzbhbVar;
                            zzbgy zzbgyVarZzf = zZzp ? zzbhdVarZzq.zzf(zzbhbVar2) : zzbhdVarZzq.zze(zzbhbVar2);
                            if (!zzbgyVarZzf.zza()) {
                                zzcfwVar2.zzd(new RuntimeException("No entry contents."));
                                zzbhjVar.zzc.zzb();
                                return;
                            }
                            zzbhg zzbhgVar = new zzbhg(zzbhjVar, zzbgyVarZzf.zzb(), 1);
                            int i = zzbhgVar.read();
                            if (i == -1) {
                                throw new IOException("Unable to read from cache.");
                            }
                            zzbhgVar.unread(i);
                            zzcfwVar2.zzc(zzbhn.zza(zzbhgVar, zzbgyVarZzf.zzd(), zzbgyVarZzf.zzg(), zzbgyVarZzf.zzf(), zzbgyVarZzf.zze()));
                        } catch (RemoteException e) {
                            e = e;
                            Throwable th = e;
                            int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                            com.google.android.gms.ads.internal.util.client.zzo.zzg("Unable to obtain a cache service instance.", th);
                            zzcfwVar2.zzd(th);
                            zzbhjVar.zzc.zzb();
                        } catch (IOException e2) {
                            e = e2;
                            Throwable th2 = e;
                            int i22 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                            com.google.android.gms.ads.internal.util.client.zzo.zzg("Unable to obtain a cache service instance.", th2);
                            zzcfwVar2.zzd(th2);
                            zzbhjVar.zzc.zzb();
                        }
                    }
                });
                zzcfwVar.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbhh
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        if (zzcfwVar.isCancelled()) {
                            listenableFutureZza.cancel(true);
                        }
                    }
                }, zzcfr.zzh);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
    }
}
