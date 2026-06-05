package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdcc implements zzimu {
    private final zzdcb zza;
    private final zzind zzb;

    private zzdcc(zzdcb zzdcbVar, zzind zzindVar) {
        this.zza = zzdcbVar;
        this.zzb = zzindVar;
    }

    public static zzdcc zza(zzdcb zzdcbVar, zzind zzindVar) {
        return new zzdcc(zzdcbVar, zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* synthetic */ Object zzb() {
        return this.zza.zzg((String) this.zzb.zzb());
    }
}
