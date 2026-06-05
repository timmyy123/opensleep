package com.google.android.gms.internal.clearcut;

import com.google.gson.Gson$$ExternalSyntheticBUOutline0;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import java.nio.ByteBuffer;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzfj extends zzfg {
    private static int zza(byte[] bArr, int i, long j, int i2) {
        if (i2 == 0) {
            return zzff.zzam(i);
        }
        if (i2 == 1) {
            return zzff.zzp(i, zzfd.zza(bArr, j));
        }
        if (i2 == 2) {
            return zzff.zzd(i, zzfd.zza(bArr, j), zzfd.zza(bArr, j + 1));
        }
        Utf8$$ExternalSyntheticBUOutline0.m$1();
        return 0;
    }

    @Override // com.google.android.gms.internal.clearcut.zzfg
    public final void zzb(CharSequence charSequence, ByteBuffer byteBuffer) {
        long j;
        long j2;
        long j3;
        int i;
        char cCharAt;
        long jZzb = zzfd.zzb(byteBuffer);
        long jPosition = ((long) byteBuffer.position()) + jZzb;
        long jLimit = ((long) byteBuffer.limit()) + jZzb;
        int length = charSequence.length();
        if (length > jLimit - jPosition) {
            Gson$$ExternalSyntheticBUOutline0.m(37, charSequence.charAt(length - 1), byteBuffer.limit());
            return;
        }
        int i2 = 0;
        while (true) {
            j = 1;
            if (i2 >= length || (cCharAt = charSequence.charAt(i2)) >= 128) {
                break;
            }
            zzfd.zza(jPosition, (byte) cCharAt);
            i2++;
            jPosition = 1 + jPosition;
        }
        if (i2 == length) {
            byteBuffer.position((int) (jPosition - jZzb));
            return;
        }
        while (i2 < length) {
            char cCharAt2 = charSequence.charAt(i2);
            if (cCharAt2 < 128 && jPosition < jLimit) {
                zzfd.zza(jPosition, (byte) cCharAt2);
                j3 = jZzb;
                j2 = j;
                jPosition += j;
            } else if (cCharAt2 >= 2048 || jPosition > jLimit - 2) {
                j2 = j;
                if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || jPosition > jLimit - 3) {
                    j3 = jZzb;
                    if (jPosition > jLimit - 4) {
                        if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i = i2 + 1) == length || !Character.isSurrogatePair(cCharAt2, charSequence.charAt(i)))) {
                            throw new zzfi(i2, length);
                        }
                        Gson$$ExternalSyntheticBUOutline0.m(cCharAt2, jPosition);
                        return;
                    }
                    int i3 = i2 + 1;
                    if (i3 != length) {
                        char cCharAt3 = charSequence.charAt(i3);
                        if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                            int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                            zzfd.zza(jPosition, (byte) ((codePoint >>> 18) | 240));
                            zzfd.zza(jPosition + j2, (byte) (((codePoint >>> 12) & 63) | 128));
                            long j4 = jPosition + 3;
                            zzfd.zza(jPosition + 2, (byte) (((codePoint >>> 6) & 63) | 128));
                            jPosition += 4;
                            zzfd.zza(j4, (byte) ((codePoint & 63) | 128));
                            i2 = i3;
                        } else {
                            i2 = i3;
                        }
                    }
                    throw new zzfi(i2 - 1, length);
                }
                zzfd.zza(jPosition, (byte) ((cCharAt2 >>> '\f') | 480));
                long j5 = jPosition + 2;
                j3 = jZzb;
                zzfd.zza(jPosition + j2, (byte) (((cCharAt2 >>> 6) & 63) | 128));
                jPosition += 3;
                zzfd.zza(j5, (byte) ((cCharAt2 & '?') | 128));
            } else {
                j2 = j;
                long j6 = jPosition + j2;
                zzfd.zza(jPosition, (byte) ((cCharAt2 >>> 6) | 960));
                jPosition += 2;
                zzfd.zza(j6, (byte) ((cCharAt2 & '?') | 128));
                j3 = jZzb;
            }
            i2++;
            j = j2;
            jZzb = j3;
        }
        byteBuffer.position((int) (jPosition - jZzb));
    }

    @Override // com.google.android.gms.internal.clearcut.zzfg
    public final int zzb(CharSequence charSequence, byte[] bArr, int i, int i2) {
        long j;
        long j2;
        int i3;
        char cCharAt;
        long j3 = i;
        long j4 = ((long) i2) + j3;
        int length = charSequence.length();
        if (length > i2 || bArr.length - i2 < i) {
            Gson$$ExternalSyntheticBUOutline0.m(37, charSequence.charAt(length - 1), i + i2);
            return 0;
        }
        int i4 = 0;
        while (true) {
            j = 1;
            if (i4 >= length || (cCharAt = charSequence.charAt(i4)) >= 128) {
                break;
            }
            zzfd.zza(bArr, j3, (byte) cCharAt);
            i4++;
            j3 = 1 + j3;
        }
        if (i4 == length) {
            return (int) j3;
        }
        while (i4 < length) {
            char cCharAt2 = charSequence.charAt(i4);
            if (cCharAt2 < 128 && j3 < j4) {
                zzfd.zza(bArr, j3, (byte) cCharAt2);
                j2 = j;
                j3 += j;
            } else if (cCharAt2 >= 2048 || j3 > j4 - 2) {
                j2 = j;
                if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || j3 > j4 - 3) {
                    if (j3 > j4 - 4) {
                        if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i3 = i4 + 1) == length || !Character.isSurrogatePair(cCharAt2, charSequence.charAt(i3)))) {
                            throw new zzfi(i4, length);
                        }
                        Gson$$ExternalSyntheticBUOutline0.m(cCharAt2, j3);
                        return 0;
                    }
                    int i5 = i4 + 1;
                    if (i5 != length) {
                        char cCharAt3 = charSequence.charAt(i5);
                        if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                            int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                            zzfd.zza(bArr, j3, (byte) ((codePoint >>> 18) | 240));
                            zzfd.zza(bArr, j3 + j2, (byte) (((codePoint >>> 12) & 63) | 128));
                            long j5 = j3 + 3;
                            zzfd.zza(bArr, 2 + j3, (byte) (((codePoint >>> 6) & 63) | 128));
                            j3 += 4;
                            zzfd.zza(bArr, j5, (byte) ((codePoint & 63) | 128));
                            i4 = i5;
                        } else {
                            i4 = i5;
                        }
                    }
                    throw new zzfi(i4 - 1, length);
                }
                zzfd.zza(bArr, j3, (byte) ((cCharAt2 >>> '\f') | 480));
                long j6 = 2 + j3;
                zzfd.zza(bArr, j3 + j2, (byte) (((cCharAt2 >>> 6) & 63) | 128));
                j3 += 3;
                zzfd.zza(bArr, j6, (byte) ((cCharAt2 & '?') | 128));
            } else {
                j2 = j;
                long j7 = j3 + j2;
                zzfd.zza(bArr, j3, (byte) ((cCharAt2 >>> 6) | 960));
                j3 += 2;
                zzfd.zza(bArr, j7, (byte) ((cCharAt2 & '?') | 128));
            }
            i4++;
            j = j2;
        }
        return (int) j3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0065, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0097, code lost:
    
        return -1;
     */
    @Override // com.google.android.gms.internal.clearcut.zzfg
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int zzb(int i, byte[] bArr, int i2, int i3) {
        int i4;
        long j;
        if ((i2 | i3 | (bArr.length - i3)) < 0) {
            Home$$ExternalSyntheticBUOutline0.m$1("Array length=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)});
            return 0;
        }
        long j2 = i2;
        int i5 = (int) (((long) i3) - j2);
        long j3 = 1;
        if (i5 >= 16) {
            i4 = 0;
            long j4 = j2;
            while (true) {
                if (i4 >= i5) {
                    i4 = i5;
                    break;
                }
                long j5 = j4 + 1;
                if (zzfd.zza(bArr, j4) < 0) {
                    break;
                }
                i4++;
                j4 = j5;
            }
        } else {
            i4 = 0;
        }
        int i6 = i5 - i4;
        long j6 = j2 + ((long) i4);
        while (true) {
            byte b = 0;
            while (true) {
                if (i6 <= 0) {
                    break;
                }
                long j7 = j6 + j3;
                byte bZza = zzfd.zza(bArr, j6);
                if (bZza < 0) {
                    b = bZza;
                    j6 = j7;
                    break;
                }
                i6--;
                b = bZza;
                j6 = j7;
            }
            if (i6 == 0) {
                return 0;
            }
            int i7 = i6 - 1;
            if (b >= -32) {
                if (b >= -16) {
                    j = j3;
                    if (i7 < 3) {
                        return zza(bArr, b, j6, i7);
                    }
                    i6 -= 4;
                    long j8 = j6 + j;
                    byte bZza2 = zzfd.zza(bArr, j6);
                    if (bZza2 > -65) {
                        break;
                    }
                    if ((((bZza2 + 112) + (b << 28)) >> 30) != 0) {
                        break;
                    }
                    long j9 = 2 + j6;
                    if (zzfd.zza(bArr, j8) > -65) {
                        break;
                    }
                    j6 += 3;
                    if (zzfd.zza(bArr, j9) > -65) {
                        break;
                    }
                } else {
                    if (i7 < 2) {
                        return zza(bArr, b, j6, i7);
                    }
                    i6 -= 3;
                    j = j3;
                    long j10 = j6 + j;
                    byte bZza3 = zzfd.zza(bArr, j6);
                    if (bZza3 > -65 || ((b == -32 && bZza3 < -96) || (b == -19 && bZza3 >= -96))) {
                        break;
                    }
                    j6 += 2;
                    if (zzfd.zza(bArr, j10) > -65) {
                        break;
                    }
                }
            } else if (i7 != 0) {
                i6 -= 2;
                if (b < -62) {
                    break;
                }
                long j11 = j6 + j3;
                if (zzfd.zza(bArr, j6) > -65) {
                    break;
                }
                j6 = j11;
                j = j3;
            } else {
                return b;
            }
            j3 = j;
        }
        return -1;
    }
}
