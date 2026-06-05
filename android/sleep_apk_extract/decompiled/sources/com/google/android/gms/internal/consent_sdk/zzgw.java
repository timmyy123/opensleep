package com.google.android.gms.internal.consent_sdk;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgw extends zzqm implements zzrr {
    private static final zzgw zzb;
    private int zzd;
    private int zze;
    private String zzf = "";
    private String zzg = "";
    private int zzh;

    static {
        zzgw zzgwVar = new zzgw();
        zzb = zzgwVar;
        zzqm.zzz(zzgw.class, zzgwVar);
    }

    private zzgw() {
    }

    public static zzgv zza() {
        return (zzgv) zzb.zzp();
    }

    public static /* synthetic */ void zzd(zzgw zzgwVar, int i) {
        zzgwVar.zzd |= 8;
        zzgwVar.zzh = i;
    }

    public static /* synthetic */ void zze(zzgw zzgwVar, String str) {
        str.getClass();
        zzgwVar.zzd |= 4;
        zzgwVar.zzg = str;
    }

    public static /* synthetic */ void zzf(zzgw zzgwVar, String str) {
        str.getClass();
        zzgwVar.zzd |= 2;
        zzgwVar.zzf = str;
    }

    public static /* synthetic */ void zzg(zzgw zzgwVar, int i) {
        zzgwVar.zze = 1;
        zzgwVar.zzd = 1 | zzgwVar.zzd;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzqm
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzqm.zzw(zzb, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဌ\u0000\u0002ለ\u0001\u0003ለ\u0002\u0004င\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzgw();
        }
        zzhb zzhbVar = null;
        if (i2 == 4) {
            return new zzgv(zzhbVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        throw null;
    }
}
