package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
final class zzcou implements zzdob {
    private final zzcox zza;
    private zzfia zzb;
    private zzfhe zzc;
    private zzdir zzd;
    private zzdcb zze;
    private zzdnx zzf;
    private zzcvi zzg;

    public /* synthetic */ zzcou(zzcox zzcoxVar, byte[] bArr) {
        this.zza = zzcoxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdby
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzdoc zzh() {
        zzinc.zzc(this.zzd, zzdir.class);
        zzinc.zzc(this.zze, zzdcb.class);
        zzinc.zzc(this.zzf, zzdnx.class);
        zzinc.zzc(this.zzg, zzcvi.class);
        return new zzcov(this.zza, this.zzg, this.zzf, new zzcyz(), new zzfme(), new zzdba(), new zzeaa(), this.zzd, this.zze, zzepo.zza(), null, this.zzb, this.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzdob
    public final /* bridge */ /* synthetic */ zzdob zzd(zzcvi zzcviVar) {
        this.zzg = zzcviVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdob
    public final /* bridge */ /* synthetic */ zzdob zze(zzdnx zzdnxVar) {
        this.zzf = zzdnxVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdob
    public final /* bridge */ /* synthetic */ zzdob zzf(zzdcb zzdcbVar) {
        this.zze = zzdcbVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdob
    public final /* bridge */ /* synthetic */ zzdob zzg(zzdir zzdirVar) {
        this.zzd = zzdirVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdby
    public final /* synthetic */ zzdby zzi(zzfhe zzfheVar) {
        this.zzc = zzfheVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdby
    public final /* synthetic */ zzdby zzj(zzfia zzfiaVar) {
        this.zzb = zzfiaVar;
        return this;
    }
}
