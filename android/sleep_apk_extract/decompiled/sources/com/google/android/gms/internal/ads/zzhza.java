package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
final class zzhza implements zzhek {
    private final zzhnc zza;

    public zzhza(zzhnc zzhncVar, zzhmd zzhmdVar) {
        this.zza = zzhncVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhek
    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        Iterator it = this.zza.zza(bArr).iterator();
        while (it.hasNext()) {
            try {
                ((zzhzb) it.next()).zza.zza(bArr, bArr2);
                return;
            } catch (GeneralSecurityException unused) {
            }
        }
        zzbuy$$ExternalSyntheticBUOutline0.m("invalid signature");
    }
}
