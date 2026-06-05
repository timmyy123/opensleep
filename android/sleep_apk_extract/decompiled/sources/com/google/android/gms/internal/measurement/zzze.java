package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzze {
    public static /* synthetic */ boolean zza(int i, zzyc zzycVar, StringBuilder sb) {
        if (i - 1 != 0 || zzycVar == zzyc.zza) {
            return false;
        }
        sb.append(zzycVar.zza());
        sb.append('.');
        sb.append(zzycVar.zzb());
        sb.append(':');
        sb.append(zzycVar.zzc());
        return true;
    }
}
