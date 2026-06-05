package com.google.android.gms.internal.vision;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class zzlv extends RuntimeException {
    private final List<String> zza;

    public zzlv(zzkk zzkkVar) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.zza = null;
    }
}
