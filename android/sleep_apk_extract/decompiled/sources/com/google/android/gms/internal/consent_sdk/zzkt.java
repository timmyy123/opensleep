package com.google.android.gms.internal.consent_sdk;

/* JADX INFO: loaded from: classes3.dex */
public final class zzkt extends zzqm implements zzrr {
    private static final zzkt zzb;
    private int zzd;
    private boolean zze;
    private boolean zzf;

    static {
        zzkt zzktVar = new zzkt();
        zzb = zzktVar;
        zzqm.zzz(zzkt.class, zzktVar);
    }

    private zzkt() {
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzqm
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzqm.zzw(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzkt();
        }
        zzkz zzkzVar = null;
        if (i2 == 4) {
            return new zzks(zzkzVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        throw null;
    }
}
