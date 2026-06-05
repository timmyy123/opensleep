package com.google.android.gms.internal.ads;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzaqm implements zzari {
    private final zzapt zza;
    private final zzes zzb = new zzes(new byte[10], 10);
    private int zzc = 0;
    private int zzd;
    private zzfi zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private int zzi;
    private int zzj;
    private boolean zzk;

    public zzaqm(zzapt zzaptVar) {
        this.zza = zzaptVar;
    }

    private final void zze(int i) {
        this.zzc = i;
        this.zzd = 0;
    }

    private final boolean zzf(zzet zzetVar, byte[] bArr, int i) {
        int iMin = Math.min(zzetVar.zzd(), i - this.zzd);
        if (iMin <= 0) {
            return true;
        }
        if (bArr == null) {
            zzetVar.zzk(iMin);
        } else {
            zzetVar.zzm(bArr, this.zzd, iMin);
        }
        int i2 = this.zzd + iMin;
        this.zzd = i2;
        return i2 == i;
    }

    @Override // com.google.android.gms.internal.ads.zzari
    public final void zza(zzfi zzfiVar, zzagb zzagbVar, zzarh zzarhVar) {
        this.zze = zzfiVar;
        this.zza.zzb(zzagbVar, zzarhVar);
    }

    @Override // com.google.android.gms.internal.ads.zzari
    public final void zzb() {
        this.zzc = 0;
        this.zzd = 0;
        this.zzh = false;
        this.zza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzari
    public final void zzc(zzet zzetVar, int i) {
        int i2;
        int i3;
        long jZze;
        long j;
        this.zze.getClass();
        int i4 = -1;
        int i5 = 2;
        if ((i & 1) != 0) {
            int i6 = this.zzc;
            if (i6 != 0 && i6 != 1) {
                if (i6 != 2) {
                    int i7 = this.zzj;
                    if (i7 != -1) {
                        StringBuilder sb = new StringBuilder(String.valueOf(i7).length() + 48);
                        sb.append("Unexpected start indicator: expected ");
                        sb.append(i7);
                        sb.append(" more bytes");
                        zzeg.zzc("PesReader", sb.toString());
                    }
                    this.zza.zze(zzetVar.zze() == 0);
                } else {
                    zzeg.zzc("PesReader", "Unexpected start indicator reading extended header");
                }
            }
            zze(1);
        }
        int i8 = i;
        while (zzetVar.zzd() > 0) {
            int i9 = this.zzc;
            if (i9 == 0) {
                i2 = i5;
                zzetVar.zzk(zzetVar.zzd());
            } else if (i9 != 1) {
                if (i9 != i5) {
                    int iZzd = zzetVar.zzd();
                    int i10 = this.zzj;
                    int i11 = i10 == i4 ? 0 : iZzd - i10;
                    if (i11 > 0) {
                        iZzd -= i11;
                        zzetVar.zzf(zzetVar.zzg() + iZzd);
                    }
                    zzapt zzaptVar = this.zza;
                    zzaptVar.zzd(zzetVar);
                    int i12 = this.zzj;
                    if (i12 != i4) {
                        int i13 = i12 - iZzd;
                        this.zzj = i13;
                        if (i13 == 0) {
                            zzaptVar.zze(false);
                            zze(1);
                        }
                    }
                } else {
                    int iMin = Math.min(10, this.zzi);
                    zzes zzesVar = this.zzb;
                    if (zzf(zzetVar, zzesVar.zza, iMin) && zzf(zzetVar, null, this.zzi)) {
                        zzesVar.zzf(0);
                        if (this.zzf) {
                            zzesVar.zzh(4);
                            long jZzj = zzesVar.zzj(3);
                            zzesVar.zzh(1);
                            int iZzj = zzesVar.zzj(15) << 15;
                            zzesVar.zzh(1);
                            long jZzj2 = zzesVar.zzj(15);
                            zzesVar.zzh(1);
                            if (this.zzh || !this.zzg) {
                                j = jZzj;
                            } else {
                                zzesVar.zzh(4);
                                j = jZzj;
                                long jZzj3 = ((long) zzesVar.zzj(3)) << 30;
                                zzesVar.zzh(1);
                                int iZzj2 = zzesVar.zzj(15) << 15;
                                zzesVar.zzh(1);
                                long jZzj4 = zzesVar.zzj(15);
                                zzesVar.zzh(1);
                                this.zze.zze(jZzj3 | ((long) iZzj2) | jZzj4);
                                this.zzh = true;
                            }
                            jZze = this.zze.zze(jZzj2 | (j << 30) | ((long) iZzj));
                        } else {
                            jZze = -9223372036854775807L;
                        }
                        i8 |= true != this.zzk ? 0 : 4;
                        this.zza.zzc(jZze, i8);
                        zze(3);
                        i4 = -1;
                        i5 = 2;
                    }
                }
                i2 = i5;
            } else {
                zzes zzesVar2 = this.zzb;
                if (zzf(zzetVar, zzesVar2.zza, 9)) {
                    zzesVar2.zzf(0);
                    int iZzj3 = zzesVar2.zzj(24);
                    if (iZzj3 != 1) {
                        zzba$$ExternalSyntheticOutline0.m258m(new StringBuilder(String.valueOf(iZzj3).length() + 30), "Unexpected start code prefix: ", iZzj3, "PesReader");
                        i4 = -1;
                        this.zzj = -1;
                        i3 = 0;
                        i2 = 2;
                    } else {
                        zzesVar2.zzh(8);
                        int iZzj4 = zzesVar2.zzj(16);
                        zzesVar2.zzh(5);
                        this.zzk = zzesVar2.zzi();
                        i2 = 2;
                        zzesVar2.zzh(2);
                        this.zzf = zzesVar2.zzi();
                        this.zzg = zzesVar2.zzi();
                        zzesVar2.zzh(6);
                        int iZzj5 = zzesVar2.zzj(8);
                        this.zzi = iZzj5;
                        if (iZzj4 == 0) {
                            this.zzj = -1;
                            i4 = -1;
                        } else {
                            int i14 = (iZzj4 - 3) - iZzj5;
                            this.zzj = i14;
                            if (i14 < 0) {
                                zzba$$ExternalSyntheticOutline0.m258m(new StringBuilder(String.valueOf(i14).length() + 36), "Found negative packet payload size: ", i14, "PesReader");
                                i4 = -1;
                                this.zzj = -1;
                            } else {
                                i4 = -1;
                            }
                        }
                        i3 = 2;
                    }
                    zze(i3);
                } else {
                    i4 = -1;
                    i2 = 2;
                }
            }
            i5 = i2;
        }
    }

    public final boolean zzd(boolean z) {
        return this.zzc == 3 && this.zzj == -1;
    }
}
