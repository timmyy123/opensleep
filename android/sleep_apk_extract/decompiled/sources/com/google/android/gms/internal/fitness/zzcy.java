package com.google.android.gms.internal.fitness;

import android.util.Log;
import com.google.android.gms.common.api.internal.BaseImplementation$ResultHolder;
import com.google.android.gms.fitness.result.DataReadResult;

/* JADX INFO: loaded from: classes3.dex */
final class zzcy extends zzav {
    private final BaseImplementation$ResultHolder zza;
    private int zzb = 0;
    private DataReadResult zzc;

    @Override // com.google.android.gms.internal.fitness.zzaw
    public final void zzb(DataReadResult dataReadResult) {
        synchronized (this) {
            try {
                if (Log.isLoggable("Fitness", 2)) {
                    int i = this.zzb;
                    StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 22);
                    sb.append("Received batch result ");
                    sb.append(i);
                    Log.v("Fitness", sb.toString());
                }
                DataReadResult dataReadResult2 = this.zzc;
                if (dataReadResult2 == null) {
                    this.zzc = dataReadResult;
                } else {
                    dataReadResult2.zzb(dataReadResult);
                }
                int i2 = this.zzb + 1;
                this.zzb = i2;
                if (i2 == this.zzc.zza()) {
                    this.zza.setResult(this.zzc);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
