package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.Surface;
import com.google.home.Home$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzadu {
    private final zzadt zza;
    private final zzaeb zzb;
    private boolean zzc;
    private long zzf;
    private boolean zzi;
    private boolean zzl;
    private boolean zzm;
    private int zzd = 0;
    private long zze = -9223372036854775807L;
    private long zzg = -9223372036854775807L;
    private long zzh = -9223372036854775807L;
    private float zzj = 1.0f;
    private zzdo zzk = zzdo.zza;

    public zzadu(Context context, zzadt zzadtVar, long j) {
        this.zza = zzadtVar;
        this.zzb = new zzaeb(context);
    }

    private final void zzo(int i) {
        this.zzd = Math.min(this.zzd, i);
    }

    public final void zza(int i) {
        if (i == 0) {
            this.zzd = 1;
        } else if (i != 1) {
            zzo(2);
        } else {
            this.zzd = 0;
        }
        this.zzb.zzd();
    }

    public final void zzb() {
        this.zzc = true;
        this.zzf = zzfl.zzs(this.zzk.zzb());
        this.zzb.zzb();
    }

    public final void zzc() {
        this.zzc = false;
        this.zzh = -9223372036854775807L;
        this.zzb.zzh();
    }

    public final void zzd(Surface surface) {
        this.zzl = surface != null;
        this.zzm = false;
        this.zzb.zzc(surface);
        zzo(1);
    }

    public final void zze(float f) {
        this.zzb.zzf(f);
    }

    public final boolean zzf() {
        int i = this.zzd;
        this.zzd = 3;
        this.zzf = zzfl.zzs(this.zzk.zzb());
        return i != 3;
    }

    public final void zzg(zzdo zzdoVar) {
        this.zzk = zzdoVar;
    }

    public final void zzh() {
        if (this.zzd == 0) {
            this.zzd = 1;
        }
    }

    public final boolean zzi(boolean z) {
        if (z && (this.zzd == 3 || (this.zzm && !this.zzl))) {
            this.zzh = -9223372036854775807L;
            return true;
        }
        if (this.zzh == -9223372036854775807L) {
            return false;
        }
        if (this.zzk.zzb() < this.zzh) {
            return true;
        }
        this.zzh = -9223372036854775807L;
        return false;
    }

    public final void zzj(boolean z) {
        this.zzi = z;
        this.zzh = -9223372036854775807L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00bd, code lost:
    
        if (r17 > 100000) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00c8, code lost:
    
        if (r24 >= r28) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00cf, code lost:
    
        if (r21.zzc != false) goto L58;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int zzk(long j, long j2, long j3, long j4, boolean z, boolean z2, zzads zzadsVar) {
        long j5;
        zzadsVar.zzc();
        if (this.zzc && this.zze == -9223372036854775807L) {
            this.zze = j2;
        }
        if (this.zzg != j) {
            this.zzb.zzg(j);
            this.zzg = j;
        }
        long jZzs = (long) ((j - j2) / ((double) this.zzj));
        if (this.zzc) {
            jZzs -= zzfl.zzs(this.zzk.zzb()) - j3;
        }
        zzadsVar.zze(jZzs);
        if (z && !z2) {
            return 3;
        }
        if (!this.zzl) {
            if (this.zza.zzaq(zzadsVar.zzd(), j2, j3, z2, true)) {
                return 4;
            }
            if (this.zzc && zzadsVar.zzd() < 30000) {
                return 3;
            }
            this.zzm = true;
            return 5;
        }
        long jZzd = zzadsVar.zzd();
        boolean z3 = false;
        if (this.zzh == -9223372036854775807L || this.zzi) {
            int i = this.zzd;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        j5 = -9223372036854775807L;
                    } else {
                        if (i != 3) {
                            Home$$ExternalSyntheticBUOutline0.m$2();
                            return 0;
                        }
                        j5 = -9223372036854775807L;
                        long jZzs2 = zzfl.zzs(this.zzk.zzb()) - this.zzf;
                        if (this.zzc) {
                            long j6 = this.zze;
                            if (j6 != -9223372036854775807L) {
                                if (j6 != j2) {
                                    if (jZzd < -30000) {
                                    }
                                }
                            }
                        }
                    }
                }
                return 0;
            }
            j5 = -9223372036854775807L;
        } else {
            j5 = -9223372036854775807L;
        }
        if (!this.zzc || j2 == this.zze) {
            return 5;
        }
        long jZzc = this.zzk.zzc();
        zzadsVar.zzg(this.zzb.zzi((zzadsVar.zzd() * 1000) + jZzc, j));
        zzadsVar.zze((zzadsVar.zzf() - jZzc) / 1000);
        if (this.zzh != j5 && !this.zzi) {
            z3 = true;
        }
        if (this.zza.zzaq(zzadsVar.zzd(), j2, j3, z2, z3)) {
            return 4;
        }
        return (zzadsVar.zzd() >= -30000 || z2) ? zzadsVar.zzd() > 50000 ? 5 : 1 : z3 ? 3 : 2;
    }

    public final void zzl() {
        this.zzb.zzd();
        this.zzg = -9223372036854775807L;
        this.zze = -9223372036854775807L;
        zzo(1);
        this.zzh = -9223372036854775807L;
        this.zzm = false;
    }

    public final void zzm(int i) {
        this.zzb.zza(i);
    }

    public final void zzn(float f) {
        zzgtj.zza(f > 0.0f);
        if (f == this.zzj) {
            return;
        }
        this.zzj = f;
        this.zzb.zze(f);
    }
}
