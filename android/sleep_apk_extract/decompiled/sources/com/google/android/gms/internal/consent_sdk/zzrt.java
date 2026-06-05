package com.google.android.gms.internal.consent_sdk;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.google.android.gms.internal.ads.zzbuy$$ExternalSyntheticBUOutline0;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes3.dex */
final class zzrt<T> implements zzsa<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzsw.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final zzrq zze;
    private final boolean zzf = false;
    private final int[] zzg;
    private final int zzh;
    private final zzsp zzi;
    private final zzqb zzj;

    private zzrt(int[] iArr, Object[] objArr, int i, int i2, zzrq zzrqVar, boolean z, int[] iArr2, int i3, int i4, zzrv zzrvVar, zzrc zzrcVar, zzsp zzspVar, zzqb zzqbVar, zzrl zzrlVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzg = iArr2;
        this.zzh = i3;
        this.zzi = zzspVar;
        this.zzj = zzqbVar;
        this.zze = zzrqVar;
    }

    private static boolean zzA(Object obj, int i, zzsa zzsaVar) {
        return zzsaVar.zzh(zzsw.zzf(obj, i & 1048575));
    }

    private static boolean zzB(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzqm) {
            return ((zzqm) obj).zzD();
        }
        return true;
    }

    private final boolean zzC(Object obj, int i, int i2) {
        return zzsw.zzc(obj, (long) (zzm(i2) & 1048575)) == i;
    }

    private static boolean zzD(Object obj, long j) {
        return ((Boolean) zzsw.zzf(obj, j)).booleanValue();
    }

    private static final void zzE(int i, Object obj, zztb zztbVar) {
        if (obj instanceof String) {
            zztbVar.zzF(i, (String) obj);
        } else {
            zztbVar.zzd(i, (zzpm) obj);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:187:0x03c3  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x03e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzrt zzi(Class cls, zzrn zzrnVar, zzrv zzrvVar, zzrc zzrcVar, zzsp zzspVar, zzqb zzqbVar, zzrl zzrlVar) {
        int i;
        int iCharAt;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int[] iArr;
        int i7;
        int i8;
        char cCharAt;
        int i9;
        char cCharAt2;
        int i10;
        char cCharAt3;
        int i11;
        char cCharAt4;
        int i12;
        char cCharAt5;
        int i13;
        char cCharAt6;
        int i14;
        char cCharAt7;
        int i15;
        char cCharAt8;
        int i16;
        zzrz zzrzVar;
        int i17;
        Object[] objArr;
        int i18;
        int i19;
        int i20;
        int iObjectFieldOffset;
        int iObjectFieldOffset2;
        int i21;
        char c;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        Field fieldZzs;
        char cCharAt9;
        int i28;
        int i29;
        int i30;
        int i31;
        int i32;
        Field fieldZzs2;
        Field fieldZzs3;
        int i33;
        char cCharAt10;
        int i34;
        int i35;
        char cCharAt11;
        int i36;
        char cCharAt12;
        int i37;
        char cCharAt13;
        if (!(zzrnVar instanceof zzrz)) {
            zzrnVar.getClass();
            Events$$ExternalSyntheticBUOutline0.m();
            return null;
        }
        zzrz zzrzVar2 = (zzrz) zzrnVar;
        String strZzd = zzrzVar2.zzd();
        int length = strZzd.length();
        char c2 = 55296;
        if (strZzd.charAt(0) >= 55296) {
            int i38 = 1;
            while (true) {
                i = i38 + 1;
                if (strZzd.charAt(i38) < 55296) {
                    break;
                }
                i38 = i;
            }
        } else {
            i = 1;
        }
        int i39 = i + 1;
        int iCharAt2 = strZzd.charAt(i);
        if (iCharAt2 >= 55296) {
            int i40 = iCharAt2 & 8191;
            int i41 = 13;
            while (true) {
                i37 = i39 + 1;
                cCharAt13 = strZzd.charAt(i39);
                if (cCharAt13 < 55296) {
                    break;
                }
                i40 |= (cCharAt13 & 8191) << i41;
                i41 += 13;
                i39 = i37;
            }
            iCharAt2 = i40 | (cCharAt13 << i41);
            i39 = i37;
        }
        if (iCharAt2 == 0) {
            i3 = 0;
            i6 = 0;
            iCharAt = 0;
            i2 = 0;
            i4 = 0;
            i5 = 0;
            iArr = zza;
            i7 = 0;
        } else {
            int i42 = i39 + 1;
            int iCharAt3 = strZzd.charAt(i39);
            if (iCharAt3 >= 55296) {
                int i43 = iCharAt3 & 8191;
                int i44 = 13;
                while (true) {
                    i15 = i42 + 1;
                    cCharAt8 = strZzd.charAt(i42);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i43 |= (cCharAt8 & 8191) << i44;
                    i44 += 13;
                    i42 = i15;
                }
                iCharAt3 = i43 | (cCharAt8 << i44);
                i42 = i15;
            }
            int i45 = i42 + 1;
            int iCharAt4 = strZzd.charAt(i42);
            if (iCharAt4 >= 55296) {
                int i46 = iCharAt4 & 8191;
                int i47 = 13;
                while (true) {
                    i14 = i45 + 1;
                    cCharAt7 = strZzd.charAt(i45);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i46 |= (cCharAt7 & 8191) << i47;
                    i47 += 13;
                    i45 = i14;
                }
                iCharAt4 = i46 | (cCharAt7 << i47);
                i45 = i14;
            }
            int i48 = i45 + 1;
            int iCharAt5 = strZzd.charAt(i45);
            if (iCharAt5 >= 55296) {
                int i49 = iCharAt5 & 8191;
                int i50 = 13;
                while (true) {
                    i13 = i48 + 1;
                    cCharAt6 = strZzd.charAt(i48);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i49 |= (cCharAt6 & 8191) << i50;
                    i50 += 13;
                    i48 = i13;
                }
                iCharAt5 = i49 | (cCharAt6 << i50);
                i48 = i13;
            }
            int i51 = i48 + 1;
            int iCharAt6 = strZzd.charAt(i48);
            if (iCharAt6 >= 55296) {
                int i52 = iCharAt6 & 8191;
                int i53 = 13;
                while (true) {
                    i12 = i51 + 1;
                    cCharAt5 = strZzd.charAt(i51);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i52 |= (cCharAt5 & 8191) << i53;
                    i53 += 13;
                    i51 = i12;
                }
                iCharAt6 = i52 | (cCharAt5 << i53);
                i51 = i12;
            }
            int i54 = i51 + 1;
            iCharAt = strZzd.charAt(i51);
            if (iCharAt >= 55296) {
                int i55 = iCharAt & 8191;
                int i56 = 13;
                while (true) {
                    i11 = i54 + 1;
                    cCharAt4 = strZzd.charAt(i54);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i55 |= (cCharAt4 & 8191) << i56;
                    i56 += 13;
                    i54 = i11;
                }
                iCharAt = i55 | (cCharAt4 << i56);
                i54 = i11;
            }
            int i57 = i54 + 1;
            int iCharAt7 = strZzd.charAt(i54);
            if (iCharAt7 >= 55296) {
                int i58 = iCharAt7 & 8191;
                int i59 = 13;
                while (true) {
                    i10 = i57 + 1;
                    cCharAt3 = strZzd.charAt(i57);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i58 |= (cCharAt3 & 8191) << i59;
                    i59 += 13;
                    i57 = i10;
                }
                iCharAt7 = i58 | (cCharAt3 << i59);
                i57 = i10;
            }
            int i60 = i57 + 1;
            int iCharAt8 = strZzd.charAt(i57);
            if (iCharAt8 >= 55296) {
                int i61 = iCharAt8 & 8191;
                int i62 = 13;
                while (true) {
                    i9 = i60 + 1;
                    cCharAt2 = strZzd.charAt(i60);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i61 |= (cCharAt2 & 8191) << i62;
                    i62 += 13;
                    i60 = i9;
                }
                iCharAt8 = i61 | (cCharAt2 << i62);
                i60 = i9;
            }
            int i63 = i60 + 1;
            int iCharAt9 = strZzd.charAt(i60);
            if (iCharAt9 >= 55296) {
                int i64 = iCharAt9 & 8191;
                int i65 = 13;
                while (true) {
                    i8 = i63 + 1;
                    cCharAt = strZzd.charAt(i63);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i64 |= (cCharAt & 8191) << i65;
                    i65 += 13;
                    i63 = i8;
                }
                iCharAt9 = i64 | (cCharAt << i65);
                i63 = i8;
            }
            int i66 = iCharAt3 + iCharAt3 + iCharAt4;
            int[] iArr2 = new int[iCharAt9 + iCharAt7 + iCharAt8];
            int i67 = iCharAt7;
            i2 = iCharAt5;
            i3 = i67;
            i4 = iCharAt6;
            i5 = iCharAt9;
            i6 = i66;
            iArr = iArr2;
            i7 = iCharAt3;
            i39 = i63;
        }
        Unsafe unsafe = zzb;
        Object[] objArrZze = zzrzVar2.zze();
        Class<?> cls2 = zzrzVar2.zza().getClass();
        int i68 = i5 + i3;
        int i69 = iCharAt + iCharAt;
        int[] iArr3 = new int[iCharAt * 3];
        Object[] objArr2 = new Object[i69];
        int i70 = i5;
        int i71 = i68;
        int i72 = 0;
        int i73 = 0;
        while (i39 < length) {
            int i74 = i39 + 1;
            int iCharAt10 = strZzd.charAt(i39);
            if (iCharAt10 >= c2) {
                int i75 = iCharAt10 & 8191;
                int i76 = i74;
                int i77 = 13;
                while (true) {
                    i36 = i76 + 1;
                    cCharAt12 = strZzd.charAt(i76);
                    if (cCharAt12 < c2) {
                        break;
                    }
                    i75 |= (cCharAt12 & 8191) << i77;
                    i77 += 13;
                    i76 = i36;
                }
                iCharAt10 = i75 | (cCharAt12 << i77);
                i16 = i36;
            } else {
                i16 = i74;
            }
            int i78 = i16 + 1;
            int iCharAt11 = strZzd.charAt(i16);
            if (iCharAt11 >= c2) {
                int i79 = iCharAt11 & 8191;
                int i80 = i78;
                int i81 = 13;
                while (true) {
                    i35 = i80 + 1;
                    cCharAt11 = strZzd.charAt(i80);
                    zzrzVar = zzrzVar2;
                    if (cCharAt11 < 55296) {
                        break;
                    }
                    i79 |= (cCharAt11 & 8191) << i81;
                    i81 += 13;
                    i80 = i35;
                    zzrzVar2 = zzrzVar;
                }
                iCharAt11 = i79 | (cCharAt11 << i81);
                i17 = i35;
            } else {
                zzrzVar = zzrzVar2;
                i17 = i78;
            }
            if ((iCharAt11 & 1024) != 0) {
                iArr[i73] = i72;
                i73++;
            }
            int i82 = iCharAt11 & PHIpAddressSearchManager.END_IP_SCAN;
            int i83 = length;
            int i84 = iCharAt11 & 2048;
            if (i82 >= 51) {
                int i85 = i17 + 1;
                int iCharAt12 = strZzd.charAt(i17);
                if (iCharAt12 >= 55296) {
                    int i86 = iCharAt12 & 8191;
                    int i87 = i85;
                    int i88 = 13;
                    while (true) {
                        i33 = i87 + 1;
                        cCharAt10 = strZzd.charAt(i87);
                        i34 = i86;
                        if (cCharAt10 < 55296) {
                            break;
                        }
                        i86 = i34 | ((cCharAt10 & 8191) << i88);
                        i88 += 13;
                        i87 = i33;
                    }
                    iCharAt12 = i34 | (cCharAt10 << i88);
                    i31 = i33;
                } else {
                    i31 = i85;
                }
                int i89 = iCharAt12;
                int i90 = i82 - 51;
                int i91 = i31;
                if (i90 == 9 || i90 == 17) {
                    objArr2[zzba$$ExternalSyntheticOutline0.m$1(i72, 3, 1)] = objArrZze[i6];
                    i32 = i84;
                    i6++;
                } else if (i90 != 12) {
                    i32 = i84;
                } else if (zzrzVar.zzc() == 1 || i84 != 0) {
                    objArr2[zzba$$ExternalSyntheticOutline0.m$1(i72, 3, 1)] = objArrZze[i6];
                    i6++;
                    i32 = i84;
                } else {
                    i32 = 0;
                }
                int i92 = i89 + i89;
                Object obj = objArrZze[i92];
                int i93 = i32;
                if (obj instanceof Field) {
                    fieldZzs2 = (Field) obj;
                } else {
                    fieldZzs2 = zzs(cls2, (String) obj);
                    objArrZze[i92] = fieldZzs2;
                }
                Object[] objArr3 = objArr2;
                int i94 = i6;
                int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZzs2);
                int i95 = i92 + 1;
                Object obj2 = objArrZze[i95];
                if (obj2 instanceof Field) {
                    fieldZzs3 = (Field) obj2;
                } else {
                    fieldZzs3 = zzs(cls2, (String) obj2);
                    objArrZze[i95] = fieldZzs3;
                }
                int iObjectFieldOffset4 = (int) unsafe.objectFieldOffset(fieldZzs3);
                i19 = i7;
                i26 = i94;
                i20 = i72;
                c = 55296;
                iObjectFieldOffset2 = iObjectFieldOffset4;
                i25 = iObjectFieldOffset3;
                i84 = i93;
                i18 = iCharAt10;
                i39 = i91;
                objArr = objArr3;
                i24 = 0;
            } else {
                Object[] objArr4 = objArr2;
                int i96 = i6 + 1;
                objArr = objArr4;
                Field fieldZzs4 = zzs(cls2, (String) objArrZze[i6]);
                i18 = iCharAt10;
                if (i82 == 9 || i82 == 17) {
                    i19 = i7;
                    objArr[zzba$$ExternalSyntheticOutline0.m$1(i72, 3, 1)] = fieldZzs4.getType();
                } else {
                    if (i82 == 27) {
                        i19 = i7;
                        i28 = 3;
                        i29 = 1;
                        i30 = i6 + 2;
                    } else if (i82 == 49) {
                        i30 = i6 + 2;
                        i19 = i7;
                        i28 = 3;
                        i29 = 1;
                    } else {
                        if (i82 == 12 || i82 == 30 || i82 == 44) {
                            i19 = i7;
                            if (zzrzVar.zzc() == 1 || i84 != 0) {
                                i30 = i6 + 2;
                                objArr[zzba$$ExternalSyntheticOutline0.m$1(i72, 3, 1)] = objArrZze[i96];
                                i96 = i30;
                            } else {
                                i20 = i72;
                                i84 = 0;
                            }
                        } else if (i82 == 50) {
                            int i97 = i6 + 2;
                            int i98 = i70 + 1;
                            iArr[i70] = i72;
                            int i99 = i72 / 3;
                            int i100 = i99 + i99;
                            objArr[i100] = objArrZze[i96];
                            if (i84 != 0) {
                                i96 = i6 + 3;
                                objArr[i100 + 1] = objArrZze[i97];
                                i20 = i72;
                                i70 = i98;
                            } else {
                                i96 = i97;
                                i20 = i72;
                                i70 = i98;
                                i84 = 0;
                            }
                            i19 = i7;
                        } else {
                            i19 = i7;
                        }
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzs4);
                        iObjectFieldOffset2 = 1048575;
                        if ((iCharAt11 & 4096) != 0 || i82 > 17) {
                            i21 = i96;
                            c = 55296;
                            i22 = i17;
                            i23 = 0;
                        } else {
                            int i101 = i17 + 1;
                            int iCharAt13 = strZzd.charAt(i17);
                            if (iCharAt13 >= 55296) {
                                int i102 = iCharAt13 & 8191;
                                int i103 = 13;
                                while (true) {
                                    i27 = i101 + 1;
                                    cCharAt9 = strZzd.charAt(i101);
                                    if (cCharAt9 < 55296) {
                                        break;
                                    }
                                    i102 |= (cCharAt9 & 8191) << i103;
                                    i103 += 13;
                                    i101 = i27;
                                }
                                iCharAt13 = i102 | (cCharAt9 << i103);
                            } else {
                                i27 = i101;
                            }
                            int i104 = (iCharAt13 / 32) + i19 + i19;
                            Object obj3 = objArrZze[i104];
                            if (obj3 instanceof Field) {
                                fieldZzs = (Field) obj3;
                            } else {
                                fieldZzs = zzs(cls2, (String) obj3);
                                objArrZze[i104] = fieldZzs;
                            }
                            i21 = i96;
                            i23 = iCharAt13 % 32;
                            iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzs);
                            i22 = i27;
                            c = 55296;
                        }
                        if (i82 >= 18 || i82 > 49) {
                            i24 = i23;
                            i25 = iObjectFieldOffset;
                            int i105 = i22;
                            i26 = i21;
                            i39 = i105;
                        } else {
                            int i106 = i71 + 1;
                            iArr[i71] = iObjectFieldOffset;
                            i24 = i23;
                            i25 = iObjectFieldOffset;
                            int i107 = i22;
                            i26 = i21;
                            i39 = i107;
                            i71 = i106;
                        }
                    }
                    objArr[zzba$$ExternalSyntheticOutline0.m$1(i72, i28, i29)] = objArrZze[i96];
                    i96 = i30;
                }
                i20 = i72;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzs4);
                iObjectFieldOffset2 = 1048575;
                if ((iCharAt11 & 4096) != 0) {
                    i21 = i96;
                    c = 55296;
                    i22 = i17;
                    i23 = 0;
                    if (i82 >= 18) {
                        i24 = i23;
                        i25 = iObjectFieldOffset;
                        int i1052 = i22;
                        i26 = i21;
                        i39 = i1052;
                    }
                }
            }
            int i108 = i20 + 1;
            iArr3[i20] = i18;
            int i109 = i20 + 2;
            iArr3[i108] = ((iCharAt11 & 512) != 0 ? 536870912 : 0) | ((iCharAt11 & 256) != 0 ? ClientDefaults.MAX_MSG_SIZE : 0) | (i84 != 0 ? Integer.MIN_VALUE : 0) | (i82 << 20) | i25;
            iArr3[i109] = (i24 << 20) | iObjectFieldOffset2;
            i72 = i20 + 3;
            i6 = i26;
            length = i83;
            c2 = c;
            zzrzVar2 = zzrzVar;
            i7 = i19;
            objArr2 = objArr;
        }
        return new zzrt(iArr3, objArr2, i2, i4, zzrzVar2.zza(), false, iArr, i5, i68, zzrvVar, zzrcVar, zzspVar, zzqbVar, zzrlVar);
    }

    private static double zzj(Object obj, long j) {
        return ((Double) zzsw.zzf(obj, j)).doubleValue();
    }

    private static float zzk(Object obj, long j) {
        return ((Float) zzsw.zzf(obj, j)).floatValue();
    }

    private static int zzl(Object obj, long j) {
        return ((Integer) zzsw.zzf(obj, j)).intValue();
    }

    private final int zzm(int i) {
        return this.zzc[i + 2];
    }

    private static int zzn(int i) {
        return (i >>> 20) & PHIpAddressSearchManager.END_IP_SCAN;
    }

    private final int zzo(int i) {
        return this.zzc[i + 1];
    }

    private static long zzp(Object obj, long j) {
        return ((Long) zzsw.zzf(obj, j)).longValue();
    }

    private final zzsa zzq(int i) {
        Object[] objArr = this.zzd;
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzsa zzsaVar = (zzsa) objArr[i3];
        if (zzsaVar != null) {
            return zzsaVar;
        }
        zzsa zzsaVarZzb = zzrx.zza().zzb((Class) objArr[i3 + 1]);
        objArr[i3] = zzsaVarZzb;
        return zzsaVarZzb;
    }

    private final Object zzr(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private static Field zzs(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String string = Arrays.toString(declaredFields);
            StringBuilder sbM6m = FileInsert$$ExternalSyntheticOutline0.m6m("Field ", str, " for ", name, " not found. Known fields are ");
            sbM6m.append(string);
            throw new RuntimeException(sbM6m.toString(), e);
        }
    }

    private final void zzt(Object obj, Object obj2, int i) {
        if (zzy(obj2, i)) {
            int iZzo = zzo(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzo;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                zzbuy$$ExternalSyntheticBUOutline0.m(this.zzc[i], obj2);
                return;
            }
            zzsa zzsaVarZzq = zzq(i);
            if (!zzy(obj, i)) {
                if (zzB(object)) {
                    Object objZzc = zzsaVarZzq.zzc();
                    zzsaVarZzq.zze(objZzc, object);
                    unsafe.putObject(obj, j, objZzc);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzv(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzB(object2)) {
                Object objZzc2 = zzsaVarZzq.zzc();
                zzsaVarZzq.zze(objZzc2, object2);
                unsafe.putObject(obj, j, objZzc2);
                object2 = objZzc2;
            }
            zzsaVarZzq.zze(object2, object);
        }
    }

    private final void zzu(Object obj, Object obj2, int i) {
        int[] iArr = this.zzc;
        int i2 = iArr[i];
        if (zzC(obj2, i2, i)) {
            int iZzo = zzo(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzo;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                zzbuy$$ExternalSyntheticBUOutline0.m(iArr[i], obj2);
                return;
            }
            zzsa zzsaVarZzq = zzq(i);
            if (!zzC(obj, i2, i)) {
                if (zzB(object)) {
                    Object objZzc = zzsaVarZzq.zzc();
                    zzsaVarZzq.zze(objZzc, object);
                    unsafe.putObject(obj, j, objZzc);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzw(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzB(object2)) {
                Object objZzc2 = zzsaVarZzq.zzc();
                zzsaVarZzq.zze(objZzc2, object2);
                unsafe.putObject(obj, j, objZzc2);
                object2 = objZzc2;
            }
            zzsaVarZzq.zze(object2, object);
        }
    }

    private final void zzv(Object obj, int i) {
        int iZzm = zzm(i);
        long j = 1048575 & iZzm;
        if (j == 1048575) {
            return;
        }
        zzsw.zzq(obj, j, (1 << (iZzm >>> 20)) | zzsw.zzc(obj, j));
    }

    private final void zzw(Object obj, int i, int i2) {
        zzsw.zzq(obj, zzm(i2) & 1048575, i);
    }

    private final boolean zzx(Object obj, Object obj2, int i) {
        return zzy(obj, i) == zzy(obj2, i);
    }

    private final boolean zzy(Object obj, int i) {
        int iZzm = zzm(i);
        long j = iZzm & 1048575;
        if (j != 1048575) {
            return ((1 << (iZzm >>> 20)) & zzsw.zzc(obj, j)) != 0;
        }
        int iZzo = zzo(i);
        long j2 = iZzo & 1048575;
        switch (zzn(iZzo)) {
            case 0:
                return Double.doubleToRawLongBits(zzsw.zza(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzsw.zzb(obj, j2)) != 0;
            case 2:
                return zzsw.zzd(obj, j2) != 0;
            case 3:
                return zzsw.zzd(obj, j2) != 0;
            case 4:
                return zzsw.zzc(obj, j2) != 0;
            case 5:
                return zzsw.zzd(obj, j2) != 0;
            case 6:
                return zzsw.zzc(obj, j2) != 0;
            case 7:
                return zzsw.zzw(obj, j2);
            case 8:
                Object objZzf = zzsw.zzf(obj, j2);
                if (objZzf instanceof String) {
                    return !((String) objZzf).isEmpty();
                }
                if (objZzf instanceof zzpm) {
                    return !zzpm.zzb.equals(objZzf);
                }
                Utf8$$ExternalSyntheticBUOutline0.m$3();
                return false;
            case 9:
                return zzsw.zzf(obj, j2) != null;
            case 10:
                return !zzpm.zzb.equals(zzsw.zzf(obj, j2));
            case 11:
                return zzsw.zzc(obj, j2) != 0;
            case 12:
                return zzsw.zzc(obj, j2) != 0;
            case 13:
                return zzsw.zzc(obj, j2) != 0;
            case 14:
                return zzsw.zzd(obj, j2) != 0;
            case 15:
                return zzsw.zzc(obj, j2) != 0;
            case 16:
                return zzsw.zzd(obj, j2) != 0;
            case 17:
                return zzsw.zzf(obj, j2) != null;
            default:
                Utf8$$ExternalSyntheticBUOutline0.m$3();
                return false;
        }
    }

    private final boolean zzz(Object obj, int i, int i2, int i3, int i4) {
        return i2 == 1048575 ? zzy(obj, i) : (i3 & i4) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:191:0x04dc  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01e4  */
    @Override // com.google.android.gms.internal.consent_sdk.zzsa
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int zza(Object obj) {
        int i;
        int iZzC;
        int iZzD;
        int iZzC2;
        int iZzd;
        int iZzC3;
        int iZzi;
        int size;
        int iZzm;
        int iZzC4;
        int iZzC5;
        int iZzC6;
        int iZzC7;
        int iZzf;
        int iZzC8;
        int iZzC9;
        int iZza;
        int iZzC10;
        int iZzD2;
        zzrt<T> zzrtVar = this;
        Object obj2 = obj;
        Unsafe unsafe = zzb;
        int i2 = 1048575;
        int i3 = 0;
        int i4 = 0;
        int iM = 0;
        int i5 = 1048575;
        while (true) {
            int[] iArr = zzrtVar.zzc;
            if (i3 >= iArr.length) {
                int iZza2 = ((zzqm) obj).zzc.zza() + iM;
                if (zzrtVar.zzf) {
                    throw FileInsert$$ExternalSyntheticOutline0.m(obj);
                }
                return iZza2;
            }
            int iZzo = zzrtVar.zzo(i3);
            int iZzn = zzn(iZzo);
            int i6 = iArr[i3];
            int i7 = iArr[i3 + 2];
            int i8 = i7 & i2;
            if (iZzn <= 17) {
                if (i8 != i5) {
                    i4 = i8 == i2 ? 0 : unsafe.getInt(obj2, i8);
                    i5 = i8;
                }
                i = 1 << (i7 >>> 20);
            } else {
                i = 0;
            }
            int i9 = iZzo & i2;
            if (iZzn >= zzqg.zzJ.zza()) {
                zzqg.zzW.zza();
            }
            long j = i9;
            switch (iZzn) {
                case 0:
                    if (zzrtVar.zzz(obj2, i3, i5, i4, i)) {
                        iM = zza$$ExternalSyntheticOutline0.m(i6 << 3, 8, iM);
                    }
                    break;
                case 1:
                    if (zzrtVar.zzz(obj2, i3, i5, i4, i)) {
                        iM = zza$$ExternalSyntheticOutline0.m(i6 << 3, 4, iM);
                    }
                    zzrtVar = this;
                    break;
                case 2:
                    if (zzrtVar.zzz(obj2, i3, i5, i4, i)) {
                        long j2 = unsafe.getLong(obj2, j);
                        iZzC = zzpv.zzC(i6 << 3);
                        iZzD = zzpv.zzD(j2);
                        iM += iZzD + iZzC;
                    }
                    zzrtVar = this;
                    break;
                case 3:
                    if (zzrtVar.zzz(obj2, i3, i5, i4, i)) {
                        long j3 = unsafe.getLong(obj2, j);
                        iZzC = zzpv.zzC(i6 << 3);
                        iZzD = zzpv.zzD(j3);
                        iM += iZzD + iZzC;
                    }
                    zzrtVar = this;
                    break;
                case 4:
                    if (zzrtVar.zzz(obj2, i3, i5, i4, i)) {
                        long j4 = unsafe.getInt(obj2, j);
                        iZzC = zzpv.zzC(i6 << 3);
                        iZzD = zzpv.zzD(j4);
                        iM += iZzD + iZzC;
                    }
                    zzrtVar = this;
                    break;
                case 5:
                    if (zzrtVar.zzz(obj2, i3, i5, i4, i)) {
                        iM = zza$$ExternalSyntheticOutline0.m(i6 << 3, 8, iM);
                    }
                    zzrtVar = this;
                    break;
                case 6:
                    if (zzrtVar.zzz(obj2, i3, i5, i4, i)) {
                        iM = zza$$ExternalSyntheticOutline0.m(i6 << 3, 4, iM);
                    }
                    zzrtVar = this;
                    break;
                case 7:
                    if (zzrtVar.zzz(obj2, i3, i5, i4, i)) {
                        iM = zza$$ExternalSyntheticOutline0.m(i6 << 3, 1, iM);
                    }
                    zzrtVar = this;
                    break;
                case 8:
                    if (zzrtVar.zzz(obj2, i3, i5, i4, i)) {
                        int i10 = i6 << 3;
                        Object object = unsafe.getObject(obj2, j);
                        if (object instanceof zzpm) {
                            iZzC2 = zzpv.zzC(i10);
                            iZzd = ((zzpm) object).zzd();
                            iZzC3 = zzpv.zzC(iZzd);
                            iM += iZzC3 + iZzd + iZzC2;
                        } else {
                            iZzC = zzpv.zzC(i10);
                            iZzD = zzpv.zzB((String) object);
                            iM += iZzD + iZzC;
                        }
                    }
                    zzrtVar = this;
                    break;
                case 9:
                    if (zzrtVar.zzz(obj2, i3, i5, i4, i)) {
                        iZzi = zzsc.zzi(i6, unsafe.getObject(obj2, j), zzrtVar.zzq(i3));
                        iM += iZzi;
                    }
                    break;
                case 10:
                    if (zzrtVar.zzz(obj2, i3, i5, i4, i)) {
                        zzpm zzpmVar = (zzpm) unsafe.getObject(obj2, j);
                        iZzC2 = zzpv.zzC(i6 << 3);
                        iZzd = zzpmVar.zzd();
                        iZzC3 = zzpv.zzC(iZzd);
                        iM += iZzC3 + iZzd + iZzC2;
                    }
                    zzrtVar = this;
                    break;
                case 11:
                    if (zzrtVar.zzz(obj2, i3, i5, i4, i)) {
                        iM = zza$$ExternalSyntheticOutline0.m(unsafe.getInt(obj2, j), zzpv.zzC(i6 << 3), iM);
                    }
                    zzrtVar = this;
                    break;
                case 12:
                    if (zzrtVar.zzz(obj2, i3, i5, i4, i)) {
                        long j5 = unsafe.getInt(obj2, j);
                        iZzC = zzpv.zzC(i6 << 3);
                        iZzD = zzpv.zzD(j5);
                        iM += iZzD + iZzC;
                    }
                    zzrtVar = this;
                    break;
                case 13:
                    if (zzrtVar.zzz(obj2, i3, i5, i4, i)) {
                        iM = zza$$ExternalSyntheticOutline0.m(i6 << 3, 4, iM);
                    }
                    zzrtVar = this;
                    break;
                case 14:
                    if (zzrtVar.zzz(obj2, i3, i5, i4, i)) {
                        iM = zza$$ExternalSyntheticOutline0.m(i6 << 3, 8, iM);
                    }
                    zzrtVar = this;
                    break;
                case 15:
                    if (zzrtVar.zzz(obj2, i3, i5, i4, i)) {
                        int i11 = unsafe.getInt(obj2, j);
                        iM = zza$$ExternalSyntheticOutline0.m((i11 >> 31) ^ (i11 + i11), zzpv.zzC(i6 << 3), iM);
                    }
                    zzrtVar = this;
                    break;
                case 16:
                    if (zzrtVar.zzz(obj2, i3, i5, i4, i)) {
                        long j6 = unsafe.getLong(obj2, j);
                        iZzC = zzpv.zzC(i6 << 3);
                        iZzD = zzpv.zzD((j6 >> 63) ^ (j6 + j6));
                        iM += iZzD + iZzC;
                    }
                    zzrtVar = this;
                    break;
                case 17:
                    if (zzrtVar.zzz(obj2, i3, i5, i4, i)) {
                        iZzi = zzsc.zza(i6, (zzrq) unsafe.getObject(obj2, j), zzrtVar.zzq(i3));
                        iM += iZzi;
                    }
                    break;
                case 18:
                    iZzi = zzsc.zze(i6, (List) unsafe.getObject(obj2, j), false);
                    iM += iZzi;
                    break;
                case 19:
                    iZzi = zzsc.zzc(i6, (List) unsafe.getObject(obj2, j), false);
                    iM += iZzi;
                    break;
                case 20:
                    List list = (List) unsafe.getObject(obj2, j);
                    int i12 = zzsc.$r8$clinit;
                    iZzC5 = list.size() == 0 ? 0 : (zzpv.zzC(i6 << 3) * list.size()) + zzsc.zzh(list);
                    iM += iZzC5;
                    break;
                case 21:
                    List list2 = (List) unsafe.getObject(obj2, j);
                    int i13 = zzsc.$r8$clinit;
                    size = list2.size();
                    if (size != 0) {
                        iZzm = zzsc.zzm(list2);
                        iZzC4 = zzpv.zzC(i6 << 3);
                        iZzC6 = (iZzC4 * size) + iZzm;
                        iM += iZzC6;
                    }
                    iZzC6 = 0;
                    iM += iZzC6;
                    break;
                case 22:
                    List list3 = (List) unsafe.getObject(obj2, j);
                    int i14 = zzsc.$r8$clinit;
                    size = list3.size();
                    if (size != 0) {
                        iZzm = zzsc.zzg(list3);
                        iZzC4 = zzpv.zzC(i6 << 3);
                        iZzC6 = (iZzC4 * size) + iZzm;
                        iM += iZzC6;
                    }
                    iZzC6 = 0;
                    iM += iZzC6;
                    break;
                case 23:
                    iZzi = zzsc.zze(i6, (List) unsafe.getObject(obj2, j), false);
                    iM += iZzi;
                    break;
                case 24:
                    iZzi = zzsc.zzc(i6, (List) unsafe.getObject(obj2, j), false);
                    iM += iZzi;
                    break;
                case 25:
                    List list4 = (List) unsafe.getObject(obj2, j);
                    int i15 = zzsc.$r8$clinit;
                    int size2 = list4.size();
                    if (size2 != 0) {
                        iZzC5 = (zzpv.zzC(i6 << 3) + 1) * size2;
                    }
                    iM += iZzC5;
                    break;
                case 26:
                    List list5 = (List) unsafe.getObject(obj2, j);
                    int i16 = zzsc.$r8$clinit;
                    int size3 = list5.size();
                    if (size3 == 0) {
                        iZzC6 = 0;
                    } else {
                        iZzC6 = zzpv.zzC(i6 << 3) * size3;
                        if (list5 instanceof zzrb) {
                            zzrb zzrbVar = (zzrb) list5;
                            for (int i17 = 0; i17 < size3; i17++) {
                                Object objZza = zzrbVar.zza();
                                if (objZza instanceof zzpm) {
                                    int iZzd2 = ((zzpm) objZza).zzd();
                                    iZzC6 = zza$$ExternalSyntheticOutline0.m(iZzd2, iZzd2, iZzC6);
                                } else {
                                    iZzC6 = zzpv.zzB((String) objZza) + iZzC6;
                                }
                            }
                        } else {
                            for (int i18 = 0; i18 < size3; i18++) {
                                Object obj3 = list5.get(i18);
                                if (obj3 instanceof zzpm) {
                                    int iZzd3 = ((zzpm) obj3).zzd();
                                    iZzC6 = zza$$ExternalSyntheticOutline0.m(iZzd3, iZzd3, iZzC6);
                                } else {
                                    iZzC6 = zzpv.zzB((String) obj3) + iZzC6;
                                }
                            }
                        }
                    }
                    iM += iZzC6;
                    break;
                case 27:
                    List list6 = (List) unsafe.getObject(obj2, j);
                    zzsa zzsaVarZzq = zzrtVar.zzq(i3);
                    int i19 = zzsc.$r8$clinit;
                    int size4 = list6.size();
                    if (size4 == 0) {
                        iZzC7 = 0;
                    } else {
                        iZzC7 = zzpv.zzC(i6 << 3) * size4;
                        for (int i20 = 0; i20 < size4; i20++) {
                            int iZzj = ((zzpa) list6.get(i20)).zzj(zzsaVarZzq);
                            iZzC7 = zza$$ExternalSyntheticOutline0.m(iZzj, iZzj, iZzC7);
                        }
                    }
                    iM += iZzC7;
                    break;
                case 28:
                    List list7 = (List) unsafe.getObject(obj2, j);
                    int i21 = zzsc.$r8$clinit;
                    int size5 = list7.size();
                    if (size5 != 0) {
                        iZzC6 = zzpv.zzC(i6 << 3) * size5;
                        for (int i22 = 0; i22 < list7.size(); i22++) {
                            int iZzd4 = ((zzpm) list7.get(i22)).zzd();
                            iZzC6 = zza$$ExternalSyntheticOutline0.m(iZzd4, iZzd4, iZzC6);
                        }
                    }
                    iM += iZzC6;
                    break;
                case 29:
                    List list8 = (List) unsafe.getObject(obj2, j);
                    int i23 = zzsc.$r8$clinit;
                    size = list8.size();
                    if (size != 0) {
                        iZzm = zzsc.zzl(list8);
                        iZzC4 = zzpv.zzC(i6 << 3);
                        iZzC6 = (iZzC4 * size) + iZzm;
                        iM += iZzC6;
                    }
                    iZzC6 = 0;
                    iM += iZzC6;
                    break;
                case 30:
                    List list9 = (List) unsafe.getObject(obj2, j);
                    int i24 = zzsc.$r8$clinit;
                    size = list9.size();
                    if (size != 0) {
                        iZzm = zzsc.zzb(list9);
                        iZzC4 = zzpv.zzC(i6 << 3);
                        iZzC6 = (iZzC4 * size) + iZzm;
                        iM += iZzC6;
                    }
                    iZzC6 = 0;
                    iM += iZzC6;
                    break;
                case 31:
                    iZzi = zzsc.zzc(i6, (List) unsafe.getObject(obj2, j), false);
                    iM += iZzi;
                    break;
                case 32:
                    iZzi = zzsc.zze(i6, (List) unsafe.getObject(obj2, j), false);
                    iM += iZzi;
                    break;
                case 33:
                    List list10 = (List) unsafe.getObject(obj2, j);
                    int i25 = zzsc.$r8$clinit;
                    size = list10.size();
                    if (size != 0) {
                        iZzm = zzsc.zzj(list10);
                        iZzC4 = zzpv.zzC(i6 << 3);
                        iZzC6 = (iZzC4 * size) + iZzm;
                        iM += iZzC6;
                    }
                    iZzC6 = 0;
                    iM += iZzC6;
                    break;
                case 34:
                    List list11 = (List) unsafe.getObject(obj2, j);
                    int i26 = zzsc.$r8$clinit;
                    size = list11.size();
                    if (size != 0) {
                        iZzm = zzsc.zzk(list11);
                        iZzC4 = zzpv.zzC(i6 << 3);
                        iZzC6 = (iZzC4 * size) + iZzm;
                        iM += iZzC6;
                    }
                    iZzC6 = 0;
                    iM += iZzC6;
                    break;
                case 35:
                    iZzf = zzsc.zzf((List) unsafe.getObject(obj2, j));
                    if (iZzf > 0) {
                        iZzC8 = zzpv.zzC(i6 << 3);
                        iZzC9 = zzpv.zzC(iZzf);
                        iM += iZzC9 + iZzC8 + iZzf;
                    }
                    break;
                case 36:
                    iZzf = zzsc.zzd((List) unsafe.getObject(obj2, j));
                    if (iZzf > 0) {
                        iZzC8 = zzpv.zzC(i6 << 3);
                        iZzC9 = zzpv.zzC(iZzf);
                        iM += iZzC9 + iZzC8 + iZzf;
                    }
                    break;
                case 37:
                    iZzf = zzsc.zzh((List) unsafe.getObject(obj2, j));
                    if (iZzf > 0) {
                        iZzC8 = zzpv.zzC(i6 << 3);
                        iZzC9 = zzpv.zzC(iZzf);
                        iM += iZzC9 + iZzC8 + iZzf;
                    }
                    break;
                case 38:
                    iZzf = zzsc.zzm((List) unsafe.getObject(obj2, j));
                    if (iZzf > 0) {
                        iZzC8 = zzpv.zzC(i6 << 3);
                        iZzC9 = zzpv.zzC(iZzf);
                        iM += iZzC9 + iZzC8 + iZzf;
                    }
                    break;
                case 39:
                    iZzf = zzsc.zzg((List) unsafe.getObject(obj2, j));
                    if (iZzf > 0) {
                        iZzC8 = zzpv.zzC(i6 << 3);
                        iZzC9 = zzpv.zzC(iZzf);
                        iM += iZzC9 + iZzC8 + iZzf;
                    }
                    break;
                case 40:
                    iZzf = zzsc.zzf((List) unsafe.getObject(obj2, j));
                    if (iZzf > 0) {
                        iZzC8 = zzpv.zzC(i6 << 3);
                        iZzC9 = zzpv.zzC(iZzf);
                        iM += iZzC9 + iZzC8 + iZzf;
                    }
                    break;
                case 41:
                    iZzf = zzsc.zzd((List) unsafe.getObject(obj2, j));
                    if (iZzf > 0) {
                        iZzC8 = zzpv.zzC(i6 << 3);
                        iZzC9 = zzpv.zzC(iZzf);
                        iM += iZzC9 + iZzC8 + iZzf;
                    }
                    break;
                case 42:
                    List list12 = (List) unsafe.getObject(obj2, j);
                    int i27 = zzsc.$r8$clinit;
                    iZzf = list12.size();
                    if (iZzf > 0) {
                        iZzC8 = zzpv.zzC(i6 << 3);
                        iZzC9 = zzpv.zzC(iZzf);
                        iM += iZzC9 + iZzC8 + iZzf;
                    }
                    break;
                case 43:
                    iZzf = zzsc.zzl((List) unsafe.getObject(obj2, j));
                    if (iZzf > 0) {
                        iZzC8 = zzpv.zzC(i6 << 3);
                        iZzC9 = zzpv.zzC(iZzf);
                        iM += iZzC9 + iZzC8 + iZzf;
                    }
                    break;
                case 44:
                    iZzf = zzsc.zzb((List) unsafe.getObject(obj2, j));
                    if (iZzf > 0) {
                        iZzC8 = zzpv.zzC(i6 << 3);
                        iZzC9 = zzpv.zzC(iZzf);
                        iM += iZzC9 + iZzC8 + iZzf;
                    }
                    break;
                case 45:
                    iZzf = zzsc.zzd((List) unsafe.getObject(obj2, j));
                    if (iZzf > 0) {
                        iZzC8 = zzpv.zzC(i6 << 3);
                        iZzC9 = zzpv.zzC(iZzf);
                        iM += iZzC9 + iZzC8 + iZzf;
                    }
                    break;
                case 46:
                    iZzf = zzsc.zzf((List) unsafe.getObject(obj2, j));
                    if (iZzf > 0) {
                        iZzC8 = zzpv.zzC(i6 << 3);
                        iZzC9 = zzpv.zzC(iZzf);
                        iM += iZzC9 + iZzC8 + iZzf;
                    }
                    break;
                case 47:
                    iZzf = zzsc.zzj((List) unsafe.getObject(obj2, j));
                    if (iZzf > 0) {
                        iZzC8 = zzpv.zzC(i6 << 3);
                        iZzC9 = zzpv.zzC(iZzf);
                        iM += iZzC9 + iZzC8 + iZzf;
                    }
                    break;
                case 48:
                    iZzf = zzsc.zzk((List) unsafe.getObject(obj2, j));
                    if (iZzf > 0) {
                        iZzC8 = zzpv.zzC(i6 << 3);
                        iZzC9 = zzpv.zzC(iZzf);
                        iM += iZzC9 + iZzC8 + iZzf;
                    }
                    break;
                case 49:
                    List list13 = (List) unsafe.getObject(obj2, j);
                    zzsa zzsaVarZzq2 = zzrtVar.zzq(i3);
                    int i28 = zzsc.$r8$clinit;
                    int size6 = list13.size();
                    if (size6 == 0) {
                        iZza = 0;
                    } else {
                        iZza = 0;
                        for (int i29 = 0; i29 < size6; i29++) {
                            iZza += zzsc.zza(i6, (zzrq) list13.get(i29), zzsaVarZzq2);
                        }
                    }
                    iM += iZza;
                    break;
                case 50:
                    zzrk zzrkVar = (zzrk) unsafe.getObject(obj2, j);
                    zzrj zzrjVar = (zzrj) zzrtVar.zzr(i3);
                    if (!zzrkVar.isEmpty()) {
                        iZzC6 = 0;
                        for (Map.Entry entry : zzrkVar.entrySet()) {
                            iZzC6 += zzrjVar.zza(i6, entry.getKey(), entry.getValue());
                        }
                    }
                    iM += iZzC6;
                    break;
                case 51:
                    if (zzrtVar.zzC(obj2, i6, i3)) {
                        iM = zza$$ExternalSyntheticOutline0.m(i6 << 3, 8, iM);
                    }
                    break;
                case 52:
                    if (zzrtVar.zzC(obj2, i6, i3)) {
                        iM = zza$$ExternalSyntheticOutline0.m(i6 << 3, 4, iM);
                    }
                    break;
                case 53:
                    if (zzrtVar.zzC(obj2, i6, i3)) {
                        long jZzp = zzp(obj2, j);
                        iZzC10 = zzpv.zzC(i6 << 3);
                        iZzD2 = zzpv.zzD(jZzp);
                        iM += iZzD2 + iZzC10;
                    }
                    break;
                case 54:
                    if (zzrtVar.zzC(obj2, i6, i3)) {
                        long jZzp2 = zzp(obj2, j);
                        iZzC10 = zzpv.zzC(i6 << 3);
                        iZzD2 = zzpv.zzD(jZzp2);
                        iM += iZzD2 + iZzC10;
                    }
                    break;
                case 55:
                    if (zzrtVar.zzC(obj2, i6, i3)) {
                        long jZzl = zzl(obj2, j);
                        iZzC10 = zzpv.zzC(i6 << 3);
                        iZzD2 = zzpv.zzD(jZzl);
                        iM += iZzD2 + iZzC10;
                    }
                    break;
                case 56:
                    if (zzrtVar.zzC(obj2, i6, i3)) {
                        iM = zza$$ExternalSyntheticOutline0.m(i6 << 3, 8, iM);
                    }
                    break;
                case 57:
                    if (zzrtVar.zzC(obj2, i6, i3)) {
                        iM = zza$$ExternalSyntheticOutline0.m(i6 << 3, 4, iM);
                    }
                    break;
                case 58:
                    if (zzrtVar.zzC(obj2, i6, i3)) {
                        iM = zza$$ExternalSyntheticOutline0.m(i6 << 3, 1, iM);
                    }
                    break;
                case 59:
                    if (zzrtVar.zzC(obj2, i6, i3)) {
                        int i30 = i6 << 3;
                        Object object2 = unsafe.getObject(obj2, j);
                        if (object2 instanceof zzpm) {
                            iZzf = zzpv.zzC(i30);
                            iZzC8 = ((zzpm) object2).zzd();
                            iZzC9 = zzpv.zzC(iZzC8);
                            iM += iZzC9 + iZzC8 + iZzf;
                        } else {
                            iZzC10 = zzpv.zzC(i30);
                            iZzD2 = zzpv.zzB((String) object2);
                            iM += iZzD2 + iZzC10;
                        }
                    }
                    break;
                case 60:
                    if (zzrtVar.zzC(obj2, i6, i3)) {
                        iZzi = zzsc.zzi(i6, unsafe.getObject(obj2, j), zzrtVar.zzq(i3));
                        iM += iZzi;
                    }
                    break;
                case 61:
                    if (zzrtVar.zzC(obj2, i6, i3)) {
                        zzpm zzpmVar2 = (zzpm) unsafe.getObject(obj2, j);
                        iZzf = zzpv.zzC(i6 << 3);
                        iZzC8 = zzpmVar2.zzd();
                        iZzC9 = zzpv.zzC(iZzC8);
                        iM += iZzC9 + iZzC8 + iZzf;
                    }
                    break;
                case 62:
                    if (zzrtVar.zzC(obj2, i6, i3)) {
                        iM = zza$$ExternalSyntheticOutline0.m(zzl(obj2, j), zzpv.zzC(i6 << 3), iM);
                    }
                    break;
                case 63:
                    if (zzrtVar.zzC(obj2, i6, i3)) {
                        long jZzl2 = zzl(obj2, j);
                        iZzC10 = zzpv.zzC(i6 << 3);
                        iZzD2 = zzpv.zzD(jZzl2);
                        iM += iZzD2 + iZzC10;
                    }
                    break;
                case 64:
                    if (zzrtVar.zzC(obj2, i6, i3)) {
                        iM = zza$$ExternalSyntheticOutline0.m(i6 << 3, 4, iM);
                    }
                    break;
                case 65:
                    if (zzrtVar.zzC(obj2, i6, i3)) {
                        iM = zza$$ExternalSyntheticOutline0.m(i6 << 3, 8, iM);
                    }
                    break;
                case 66:
                    if (zzrtVar.zzC(obj2, i6, i3)) {
                        int iZzl = zzl(obj2, j);
                        iM = zza$$ExternalSyntheticOutline0.m((iZzl >> 31) ^ (iZzl + iZzl), zzpv.zzC(i6 << 3), iM);
                    }
                    break;
                case 67:
                    if (zzrtVar.zzC(obj2, i6, i3)) {
                        long jZzp3 = zzp(obj2, j);
                        iZzC10 = zzpv.zzC(i6 << 3);
                        iZzD2 = zzpv.zzD((jZzp3 >> 63) ^ (jZzp3 + jZzp3));
                        iM += iZzD2 + iZzC10;
                    }
                    break;
                case 68:
                    if (zzrtVar.zzC(obj2, i6, i3)) {
                        iZzi = zzsc.zza(i6, (zzrq) unsafe.getObject(obj2, j), zzrtVar.zzq(i3));
                        iM += iZzi;
                    }
                    break;
            }
            i3 += 3;
            obj2 = obj;
            i2 = 1048575;
        }
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzsa
    public final int zzb(Object obj) {
        int i;
        long jDoubleToLongBits;
        int i2;
        int iFloatToIntBits;
        int iZzc;
        int i3;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int[] iArr = this.zzc;
            if (i4 >= iArr.length) {
                int iHashCode = ((zzqm) obj).zzc.hashCode() + (i5 * 53);
                if (this.zzf) {
                    throw FileInsert$$ExternalSyntheticOutline0.m(obj);
                }
                return iHashCode;
            }
            int iZzo = zzo(i4);
            int i6 = 1048575 & iZzo;
            int iZzn = zzn(iZzo);
            int i7 = iArr[i4];
            long j = i6;
            int iHashCode2 = 37;
            switch (iZzn) {
                case 0:
                    i = i5 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(zzsw.zza(obj, j));
                    byte[] bArr = zzqs.zzb;
                    iZzc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i5 = i + iZzc;
                    break;
                case 1:
                    i2 = i5 * 53;
                    iFloatToIntBits = Float.floatToIntBits(zzsw.zzb(obj, j));
                    i5 = iFloatToIntBits + i2;
                    break;
                case 2:
                    i = i5 * 53;
                    jDoubleToLongBits = zzsw.zzd(obj, j);
                    byte[] bArr2 = zzqs.zzb;
                    iZzc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i5 = i + iZzc;
                    break;
                case 3:
                    i = i5 * 53;
                    jDoubleToLongBits = zzsw.zzd(obj, j);
                    byte[] bArr3 = zzqs.zzb;
                    iZzc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i5 = i + iZzc;
                    break;
                case 4:
                    i = i5 * 53;
                    iZzc = zzsw.zzc(obj, j);
                    i5 = i + iZzc;
                    break;
                case 5:
                    i = i5 * 53;
                    jDoubleToLongBits = zzsw.zzd(obj, j);
                    byte[] bArr4 = zzqs.zzb;
                    iZzc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i5 = i + iZzc;
                    break;
                case 6:
                    i = i5 * 53;
                    iZzc = zzsw.zzc(obj, j);
                    i5 = i + iZzc;
                    break;
                case 7:
                    i2 = i5 * 53;
                    iFloatToIntBits = zzqs.zza(zzsw.zzw(obj, j));
                    i5 = iFloatToIntBits + i2;
                    break;
                case 8:
                    i2 = i5 * 53;
                    iFloatToIntBits = ((String) zzsw.zzf(obj, j)).hashCode();
                    i5 = iFloatToIntBits + i2;
                    break;
                case 9:
                    i3 = i5 * 53;
                    Object objZzf = zzsw.zzf(obj, j);
                    if (objZzf != null) {
                        iHashCode2 = objZzf.hashCode();
                    }
                    i5 = i3 + iHashCode2;
                    break;
                case 10:
                    i2 = i5 * 53;
                    iFloatToIntBits = zzsw.zzf(obj, j).hashCode();
                    i5 = iFloatToIntBits + i2;
                    break;
                case 11:
                    i = i5 * 53;
                    iZzc = zzsw.zzc(obj, j);
                    i5 = i + iZzc;
                    break;
                case 12:
                    i = i5 * 53;
                    iZzc = zzsw.zzc(obj, j);
                    i5 = i + iZzc;
                    break;
                case 13:
                    i = i5 * 53;
                    iZzc = zzsw.zzc(obj, j);
                    i5 = i + iZzc;
                    break;
                case 14:
                    i = i5 * 53;
                    jDoubleToLongBits = zzsw.zzd(obj, j);
                    byte[] bArr5 = zzqs.zzb;
                    iZzc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i5 = i + iZzc;
                    break;
                case 15:
                    i = i5 * 53;
                    iZzc = zzsw.zzc(obj, j);
                    i5 = i + iZzc;
                    break;
                case 16:
                    i = i5 * 53;
                    jDoubleToLongBits = zzsw.zzd(obj, j);
                    byte[] bArr6 = zzqs.zzb;
                    iZzc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i5 = i + iZzc;
                    break;
                case 17:
                    i3 = i5 * 53;
                    Object objZzf2 = zzsw.zzf(obj, j);
                    if (objZzf2 != null) {
                        iHashCode2 = objZzf2.hashCode();
                    }
                    i5 = i3 + iHashCode2;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i2 = i5 * 53;
                    iFloatToIntBits = zzsw.zzf(obj, j).hashCode();
                    i5 = iFloatToIntBits + i2;
                    break;
                case 50:
                    i2 = i5 * 53;
                    iFloatToIntBits = zzsw.zzf(obj, j).hashCode();
                    i5 = iFloatToIntBits + i2;
                    break;
                case 51:
                    if (zzC(obj, i7, i4)) {
                        i = i5 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(zzj(obj, j));
                        byte[] bArr7 = zzqs.zzb;
                        iZzc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i5 = i + iZzc;
                    }
                    break;
                case 52:
                    if (zzC(obj, i7, i4)) {
                        i2 = i5 * 53;
                        iFloatToIntBits = Float.floatToIntBits(zzk(obj, j));
                        i5 = iFloatToIntBits + i2;
                    }
                    break;
                case 53:
                    if (zzC(obj, i7, i4)) {
                        i = i5 * 53;
                        jDoubleToLongBits = zzp(obj, j);
                        byte[] bArr8 = zzqs.zzb;
                        iZzc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i5 = i + iZzc;
                    }
                    break;
                case 54:
                    if (zzC(obj, i7, i4)) {
                        i = i5 * 53;
                        jDoubleToLongBits = zzp(obj, j);
                        byte[] bArr9 = zzqs.zzb;
                        iZzc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i5 = i + iZzc;
                    }
                    break;
                case 55:
                    if (zzC(obj, i7, i4)) {
                        i = i5 * 53;
                        iZzc = zzl(obj, j);
                        i5 = i + iZzc;
                    }
                    break;
                case 56:
                    if (zzC(obj, i7, i4)) {
                        i = i5 * 53;
                        jDoubleToLongBits = zzp(obj, j);
                        byte[] bArr10 = zzqs.zzb;
                        iZzc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i5 = i + iZzc;
                    }
                    break;
                case 57:
                    if (zzC(obj, i7, i4)) {
                        i = i5 * 53;
                        iZzc = zzl(obj, j);
                        i5 = i + iZzc;
                    }
                    break;
                case 58:
                    if (zzC(obj, i7, i4)) {
                        i2 = i5 * 53;
                        iFloatToIntBits = zzqs.zza(zzD(obj, j));
                        i5 = iFloatToIntBits + i2;
                    }
                    break;
                case 59:
                    if (zzC(obj, i7, i4)) {
                        i2 = i5 * 53;
                        iFloatToIntBits = ((String) zzsw.zzf(obj, j)).hashCode();
                        i5 = iFloatToIntBits + i2;
                    }
                    break;
                case 60:
                    if (zzC(obj, i7, i4)) {
                        i2 = i5 * 53;
                        iFloatToIntBits = zzsw.zzf(obj, j).hashCode();
                        i5 = iFloatToIntBits + i2;
                    }
                    break;
                case 61:
                    if (zzC(obj, i7, i4)) {
                        i2 = i5 * 53;
                        iFloatToIntBits = zzsw.zzf(obj, j).hashCode();
                        i5 = iFloatToIntBits + i2;
                    }
                    break;
                case 62:
                    if (zzC(obj, i7, i4)) {
                        i = i5 * 53;
                        iZzc = zzl(obj, j);
                        i5 = i + iZzc;
                    }
                    break;
                case 63:
                    if (zzC(obj, i7, i4)) {
                        i = i5 * 53;
                        iZzc = zzl(obj, j);
                        i5 = i + iZzc;
                    }
                    break;
                case 64:
                    if (zzC(obj, i7, i4)) {
                        i = i5 * 53;
                        iZzc = zzl(obj, j);
                        i5 = i + iZzc;
                    }
                    break;
                case 65:
                    if (zzC(obj, i7, i4)) {
                        i = i5 * 53;
                        jDoubleToLongBits = zzp(obj, j);
                        byte[] bArr11 = zzqs.zzb;
                        iZzc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i5 = i + iZzc;
                    }
                    break;
                case 66:
                    if (zzC(obj, i7, i4)) {
                        i = i5 * 53;
                        iZzc = zzl(obj, j);
                        i5 = i + iZzc;
                    }
                    break;
                case 67:
                    if (zzC(obj, i7, i4)) {
                        i = i5 * 53;
                        jDoubleToLongBits = zzp(obj, j);
                        byte[] bArr12 = zzqs.zzb;
                        iZzc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i5 = i + iZzc;
                    }
                    break;
                case 68:
                    if (zzC(obj, i7, i4)) {
                        i2 = i5 * 53;
                        iFloatToIntBits = zzsw.zzf(obj, j).hashCode();
                        i5 = iFloatToIntBits + i2;
                    }
                    break;
            }
            i4 += 3;
        }
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzsa
    public final Object zzc() {
        return ((zzqm) this.zze).zzr();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006f  */
    @Override // com.google.android.gms.internal.consent_sdk.zzsa
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzd(Object obj) {
        if (zzB(obj)) {
            if (obj instanceof zzqm) {
                zzqm zzqmVar = (zzqm) obj;
                zzqmVar.zzA(Integer.MAX_VALUE);
                zzqmVar.zza = 0;
                zzqmVar.zzy();
            }
            int[] iArr = this.zzc;
            for (int i = 0; i < iArr.length; i += 3) {
                int iZzo = zzo(i);
                int i2 = 1048575 & iZzo;
                int iZzn = zzn(iZzo);
                long j = i2;
                if (iZzn != 9) {
                    if (iZzn != 60 && iZzn != 68) {
                        switch (iZzn) {
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case 48:
                            case 49:
                                ((zzqr) zzsw.zzf(obj, j)).zzb();
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    ((zzrk) object).zzc();
                                    unsafe.putObject(obj, j, object);
                                }
                                break;
                        }
                    } else if (zzC(obj, iArr[i], i)) {
                        zzq(i).zzd(zzb.getObject(obj, j));
                    }
                } else if (zzy(obj, i)) {
                    zzq(i).zzd(zzb.getObject(obj, j));
                }
            }
            this.zzi.zza(obj);
            if (this.zzf) {
                this.zzj.zza(obj);
            }
        }
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzsa
    public final void zze(Object obj, Object obj2) {
        if (!zzB(obj)) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Mutating immutable message: ".concat(String.valueOf(obj)));
            return;
        }
        obj2.getClass();
        int i = 0;
        while (true) {
            int[] iArr = this.zzc;
            if (i >= iArr.length) {
                zzsc.zzp(this.zzi, obj, obj2);
                if (this.zzf) {
                    zzsc.zzo(this.zzj, obj, obj2);
                    return;
                }
                return;
            }
            int iZzo = zzo(i);
            int i2 = 1048575 & iZzo;
            int iZzn = zzn(iZzo);
            int i3 = iArr[i];
            long j = i2;
            switch (iZzn) {
                case 0:
                    if (zzy(obj2, i)) {
                        zzsw.zzo(obj, j, zzsw.zza(obj2, j));
                        zzv(obj, i);
                    }
                    break;
                case 1:
                    if (zzy(obj2, i)) {
                        zzsw.zzp(obj, j, zzsw.zzb(obj2, j));
                        zzv(obj, i);
                    }
                    break;
                case 2:
                    if (zzy(obj2, i)) {
                        zzsw.zzr(obj, j, zzsw.zzd(obj2, j));
                        zzv(obj, i);
                    }
                    break;
                case 3:
                    if (zzy(obj2, i)) {
                        zzsw.zzr(obj, j, zzsw.zzd(obj2, j));
                        zzv(obj, i);
                    }
                    break;
                case 4:
                    if (zzy(obj2, i)) {
                        zzsw.zzq(obj, j, zzsw.zzc(obj2, j));
                        zzv(obj, i);
                    }
                    break;
                case 5:
                    if (zzy(obj2, i)) {
                        zzsw.zzr(obj, j, zzsw.zzd(obj2, j));
                        zzv(obj, i);
                    }
                    break;
                case 6:
                    if (zzy(obj2, i)) {
                        zzsw.zzq(obj, j, zzsw.zzc(obj2, j));
                        zzv(obj, i);
                    }
                    break;
                case 7:
                    if (zzy(obj2, i)) {
                        zzsw.zzm(obj, j, zzsw.zzw(obj2, j));
                        zzv(obj, i);
                    }
                    break;
                case 8:
                    if (zzy(obj2, i)) {
                        zzsw.zzs(obj, j, zzsw.zzf(obj2, j));
                        zzv(obj, i);
                    }
                    break;
                case 9:
                    zzt(obj, obj2, i);
                    break;
                case 10:
                    if (zzy(obj2, i)) {
                        zzsw.zzs(obj, j, zzsw.zzf(obj2, j));
                        zzv(obj, i);
                    }
                    break;
                case 11:
                    if (zzy(obj2, i)) {
                        zzsw.zzq(obj, j, zzsw.zzc(obj2, j));
                        zzv(obj, i);
                    }
                    break;
                case 12:
                    if (zzy(obj2, i)) {
                        zzsw.zzq(obj, j, zzsw.zzc(obj2, j));
                        zzv(obj, i);
                    }
                    break;
                case 13:
                    if (zzy(obj2, i)) {
                        zzsw.zzq(obj, j, zzsw.zzc(obj2, j));
                        zzv(obj, i);
                    }
                    break;
                case 14:
                    if (zzy(obj2, i)) {
                        zzsw.zzr(obj, j, zzsw.zzd(obj2, j));
                        zzv(obj, i);
                    }
                    break;
                case 15:
                    if (zzy(obj2, i)) {
                        zzsw.zzq(obj, j, zzsw.zzc(obj2, j));
                        zzv(obj, i);
                    }
                    break;
                case 16:
                    if (zzy(obj2, i)) {
                        zzsw.zzr(obj, j, zzsw.zzd(obj2, j));
                        zzv(obj, i);
                    }
                    break;
                case 17:
                    zzt(obj, obj2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    zzqr zzqrVarZzd = (zzqr) zzsw.zzf(obj, j);
                    zzqr zzqrVar = (zzqr) zzsw.zzf(obj2, j);
                    int size = zzqrVarZzd.size();
                    int size2 = zzqrVar.size();
                    if (size > 0 && size2 > 0) {
                        if (!zzqrVarZzd.zzc()) {
                            zzqrVarZzd = zzqrVarZzd.zzd(size2 + size);
                        }
                        zzqrVarZzd.addAll(zzqrVar);
                    }
                    if (size > 0) {
                        zzqrVar = zzqrVarZzd;
                    }
                    zzsw.zzs(obj, j, zzqrVar);
                    break;
                case 50:
                    int i4 = zzsc.$r8$clinit;
                    zzrk zzrkVarZzb = (zzrk) zzsw.zzf(obj, j);
                    zzrk zzrkVar = (zzrk) zzsw.zzf(obj2, j);
                    if (!zzrkVar.isEmpty()) {
                        if (!zzrkVarZzb.zze()) {
                            zzrkVarZzb = zzrkVarZzb.zzb();
                        }
                        zzrkVarZzb.zzd(zzrkVar);
                    }
                    zzsw.zzs(obj, j, zzrkVarZzb);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (zzC(obj2, i3, i)) {
                        zzsw.zzs(obj, j, zzsw.zzf(obj2, j));
                        zzw(obj, i3, i);
                    }
                    break;
                case 60:
                    zzu(obj, obj2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzC(obj2, i3, i)) {
                        zzsw.zzs(obj, j, zzsw.zzf(obj2, j));
                        zzw(obj, i3, i);
                    }
                    break;
                case 68:
                    zzu(obj, obj2, i);
                    break;
            }
            i += 3;
        }
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzsa
    public final void zzf(Object obj, zztb zztbVar) {
        int i;
        zzrt<T> zzrtVar = this;
        if (zzrtVar.zzf) {
            throw FileInsert$$ExternalSyntheticOutline0.m(obj);
        }
        int[] iArr = zzrtVar.zzc;
        Unsafe unsafe = zzb;
        int i2 = 1048575;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (i4 < iArr.length) {
            int iZzo = zzrtVar.zzo(i4);
            int iZzn = zzn(iZzo);
            int i6 = iArr[i4];
            if (iZzn <= 17) {
                int i7 = iArr[i4 + 2];
                int i8 = i7 & i2;
                if (i8 != i3) {
                    i5 = i8 == i2 ? 0 : unsafe.getInt(obj, i8);
                    i3 = i8;
                }
                i = 1 << (i7 >>> 20);
            } else {
                i = 0;
            }
            long j = iZzo & i2;
            switch (iZzn) {
                case 0:
                    if (zzrtVar.zzz(obj, i4, i3, i5, i)) {
                        zztbVar.zzf(i6, zzsw.zza(obj, j));
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzrtVar = this;
                    break;
                case 1:
                    if (zzrtVar.zzz(obj, i4, i3, i5, i)) {
                        zztbVar.zzn(i6, zzsw.zzb(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzrtVar = this;
                    break;
                case 2:
                    if (zzrtVar.zzz(obj, i4, i3, i5, i)) {
                        zztbVar.zzs(i6, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzrtVar = this;
                    break;
                case 3:
                    if (zzrtVar.zzz(obj, i4, i3, i5, i)) {
                        zztbVar.zzJ(i6, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzrtVar = this;
                    break;
                case 4:
                    if (zzrtVar.zzz(obj, i4, i3, i5, i)) {
                        zztbVar.zzq(i6, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzrtVar = this;
                    break;
                case 5:
                    if (zzrtVar.zzz(obj, i4, i3, i5, i)) {
                        zztbVar.zzl(i6, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzrtVar = this;
                    break;
                case 6:
                    if (zzrtVar.zzz(obj, i4, i3, i5, i)) {
                        zztbVar.zzj(i6, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzrtVar = this;
                    break;
                case 7:
                    if (zzrtVar.zzz(obj, i4, i3, i5, i)) {
                        zztbVar.zzb(i6, zzsw.zzw(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzrtVar = this;
                    break;
                case 8:
                    if (zzrtVar.zzz(obj, i4, i3, i5, i)) {
                        zzE(i6, unsafe.getObject(obj, j), zztbVar);
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzrtVar = this;
                    break;
                case 9:
                    if (zzrtVar.zzz(obj, i4, i3, i5, i)) {
                        zztbVar.zzv(i6, unsafe.getObject(obj, j), zzrtVar.zzq(i4));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzrtVar = this;
                    break;
                case 10:
                    if (zzrtVar.zzz(obj, i4, i3, i5, i)) {
                        zztbVar.zzd(i6, (zzpm) unsafe.getObject(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzrtVar = this;
                    break;
                case 11:
                    if (zzrtVar.zzz(obj, i4, i3, i5, i)) {
                        zztbVar.zzH(i6, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzrtVar = this;
                    break;
                case 12:
                    if (zzrtVar.zzz(obj, i4, i3, i5, i)) {
                        zztbVar.zzh(i6, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzrtVar = this;
                    break;
                case 13:
                    if (zzrtVar.zzz(obj, i4, i3, i5, i)) {
                        zztbVar.zzx(i6, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzrtVar = this;
                    break;
                case 14:
                    if (zzrtVar.zzz(obj, i4, i3, i5, i)) {
                        zztbVar.zzz(i6, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzrtVar = this;
                    break;
                case 15:
                    if (zzrtVar.zzz(obj, i4, i3, i5, i)) {
                        zztbVar.zzB(i6, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzrtVar = this;
                    break;
                case 16:
                    if (zzrtVar.zzz(obj, i4, i3, i5, i)) {
                        zztbVar.zzD(i6, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzrtVar = this;
                    break;
                case 17:
                    if (zzrtVar.zzz(obj, i4, i3, i5, i)) {
                        zztbVar.zzp(i6, unsafe.getObject(obj, j), zzrtVar.zzq(i4));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzrtVar = this;
                    break;
                case 18:
                    zzsc.zzr(iArr[i4], (List) unsafe.getObject(obj, j), zztbVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzrtVar = this;
                    break;
                case 19:
                    zzsc.zzv(iArr[i4], (List) unsafe.getObject(obj, j), zztbVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzrtVar = this;
                    break;
                case 20:
                    zzsc.zzx(iArr[i4], (List) unsafe.getObject(obj, j), zztbVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzrtVar = this;
                    break;
                case 21:
                    zzsc.zzD(iArr[i4], (List) unsafe.getObject(obj, j), zztbVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzrtVar = this;
                    break;
                case 22:
                    zzsc.zzw(iArr[i4], (List) unsafe.getObject(obj, j), zztbVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzrtVar = this;
                    break;
                case 23:
                    zzsc.zzu(iArr[i4], (List) unsafe.getObject(obj, j), zztbVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzrtVar = this;
                    break;
                case 24:
                    zzsc.zzt(iArr[i4], (List) unsafe.getObject(obj, j), zztbVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzrtVar = this;
                    break;
                case 25:
                    zzsc.zzq(iArr[i4], (List) unsafe.getObject(obj, j), zztbVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzrtVar = this;
                    break;
                case 26:
                    int i9 = iArr[i4];
                    List list = (List) unsafe.getObject(obj, j);
                    int i10 = zzsc.$r8$clinit;
                    if (list != null && !list.isEmpty()) {
                        zztbVar.zzG(i9, list);
                    }
                    break;
                case 27:
                    int i11 = iArr[i4];
                    List list2 = (List) unsafe.getObject(obj, j);
                    zzsa zzsaVarZzq = zzrtVar.zzq(i4);
                    int i12 = zzsc.$r8$clinit;
                    if (list2 != null && !list2.isEmpty()) {
                        for (int i13 = 0; i13 < list2.size(); i13++) {
                            ((zzpw) zztbVar).zzv(i11, list2.get(i13), zzsaVarZzq);
                        }
                    }
                    break;
                case 28:
                    int i14 = iArr[i4];
                    List list3 = (List) unsafe.getObject(obj, j);
                    int i15 = zzsc.$r8$clinit;
                    if (list3 != null && !list3.isEmpty()) {
                        zztbVar.zze(i14, list3);
                    }
                    break;
                case 29:
                    zzsc.zzC(iArr[i4], (List) unsafe.getObject(obj, j), zztbVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzrtVar = this;
                    break;
                case 30:
                    zzsc.zzs(iArr[i4], (List) unsafe.getObject(obj, j), zztbVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzrtVar = this;
                    break;
                case 31:
                    zzsc.zzy(iArr[i4], (List) unsafe.getObject(obj, j), zztbVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzrtVar = this;
                    break;
                case 32:
                    zzsc.zzz(iArr[i4], (List) unsafe.getObject(obj, j), zztbVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzrtVar = this;
                    break;
                case 33:
                    zzsc.zzA(iArr[i4], (List) unsafe.getObject(obj, j), zztbVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzrtVar = this;
                    break;
                case 34:
                    zzsc.zzB(iArr[i4], (List) unsafe.getObject(obj, j), zztbVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzrtVar = this;
                    break;
                case 35:
                    zzsc.zzr(iArr[i4], (List) unsafe.getObject(obj, j), zztbVar, true);
                    break;
                case 36:
                    zzsc.zzv(iArr[i4], (List) unsafe.getObject(obj, j), zztbVar, true);
                    break;
                case 37:
                    zzsc.zzx(iArr[i4], (List) unsafe.getObject(obj, j), zztbVar, true);
                    break;
                case 38:
                    zzsc.zzD(iArr[i4], (List) unsafe.getObject(obj, j), zztbVar, true);
                    break;
                case 39:
                    zzsc.zzw(iArr[i4], (List) unsafe.getObject(obj, j), zztbVar, true);
                    break;
                case 40:
                    zzsc.zzu(iArr[i4], (List) unsafe.getObject(obj, j), zztbVar, true);
                    break;
                case 41:
                    zzsc.zzt(iArr[i4], (List) unsafe.getObject(obj, j), zztbVar, true);
                    break;
                case 42:
                    zzsc.zzq(iArr[i4], (List) unsafe.getObject(obj, j), zztbVar, true);
                    break;
                case 43:
                    zzsc.zzC(iArr[i4], (List) unsafe.getObject(obj, j), zztbVar, true);
                    break;
                case 44:
                    zzsc.zzs(iArr[i4], (List) unsafe.getObject(obj, j), zztbVar, true);
                    break;
                case 45:
                    zzsc.zzy(iArr[i4], (List) unsafe.getObject(obj, j), zztbVar, true);
                    break;
                case 46:
                    zzsc.zzz(iArr[i4], (List) unsafe.getObject(obj, j), zztbVar, true);
                    break;
                case 47:
                    zzsc.zzA(iArr[i4], (List) unsafe.getObject(obj, j), zztbVar, true);
                    break;
                case 48:
                    zzsc.zzB(iArr[i4], (List) unsafe.getObject(obj, j), zztbVar, true);
                    break;
                case 49:
                    int i16 = iArr[i4];
                    List list4 = (List) unsafe.getObject(obj, j);
                    zzsa zzsaVarZzq2 = zzrtVar.zzq(i4);
                    int i17 = zzsc.$r8$clinit;
                    if (list4 != null && !list4.isEmpty()) {
                        for (int i18 = 0; i18 < list4.size(); i18++) {
                            ((zzpw) zztbVar).zzp(i16, list4.get(i18), zzsaVarZzq2);
                        }
                    }
                    break;
                case 50:
                    Object object = unsafe.getObject(obj, j);
                    if (object != null) {
                        zztbVar.zzu(i6, ((zzrj) zzrtVar.zzr(i4)).zzc(), (zzrk) object);
                    }
                    break;
                case 51:
                    if (zzrtVar.zzC(obj, i6, i4)) {
                        zztbVar.zzf(i6, zzj(obj, j));
                    }
                    break;
                case 52:
                    if (zzrtVar.zzC(obj, i6, i4)) {
                        zztbVar.zzn(i6, zzk(obj, j));
                    }
                    break;
                case 53:
                    if (zzrtVar.zzC(obj, i6, i4)) {
                        zztbVar.zzs(i6, zzp(obj, j));
                    }
                    break;
                case 54:
                    if (zzrtVar.zzC(obj, i6, i4)) {
                        zztbVar.zzJ(i6, zzp(obj, j));
                    }
                    break;
                case 55:
                    if (zzrtVar.zzC(obj, i6, i4)) {
                        zztbVar.zzq(i6, zzl(obj, j));
                    }
                    break;
                case 56:
                    if (zzrtVar.zzC(obj, i6, i4)) {
                        zztbVar.zzl(i6, zzp(obj, j));
                    }
                    break;
                case 57:
                    if (zzrtVar.zzC(obj, i6, i4)) {
                        zztbVar.zzj(i6, zzl(obj, j));
                    }
                    break;
                case 58:
                    if (zzrtVar.zzC(obj, i6, i4)) {
                        zztbVar.zzb(i6, zzD(obj, j));
                    }
                    break;
                case 59:
                    if (zzrtVar.zzC(obj, i6, i4)) {
                        zzE(i6, unsafe.getObject(obj, j), zztbVar);
                    }
                    break;
                case 60:
                    if (zzrtVar.zzC(obj, i6, i4)) {
                        zztbVar.zzv(i6, unsafe.getObject(obj, j), zzrtVar.zzq(i4));
                    }
                    break;
                case 61:
                    if (zzrtVar.zzC(obj, i6, i4)) {
                        zztbVar.zzd(i6, (zzpm) unsafe.getObject(obj, j));
                    }
                    break;
                case 62:
                    if (zzrtVar.zzC(obj, i6, i4)) {
                        zztbVar.zzH(i6, zzl(obj, j));
                    }
                    break;
                case 63:
                    if (zzrtVar.zzC(obj, i6, i4)) {
                        zztbVar.zzh(i6, zzl(obj, j));
                    }
                    break;
                case 64:
                    if (zzrtVar.zzC(obj, i6, i4)) {
                        zztbVar.zzx(i6, zzl(obj, j));
                    }
                    break;
                case 65:
                    if (zzrtVar.zzC(obj, i6, i4)) {
                        zztbVar.zzz(i6, zzp(obj, j));
                    }
                    break;
                case 66:
                    if (zzrtVar.zzC(obj, i6, i4)) {
                        zztbVar.zzB(i6, zzl(obj, j));
                    }
                    break;
                case 67:
                    if (zzrtVar.zzC(obj, i6, i4)) {
                        zztbVar.zzD(i6, zzp(obj, j));
                    }
                    break;
                case 68:
                    if (zzrtVar.zzC(obj, i6, i4)) {
                        zztbVar.zzp(i6, unsafe.getObject(obj, j), zzrtVar.zzq(i4));
                    }
                    break;
            }
            i4 += 3;
            i2 = 1048575;
            zzrtVar = this;
        }
        zzsq zzsqVar = ((zzqm) obj).zzc;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzsa
    public final boolean zzg(Object obj, Object obj2) {
        boolean zZzE;
        int i = 0;
        while (true) {
            if (i < this.zzc.length) {
                int iZzo = zzo(i);
                long j = iZzo & 1048575;
                switch (zzn(iZzo)) {
                    case 0:
                        if (zzx(obj, obj2, i) && Double.doubleToLongBits(zzsw.zza(obj, j)) == Double.doubleToLongBits(zzsw.zza(obj2, j))) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 1:
                        if (zzx(obj, obj2, i) && Float.floatToIntBits(zzsw.zzb(obj, j)) == Float.floatToIntBits(zzsw.zzb(obj2, j))) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 2:
                        if (zzx(obj, obj2, i) && zzsw.zzd(obj, j) == zzsw.zzd(obj2, j)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 3:
                        if (zzx(obj, obj2, i) && zzsw.zzd(obj, j) == zzsw.zzd(obj2, j)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 4:
                        if (zzx(obj, obj2, i) && zzsw.zzc(obj, j) == zzsw.zzc(obj2, j)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 5:
                        if (zzx(obj, obj2, i) && zzsw.zzd(obj, j) == zzsw.zzd(obj2, j)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 6:
                        if (zzx(obj, obj2, i) && zzsw.zzc(obj, j) == zzsw.zzc(obj2, j)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 7:
                        if (zzx(obj, obj2, i) && zzsw.zzw(obj, j) == zzsw.zzw(obj2, j)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 8:
                        if (zzx(obj, obj2, i) && zzsc.zzE(zzsw.zzf(obj, j), zzsw.zzf(obj2, j))) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 9:
                        if (zzx(obj, obj2, i) && zzsc.zzE(zzsw.zzf(obj, j), zzsw.zzf(obj2, j))) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 10:
                        if (zzx(obj, obj2, i) && zzsc.zzE(zzsw.zzf(obj, j), zzsw.zzf(obj2, j))) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 11:
                        if (zzx(obj, obj2, i) && zzsw.zzc(obj, j) == zzsw.zzc(obj2, j)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 12:
                        if (zzx(obj, obj2, i) && zzsw.zzc(obj, j) == zzsw.zzc(obj2, j)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 13:
                        if (zzx(obj, obj2, i) && zzsw.zzc(obj, j) == zzsw.zzc(obj2, j)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 14:
                        if (zzx(obj, obj2, i) && zzsw.zzd(obj, j) == zzsw.zzd(obj2, j)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 15:
                        if (zzx(obj, obj2, i) && zzsw.zzc(obj, j) == zzsw.zzc(obj2, j)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 16:
                        if (zzx(obj, obj2, i) && zzsw.zzd(obj, j) == zzsw.zzd(obj2, j)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 17:
                        if (zzx(obj, obj2, i) && zzsc.zzE(zzsw.zzf(obj, j), zzsw.zzf(obj2, j))) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        zZzE = zzsc.zzE(zzsw.zzf(obj, j), zzsw.zzf(obj2, j));
                        break;
                    case 50:
                        zZzE = zzsc.zzE(zzsw.zzf(obj, j), zzsw.zzf(obj2, j));
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                    case 60:
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                    case 68:
                        long jZzm = zzm(i) & 1048575;
                        if (zzsw.zzc(obj, jZzm) == zzsw.zzc(obj2, jZzm) && zzsc.zzE(zzsw.zzf(obj, j), zzsw.zzf(obj2, j))) {
                            continue;
                            i += 3;
                        }
                        break;
                    default:
                        i += 3;
                        break;
                }
                if (zZzE) {
                    i += 3;
                }
            } else if (((zzqm) obj).zzc.equals(((zzqm) obj2).zzc)) {
                if (this.zzf) {
                    throw FileInsert$$ExternalSyntheticOutline0.m(obj);
                }
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzsa
    public final boolean zzh(Object obj) {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        int i5 = 0;
        int i6 = 1048575;
        while (i5 < this.zzh) {
            int[] iArr = this.zzg;
            int[] iArr2 = this.zzc;
            int i7 = iArr[i5];
            int i8 = iArr2[i7];
            int iZzo = zzo(i7);
            int i9 = iArr2[i7 + 2];
            int i10 = i9 & 1048575;
            int i11 = 1 << (i9 >>> 20);
            if (i10 != i6) {
                if (i10 != 1048575) {
                    i4 = zzb.getInt(obj, i10);
                }
                i2 = i7;
                i3 = i4;
                i = i10;
            } else {
                int i12 = i4;
                i = i6;
                i2 = i7;
                i3 = i12;
            }
            if ((268435456 & iZzo) == 0 || zzz(obj, i2, i, i3, i11)) {
                int iZzn = zzn(iZzo);
                if (iZzn != 9 && iZzn != 17) {
                    if (iZzn != 27) {
                        if (iZzn == 60 || iZzn == 68) {
                            if (!zzC(obj, i8, i2) || zzA(obj, iZzo, zzq(i2))) {
                                i5++;
                                i6 = i;
                                i4 = i3;
                            }
                        } else if (iZzn != 49) {
                            if (iZzn != 50) {
                                continue;
                            } else {
                                zzrk zzrkVar = (zzrk) zzsw.zzf(obj, iZzo & 1048575);
                                if (!zzrkVar.isEmpty() && ((zzrj) zzr(i2)).zzc().zzb.zzb() == zzta.MESSAGE) {
                                    zzsa zzsaVarZzb = null;
                                    for (Object obj2 : zzrkVar.values()) {
                                        if (zzsaVarZzb == null) {
                                            zzsaVarZzb = zzrx.zza().zzb(obj2.getClass());
                                        }
                                        if (!zzsaVarZzb.zzh(obj2)) {
                                        }
                                    }
                                }
                            }
                            i5++;
                            i6 = i;
                            i4 = i3;
                        }
                    }
                    List list = (List) zzsw.zzf(obj, iZzo & 1048575);
                    if (list.isEmpty()) {
                        continue;
                    } else {
                        zzsa zzsaVarZzq = zzq(i2);
                        for (int i13 = 0; i13 < list.size(); i13++) {
                            if (zzsaVarZzq.zzh(list.get(i13))) {
                            }
                        }
                    }
                    i5++;
                    i6 = i;
                    i4 = i3;
                } else if (!zzz(obj, i2, i, i3, i11) || zzA(obj, iZzo, zzq(i2))) {
                    i5++;
                    i6 = i;
                    i4 = i3;
                }
            }
            return false;
        }
        if (this.zzf) {
            throw FileInsert$$ExternalSyntheticOutline0.m(obj);
        }
        return true;
    }
}
