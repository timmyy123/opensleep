package com.google.android.gms.internal.play_billing;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes3.dex */
final class zzl extends zzf {
    final AtomicReferenceFieldUpdater zza;
    final AtomicReferenceFieldUpdater zzb;
    final AtomicReferenceFieldUpdater zzc;
    final AtomicReferenceFieldUpdater zzd;
    final AtomicReferenceFieldUpdater zze;

    public zzl(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
        super(null);
        this.zza = atomicReferenceFieldUpdater;
        this.zzb = atomicReferenceFieldUpdater2;
        this.zzc = atomicReferenceFieldUpdater3;
        this.zzd = atomicReferenceFieldUpdater4;
        this.zze = atomicReferenceFieldUpdater5;
    }

    @Override // com.google.android.gms.internal.play_billing.zzf
    public final void zza(zzo zzoVar, zzo zzoVar2) {
        this.zzb.lazySet(zzoVar, zzoVar2);
    }

    @Override // com.google.android.gms.internal.play_billing.zzf
    public final void zzb(zzo zzoVar, Thread thread) {
        this.zza.lazySet(zzoVar, thread);
    }

    @Override // com.google.android.gms.internal.play_billing.zzf
    public final boolean zzc(zzq zzqVar, zzj zzjVar, zzj zzjVar2) {
        return zzk.zza(this.zzd, zzqVar, zzjVar, zzjVar2);
    }

    @Override // com.google.android.gms.internal.play_billing.zzf
    public final boolean zzd(zzq zzqVar, Object obj, Object obj2) {
        return zzk.zza(this.zze, zzqVar, obj, obj2);
    }

    @Override // com.google.android.gms.internal.play_billing.zzf
    public final boolean zze(zzq zzqVar, zzo zzoVar, zzo zzoVar2) {
        return zzk.zza(this.zzc, zzqVar, zzoVar, zzoVar2);
    }
}
