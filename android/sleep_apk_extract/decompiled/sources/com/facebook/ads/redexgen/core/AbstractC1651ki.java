package com.facebook.ads.redexgen.core;

import com.google.common.base.ElementTypesAreNonnullByDefault;
import com.google.common.base.Strings;
import java.util.Arrays;
import javax.annotation.CheckForNull;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ki, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@ElementTypesAreNonnullByDefault
public abstract class AbstractC1651ki {
    public static byte[] A00;
    public static String[] A01 = {"rIY6scqdx44s0lYhNsVasOWOliCxkCUS", "XG17z2bEBjC2W", "Vem1quc5hPIJuUrE", "UcFFOKOZJEGoXQOYNnqMCDDpRLrphEx7", "nkZ3L4NSKd4uHuOS6chXEBDQJqUE8doa", "6xQ37guYp3oV6tn7J9L0pQx9gviAFZKh", "Tb0XI9b9KZ2bW8CyI06iyuXMMlzfJONe", "u0lWMQq9JRx7ZEcoLF7IwO0fOB8k5dGw"};

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 1 out of bounds for length 1
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static <T> T A04(@CheckForNull T reference) {
        if (reference != null) {
            return reference;
        }
        throw new NullPointerException();
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 2 out of bounds for length 2
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static <T> T A05(@CheckForNull T reference, @CheckForNull Object errorMessage) {
        if (reference != null) {
            return reference;
        }
        throw new NullPointerException(String.valueOf(errorMessage));
    }

    public static String A06(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            byte b = bArrCopyOfRange[i4];
            String[] strArr = A01;
            if (strArr[0].charAt(16) != strArr[3].charAt(16)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[1] = "4hJwB50Ffda8q";
            strArr2[2] = "BvOy7f3XfmcoPFEY";
            bArrCopyOfRange[i4] = (byte) ((b ^ i3) ^ 108);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0A() {
        A00 = new byte[]{35, 117, 38, 46, 35, 117, 47, 38, 107, 115, 117, 114, 38, 100, 99, 38, 106, 99, 117, 117, 38, 114, 110, 103, 104, 38, 117, 111, 124, 99, 38, 46, 35, 117, 47, 38, 112, 35, 43, 38, 112, 42, 35, 110, 118, 112, 119, 35, 109, 108, 119, 35, 97, 102, 35, 100, 113, 102, 98, 119, 102, 113, 35, 119, 107, 98, 109, 35, 112, 106, 121, 102, 35, 43, 38, 112, 42, 59, 109, 62, 54, 59, 109, 55, 62, 115, 107, 109, 106, 62, 112, 113, 106, 62, 124, 123, 62, 112, 123, 121, 127, 106, 119, 104, 123, 50, 57, 51, 119, 62, 57, 51, 50, 47, 114, 121, 115, 55, 126, 121, 115, 114, 111, 55, 63, 50, 100, 62, 55, 122, 98, 100, 99, 55, 121, 120, 99, 55, 117, 114, 55, 123, 114, 100, 100, 55, 99, 127, 118, 121, 55, 100, 99, 118, 101, 99, 55, 126, 121, 115, 114, 111, 55, 63, 50, 100, 62, 122, 125, 119, 118, 107, 57, 50, 48, 54, 35, 62, 33, 50, 119, 36, 62, 45, 50, 109, 119, 127, 120, 109, 126, 120, 44, 101, 98, 104, 105, 116};
    }

    static {
        A0A();
    }

    public static int A00(int index, int size) {
        return A02(index, size, A06(167, 5, 127));
    }

    public static int A01(int index, int size) {
        return A03(index, size, A06(167, 5, 127));
    }

    public static int A02(int index, int size, String desc) {
        if (index >= 0 && index < size) {
            return index;
        }
        throw new IndexOutOfBoundsException(A08(index, size, desc));
    }

    public static int A03(int index, int size, String desc) {
        if (index >= 0 && index <= size) {
            return index;
        }
        throw new IndexOutOfBoundsException(A09(index, size, desc));
    }

    public static String A07(int start, int end, int size) {
        if (start < 0 || start > size) {
            return A09(start, size, A06(187, 11, 96));
        }
        return (end < 0 || end > size) ? A09(end, size, A06(105, 9, 59)) : Strings.A02(A06(114, 53, 123), new Object[]{Integer.valueOf(end), Integer.valueOf(start)});
    }

    public static String A08(int index, int size, String desc) {
        if (index < 0) {
            return Strings.A02(A06(77, 28, 114), new Object[]{desc, Integer.valueOf(index)});
        }
        if (size >= 0) {
            return Strings.A02(A06(0, 35, 106), new Object[]{desc, Integer.valueOf(index), Integer.valueOf(size)});
        }
        throw new IllegalArgumentException(A06(172, 15, 59) + size);
    }

    public static String A09(int index, int size, String desc) {
        if (index < 0) {
            return Strings.A02(A06(77, 28, 114), new Object[]{desc, Integer.valueOf(index)});
        }
        if (size >= 0) {
            return Strings.A02(A06(35, 42, 111), new Object[]{desc, Integer.valueOf(index), Integer.valueOf(size)});
        }
        throw new IllegalArgumentException(A06(172, 15, 59) + size);
    }

    public static void A0B(int start, int end, int size) {
        if (start >= 0 && end >= start && end <= size) {
        } else {
            throw new IndexOutOfBoundsException(A07(start, end, size));
        }
    }

    public static void A0C(boolean expression) {
        if (expression) {
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static void A0D(boolean expression) {
        if (expression) {
        } else {
            throw new IllegalStateException();
        }
    }

    public static void A0E(@CheckForNull boolean expression, Object errorMessage) {
        if (expression) {
        } else {
            throw new IllegalArgumentException(String.valueOf(errorMessage));
        }
    }

    public static void A0F(@CheckForNull boolean expression, Object errorMessage) {
        if (expression) {
        } else {
            throw new IllegalStateException(String.valueOf(errorMessage));
        }
    }

    public static void A0G(boolean expression, String errorMessageTemplate, int p1, int p2) {
        if (!expression) {
            throw new IllegalArgumentException(Strings.A02(errorMessageTemplate, new Object[]{Integer.valueOf(p1), Integer.valueOf(p2)}));
        }
    }

    public static void A0H(boolean expression, String errorMessageTemplate, long p1) {
        if (!expression) {
            throw new IllegalArgumentException(Strings.A02(errorMessageTemplate, new Object[]{Long.valueOf(p1)}));
        }
    }
}
