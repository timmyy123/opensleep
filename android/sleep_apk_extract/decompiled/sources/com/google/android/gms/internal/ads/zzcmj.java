package com.google.android.gms.internal.ads;

import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcmj extends zzcmi {
    public zzcmj(zzcku zzckuVar, zzbhp zzbhpVar, boolean z, zzekr zzekrVar) {
        super(zzckuVar, zzbhpVar, z, zzekrVar);
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return this.zza.zzaA(renderProcessGoneDetail.didCrash(), renderProcessGoneDetail.rendererPriorityAtExit());
    }
}
