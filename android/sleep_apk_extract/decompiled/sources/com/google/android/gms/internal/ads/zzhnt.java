package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhnt {
    private final Map zza;
    private final Map zzb;
    private final Map zzc;
    private final Map zzd;

    public zzhnt(zzhnw zzhnwVar) {
        this.zza = new HashMap(zzhnwVar.zzg());
        this.zzb = new HashMap(zzhnwVar.zzh());
        this.zzc = new HashMap(zzhnwVar.zzi());
        this.zzd = new HashMap(zzhnwVar.zzj());
    }

    public final zzhnt zza(zzhlu zzhluVar) throws GeneralSecurityException {
        zzhnv zzhnvVar = new zzhnv(zzhluVar.zzb(), zzhluVar.zzc(), null);
        Map map = this.zza;
        if (!map.containsKey(zzhnvVar)) {
            map.put(zzhnvVar, zzhluVar);
            return this;
        }
        zzhlu zzhluVar2 = (zzhlu) map.get(zzhnvVar);
        if (zzhluVar2.equals(zzhluVar) && zzhluVar.equals(zzhluVar2)) {
            return this;
        }
        throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: ".concat(zzhnvVar.toString()));
    }

    public final zzhnt zzb(zzhlr zzhlrVar) throws GeneralSecurityException {
        zzhnu zzhnuVar = new zzhnu(zzhlrVar.zzc(), zzhlrVar.zzb(), null);
        Map map = this.zzb;
        if (!map.containsKey(zzhnuVar)) {
            map.put(zzhnuVar, zzhlrVar);
            return this;
        }
        zzhlr zzhlrVar2 = (zzhlr) map.get(zzhnuVar);
        if (zzhlrVar2.equals(zzhlrVar) && zzhlrVar.equals(zzhlrVar2)) {
            return this;
        }
        throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: ".concat(zzhnuVar.toString()));
    }

    public final zzhnt zzc(zzhmy zzhmyVar) throws GeneralSecurityException {
        zzhnv zzhnvVar = new zzhnv(zzhmyVar.zzb(), zzhmyVar.zzc(), null);
        Map map = this.zzc;
        if (!map.containsKey(zzhnvVar)) {
            map.put(zzhnvVar, zzhmyVar);
            return this;
        }
        zzhmy zzhmyVar2 = (zzhmy) map.get(zzhnvVar);
        if (zzhmyVar2.equals(zzhmyVar) && zzhmyVar.equals(zzhmyVar2)) {
            return this;
        }
        throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: ".concat(zzhnvVar.toString()));
    }

    public final zzhnt zzd(zzhmv zzhmvVar) throws GeneralSecurityException {
        zzhnu zzhnuVar = new zzhnu(zzhmvVar.zzc(), zzhmvVar.zzb(), null);
        Map map = this.zzd;
        if (!map.containsKey(zzhnuVar)) {
            map.put(zzhnuVar, zzhmvVar);
            return this;
        }
        zzhmv zzhmvVar2 = (zzhmv) map.get(zzhnuVar);
        if (zzhmvVar2.equals(zzhmvVar) && zzhmvVar.equals(zzhmvVar2)) {
            return this;
        }
        throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: ".concat(zzhnuVar.toString()));
    }

    public final /* synthetic */ Map zze() {
        return this.zza;
    }

    public final /* synthetic */ Map zzf() {
        return this.zzb;
    }

    public final /* synthetic */ Map zzg() {
        return this.zzc;
    }

    public final /* synthetic */ Map zzh() {
        return this.zzd;
    }

    public zzhnt() {
        this.zza = new HashMap();
        this.zzb = new HashMap();
        this.zzc = new HashMap();
        this.zzd = new HashMap();
    }
}
