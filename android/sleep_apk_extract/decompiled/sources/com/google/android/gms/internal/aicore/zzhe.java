package com.google.android.gms.internal.aicore;

import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzhe {
    public static final /* synthetic */ int $r8$clinit = 0;

    static {
        if (zzhc.zza() && zzhc.zzb()) {
            int i = zzdq.$r8$clinit;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0076 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x007a A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean zza(byte[] bArr, int i, int i2) {
        while (i < i2 && bArr[i] >= 0) {
            i++;
        }
        if (i >= i2) {
            return true;
        }
        while (i < i2) {
            int i3 = i + 1;
            int iZzb = bArr[i];
            if (iZzb >= 0) {
                i = i3;
            } else if (iZzb < -32) {
                if (i3 >= i2) {
                    return iZzb == 0;
                }
                if (iZzb < -62) {
                    return false;
                }
                i += 2;
                if (bArr[i3] > -65) {
                    return false;
                }
            } else if (iZzb < -16) {
                if (i3 >= i2 - 1) {
                    iZzb = zzb(bArr, i3, i2);
                    if (iZzb == 0) {
                    }
                } else {
                    int i4 = i + 2;
                    char c = bArr[i3];
                    if (c > -65) {
                        return false;
                    }
                    if (iZzb == -32 && c < -96) {
                        return false;
                    }
                    if (iZzb == -19 && c >= -96) {
                        return false;
                    }
                    i += 3;
                    if (bArr[i4] > -65) {
                        return false;
                    }
                }
            } else if (i3 >= i2 - 2) {
                iZzb = zzb(bArr, i3, i2);
                if (iZzb == 0) {
                }
            } else {
                int i5 = i + 2;
                int i6 = bArr[i3];
                if (i6 > -65) {
                    return false;
                }
                if ((((i6 + 112) + (iZzb << 28)) >> 30) != 0) {
                    return false;
                }
                int i7 = i + 3;
                if (bArr[i5] > -65) {
                    return false;
                }
                i += 4;
                if (bArr[i7] > -65) {
                    return false;
                }
            }
        }
        return true;
    }

    public static /* synthetic */ int zzb(byte[] bArr, int i, int i2) {
        int i3 = i2 - i;
        byte b = bArr[i - 1];
        if (i3 == 0) {
            if (b <= -12) {
                return b;
            }
            return -1;
        }
        if (i3 == 1) {
            byte b2 = bArr[i];
            if (b > -12 || b2 > -65) {
                return -1;
            }
            return (b2 << 8) ^ b;
        }
        if (i3 != 2) {
            Utf8$$ExternalSyntheticBUOutline0.m$1();
            return 0;
        }
        byte b3 = bArr[i];
        byte b4 = bArr[i + 1];
        if (b > -12 || b3 > -65 || b4 > -65) {
            return -1;
        }
        return (b4 << 16) ^ ((b3 << 8) ^ b);
    }
}
