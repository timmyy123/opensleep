package com.google.android.gms.internal.aicore;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgu extends RuntimeException {
    public zzgu(zzga zzgaVar) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public final zzfi zza() {
        return new zzfi(getMessage());
    }
}
