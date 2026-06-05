package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class zzkh implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzlj zzb;

    public zzkh(zzlj zzljVar, long j) {
        this.zza = j;
        Objects.requireNonNull(zzljVar);
        this.zzb = zzljVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzlj zzljVar = this.zzb;
        zzljVar.zzg();
        zzljVar.zzb();
        zzic zzicVar = zzljVar.zzu;
        zzicVar.zzaW().zzj().zza("Resetting analytics data (FE)");
        zzic zzicVar2 = zzljVar.zzu;
        zzoc zzocVarZzh = zzicVar2.zzh();
        zzocVarZzh.zzg();
        zzocVarZzh.zzb.zzc();
        zzicVar2.zzv().zzi();
        boolean z = !zzljVar.zzu.zzB();
        zzhh zzhhVarZzd = zzicVar.zzd();
        zzhhVarZzd.zzc.zzb(this.zza);
        zzic zzicVar3 = zzhhVarZzd.zzu;
        if (!TextUtils.isEmpty(zzicVar3.zzd().zzq.zza())) {
            zzhhVarZzd.zzq.zzb(null);
        }
        zzhhVarZzd.zzk.zzb(0L);
        zzhhVarZzd.zzl.zzb(0L);
        if (!zzicVar3.zzc().zzt()) {
            zzhhVarZzd.zzm(z);
        }
        zzhhVarZzd.zzr.zzb(null);
        zzhhVarZzd.zzs.zzb(0L);
        zzhhVarZzd.zzt.zzb(null);
        zzicVar2.zzt().zzB();
        zzicVar2.zzh().zza.zza();
        zzljVar.zzc = z;
        zzicVar2.zzt().zzC(new AtomicReference());
    }
}
