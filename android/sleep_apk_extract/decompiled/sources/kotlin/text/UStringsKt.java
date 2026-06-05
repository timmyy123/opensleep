package kotlin.text;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\u001a\u001b\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\u0006\u001a\u00020\u0003*\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\b\u0010\t\u001a\u0013\u0010\u000b\u001a\u00020\n*\u00020\u0003H\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a\u0013\u0010\r\u001a\u00020\u0000*\u00020\u0003H\u0007¢\u0006\u0004\b\r\u0010\u000e\u001a\u0013\u0010\u000f\u001a\u00020\u0007*\u00020\u0003H\u0007¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001b\u0010\u000f\u001a\u00020\u0007*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u000f\u0010\u0011\u001a\u0013\u0010\u0013\u001a\u00020\u0012*\u00020\u0003H\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0015\u0010\u0015\u001a\u0004\u0018\u00010\n*\u00020\u0003H\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001d\u0010\u0015\u001a\u0004\u0018\u00010\n*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0015\u0010\u0017\u001a\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0000*\u00020\u0003H\u0007¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u0000*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0018\u0010\u001a\u001a\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u0007*\u00020\u0003H\u0007¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u0007*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u001b\u0010\u001d\u001a\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u0012*\u00020\u0003H\u0007¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u0012*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u001e\u0010 ¨\u0006!"}, d2 = {"Lkotlin/UShort;", "", "radix", "", "toString-olVBNx4", "(SI)Ljava/lang/String;", InAppPurchaseConstants.METHOD_TO_STRING, "Lkotlin/UInt;", "toString-V7xB4Y4", "(II)Ljava/lang/String;", "Lkotlin/UByte;", "toUByte", "(Ljava/lang/String;)B", "toUShort", "(Ljava/lang/String;)S", "toUInt", "(Ljava/lang/String;)I", "(Ljava/lang/String;I)I", "Lkotlin/ULong;", "toULong", "(Ljava/lang/String;)J", "toUByteOrNull", "(Ljava/lang/String;)Lkotlin/UByte;", "(Ljava/lang/String;I)Lkotlin/UByte;", "toUShortOrNull", "(Ljava/lang/String;)Lkotlin/UShort;", "(Ljava/lang/String;I)Lkotlin/UShort;", "toUIntOrNull", "(Ljava/lang/String;)Lkotlin/UInt;", "(Ljava/lang/String;I)Lkotlin/UInt;", "toULongOrNull", "(Ljava/lang/String;)Lkotlin/ULong;", "(Ljava/lang/String;I)Lkotlin/ULong;", "kotlin-stdlib"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class UStringsKt {
    /* JADX INFO: renamed from: toString-V7xB4Y4, reason: not valid java name */
    public static final String m2521toStringV7xB4Y4(int i, int i2) {
        return UnsignedKt.ulongToString(((long) i) & 4294967295L, CharsKt__CharJVMKt.checkRadix(i2));
    }

    /* JADX INFO: renamed from: toString-olVBNx4, reason: not valid java name */
    public static final String m2522toStringolVBNx4(short s, int i) {
        String string = Integer.toString(s & 65535, CharsKt__CharJVMKt.checkRadix(i));
        string.getClass();
        return string;
    }

    public static final byte toUByte(String str) {
        str.getClass();
        UByte uByteOrNull = toUByteOrNull(str);
        if (uByteOrNull != null) {
            return uByteOrNull.getData();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(str);
        Utf8$$ExternalSyntheticBUOutline0.m();
        return (byte) 0;
    }

    public static final UByte toUByteOrNull(String str, int i) {
        str.getClass();
        UInt uIntOrNull = toUIntOrNull(str, i);
        if (uIntOrNull == null) {
            return null;
        }
        int data2 = uIntOrNull.getData();
        if (Integer.compare(data2 ^ Integer.MIN_VALUE, UInt.m2389constructorimpl(PHIpAddressSearchManager.END_IP_SCAN) ^ Integer.MIN_VALUE) > 0) {
            return null;
        }
        return UByte.m2366boximpl(UByte.m2367constructorimpl((byte) data2));
    }

    public static final int toUInt(String str) {
        str.getClass();
        UInt uIntOrNull = toUIntOrNull(str);
        if (uIntOrNull != null) {
            return uIntOrNull.getData();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(str);
        Utf8$$ExternalSyntheticBUOutline0.m();
        return 0;
    }

    public static final UInt toUIntOrNull(String str, int i) {
        int i2;
        str.getClass();
        CharsKt__CharJVMKt.checkRadix(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i3 = 0;
        char cCharAt = str.charAt(0);
        if (Intrinsics.compare((int) cCharAt, 48) < 0) {
            i2 = 1;
            if (length == 1 || cCharAt != '+') {
                return null;
            }
        } else {
            i2 = 0;
        }
        int iM2389constructorimpl = UInt.m2389constructorimpl(i);
        int i4 = 119304647;
        while (i2 < length) {
            int iDigitOf = CharsKt__CharJVMKt.digitOf(str.charAt(i2), i);
            if (iDigitOf < 0) {
                return null;
            }
            int i5 = i3 ^ Integer.MIN_VALUE;
            if (Integer.compare(i5, i4 ^ Integer.MIN_VALUE) > 0) {
                if (i4 == 119304647) {
                    i4 = (int) (4294967295L / (((long) iM2389constructorimpl) & 4294967295L));
                    if (Integer.compare(i5, i4 ^ Integer.MIN_VALUE) > 0) {
                    }
                }
                return null;
            }
            int iM2389constructorimpl2 = UInt.m2389constructorimpl(i3 * iM2389constructorimpl);
            int iM2389constructorimpl3 = UInt.m2389constructorimpl(UInt.m2389constructorimpl(iDigitOf) + iM2389constructorimpl2);
            if (Integer.compare(iM2389constructorimpl3 ^ Integer.MIN_VALUE, iM2389constructorimpl2 ^ Integer.MIN_VALUE) < 0) {
                return null;
            }
            i2++;
            i3 = iM2389constructorimpl3;
        }
        return UInt.m2388boximpl(i3);
    }

    public static final long toULong(String str) {
        str.getClass();
        ULong uLongOrNull = toULongOrNull(str);
        if (uLongOrNull != null) {
            return uLongOrNull.getData();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(str);
        Utf8$$ExternalSyntheticBUOutline0.m();
        return 0L;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0095 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final ULong toULongOrNull(String str, int i) {
        int i2;
        long j;
        str.getClass();
        CharsKt__CharJVMKt.checkRadix(i);
        int length = str.length();
        ULong uLong = null;
        if (length == 0) {
            return null;
        }
        char cCharAt = str.charAt(0);
        int i3 = 1;
        if (Intrinsics.compare((int) cCharAt, 48) >= 0) {
            i2 = 0;
        } else {
            if (length == 1 || cCharAt != '+') {
                return null;
            }
            i2 = 1;
        }
        long jM2411constructorimpl = ULong.m2411constructorimpl(i);
        long j2 = 0;
        long jM2411constructorimpl2 = 0;
        long j3 = 512409557603043100L;
        while (i2 < length) {
            int iDigitOf = CharsKt__CharJVMKt.digitOf(str.charAt(i2), i);
            if (iDigitOf < 0) {
                return uLong;
            }
            ULong uLong2 = uLong;
            long j4 = jM2411constructorimpl2 ^ Long.MIN_VALUE;
            int i4 = i3;
            long j5 = jM2411constructorimpl;
            if (Long.compare(j4, j3 ^ Long.MIN_VALUE) > 0) {
                if (j3 == 512409557603043100L) {
                    if (j5 >= j2) {
                        long j6 = (Long.MAX_VALUE / j5) << i4;
                        j = j6 + ((long) ((((-1) - (j6 * j5)) ^ Long.MIN_VALUE) >= (j5 ^ Long.MIN_VALUE) ? i4 : 0));
                    } else if (Long.MAX_VALUE < (j5 ^ Long.MIN_VALUE)) {
                        j3 = j2;
                        if (Long.compare(j4, j3 ^ Long.MIN_VALUE) > 0) {
                        }
                    } else {
                        j = 1;
                    }
                    j3 = j;
                    if (Long.compare(j4, j3 ^ Long.MIN_VALUE) > 0) {
                    }
                }
                return uLong2;
            }
            long jM2411constructorimpl3 = ULong.m2411constructorimpl(jM2411constructorimpl2 * j5);
            jM2411constructorimpl2 = ULong.m2411constructorimpl(ULong.m2411constructorimpl(((long) UInt.m2389constructorimpl(iDigitOf)) & 4294967295L) + jM2411constructorimpl3);
            if (Long.compare(jM2411constructorimpl2 ^ Long.MIN_VALUE, jM2411constructorimpl3 ^ Long.MIN_VALUE) < 0) {
                return uLong2;
            }
            i2++;
            uLong = uLong2;
            i3 = i4;
            jM2411constructorimpl = j5;
            j2 = 0;
        }
        return ULong.m2410boximpl(jM2411constructorimpl2);
    }

    public static final short toUShort(String str) {
        str.getClass();
        UShort uShortOrNull = toUShortOrNull(str);
        if (uShortOrNull != null) {
            return uShortOrNull.getData();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(str);
        Utf8$$ExternalSyntheticBUOutline0.m();
        return (short) 0;
    }

    public static final UShort toUShortOrNull(String str, int i) {
        str.getClass();
        UInt uIntOrNull = toUIntOrNull(str, i);
        if (uIntOrNull == null) {
            return null;
        }
        int data2 = uIntOrNull.getData();
        if (Integer.compare(data2 ^ Integer.MIN_VALUE, UInt.m2389constructorimpl(65535) ^ Integer.MIN_VALUE) > 0) {
            return null;
        }
        return UShort.m2432boximpl(UShort.m2433constructorimpl((short) data2));
    }

    public static final int toUInt(String str, int i) {
        str.getClass();
        UInt uIntOrNull = toUIntOrNull(str, i);
        if (uIntOrNull != null) {
            return uIntOrNull.getData();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(str);
        Utf8$$ExternalSyntheticBUOutline0.m();
        return 0;
    }

    public static final UByte toUByteOrNull(String str) {
        str.getClass();
        return toUByteOrNull(str, 10);
    }

    public static final UShort toUShortOrNull(String str) {
        str.getClass();
        return toUShortOrNull(str, 10);
    }

    public static final UInt toUIntOrNull(String str) {
        str.getClass();
        return toUIntOrNull(str, 10);
    }

    public static final ULong toULongOrNull(String str) {
        str.getClass();
        return toULongOrNull(str, 10);
    }
}
