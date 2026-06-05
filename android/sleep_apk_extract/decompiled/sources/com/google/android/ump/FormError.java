package com.google.android.ump;

/* JADX INFO: loaded from: classes4.dex */
public class FormError {
    private final int zza;
    private final String zzb;

    public FormError(int i, String str) {
        this.zza = i;
        this.zzb = str;
    }

    public int getErrorCode() {
        return this.zza;
    }

    public String getMessage() {
        return this.zzb;
    }
}
