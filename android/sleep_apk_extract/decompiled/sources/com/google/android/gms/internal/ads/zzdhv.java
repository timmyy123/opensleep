package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AppEventListener;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdhv extends zzdip implements zzboi {
    public zzdhv(Set set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzboi
    public final synchronized void zzb(final String str, final String str2) {
        zzs(new zzdio() { // from class: com.google.android.gms.internal.ads.zzdhu
            @Override // com.google.android.gms.internal.ads.zzdio
            public final /* synthetic */ void zza(Object obj) {
                ((AppEventListener) obj).onAppEvent(str, str2);
            }
        });
    }
}
