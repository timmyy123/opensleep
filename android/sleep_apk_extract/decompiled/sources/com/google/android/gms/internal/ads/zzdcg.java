package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdcg implements zzimu {
    private final zzind zza;

    private zzdcg(zzdcb zzdcbVar, zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzdcg zzc(zzdcb zzdcbVar, zzind zzindVar) {
        return new zzdcg(zzdcbVar, zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final String zzb() {
        String strZzp = ((zzczj) this.zza.zzb()).zzp();
        zzinc.zzb(strZzp);
        return strZzp;
    }
}
