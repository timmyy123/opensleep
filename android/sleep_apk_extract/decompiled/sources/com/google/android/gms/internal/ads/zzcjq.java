package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class zzcjq implements zzhp {
    private final zzhp zza;
    private final long zzb;
    private final zzhp zzc;
    private long zzd;
    private Uri zze;

    public zzcjq(zzhp zzhpVar, int i, zzhp zzhpVar2) {
        this.zza = zzhpVar;
        this.zzb = i;
        this.zzc = zzhpVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzj
    public final int zza(byte[] bArr, int i, int i2) {
        int i3;
        long j = this.zzd;
        long j2 = this.zzb;
        if (j < j2) {
            int iZza = this.zza.zza(bArr, i, (int) Math.min(i2, j2 - j));
            long j3 = this.zzd + ((long) iZza);
            this.zzd = j3;
            i3 = iZza;
            j = j3;
        } else {
            i3 = 0;
        }
        if (j < j2) {
            return i3;
        }
        int iZza2 = this.zzc.zza(bArr, i + i3, i2 - i3);
        int i4 = i3 + iZza2;
        this.zzd += (long) iZza2;
        return i4;
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final long zzb(zzht zzhtVar) {
        Uri uri;
        zzht zzhtVar2;
        Uri uri2 = zzhtVar.zza;
        this.zze = uri2;
        long j = zzhtVar.zze;
        long j2 = this.zzb;
        zzht zzhtVar3 = null;
        if (j >= j2) {
            uri = uri2;
            zzhtVar2 = null;
        } else {
            long j3 = zzhtVar.zzf;
            long jMin = j2 - j;
            if (j3 != -1) {
                jMin = Math.min(j3, jMin);
            }
            uri = uri2;
            zzhtVar2 = new zzht(uri, j, jMin, null);
        }
        long j4 = zzhtVar.zzf;
        if (j4 == -1 || j + j4 > j2) {
            zzhtVar3 = new zzht(uri, Math.max(j2, j), j4 != -1 ? Math.min(j4, (j + j4) - j2) : -1L, null);
        }
        long jZzb = zzhtVar2 != null ? this.zza.zzb(zzhtVar2) : 0L;
        long jZzb2 = zzhtVar3 != null ? this.zzc.zzb(zzhtVar3) : 0L;
        this.zzd = j;
        if (jZzb == -1 || jZzb2 == -1) {
            return -1L;
        }
        return jZzb + jZzb2;
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final Uri zzc() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final void zzd() {
        this.zza.zzd();
        this.zzc.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final void zze(zzin zzinVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzhp, com.google.android.gms.internal.ads.zzii
    public final Map zzj() {
        return zzgwp.zza();
    }
}
