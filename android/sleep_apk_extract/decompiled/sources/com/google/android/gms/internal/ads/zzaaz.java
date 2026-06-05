package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzaaz {
    public final zzbg zza;
    public final int[] zzb;

    public zzaaz(zzbg zzbgVar, int[] iArr, int i) {
        if (iArr.length == 0) {
            zzeg.zzf("ETSDefinition", "Empty tracks are not allowed", new IllegalArgumentException());
        }
        this.zza = zzbgVar;
        this.zzb = iArr;
    }
}
