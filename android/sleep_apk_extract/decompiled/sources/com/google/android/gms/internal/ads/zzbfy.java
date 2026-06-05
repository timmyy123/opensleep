package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbfy {
    final long zza;
    final String zzb;
    final int zzc;

    public zzbfy(long j, String str, int i) {
        this.zza = j;
        this.zzb = str;
        this.zzc = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbfy)) {
            return false;
        }
        zzbfy zzbfyVar = (zzbfy) obj;
        return zzbfyVar.zza == this.zza && zzbfyVar.zzc == this.zzc;
    }

    public final int hashCode() {
        return (int) this.zza;
    }
}
