package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
final class zzcpe implements zzcwp {
    private final zzcox zza;
    private zzfia zzb;
    private zzfhe zzc;
    private zzdir zzd;
    private zzdcb zze;
    private zzeri zzf;
    private zzcxl zzg;
    private zzepm zzh;
    private zzcvi zzi;
    private zzdnx zzj;

    public /* synthetic */ zzcpe(zzcox zzcoxVar, byte[] bArr) {
        this.zza = zzcoxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdby
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzcwq zzh() {
        zzinc.zzc(this.zzd, zzdir.class);
        zzinc.zzc(this.zze, zzdcb.class);
        zzinc.zzc(this.zzf, zzeri.class);
        zzinc.zzc(this.zzg, zzcxl.class);
        if (this.zzh == null) {
            this.zzh = zzepo.zza();
        }
        zzinc.zzc(this.zzi, zzcvi.class);
        zzinc.zzc(this.zzj, zzdnx.class);
        return new zzcpf(this.zza, this.zzi, this.zzj, new zzcyz(), new zzfme(), new zzdba(), new zzeaa(), this.zzd, this.zze, this.zzh, this.zzf, this.zzg, null, this.zzb, this.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzcwp
    public final /* bridge */ /* synthetic */ zzcwp zzd(zzdnx zzdnxVar) {
        this.zzj = zzdnxVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcwp
    public final /* bridge */ /* synthetic */ zzcwp zze(zzcvi zzcviVar) {
        this.zzi = zzcviVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcwp
    public final /* bridge */ /* synthetic */ zzcwp zzf(zzepm zzepmVar) {
        this.zzh = zzepmVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcwp
    public final /* bridge */ /* synthetic */ zzcwp zzg(zzcxl zzcxlVar) {
        this.zzg = zzcxlVar;
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

    @Override // com.google.android.gms.internal.ads.zzcwp
    public final /* bridge */ /* synthetic */ zzcwp zzk(zzeri zzeriVar) {
        this.zzf = zzeriVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcwp
    public final /* bridge */ /* synthetic */ zzcwp zzl(zzdcb zzdcbVar) {
        this.zze = zzdcbVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcwp
    public final /* bridge */ /* synthetic */ zzcwp zzm(zzdir zzdirVar) {
        this.zzd = zzdirVar;
        return this;
    }
}
