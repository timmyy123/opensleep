package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzaie extends zzafk {
    public zzaie(final zzagl zzaglVar, int i, long j, long j2) {
        long j3;
        Objects.requireNonNull(zzaglVar);
        zzafh zzafhVar = new zzafh() { // from class: com.google.android.gms.internal.ads.zzaic
            @Override // com.google.android.gms.internal.ads.zzafh
            public final /* synthetic */ long zza(long j4) {
                return zzaglVar.zzb(j4);
            }
        };
        zzaid zzaidVar = new zzaid(zzaglVar, i, null);
        long jZza = zzaglVar.zza();
        long j4 = zzaglVar.zzj;
        int i2 = zzaglVar.zzd;
        if (i2 > 0) {
            j3 = ((((long) i2) + ((long) zzaglVar.zzc)) / 2) + 1;
        } else {
            int i3 = zzaglVar.zza;
            long j5 = 4096;
            if (i3 == zzaglVar.zzb && i3 > 0) {
                j5 = i3;
            }
            j3 = 64 + (((j5 * ((long) zzaglVar.zzg)) * ((long) zzaglVar.zzh)) / 8);
        }
        super(zzafhVar, zzaidVar, jZza, 0L, j4, j, j2, j3, Math.max(6, zzaglVar.zzc));
    }
}
