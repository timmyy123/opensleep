package com.google.android.gms.internal.ads;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhnj {
    private final Map zza;
    private final Map zzb;

    public /* synthetic */ zzhnj(zzhng zzhngVar, byte[] bArr) {
        this.zza = new HashMap(zzhngVar.zzc());
        this.zzb = new HashMap(zzhngVar.zzd());
    }

    private final Object zzf(zzhdq zzhdqVar, Class cls) throws GeneralSecurityException {
        zzhnh zzhnhVar = new zzhnh(zzhdqVar.getClass(), cls, null);
        Map map = this.zza;
        if (map.containsKey(zzhnhVar)) {
            return ((zzhnf) map.get(zzhnhVar)).zza(zzhdqVar);
        }
        String string = zzhnhVar.toString();
        throw new GeneralSecurityException(Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(string.length() + 102), "No PrimitiveConstructor for ", string, " available, see https://developers.google.com/tink/faq/registration_errors"));
    }

    public final Object zza(zzhdq zzhdqVar, Class cls) {
        return zzf(zzhdqVar, cls);
    }

    public final Object zzb(zzhec zzhecVar, Class cls) throws GeneralSecurityException {
        Map map = this.zzb;
        if (!map.containsKey(cls)) {
            throw new GeneralSecurityException("No wrapper found for ".concat(cls.toString()));
        }
        final zzhnl zzhnlVar = (zzhnl) map.get(cls);
        return zzhnlVar.zzd(zzhecVar, new zzhnk() { // from class: com.google.android.gms.internal.ads.zzhni
            @Override // com.google.android.gms.internal.ads.zzhnk
            public final /* synthetic */ Object zza(zzhdz zzhdzVar) {
                return this.zza.zze(zzhnlVar, zzhdzVar);
            }
        });
    }

    public final /* synthetic */ Map zzc() {
        return this.zza;
    }

    public final /* synthetic */ Map zzd() {
        return this.zzb;
    }

    public final /* synthetic */ Object zze(zzhnl zzhnlVar, zzhdz zzhdzVar) {
        return zzf(zzhdzVar.zza(), zzhnlVar.zzb());
    }
}
