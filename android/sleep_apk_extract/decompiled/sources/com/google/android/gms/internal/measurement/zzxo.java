package com.google.android.gms.internal.measurement;

import java.util.logging.Level;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzxo extends zzxz implements zzyi {
    public zzxo(Level level, boolean z) {
        super(level, false);
    }

    @Override // com.google.android.gms.internal.measurement.zzxz
    public final zzabn zza() {
        return zzabl.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzxz
    public final boolean zzb(zzyd zzydVar) {
        zzzj zzzjVarZzl = zzl();
        int iZza = zzzjVarZzl.zza();
        int i = 0;
        while (true) {
            if (i >= iZza) {
                break;
            }
            if (zzzjVarZzl.zzb(i).zzd() != "eye3tag") {
                i++;
            } else if (zzzjVarZzl.zzd(zzxx.zza) == null) {
                zzyl zzylVar = zzxx.zzi;
                if (zzzjVarZzl.zzd(zzylVar) == null) {
                    zzm(zzylVar, zzyv.SMALL);
                }
            }
        }
        return super.zzb(zzydVar);
    }
}
