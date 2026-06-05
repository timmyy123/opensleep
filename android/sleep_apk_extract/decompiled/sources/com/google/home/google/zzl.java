package com.google.home.google;

/* JADX INFO: loaded from: classes4.dex */
public abstract class zzl {
    public static /* synthetic */ String zza(Object obj, String str, byte b, String str2, String str3) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + b + String.valueOf(obj).length() + 1);
        sb.append(str2);
        sb.append(str);
        sb.append(str3);
        sb.append(obj);
        sb.append(")");
        return sb.toString();
    }
}
