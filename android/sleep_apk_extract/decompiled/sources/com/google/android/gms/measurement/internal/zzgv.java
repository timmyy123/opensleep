package com.google.android.gms.measurement.internal;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.os.Bundle;

/* JADX INFO: loaded from: classes4.dex */
public final class zzgv {
    public final String zza;
    public final String zzb;
    public final long zzc;
    public final long zzd;
    public final Bundle zze;

    public zzgv(String str, String str2, Bundle bundle, long j, long j2) {
        this.zza = str;
        this.zzb = str2;
        this.zze = bundle;
        this.zzc = j;
        this.zzd = j2;
    }

    public static zzgv zza(zzbh zzbhVar) {
        return new zzgv(zzbhVar.zza, zzbhVar.zzc, zzbhVar.zzb.zzf(), zzbhVar.zzd, zzbhVar.zze);
    }

    public final String toString() {
        String str = this.zzb;
        String string = this.zze.toString();
        int length = String.valueOf(str).length();
        String str2 = this.zza;
        StringBuilder sb = new StringBuilder(length + 13 + String.valueOf(str2).length() + 8 + string.length());
        FileInsert$$ExternalSyntheticOutline0.m(sb, "origin=", str, ",name=", str2);
        return FileInsert$$ExternalSyntheticOutline0.m(sb, ",params=", string);
    }

    public final zzbh zzb() {
        return new zzbh(this.zza, new zzbf(new Bundle(this.zze)), this.zzb, this.zzc, this.zzd);
    }
}
