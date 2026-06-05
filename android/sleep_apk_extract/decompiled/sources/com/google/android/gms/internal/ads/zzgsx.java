package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzgsx implements zzgtk {
    public static zzgsx zzc(char c) {
        return new zzgsu(c);
    }

    @Override // com.google.android.gms.internal.ads.zzgtk
    @Deprecated
    public final /* synthetic */ boolean zza(Object obj) {
        return zzb(((Character) obj).charValue());
    }

    public abstract boolean zzb(char c);
}
