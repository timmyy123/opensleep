package com.google.android.gms.internal.ads;

import java.util.Arrays;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes3.dex */
public final class zziap implements zzheg {
    private static final byte[] zza = {0};
    private final zzhqd zzb;
    private final int zzc;
    private final byte[] zzd;
    private final byte[] zze;

    private zziap(zzhom zzhomVar) {
        String strValueOf = String.valueOf(zzhomVar.zzf().zzg());
        this.zzb = new zziao("HMAC".concat(strValueOf), new SecretKeySpec(zzhomVar.zzd().zzc(zzhdo.zza()), "HMAC"));
        this.zzc = zzhomVar.zzf().zzd();
        this.zzd = zzhomVar.zze().zzc();
        if (zzhomVar.zzf().zzf().equals(zzhou.zzc)) {
            this.zze = Arrays.copyOf(zza, 1);
        } else {
            this.zze = new byte[0];
        }
    }

    public static zzheg zza(zzhob zzhobVar) {
        return new zziap(zzhobVar);
    }

    public static zzheg zzb(zzhom zzhomVar) {
        return new zziap(zzhomVar);
    }

    public final byte[] zzc(byte[] bArr) {
        byte[] bArr2 = this.zze;
        int length = bArr2.length;
        byte[] bArr3 = this.zzd;
        return length > 0 ? zzhzl.zza(bArr3, this.zzb.zza(zzhzl.zza(bArr, bArr2), this.zzc)) : zzhzl.zza(bArr3, this.zzb.zza(bArr, this.zzc));
    }

    private zziap(zzhob zzhobVar) {
        this.zzb = zziam.zzb(zzhqb.zzc(zzhqc.zzb(zzhobVar.zzf().zzc()), zzhobVar.zzd()));
        this.zzc = zzhobVar.zzf().zzd();
        this.zzd = zzhobVar.zze().zzc();
        if (zzhobVar.zzf().zzf().equals(zzhoh.zzc)) {
            this.zze = Arrays.copyOf(zza, 1);
        } else {
            this.zze = new byte[0];
        }
    }

    public zziap(zzhqd zzhqdVar, int i) {
        this.zzb = zzhqdVar;
        this.zzc = i;
        this.zzd = new byte[0];
        this.zze = new byte[0];
        zzhqdVar.zza(new byte[0], i);
    }
}
