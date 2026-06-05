package com.google.android.gms.internal.serialization;

/* JADX INFO: loaded from: classes3.dex */
public final class zzabq extends RuntimeException {
    public zzabq(zzaaq zzaaqVar) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public final zzzv zza() {
        return new zzzv(getMessage());
    }
}
