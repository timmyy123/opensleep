package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhnm implements zzhns {
    private final String zza;
    private final zziaz zzb;
    private final zzida zzc;
    private final zzhsp zzd;
    private final zzhtm zze;

    @Nullable
    private final Integer zzf;

    private zzhnm(String str, zziaz zziazVar, zzida zzidaVar, zzhsp zzhspVar, zzhtm zzhtmVar, @Nullable Integer num) {
        this.zza = str;
        this.zzb = zziazVar;
        this.zzc = zzidaVar;
        this.zzd = zzhspVar;
        this.zze = zzhtmVar;
        this.zzf = num;
    }

    public static zzhnm zza(String str, zzida zzidaVar, zzhsp zzhspVar, zzhtm zzhtmVar, @Nullable Integer num) throws GeneralSecurityException {
        if (zzhtmVar == zzhtm.RAW) {
            if (num != null) {
                zzbuy$$ExternalSyntheticBUOutline0.m("Keys with output prefix type raw should not have an id requirement.");
                return null;
            }
        } else if (num == null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Keys with output prefix type different from raw should have an id requirement.");
            return null;
        }
        return new zzhnm(str, zzhnz.zzb(str), zzidaVar, zzhspVar, zzhtmVar, num);
    }

    public final zzida zzb() {
        return this.zzc;
    }

    public final zzhsp zzc() {
        return this.zzd;
    }

    public final zzhtm zzd() {
        return this.zze;
    }

    @Nullable
    public final Integer zze() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzhns
    public final zziaz zzf() {
        return this.zzb;
    }

    public final String zzg() {
        return this.zza;
    }
}
