package com.google.android.gms.internal.ads;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhic extends zzhet {
    private final zzhii zza;
    private final zzibb zzb;
    private final zziaz zzc;

    @Nullable
    private final Integer zzd;

    private zzhic(zzhii zzhiiVar, zzibb zzibbVar, zziaz zziazVar, @Nullable Integer num) {
        this.zza = zzhiiVar;
        this.zzb = zzibbVar;
        this.zzc = zziazVar;
        this.zzd = num;
    }

    public static zzhic zzd(zzhih zzhihVar, zzibb zzibbVar, @Nullable Integer num) throws GeneralSecurityException {
        zziaz zziazVarZzb;
        zzhih zzhihVar2 = zzhih.zzc;
        if (zzhihVar != zzhihVar2 && num == null) {
            String string = zzhihVar.toString();
            throw new GeneralSecurityException(Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(string.length() + 62), "For given Variant ", string, " the value of idRequirement must be non-null"));
        }
        if (zzhihVar == zzhihVar2 && num != null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("For given Variant NO_PREFIX the value of idRequirement must be null");
            return null;
        }
        if (zzibbVar.zzd() != 32) {
            int iZzd = zzibbVar.zzd();
            throw new GeneralSecurityException(zzba$$ExternalSyntheticOutline0.m(iZzd, "XChaCha20Poly1305 key must be constructed with key of length 32 bytes, not ", new StringBuilder(String.valueOf(iZzd).length() + 75)));
        }
        zzhii zzhiiVarZzb = zzhii.zzb(zzhihVar);
        if (zzhiiVarZzb.zzc() == zzhihVar2) {
            zziazVarZzb = zzhms.zza;
        } else if (zzhiiVarZzb.zzc() == zzhih.zzb) {
            zziazVarZzb = zzhms.zza(num.intValue());
        } else {
            if (zzhiiVarZzb.zzc() != zzhih.zza) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("Unknown Variant: ".concat(zzhiiVarZzb.zzc().toString()));
                return null;
            }
            zziazVarZzb = zzhms.zzb(num.intValue());
        }
        return new zzhic(zzhiiVarZzb, zzibbVar, zziazVarZzb, num);
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

    public final zzhii zzf() {
        return this.zza;
    }
}
