package com.google.home.matter.standard;

/* JADX INFO: loaded from: classes4.dex */
public abstract class zzf {
    public static /* synthetic */ String zza(Object obj, String str, byte b, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + b);
        sb.append(str);
        sb.append(obj);
        sb.append(str2);
        return sb.toString();
    }
}
