package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzgym extends zzgwp {
    static final zzgwp zza = new zzgym(null, new Object[0], 0);
    final transient Object[] zzb;
    private final transient Object zzc;
    private final transient int zzd;

    private zzgym(Object obj, Object[] objArr, int i) {
        this.zzc = obj;
        this.zzb = objArr;
        this.zzd = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01b1  */
    /* JADX WARN: Type inference failed for: r16v11 */
    /* JADX WARN: Type inference failed for: r16v12 */
    /* JADX WARN: Type inference failed for: r16v13 */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r3v32 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.lang.Object[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzgym zzk(int i, Object[] objArr, zzgwo zzgwoVar) {
        boolean z;
        int i2;
        char c;
        ?? r3;
        char c2;
        short[] sArr;
        boolean z2;
        int i3;
        ?? r16;
        boolean z3;
        boolean z4;
        int i4 = i;
        Object[] objArrCopyOf = objArr;
        if (i4 == 0) {
            return (zzgym) zza;
        }
        zzgwn zzgwnVar = null;
        ?? r32 = 0;
        zzgwn zzgwnVar2 = null;
        zzgwn zzgwnVar3 = null;
        boolean z5 = false;
        int i5 = 1;
        if (i4 == 1) {
            Object obj = objArrCopyOf[0];
            Objects.requireNonNull(obj);
            Object obj2 = objArrCopyOf[1];
            Objects.requireNonNull(obj2);
            zzgvi.zza(obj, obj2);
            return new zzgym(null, objArrCopyOf, 1);
        }
        zzgtj.zzn(i4, objArrCopyOf.length >> 1, "index");
        int iZzo = zzgww.zzo(i4);
        char c3 = 2;
        if (i4 != 1) {
            int i6 = iZzo - 1;
            if (iZzo <= 128) {
                byte[] bArr = new byte[iZzo];
                Arrays.fill(bArr, (byte) -1);
                int i7 = 0;
                int i8 = 0;
                while (i7 < i4) {
                    int i9 = i8 + i8;
                    int i10 = i7 + i7;
                    Object obj3 = objArrCopyOf[i10];
                    Objects.requireNonNull(obj3);
                    Object obj4 = objArrCopyOf[i10 ^ i5];
                    Objects.requireNonNull(obj4);
                    zzgvi.zza(obj3, obj4);
                    int iZza = zzgwf.zza(obj3.hashCode());
                    while (true) {
                        int i11 = iZza & i6;
                        z2 = z5;
                        i3 = i5;
                        int i12 = bArr[i11] & 255;
                        if (i12 == 255) {
                            bArr[i11] = (byte) i9;
                            if (i8 < i7) {
                                objArrCopyOf[i9] = obj3;
                                objArrCopyOf[i9 ^ 1] = obj4;
                            }
                            i8++;
                        } else {
                            if (obj3.equals(objArrCopyOf[i12 == true ? 1 : 0])) {
                                int i13 = ~i12;
                                Object obj5 = objArrCopyOf[i13 == true ? 1 : 0];
                                Objects.requireNonNull(obj5);
                                zzgwn zzgwnVar4 = new zzgwn(obj3, obj4, obj5);
                                objArrCopyOf[i13 == true ? 1 : 0] = obj4;
                                zzgwnVar2 = zzgwnVar4;
                                break;
                            }
                            iZza = i11 + 1;
                            z5 = z2;
                            i5 = i3;
                        }
                    }
                    i7++;
                    z5 = z2;
                    i5 = i3;
                }
                z = z5;
                i2 = i5;
                if (i8 == i4) {
                    r32 = bArr;
                    z4 = z;
                } else {
                    sArr = new Object[3];
                    sArr[z ? 1 : 0] = bArr;
                    sArr[i2] = Integer.valueOf(i8);
                    sArr[2] = zzgwnVar2;
                    r32 = sArr;
                    z4 = z;
                }
            } else {
                z = false;
                i2 = 1;
                if (iZzo <= 32768) {
                    sArr = new short[iZzo];
                    Arrays.fill(sArr, (short) -1);
                    int i14 = 0;
                    for (int i15 = 0; i15 < i4; i15++) {
                        int i16 = i14 + i14;
                        int i17 = i15 + i15;
                        Object obj6 = objArrCopyOf[i17];
                        Objects.requireNonNull(obj6);
                        Object obj7 = objArrCopyOf[i17 ^ 1];
                        Objects.requireNonNull(obj7);
                        zzgvi.zza(obj6, obj7);
                        int iZza2 = zzgwf.zza(obj6.hashCode());
                        while (true) {
                            int i18 = iZza2 & i6;
                            char c4 = (char) sArr[i18];
                            if (c4 == 65535) {
                                sArr[i18] = (short) i16;
                                if (i14 < i15) {
                                    objArrCopyOf[i16] = obj6;
                                    objArrCopyOf[i16 ^ 1] = obj7;
                                }
                                i14++;
                            } else {
                                if (obj6.equals(objArrCopyOf[c4])) {
                                    int i19 = c4 ^ 1;
                                    Object obj8 = objArrCopyOf[i19 == true ? 1 : 0];
                                    Objects.requireNonNull(obj8);
                                    zzgwn zzgwnVar5 = new zzgwn(obj6, obj7, obj8);
                                    objArrCopyOf[i19 == true ? 1 : 0] = obj7;
                                    zzgwnVar3 = zzgwnVar5;
                                    break;
                                }
                                iZza2 = i18 + 1;
                            }
                        }
                    }
                    if (i14 == i4) {
                        r32 = sArr;
                        z4 = z;
                    } else {
                        r32 = new Object[]{sArr, Integer.valueOf(i14), zzgwnVar3};
                        z4 = z;
                    }
                } else {
                    int[] iArr = new int[iZzo];
                    Arrays.fill(iArr, -1);
                    int i20 = 0;
                    int i21 = 0;
                    while (i20 < i4) {
                        int i22 = i21 + i21;
                        int i23 = i20 + i20;
                        Object obj9 = objArrCopyOf[i23];
                        Objects.requireNonNull(obj9);
                        Object obj10 = objArrCopyOf[i23 ^ 1];
                        Objects.requireNonNull(obj10);
                        zzgvi.zza(obj9, obj10);
                        int iZza3 = zzgwf.zza(obj9.hashCode());
                        while (true) {
                            int i24 = iZza3 & i6;
                            int i25 = iArr[i24];
                            if (i25 == -1) {
                                iArr[i24] = i22;
                                if (i21 < i20) {
                                    objArrCopyOf[i22] = obj9;
                                    objArrCopyOf[i22 ^ 1] = obj10;
                                }
                                i21++;
                                c2 = c3;
                            } else {
                                c2 = c3;
                                if (obj9.equals(objArrCopyOf[i25])) {
                                    int i26 = i25 ^ 1;
                                    Object obj11 = objArrCopyOf[i26];
                                    Objects.requireNonNull(obj11);
                                    zzgwn zzgwnVar6 = new zzgwn(obj9, obj10, obj11);
                                    objArrCopyOf[i26] = obj10;
                                    zzgwnVar = zzgwnVar6;
                                    break;
                                }
                                iZza3 = i24 + 1;
                                c3 = c2;
                            }
                        }
                        i20++;
                        c3 = c2;
                    }
                    c = c3;
                    if (i21 == i4) {
                        r3 = iArr;
                        r16 = z;
                    } else {
                        Object[] objArr2 = new Object[3];
                        objArr2[0] = iArr;
                        objArr2[1] = Integer.valueOf(i21);
                        objArr2[c] = zzgwnVar;
                        r3 = objArr2;
                        r16 = z;
                    }
                }
            }
            z3 = r3 instanceof Object[];
            ?? r33 = r3;
            if (z3) {
                Object[] objArr3 = (Object[]) r3;
                zzgwn zzgwnVar7 = (zzgwn) objArr3[c];
                if (zzgwoVar == null) {
                    throw zzgwnVar7.zza();
                }
                zzgwoVar.zzc = zzgwnVar7;
                Object obj12 = objArr3[r16];
                int iIntValue = ((Integer) objArr3[i2]).intValue();
                objArrCopyOf = Arrays.copyOf(objArrCopyOf, iIntValue + iIntValue);
                r33 = obj12;
                i4 = iIntValue;
            }
            return new zzgym(r33, objArrCopyOf, i4);
        }
        Object obj13 = objArrCopyOf[0];
        Objects.requireNonNull(obj13);
        Object obj14 = objArrCopyOf[1];
        Objects.requireNonNull(obj14);
        zzgvi.zza(obj13, obj14);
        z4 = false;
        i4 = 1;
        i2 = 1;
        c = 2;
        r3 = r32;
        r16 = z4;
        z3 = r3 instanceof Object[];
        ?? r332 = r3;
        if (z3) {
        }
        return new zzgym(r332, objArrCopyOf, i4);
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0003  */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0003 A[EDGE_INSN: B:44:0x0003->B:4:0x0003 BREAK  A[LOOP:0: B:16:0x0038->B:22:0x004e], EDGE_INSN: B:46:0x0003->B:4:0x0003 BREAK  A[LOOP:1: B:26:0x0063->B:32:0x007a], EDGE_INSN: B:48:0x0003->B:4:0x0003 BREAK  A[LOOP:2: B:34:0x0089->B:43:0x00a0]] */
    @Override // com.google.android.gms.internal.ads.zzgwp, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object get(Object obj) {
        Object obj2;
        if (obj == null) {
            obj2 = null;
        } else {
            int i = this.zzd;
            Object[] objArr = this.zzb;
            if (i == 1) {
                Object obj3 = objArr[0];
                Objects.requireNonNull(obj3);
                if (obj3.equals(obj)) {
                    obj2 = objArr[1];
                    Objects.requireNonNull(obj2);
                }
            } else {
                Object obj4 = this.zzc;
                if (obj4 != null) {
                    if (obj4 instanceof byte[]) {
                        byte[] bArr = (byte[]) obj4;
                        int length = bArr.length - 1;
                        int iZza = zzgwf.zza(obj.hashCode());
                        while (true) {
                            int i2 = iZza & length;
                            int i3 = bArr[i2] & 255;
                            if (i3 == 255) {
                                break;
                            }
                            if (obj.equals(objArr[i3])) {
                                obj2 = objArr[i3 ^ 1];
                                break;
                            }
                            iZza = i2 + 1;
                        }
                    } else if (obj4 instanceof short[]) {
                        short[] sArr = (short[]) obj4;
                        int length2 = sArr.length - 1;
                        int iZza2 = zzgwf.zza(obj.hashCode());
                        while (true) {
                            int i4 = iZza2 & length2;
                            char c = (char) sArr[i4];
                            if (c == 65535) {
                                break;
                            }
                            if (obj.equals(objArr[c])) {
                                obj2 = objArr[c ^ 1];
                                break;
                            }
                            iZza2 = i4 + 1;
                        }
                    } else {
                        int[] iArr = (int[]) obj4;
                        int length3 = iArr.length - 1;
                        int iZza3 = zzgwf.zza(obj.hashCode());
                        while (true) {
                            int i5 = iZza3 & length3;
                            int i6 = iArr[i5];
                            if (i6 == -1) {
                                break;
                            }
                            if (obj.equals(objArr[i6])) {
                                obj2 = objArr[i6 ^ 1];
                                break;
                            }
                            iZza3 = i5 + 1;
                        }
                    }
                }
            }
        }
        if (obj2 == null) {
            return null;
        }
        return obj2;
    }

    @Override // java.util.Map
    public final int size() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgwp
    public final zzgww zze() {
        return new zzgyj(this, this.zzb, 0, this.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzgwp
    public final zzgww zzg() {
        return new zzgyk(this, new zzgyl(this.zzb, 0, this.zzd));
    }

    @Override // com.google.android.gms.internal.ads.zzgwp
    public final zzgwi zzi() {
        return new zzgyl(this.zzb, 1, this.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzgwp
    public final boolean zzj() {
        return false;
    }
}
