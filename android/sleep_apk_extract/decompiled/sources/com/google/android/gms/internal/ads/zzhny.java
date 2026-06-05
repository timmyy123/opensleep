package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhny extends RuntimeException {
    public zzhny(String str) {
        super(str);
    }

    public static Object zza(zzhnx zzhnxVar) {
        try {
            return zzhnxVar.zza();
        } catch (Exception e) {
            throw new zzhny(e);
        }
    }

    public zzhny(String str, Throwable th) {
        super(str, th);
    }

    public zzhny(Throwable th) {
        super(th);
    }
}
