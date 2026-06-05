package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgcm {
    private static zzgcm zzb;
    final zzgci zza;

    private zzgcm(Context context) {
        this.zza = zzgci.zza(context);
        zzgch.zza(context);
    }

    public static final zzgcm zza(Context context) {
        zzgcm zzgcmVar;
        synchronized (zzgcm.class) {
            try {
                if (zzb == null) {
                    zzb = new zzgcm(context);
                }
                zzgcmVar = zzb;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzgcmVar;
    }

    public final void zzb(zzgcg zzgcgVar) {
        synchronized (zzgcm.class) {
            zzgci zzgciVar = this.zza;
            zzgciVar.zzf("vendor_scoped_gpid_v2_id");
            zzgciVar.zzf("vendor_scoped_gpid_v2_creation_time");
        }
    }
}
