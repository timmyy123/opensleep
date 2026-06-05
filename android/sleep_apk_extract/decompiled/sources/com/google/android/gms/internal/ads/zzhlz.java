package com.google.android.gms.internal.ads;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhlz extends zzhdq {
    private final zzhnm zza;

    public zzhlz(zzhnm zzhnmVar, @Nullable zzhel zzhelVar) {
        zze(zzhnmVar, zzhelVar);
        this.zza = zzhnmVar;
    }

    private static void zze(zzhnm zzhnmVar, @Nullable zzhel zzhelVar) {
        int i = zzhlx.zzb[zzhnmVar.zzc().ordinal()];
    }

    @Override // com.google.android.gms.internal.ads.zzhdq
    public final zzheh zza() {
        zzhnm zzhnmVar = this.zza;
        return new zzhly(zzhnmVar.zzg(), zzhnmVar.zzd(), null);
    }

    @Override // com.google.android.gms.internal.ads.zzhdq
    @Nullable
    public final Integer zzb() {
        return this.zza.zze();
    }

    public final zzhnm zzc(@Nullable zzhel zzhelVar) {
        zzhnm zzhnmVar = this.zza;
        zze(zzhnmVar, zzhelVar);
        return zzhnmVar;
    }

    public final zziaz zzd() {
        zzhnm zzhnmVar = this.zza;
        if (zzhnmVar.zzd().equals(zzhtm.RAW)) {
            return zziaz.zza(new byte[0]);
        }
        if (zzhnmVar.zzd().equals(zzhtm.TINK)) {
            return zzhms.zzb(zzhnmVar.zze().intValue());
        }
        if (zzhnmVar.zzd().equals(zzhtm.LEGACY) || zzhnmVar.zzd().equals(zzhtm.CRUNCHY)) {
            return zzhms.zza(zzhnmVar.zze().intValue());
        }
        zzbuy$$ExternalSyntheticBUOutline0.m("Unknown output prefix type");
        return null;
    }
}
