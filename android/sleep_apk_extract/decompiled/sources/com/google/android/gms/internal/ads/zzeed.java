package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public class zzeed extends Exception {
    private final int zza;

    public zzeed(int i, String str, Throwable th) {
        super(str, th);
        this.zza = 1;
    }

    public final int zza() {
        return this.zza;
    }

    public zzeed(int i, String str) {
        super(str);
        this.zza = i;
    }

    public zzeed(int i) {
        this.zza = i;
    }
}
