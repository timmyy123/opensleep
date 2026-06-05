package com.google.android.gms.internal.ads;

import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public final class zzapr implements zzapt {
    private final zzet zza;
    private final String zzc;
    private final int zzd;
    private String zzf;
    private zzahk zzg;
    private int zzi;
    private int zzj;
    private long zzk;
    private zzv zzl;
    private int zzm;
    private int zzn;
    private int zzh = 0;
    private long zzq = -9223372036854775807L;
    private final AtomicInteger zzb = new AtomicInteger();
    private int zzo = -1;
    private int zzp = -1;
    private final String zze = "video/mp2t";

    public zzapr(String str, int i, int i2, String str2) {
        this.zza = new zzet(new byte[i2]);
        this.zzc = str;
        this.zzd = i;
    }

    private final boolean zzf(zzet zzetVar, byte[] bArr, int i) {
        int iMin = Math.min(zzetVar.zzd(), i - this.zzi);
        zzetVar.zzm(bArr, this.zzi, iMin);
        int i2 = this.zzi + iMin;
        this.zzi = i2;
        return i2 == i;
    }

    private final void zzg(zzafw zzafwVar) {
        int i;
        int i2 = zzafwVar.zzb;
        if (i2 == -2147483647 || (i = zzafwVar.zzc) == -1) {
            return;
        }
        zzv zzvVar = this.zzl;
        if (zzvVar != null && i == zzvVar.zzH && i2 == zzvVar.zzI && Objects.equals(zzafwVar.zza, zzvVar.zzp)) {
            return;
        }
        zzv zzvVar2 = this.zzl;
        zzt zztVar = zzvVar2 == null ? new zzt() : zzvVar2.zza();
        zztVar.zza(this.zzf);
        zztVar.zzn(this.zze);
        zztVar.zzo(zzafwVar.zza);
        zztVar.zzG(i);
        zztVar.zzH(i2);
        zztVar.zze(this.zzc);
        zztVar.zzg(this.zzd);
        zzv zzvVarZzO = zztVar.zzO();
        this.zzl = zzvVarZzO;
        this.zzg.zzA(zzvVarZzO);
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zza() {
        this.zzh = 0;
        this.zzi = 0;
        this.zzj = 0;
        this.zzq = -9223372036854775807L;
        this.zzb.set(0);
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzb(zzagb zzagbVar, zzarh zzarhVar) {
        zzarhVar.zza();
        this.zzf = zzarhVar.zzc();
        this.zzg = zzagbVar.zzu(zzarhVar.zzb(), 1);
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzc(long j, int i) {
        this.zzq = j;
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzd(zzet zzetVar) throws zzat {
        int i;
        byte b;
        int i2;
        byte b2;
        this.zzg.getClass();
        while (zzetVar.zzd() > 0) {
            int i3 = this.zzh;
            if (i3 == 0) {
                while (true) {
                    if (zzetVar.zzd() > 0) {
                        int i4 = this.zzj << 8;
                        this.zzj = i4;
                        int iZzs = i4 | zzetVar.zzs();
                        this.zzj = iZzs;
                        int iZza = zzafx.zza(iZzs);
                        this.zzn = iZza;
                        if (iZza != 0) {
                            byte[] bArrZzi = this.zza.zzi();
                            int i5 = this.zzj;
                            bArrZzi[0] = (byte) ((i5 >> 24) & PHIpAddressSearchManager.END_IP_SCAN);
                            bArrZzi[1] = (byte) ((i5 >> 16) & PHIpAddressSearchManager.END_IP_SCAN);
                            bArrZzi[2] = (byte) ((i5 >> 8) & PHIpAddressSearchManager.END_IP_SCAN);
                            bArrZzi[3] = (byte) (i5 & PHIpAddressSearchManager.END_IP_SCAN);
                            this.zzi = 4;
                            this.zzj = 0;
                            int i6 = this.zzn;
                            if (i6 == 3 || i6 == 4) {
                                this.zzh = 4;
                            } else if (i6 == 1) {
                                this.zzh = 1;
                            } else {
                                this.zzh = 2;
                            }
                        }
                    }
                }
            } else if (i3 == 1) {
                zzet zzetVar2 = this.zza;
                if (zzf(zzetVar, zzetVar2.zzi(), 18)) {
                    byte[] bArrZzi2 = zzetVar2.zzi();
                    if (this.zzl == null) {
                        zzv zzvVarZzb = zzafx.zzb(bArrZzi2, this.zzf, this.zzc, this.zzd, this.zze, null);
                        this.zzl = zzvVarZzb;
                        this.zzg.zzA(zzvVarZzb);
                    }
                    this.zzm = zzafx.zzc(bArrZzi2);
                    byte b3 = bArrZzi2[0];
                    if (b3 != -2) {
                        if (b3 == -1) {
                            i = (bArrZzi2[4] & 7) << 4;
                            b2 = bArrZzi2[7];
                        } else if (b3 != 31) {
                            i = (bArrZzi2[4] & 1) << 6;
                            b = bArrZzi2[5];
                        } else {
                            i = (bArrZzi2[5] & 7) << 4;
                            b2 = bArrZzi2[6];
                        }
                        i2 = b2 & 60;
                        this.zzk = zzhah.zza(zzfl.zzt(((i | (i2 >> 2)) + 1) * 32, this.zzl.zzI));
                        zzetVar2.zzh(0);
                        this.zzg.zzc(zzetVar2, 18);
                        this.zzh = 6;
                    } else {
                        i = (bArrZzi2[5] & 1) << 6;
                        b = bArrZzi2[4];
                    }
                    i2 = b & 252;
                    this.zzk = zzhah.zza(zzfl.zzt(((i | (i2 >> 2)) + 1) * 32, this.zzl.zzI));
                    zzetVar2.zzh(0);
                    this.zzg.zzc(zzetVar2, 18);
                    this.zzh = 6;
                }
            } else if (i3 != 2) {
                if (i3 == 3) {
                    zzet zzetVar3 = this.zza;
                    if (zzf(zzetVar, zzetVar3.zzi(), this.zzo)) {
                        zzafw zzafwVarZzd = zzafx.zzd(zzetVar3.zzi());
                        zzg(zzafwVarZzd);
                        this.zzm = zzafwVarZzd.zzd;
                        long j = zzafwVarZzd.zze;
                        this.zzk = j != -9223372036854775807L ? j : 0L;
                        zzetVar3.zzh(0);
                        this.zzg.zzc(zzetVar3, this.zzo);
                        this.zzh = 6;
                    }
                } else if (i3 == 4) {
                    zzet zzetVar4 = this.zza;
                    if (zzf(zzetVar, zzetVar4.zzi(), 6)) {
                        int iZzg = zzafx.zzg(zzetVar4.zzi());
                        this.zzp = iZzg;
                        int i7 = this.zzi;
                        if (i7 > iZzg) {
                            int i8 = i7 - iZzg;
                            this.zzi = i7 - i8;
                            zzetVar.zzh(zzetVar.zzg() - i8);
                        }
                        this.zzh = 5;
                    }
                } else if (i3 != 5) {
                    int iMin = Math.min(zzetVar.zzd(), this.zzm - this.zzi);
                    this.zzg.zzc(zzetVar, iMin);
                    int i9 = this.zzi + iMin;
                    this.zzi = i9;
                    if (i9 == this.zzm) {
                        zzgtj.zzi(this.zzq != -9223372036854775807L);
                        this.zzg.zze(this.zzq, this.zzn == 4 ? 0 : 1, this.zzm, 0, null);
                        this.zzq += this.zzk;
                        this.zzh = 0;
                    }
                } else {
                    zzet zzetVar5 = this.zza;
                    if (zzf(zzetVar, zzetVar5.zzi(), this.zzp)) {
                        zzafw zzafwVarZzf = zzafx.zzf(zzetVar5.zzi(), this.zzb);
                        if (this.zzn == 3) {
                            zzg(zzafwVarZzf);
                        }
                        this.zzm = zzafwVarZzf.zzd;
                        long j2 = zzafwVarZzf.zze;
                        this.zzk = j2 != -9223372036854775807L ? j2 : 0L;
                        zzetVar5.zzh(0);
                        this.zzg.zzc(zzetVar5, this.zzp);
                        this.zzh = 6;
                    }
                }
            } else {
                zzet zzetVar6 = this.zza;
                if (zzf(zzetVar, zzetVar6.zzi(), 7)) {
                    this.zzo = zzafx.zze(zzetVar6.zzi());
                    this.zzh = 3;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zze(boolean z) {
    }
}
