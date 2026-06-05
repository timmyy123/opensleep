package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
final class zzxx extends zzabc {
    private final zzbg zza;

    public zzxx(zzaba zzabaVar, zzbg zzbgVar) {
        super(zzabaVar);
        this.zza = zzbgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzabc
    public final boolean equals(Object obj) {
        if (super.equals(obj) && (obj instanceof zzxx)) {
            return this.zza.equals(((zzxx) obj).zza);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzabc
    public final int hashCode() {
        return this.zza.hashCode() + (super.hashCode() * 31);
    }

    @Override // com.google.android.gms.internal.ads.zzabf
    public final zzbg zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzabf
    public final zzv zzb(int i) {
        return this.zza.zza(zzd().zzf(i));
    }

    @Override // com.google.android.gms.internal.ads.zzaba
    public final zzv zzc() {
        return this.zza.zza(zzd().zzh());
    }
}
