package com.google.android.gms.internal.ads;

import android.os.Looper;

/* JADX INFO: loaded from: classes3.dex */
public final class zzyu extends zzwj implements zzyi {
    private final zzho zza;
    private final zzyc zzb;
    private final zzun zzc;
    private final int zzd;
    private boolean zze = true;
    private long zzf = -9223372036854775807L;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;
    private zzin zzj;
    private zzak zzk;
    private final zzabu zzl;

    public /* synthetic */ zzyu(zzak zzakVar, zzho zzhoVar, zzyc zzycVar, zzun zzunVar, zzabu zzabuVar, int i, boolean z, int i2, zzv zzvVar, zzgub zzgubVar, byte[] bArr) {
        this.zzk = zzakVar;
        this.zza = zzhoVar;
        this.zzb = zzycVar;
        this.zzc = zzunVar;
        this.zzl = zzabuVar;
        this.zzd = i;
    }

    private final void zzu() {
        long j = this.zzf;
        boolean z = this.zzg;
        boolean z2 = this.zzh;
        zzak zzakVarZzJ = zzJ();
        zzbf zzzgVar = new zzzg(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L, j, j, 0L, 0L, z, false, false, null, zzakVarZzJ, z2 ? zzakVarZzJ.zzc : null);
        if (this.zze) {
            zzzgVar = new zzyr(this, zzzgVar);
        }
        zze(zzzgVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxm
    public final synchronized void zzA(zzak zzakVar) {
        this.zzk = zzakVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxm
    public final void zzD(zzxi zzxiVar) {
        ((zzyq) zzxiVar).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzxm
    public final zzxi zzG(zzxk zzxkVar, zzabl zzablVar, long j) {
        zzhp zzhpVarZza = this.zza.zza();
        zzin zzinVar = this.zzj;
        if (zzinVar != null) {
            zzhpVarZza.zze(zzinVar);
        }
        zzag zzagVar = zzJ().zzb;
        zzagVar.getClass();
        return new zzyq(zzagVar.zza, zzhpVarZza, this.zzb.zza(zzk()), this.zzc, zzh(zzxkVar), this.zzl, zzf(zzxkVar), this, zzablVar, null, this.zzd, false, 0, null, zzfl.zzs(-9223372036854775807L), null);
    }

    @Override // com.google.android.gms.internal.ads.zzxm
    public final synchronized zzak zzJ() {
        return this.zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzwj
    public final void zza(zzin zzinVar) {
        this.zzj = zzinVar;
        Looper.myLooper().getClass();
        zzk();
        zzu();
    }

    @Override // com.google.android.gms.internal.ads.zzyi
    public final void zzb(long j, zzahb zzahbVar, boolean z) {
        if (this.zzi && zzahbVar.zzj()) {
            return;
        }
        this.zzi = !zzahbVar.zzj();
        if (j == -9223372036854775807L) {
            j = this.zzf;
        }
        boolean zZzb = zzahbVar.zzb();
        if (!this.zze && this.zzf == j && this.zzg == zZzb && this.zzh == z) {
            return;
        }
        this.zzf = j;
        this.zzg = zZzb;
        this.zzh = z;
        this.zze = false;
        zzu();
    }

    @Override // com.google.android.gms.internal.ads.zzwj
    public final void zzd() {
    }

    @Override // com.google.android.gms.internal.ads.zzxm
    public final void zzt() {
    }
}
