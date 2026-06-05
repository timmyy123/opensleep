package com.google.home.matter.standard;

import com.google.home.automation.zza$$ExternalSyntheticOutline0;

/* JADX INFO: loaded from: classes4.dex */
public abstract class zze {
    public static /* synthetic */ String zza(Object obj, Object obj2, byte b, byte b2, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(String.valueOf(obj2).length() + b2 + String.valueOf(obj).length() + b);
        zza$$ExternalSyntheticOutline0.m(sb, str, obj2, str2, obj);
        sb.append(str3);
        return sb.toString();
    }
}
