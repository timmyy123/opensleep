package com.google.android.gms.internal.ads;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhom extends zzhox {
    private final zzhov zza;
    private final zzibb zzb;
    private final zziaz zzc;

    @Nullable
    private final Integer zzd;

    public /* synthetic */ zzhom(zzhov zzhovVar, zzibb zzibbVar, zziaz zziazVar, Integer num, byte[] bArr) {
        this.zza = zzhovVar;
        this.zzb = zzibbVar;
        this.zzc = zziazVar;
        this.zzd = num;
    }

    public static zzhol zzc() {
        return new zzhol(null);
    }

    @Override // com.google.android.gms.internal.ads.zzhdq
    public final /* synthetic */ zzheh zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzhdq
    @Nullable
    public final Integer zzb() {
        return this.zzd;
    }

    public final zzibb zzd() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzhox
    public final zziaz zze() {
        return this.zzc;
    }

    public final zzhov zzf() {
        return this.zza;
    }
}
