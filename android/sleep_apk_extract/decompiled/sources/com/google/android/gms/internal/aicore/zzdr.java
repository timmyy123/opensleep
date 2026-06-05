package com.google.android.gms.internal.aicore;

/* JADX INFO: loaded from: classes3.dex */
final class zzdr {
    public int zza;
    public long zzb;
    public Object zzc;
    public final zzek zzd;
    public int zze;

    public zzdr(zzek zzekVar) {
        zzekVar.getClass();
        this.zzd = zzekVar;
    }

    public static /* synthetic */ String zza(int i, int i2) {
        StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 13 + String.valueOf(i).length());
        sb.append("Index:");
        sb.append(i2);
        sb.append(", Size:");
        sb.append(i);
        return sb.toString();
    }
}
