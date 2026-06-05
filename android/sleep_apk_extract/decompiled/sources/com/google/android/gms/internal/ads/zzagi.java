package com.google.android.gms.internal.ads;

import java.util.Arrays;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzagi {
    public static zzap zza(zzafz zzafzVar, boolean z) {
        zzap zzapVarZza = new zzagt().zza(zzafzVar, z ? null : zzajn.zza, 0);
        if (zzapVarZza == null || zzapVarZza.zza() == 0) {
            return null;
        }
        return zzapVarZza;
    }

    public static boolean zzb(zzafz zzafzVar, zzagh zzaghVar) {
        zzafzVar.zzl();
        zzes zzesVar = new zzes(new byte[4], 4);
        zzafzVar.zzi(zzesVar.zza, 0, 4);
        boolean zZzi = zzesVar.zzi();
        int iZzj = zzesVar.zzj(7);
        int iZzj2 = zzesVar.zzj(24) + 4;
        if (iZzj == 0) {
            byte[] bArr = new byte[38];
            zzafzVar.zzc(bArr, 0, 38);
            zzaghVar.zza = new zzagl(bArr, 4);
            return zZzi;
        }
        zzagl zzaglVar = zzaghVar.zza;
        if (zzaglVar == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$3();
            return false;
        }
        if (iZzj == 3) {
            zzet zzetVar = new zzet(iZzj2);
            zzafzVar.zzc(zzetVar.zzi(), 0, iZzj2);
            zzaghVar.zza = zzaglVar.zze(zzc(zzetVar));
            return zZzi;
        }
        if (iZzj == 4) {
            zzet zzetVar2 = new zzet(iZzj2);
            zzafzVar.zzc(zzetVar2.zzi(), 0, iZzj2);
            zzetVar2.zzk(4);
            zzaghVar.zza = new zzagl(zzaglVar.zza, zzaglVar.zzb, zzaglVar.zzc, zzaglVar.zzd, zzaglVar.zze, zzaglVar.zzg, zzaglVar.zzh, zzaglVar.zzj, zzaglVar.zzk, zzaglVar.zzd(zzahm.zzb(Arrays.asList(zzhe.zzb(zzetVar2, false, false).zza))));
            return zZzi;
        }
        if (iZzj != 6) {
            zzafzVar.zzf(iZzj2);
            return zZzi;
        }
        zzet zzetVar3 = new zzet(iZzj2);
        zzafzVar.zzc(zzetVar3.zzi(), 0, iZzj2);
        zzetVar3.zzk(4);
        zzaghVar.zza = new zzagl(zzaglVar.zza, zzaglVar.zzb, zzaglVar.zzc, zzaglVar.zzd, zzaglVar.zze, zzaglVar.zzg, zzaglVar.zzh, zzaglVar.zzj, zzaglVar.zzk, zzaglVar.zzd(new zzap(zzgwm.zzj(zzajc.zzb(zzetVar3)))));
        return zZzi;
    }

    public static zzagk zzc(zzet zzetVar) {
        zzetVar.zzk(1);
        int iZzx = zzetVar.zzx();
        long jZzg = zzetVar.zzg();
        long j = iZzx;
        int i = iZzx / 18;
        long[] jArrCopyOf = new long[i];
        long[] jArrCopyOf2 = new long[i];
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                break;
            }
            long jZzD = zzetVar.zzD();
            if (jZzD == -1) {
                jArrCopyOf = Arrays.copyOf(jArrCopyOf, i2);
                jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i2);
                break;
            }
            jArrCopyOf[i2] = jZzD;
            jArrCopyOf2[i2] = zzetVar.zzD();
            zzetVar.zzk(2);
            i2++;
        }
        zzetVar.zzk((int) ((jZzg + j) - ((long) zzetVar.zzg())));
        return new zzagk(jArrCopyOf, jArrCopyOf2);
    }
}
