package com.google.home.matter.standard;

/* JADX INFO: loaded from: classes4.dex */
public abstract class zzc {
    public static /* synthetic */ String zza(boolean z, String str, byte b) {
        StringBuilder sb = new StringBuilder(String.valueOf(z).length() + b);
        sb.append(str);
        sb.append(z);
        sb.append(")");
        return sb.toString();
    }
}
