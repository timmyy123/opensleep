package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
final class zzcqa implements zzdvq {
    private final zzcox zza;
    private zzfia zzb;
    private zzfhe zzc;
    private zzdir zzd;
    private zzdcb zze;

    public /* synthetic */ zzcqa(zzcox zzcoxVar, byte[] bArr) {
        this.zza = zzcoxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdby
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzdvr zzh() {
        zzinc.zzc(this.zzd, zzdir.class);
        zzinc.zzc(this.zze, zzdcb.class);
        return new zzcqb(this.zza, new zzcyz(), new zzfme(), new zzdba(), new zzeaa(), this.zzd, this.zze, zzepo.zza(), null, this.zzb, this.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzdvq
    public final /* bridge */ /* synthetic */ zzdvq zzd(zzdcb zzdcbVar) {
        this.zze = zzdcbVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdvq
    public final /* bridge */ /* synthetic */ zzdvq zze(zzdir zzdirVar) {
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
