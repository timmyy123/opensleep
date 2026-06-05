package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class zzdlt implements zzdio {
    static final /* synthetic */ zzdlt zza = new zzdlt();

    private /* synthetic */ zzdlt() {
    }

    @Override // com.google.android.gms.internal.ads.zzdio
    public final /* synthetic */ void zza(Object obj) {
        ((VideoController.VideoLifecycleCallbacks) obj).onVideoPause();
    }
}
