package kotlin.uuid;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import kotlin.Metadata;
import kotlin.text.HexExtensionsKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0010\t\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0001\n\u0002\b\u0003\u001a3\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\b\u0010\t\u001a\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0001¢\u0006\u0004\b\r\u0010\u000e\u001a\u0017\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\nH\u0001¢\u0006\u0004\b\u0010\u0010\u000e\u001a\u001b\u0010\u0014\u001a\u00020\n*\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001a'\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"", "", "dst", "", "dstOffset", "startIndex", "endIndex", "", "formatBytesIntoCommonImpl", "(J[BIII)V", "", "hexDashString", "Lkotlin/uuid/Uuid;", "uuidParseHexDashCommonImpl", "(Ljava/lang/String;)Lkotlin/uuid/Uuid;", "hexString", "uuidParseHexCommonImpl", "maxLength", "truncateForErrorMessage$UuidKt__UuidKt", "(Ljava/lang/String;I)Ljava/lang/String;", "truncateForErrorMessage", "inputString", "errorDescription", "errorIndex", "", "uuidThrowUnexpectedCharacterException", "(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/Void;", "kotlin-stdlib"}, k = 5, mv = {2, 3, 0}, xi = 49, xs = "kotlin/uuid/UuidKt")
abstract class UuidKt__UuidKt extends UuidKt__UuidJVMKt {
    public static final void formatBytesIntoCommonImpl(long j, byte[] bArr, int i, int i2, int i3) {
        bArr.getClass();
        int i4 = 7 - i2;
        int i5 = 8 - i3;
        if (i5 > i4) {
            return;
        }
        while (true) {
            int i6 = HexExtensionsKt.getBYTE_TO_LOWER_CASE_HEX_DIGITS()[(int) ((j >> (i4 << 3)) & 255)];
            int i7 = i + 1;
            bArr[i] = (byte) (i6 >> 8);
            i += 2;
            bArr[i7] = (byte) i6;
            if (i4 == i5) {
                return;
            } else {
                i4--;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String truncateForErrorMessage$UuidKt__UuidKt(String str, int i) {
        return str.length() <= i ? str : str.substring(0, i).concat("...");
    }

    public static final Uuid uuidParseHexCommonImpl(String str) {
        str.getClass();
        int i = 0;
        long j = 0;
        while (true) {
            if (i >= 16) {
                long j2 = 0;
                for (int i2 = 16; i2 < 32; i2++) {
                    long j3 = j2 << 4;
                    char cCharAt = str.charAt(i2);
                    if ((cCharAt >>> '\b') != 0 || HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[cCharAt] < 0) {
                        uuidThrowUnexpectedCharacterException(str, "a hexadecimal digit", i2);
                    } else {
                        j2 = j3 | HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[cCharAt];
                    }
                }
                return Uuid.INSTANCE.fromLongs(j, j2);
            }
            long j4 = j << 4;
            char cCharAt2 = str.charAt(i);
            if ((cCharAt2 >>> '\b') != 0 || HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[cCharAt2] < 0) {
                break;
            }
            j = j4 | HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[cCharAt2];
            i++;
        }
        uuidThrowUnexpectedCharacterException(str, "a hexadecimal digit", i);
        Utf8$$ExternalSyntheticBUOutline0.m();
        return null;
    }

    public static final Uuid uuidParseHexDashCommonImpl(String str) {
        str.getClass();
        int i = 0;
        long j = 0;
        while (true) {
            int i2 = 8;
            if (i < 8) {
                long j2 = j << 4;
                char cCharAt = str.charAt(i);
                if ((cCharAt >>> '\b') != 0 || HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[cCharAt] < 0) {
                    break;
                }
                j = j2 | HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[cCharAt];
                i++;
            } else {
                if (str.charAt(8) == '-') {
                    i = 9;
                    long j3 = 0;
                    while (true) {
                        i2 = 13;
                        if (i < 13) {
                            long j4 = j3 << 4;
                            char cCharAt2 = str.charAt(i);
                            if ((cCharAt2 >>> '\b') != 0 || HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[cCharAt2] < 0) {
                                break;
                            }
                            j3 = j4 | HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[cCharAt2];
                            i++;
                        } else if (str.charAt(13) == '-') {
                            i = 14;
                            long j5 = 0;
                            while (true) {
                                i2 = 18;
                                if (i < 18) {
                                    long j6 = j5 << 4;
                                    char cCharAt3 = str.charAt(i);
                                    if ((cCharAt3 >>> '\b') != 0 || HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[cCharAt3] < 0) {
                                        break;
                                    }
                                    j5 = j6 | HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[cCharAt3];
                                    i++;
                                } else if (str.charAt(18) == '-') {
                                    i = 19;
                                    long j7 = 0;
                                    while (true) {
                                        i2 = 23;
                                        if (i < 23) {
                                            long j8 = j7 << 4;
                                            char cCharAt4 = str.charAt(i);
                                            if ((cCharAt4 >>> '\b') != 0 || HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[cCharAt4] < 0) {
                                                break;
                                            }
                                            j7 = j8 | HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[cCharAt4];
                                            i++;
                                        } else if (str.charAt(23) == '-') {
                                            i = 24;
                                            long j9 = 0;
                                            while (i < 36) {
                                                long j10 = j9 << 4;
                                                char cCharAt5 = str.charAt(i);
                                                if ((cCharAt5 >>> '\b') == 0 && HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[cCharAt5] >= 0) {
                                                    j9 = j10 | HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[cCharAt5];
                                                    i++;
                                                }
                                            }
                                            return Uuid.INSTANCE.fromLongs((j << 32) | (j3 << 16) | j5, (j7 << 48) | j9);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                uuidThrowUnexpectedCharacterException(str, "'-' (hyphen)", i2);
            }
        }
        uuidThrowUnexpectedCharacterException(str, "a hexadecimal digit", i);
        Utf8$$ExternalSyntheticBUOutline0.m();
        return null;
    }

    public static final Void uuidThrowUnexpectedCharacterException(String str, String str2, int i) {
        str.getClass();
        str2.getClass();
        StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(i, "Expected ", str2, " at index ", ", but was '");
        sbM.append(str.charAt(i));
        sbM.append('\'');
        throw new IllegalArgumentException(sbM.toString());
    }
}
