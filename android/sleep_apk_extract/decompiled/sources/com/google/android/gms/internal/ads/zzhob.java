package com.google.android.gms.internal.ads;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhob extends zzhox {
    private final zzhoi zza;
    private final zzibb zzb;
    private final zziaz zzc;

    @Nullable
    private final Integer zzd;

    public /* synthetic */ zzhob(zzhoi zzhoiVar, zzibb zzibbVar, zziaz zziazVar, Integer num, byte[] bArr) {
        this.zza = zzhoiVar;
        this.zzb = zzibbVar;
        this.zzc = zziazVar;
        this.zzd = num;
    }

    public static zzhoa zzc() {
        return new zzhoa(null);
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

    public final zzhoi zzf() {
        return this.zza;
    }
}
