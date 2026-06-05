package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.browser.customtabs.CustomTabsCallback;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzbjm extends CustomTabsCallback {
    final /* synthetic */ zzbjp zza;

    public zzbjm(zzbjp zzbjpVar) {
        Objects.requireNonNull(zzbjpVar);
        this.zza = zzbjpVar;
    }

    @Override // androidx.browser.customtabs.CustomTabsCallback
    public final void onNavigationEvent(int i, Bundle bundle) {
        this.zza.zzc(i);
    }
}
