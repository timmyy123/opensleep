package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzfa {
    final /* synthetic */ zzfc zza;
    private final int zzb;
    private Object zzc;
    private int zzd;
    private int zze;
    private boolean zzf;
    private long zzg;

    public zzfa(zzfc zzfcVar, int i) {
        Objects.requireNonNull(zzfcVar);
        this.zza = zzfcVar;
        this.zzb = i;
    }

    public final void zza() {
        long jZzt;
        zzfc zzfcVar = this.zza;
        zzbf zzbfVarZzq = zzfcVar.zzd().zzq();
        Object objZzf = zzbfVarZzq.zzg() ? null : zzbfVarZzq.zzf(zzfcVar.zzd().zzr());
        zzbb zzbbVarZzd = zzfcVar.zzd();
        zzbb zzbbVarZzd2 = zzfcVar.zzd();
        zzbb zzbbVarZzd3 = zzfcVar.zzd();
        int iZzy = zzbbVarZzd.zzy();
        int iZzz = zzbbVarZzd2.zzz();
        long jZzu = zzbbVarZzd3.zzu();
        if (objZzf == null || iZzy != -1) {
            jZzt = iZzy != -1 ? zzfcVar.zzd().zzt() : -9223372036854775807L;
        } else {
            zzbfVarZzq.zzo(objZzf, zzfcVar.zzf());
            jZzu -= zzfl.zzr(0L);
            jZzt = zzfl.zzr(zzfcVar.zzf().zzd);
            iZzy = -1;
        }
        boolean zZza = zzfcVar.zzd().zza();
        if (!zZza || jZzt == -9223372036854775807L || jZzu < jZzt) {
            zzfcVar.zzg().zzk(3);
            if (zZza && jZzt != -9223372036854775807L) {
                zzfcVar.zzg().zzi(3, (int) Math.ceil((jZzt - jZzu) / zzfcVar.zzd().zzn().zzb));
            }
            this.zzf = false;
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (this.zzf && Objects.equals(objZzf, this.zzc) && iZzy == this.zzd && iZzz == this.zze) {
            long j = jElapsedRealtime - this.zzg;
            int i = this.zzb;
            if (j >= i) {
                zzfcVar.zze().zza(new zzfd(3, i));
                return;
            }
            return;
        }
        this.zzf = true;
        this.zzg = jElapsedRealtime;
        this.zzc = objZzf;
        this.zzd = iZzy;
        this.zze = iZzz;
        zzfcVar.zzg().zzk(3);
        zzfcVar.zzg().zzi(3, this.zzb);
    }
}
