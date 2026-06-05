package com.google.android.gms.internal.ads;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzain extends zzaim {
    private final zzet zzb;
    private final zzet zzc;
    private int zzd;
    private boolean zze;
    private boolean zzf;
    private int zzg;

    public zzain(zzahk zzahkVar) {
        super(zzahkVar);
        this.zzb = new zzet(zzgp.zza);
        this.zzc = new zzet(4);
    }

    @Override // com.google.android.gms.internal.ads.zzaim
    public final boolean zza(zzet zzetVar) throws zzail {
        int iZzs = zzetVar.zzs();
        int i = iZzs >> 4;
        int i2 = iZzs & 15;
        if (i2 != 7) {
            throw new zzail(zzba$$ExternalSyntheticOutline0.m(i2, "Video format not supported: ", new StringBuilder(String.valueOf(i2).length() + 28)));
        }
        this.zzg = i;
        return i != 5;
    }

    @Override // com.google.android.gms.internal.ads.zzaim
    public final boolean zzb(zzet zzetVar, long j) throws zzat {
        int i;
        int iZzs = zzetVar.zzs();
        long jZzy = zzetVar.zzy();
        if (iZzs == 0) {
            if (!this.zze) {
                zzet zzetVar2 = new zzet(new byte[zzetVar.zzd()]);
                zzetVar.zzm(zzetVar2.zzi(), 0, zzetVar.zzd());
                zzafd zzafdVarZza = zzafd.zza(zzetVar2);
                this.zzd = zzafdVarZza.zzb;
                zzt zztVar = new zzt();
                zztVar.zzn("video/x-flv");
                zztVar.zzo("video/avc");
                zztVar.zzk(zzafdVarZza.zzl);
                zztVar.zzv(zzafdVarZza.zzc);
                zztVar.zzw(zzafdVarZza.zzd);
                zztVar.zzB(zzafdVarZza.zzk);
                zztVar.zzr(zzafdVarZza.zza);
                this.zza.zzA(zztVar.zzO());
                this.zze = true;
                return false;
            }
        } else if (iZzs == 1 && this.zze) {
            int i2 = this.zzg == 1 ? 1 : 0;
            if (this.zzf) {
                i = i2;
            } else if (i2 != 0) {
                i = 1;
            }
            zzet zzetVar3 = this.zzc;
            byte[] bArrZzi = zzetVar3.zzi();
            bArrZzi[0] = 0;
            bArrZzi[1] = 0;
            bArrZzi[2] = 0;
            int i3 = 4 - this.zzd;
            int i4 = 0;
            while (zzetVar.zzd() > 0) {
                zzetVar.zzm(zzetVar3.zzi(), i3, this.zzd);
                zzetVar3.zzh(0);
                zzet zzetVar4 = this.zzb;
                int iZzH = zzetVar3.zzH();
                zzetVar4.zzh(0);
                zzahk zzahkVar = this.zza;
                zzahkVar.zzc(zzetVar4, 4);
                zzahkVar.zzc(zzetVar, iZzH);
                i4 = i4 + 4 + iZzH;
            }
            this.zza.zze((jZzy * 1000) + j, i, i4, 0, null);
            this.zzf = true;
            return true;
        }
        return false;
    }
}
