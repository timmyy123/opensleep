package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdci implements zzimu {
    private final zzdcb zza;

    private zzdci(zzdcb zzdcbVar) {
        this.zza = zzdcbVar;
    }

    public static zzdci zzc(zzdcb zzdcbVar) {
        return new zzdci(zzdcbVar);
    }

    public static zzfky zzd(zzdcb zzdcbVar) {
        zzfky zzfkyVarZzb = zzdcbVar.zzb();
        zzinc.zzb(zzfkyVarZzb);
        return zzfkyVarZzb;
    }

    public final zzfky zza() {
        return zzd(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }
}
