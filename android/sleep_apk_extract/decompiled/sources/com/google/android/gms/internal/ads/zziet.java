package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class zziet extends IOException {
    private boolean zza;

    public zziet(IOException iOException) {
        super(iOException.getMessage(), iOException);
    }

    public final void zza() {
        this.zza = true;
    }

    public final boolean zzb() {
        return this.zza;
    }

    public zziet(String str) {
        super(str);
    }

    public zziet(String str, IOException iOException) {
        super("Unable to parse map entry.", iOException);
    }
}
