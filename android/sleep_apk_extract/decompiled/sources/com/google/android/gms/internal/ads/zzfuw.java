package com.google.android.gms.internal.ads;

import android.view.View;
import android.webkit.WebView;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewFeature;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Timer;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfuw {
    private final zzfuy zza;
    private final WebView zzb;
    private zzfwz zzc;
    private final HashMap zzd;
    private final zzfvm zze;

    private zzfuw(zzfuy zzfuyVar, WebView webView, boolean z) {
        HashMap map = new HashMap();
        this.zzd = map;
        this.zze = new zzfvm();
        zzfwi.zza();
        this.zza = zzfuyVar;
        this.zzb = webView;
        if (zzc() != webView) {
            Iterator it = map.values().iterator();
            while (it.hasNext()) {
                ((zzfuk) it.next()).zzb(webView);
            }
            this.zzc = new zzfwz(webView);
        }
        if (!WebViewFeature.isFeatureSupported("WEB_MESSAGE_LISTENER")) {
            Utf8$$ExternalSyntheticBUOutline0.m("The JavaScriptSessionService cannot be supported in this WebView version.");
            throw null;
        }
        zze();
        WebViewCompat.addWebMessageListener(this.zzb, "omidJsSessionService", new HashSet(Arrays.asList("*")), new zzfuu(this));
    }

    public static zzfuw zza(zzfuy zzfuyVar, WebView webView, boolean z) {
        return new zzfuw(zzfuyVar, webView, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzh, reason: merged with bridge method [inline-methods] */
    public final void zze() {
        WebViewCompat.removeWebMessageListener(this.zzb, "omidJsSessionService");
    }

    public final void zzb(zzfuv zzfuvVar) {
        Iterator it = this.zzd.values().iterator();
        while (it.hasNext()) {
            ((zzfuk) it.next()).zzc();
        }
        Timer timer = new Timer();
        timer.schedule(new zzfut(this, zzfuvVar, timer), 1000L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View zzc() {
        zzfwz zzfwzVar = this.zzc;
        if (zzfwzVar == null) {
            return null;
        }
        return (View) zzfwzVar.get();
    }

    public final void zzd(View view, zzfur zzfurVar, String str) {
        Iterator it = this.zzd.values().iterator();
        while (it.hasNext()) {
            ((zzfuk) it.next()).zzd(view, zzfurVar, "Ad overlay");
        }
        this.zze.zzb(view, zzfurVar, "Ad overlay");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ void zzf(String str) {
        zzfup zzfupVar = zzfup.DEFINED_BY_JAVASCRIPT;
        zzfus zzfusVar = zzfus.DEFINED_BY_JAVASCRIPT;
        zzfux zzfuxVar = zzfux.JAVASCRIPT;
        zzfuo zzfuoVar = new zzfuo(zzful.zza(zzfupVar, zzfusVar, zzfuxVar, zzfuxVar, false), zzfum.zza(this.zza, this.zzb, null, null), str);
        this.zzd.put(str, zzfuoVar);
        zzfuoVar.zzb(zzc());
        for (zzfvl zzfvlVar : this.zze.zza()) {
            zzfuoVar.zzd((View) zzfvlVar.zza().get(), zzfvlVar.zzc(), zzfvlVar.zzd());
        }
        zzfuoVar.zza();
    }

    public final /* synthetic */ void zzg(String str) {
        HashMap map = this.zzd;
        zzfuk zzfukVar = (zzfuk) map.get(str);
        if (zzfukVar != null) {
            zzfukVar.zzc();
            map.remove(str);
        }
    }
}
