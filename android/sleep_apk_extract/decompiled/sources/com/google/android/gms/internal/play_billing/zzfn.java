package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfn extends zzhk implements zzin {
    private static final zzfn zzb;
    private zzho zzd = zzhk.zzs();

    static {
        zzfn zzfnVar = new zzfn();
        zzb = zzfnVar;
        zzhk.zzx(zzfn.class, zzfnVar);
    }

    private zzfn() {
    }

    public static zzfm zza() {
        return (zzfm) zzb.zzm();
    }

    public static /* synthetic */ void zzc(zzfn zzfnVar, Iterable iterable) {
        zzho zzhoVar = zzfnVar.zzd;
        if (!zzhoVar.zzc()) {
            int size = zzhoVar.size();
            zzfnVar.zzd = zzhoVar.zzd(size + size);
        }
        zzfv.zzg(iterable, zzfnVar.zzd);
    }

    @Override // com.google.android.gms.internal.play_billing.zzhk
    public final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzhk.zzu(zzb, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zzfl.class});
        }
        if (i2 == 3) {
            return new zzfn();
        }
        zzfo zzfoVar = null;
        if (i2 == 4) {
            return new zzfm(zzfoVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
