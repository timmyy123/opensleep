package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes3.dex */
public final class zzafy extends RuntimeException {
    public zzafy(zzafc zzafcVar) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public final zzaeh zza() {
        return new zzaeh(getMessage());
    }
}
