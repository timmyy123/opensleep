package com.google.android.gms.internal.ads;

import com.google.android.gms.appset.AppSetIdInfo;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class zzfds implements zzhbe {
    static final /* synthetic */ zzfds zza = new zzfds();

    private /* synthetic */ zzfds() {
    }

    @Override // com.google.android.gms.internal.ads.zzhbe
    public final /* synthetic */ ListenableFuture zza(Object obj) {
        AppSetIdInfo appSetIdInfo = (AppSetIdInfo) obj;
        return appSetIdInfo == null ? zzhbw.zza(new zzfdu(null, -1)) : zzhbw.zza(new zzfdu(appSetIdInfo.getId(), appSetIdInfo.getScope()));
    }
}
