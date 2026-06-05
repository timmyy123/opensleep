package com.google.android.gms.internal.ads;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzgvi {
    public static void zza(Object obj, Object obj2) {
        if (obj == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("null key in entry: null=".concat(String.valueOf(obj2)));
        } else {
            if (obj2 != null) {
                return;
            }
            String string = obj.toString();
            Types$$ExternalSyntheticBUOutline0.m$1(Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(string.length() + 26), "null value in entry: ", string, "=null"));
        }
    }

    public static int zzb(int i, String str) {
        if (i >= 0) {
            return i;
        }
        StringBuilder sb = new StringBuilder(str.length() + 29 + String.valueOf(i).length());
        sb.append(str);
        sb.append(" cannot be negative but was: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }
}
