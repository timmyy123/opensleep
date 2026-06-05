package com.google.android.gms.internal.ads;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.google.android.gms.internal.ads.zzhap;

/* JADX INFO: loaded from: classes3.dex */
final class zzhcl extends zzhap.zzf implements Runnable {
    private final Runnable zza;

    public zzhcl(Runnable runnable) {
        runnable.getClass();
        this.zza = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zza.run();
        } catch (Throwable th) {
            zzb(th);
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhap
    public final String zzd() {
        String string = this.zza.toString();
        return Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(string.length() + 7), "task=[", string, "]");
    }
}
