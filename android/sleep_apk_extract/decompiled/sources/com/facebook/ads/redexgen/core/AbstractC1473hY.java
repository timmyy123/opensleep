package com.facebook.ads.redexgen.core;

import java.util.Arrays;
import java.util.Formattable;
import java.util.MissingFormatArgumentException;
import java.util.UnknownFormatConversionException;
import javax.annotation.Nullable;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.hY, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1473hY {
    public static byte[] A00;
    public static String[] A01 = {"8Sd1qkECxTgChNdlguLEZkZWMegMfOE5", "eE6tYG5sq9M8IjBBtVPbkf6Vz6TlptaI", "QOK7QojphBw5FabNaFdniimN5leZGYDr", "7RC2mif7S53CKwDAOZDI7R724V8msIlw", "uAGCbL6a5SqKA6tsA4uR", "AhKYWwBlorMFpY7WjQZRM9a3PetGdW8", "8WuUCWPLRijzu2iy4u5OiIf4MXR0TAdJ", "jN3W5Bup4fcwVqh0edpT69G47IDoXIn2"};
    public static final Object[] A02;

    public static String A0G(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A01[6].charAt(15) == 'n') {
                throw new RuntimeException();
            }
            A01[1] = "skGE7NcFmlK9UGwd3HQe5P1GOhX2S0Sv";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 14);
            i4++;
        }
    }

    public static void A0L() {
        A00 = new byte[]{-117, 113, -35, -14, -7, -1, -10, -18, -86, -8, -7, -2, -86, -20, -17, -86, -8, -1, -10, -10, -86, -1, -8, -18, -17, -4, -86, -8, -7, -4, -9, -21, -10, -86, -19, -13, -4, -19, -1, -9, -3, -2, -21, -8, -19, -17, -3, -43, -36, -45, -45};
    }

    static {
        A0L();
        A02 = new Object[]{null};
    }

    public static int A00(String str) {
        return A0C(null, str, 0, null, null, null, null);
    }

    public static int A01(String str, int i) {
        int length = str.length();
        char ch = 0;
        while (i < length) {
            int index = str.charAt(i);
            if (index == 37) {
                int formatLen = A02(str, i);
                if (formatLen == -100) {
                    int index2 = i + 1;
                    if (str.charAt(index2) == 37) {
                        i++;
                        ch = 1;
                    } else {
                        int index3 = i + 2;
                        return index3;
                    }
                } else {
                    continue;
                }
            }
            i++;
        }
        return ch != 0 ? -201 : -200;
    }

    public static int A02(String str, int i) {
        int i2 = i + 1;
        int nextIndex = str.length();
        if (nextIndex > i2) {
            char cCharAt = str.charAt(i2);
            if (cCharAt == 's' || cCharAt == 'd') {
                return -100;
            }
            char nextChar = A01[6].charAt(15);
            if (nextChar == 'n') {
                throw new RuntimeException();
            }
            A01[1] = "DuYzmbbLi8NR0v6nZg86VBAdA9cmFFLr";
            if (cCharAt == '%') {
                return -100;
            }
            return -101;
        }
        return -101;
    }

    public static int A03(@Nullable String str, @Nullable int i, @Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, Object obj4, Object[] objArr) {
        switch (i) {
            case 0:
                return A00(str);
            case 1:
                return A04(str, obj);
            case 2:
                return A05(str, obj, obj2);
            case 3:
                return A06(str, obj, obj2, obj3);
            case 4:
                return A07(str, obj, obj2, obj3, obj4);
            default:
                return A08(str, objArr);
        }
    }

    public static int A04(@Nullable String str, Object obj) {
        return A0C(null, str, 1, obj, null, null, null);
    }

    public static int A05(@Nullable String str, @Nullable Object obj, Object obj2) {
        return A0C(null, str, 2, obj, obj2, null, null);
    }

    public static int A06(@Nullable String str, @Nullable Object obj, @Nullable Object obj2, Object obj3) {
        return A0C(null, str, 3, obj, obj2, obj3, null);
    }

    public static int A07(@Nullable String str, @Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, Object obj4) {
        return A0C(null, str, 4, obj, obj2, obj3, obj4);
    }

    public static int A08(@Nullable String str, Object[] objArr) {
        return A0F(null, str, objArr);
    }

    public static int A09(@Nullable StringBuilder sb, @Nullable Object obj) {
        int i = 0;
        if (obj == null) {
            String strA0G = A0G(47, 4, 89);
            if (sb == null) {
                int length = strA0G.length();
                i = 0 + length;
            } else {
                sb.append(strA0G);
            }
        } else {
            boolean z = obj instanceof Integer;
            if (A01[1].charAt(0) != 'K') {
                A01[6] = "qj7fRfmIIB6kzsQFMAkTgCFneI3s8jGM";
                if (z) {
                    if (sb == null) {
                        i = 0 + 11;
                    } else if (A01[6].charAt(15) != 'n') {
                        A01[6] = "O4ypdRTgmt7luw9ydfRW3B9AFY3tOHa9";
                        int length2 = ((Number) obj).intValue();
                        sb.append(length2);
                    } else {
                        int length3 = ((Number) obj).intValue();
                        sb.append(length3);
                    }
                } else if (obj instanceof Short) {
                    if (sb == null) {
                        i = 0 + 6;
                    } else {
                        int length4 = ((Number) obj).intValue();
                        sb.append(length4);
                    }
                } else {
                    boolean z2 = obj instanceof Byte;
                    if (A01[4].length() != 19) {
                        String[] strArr = A01;
                        strArr[3] = "csKQFPsvsd8Y7y0GZsslTGMfIZRxrswf";
                        strArr[2] = "wF53Kmv7ZDAYUPjR0E2wAbKHzATsDJ47";
                        if (z2) {
                            if (sb == null) {
                                i = 0 + 4;
                            } else {
                                int length5 = ((Number) obj).intValue();
                                sb.append(length5);
                            }
                        } else if (obj instanceof Long) {
                            if (sb == null) {
                                i = 0 + 20;
                            } else {
                                sb.append(((Long) obj).longValue());
                            }
                        } else {
                            if (sb == null) {
                                return -1;
                            }
                            throw new AssertionError();
                        }
                    }
                }
            }
            throw new RuntimeException();
        }
        if (sb == null) {
            return i;
        }
        return -3;
    }

    public static int A0A(@Nullable StringBuilder sb, @Nullable Object obj) {
        if (obj instanceof Formattable) {
            if (sb == null) {
                return -1;
            }
            throw new AssertionError();
        }
        String string = null;
        if (obj instanceof String) {
            string = (String) obj;
        } else if (obj != null) {
            string = obj.toString();
        }
        if (string == null) {
            string = A0G(47, 4, 89);
        }
        if (sb == null) {
            return string.length();
        }
        sb.append(string);
        return -3;
    }

    public static int A0B(@Nullable StringBuilder sb, String str, int i, int i2, boolean z) {
        int length = str.length();
        int i3 = 0;
        while (i < length) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '%') {
                int formatLen = i + 1;
                if (length > formatLen) {
                    int formatLen2 = i + 1;
                    if (str.charAt(formatLen2) == 37) {
                        i++;
                    }
                }
                if (!z) {
                    throw new AssertionError();
                }
                int index = A01[6].charAt(15);
                if (index == 110) {
                    throw new RuntimeException();
                }
                A01[1] = "fVpeC838v4d09FxkUxUgJ6CBFHJaQPQZ";
                return -1;
            }
            if (sb == null) {
                i3++;
            } else {
                sb.append(cCharAt);
            }
            i++;
        }
        if (z) {
            return i2 + i3;
        }
        return -3;
    }

    public static int A0C(@Nullable StringBuilder sb, @Nullable String str, @Nullable int i, @Nullable Object obj, @Nullable Object obj2, Object obj3, Object obj4) {
        int i2;
        int iA01 = 0;
        int i3 = 0;
        boolean z = sb == null;
        int i4 = i == 0 ? -1 : 0;
        int length = A01[4].length();
        if (length == 19) {
            throw new RuntimeException();
        }
        A01[7] = "8ynbtcYvJcGQo99l12TWemlAPLQxISIP";
        int segIdx = i4;
        while (true) {
            if (segIdx < i) {
                int argIdx = segIdx;
                int iA0D = A0D(sb, str, iA01, obj, obj2, obj3, obj4, argIdx);
                if (iA0D == -1) {
                    return -1;
                }
                if (z) {
                    i3 += iA0D;
                }
                iA01 = A01(str, iA01);
                if (segIdx == i4) {
                    i2 = -200;
                    if (iA01 == -200 && z) {
                        return -2;
                    }
                } else {
                    i2 = -200;
                }
                if (iA01 < 0) {
                    break;
                }
                segIdx++;
            } else {
                i2 = -200;
                break;
            }
        }
        if (iA01 == i2 || iA01 == -201) {
            if (z) {
                return i3;
            }
            return -3;
        }
        return A0B(sb, str, iA01, i3, z);
    }

    public static int A0D(@Nullable StringBuilder sb, @Nullable String str, @Nullable int i, @Nullable Object obj, @Nullable Object obj2, Object obj3, Object obj4, int i2) {
        switch (i2) {
            case -1:
                return A0E(sb, str, i, null, false);
            case 0:
                return A0E(sb, str, i, obj, true);
            case 1:
                return A0E(sb, str, i, obj2, true);
            case 2:
                int iA0E = A0E(sb, str, i, obj3, true);
                if (A01[1].charAt(0) == 'K') {
                    throw new RuntimeException();
                }
                A01[1] = "lLENtgmJN01kc6wViYFGzWwEkJhXf84x";
                return iA0E;
            case 3:
                return A0E(sb, str, i, obj4, true);
            default:
                throw new AssertionError();
        }
    }

    public static int A0E(@Nullable StringBuilder sb, @Nullable String str, int i, Object obj, boolean z) {
        int index;
        int length = str.length();
        int i2 = 0;
        while (i < length) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '%') {
                if (A02(str, i) != -100) {
                    return -1;
                }
                int index2 = i + 1;
                int length2 = str.charAt(index2);
                if (!z && length2 != 37) {
                    return -1;
                }
                int formatLen = 1;
                if (length2 == 115) {
                    index = A0A(sb, obj);
                } else if (length2 == 100) {
                    index = A09(sb, obj);
                } else if (length2 == 37) {
                    formatLen = 0;
                    if (sb != null) {
                        sb.append('%');
                    }
                    index = 1;
                    i++;
                } else {
                    index = -1;
                }
                if (index == -1) {
                    return -1;
                }
                if (sb == null) {
                    i2 += index;
                }
                if (formatLen != 0) {
                    break;
                }
            } else if (sb == null) {
                i2++;
            } else {
                sb.append(cCharAt);
            }
            i++;
        }
        if (sb == null) {
            return i2;
        }
        return -3;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x000c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int A0F(@Nullable StringBuilder sb, @Nullable String str, Object... objArr) {
        int iA01 = 0;
        int i = 0;
        int i2 = 0;
        boolean argsWasEmpty = sb == null;
        boolean z = false;
        if (objArr != null) {
            int segIdx = objArr.length;
            if (segIdx == 0) {
                objArr = A02;
                if (A01[0].charAt(8) == 103) {
                    throw new RuntimeException();
                }
                A01[4] = "FyR6wqN";
                z = true;
            }
        }
        boolean z2 = false;
        int length = objArr.length;
        while (true) {
            if (i2 < length) {
                int length2 = A0E(sb, str, iA01, objArr[i2], !z);
                if (length2 == -1) {
                    return -1;
                }
                if (argsWasEmpty) {
                    i += length2;
                }
                iA01 = A01(str, iA01);
                if (iA01 == -200) {
                    break;
                }
                if (iA01 == -201) {
                    z2 = true;
                    break;
                }
                z2 = true;
                i2++;
            } else {
                break;
            }
        }
        if (argsWasEmpty && !z2) {
            return -2;
        }
        if (iA01 == -200 || iA01 == -201) {
            if (argsWasEmpty) {
                return i;
            }
            return -3;
        }
        int segIdx2 = A0B(sb, str, iA01, i, argsWasEmpty);
        return segIdx2;
    }

    public static String A0H(@Nullable String str, @Nullable int i, @Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, Object obj4, Object[] objArr) {
        switch (i) {
            case 0:
                return A0K(str, new Object[0]);
            case 1:
                return A0K(str, obj);
            case 2:
                return A0K(str, obj, obj2);
            case 3:
                Object[] objArr2 = {obj, obj2, obj3};
                if (A01[6].charAt(15) == 'n') {
                    throw new RuntimeException();
                }
                A01[0] = "XCWvLacnK9ECASwOW0Hv8sDP0GvXvxfm";
                return A0K(str, objArr2);
            case 4:
                return A0K(str, obj, obj2, obj3, obj4);
            default:
                return A0K(str, objArr);
        }
    }

    public static String A0I(@Nullable String str, @Nullable int i, @Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, Object obj4, Object[] objArr) {
        int iA03 = A03(str, i, obj, obj2, obj3, obj4, objArr);
        if (iA03 == -1) {
            return A0H(str, i, obj, obj2, obj3, obj4, objArr);
        }
        if (iA03 == -2) {
            return str;
        }
        StringBuilder sb = new StringBuilder(iA03);
        if (i == -1) {
            A0F(sb, str, objArr);
        } else {
            A0C(sb, str, i, obj, obj2, obj3, obj4);
        }
        return sb.toString();
    }

    public static String A0J(@Nullable String str, Object obj) {
        return A0I(str, 1, obj, null, null, null, null);
    }

    public static String A0K(@Nullable String str, Object... objArr) {
        try {
            return String.format(null, str, (Object[]) AbstractC1482hi.A00(objArr, A0G(2, 45, 124)));
        } catch (MissingFormatArgumentException | UnknownFormatConversionException ex) {
            throw new RuntimeException(ex.getMessage() + A0G(0, 2, 67) + str);
        }
    }
}
