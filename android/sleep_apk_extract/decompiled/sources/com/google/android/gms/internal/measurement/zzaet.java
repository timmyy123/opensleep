package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes3.dex */
final class zzaet {
    private static final zzafa zzb = new zzaer();
    private final zzafa zza;

    public zzaet() {
        zzado zzadoVarZza = zzado.zza();
        int i = zzacf.$r8$clinit;
        this.zza = new zzaes(zzadoVarZza, zzb);
    }

    public final zzafp zza(Class cls) {
        int i = zzafq.$r8$clinit;
        if (!zzadu.class.isAssignableFrom(cls)) {
            int i2 = zzacf.$r8$clinit;
        }
        zzaez zzaezVarZzc = this.zza.zzc(cls);
        if (zzaezVarZzc.zza()) {
            int i3 = zzacf.$r8$clinit;
            return zzafg.zzh(zzafq.zzB(), zzadi.zza(), zzaezVarZzc.zzb());
        }
        int i4 = zzacf.$r8$clinit;
        return zzaff.zzm(cls, zzaezVarZzc, zzafi.zza(), zzaep.zza(), zzafq.zzB(), zzaezVarZzc.zzc() + (-1) != 1 ? zzadi.zza() : null, zzaey.zza());
    }
}
