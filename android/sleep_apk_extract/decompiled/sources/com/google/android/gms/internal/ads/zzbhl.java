package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbhl {
    private zzbha zza;
    private boolean zzb;
    private final Context zzc;
    private final Object zzd = new Object();

    public zzbhl(Context context) {
        this.zzc = context;
    }

    public final Future zza(zzbhb zzbhbVar) {
        zzbhf zzbhfVar = new zzbhf(this);
        zzbhj zzbhjVar = new zzbhj(this, zzbhbVar, zzbhfVar);
        zzbhk zzbhkVar = new zzbhk(this, zzbhfVar);
        synchronized (this.zzd) {
            zzbha zzbhaVar = new zzbha(this.zzc, com.google.android.gms.ads.internal.zzt.zzs().zza(), zzbhjVar, zzbhkVar);
            this.zza = zzbhaVar;
            zzbhaVar.checkAvailabilityAndConnect();
        }
        return zzbhfVar;
    }

    public final /* synthetic */ void zzb() {
        synchronized (this.zzd) {
            try {
                zzbha zzbhaVar = this.zza;
                if (zzbhaVar == null) {
                    return;
                }
                zzbhaVar.disconnect();
                this.zza = null;
                Binder.flushPendingCommands();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final /* synthetic */ zzbha zzc() {
        return this.zza;
    }

    public final /* synthetic */ boolean zzd() {
        return this.zzb;
    }

    public final /* synthetic */ void zze(boolean z) {
        this.zzb = true;
    }

    public final /* synthetic */ Object zzf() {
        return this.zzd;
    }
}
