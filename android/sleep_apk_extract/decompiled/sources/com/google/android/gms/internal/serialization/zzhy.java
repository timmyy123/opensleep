package com.google.android.gms.internal.serialization;

import okio.Utf8$$ExternalSyntheticBUOutline0;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhy {
    public static Object zza(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        Types$$ExternalSyntheticBUOutline0.m$1(str.concat(" must not be null"));
        return null;
    }

    public static void zzb(boolean z, String str) {
        if (z) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2(str);
    }

    public static String zzd(String str) {
        if (str.isEmpty()) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("identifier must not be empty");
            return null;
        }
        if (!zze(str.charAt(0))) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("identifier must start with an ASCII letter: ".concat(str));
            return null;
        }
        for (int i = 1; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (!zze(cCharAt) && ((cCharAt < '0' || cCharAt > '9') && cCharAt != '_')) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("identifier must contain only ASCII letters, digits or underscore: ".concat(str));
                return null;
            }
        }
        return str;
    }

    private static boolean zze(char c) {
        if (c < 'a' || c > 'z') {
            return c >= 'A' && c <= 'Z';
        }
        return true;
    }
}
