package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgq {
    private final boolean zza;

    /* JADX WARN: Removed duplicated region for block: B:12:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private zzgq(zzgt zzgtVar, zzgs zzgsVar) throws zzgr {
        int i = zzgsVar.zza;
        boolean z = false;
        zzgtj.zza(i == 6 || i == 3);
        int iMin = Math.min(4, zzgsVar.zzb.remaining());
        byte[] bArr = new byte[iMin];
        zzgsVar.zzb.asReadOnlyBuffer().get(bArr);
        zzes zzesVar = new zzes(bArr, iMin);
        zzgu.zzb(zzgtVar.zza);
        if (!zzesVar.zzi()) {
            int iZzj = zzesVar.zzj(2);
            boolean zZzi = zzesVar.zzi();
            zzgu.zzb(zzgtVar.zzb);
            if (zZzi) {
                boolean zZzi2 = (iZzj == 3 || iZzj == 0) ? true : zzesVar.zzi();
                zzesVar.zzg();
                zzgu.zzb(!zzgtVar.zzd);
                if (zzesVar.zzi()) {
                    zzgu.zzb(!zzgtVar.zze);
                    zzesVar.zzg();
                }
                zzgu.zzb(zzgtVar.zzc);
                if (iZzj != 3) {
                    zzesVar.zzg();
                }
                zzesVar.zzh(zzgtVar.zzf);
                if (iZzj != 2 && iZzj != 0 && !zZzi2) {
                    zzesVar.zzh(3);
                }
                if (iZzj == 3 || iZzj == 0 || zzesVar.zzj(8) != 0) {
                    z = true;
                }
            }
        }
        this.zza = z;
    }

    public static zzgq zzb(zzgt zzgtVar, zzgs zzgsVar) {
        try {
            return new zzgq(zzgtVar, zzgsVar);
        } catch (zzgr unused) {
            return null;
        }
    }

    public final boolean zza() {
        return this.zza;
    }
}
