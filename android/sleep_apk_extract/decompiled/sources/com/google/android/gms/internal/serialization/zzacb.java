package com.google.android.gms.internal.serialization;

import com.google.gson.Gson$$ExternalSyntheticBUOutline0;
import com.google.home.Home$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzacb extends zzaca {
    @Override // com.google.android.gms.internal.serialization.zzaca
    public final String zza(byte[] bArr, int i, int i2) throws zzzv {
        int i3;
        int length = bArr.length;
        if ((((length - i) - i2) | i | i2) < 0) {
            Home$$ExternalSyntheticBUOutline0.m$1("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(length), Integer.valueOf(i), Integer.valueOf(i2)});
            return null;
        }
        int i4 = i + i2;
        char[] cArr = new char[i2];
        int i5 = 0;
        while (i < i4) {
            byte b = bArr[i];
            if (!zzabz.zza(b)) {
                break;
            }
            i++;
            cArr[i5] = (char) b;
            i5++;
        }
        int i6 = i5;
        while (i < i4) {
            int i7 = i + 1;
            byte b2 = bArr[i];
            if (zzabz.zza(b2)) {
                cArr[i6] = (char) b2;
                i6++;
                i = i7;
                while (i < i4) {
                    byte b3 = bArr[i];
                    if (zzabz.zza(b3)) {
                        i++;
                        cArr[i6] = (char) b3;
                        i6++;
                    }
                }
            } else {
                if (zzabz.zzb(b2)) {
                    if (i7 >= i4) {
                        Gson$$ExternalSyntheticBUOutline0.m("Protocol message had invalid UTF-8.");
                        return null;
                    }
                    i3 = i6 + 1;
                    i += 2;
                    zzabz.zzd(b2, bArr[i7], cArr, i6);
                } else if (zzabz.zzc(b2)) {
                    if (i7 >= i4 - 1) {
                        Gson$$ExternalSyntheticBUOutline0.m("Protocol message had invalid UTF-8.");
                        return null;
                    }
                    i3 = i6 + 1;
                    int i8 = i + 2;
                    i += 3;
                    zzabz.zze(b2, bArr[i7], bArr[i8], cArr, i6);
                } else {
                    if (i7 >= i4 - 2) {
                        Gson$$ExternalSyntheticBUOutline0.m("Protocol message had invalid UTF-8.");
                        return null;
                    }
                    byte b4 = bArr[i7];
                    int i9 = i + 3;
                    byte b5 = bArr[i + 2];
                    i += 4;
                    zzabz.zzf(b2, b4, b5, bArr[i9], cArr, i6);
                    i6 += 2;
                }
                i6 = i3;
            }
        }
        return new String(cArr, 0, i6);
    }
}
