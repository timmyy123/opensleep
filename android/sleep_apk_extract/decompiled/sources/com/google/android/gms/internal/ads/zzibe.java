package com.google.android.gms.internal.ads;

import java.util.Objects;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public final class zzibe {
    public static final zzibe zza = new zzibe("", "", false);
    private final String zzb;
    private final String zzc;
    private final boolean zzd;

    static {
        new zzibe("\n", "  ", true);
    }

    private zzibe(String str, String str2, boolean z) {
        Objects.requireNonNull(str, "newline == null");
        Objects.requireNonNull(str2, "indent == null");
        if (!str.matches("[\r\n]*")) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Only combinations of \\n and \\r are allowed in newline.");
            throw null;
        }
        if (!str2.matches("[ \t]*")) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Only combinations of spaces and tabs are allowed in indent.");
            throw null;
        }
        this.zzb = str;
        this.zzc = str2;
        this.zzd = z;
    }

    public final String zza() {
        return this.zzb;
    }

    public final String zzb() {
        return this.zzc;
    }

    public final boolean zzc() {
        return this.zzd;
    }
}
