package com.google.android.gms.internal.serialization;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzie {
    public static void zza(boolean z, String str, long j, long j2) {
        if (z) {
            return;
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder(String.valueOf(j2).length() + length + 11 + String.valueOf(j).length() + 2 + 1);
        Fragment$$ExternalSyntheticOutline1.m67m(sb, "overflow: ", str, "(");
        sb.append(j);
        sb.append(", ");
        sb.append(j2);
        sb.append(")");
        throw new ArithmeticException(sb.toString());
    }
}
