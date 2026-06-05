package com.google.android.gms.internal.ads;

import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.io.File;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzcmh extends zzclf {
    public zzcmh(zzcku zzckuVar, zzbhp zzbhpVar, boolean z, zzekr zzekrVar) {
        super(zzckuVar, zzbhpVar, z, new zzbyf(zzckuVar, zzckuVar.zzK(), new zzbhx(zzckuVar.getContext())), null, zzekrVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final WebResourceResponse zzac(WebView webView, String str, Map map) {
        String str2;
        if (!(webView instanceof zzcku)) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Tried to intercept request from a WebView that wasn't an AdWebView.");
            return null;
        }
        zzcku zzckuVar = (zzcku) webView;
        zzcdn zzcdnVar = this.zzb;
        if (zzcdnVar != null) {
            zzcdnVar.zze(str, map, 1);
        }
        zzfzk.zza();
        zzfzp zzfzpVar = zzfzp.zza;
        if (!"mraid.js".equalsIgnoreCase(new File(str).getName())) {
            if (map == null) {
                map = Collections.EMPTY_MAP;
            }
            return zzL(str, map);
        }
        if (zzckuVar.zzP() != null) {
            zzckuVar.zzP().zzN();
        }
        if (zzckuVar.zzN().zzg()) {
            str2 = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzaB);
        } else if (zzckuVar.zzW()) {
            str2 = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzaA);
        } else {
            str2 = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzaz);
        }
        com.google.android.gms.ads.internal.zzt.zzc();
        return com.google.android.gms.ads.internal.util.zzs.zzz(zzckuVar.getContext(), zzckuVar.zzs().afmaVersion, str2);
    }
}
