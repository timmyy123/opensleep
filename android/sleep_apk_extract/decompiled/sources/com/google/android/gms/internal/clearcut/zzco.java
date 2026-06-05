package com.google.android.gms.internal.clearcut;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class zzco extends IOException {
    private zzdo zzkw;

    public zzco(String str) {
        super(str);
        this.zzkw = null;
    }

    public static zzco zzbl() {
        return new zzco("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public static zzco zzbm() {
        return new zzco("Protocol message contained an invalid tag (zero).");
    }

    public static zzcp zzbn() {
        return new zzcp("Protocol message tag had invalid wire type.");
    }

    public static zzco zzbo() {
        return new zzco("Failed to parse the message.");
    }

    public static zzco zzbp() {
        return new zzco("Protocol message had invalid UTF-8.");
    }

    public final zzco zzg(zzdo zzdoVar) {
        this.zzkw = zzdoVar;
        return this;
    }
}
