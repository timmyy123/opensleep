package com.google.android.gms.internal.measurement;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public final class zzrw {
    private final Context zza;
    private final zzsh zzb = new zzsh();

    public /* synthetic */ zzrw(Context context, byte[] bArr) {
        zzsq.zza(context != null, "Context cannot be null", new Object[0]);
        this.zza = context.getApplicationContext();
    }

    public final zzrx zza() {
        return new zzrx(this, null);
    }

    public final /* synthetic */ Context zzb() {
        return this.zza;
    }

    public final /* synthetic */ zzsh zzc() {
        return this.zzb;
    }
}
