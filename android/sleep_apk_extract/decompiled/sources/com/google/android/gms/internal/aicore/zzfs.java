package com.google.android.gms.internal.aicore;

/* JADX INFO: loaded from: classes3.dex */
final class zzfs implements zzgl {
    private static final zzfy zzb = new zzfq();
    private final zzfy zza;

    public zzfs() {
        zzes zzesVarZza = zzes.zza();
        int i = zzgh.$r8$clinit;
        zzfr zzfrVar = new zzfr(zzesVarZza, zzb);
        byte[] bArr = zzfh.zzb;
        this.zza = zzfrVar;
    }

    @Override // com.google.android.gms.internal.aicore.zzgl
    public final zzgk zza(Class cls) {
        int i = zzgm.$r8$clinit;
        if (!zzex.class.isAssignableFrom(cls)) {
            int i2 = zzgh.$r8$clinit;
        }
        zzfx zzfxVarZzc = this.zza.zzc(cls);
        if (zzfxVarZzc.zza()) {
            int i3 = zzgh.$r8$clinit;
            return zzge.zze(zzgm.zza(), zzen.zza(), zzfxVarZzc.zzb());
        }
        int i4 = zzgh.$r8$clinit;
        return zzgd.zzj(cls, zzfxVarZzc, zzgg.zza(), zzfo.zza(), zzgm.zza(), zzfxVarZzc.zzc() + (-1) != 1 ? zzen.zza() : null, zzfw.zza());
    }
}
