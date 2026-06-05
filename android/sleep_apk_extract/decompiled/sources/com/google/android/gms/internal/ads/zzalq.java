package com.google.android.gms.internal.ads;

import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;

/* JADX INFO: loaded from: classes3.dex */
final class zzalq {
    public final zzahk zza;
    public zzaml zzd;
    public zzalk zze;
    public int zzf;
    public int zzg;
    public int zzh;
    public int zzi;
    private final zzv zzj;
    private boolean zzm;
    public final zzamk zzb = new zzamk();
    public final zzet zzc = new zzet();
    private final zzet zzk = new zzet(1);
    private final zzet zzl = new zzet();

    public zzalq(zzahk zzahkVar, zzaml zzamlVar, zzalk zzalkVar, zzv zzvVar) {
        this.zza = zzahkVar;
        this.zzd = zzamlVar;
        this.zze = zzalkVar;
        this.zzj = zzvVar;
        zza(zzamlVar, zzalkVar);
    }

    public final void zza(zzaml zzamlVar, zzalk zzalkVar) {
        this.zzd = zzamlVar;
        this.zze = zzalkVar;
        this.zza.zzA(this.zzj);
        zzc();
    }

    public final void zzb(zzq zzqVar) {
        zzami zzamiVar = this.zzd.zza;
        zzalk zzalkVar = this.zzb.zza;
        String str = zzfl.zza;
        zzamj zzamjVarZza = zzamiVar.zza(zzalkVar.zza);
        zzq zzqVarZzb = zzqVar.zzb(zzamjVarZza != null ? zzamjVarZza.zzb : null);
        zzt zztVarZza = this.zzj.zza();
        zztVarZza.zzs(zzqVarZzb);
        this.zza.zzA(zztVarZza.zzO());
    }

    public final void zzc() {
        zzamk zzamkVar = this.zzb;
        zzamkVar.zzd = 0;
        zzamkVar.zzp = 0L;
        zzamkVar.zzq = false;
        zzamkVar.zzk = false;
        zzamkVar.zzo = false;
        zzamkVar.zzm = null;
        this.zzf = 0;
        this.zzh = 0;
        this.zzg = 0;
        this.zzi = 0;
        this.zzm = false;
    }

    public final long zzd() {
        if (!this.zzm) {
            return this.zzd.zzf[this.zzf];
        }
        zzamk zzamkVar = this.zzb;
        return zzamkVar.zzi[this.zzf];
    }

    public final long zze() {
        return !this.zzm ? this.zzd.zzc[this.zzf] : this.zzb.zzf[this.zzh];
    }

    public final int zzf() {
        return !this.zzm ? this.zzd.zzd[this.zzf] : this.zzb.zzh[this.zzf];
    }

    public final int zzg() {
        int i = !this.zzm ? this.zzd.zzg[this.zzf] : this.zzb.zzj[this.zzf] ? 1 : 0;
        return zzj() != null ? 1073741824 | i : i;
    }

    public final boolean zzh() {
        this.zzf++;
        if (!this.zzm) {
            return false;
        }
        int i = this.zzg + 1;
        this.zzg = i;
        int[] iArr = this.zzb.zzg;
        int i2 = this.zzh;
        if (i != iArr[i2]) {
            return true;
        }
        this.zzh = i2 + 1;
        this.zzg = 0;
        return false;
    }

    public final int zzi(int i, int i2) {
        zzet zzetVar;
        zzamj zzamjVarZzj = zzj();
        if (zzamjVarZzj == null) {
            return 0;
        }
        int i3 = zzamjVarZzj.zzd;
        if (i3 != 0) {
            zzetVar = this.zzb.zzn;
        } else {
            byte[] bArr = zzamjVarZzj.zze;
            String str = zzfl.zza;
            zzet zzetVar2 = this.zzl;
            int length = bArr.length;
            zzetVar2.zzb(bArr, length);
            zzetVar = zzetVar2;
            i3 = length;
        }
        zzamk zzamkVar = this.zzb;
        boolean zZzb = zzamkVar.zzb(this.zzf);
        boolean z = zZzb || i2 != 0;
        zzet zzetVar3 = this.zzk;
        zzetVar3.zzi()[0] = (byte) ((true != z ? 0 : 128) | i3);
        zzetVar3.zzh(0);
        zzahk zzahkVar = this.zza;
        zzahkVar.zzd(zzetVar3, 1, 1);
        zzahkVar.zzd(zzetVar, i3, 1);
        if (!z) {
            return i3 + 1;
        }
        if (!zZzb) {
            zzet zzetVar4 = this.zzc;
            zzetVar4.zza(8);
            byte[] bArrZzi = zzetVar4.zzi();
            bArrZzi[0] = 0;
            bArrZzi[1] = 1;
            bArrZzi[2] = 0;
            bArrZzi[3] = (byte) i2;
            bArrZzi[4] = (byte) ((i >> 24) & PHIpAddressSearchManager.END_IP_SCAN);
            bArrZzi[5] = (byte) ((i >> 16) & PHIpAddressSearchManager.END_IP_SCAN);
            bArrZzi[6] = (byte) ((i >> 8) & PHIpAddressSearchManager.END_IP_SCAN);
            bArrZzi[7] = (byte) (i & PHIpAddressSearchManager.END_IP_SCAN);
            zzahkVar.zzd(zzetVar4, 8, 1);
            return i3 + 9;
        }
        int i4 = i3 + 1;
        zzet zzetVar5 = zzamkVar.zzn;
        int iZzt = zzetVar5.zzt();
        zzetVar5.zzk(-2);
        int i5 = (iZzt * 6) + 2;
        if (i2 != 0) {
            zzet zzetVar6 = this.zzc;
            zzetVar6.zza(i5);
            byte[] bArrZzi2 = zzetVar6.zzi();
            zzetVar5.zzm(bArrZzi2, 0, i5);
            int i6 = (((bArrZzi2[2] & 255) << 8) | (bArrZzi2[3] & 255)) + i2;
            bArrZzi2[2] = (byte) ((i6 >> 8) & PHIpAddressSearchManager.END_IP_SCAN);
            bArrZzi2[3] = (byte) (i6 & PHIpAddressSearchManager.END_IP_SCAN);
            zzetVar5 = zzetVar6;
        }
        zzahkVar.zzd(zzetVar5, i5, 1);
        return i4 + i5;
    }

    public final zzamj zzj() {
        if (!this.zzm) {
            return null;
        }
        zzamk zzamkVar = this.zzb;
        zzalk zzalkVar = zzamkVar.zza;
        String str = zzfl.zza;
        int i = zzalkVar.zza;
        zzamj zzamjVarZza = zzamkVar.zzm;
        if (zzamjVarZza == null) {
            zzamjVarZza = this.zzd.zza.zza(i);
        }
        if (zzamjVarZza == null || !zzamjVarZza.zza) {
            return null;
        }
        return zzamjVarZza;
    }

    public final /* synthetic */ boolean zzk() {
        return this.zzm;
    }

    public final /* synthetic */ void zzl(boolean z) {
        this.zzm = true;
    }
}
