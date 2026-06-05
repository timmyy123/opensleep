package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.internal.ads.zzbjq;
import com.google.android.gms.internal.ads.zzbjr;
import com.google.android.gms.internal.ads.zzink;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzk implements zzbjq {
    final /* synthetic */ zzbjr zza;
    final /* synthetic */ Bundle zzb;
    final /* synthetic */ Context zzc;
    final /* synthetic */ Uri zzd;

    public zzk(zzs zzsVar, zzbjr zzbjrVar, Bundle bundle, Context context, Uri uri) {
        this.zza = zzbjrVar;
        this.zzb = bundle;
        this.zzc = context;
        this.zzd = uri;
        Objects.requireNonNull(zzsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbjq
    public final void zza() {
        zzbjr zzbjrVar = this.zza;
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder(zzbjrVar.zzc());
        zzs.zzai(builder, this.zzb);
        CustomTabsIntent customTabsIntentBuild = builder.build();
        Intent intent = customTabsIntentBuild.intent;
        Context context = this.zzc;
        intent.setPackage(zzink.zza(context));
        customTabsIntentBuild.launchUrl(context, this.zzd);
        zzbjrVar.zzb((Activity) context);
    }
}
