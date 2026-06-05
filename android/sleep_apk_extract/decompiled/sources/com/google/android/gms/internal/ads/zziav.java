package com.google.android.gms.internal.ads;

import java.security.KeyFactory;
import java.security.NoSuchProviderException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zziav implements zzhek {
    static final zzhli zza;
    private static final byte[] zzb;
    private static final byte[] zzc;

    static {
        zzhlh zzhlhVarZza = zzhli.zza();
        zzhlhVarZza.zza(zziai.SHA256, zzhww.zza);
        zzhlhVarZza.zza(zziai.SHA384, zzhww.zzb);
        zzhlhVarZza.zza(zziai.SHA512, zzhww.zzc);
        zza = zzhlhVarZza.zzb();
        zzb = new byte[0];
        zzc = new byte[]{0};
    }

    public static zzhek zzb(zzhxc zzhxcVar) {
        try {
            return zzhyw.zze(zzhxcVar);
        } catch (NoSuchProviderException unused) {
            RSAPublicKey rSAPublicKey = (RSAPublicKey) ((KeyFactory) zzhzz.zzf.zzb("RSA")).generatePublic(new RSAPublicKeySpec(zzhxcVar.zzd(), zzhxcVar.zzf().zzd()));
            zzhwy zzhwyVarZzf = zzhxcVar.zzf();
            zzhli zzhliVar = zza;
            return new zziau(rSAPublicKey, (zziai) zzhliVar.zzb(zzhwyVarZzf.zzf()), (zziai) zzhliVar.zzb(zzhwyVarZzf.zzg()), zzhwyVarZzf.zzh(), zzhxcVar.zze().zzc(), zzhxcVar.zzf().zze().equals(zzhwx.zzc) ? zzc : zzb, null);
        }
    }
}
