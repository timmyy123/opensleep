package com.google.android.gms.internal.serialization;

import java.util.Set;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhh implements zzgz {
    private final String zza;
    private final Level zzb;
    private final Set zzc;
    private final zzgh zzd;
    private final int zze;

    public /* synthetic */ zzhh(byte[] bArr) {
        this("", true, 2, Level.ALL, false, zzhj.zzb, zzhj.zzc);
    }

    @Override // com.google.android.gms.internal.serialization.zzgz
    public final zzfw zza(String str) {
        return new zzhj(this.zza, str, true, 2, this.zzb, this.zzc, this.zzd, null);
    }

    public final zzhh zzb(boolean z) {
        Set set = this.zzc;
        zzgh zzghVar = this.zzd;
        return new zzhh(this.zza, true, 2, Level.OFF, false, set, zzghVar);
    }

    private zzhh(String str, boolean z, int i, Level level, boolean z2, Set set, zzgh zzghVar) {
        this.zza = "";
        this.zze = 2;
        this.zzb = level;
        this.zzc = set;
        this.zzd = zzghVar;
    }
}
