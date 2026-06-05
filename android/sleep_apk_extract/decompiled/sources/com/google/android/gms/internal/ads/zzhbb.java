package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
final class zzhbb extends zzhaz {
    public /* synthetic */ zzhbb(byte[] bArr) {
        super(null);
    }

    @Override // com.google.android.gms.internal.ads.zzhaz
    public final void zza(zzhbc zzhbcVar, Set set, Set set2) {
        synchronized (zzhbcVar) {
            try {
                if (zzhbcVar.seenExceptionsField == null) {
                    zzhbcVar.seenExceptionsField = set2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhaz
    public final int zzb(zzhbc zzhbcVar) {
        int i;
        synchronized (zzhbcVar) {
            i = zzhbcVar.remainingField - 1;
            zzhbcVar.remainingField = i;
        }
        return i;
    }
}
