package com.google.android.gms.vision;

import android.util.SparseIntArray;

/* JADX INFO: loaded from: classes4.dex */
public final class zzc {
    private static final Object zza = new Object();
    private static int zzb;
    private final SparseIntArray zzc = new SparseIntArray();
    private final SparseIntArray zzd = new SparseIntArray();

    public final int zza(int i) {
        synchronized (zza) {
            try {
                int i2 = this.zzc.get(i, -1);
                if (i2 != -1) {
                    return i2;
                }
                int i3 = zzb;
                zzb = i3 + 1;
                this.zzc.append(i, i3);
                this.zzd.append(i3, i);
                return i3;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
