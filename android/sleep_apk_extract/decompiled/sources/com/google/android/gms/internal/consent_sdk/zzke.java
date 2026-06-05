package com.google.android.gms.internal.consent_sdk;

/* JADX INFO: loaded from: classes3.dex */
public final class zzke extends zzqm implements zzrr {
    private static final zzke zzb;
    private int zzd;
    private boolean zze;
    private boolean zzf;

    static {
        zzke zzkeVar = new zzke();
        zzb = zzkeVar;
        zzqm.zzz(zzke.class, zzkeVar);
    }

    private zzke() {
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
            return new zzke();
        }
        zzkz zzkzVar = null;
        if (i2 == 4) {
            return new zzkd(zzkzVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        throw null;
    }
}
