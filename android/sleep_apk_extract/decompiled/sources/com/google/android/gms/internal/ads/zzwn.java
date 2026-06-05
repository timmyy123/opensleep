package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzwn implements zzzc {
    public final zzzc zza;
    final /* synthetic */ zzwo zzb;
    private boolean zzc;

    public zzwn(zzwo zzwoVar, zzzc zzzcVar) {
        Objects.requireNonNull(zzwoVar);
        this.zzb = zzwoVar;
        this.zza = zzzcVar;
    }

    public final void zza() {
        this.zzc = false;
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final boolean zzb() {
        return !this.zzb.zzo() && this.zza.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final void zzc() {
        this.zza.zzc();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004b  */
    @Override // com.google.android.gms.internal.ads.zzzc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int zzd(zzlw zzlwVar, zziv zzivVar, int i) {
        zzwo zzwoVar = this.zzb;
        if (zzwoVar.zzo()) {
            return -3;
        }
        if (this.zzc) {
            zzivVar.zzg(4);
            return -4;
        }
        zzzc zzzcVar = this.zza;
        long jZzi = zzwoVar.zzi();
        int iZzd = zzzcVar.zzd(zzlwVar, zzivVar, i);
        if (zzwoVar.zzq() != -9223372036854775807L && iZzd != -3) {
            zzwoVar.zzr(-9223372036854775807L);
        }
        long j = zzwoVar.zzb;
        if (iZzd != -5) {
            if (j == Long.MIN_VALUE || ((iZzd != -4 || zzivVar.zze < j) && !(iZzd == -3 && jZzi == Long.MIN_VALUE && !zzivVar.zzd))) {
                return iZzd;
            }
            zzivVar.zza();
            zzivVar.zzg(4);
            this.zzc = true;
            return -4;
        }
        zzv zzvVar = zzlwVar.zzb;
        zzvVar.getClass();
        int i2 = zzvVar.zzK;
        if (i2 != 0) {
            int i3 = j == Long.MIN_VALUE ? zzvVar.zzL : 0;
            zzt zztVarZza = zzvVar.zza();
            zztVarZza.zzJ(i2);
            zztVarZza.zzK(i3);
            zzlwVar.zzb = zztVarZza.zzO();
        } else if (zzvVar.zzL != 0) {
            i2 = 0;
            if (j == Long.MIN_VALUE) {
            }
            zzt zztVarZza2 = zzvVar.zza();
            zztVarZza2.zzJ(i2);
            zztVarZza2.zzK(i3);
            zzlwVar.zzb = zztVarZza2.zzO();
        }
        return -5;
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final int zze(long j) {
        if (this.zzb.zzo()) {
            return -3;
        }
        return this.zza.zze(j);
    }
}
