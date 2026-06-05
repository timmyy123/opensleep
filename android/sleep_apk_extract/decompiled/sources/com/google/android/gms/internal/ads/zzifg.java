package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
final class zzifg {
    private static final zzifn zzb = new zzife();
    private final zzifn zza;

    public zzifg() {
        zzidx zzidxVarZza = zzidx.zza();
        int i = zzicn.$r8$clinit;
        this.zza = new zziff(zzidxVarZza, zzb);
    }

    public final zzigh zza(Class cls) {
        int i = zzigi.$r8$clinit;
        if (!zziee.class.isAssignableFrom(cls)) {
            int i2 = zzicn.$r8$clinit;
        }
        zzifm zzifmVarZzc = this.zza.zzc(cls);
        if (zzifmVarZzc.zza()) {
            int i3 = zzicn.$r8$clinit;
            return zzift.zzh(zzigi.zzF(), zzidr.zza(), zzifmVarZzc.zzb());
        }
        int i4 = zzicn.$r8$clinit;
        return zzifs.zzm(cls, zzifmVarZzc, zzifw.zza(), zzifc.zza(), zzigi.zzF(), zzifmVarZzc.zzc() + (-1) != 1 ? zzidr.zza() : null, zzifl.zza());
    }
}
