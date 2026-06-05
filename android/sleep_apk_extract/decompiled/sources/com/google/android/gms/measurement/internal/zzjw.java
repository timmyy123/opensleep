package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.util.SparseArray;
import com.google.common.util.concurrent.FutureCallback;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
final class zzjw implements FutureCallback {
    final /* synthetic */ zzoh zza;
    final /* synthetic */ zzlj zzb;

    public zzjw(zzlj zzljVar, zzoh zzohVar) {
        this.zza = zzohVar;
        Objects.requireNonNull(zzljVar);
        this.zzb = zzljVar;
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public final void onFailure(Throwable th) {
        zzlj zzljVar = this.zzb;
        zzljVar.zzg();
        zzljVar.zzal(false);
        zzljVar.zzx().add(this.zza);
        if (zzljVar.zzam() > ((Integer) zzfy.zzav.zzb(null)).intValue()) {
            zzljVar.zzan(1);
            zzljVar.zzu.zzaW().zze().zzc("registerTriggerAsync failed. May try later. App ID, throwable", zzgu.zzl(zzljVar.zzu.zzv().zzj()), zzgu.zzl(th.toString()));
        } else {
            zzljVar.zzu.zzaW().zze().zzd("registerTriggerAsync failed. App ID, delay in seconds, throwable", zzgu.zzl(zzljVar.zzu.zzv().zzj()), zzgu.zzl(String.valueOf(zzljVar.zzam())), zzgu.zzl(th.toString()));
            zzljVar.zzah(zzljVar.zzam());
            int iZzam = zzljVar.zzam();
            zzljVar.zzan(iZzam + iZzam);
        }
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public final void onSuccess(Object obj) {
        zzlj zzljVar = this.zzb;
        zzljVar.zzg();
        zzic zzicVar = zzljVar.zzu;
        SparseArray sparseArrayZzf = zzicVar.zzd().zzf();
        zzoh zzohVar = this.zza;
        sparseArrayZzf.put(zzohVar.zzc, Long.valueOf(zzohVar.zzb));
        zzhh zzhhVarZzd = zzicVar.zzd();
        int[] iArr = new int[sparseArrayZzf.size()];
        long[] jArr = new long[sparseArrayZzf.size()];
        for (int i = 0; i < sparseArrayZzf.size(); i++) {
            iArr[i] = sparseArrayZzf.keyAt(i);
            jArr[i] = ((Long) sparseArrayZzf.valueAt(i)).longValue();
        }
        Bundle bundle = new Bundle();
        bundle.putIntArray("uriSources", iArr);
        bundle.putLongArray("uriTimestamps", jArr);
        zzhhVarZzd.zzi.zzb(bundle);
        zzljVar.zzal(false);
        zzljVar.zzan(1);
        zzicVar.zzaW().zzj().zzb("Successfully registered trigger URI", zzohVar.zza);
        zzljVar.zzy();
    }
}
