package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class zzms {
    private static final zzxk zzu = new zzxk(new Object(), -1);
    public final zzbf zza;
    public final zzxk zzb;
    public final long zzc;
    public final long zzd;
    public final int zze;
    public final zzjk zzf;
    public final boolean zzg;
    public final zzzn zzh;
    public final zzabi zzi;
    public final List zzj;
    public final zzxk zzk;
    public final boolean zzl;
    public final int zzm;
    public final int zzn;
    public final zzav zzo;
    public final boolean zzp = false;
    public volatile long zzq;
    public volatile long zzr;
    public volatile long zzs;
    public volatile long zzt;

    public zzms(zzbf zzbfVar, zzxk zzxkVar, long j, long j2, int i, zzjk zzjkVar, boolean z, zzzn zzznVar, zzabi zzabiVar, List list, zzxk zzxkVar2, boolean z2, int i2, int i3, zzav zzavVar, long j3, long j4, long j5, long j6, boolean z3) {
        this.zza = zzbfVar;
        this.zzb = zzxkVar;
        this.zzc = j;
        this.zzd = j2;
        this.zze = i;
        this.zzf = zzjkVar;
        this.zzg = z;
        this.zzh = zzznVar;
        this.zzi = zzabiVar;
        this.zzj = list;
        this.zzk = zzxkVar2;
        this.zzl = z2;
        this.zzm = i2;
        this.zzn = i3;
        this.zzo = zzavVar;
        this.zzq = j3;
        this.zzr = j4;
        this.zzs = j5;
        this.zzt = j6;
    }

    public static zzms zza(zzabi zzabiVar) {
        zzbf zzbfVar = zzbf.zza;
        zzxk zzxkVar = zzu;
        return new zzms(zzbfVar, zzxkVar, -9223372036854775807L, 0L, 1, null, false, zzzn.zza, zzabiVar, zzgwm.zzi(), zzxkVar, false, 1, 0, zzav.zza, 0L, 0L, 0L, 0L, false);
    }

    public static zzxk zzb() {
        return zzu;
    }

    public final zzms zzc(zzxk zzxkVar, long j, long j2, long j3, long j4, zzzn zzznVar, zzabi zzabiVar, List list) {
        zzxk zzxkVar2 = this.zzk;
        boolean z = this.zzl;
        int i = this.zzm;
        int i2 = this.zzn;
        zzav zzavVar = this.zzo;
        long j5 = this.zzq;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        return new zzms(this.zza, zzxkVar, j2, j3, this.zze, this.zzf, this.zzg, zzznVar, zzabiVar, list, zzxkVar2, z, i, i2, zzavVar, j5, j4, j, jElapsedRealtime, false);
    }

    public final zzms zzd(zzbf zzbfVar) {
        return new zzms(zzbfVar, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzo, this.zzq, this.zzr, this.zzs, this.zzt, false);
    }

    public final zzms zze(int i) {
        return new zzms(this.zza, this.zzb, this.zzc, this.zzd, i, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzo, this.zzq, this.zzr, this.zzs, this.zzt, false);
    }

    public final zzms zzf(zzjk zzjkVar) {
        return new zzms(this.zza, this.zzb, this.zzc, this.zzd, this.zze, zzjkVar, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzo, this.zzq, this.zzr, this.zzs, this.zzt, false);
    }

    public final zzms zzg(boolean z) {
        return new zzms(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, z, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzo, this.zzq, this.zzr, this.zzs, this.zzt, false);
    }

    public final zzms zzh(zzxk zzxkVar) {
        return new zzms(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, zzxkVar, this.zzl, this.zzm, this.zzn, this.zzo, this.zzq, this.zzr, this.zzs, this.zzt, false);
    }

    public final zzms zzi(boolean z, int i, int i2) {
        return new zzms(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, z, i, i2, this.zzo, this.zzq, this.zzr, this.zzs, this.zzt, false);
    }

    public final boolean zzj() {
        return this.zze == 3 && this.zzl && this.zzn == 0;
    }
}
