package com.google.android.gms.internal.ads;

import java.io.EOFException;

/* JADX INFO: loaded from: classes3.dex */
public final class zzagt {
    private final zzet zza = new zzet(10);

    private final boolean zzb(zzafz zzafzVar, int i) {
        int i2;
        int i3 = 0;
        do {
            int i4 = i3 % 10;
            if (i4 == 0) {
                if (i3 != 0) {
                    zzet zzetVar = this.zza;
                    System.arraycopy(zzetVar.zzi(), 10, zzetVar.zzi(), 0, 9);
                }
                i2 = 0;
            } else {
                i2 = i4;
            }
            int i5 = i3 != 0 ? 1 : 10;
            try {
                zzet zzetVar2 = this.zza;
                int i6 = i4 + 10;
                zzafzVar.zzi(zzetVar2.zzi(), i6 - i5, i5);
                zzetVar2.zzh(i2);
                zzetVar2.zzf(i6);
                if (zzetVar2.zzq() == 4801587) {
                    return true;
                }
                if (zzagw.zza(zzetVar2.zzr()) != -1) {
                    return false;
                }
                if (i3 == 0) {
                    zzetVar2.zzc(20);
                }
                i3++;
            } catch (EOFException unused) {
            }
        } while (i3 <= i);
        return false;
    }

    public final zzap zza(zzafz zzafzVar, zzajk zzajkVar, int i) {
        zzap zzapVarZza = null;
        int i2 = 0;
        while (zzb(zzafzVar, i)) {
            zzet zzetVar = this.zza;
            int iZzg = zzetVar.zzg();
            zzetVar.zzk(6);
            int iZzG = zzetVar.zzG();
            int i3 = iZzG + 10;
            if (zzapVarZza == null) {
                byte[] bArr = new byte[i3];
                System.arraycopy(zzetVar.zzi(), iZzg, bArr, 0, 10);
                zzafzVar.zzi(bArr, 10, iZzG);
                zzapVarZza = zzajn.zza(bArr, i3, zzajkVar, new zzaiy());
            } else {
                zzafzVar.zzk(iZzG);
            }
            i2 += i3;
        }
        zzafzVar.zzl();
        zzafzVar.zzk(i2);
        return zzapVarZza;
    }
}
