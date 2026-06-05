package com.google.android.gms.internal.measurement;

import java.io.InputStream;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes3.dex */
public final class zzna implements zzrt {
    private final boolean zza;

    public zzna(boolean z) {
        this.zza = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzrt
    public final /* bridge */ /* synthetic */ Object zza(zzrs zzrsVar) {
        zznd zzndVarZzb;
        zzrsVar.getClass();
        InputStream inputStreamZzc = zzst.zzc(zzrsVar);
        try {
            int i = 4096;
            if (this.zza) {
                if (inputStreamZzc instanceof zzsf) {
                    long length = ((zzsf) inputStreamZzc).zza().length();
                    if (length == 0) {
                        i = 512;
                    } else if (length < 4096) {
                        i = (int) length;
                    }
                }
                zzndVarZzb = zznd.zzb(zzacv.zzM(inputStreamZzc, i), true);
                zzndVarZzb.getClass();
            } else {
                zzndVarZzb = zznd.zzb(zzacv.zzM(inputStreamZzc, 4096), false);
                zzndVarZzb.getClass();
            }
            CloseableKt.closeFinally(inputStreamZzc, null);
            return zzndVarZzb;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(inputStreamZzc, th);
                throw th2;
            }
        }
    }
}
