package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfbi implements zzfci {
    private final String zza;

    public zzfbi(String str) {
        this.zza = str;
    }

    @Override // com.google.android.gms.internal.ads.zzfci
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        ((Bundle) obj).putString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID, this.zza);
    }
}
