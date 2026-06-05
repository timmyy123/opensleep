package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfyy extends Exception {
    private final int zza;

    public zzfyy(int i, String str) {
        super(str);
        this.zza = i;
    }

    public final int zza() {
        return this.zza;
    }

    public zzfyy(int i, Throwable th) {
        super(th);
        this.zza = i;
    }
}
