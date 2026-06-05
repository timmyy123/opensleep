package com.google.android.gms.internal.clearcut;

import android.net.Uri;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzao {
    private final String zzef;
    private final Uri zzeg;
    private final String zzeh;
    private final String zzei;
    private final boolean zzej;
    private final boolean zzek;

    private zzao(String str, Uri uri, String str2, String str3, boolean z, boolean z2) {
        this.zzef = str;
        this.zzeg = uri;
        this.zzeh = str2;
        this.zzei = str3;
        this.zzej = z;
        this.zzek = z2;
    }

    public final zzae<String> zza(String str, String str2) {
        return zzae.zzb(this, str, (String) null);
    }

    public final zzao zzc(String str) {
        boolean z = this.zzej;
        if (!z) {
            return new zzao(this.zzef, this.zzeg, str, this.zzei, z, this.zzek);
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Cannot set GServices prefix and skip GServices");
        return null;
    }

    public final zzao zzd(String str) {
        return new zzao(this.zzef, this.zzeg, this.zzeh, str, this.zzej, this.zzek);
    }

    public zzao(Uri uri) {
        this(null, uri, "", "", false, false);
    }

    public final <T> zzae<T> zza(String str, T t, zzan<T> zzanVar) {
        return zzae.zza(this, str, t, zzanVar);
    }

    public final zzae<Boolean> zzc(String str, boolean z) {
        return zzae.zzb(this, str, false);
    }
}
