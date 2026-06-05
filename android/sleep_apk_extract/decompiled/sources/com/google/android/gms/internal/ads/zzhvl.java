package com.google.android.gms.internal.ads;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhvl extends zzhxk {
    private final zzhve zza;
    private final zziaz zzb;
    private final zziaz zzc;

    @Nullable
    private final Integer zzd;

    private zzhvl(zzhve zzhveVar, zziaz zziazVar, zziaz zziazVar2, @Nullable Integer num) {
        this.zza = zzhveVar;
        this.zzb = zziazVar;
        this.zzc = zziazVar2;
        this.zzd = num;
    }

    public static zzhvl zzc(zzhvd zzhvdVar, zziaz zziazVar, @Nullable Integer num) throws GeneralSecurityException {
        zziaz zziazVarZza;
        zzhve zzhveVarZzb = zzhve.zzb(zzhvdVar);
        zzhvd zzhvdVar2 = zzhvd.zzd;
        if (!zzhvdVar.equals(zzhvdVar2) && num == null) {
            String string = zzhvdVar.toString();
            throw new GeneralSecurityException(Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(string.length() + 62), "For given Variant ", string, " the value of idRequirement must be non-null"));
        }
        if (zzhvdVar == zzhvdVar2 && num != null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("For given Variant NO_PREFIX the value of idRequirement must be null");
            return null;
        }
        if (zziazVar.zzd() != 32) {
            int iZzd = zziazVar.zzd();
            throw new GeneralSecurityException(zzba$$ExternalSyntheticOutline0.m(iZzd, "Ed25519 key must be constructed with key of length 32 bytes, not ", new StringBuilder(String.valueOf(iZzd).length() + 65)));
        }
        if (zzhveVarZzb.zzc() == zzhvdVar2) {
            zziazVarZza = zzhms.zza;
        } else if (zzhveVarZzb.zzc() == zzhvd.zzb || zzhveVarZzb.zzc() == zzhvd.zzc) {
            zziazVarZza = zzhms.zza(num.intValue());
        } else {
            if (zzhveVarZzb.zzc() != zzhvd.zza) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("Unknown Variant: ".concat(zzhveVarZzb.zzc().toString()));
                return null;
            }
            zziazVarZza = zzhms.zzb(num.intValue());
        }
        return new zzhvl(zzhveVarZzb, zziazVar, zziazVarZza, num);
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

    public final zziaz zzd() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzhxk
    public final zziaz zze() {
        return this.zzc;
    }

    public final zzhve zzf() {
        return this.zza;
    }
}
