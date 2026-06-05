package com.google.android.gms.internal.ads;

import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import java.lang.reflect.Array;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzhle {
    static final long[] zza;
    static final long[] zzb;
    static final long[] zzc;
    static final zzhkx[][] zzd;
    static final zzhkx[] zze;
    private static final BigInteger zzf;
    private static final BigInteger zzg;
    private static final BigInteger zzh;
    private static final BigInteger zzi;

    static {
        BigInteger bigIntegerSubtract = BigInteger.valueOf(2L).pow(PHIpAddressSearchManager.END_IP_SCAN).subtract(BigInteger.valueOf(19L));
        zzf = bigIntegerSubtract;
        BigInteger bigIntegerMod = BigInteger.valueOf(-121665L).multiply(BigInteger.valueOf(121666L).modInverse(bigIntegerSubtract)).mod(bigIntegerSubtract);
        zzg = bigIntegerMod;
        BigInteger bigIntegerMod2 = BigInteger.valueOf(2L).multiply(bigIntegerMod).mod(bigIntegerSubtract);
        zzh = bigIntegerMod2;
        BigInteger bigIntegerValueOf = BigInteger.valueOf(2L);
        BigInteger bigInteger = BigInteger.ONE;
        BigInteger bigIntegerModPow = bigIntegerValueOf.modPow(bigIntegerSubtract.subtract(bigInteger).divide(BigInteger.valueOf(4L)), bigIntegerSubtract);
        zzi = bigIntegerModPow;
        zzhld zzhldVar = new zzhld(null);
        zzhldVar.zzd(BigInteger.valueOf(4L).multiply(BigInteger.valueOf(5L).modInverse(bigIntegerSubtract)).mod(bigIntegerSubtract));
        BigInteger bigIntegerZzc = zzhldVar.zzc();
        BigInteger bigIntegerMultiply = bigIntegerZzc.pow(2).subtract(bigInteger).multiply(bigIntegerMod.multiply(bigIntegerZzc.pow(2)).add(bigInteger).modInverse(bigIntegerSubtract));
        BigInteger bigIntegerModPow2 = bigIntegerMultiply.modPow(bigIntegerSubtract.add(BigInteger.valueOf(3L)).divide(BigInteger.valueOf(8L)), bigIntegerSubtract);
        if (!bigIntegerModPow2.pow(2).subtract(bigIntegerMultiply).mod(bigIntegerSubtract).equals(BigInteger.ZERO)) {
            bigIntegerModPow2 = bigIntegerModPow2.multiply(bigIntegerModPow).mod(bigIntegerSubtract);
        }
        if (bigIntegerModPow2.testBit(0)) {
            bigIntegerModPow2 = bigIntegerSubtract.subtract(bigIntegerModPow2);
        }
        zzhldVar.zzb(bigIntegerModPow2);
        zza = zzhlj.zzg(zzb(bigIntegerMod));
        zzb = zzhlj.zzg(zzb(bigIntegerMod2));
        zzc = zzhlj.zzg(zzb(bigIntegerModPow));
        zzd = (zzhkx[][]) Array.newInstance((Class<?>) zzhkx.class, 32, 8);
        zzhld zzhldVarZza = zzhldVar;
        for (int i = 0; i < 32; i++) {
            zzhld zzhldVarZza2 = zzhldVarZza;
            for (int i2 = 0; i2 < 8; i2++) {
                zzd[i][i2] = zzc(zzhldVarZza2);
                zzhldVarZza2 = zza(zzhldVarZza2, zzhldVarZza);
            }
            for (int i3 = 0; i3 < 8; i3++) {
                zzhldVarZza = zza(zzhldVarZza, zzhldVarZza);
            }
        }
        zzhld zzhldVarZza3 = zza(zzhldVar, zzhldVar);
        zze = new zzhkx[8];
        for (int i4 = 0; i4 < 8; i4++) {
            zze[i4] = zzc(zzhldVar);
            zzhldVar = zza(zzhldVar, zzhldVarZza3);
        }
    }

    private static zzhld zza(zzhld zzhldVar, zzhld zzhldVar2) {
        zzhld zzhldVar3 = new zzhld(null);
        BigInteger bigIntegerMultiply = zzg.multiply(zzhldVar.zza().multiply(zzhldVar2.zza()).multiply(zzhldVar.zzc()).multiply(zzhldVar2.zzc()));
        BigInteger bigInteger = zzf;
        BigInteger bigIntegerMod = bigIntegerMultiply.mod(bigInteger);
        BigInteger bigIntegerAdd = zzhldVar.zza().multiply(zzhldVar2.zzc()).add(zzhldVar2.zza().multiply(zzhldVar.zzc()));
        BigInteger bigInteger2 = BigInteger.ONE;
        zzhldVar3.zzb(bigIntegerAdd.multiply(bigInteger2.add(bigIntegerMod).modInverse(bigInteger)).mod(bigInteger));
        zzhldVar3.zzd(zzhldVar.zzc().multiply(zzhldVar2.zzc()).add(zzhldVar.zza().multiply(zzhldVar2.zza())).multiply(bigInteger2.subtract(bigIntegerMod).modInverse(bigInteger)).mod(bigInteger));
        return zzhldVar3;
    }

    private static byte[] zzb(BigInteger bigInteger) {
        byte[] bArr = new byte[32];
        byte[] byteArray = bigInteger.toByteArray();
        int length = byteArray.length;
        System.arraycopy(byteArray, 0, bArr, 32 - length, length);
        for (int i = 0; i < 16; i++) {
            byte b = bArr[i];
            int i2 = 31 - i;
            bArr[i] = bArr[i2];
            bArr[i2] = b;
        }
        return bArr;
    }

    private static zzhkx zzc(zzhld zzhldVar) {
        BigInteger bigIntegerAdd = zzhldVar.zzc().add(zzhldVar.zza());
        BigInteger bigInteger = zzf;
        return new zzhkx(zzhlj.zzg(zzb(bigIntegerAdd.mod(bigInteger))), zzhlj.zzg(zzb(zzhldVar.zzc().subtract(zzhldVar.zza()).mod(bigInteger))), zzhlj.zzg(zzb(zzh.multiply(zzhldVar.zza()).multiply(zzhldVar.zzc()).mod(bigInteger))));
    }
}
