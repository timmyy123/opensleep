package com.google.android.gms.internal.consent_sdk;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfa extends zzqm implements zzrr {
    private static final zzfa zzb;
    private int zzd;
    private zzew zze;
    private zzey zzf;
    private String zzg = "";
    private String zzh = "";

    static {
        zzfa zzfaVar = new zzfa();
        zzb = zzfaVar;
        zzqm.zzz(zzfa.class, zzfaVar);
    }

    private zzfa() {
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzqm
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzqm.zzw(zzb, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဈ\u0002\u0004ဈ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzfa();
        }
        zzez zzezVar = null;
        if (i2 == 4) {
            return new zzek(zzezVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        throw null;
    }
}
