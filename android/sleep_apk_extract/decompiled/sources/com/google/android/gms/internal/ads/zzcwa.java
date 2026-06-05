package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcwa implements zzimu {
    private final zzind zza;

    private zzcwa(zzcvs zzcvsVar, zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzcwa zza(zzcvs zzcvsVar, zzind zzindVar) {
        return new zzcwa(zzcvsVar, zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzgww zzgwwVarZzi = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzoc)).booleanValue() ? zzgww.zzi(new zzdkq(((zzcxe) this.zza).zzb(), zzcfr.zza)) : zzgww.zzh();
        zzinc.zzb(zzgwwVarZzi);
        return zzgwwVarZzi;
    }
}
