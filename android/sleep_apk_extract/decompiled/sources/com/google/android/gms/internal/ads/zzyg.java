package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class zzyg extends zzago {
    private final zzzb zza;
    private final zzafv zzb;
    private final AtomicReference zzc;

    public zzyg(zzzb zzzbVar) {
        super(zzzbVar);
        this.zza = zzzbVar;
        this.zzb = new zzafv();
        this.zzc = new AtomicReference(zzyf.PASS_THROUGH);
    }

    private final zzahk zzh() {
        return this.zzc.get() == zzyf.DISCARDING ? this.zzb : this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzahk
    public final int zza(zzj zzjVar, int i, boolean z) {
        return zzh().zza(zzjVar, i, z);
    }

    @Override // com.google.android.gms.internal.ads.zzahk
    public final int zzb(zzj zzjVar, int i, boolean z, int i2) {
        return zzh().zzb(zzjVar, i, z, 0);
    }

    @Override // com.google.android.gms.internal.ads.zzahk
    public final void zzc(zzet zzetVar, int i) {
        zzh().zzc(zzetVar, i);
    }

    @Override // com.google.android.gms.internal.ads.zzahk
    public final void zzd(zzet zzetVar, int i, int i2) {
        zzh().zzd(zzetVar, i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzahk
    public final void zze(long j, int i, int i2, int i3, zzahj zzahjVar) {
        zzh().zze(j, i, i2, i3, zzahjVar);
        AtomicReference atomicReference = this.zzc;
        if (atomicReference.get() == zzyf.DISCARD_AFTER_NEXT_SAMPLE_METADATA) {
            this.zza.zzg(false);
            atomicReference.set(zzyf.DISCARDING);
        }
    }

    public final boolean zzf() {
        return this.zzc.get() == zzyf.PASS_THROUGH;
    }
}
