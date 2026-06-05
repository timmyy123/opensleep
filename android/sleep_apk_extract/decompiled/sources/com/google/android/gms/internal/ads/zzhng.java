package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhng {
    private final Map zza;
    private final Map zzb;

    public /* synthetic */ zzhng(zzhnj zzhnjVar, byte[] bArr) {
        this.zza = new HashMap(zzhnjVar.zzc());
        this.zzb = new HashMap(zzhnjVar.zzd());
    }

    public final zzhng zza(zzhnf zzhnfVar) throws GeneralSecurityException {
        if (zzhnfVar == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("primitive constructor must be non-null");
            return null;
        }
        zzhnh zzhnhVar = new zzhnh(zzhnfVar.zzb(), zzhnfVar.zzc(), null);
        Map map = this.zza;
        if (!map.containsKey(zzhnhVar)) {
            map.put(zzhnhVar, zzhnfVar);
            return this;
        }
        zzhnf zzhnfVar2 = (zzhnf) map.get(zzhnhVar);
        if (zzhnfVar2.equals(zzhnfVar) && zzhnfVar.equals(zzhnfVar2)) {
            return this;
        }
        throw new GeneralSecurityException("Attempt to register non-equal PrimitiveConstructor object for already existing object of type: ".concat(zzhnhVar.toString()));
    }

    public final zzhng zzb(zzhnl zzhnlVar) throws GeneralSecurityException {
        Map map = this.zzb;
        Class clsZza = zzhnlVar.zza();
        if (!map.containsKey(clsZza)) {
            map.put(clsZza, zzhnlVar);
            return this;
        }
        zzhnl zzhnlVar2 = (zzhnl) map.get(clsZza);
        if (zzhnlVar2.equals(zzhnlVar) && zzhnlVar.equals(zzhnlVar2)) {
            return this;
        }
        throw new GeneralSecurityException("Attempt to register non-equal PrimitiveWrapper object or input class object for already existing object of type".concat(clsZza.toString()));
    }

    public final /* synthetic */ Map zzc() {
        return this.zza;
    }

    public final /* synthetic */ Map zzd() {
        return this.zzb;
    }

    public /* synthetic */ zzhng(byte[] bArr) {
        this.zza = new HashMap();
        this.zzb = new HashMap();
    }
}
