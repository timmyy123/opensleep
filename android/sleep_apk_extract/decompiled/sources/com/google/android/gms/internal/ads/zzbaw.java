package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbaw extends Exception {
    public zzbaw(zzbax zzbaxVar) {
        Objects.requireNonNull(zzbaxVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbaw(zzbax zzbaxVar, Throwable th) {
        super(th);
        Objects.requireNonNull(zzbaxVar);
    }
}
