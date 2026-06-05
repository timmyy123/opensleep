package com.google.android.gms.internal.ads;

import android.content.Context;
import android.webkit.CookieManager;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class zzeev implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzeev(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzeev zza(zzind zzindVar, zzind zzindVar2) {
        return new zzeev(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* synthetic */ Object zzb() {
        zzfpk zzfpkVar = (zzfpk) this.zza.zzb();
        final CookieManager cookieManagerZza = com.google.android.gms.ads.internal.zzt.zzf().zza((Context) this.zzb.zzb());
        zzfpe zzfpeVar = zzfpe.WEBVIEW_COOKIE;
        Objects.requireNonNull(zzfpkVar);
        return zzfov.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzeeq
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                CookieManager cookieManager = cookieManagerZza;
                if (cookieManager == null) {
                    return "";
                }
                return cookieManager.getCookie((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzbz));
            }
        }, zzfpeVar, zzfpkVar).zzh(1L, TimeUnit.SECONDS).zzf(Exception.class, zzeen.zza).zzi();
    }
}
