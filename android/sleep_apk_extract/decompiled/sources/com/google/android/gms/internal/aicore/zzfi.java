package com.google.android.gms.internal.aicore;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfi extends IOException {
    public zzfi(IOException iOException) {
        super(iOException.getMessage(), iOException);
    }

    public zzfi(String str) {
        super(str);
    }
}
