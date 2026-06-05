package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzix implements zzna, zznc {
    private final int zzb;
    private zznd zzd;
    private int zze;
    private zzqf zzf;
    private zzdo zzg;
    private int zzh;
    private zzzc zzi;
    private zzv[] zzj;
    private long zzk;
    private long zzl;
    private boolean zzn;
    private boolean zzo;
    private zzxk zzq;
    private zznb zzr;
    private final Object zza = new Object();
    private final zzlw zzc = new zzlw();
    private long zzm = Long.MIN_VALUE;
    private zzbf zzp = zzbf.zza;

    public zzix(int i) {
        this.zzb = i;
    }

    private final void zzae(long j, boolean z, boolean z2) {
        this.zzn = false;
        this.zzl = j;
        this.zzm = j;
        if (!z2) {
            z2 = zzR(j) != 0;
        }
        zzA(j, z, z2);
    }

    public abstract void zzA(long j, boolean z, boolean z2);

    public abstract void zzB();

    public abstract void zzC();

    public abstract void zzD();

    public abstract void zzE();

    public abstract void zzF();

    public void zzG(zzbf zzbfVar) {
    }

    public final long zzH() {
        return this.zzl;
    }

    public final zzlw zzI() {
        zzlw zzlwVar = this.zzc;
        zzlwVar.zza = null;
        zzlwVar.zzb = null;
        return zzlwVar;
    }

    public final zzv[] zzJ() {
        zzv[] zzvVarArr = this.zzj;
        zzvVarArr.getClass();
        return zzvVarArr;
    }

    public final zznd zzK() {
        zznd zzndVar = this.zzd;
        zzndVar.getClass();
        return zzndVar;
    }

    public final zzqf zzL() {
        zzqf zzqfVar = this.zzf;
        zzqfVar.getClass();
        return zzqfVar;
    }

    public final zzdo zzM() {
        zzdo zzdoVar = this.zzg;
        zzdoVar.getClass();
        return zzdoVar;
    }

    public final zzbf zzN() {
        return this.zzp;
    }

    public final zzxk zzO() {
        return this.zzq;
    }

    public final zzjk zzP(Throwable th, zzv zzvVar, boolean z, int i) {
        int iZzad = 4;
        if (zzvVar != null && !this.zzo) {
            this.zzo = true;
            try {
                iZzad = zzad(zzvVar) & 7;
            } catch (zzjk unused) {
            } finally {
                this.zzo = false;
            }
        }
        return zzjk.zzb(th, zzU(), this.zze, zzvVar, iZzad, this.zzq, z, i);
    }

    public final int zzQ(zzlw zzlwVar, zziv zzivVar, int i) {
        zzzc zzzcVar = this.zzi;
        zzzcVar.getClass();
        int iZzd = zzzcVar.zzd(zzlwVar, zzivVar, i);
        if (iZzd == -4) {
            if (zzivVar.zzb()) {
                this.zzm = Long.MIN_VALUE;
                return this.zzn ? -4 : -3;
            }
            long j = zzivVar.zze + this.zzk;
            zzivVar.zze = j;
            this.zzm = Math.max(this.zzm, j);
            return iZzd;
        }
        if (iZzd == -5) {
            zzv zzvVar = zzlwVar.zzb;
            zzvVar.getClass();
            long j2 = zzvVar.zzu;
            if (j2 != Long.MAX_VALUE) {
                zzt zztVarZza = zzvVar.zza();
                zztVarZza.zzt(j2 + this.zzk);
                zzlwVar.zzb = zztVarZza.zzO();
                return -5;
            }
        }
        return iZzd;
    }

    public final int zzR(long j) {
        zzzc zzzcVar = this.zzi;
        zzzcVar.getClass();
        return zzzcVar.zze(j - this.zzk);
    }

    public final boolean zzS() {
        if (zzcW()) {
            return this.zzn;
        }
        zzzc zzzcVar = this.zzi;
        zzzcVar.getClass();
        return zzzcVar.zzb();
    }

    public final void zzT() {
        zznb zznbVar;
        synchronized (this.zza) {
            zznbVar = this.zzr;
        }
        if (zznbVar != null) {
            zznbVar.zza(this);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzna, com.google.android.gms.internal.ads.zznc
    public final int zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final zznc zzb() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final void zzc(int i, zzqf zzqfVar, zzdo zzdoVar) {
        this.zze = i;
        this.zzf = zzqfVar;
        this.zzg = zzdoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final void zzcT() {
        zzgtj.zzi(this.zzh == 1);
        this.zzh = 2;
        zzB();
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final void zzcU(zzv[] zzvVarArr, zzzc zzzcVar, long j, long j2, zzxk zzxkVar) {
        zzgtj.zzi(!this.zzn);
        this.zzi = zzzcVar;
        this.zzq = zzxkVar;
        if (this.zzm == Long.MIN_VALUE) {
            this.zzm = j;
        }
        this.zzj = zzvVarArr;
        this.zzk = j2;
        zzz(zzvVarArr, j, j2, zzxkVar);
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final zzzc zzcV() {
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final boolean zzcW() {
        return this.zzm == Long.MIN_VALUE;
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public zzmb zzd() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final int zze() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final void zzf(zznd zzndVar, zzv[] zzvVarArr, zzzc zzzcVar, long j, boolean z, boolean z2, long j2, long j3, zzxk zzxkVar) {
        zzgtj.zzi(this.zzh == 0);
        this.zzd = zzndVar;
        this.zzq = zzxkVar;
        this.zzh = 1;
        zzy(z, z2);
        zzcU(zzvVarArr, zzzcVar, j2, j3, zzxkVar);
        zzae(j2, z, true);
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final long zzk() {
        return this.zzm;
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final void zzl() {
        this.zzn = true;
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final boolean zzm() {
        return this.zzn;
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final void zzn() {
        zzzc zzzcVar = this.zzi;
        zzzcVar.getClass();
        zzzcVar.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final void zzo(zzbf zzbfVar) {
        if (Objects.equals(this.zzp, zzbfVar)) {
            return;
        }
        this.zzp = zzbfVar;
        zzG(zzbfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final void zzp(long j, boolean z) {
        zzae(j, false, z);
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final void zzq() {
        zzgtj.zzi(this.zzh == 2);
        this.zzh = 1;
        zzC();
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final void zzr() {
        zzgtj.zzi(this.zzh == 1);
        zzlw zzlwVar = this.zzc;
        zzlwVar.zza = null;
        zzlwVar.zzb = null;
        this.zzh = 0;
        this.zzi = null;
        this.zzj = null;
        this.zzn = false;
        zzD();
        this.zzq = null;
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final void zzs() {
        zzgtj.zzi(this.zzh == 0);
        zzlw zzlwVar = this.zzc;
        zzlwVar.zza = null;
        zzlwVar.zzb = null;
        zzE();
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final void zzt() {
        zzgtj.zzi(this.zzh == 0);
        zzF();
    }

    @Override // com.google.android.gms.internal.ads.zznc
    public final void zzv(zznb zznbVar) {
        synchronized (this.zza) {
            this.zzr = zznbVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zznc
    public final void zzw() {
        synchronized (this.zza) {
            this.zzr = null;
        }
    }

    public abstract void zzy(boolean z, boolean z2);

    public abstract void zzz(zzv[] zzvVarArr, long j, long j2, zzxk zzxkVar);
}
