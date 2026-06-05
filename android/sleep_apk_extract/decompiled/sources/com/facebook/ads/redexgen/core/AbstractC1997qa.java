package com.facebook.ads.redexgen.core;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.qa, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a#\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0007¢\u0006\u0004\b\t\u0010\n\u001a5\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\t\u0010\f\u001a~\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0014\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u000f2\u001a\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u00112(\u0010\u0012\u001a$\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u0013H\u0082\b¢\u0006\u0002\u0010\u0014\"\u0018\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"EMPTY", "", "", "[Ljava/lang/Object;", "MAX_SIZE", "", "collectionToArray", "collection", "", "toArray", "(Ljava/util/Collection;)[Ljava/lang/Object;", "a", "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "toArrayImpl", "empty", "Lkotlin/Function0;", "alloc", "Lkotlin/Function1;", "trim", "Lkotlin/Function2;", "(Ljava/util/Collection;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)[Ljava/lang/Object;", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
public abstract class AbstractC1997qa {
    public static byte[] A00;
    public static String[] A01 = {"YRWMBYiInjfQquDkxRxaATvpWTtljPJC", "ofzRm5oD0ZehPjXAXsE4VN9RCemE2t7K", "rA3SUki7nKpweXyrpjsgW", "Q8xFqD15qZ9htNy6CShIJMvcdmz5frjW", "47AxPgGepX47UnNHLVE8SY2HaawvPhh1", "ilOqevOSCglGHIOxiwAEAySXTzWlxd7f", "WuOUZ6PVGszUBtiCu1AXLxWGhthYizTs", "WIuZhNvv8KxyFIlYsT8aGBLDwb7Qt6lT"};
    public static final Object[] A02;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 30);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{108, 96, 99, 99, 106, 108, 123, 102, 96, 97, 26, 22, 9, 0, 54, 31, 81, 87, 87, 87, 80, 123, 96, 121, 121, 53, 118, 116, 123, 123, 122, 97, 53, 119, 112, 53, 118, 116, 102, 97, 53, 97, 122, 53, 123, 122, 123, 56, 123, 96, 121, 121, 53, 97, 108, 101, 112, 53, 126, 122, 97, 121, 124, 123, 59, 84, 103, 103, 116, 108, 41, 126, 122, 97, 121, 124, 123, 59, 84, 123, 108, 42, 43};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 7 out of bounds for length 7
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    @Deprecated(message = "This function will be made internal in a future release")
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.9")
    public static final Object[] A02(Collection<?> collection) {
        C1995qY.A09(collection, A00(0, 10, 17));
        int size = collection.size();
        if (size == 0) {
            return A02;
        }
        Iterator<?> it = collection.iterator();
        if (!it.hasNext()) {
            return A02;
        }
        Object[] objArrCopyOf = new Object[size];
        int i = 0;
        while (true) {
            int i2 = i + 1;
            objArrCopyOf[i] = it.next();
            if (i2 >= objArrCopyOf.length) {
                boolean zHasNext = it.hasNext();
                String[] strArr = A01;
                if (strArr[3].charAt(14) == strArr[1].charAt(14)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A01;
                strArr2[6] = "EScuV0zxhuEvZysc5helwPhrpqvjjBl6";
                strArr2[4] = "HbMMbmPQRBR0PjZnzsYHyu73qTDtUO0T";
                if (!zHasNext) {
                    return objArrCopyOf;
                }
                int i3 = ((i2 * 3) + 1) >>> 1;
                if (i3 <= i2) {
                    if (i2 >= 2147483645) {
                        throw new OutOfMemoryError();
                    }
                    i3 = 2147483645;
                }
                objArrCopyOf = Arrays.copyOf(objArrCopyOf, i3);
                i = i2;
            } else {
                if (!it.hasNext()) {
                    Object[] objArrCopyOf2 = Arrays.copyOf(objArrCopyOf, i2);
                    C1995qY.A08(objArrCopyOf2, A00(10, 11, 103));
                    return objArrCopyOf2;
                }
                i = i2;
            }
        }
    }

    static {
        A01();
        A02 = new Object[0];
    }

    @Deprecated(message = "This function will be made internal in a future release")
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.9")
    public static final Object[] A03(Collection<?> collection, Object[] objArr) {
        Object[] objArrCopyOf;
        C1995qY.A09(collection, A00(0, 10, 17));
        if (objArr != null) {
            int size = collection.size();
            if (size == 0) {
                int $i$f$toArrayImpl = objArr.length;
                if ($i$f$toArrayImpl > 0) {
                    objArr[0] = null;
                }
            } else {
                Iterator<?> it = collection.iterator();
                if (!it.hasNext()) {
                    if (objArr.length > 0) {
                        objArr[0] = null;
                    }
                } else {
                    int length = objArr.length;
                    String[] strArr = A01;
                    String str = strArr[3];
                    String str2 = strArr[1];
                    int size$iv = str.charAt(14);
                    int $i$f$toArrayImpl2 = str2.charAt(14);
                    if (size$iv == $i$f$toArrayImpl2) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A01;
                    strArr2[6] = "lrytJuFjMaT6Yp6XeApmWusax7Y4JpNy";
                    strArr2[4] = "gD4OyNyezD5obJmFstdRZH3h61osYZaN";
                    if (size <= length) {
                        objArrCopyOf = objArr;
                    } else {
                        Object objNewInstance = Array.newInstance(objArr.getClass().getComponentType(), size);
                        C1995qY.A07(objNewInstance, A00(21, 62, 11));
                        objArrCopyOf = (Object[]) objNewInstance;
                    }
                    int size2 = 0;
                    while (true) {
                        int size$iv2 = size2 + 1;
                        objArrCopyOf[size2] = it.next();
                        int $i$f$toArrayImpl3 = objArrCopyOf.length;
                        if (size$iv2 >= $i$f$toArrayImpl3) {
                            if (!it.hasNext()) {
                                return objArrCopyOf;
                            }
                            int $i$f$toArrayImpl4 = size$iv2 * 3;
                            int $i$f$toArrayImpl5 = ($i$f$toArrayImpl4 + 1) >>> 1;
                            if ($i$f$toArrayImpl5 <= size$iv2) {
                                if (size$iv2 < 2147483645) {
                                    $i$f$toArrayImpl5 = 2147483645;
                                } else {
                                    throw new OutOfMemoryError();
                                }
                            }
                            objArrCopyOf = Arrays.copyOf(objArrCopyOf, $i$f$toArrayImpl5);
                            size2 = size$iv2;
                        } else {
                            if (!it.hasNext()) {
                                if (objArrCopyOf == objArr) {
                                    objArr[size$iv2] = null;
                                } else {
                                    objArr = Arrays.copyOf(objArrCopyOf, size$iv2);
                                    String[] strArr3 = A01;
                                    String str3 = strArr3[3];
                                    String str4 = strArr3[1];
                                    int size$iv3 = str3.charAt(14);
                                    int $i$f$toArrayImpl6 = str4.charAt(14);
                                    if (size$iv3 != $i$f$toArrayImpl6) {
                                        Object[] result$iv = A01;
                                        result$iv[3] = "a1CLoXNfwlIpmleoSKN4NkPE1uDxInsC";
                                        result$iv[1] = "wVkQ3LJdF0ZjrFX0fazADLSmSMcjvZac";
                                        C1995qY.A08(objArr, A00(10, 11, 103));
                                    } else {
                                        Object[] result$iv2 = A01;
                                        result$iv2[3] = "wQC4VnYrG9FSwrmyUZJgsxR7nFQ96o5n";
                                        result$iv2[1] = "JKwZ5zO4Pn7yvVfezxQSNQHnVQkdTLIv";
                                        C1995qY.A08(objArr, A00(10, 11, 84));
                                    }
                                }
                                return objArr;
                            }
                            size2 = size$iv2;
                        }
                    }
                }
            }
            return objArr;
        }
        throw new NullPointerException();
    }
}
