package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzeey implements zzimu {
    private final zzind zza;

    private zzeey(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzeey zzc(zzind zzindVar) {
        return new zzeey(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final String zzb() {
        String packageName = ((zzcns) this.zza).zza().getPackageName();
        zzinc.zzb(packageName);
        return packageName;
    }
}
