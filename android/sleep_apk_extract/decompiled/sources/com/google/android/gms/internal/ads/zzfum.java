package com.google.android.gms.internal.ads;

import android.webkit.WebView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfum {
    private final zzfuy zza;
    private final WebView zzb;
    private final List zzc = new ArrayList();
    private final Map zzd = new HashMap();
    private final String zze;
    private final String zzf;
    private final zzfun zzg;

    private zzfum(zzfuy zzfuyVar, WebView webView, String str, List list, String str2, String str3, zzfun zzfunVar) {
        this.zza = zzfuyVar;
        this.zzb = webView;
        this.zzg = zzfunVar;
        this.zzf = str2;
        this.zze = str3;
    }

    public static zzfum zza(zzfuy zzfuyVar, WebView webView, String str, String str2) {
        if (str2 != null) {
            zzfwi.zzd(str2, 256, "CustomReferenceData is greater than 256 characters");
        }
        return new zzfum(zzfuyVar, webView, null, null, str, str2, zzfun.HTML);
    }

    public static zzfum zzb(zzfuy zzfuyVar, WebView webView, String str, String str2) {
        zzfwi.zzd("", 256, "CustomReferenceData is greater than 256 characters");
        return new zzfum(zzfuyVar, webView, null, null, str, "", zzfun.JAVASCRIPT);
    }

    public final zzfuy zzc() {
        return this.zza;
    }

    public final List zzd() {
        return Collections.unmodifiableList(this.zzc);
    }

    public final Map zze() {
        return Collections.unmodifiableMap(this.zzd);
    }

    public final WebView zzf() {
        return this.zzb;
    }

    public final String zzg() {
        return this.zzf;
    }

    public final String zzh() {
        return this.zze;
    }

    public final zzfun zzi() {
        return this.zzg;
    }
}
