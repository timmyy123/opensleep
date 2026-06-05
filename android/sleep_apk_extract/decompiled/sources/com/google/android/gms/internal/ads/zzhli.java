package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhli {
    private final Map zza;
    private final Map zzb;

    public /* synthetic */ zzhli(Map map, Map map2, byte[] bArr) {
        this.zza = map;
        this.zzb = map2;
    }

    public static zzhlh zza() {
        return new zzhlh(null);
    }

    public final Enum zzb(Object obj) throws GeneralSecurityException {
        Enum r1 = (Enum) this.zzb.get(obj);
        if (r1 != null) {
            return r1;
        }
        throw new GeneralSecurityException("Unable to convert object enum: ".concat(String.valueOf(obj)));
    }

    public final Object zzc(Enum r2) throws GeneralSecurityException {
        Object obj = this.zza.get(r2);
        if (obj != null) {
            return obj;
        }
        throw new GeneralSecurityException("Unable to convert proto enum: ".concat(String.valueOf(r2)));
    }
}
