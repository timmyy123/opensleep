package com.google.android.gms.internal.ads;

import com.google.android.gms.appset.AppSetIdInfo;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class zzevu implements zzhbe {
    static final /* synthetic */ zzevu zza = new zzevu();

    private /* synthetic */ zzevu() {
    }

    @Override // com.google.android.gms.internal.ads.zzhbe
    public final /* synthetic */ ListenableFuture zza(Object obj) {
        AppSetIdInfo appSetIdInfo = (AppSetIdInfo) obj;
        return appSetIdInfo == null ? zzhbw.zza(new zzevy(null, -1)) : zzhbw.zza(new zzevy(appSetIdInfo.getId(), appSetIdInfo.getScope()));
    }
}
