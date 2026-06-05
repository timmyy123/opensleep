package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcg;

/* JADX INFO: loaded from: classes3.dex */
final class zzdd implements zzeg {
    private static final zzdn zzlz = new zzde();
    private final zzdn zzly;

    public zzdd() {
        this(new zzdf(zzcf.zzay(), zzby()));
    }

    private static boolean zza(zzdm zzdmVar) {
        return zzdmVar.zzcf() == zzcg.zzg.zzkl;
    }

    private static zzdn zzby() {
        try {
            return (zzdn) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            return zzlz;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.zzeg
    public final <T> zzef<T> zzd(Class<T> cls) {
        zzeh.zzf((Class<?>) cls);
        zzdm zzdmVarZzb = this.zzly.zzb(cls);
        if (zzdmVarZzb.zzcg()) {
            return zzcg.class.isAssignableFrom(cls) ? zzdu.zza(zzeh.zzdo(), zzbx.zzap(), zzdmVarZzb.zzch()) : zzdu.zza(zzeh.zzdm(), zzbx.zzaq(), zzdmVarZzb.zzch());
        }
        if (zzcg.class.isAssignableFrom(cls)) {
            return zza(zzdmVarZzb) ? zzds.zza(cls, zzdmVarZzb, zzdy.zzck(), zzcy.zzbw(), zzeh.zzdo(), zzbx.zzap(), zzdl.zzcd()) : zzds.zza(cls, zzdmVarZzb, zzdy.zzck(), zzcy.zzbw(), zzeh.zzdo(), (zzbu<?>) null, zzdl.zzcd());
        }
        boolean zZza = zza(zzdmVarZzb);
        zzdw zzdwVarZzcj = zzdy.zzcj();
        zzcy zzcyVarZzbv = zzcy.zzbv();
        return zZza ? zzds.zza(cls, zzdmVarZzb, zzdwVarZzcj, zzcyVarZzbv, zzeh.zzdm(), zzbx.zzaq(), zzdl.zzcc()) : zzds.zza(cls, zzdmVarZzb, zzdwVarZzcj, zzcyVarZzbv, zzeh.zzdn(), (zzbu<?>) null, zzdl.zzcc());
    }

    private zzdd(zzdn zzdnVar) {
        this.zzly = (zzdn) zzci.zza(zzdnVar, "messageInfoFactory");
    }
}
