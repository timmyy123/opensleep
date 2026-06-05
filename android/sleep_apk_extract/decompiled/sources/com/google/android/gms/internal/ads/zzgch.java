package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgch {
    private static zzgch zzb;
    final zzgci zza;

    private zzgch(Context context) {
        this.zza = zzgci.zza(context);
    }

    public static final zzgch zza(Context context) {
        zzgch zzgchVar;
        synchronized (zzgch.class) {
            try {
                if (zzb == null) {
                    zzb = new zzgch(context);
                }
                zzgchVar = zzb;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzgchVar;
    }

    public final void zzb(boolean z) {
        synchronized (zzgch.class) {
            try {
                zzgci zzgciVar = this.zza;
                zzgciVar.zzb("paidv2_publisher_option", Boolean.valueOf(z));
                if (!z) {
                    zzgciVar.zzf("paidv2_creation_time");
                    zzgciVar.zzf("paidv2_id");
                    zzgciVar.zzf("vendor_scoped_gpid_v2_id");
                    zzgciVar.zzf("vendor_scoped_gpid_v2_creation_time");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean zzc() {
        boolean zZze;
        synchronized (zzgch.class) {
            zZze = this.zza.zze("paidv2_publisher_option", true);
        }
        return zZze;
    }

    public final void zzd(boolean z) {
        synchronized (zzgch.class) {
            this.zza.zzb("paidv2_user_option", Boolean.valueOf(z));
        }
    }

    public final boolean zze() {
        boolean zZze;
        synchronized (zzgch.class) {
            zZze = this.zza.zze("paidv2_user_option", true);
        }
        return zZze;
    }
}
