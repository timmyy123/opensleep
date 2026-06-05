package com.google.android.gms.internal.ads;

import com.google.android.gms.appset.AppSetIdInfo;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class zzevw implements zzgta {
    static final /* synthetic */ zzevw zza = new zzevw();

    private /* synthetic */ zzevw() {
    }

    @Override // com.google.android.gms.internal.ads.zzgta
    public final /* synthetic */ Object apply(Object obj) {
        AppSetIdInfo appSetIdInfo = (AppSetIdInfo) obj;
        return new zzevy(appSetIdInfo.getId(), appSetIdInfo.getScope());
    }
}
