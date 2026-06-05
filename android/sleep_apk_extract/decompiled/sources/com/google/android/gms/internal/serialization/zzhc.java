package com.google.android.gms.internal.serialization;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhc {
    public static String zza(String str, String str2, boolean z) {
        if (str2.length() > 23) {
            int i = -1;
            for (int length = str2.length() - 1; length >= 0; length--) {
                char cCharAt = str2.charAt(length);
                if (cCharAt == '.' || cCharAt == '$') {
                    i = length;
                    break;
                }
            }
            str2 = str2.substring(i + 1);
        }
        String strConcat = "".concat(str2);
        return strConcat.substring(0, Math.min(strConcat.length(), 23));
    }
}
