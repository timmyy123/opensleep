package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzibb {
    private final zziaz zza;

    private zzibb(zziaz zziazVar) {
        this.zza = zziazVar;
    }

    public static zzibb zza(byte[] bArr, zzhel zzhelVar) {
        return new zzibb(zziaz.zza(bArr));
    }

    public static zzibb zzb(int i) {
        return new zzibb(zziaz.zza(zzhnp.zza(i)));
    }

    public final byte[] zzc(zzhel zzhelVar) {
        return this.zza.zzc();
    }

    public final int zzd() {
        return this.zza.zzd();
    }
}
