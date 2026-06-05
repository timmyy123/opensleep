package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzigs extends RuntimeException {
    public zzigs(zzifp zzifpVar) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public final zziet zza() {
        return new zziet(getMessage());
    }
}
