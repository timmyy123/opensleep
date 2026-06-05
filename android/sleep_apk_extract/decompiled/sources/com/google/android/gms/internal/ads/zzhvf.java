package com.google.android.gms.internal.ads;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhvf extends zzhxj {
    private final zzhvl zza;
    private final zzibb zzb;

    private zzhvf(zzhvl zzhvlVar, zzibb zzibbVar) {
        this.zza = zzhvlVar;
        this.zzb = zzibbVar;
    }

    public static zzhvf zzc(zzhvl zzhvlVar, zzibb zzibbVar) throws GeneralSecurityException {
        if (zzibbVar.zzd() != 32) {
            int iZzd = zzibbVar.zzd();
            throw new GeneralSecurityException(zzba$$ExternalSyntheticOutline0.m(iZzd, "Ed25519 key must be constructed with key of length 32 bytes, not ", new StringBuilder(String.valueOf(iZzd).length() + 65)));
        }
        if (Arrays.equals(zzhvlVar.zzd().zzc(), zzhlc.zza(zzhlc.zzb(zzibbVar.zzc(zzhdo.zza()))))) {
            return new zzhvf(zzhvlVar, zzibbVar);
        }
        zzbuy$$ExternalSyntheticBUOutline0.m("Ed25519 keys mismatch");
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzhdq
    public final /* synthetic */ zzheh zza() {
        return this.zza.zzf();
    }

    public final zzhve zzd() {
        return this.zza.zzf();
    }

    public final zzhvl zze() {
        return this.zza;
    }

    public final zzibb zzf() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzhxj
    public final /* synthetic */ zzhxk zzg() {
        return this.zza;
    }
}
