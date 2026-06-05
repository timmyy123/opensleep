package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
final class zzhzj extends zzhzi {
    private static final int[] zzc = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    private int zzd;
    private final int[] zze;

    public zzhzj(int i, byte[] bArr) {
        this.zza = bArr;
        this.zze = zzc;
        this.zzd = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x00f1, code lost:
    
        if (r2 == 1) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00f3, code lost:
    
        if (r2 == 2) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00f5, code lost:
    
        if (r2 == 3) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00f7, code lost:
    
        if (r2 == 4) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00fa, code lost:
    
        r1 = r9 + 1;
        r5[r9] = (byte) (r8 >> 10);
        r9 = r9 + 2;
        r5[r1] = (byte) (r8 >> 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0109, code lost:
    
        r5[r9] = (byte) (r8 >> 4);
        r9 = r9 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0111, code lost:
    
        r17.zzd = r2;
        r17.zzb = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0115, code lost:
    
        return true;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21, types: [int] */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zza(byte[] bArr, int i, int i2, boolean z) {
        boolean z2;
        ?? r2;
        ?? r22;
        int i3 = this.zzd;
        boolean z3 = false;
        if (i3 == 6) {
            return false;
        }
        byte[] bArr2 = this.zza;
        int[] iArr = this.zze;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        ?? r23 = i3;
        while (true) {
            if (i4 >= i2) {
                z2 = z3;
                r2 = r23;
                break;
            }
            if (r23 != 0) {
                z2 = z3;
                r22 = r23;
            } else {
                while (true) {
                    int i7 = i4 + 4;
                    if (i7 > i2) {
                        z2 = z3;
                        break;
                    }
                    z2 = z3;
                    i5 = (iArr[bArr[i4] & 255] << 18) | (iArr[bArr[i4 + 1] & 255] << 12) | (iArr[bArr[i4 + 2] & 255] << 6) | iArr[bArr[i4 + 3] & 255];
                    if (i5 < 0) {
                        break;
                    }
                    bArr2[i6 + 2] = (byte) i5;
                    bArr2[i6 + 1] = (byte) (i5 >> 8);
                    bArr2[i6] = (byte) (i5 >> 16);
                    i6 += 3;
                    z3 = z2;
                    i4 = i7;
                }
                if (i4 >= i2) {
                    r2 = z2;
                    break;
                }
                r22 = z2;
            }
            int i8 = i4 + 1;
            int i9 = iArr[bArr[i4] & 255];
            if (r22 != 0) {
                if (r22 == 1) {
                    if (i9 < 0) {
                        if (i9 != -1) {
                            break;
                        }
                    }
                    i9 |= i5 << 6;
                    r22++;
                } else if (r22 == 2) {
                    if (i9 < 0) {
                        if (i9 == -2) {
                            bArr2[i6] = (byte) (i5 >> 4);
                            i6++;
                            r22 = 4;
                        } else if (i9 != -1) {
                            break;
                        }
                    }
                    i9 |= i5 << 6;
                    r22++;
                } else if (r22 != 3) {
                    if (r22 != 4) {
                        if (r22 == 5 && i9 != -1) {
                            break;
                        }
                    } else if (i9 == -2) {
                        r22++;
                    } else if (i9 != -1) {
                        break;
                    }
                } else if (i9 >= 0) {
                    i9 |= i5 << 6;
                    bArr2[i6 + 2] = (byte) i9;
                    bArr2[i6 + 1] = (byte) (i9 >> 8);
                    bArr2[i6] = (byte) (i9 >> 16);
                    i6 += 3;
                    r22 = z2;
                } else if (i9 == -2) {
                    bArr2[i6 + 1] = (byte) (i5 >> 2);
                    bArr2[i6] = (byte) (i5 >> 10);
                    i6 += 2;
                    r22 = 5;
                } else if (i9 != -1) {
                    break;
                }
                i5 = i9;
            } else if (i9 >= 0) {
                r22++;
                i5 = i9;
            } else if (i9 != -1) {
                break;
            }
            i4 = i8;
            z3 = z2;
            r23 = r22;
        }
        this.zzd = 6;
        return z2;
    }
}
