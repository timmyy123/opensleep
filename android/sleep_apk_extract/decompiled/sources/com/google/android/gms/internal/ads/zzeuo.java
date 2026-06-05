package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class zzeuo implements zzhbe {
    static final /* synthetic */ zzeuo zza = new zzeuo();

    private /* synthetic */ zzeuo() {
    }

    @Override // com.google.android.gms.internal.ads.zzhbe
    public final /* synthetic */ ListenableFuture zza(Object obj) {
        return ((Throwable) obj) instanceof TimeoutException ? zzhbw.zza(new zzeur(Integer.toString(17))) : zzhbw.zza(new zzeur(null));
    }
}
