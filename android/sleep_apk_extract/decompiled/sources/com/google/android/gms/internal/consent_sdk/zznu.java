package com.google.android.gms.internal.consent_sdk;

/* JADX INFO: loaded from: classes3.dex */
public final class zznu extends zzqm implements zzrr {
    private static final zznu zzb;
    private int zzd;
    private int zze;
    private int zzf;

    static {
        zznu zznuVar = new zznu();
        zzb = zznuVar;
        zzqm.zzz(zznu.class, zznuVar);
    }

    private zznu() {
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzqm
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzqm.zzw(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001", new Object[]{"zzd", "zze", zznr.zza, "zzf", zzns.zza});
        }
        if (i2 == 3) {
            return new zznu();
        }
        zznt zzntVar = null;
        if (i2 == 4) {
            return new zznq(zzntVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        throw null;
    }
}
