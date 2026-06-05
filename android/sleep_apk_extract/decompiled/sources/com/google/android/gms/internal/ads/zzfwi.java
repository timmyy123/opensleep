package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzfwi {
    public static void zza() {
        if (zzfui.zzb()) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Method called before OM SDK activation");
    }

    public static void zzb(Object obj, String str) {
        if (obj != null) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2(str);
    }

    public static void zzc(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(str2);
        }
    }

    public static void zzd(String str, int i, String str2) {
        if (str.length() <= 256) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("CustomReferenceData is greater than 256 characters");
    }
}
