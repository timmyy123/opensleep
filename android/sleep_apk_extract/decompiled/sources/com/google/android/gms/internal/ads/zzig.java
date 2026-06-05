package com.google.android.gms.internal.ads;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.ads.AdError;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class zzig extends zzie {
    public final int zzc;

    public zzig(int i, String str, IOException iOException, Map map, zzht zzhtVar, byte[] bArr) {
        super(zzba$$ExternalSyntheticOutline0.m(i, "Response code: ", new StringBuilder(String.valueOf(i).length() + 15)), iOException, zzhtVar, AdError.INTERNAL_ERROR_2004, 1);
        this.zzc = i;
    }
}
