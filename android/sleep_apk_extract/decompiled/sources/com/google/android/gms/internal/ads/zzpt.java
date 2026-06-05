package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzpt {
    final /* synthetic */ zzpu zza;
    private final String zzb;
    private int zzc;
    private long zzd;
    private zzxk zze;
    private boolean zzf;
    private boolean zzg;

    public zzpt(zzpu zzpuVar, String str, int i, zzxk zzxkVar) {
        Objects.requireNonNull(zzpuVar);
        this.zza = zzpuVar;
        this.zzb = str;
        this.zzc = i;
        this.zzd = zzxkVar == null ? -1L : zzxkVar.zzd;
        if (zzxkVar == null || !zzxkVar.zzb()) {
            return;
        }
        this.zze = zzxkVar;
    }

    public final boolean zza(zzbf zzbfVar, zzbf zzbfVar2) {
        int i = this.zzc;
        if (i < zzbfVar.zza()) {
            zzpu zzpuVar = this.zza;
            zzbfVar.zzb(i, zzpuVar.zzj(), 0L);
            for (int i2 = zzpuVar.zzj().zzn; i2 <= zzpuVar.zzj().zzo; i2++) {
                int iZze = zzbfVar2.zze(zzbfVar.zzf(i2));
                if (iZze != -1) {
                    i = zzbfVar2.zzd(iZze, zzpuVar.zzk(), false).zzc;
                    break;
                }
            }
            i = -1;
        } else if (i >= zzbfVar2.zza()) {
            i = -1;
        }
        this.zzc = i;
        if (i == -1) {
            return false;
        }
        zzxk zzxkVar = this.zze;
        return zzxkVar == null || zzbfVar2.zze(zzxkVar.zza) != -1;
    }

    public final boolean zzb(int i, zzxk zzxkVar) {
        if (zzxkVar != null) {
            long j = zzxkVar.zzd;
            if (j != -1) {
                zzxk zzxkVar2 = this.zze;
                return zzxkVar2 == null ? !zzxkVar.zzb() && j == this.zzd : j == zzxkVar2.zzd && zzxkVar.zzb == zzxkVar2.zzb && zzxkVar.zzc == zzxkVar2.zzc;
            }
        }
        return i == this.zzc;
    }

    public final void zzc(int i, zzxk zzxkVar) {
        if (this.zzd == -1 && i == this.zzc && zzxkVar != null) {
            zzpu zzpuVar = this.zza;
            long j = zzxkVar.zzd;
            if (j >= zzpuVar.zzi()) {
                this.zzd = j;
            }
        }
    }

    public final boolean zzd(zznn zznnVar) {
        zzxk zzxkVar = zznnVar.zzd;
        if (zzxkVar == null) {
            return this.zzc != zznnVar.zzc;
        }
        long j = this.zzd;
        if (j == -1) {
            return false;
        }
        long j2 = zzxkVar.zzd;
        if (j2 > j) {
            return true;
        }
        if (this.zze == null) {
            return false;
        }
        zzbf zzbfVar = zznnVar.zzb;
        int iZze = zzbfVar.zze(zzxkVar.zza);
        int iZze2 = zzbfVar.zze(this.zze.zza);
        zzxk zzxkVar2 = this.zze;
        if (j2 < zzxkVar2.zzd || iZze < iZze2) {
            return false;
        }
        if (iZze > iZze2) {
            return true;
        }
        if (!zzxkVar.zzb()) {
            int i = zzxkVar.zze;
            return i == -1 || i > zzxkVar2.zzb;
        }
        int i2 = zzxkVar.zzb;
        int i3 = zzxkVar.zzc;
        int i4 = zzxkVar2.zzb;
        if (i2 <= i4) {
            return i2 == i4 && i3 > zzxkVar2.zzc;
        }
        return true;
    }

    public final /* synthetic */ String zze() {
        return this.zzb;
    }

    public final /* synthetic */ int zzf() {
        return this.zzc;
    }

    public final /* synthetic */ long zzg() {
        return this.zzd;
    }

    public final /* synthetic */ zzxk zzh() {
        return this.zze;
    }

    public final /* synthetic */ boolean zzi() {
        return this.zzf;
    }

    public final /* synthetic */ void zzj(boolean z) {
        this.zzf = true;
    }

    public final /* synthetic */ boolean zzk() {
        return this.zzg;
    }

    public final /* synthetic */ void zzl(boolean z) {
        this.zzg = true;
    }
}
