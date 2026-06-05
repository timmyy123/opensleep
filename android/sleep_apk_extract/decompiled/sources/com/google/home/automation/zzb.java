package com.google.home.automation;

/* JADX INFO: loaded from: classes4.dex */
public abstract class zzb {
    public static /* synthetic */ String zza(Object obj, String str, byte b) {
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + b);
        sb.append(str);
        sb.append(obj);
        sb.append(")");
        return sb.toString();
    }
}
