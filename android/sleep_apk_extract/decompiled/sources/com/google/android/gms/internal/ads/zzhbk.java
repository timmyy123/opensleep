package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
final class zzhbk extends zzhay {
    private zzhbj zza;

    public zzhbk(zzgwi zzgwiVar, boolean z, Executor executor, Callable callable) {
        super(zzgwiVar, z, false);
        this.zza = new zzhbi(this, callable, executor);
        zze();
    }

    @Override // com.google.android.gms.internal.ads.zzhay
    public final void zzA(int i) {
        super.zzA(i);
        if (i == 1) {
            this.zza = null;
        }
    }

    public final /* synthetic */ void zzD(zzhbj zzhbjVar) {
        this.zza = null;
    }

    @Override // com.google.android.gms.internal.ads.zzhap
    public final void zzi() {
        zzhbj zzhbjVar = this.zza;
        if (zzhbjVar != null) {
            zzhbjVar.zzh();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhay
    public final void zzw(int i, Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzhay
    public final void zzx() {
        zzhbj zzhbjVar = this.zza;
        if (zzhbjVar != null) {
            zzhbjVar.zze();
        }
    }
}
