package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.webkit.WebView;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfwc extends zzfvy {
    private WebView zza;
    private Long zzb;
    private final Map zzc;

    public zzfwc(String str, Map map, String str2) {
        super(str);
        this.zzb = null;
        this.zzc = map;
    }

    @Override // com.google.android.gms.internal.ads.zzfvy
    public final void zza() {
        WebView webView = new WebView(zzfvn.zza().zzb());
        this.zza = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.zza.getSettings().setAllowContentAccess(false);
        this.zza.getSettings().setAllowFileAccess(false);
        this.zza.setWebViewClient(new zzfwa(this));
        zzc(this.zza);
        zzfvp.zzk(this.zza, null);
        Map map = this.zzc;
        Iterator it = map.keySet().iterator();
        if (!it.hasNext()) {
            this.zzb = Long.valueOf(System.nanoTime());
        } else {
            map.get((String) it.next()).getClass();
            Events$$ExternalSyntheticBUOutline0.m();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfvy
    public final void zzb() {
        super.zzb();
        new Handler().postDelayed(new zzfwb(this), Math.max(4000 - (this.zzb == null ? 4000L : (System.nanoTime() - this.zzb.longValue()) / 1000000), 2000L));
        this.zza = null;
    }

    @Override // com.google.android.gms.internal.ads.zzfvy
    public final void zzk(zzfuo zzfuoVar, zzfum zzfumVar) {
        JSONObject jSONObject = new JSONObject();
        Map mapZze = zzfumVar.zze();
        Iterator it = mapZze.keySet().iterator();
        if (!it.hasNext()) {
            zzl(zzfuoVar, zzfumVar, jSONObject);
        } else {
            mapZze.get((String) it.next()).getClass();
            Events$$ExternalSyntheticBUOutline0.m();
        }
    }

    public final /* synthetic */ WebView zzq() {
        return this.zza;
    }
}
