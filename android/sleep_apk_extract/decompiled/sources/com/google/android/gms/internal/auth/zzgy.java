package com.google.android.gms.internal.auth;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgy extends RuntimeException {
    public zzgy(zzfx zzfxVar) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public final zzfb zza() {
        return new zzfb(getMessage());
    }
}
