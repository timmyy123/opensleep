package com.google.android.gms.internal.ads;

import adamb.ogg.OggIO$$ExternalSyntheticBUOutline0;
import java.io.IOException;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzamo implements zzamv {
    private final zzamu zza;
    private final long zzb;
    private final long zzc;
    private final zzamz zzd;
    private int zze;
    private long zzf;
    private long zzg;
    private long zzh;
    private long zzi;
    private long zzj;
    private long zzk;
    private long zzl;

    public zzamo(zzamz zzamzVar, long j, long j2, long j3, long j4, boolean z) {
        zzgtj.zza(j >= 0 && j2 > j);
        this.zzd = zzamzVar;
        this.zzb = j;
        this.zzc = j2;
        if (j3 == j2 - j || z) {
            this.zzf = j4;
            this.zze = 4;
        } else {
            this.zze = 0;
        }
        this.zza = new zzamu();
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final long zza(zzafz zzafzVar) throws IOException {
        long j;
        long j2;
        long j3;
        int i = this.zze;
        long jMax = -1;
        if (i == 0) {
            j = 0;
            long jZzn = zzafzVar.zzn();
            this.zzg = jZzn;
            this.zze = 1;
            long j4 = this.zzc - 65307;
            if (j4 > jZzn) {
                return j4;
            }
        } else if (i != 1) {
            if (i == 2) {
                long j5 = this.zzi;
                long j6 = this.zzj;
                if (j5 == j6) {
                    j3 = -1;
                    j2 = 2;
                } else {
                    long jZzn2 = zzafzVar.zzn();
                    zzamu zzamuVar = this.zza;
                    if (zzamuVar.zzb(zzafzVar, j6)) {
                        zzamuVar.zzc(zzafzVar, false);
                        zzafzVar.zzl();
                        long j7 = this.zzh;
                        j2 = 2;
                        long j8 = zzamuVar.zzb;
                        long j9 = j7 - j8;
                        int i2 = zzamuVar.zzd + zzamuVar.zze;
                        if (j9 < 0 || j9 >= 72000) {
                            if (j9 < 0) {
                                this.zzj = jZzn2;
                                this.zzl = j8;
                            } else {
                                this.zzi = ((long) i2) + zzafzVar.zzn();
                                this.zzk = j8;
                            }
                            long j10 = this.zzj;
                            long j11 = this.zzi;
                            long j12 = j10 - j11;
                            if (j12 < 100000) {
                                this.zzj = j11;
                                j3 = -1;
                                jMax = j11;
                            } else {
                                long jZzn3 = zzafzVar.zzn() - (((long) i2) * (j9 <= 0 ? 2L : 1L));
                                j3 = -1;
                                String str = zzfl.zza;
                                jMax = Math.max(j11, Math.min(((j9 * j12) / (this.zzl - this.zzk)) + jZzn3, j10 - 1));
                            }
                        } else {
                            j3 = -1;
                        }
                    } else {
                        long j13 = this.zzi;
                        if (j13 == jZzn2) {
                            OggIO$$ExternalSyntheticBUOutline0.m("No ogg page can be found.");
                            return 0L;
                        }
                        j3 = -1;
                        j2 = 2;
                        jMax = j13;
                    }
                }
                if (jMax != j3) {
                    return jMax;
                }
                this.zze = 3;
            } else {
                if (i != 3) {
                    return -1L;
                }
                j3 = -1;
                j2 = 2;
            }
            while (true) {
                zzamu zzamuVar2 = this.zza;
                zzamuVar2.zzb(zzafzVar, j3);
                zzamuVar2.zzc(zzafzVar, false);
                if (zzamuVar2.zzb > this.zzh) {
                    zzafzVar.zzl();
                    this.zze = 4;
                    return -(this.zzk + j2);
                }
                zzafzVar.zzf(zzamuVar2.zzd + zzamuVar2.zze);
                this.zzi = zzafzVar.zzn();
                this.zzk = zzamuVar2.zzb;
                j3 = -1;
            }
        } else {
            j = 0;
        }
        zzamu zzamuVar3 = this.zza;
        zzamuVar3.zza();
        if (!zzamuVar3.zzb(zzafzVar, -1L)) {
            Utf8$$ExternalSyntheticBUOutline0.m$2();
            return j;
        }
        zzamuVar3.zzc(zzafzVar, false);
        zzafzVar.zzf(zzamuVar3.zzd + zzamuVar3.zze);
        long j14 = zzamuVar3.zzb;
        while ((zzamuVar3.zza & 4) != 4 && zzamuVar3.zzb(zzafzVar, -1L) && zzafzVar.zzn() < this.zzc && zzamuVar3.zzc(zzafzVar, true) && zzagc.zzd(zzafzVar, zzamuVar3.zzd + zzamuVar3.zze)) {
            j14 = zzamuVar3.zzb;
        }
        this.zzf = j14;
        this.zze = 4;
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void zzb(long j) {
        long j2 = this.zzf - 1;
        String str = zzfl.zza;
        this.zzh = Math.max(0L, Math.min(j, j2));
        this.zze = 2;
        this.zzi = this.zzb;
        this.zzj = this.zzc;
        this.zzk = 0L;
        this.zzl = this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final /* bridge */ /* synthetic */ zzahb zzc() {
        byte[] bArr = null;
        if (this.zzf != 0) {
            return new zzamn(this, bArr);
        }
        return null;
    }

    public final /* synthetic */ long zzd() {
        return this.zzb;
    }

    public final /* synthetic */ long zze() {
        return this.zzc;
    }

    public final /* synthetic */ zzamz zzf() {
        return this.zzd;
    }

    public final /* synthetic */ long zzg() {
        return this.zzf;
    }
}
