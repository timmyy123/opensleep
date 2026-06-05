package com.facebook.ads.redexgen.core;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.pm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1949pm<K, V> extends AbstractCollection<V> {
    public static String[] A01 = {"in42tJQ01GZUPWpapY3GS1ba37Q621he", "aDWnks8SkwEFtMvER77PJBAmsGMrEJ6D", "AX4wQMRLKDeL8ngjMfYHLQFqA74wDV2X", "9hok8rTzZXESykboyURYSAJr5s9hilMu", "9Zv0w4TVYcP2oQrIhtVpC4IoTwCIn61q", "DtsNkjQzxYFKhoARFm7ioA0etAdT1uIj", "Qm8i24sVu4QbvSFZB0Cqa", "BgiAdgr6UkIVh80noo0NQyRYH0DUUQhv"};
    public final Map<K, V> A00;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 6 out of bounds for length 6
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection<?> c) {
        try {
            return super.retainAll((Collection) AbstractC1651ki.A04(c));
        } catch (UnsupportedOperationException unused) {
            HashSet hashSetA05 = AbstractC2004qj.A05();
            for (Map.Entry<K, V> entry : A00().entrySet()) {
                if (c.contains(entry.getValue())) {
                    hashSetA05.add(entry.getKey());
                }
            }
            return A00().keySet().retainAll(hashSetA05);
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.pm != com.google.common.collect.Maps$Values<K, V> */
    public C1949pm(Map<K, V> map) {
        this.A00 = (Map) AbstractC1651ki.A04(map);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.pm != com.google.common.collect.Maps$Values<K, V> */
    private final Map<K, V> A00() {
        return this.A00;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.pm != com.google.common.collect.Maps$Values<K, V> */
    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        A00().clear();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.pm != com.google.common.collect.Maps$Values<K, V> */
    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@CheckForNull Object o) {
        return A00().containsValue(o);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.pm != com.google.common.collect.Maps$Values<K, V> */
    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return A00().isEmpty();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.pm != com.google.common.collect.Maps$Values<K, V> */
    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<V> iterator() {
        return AbstractC1951po.A03(A00().entrySet().iterator());
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.pm != com.google.common.collect.Maps$Values<K, V> */
    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(@CheckForNull Object o) {
        Map.Entry<K, V> entry;
        try {
            return super.remove(o);
        } catch (UnsupportedOperationException unused) {
            Map<K, V> mapA00 = A00();
            if (A01[6].length() == 21) {
                A01[6] = "aipsxbSp1tnZ2v2drkTfU";
                Iterator<Map.Entry<K, V>> it = mapA00.entrySet().iterator();
                do {
                    boolean zHasNext = it.hasNext();
                    String[] strArr = A01;
                    if (strArr[1].charAt(18) == strArr[5].charAt(18)) {
                        String[] strArr2 = A01;
                        strArr2[0] = "hJKuR3xA1w5y7oQ8WRbWSr1qNuhor3Na";
                        strArr2[3] = "kTeXKTesQI660Qr0JB9qS0JQxEcCo8pe";
                        if (!zHasNext) {
                            String[] strArr3 = A01;
                            if (strArr3[1].charAt(18) != strArr3[5].charAt(18)) {
                                A01[6] = "IeB1biIWoxDuKDO5ci7KI";
                                return false;
                            }
                            A01[6] = "wnKimEEcKP0TlLR5z0mvC";
                            return false;
                        }
                        entry = it.next();
                    }
                } while (!CB.A01(o, entry.getValue()));
                A00().remove(entry.getKey());
                return true;
            }
            throw new RuntimeException();
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.pm != com.google.common.collect.Maps$Values<K, V> */
    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection<?> c) {
        try {
            return super.removeAll((Collection) AbstractC1651ki.A04(c));
        } catch (UnsupportedOperationException unused) {
            HashSet hashSetA05 = AbstractC2004qj.A05();
            Set<Map.Entry<K, V>> setEntrySet = A00().entrySet();
            String[] strArr = A01;
            if (strArr[2].charAt(30) == strArr[7].charAt(30)) {
                throw new RuntimeException();
            }
            A01[6] = "ER1uMOhoexHNMxXkTRXkp";
            for (Map.Entry<K, V> entry : setEntrySet) {
                if (c.contains(entry.getValue())) {
                    hashSetA05.add(entry.getKey());
                }
            }
            return A00().keySet().removeAll(hashSetA05);
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.pm != com.google.common.collect.Maps$Values<K, V> */
    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return A00().size();
    }
}
