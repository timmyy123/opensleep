package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdoi implements zzimu {
    private final zzind zza;
    private final zzind zzb;
    private final zzind zzc;
    private final zzind zzd;
    private final zzind zze;
    private final zzind zzf;

    private zzdoi(zzind zzindVar, zzind zzindVar2, zzind zzindVar3, zzind zzindVar4, zzind zzindVar5, zzind zzindVar6) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
        this.zzc = zzindVar3;
        this.zzd = zzindVar4;
        this.zze = zzindVar5;
        this.zzf = zzindVar6;
    }

    public static zzdoi zza(zzind zzindVar, zzind zzindVar2, zzind zzindVar3, zzind zzindVar4, zzind zzindVar5, zzind zzindVar6) {
        return new zzdoi(zzindVar, zzindVar2, zzindVar3, zzindVar4, zzindVar5, zzindVar6);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzcnj zzcnjVar = (zzcnj) this.zza.zzb();
        zzdca zzdcaVarZza = ((zzdcj) this.zzb).zza();
        zzdir zzdirVarZza = ((zzdjm) this.zzc).zza();
        zzdnx zzdnxVarZza = ((zzdnz) this.zzd).zza();
        zzdfs zzdfsVarZzb = ((zzcvk) this.zze).zzb();
        zzepd zzepdVar = (zzepd) this.zzf.zzb();
        zzcwp zzcwpVarZzi = zzcnjVar.zzi();
        zzcwpVarZzi.zzl(zzdcaVarZza.zze());
        zzcwpVarZzi.zzm(zzdirVarZza);
        zzcwpVarZzi.zzd(zzdnxVarZza);
        zzcwpVarZzi.zzk(new zzeri(null));
        zzcwpVarZzi.zzg(new zzcxl(zzdfsVarZzb, null));
        zzcwpVarZzi.zze(new zzcvi(null));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzez)).booleanValue()) {
            zzcwpVarZzi.zzf(zzepm.zza(zzepdVar));
        }
        zzcxw zzcxwVarZzd = zzcwpVarZzi.zzh().zzd();
        zzinc.zzb(zzcxwVarZzd);
        return zzcxwVarZzd;
    }
}
