package com.google.android.play.core.appupdate;

import android.content.Context;

/* JADX INFO: loaded from: classes4.dex */
public final class zzb {
    private static zza zza;

    public static synchronized zza zza(Context context) {
        try {
            if (zza == null) {
                zzab zzabVar = new zzab(null);
                zzabVar.zzb(new zzi(com.google.android.play.core.appupdate.internal.zzz.zza(context)));
                zza = zzabVar.zza();
            }
        } catch (Throwable th) {
            throw th;
        }
        return zza;
    }
}
