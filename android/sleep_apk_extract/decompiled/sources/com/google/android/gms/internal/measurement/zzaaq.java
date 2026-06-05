package com.google.android.gms.internal.measurement;

import java.util.Set;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes3.dex */
public final class zzaaq implements zzaai {
    private final String zza;
    private final Level zzb;
    private final Set zzc;
    private final zzzq zzd;
    private final int zze;

    public /* synthetic */ zzaaq(byte[] bArr) {
        this("", true, 2, Level.ALL, false, zzaas.zzb, zzaas.zzc);
    }

    @Override // com.google.android.gms.internal.measurement.zzaai
    public final zzzf zza(String str) {
        return new zzaas(this.zza, str, true, 2, this.zzb, this.zzc, this.zzd, null);
    }

    public final zzaaq zzb(boolean z) {
        Set set = this.zzc;
        zzzq zzzqVar = this.zzd;
        return new zzaaq(this.zza, true, 2, Level.OFF, false, set, zzzqVar);
    }

    private zzaaq(String str, boolean z, int i, Level level, boolean z2, Set set, zzzq zzzqVar) {
        this.zza = "";
        this.zze = 2;
        this.zzb = level;
        this.zzc = set;
        this.zzd = zzzqVar;
    }
}
