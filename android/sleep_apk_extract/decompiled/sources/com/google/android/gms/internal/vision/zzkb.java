package com.google.android.gms.internal.vision;

/* JADX INFO: loaded from: classes4.dex */
final class zzkb implements zzlf {
    private static final zzkl zzb = new zzka();
    private final zzkl zza;

    public zzkb() {
        this(new zzkd(zzjc.zza(), zza()));
    }

    @Override // com.google.android.gms.internal.vision.zzlf
    public final <T> zzlc<T> zza(Class<T> cls) {
        zzle.zza((Class<?>) cls);
        zzki zzkiVarZzb = this.zza.zzb(cls);
        return zzkiVarZzb.zzb() ? zzjb.class.isAssignableFrom(cls) ? zzkq.zza(zzle.zzc(), zzir.zza(), zzkiVarZzb.zzc()) : zzkq.zza(zzle.zza(), zzir.zzb(), zzkiVarZzb.zzc()) : zzjb.class.isAssignableFrom(cls) ? zza(zzkiVarZzb) ? zzko.zza(cls, zzkiVarZzb, zzku.zzb(), zzju.zzb(), zzle.zzc(), zzir.zza(), zzkj.zzb()) : zzko.zza(cls, zzkiVarZzb, zzku.zzb(), zzju.zzb(), zzle.zzc(), (zziq<?>) null, zzkj.zzb()) : zza(zzkiVarZzb) ? zzko.zza(cls, zzkiVarZzb, zzku.zza(), zzju.zza(), zzle.zza(), zzir.zzb(), zzkj.zza()) : zzko.zza(cls, zzkiVarZzb, zzku.zza(), zzju.zza(), zzle.zzb(), (zziq<?>) null, zzkj.zza());
    }

    private zzkb(zzkl zzklVar) {
        this.zza = (zzkl) zzjf.zza(zzklVar, "messageInfoFactory");
    }

    private static boolean zza(zzki zzkiVar) {
        return zzkiVar.zza() == zzkz.zza;
    }

    private static zzkl zza() {
        try {
            return (zzkl) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            return zzb;
        }
    }
}
