package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzch;
import com.google.android.gms.internal.ads.zzbuy;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzb {
    private static volatile zzch zza;

    public static zzch zza(Context context) {
        if (zza == null) {
            synchronized (zzb.class) {
                try {
                    if (zza == null) {
                        zza = zzay.zzb().zzd(context, new zzbuy());
                    }
                } finally {
                }
            }
        }
        return zza;
    }
}
