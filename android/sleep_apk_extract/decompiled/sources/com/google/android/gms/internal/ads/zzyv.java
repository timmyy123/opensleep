package com.google.android.gms.internal.ads;

import com.facebook.internal.NativeProtocol;

/* JADX INFO: loaded from: classes3.dex */
final class zzyv implements zzabk {
    public long zza;
    public long zzb;
    public zzabj zzc;
    public zzyv zzd;

    public zzyv(long j, int i) {
        zza(j, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
    }

    public final void zza(long j, int i) {
        zzgtj.zzi(this.zzc == null);
        this.zza = j;
        this.zzb = j + 65536;
    }

    public final int zzb(long j) {
        long j2 = j - this.zza;
        int i = this.zzc.zzb;
        return (int) j2;
    }

    public final zzyv zzc() {
        this.zzc = null;
        zzyv zzyvVar = this.zzd;
        this.zzd = null;
        return zzyvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzabk
    public final zzabj zzd() {
        zzabj zzabjVar = this.zzc;
        zzabjVar.getClass();
        return zzabjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzabk
    public final zzabk zze() {
        zzyv zzyvVar = this.zzd;
        if (zzyvVar == null || zzyvVar.zzc == null) {
            return null;
        }
        return zzyvVar;
    }
}
