package com.google.android.gms.internal.ads;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes3.dex */
public final class zzaos implements zzanl {
    public static final zzand zza = new zzand(zzgwm.zzi(), -9223372036854775807L, -9223372036854775807L);
    private final zzet zzb = new zzet();
    private final zzet zzc = new zzet();
    private final zzaor zzd;
    private Inflater zze;

    public zzaos(List list) {
        zzaor zzaorVar = new zzaor();
        this.zzd = zzaorVar;
        zzaorVar.zza(new String((byte[]) list.get(0), StandardCharsets.UTF_8));
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x006f  */
    @Override // com.google.android.gms.internal.ads.zzanl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza(byte[] bArr, int i, int i2, zzank zzankVar, zzdt zzdtVar) {
        zzand zzandVar;
        zzet zzetVar = this.zzb;
        zzetVar.zzb(bArr, i2 + i);
        zzetVar.zzh(i);
        if (this.zze == null) {
            this.zze = new Inflater();
        }
        zzet zzetVar2 = this.zzc;
        if (zzfl.zzO(zzetVar, zzetVar2, this.zze)) {
            zzetVar.zzb(zzetVar2.zzi(), zzetVar2.zze());
        }
        zzaor zzaorVar = this.zzd;
        zzaorVar.zzc();
        int iZzd = zzetVar.zzd();
        if (iZzd < 2 || zzetVar.zzt() != iZzd) {
            zzandVar = zza;
        } else {
            zzaorVar.zzd(zzetVar);
            long jZzf = zzaorVar.zzf();
            zzcx zzcxVarZzb = zzaorVar.zzb(zzetVar);
            long jZzf2 = -9223372036854775807L;
            if (jZzf != -9223372036854775807L) {
                if (zzaorVar.zze() != -9223372036854775807L) {
                    jZzf2 = zzaorVar.zzf() > zzaorVar.zze() ? zzaorVar.zzf() - zzaorVar.zze() : zzaorVar.zzf();
                }
            }
            zzandVar = new zzand(zzcxVarZzb != null ? zzgwm.zzj(zzcxVarZzb) : zzgwm.zzi(), zzaorVar.zze(), jZzf2);
        }
        zzdtVar.zza(zzandVar);
    }
}
