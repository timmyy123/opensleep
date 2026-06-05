package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
final class zzcpp implements zzdnf {
    private final zzcox zza;
    private zzfia zzb;
    private zzfhe zzc;
    private zzdir zzd;
    private zzdcb zze;
    private zzeri zzf;

    public /* synthetic */ zzcpp(zzcox zzcoxVar, byte[] bArr) {
        this.zza = zzcoxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdby
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzdng zzh() {
        zzinc.zzc(this.zzd, zzdir.class);
        zzinc.zzc(this.zze, zzdcb.class);
        zzinc.zzc(this.zzf, zzeri.class);
        return new zzcpq(this.zza, new zzcyz(), new zzfme(), new zzdba(), new zzeaa(), this.zzd, this.zze, zzepo.zza(), this.zzf, null, this.zzb, this.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzdnf
    public final /* bridge */ /* synthetic */ zzdnf zzd(zzeri zzeriVar) {
        this.zzf = zzeriVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdnf
    public final /* bridge */ /* synthetic */ zzdnf zze(zzdcb zzdcbVar) {
        this.zze = zzdcbVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdnf
    public final /* bridge */ /* synthetic */ zzdnf zzf(zzdir zzdirVar) {
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
