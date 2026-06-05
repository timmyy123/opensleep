package com.google.android.gms.internal.serialization;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class zzzv extends IOException {
    private boolean zza;

    public zzzv(IOException iOException) {
        super(iOException.getMessage(), iOException);
    }

    public final boolean zzb() {
        return this.zza;
    }

    public zzzv(String str) {
        super(str);
    }
}
