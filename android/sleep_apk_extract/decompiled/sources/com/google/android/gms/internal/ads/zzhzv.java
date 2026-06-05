package com.google.android.gms.internal.ads;

import java.security.Provider;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
final class zzhzv implements zzhzy {
    private final zziah zza;

    @Override // com.google.android.gms.internal.ads.zzhzy
    public final Object zza(String str) {
        Iterator it = zzhzz.zza("GmsCore_OpenSSL", "AndroidOpenSSL").iterator();
        while (it.hasNext()) {
            try {
                return this.zza.zza(str, (Provider) it.next());
            } catch (Exception unused) {
            }
        }
        return this.zza.zza(str, null);
    }
}
