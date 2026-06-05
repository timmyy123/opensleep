package com.google.android.gms.internal.ads;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.security.GeneralSecurityException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhlo {
    private static final Logger zza = Logger.getLogger(zzhlo.class.getName());
    private static final zzhlo zzd = new zzhlo();
    private final ConcurrentMap zzb = new ConcurrentHashMap();
    private final ConcurrentMap zzc = new ConcurrentHashMap();

    public static zzhlo zza() {
        return zzd;
    }

    private final synchronized zzhdr zzg(String str) {
        ConcurrentMap concurrentMap;
        concurrentMap = this.zzb;
        if (!concurrentMap.containsKey(str)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 98);
            sb.append("No key manager found for key type ");
            sb.append(str);
            sb.append(", see https://developers.google.com/tink/faq/registration_errors");
            throw new GeneralSecurityException(sb.toString());
        }
        return (zzhdr) concurrentMap.get(str);
    }

    private final synchronized void zzh(zzhdr zzhdrVar, boolean z, boolean z2) {
        try {
            String strZzb = zzhdrVar.zzb();
            if (z2) {
                ConcurrentMap concurrentMap = this.zzc;
                if (concurrentMap.containsKey(strZzb) && !((Boolean) concurrentMap.get(strZzb)).booleanValue()) {
                    throw new GeneralSecurityException("New keys are already disallowed for key type ".concat(strZzb));
                }
            }
            ConcurrentMap concurrentMap2 = this.zzb;
            zzhdr zzhdrVar2 = (zzhdr) concurrentMap2.get(strZzb);
            if (zzhdrVar2 != null && !zzhdrVar2.getClass().equals(zzhdrVar.getClass())) {
                zza.logp(Level.WARNING, "com.google.crypto.tink.internal.KeyManagerRegistry", "insertKeyManager", "Attempted overwrite of a registered key manager for key type ".concat(strZzb));
                throw new GeneralSecurityException("typeUrl (" + strZzb + ") is already registered with " + zzhdrVar2.getClass().getName() + ", cannot be re-registered with " + zzhdrVar.getClass().getName());
            }
            concurrentMap2.putIfAbsent(strZzb, zzhdrVar);
            this.zzc.put(strZzb, Boolean.valueOf(z2));
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zzb(zzhdr zzhdrVar, boolean z) {
        zzf(zzhdrVar, 1, z);
    }

    public final zzhdr zzc(String str, Class cls) throws GeneralSecurityException {
        zzhdr zzhdrVarZzg = zzg(str);
        if (zzhdrVarZzg.zzc().equals(cls)) {
            return zzhdrVarZzg;
        }
        String name = cls.getName();
        String strValueOf = String.valueOf(zzhdrVarZzg.getClass());
        String string = zzhdrVarZzg.zzc().toString();
        StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(name.length() + 53, 23, strValueOf) + string.length());
        FileInsert$$ExternalSyntheticOutline0.m(sb, "Primitive type ", name, " not supported by key manager of type ", strValueOf);
        throw new GeneralSecurityException(FileInsert$$ExternalSyntheticOutline0.m(sb, ", which only supports: ", string));
    }

    public final zzhdr zzd(String str) {
        return zzg(str);
    }

    public final boolean zze(String str) {
        return ((Boolean) this.zzc.get(str)).booleanValue();
    }

    public final synchronized void zzf(zzhdr zzhdrVar, int i, boolean z) {
        if (!zzhkr.zza(i)) {
            throw new GeneralSecurityException("Cannot register key manager: FIPS compatibility insufficient");
        }
        zzh(zzhdrVar, false, z);
    }
}
