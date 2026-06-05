package com.facebook.ads.redexgen.core;

import com.google.common.collect.ElementTypesAreNonnullByDefault;
import com.google.common.collect.ParametricNullness;
import java.util.Arrays;
import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.lr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@ElementTypesAreNonnullByDefault
public abstract class AbstractC1721lr<K, V> implements Map.Entry<K, V> {
    public static byte[] A00;
    public static String[] A01 = {"", "AHmssJtphfILjwQVRES95tupop6kXDQQ", "yJHaEgFHh5vkWuQcGLin5fNpIgHRL", "ccyLBaVl3X5EOQ8kN1enx63wY5xQU5lC", "3LjlCH8sjLmYp1xVnKelHd59e9s4LfUj", "GQEojbmQH74RV7s", "FXhCVdruUKy9z7YPJhdtWoULoWyo0GSZ", "auhNtHWmqaxtUCEmMYI9KHEqFElVZGC8"};

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 113);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{26};
    }

    @Override // java.util.Map.Entry
    @ParametricNullness
    public abstract K getKey();

    @Override // java.util.Map.Entry
    @ParametricNullness
    public abstract V getValue();

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 4 out of bounds for length 4
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    @Override // java.util.Map.Entry
    public int hashCode() {
        K key = getKey();
        V value = getValue();
        return (value != null ? value.hashCode() : 0) ^ (key == null ? 0 : key.hashCode());
    }

    @Override // java.util.Map.Entry
    @ParametricNullness
    public abstract V setValue(@ParametricNullness V value);

    static {
        A02();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.lr != com.google.common.collect.AbstractMapEntry<K, V> */
    @Override // java.util.Map.Entry
    public boolean equals(@CheckForNull Object object) {
        if (!(object instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) object;
        if (!CB.A01(getKey(), entry.getKey())) {
            return false;
        }
        V value = getValue();
        Object value2 = entry.getValue();
        if (A01[0].length() != 0) {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[3] = "YCWNm5eFsX3xC0mwHDsNgk3AXhMAFfWj";
        strArr[6] = "Tjij5fiogIBxnlqsRAm66kaj3TK5HnAa";
        return CB.A01(value, value2);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.lr != com.google.common.collect.AbstractMapEntry<K, V> */
    public final String toString() {
        return getKey() + A01(0, 1, 108) + getValue();
    }
}
