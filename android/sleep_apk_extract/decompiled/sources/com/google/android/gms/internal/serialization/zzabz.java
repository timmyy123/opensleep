package com.google.android.gms.internal.serialization;

import com.google.gson.Gson$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzabz {
    public static /* synthetic */ boolean zza(byte b) {
        return b >= 0;
    }

    public static /* synthetic */ boolean zzb(byte b) {
        return b < -32;
    }

    public static /* synthetic */ boolean zzc(byte b) {
        return b < -16;
    }

    public static /* synthetic */ void zzd(byte b, byte b2, char[] cArr, int i) throws zzzv {
        if (b < -62 || zzg(b2)) {
            Gson$$ExternalSyntheticBUOutline0.m("Protocol message had invalid UTF-8.");
        } else {
            cArr[i] = (char) (((b & 31) << 6) | (b2 & 63));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0013  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0016 A[PHI: r2
      0x0016: PHI (r2v3 byte) = (r2v2 byte), (r2v9 byte) binds: [B:9:0x0011, B:11:0x0015] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ void zze(byte b, byte b2, byte b3, char[] cArr, int i) throws zzzv {
        if (!zzg(b2)) {
            if (b != -32) {
                if (b != -19) {
                    if (!zzg(b3)) {
                        cArr[i] = (char) (((b & 15) << 12) | ((b2 & 63) << 6) | (b3 & 63));
                        return;
                    }
                } else if (b2 < -96) {
                    b = -19;
                    if (!zzg(b3)) {
                    }
                }
            } else if (b2 >= -96) {
                b = -32;
                if (b != -19) {
                }
            }
        }
        Gson$$ExternalSyntheticBUOutline0.m("Protocol message had invalid UTF-8.");
    }

    public static /* synthetic */ void zzf(byte b, byte b2, byte b3, byte b4, char[] cArr, int i) throws zzzv {
        if (!zzg(b2)) {
            if ((((b2 + 112) + (b << 28)) >> 30) == 0 && !zzg(b3) && !zzg(b4)) {
                int i2 = ((b & 7) << 18) | ((b2 & 63) << 12) | ((b3 & 63) << 6) | (b4 & 63);
                cArr[i] = (char) ((i2 >>> 10) + 55232);
                cArr[i + 1] = (char) ((i2 & 1023) + 56320);
                return;
            }
        }
        Gson$$ExternalSyntheticBUOutline0.m("Protocol message had invalid UTF-8.");
    }

    private static boolean zzg(byte b) {
        return b > -65;
    }
}
