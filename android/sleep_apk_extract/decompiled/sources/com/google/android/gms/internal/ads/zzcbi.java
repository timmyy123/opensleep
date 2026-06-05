package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
final class zzcbi implements Callable {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzcbk zzb;

    public zzcbi(zzcbk zzcbkVar, Context context) {
        this.zza = context;
        Objects.requireNonNull(zzcbkVar);
        this.zzb = zzcbkVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0038  */
    @Override // java.util.concurrent.Callable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* bridge */ /* synthetic */ Object call() {
        zzcbh zzcbhVarZza;
        zzcbk zzcbkVar = this.zzb;
        WeakHashMap weakHashMapZzb = zzcbkVar.zzb();
        Context context = this.zza;
        zzcbj zzcbjVar = (zzcbj) weakHashMapZzb.get(context);
        if (zzcbjVar != null) {
            zzcbhVarZza = zzcbjVar.zza + ((Long) zzbkf.zzd.zze()).longValue() < com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis() ? new zzcbg(context).zza() : new zzcbg(context, zzcbjVar.zzb).zza();
        }
        zzcbkVar.zzb().put(context, new zzcbj(zzcbkVar, zzcbhVarZza));
        return zzcbhVarZza;
    }
}
