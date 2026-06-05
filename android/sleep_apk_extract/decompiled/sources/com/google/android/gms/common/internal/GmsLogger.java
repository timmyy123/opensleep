package com.google.android.gms.common.internal;

/* JADX INFO: loaded from: classes3.dex */
public final class GmsLogger {
    private final String zza;
    private final String zzb;

    public GmsLogger(String str, String str2) {
        Preconditions.checkNotNull(str, "log tag cannot be null");
        Preconditions.checkArgument(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, 23);
        this.zza = str;
        this.zzb = (str2 == null || str2.length() <= 0) ? null : str2;
    }

    public GmsLogger(String str) {
        this(str, null);
    }
}
