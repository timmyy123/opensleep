package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgck extends zzgcj {
    private static zzgck zzd;

    private zzgck(Context context) {
        super(context, "paidv1_id", "paidv1_creation_time", "PaidV1LifecycleImpl");
    }

    public static final zzgck zzh(Context context) {
        zzgck zzgckVar;
        synchronized (zzgck.class) {
            try {
                if (zzd == null) {
                    zzd = new zzgck(context);
                }
                zzgckVar = zzd;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzgckVar;
    }

    public final zzgcg zzi(long j, boolean z) {
        zzgcg zzgcgVarZza;
        synchronized (zzgck.class) {
            zzgcgVarZza = zza(null, null, j, z);
        }
        return zzgcgVarZza;
    }

    public final zzgcg zzj(String str, String str2, long j, boolean z) {
        zzgcg zzgcgVarZza;
        synchronized (zzgck.class) {
            zzgcgVarZza = zza(str, str2, j, z);
        }
        return zzgcgVarZza;
    }

    public final void zzk() {
        synchronized (zzgck.class) {
            zzc(false);
        }
    }

    public final void zzl() {
        synchronized (zzgck.class) {
            zzc(true);
        }
    }
}
