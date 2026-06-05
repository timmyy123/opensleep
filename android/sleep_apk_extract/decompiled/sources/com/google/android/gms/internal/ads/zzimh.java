package com.google.android.gms.internal.ads;

import android.util.Log;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzimh extends zzimm {
    final String zza;

    public zzimh(String str) {
        this.zza = str;
    }

    @Override // com.google.android.gms.internal.ads.zzimm
    public final void zza(String str) {
        String str2 = this.zza;
        StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(zzba$$ExternalSyntheticOutline0.m(1, str2), str));
        sb.append(str2);
        sb.append(":");
        sb.append(str);
        Log.d("isoparser", sb.toString());
    }
}
