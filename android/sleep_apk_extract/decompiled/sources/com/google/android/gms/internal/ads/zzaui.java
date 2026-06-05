package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
final class zzaui implements zzatz {
    final /* synthetic */ Context zza;
    private File zzb = null;

    public zzaui(Context context) {
        this.zza = context;
    }

    @Override // com.google.android.gms.internal.ads.zzatz
    public final File zza() {
        if (this.zzb == null) {
            this.zzb = new File(this.zza.getCacheDir(), "volley");
        }
        return this.zzb;
    }
}
