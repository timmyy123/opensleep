package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzafl {
    public static void zza(long j, zzet zzetVar, zzahk[] zzahkVarArr) {
        int iZzB;
        while (true) {
            if (zzetVar.zzd() <= 1) {
                return;
            }
            int iZzc = zzc(zzetVar);
            int iZzc2 = zzc(zzetVar);
            int iZzg = zzetVar.zzg() + iZzc2;
            if (iZzc2 == -1 || iZzc2 > zzetVar.zzd()) {
                zzeg.zzc("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                iZzg = zzetVar.zze();
            } else if (iZzc == 4 && iZzc2 >= 8) {
                int iZzs = zzetVar.zzs();
                int iZzt = zzetVar.zzt();
                if (iZzt == 49) {
                    iZzB = zzetVar.zzB();
                    iZzt = 49;
                } else {
                    iZzB = 0;
                }
                int iZzs2 = zzetVar.zzs();
                if (iZzt == 47) {
                    zzetVar.zzk(1);
                    iZzt = 47;
                }
                boolean z = iZzs == 181 && (iZzt == 49 || iZzt == 47) && iZzs2 == 3;
                if (iZzt == 49) {
                    z &= iZzB == 1195456820;
                }
                if (z) {
                    zzb(j, zzetVar, zzahkVarArr);
                }
            }
            zzetVar.zzh(iZzg);
        }
    }

    public static void zzb(long j, zzet zzetVar, zzahk[] zzahkVarArr) {
        int iZzs = zzetVar.zzs();
        if ((iZzs & 64) != 0) {
            int i = iZzs & 31;
            zzetVar.zzk(1);
            int iZzg = zzetVar.zzg();
            for (zzahk zzahkVar : zzahkVarArr) {
                int i2 = i * 3;
                zzetVar.zzh(iZzg);
                zzahkVar.zzc(zzetVar, i2);
                zzgtj.zzi(j != -9223372036854775807L);
                zzahkVar.zze(j, 1, i2, 0, null);
            }
        }
    }

    private static int zzc(zzet zzetVar) {
        int i = 0;
        while (zzetVar.zzd() != 0) {
            int iZzs = zzetVar.zzs();
            i += iZzs;
            if (iZzs != 255) {
                return i;
            }
        }
        return -1;
    }
}
