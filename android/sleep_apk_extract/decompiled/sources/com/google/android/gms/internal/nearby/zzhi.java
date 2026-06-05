package com.google.android.gms.internal.nearby;

import android.net.Uri;
import android.os.ParcelFileDescriptor;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhi {
    private final zzhk zza = new zzhk(null);

    public final zzhi zza(byte[] bArr) {
        this.zza.zzc = bArr;
        return this;
    }

    public final zzhi zzb(ParcelFileDescriptor parcelFileDescriptor) {
        this.zza.zzd = parcelFileDescriptor;
        return this;
    }

    public final zzhi zzc(String str) {
        this.zza.zzm = str;
        return this;
    }

    public final zzhi zzd(long j) {
        this.zza.zza = j;
        return this;
    }

    public final zzhi zze(boolean z) {
        this.zza.zzj = z;
        return this;
    }

    public final zzhi zzf(String str) {
        this.zza.zze = str;
        return this;
    }

    public final zzhi zzg(long j) {
        this.zza.zzf = j;
        return this;
    }

    public final zzhi zzh(long j) {
        this.zza.zzi = j;
        return this;
    }

    public final zzhi zzi(String str) {
        this.zza.zzn = str;
        return this;
    }

    public final zzhi zzj(long j) {
        this.zza.zzl = j;
        return this;
    }

    public final zzhi zzk(zzhg zzhgVar) {
        this.zza.zzk = zzhgVar;
        return this;
    }

    public final zzhi zzl(ParcelFileDescriptor parcelFileDescriptor) {
        this.zza.zzg = parcelFileDescriptor;
        return this;
    }

    public final zzhi zzm(int i) {
        this.zza.zzb = i;
        return this;
    }

    public final zzhi zzn(Uri uri) {
        this.zza.zzh = uri;
        return this;
    }

    public final zzhk zzo() {
        return this.zza;
    }
}
