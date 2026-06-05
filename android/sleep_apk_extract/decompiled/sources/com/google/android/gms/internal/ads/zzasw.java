package com.google.android.gms.internal.ads;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class zzasw {
    private final String zza;
    private final String zzb;

    public zzasw(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzasw.class == obj.getClass()) {
            zzasw zzaswVar = (zzasw) obj;
            if (TextUtils.equals(this.zza, zzaswVar.zza) && TextUtils.equals(this.zzb, zzaswVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.zzb.hashCode() + (this.zza.hashCode() * 31);
    }

    public final String toString() {
        String str = this.zza;
        int length = String.valueOf(str).length();
        String str2 = this.zzb;
        StringBuilder sb = new StringBuilder(length + 19 + String.valueOf(str2).length() + 1);
        FileInsert$$ExternalSyntheticOutline0.m(sb, "Header[name=", str, ",value=", str2);
        sb.append("]");
        return sb.toString();
    }

    public final String zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zzb;
    }
}
