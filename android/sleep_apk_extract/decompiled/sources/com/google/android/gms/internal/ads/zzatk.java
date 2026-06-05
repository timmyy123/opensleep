package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzatk {
    public final Object zza;
    public final zzasn zzb;
    public final zzatn zzc;
    public boolean zzd;

    private zzatk(zzatn zzatnVar) {
        this.zzd = false;
        this.zza = null;
        this.zzb = null;
        this.zzc = zzatnVar;
    }

    public static zzatk zza(Object obj, zzasn zzasnVar) {
        return new zzatk(obj, zzasnVar);
    }

    public static zzatk zzb(zzatn zzatnVar) {
        return new zzatk(zzatnVar);
    }

    public final boolean zzc() {
        return this.zzc == null;
    }

    private zzatk(Object obj, zzasn zzasnVar) {
        this.zzd = false;
        this.zza = obj;
        this.zzb = zzasnVar;
        this.zzc = null;
    }
}
