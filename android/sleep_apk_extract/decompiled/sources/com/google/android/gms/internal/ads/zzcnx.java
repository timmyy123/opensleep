package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcnx implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzcnx(zzcnl zzcnlVar, zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzcnx zza(zzcnl zzcnlVar, zzind zzindVar, zzind zzindVar2) {
        return new zzcnx(zzcnlVar, zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzdI)).booleanValue() ? new zzbap((zzbak) this.zzb.zzb()) : new zzbap((zzbak) this.zza.zzb());
    }
}
