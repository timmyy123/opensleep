package com.google.android.gms.internal.serialization;

/* JADX INFO: loaded from: classes3.dex */
final class zzaah implements zzabf {
    private static final zzaao zzb = new zzaaf();
    private final zzaao zza;

    public zzaah() {
        zzyx zzyxVarZza = zzyx.zza();
        int i = zzaba.$r8$clinit;
        zzaag zzaagVar = new zzaag(zzyxVarZza, zzb);
        byte[] bArr = zzzt.zzb;
        this.zza = zzaagVar;
    }

    @Override // com.google.android.gms.internal.serialization.zzabf
    public final zzabe zza(Class cls) {
        int i = zzabg.$r8$clinit;
        if (!zzzg.class.isAssignableFrom(cls)) {
            int i2 = zzaba.$r8$clinit;
        }
        zzaan zzaanVarZzc = this.zza.zzc(cls);
        if (zzaanVarZzc.zza()) {
            int i3 = zzaba.$r8$clinit;
            return zzaau.zzh(zzabg.zzE(), zzys.zza(), zzaanVarZzc.zzb());
        }
        int i4 = zzaba.$r8$clinit;
        return zzaat.zzm(cls, zzaanVarZzc, zzaax.zza(), zzaad.zza(), zzabg.zzE(), zzaanVarZzc.zzc() + (-1) != 1 ? zzys.zza() : null, zzaam.zza());
    }
}
