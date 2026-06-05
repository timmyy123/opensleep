package com.google.android.gms.internal.ads;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhhw extends zzhet {
    private final zzhib zza;
    private final zzibb zzb;
    private final zziaz zzc;

    @Nullable
    private final Integer zzd;

    private zzhhw(zzhib zzhibVar, zzibb zzibbVar, zziaz zziazVar, @Nullable Integer num) {
        this.zza = zzhibVar;
        this.zzb = zzibbVar;
        this.zzc = zziazVar;
        this.zzd = num;
    }

    public static zzhhw zzd(zzhib zzhibVar, zzibb zzibbVar, @Nullable Integer num) throws GeneralSecurityException {
        zziaz zziazVarZzb;
        zzhia zzhiaVarZzc = zzhibVar.zzc();
        zzhia zzhiaVar = zzhia.zzb;
        if (zzhiaVarZzc != zzhiaVar && num == null) {
            String string = zzhibVar.zzc().toString();
            throw new GeneralSecurityException(Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(string.length() + 62), "For given Variant ", string, " the value of idRequirement must be non-null"));
        }
        if (zzhibVar.zzc() == zzhiaVar && num != null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("For given Variant NO_PREFIX the value of idRequirement must be null");
            return null;
        }
        if (zzibbVar.zzd() != 32) {
            int iZzd = zzibbVar.zzd();
            throw new GeneralSecurityException(zzba$$ExternalSyntheticOutline0.m(iZzd, "XAesGcmKey key must be constructed with key of length 32 bytes, not ", new StringBuilder(String.valueOf(iZzd).length() + 68)));
        }
        if (zzhibVar.zzc() == zzhiaVar) {
            zziazVarZzb = zzhms.zza;
        } else {
            if (zzhibVar.zzc() != zzhia.zza) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("Unknown Variant: ".concat(zzhibVar.zzc().toString()));
                return null;
            }
            zziazVarZzb = zzhms.zzb(num.intValue());
        }
        return new zzhhw(zzhibVar, zzibbVar, zziazVarZzb, num);
    }

    @Override // com.google.android.gms.internal.ads.zzhdq
    public final /* synthetic */ zzheh zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzhdq
    @Nullable
    public final Integer zzb() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzhet
    public final zziaz zzc() {
        return this.zzc;
    }

    public final zzibb zze() {
        return this.zzb;
    }

    public final zzhib zzf() {
        return this.zza;
    }
}
