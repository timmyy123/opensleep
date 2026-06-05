package com.google.android.gms.internal.ads;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhe {
    public static int zza(int i) {
        int i2 = 0;
        while (i > 0) {
            i >>>= 1;
            i2++;
        }
        return i2;
    }

    public static zzhb zzb(zzet zzetVar, boolean z, boolean z2) throws zzat {
        if (z) {
            zzc(3, zzetVar, false);
        }
        String strZzK = zzetVar.zzK((int) zzetVar.zzA(), StandardCharsets.UTF_8);
        int length = strZzK.length();
        long jZzA = zzetVar.zzA();
        String[] strArr = new String[(int) jZzA];
        int length2 = length + 15;
        for (int i = 0; i < jZzA; i++) {
            String strZzK2 = zzetVar.zzK((int) zzetVar.zzA(), StandardCharsets.UTF_8);
            strArr[i] = strZzK2;
            length2 = length2 + 4 + strZzK2.length();
        }
        if (z2 && (zzetVar.zzs() & 1) == 0) {
            throw zzat.zzb("framing bit expected to be set", null);
        }
        return new zzhb(strZzK, strArr, length2 + 1);
    }

    public static boolean zzc(int i, zzet zzetVar, boolean z) throws zzat {
        if (zzetVar.zzd() < 7) {
            if (z) {
                return false;
            }
            int iZzd = zzetVar.zzd();
            StringBuilder sb = new StringBuilder(String.valueOf(iZzd).length() + 18);
            sb.append("too short header: ");
            sb.append(iZzd);
            throw zzat.zzb(sb.toString(), null);
        }
        if (zzetVar.zzs() != i) {
            if (z) {
                return false;
            }
            throw zzat.zzb("expected header type ".concat(String.valueOf(Integer.toHexString(i))), null);
        }
        if (zzetVar.zzs() == 118 && zzetVar.zzs() == 111 && zzetVar.zzs() == 114 && zzetVar.zzs() == 98 && zzetVar.zzs() == 105 && zzetVar.zzs() == 115) {
            return true;
        }
        if (z) {
            return false;
        }
        throw zzat.zzb("expected characters 'vorbis'", null);
    }
}
