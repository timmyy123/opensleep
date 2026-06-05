package com.google.android.gms.internal.measurement;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class zzqs {
    private final boolean zza = true;
    private final String zzb;
    private final zzacr zzc;
    private final ImmutableMap zzd;
    private final zzqr zze;

    private zzqs(zzqv zzqvVar, zzqr zzqrVar) {
        zzqv.zzi().equals(zzqvVar);
        this.zzb = zzqvVar.zza();
        this.zzc = zzqvVar.zzb();
        zzqvVar.zzc();
        zzqvVar.zzd();
        ImmutableSet.of();
        ImmutableMap.Builder builderBuilderWithExpectedSize = ImmutableMap.builderWithExpectedSize(zzqvVar.zzf() + 3);
        for (zzqx zzqxVar : zzqvVar.zze()) {
            int iZzp = zzqxVar.zzp();
            int i = iZzp - 1;
            if (iZzp == 0) {
                throw null;
            }
            if (i == 0) {
                builderBuilderWithExpectedSize.put(zzqxVar.zza(), Long.valueOf(zzqxVar.zzb()));
            } else if (i == 1) {
                builderBuilderWithExpectedSize.put(zzqxVar.zza(), Boolean.valueOf(zzqxVar.zzc()));
            } else if (i == 2) {
                builderBuilderWithExpectedSize.put(zzqxVar.zza(), Double.valueOf(zzqxVar.zzd()));
            } else if (i == 3) {
                builderBuilderWithExpectedSize.put(zzqxVar.zza(), zzqxVar.zze());
            } else if (i == 4) {
                builderBuilderWithExpectedSize.put(zzqxVar.zza(), zzqxVar.zzf().zzm());
            }
        }
        builderBuilderWithExpectedSize.put("__phenotype_server_token", zzqvVar.zzc());
        builderBuilderWithExpectedSize.put("__phenotype_snapshot_token", zzqvVar.zza());
        builderBuilderWithExpectedSize.put("__phenotype_configuration_version", Long.valueOf(zzqvVar.zzd()));
        this.zzd = builderBuilderWithExpectedSize.buildKeepingLast();
        this.zze = zzqrVar;
    }

    public static zzqs zza(zzqv zzqvVar, zzqr zzqrVar) {
        return new zzqs(zzqvVar, zzqrVar);
    }

    public static zzqs zzb(zzqv zzqvVar, zzqs zzqsVar) {
        return new zzqs(zzqvVar, zzqsVar.zze);
    }

    public static zzqs zzc(zznd zzndVar, zzqr zzqrVar) {
        return new zzqs(zzndVar, zzqrVar);
    }

    public final String zzd() {
        return this.zzb;
    }

    public final zzacr zze() {
        return this.zzc;
    }

    public final ImmutableMap zzf() {
        return this.zzd;
    }

    public final boolean zzg() {
        return this.zze.zzc() == 3;
    }

    public final boolean zzh() {
        return this.zza;
    }

    public final zzmd zzi() {
        return this.zze.zza();
    }

    public final boolean zzj() {
        return this.zze.zzb() == 17;
    }

    public final boolean zzk() {
        int iZzb = this.zze.zzb() - 2;
        return iZzb == 15 || iZzb == 16;
    }

    private zzqs(zznd zzndVar, zzqr zzqrVar) {
        zzndVar.zzi();
        this.zzb = zzndVar.zzd();
        this.zzc = zzndVar.zzg();
        zzndVar.zze();
        zzndVar.zzf();
        Map mapZzh = zzndVar.zzh();
        if (mapZzh != null) {
            ImmutableSet.copyOf((Collection) mapZzh.keySet());
        } else {
            ImmutableSet.of();
        }
        zzmw zzmwVarZzc = zzndVar.zzc();
        ImmutableMap.Builder builderBuilderWithExpectedSize = ImmutableMap.builderWithExpectedSize(zzmwVarZzc.zzf() + 3);
        zzmwVarZzc.zzc(builderBuilderWithExpectedSize);
        builderBuilderWithExpectedSize.put("__phenotype_server_token", zzndVar.zze()).put("__phenotype_snapshot_token", zzndVar.zzd()).put("__phenotype_configuration_version", Long.valueOf(zzndVar.zzf()));
        this.zzd = builderBuilderWithExpectedSize.buildKeepingLast();
        this.zze = zzqrVar;
    }
}
