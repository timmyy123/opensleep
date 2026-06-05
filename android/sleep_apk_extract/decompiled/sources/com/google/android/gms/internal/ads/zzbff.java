package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AppEventListener;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbff extends com.google.android.gms.ads.internal.client.zzck {
    private final AppEventListener zza;

    public zzbff(AppEventListener appEventListener) {
        this.zza = appEventListener;
    }

    @Override // com.google.android.gms.ads.internal.client.zzcl
    public final void zzb(String str, String str2) {
        this.zza.onAppEvent(str, str2);
    }
}
