package com.google.android.gms.internal.common;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzai {
    public static Object[] zza(Object[] objArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (objArr[i2] == null) {
                Types$$ExternalSyntheticBUOutline0.m$1(zzba$$ExternalSyntheticOutline0.m(i2, "at index ", new StringBuilder(String.valueOf(i2).length() + 9)));
                return null;
            }
        }
        return objArr;
    }
}
