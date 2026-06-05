package com.google.android.gms.internal.measurement;

import java.util.Set;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes3.dex */
final class zzaar extends zzaag {
    private final String zza;
    private final Level zzb;
    private final Set zzc;
    private final zzzq zzd;
    private final int zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzaar(String str, String str2, boolean z, int i, boolean z2, boolean z3) {
        super(str2);
        Level level = Level.ALL;
        int i2 = zzaas.$r8$clinit;
        this.zza = "";
        this.zze = 2;
        this.zzb = level;
        this.zzc = zzaas.zzb;
        this.zzd = zzaas.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzzf
    public final boolean zzb(Level level) {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzzf
    public final void zzc(zzzd zzzdVar) {
        String strZza = (String) zzzdVar.zzl().zzd(zzyw.zza);
        if (strZza == null) {
            strZza = zza();
        }
        if (strZza == null) {
            strZza = zzzdVar.zzg().zza();
            int iIndexOf = strZza.indexOf(36, strZza.lastIndexOf(46));
            if (iIndexOf >= 0) {
                strZza = strZza.substring(0, iIndexOf);
            }
        }
        String str = this.zza;
        zzaas.zzi(zzzdVar, zzaal.zza(str, strZza, true), 2, this.zzb, this.zzc, this.zzd);
    }
}
