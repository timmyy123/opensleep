package com.facebook.ads.redexgen.core;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class P8<K, V> implements Set<Map.Entry<K, V>> {
    public static String[] A01 = {"YtNF8b8ioPsgGgaDUde7WsjUMR00Jzoy", "ONmCOidcB6U5WZLM0OONVLfChSccD2jC", "SJu8u5Zh6YlgArwXrUirNpL4997vCJ", "nE4owr1wlu2VobktzduoSxTpcn75jZ1P", "qSRAP7Al4GPL3nfNBbzCOWjKh9ZAaoHj", "", "XO0jmWeq4", "JpA0oM1ow"};
    public final /* synthetic */ PC A00;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 7 out of bounds for length 7
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    @Override // java.util.Set, java.util.Collection
    public final boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
        int iA04 = this.A00.A04();
        for (Map.Entry<K, V> entry : collection) {
            this.A00.A0F(entry.getKey(), entry.getValue());
        }
        return iA04 != this.A00.A04();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.P8 != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
    public P8(PC pc) {
        this.A00 = pc;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.P8 != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
    private final boolean A00(@Nullable Map.Entry<K, V> object) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.P8 != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ /* synthetic */ boolean add(@Nullable Object obj) {
        A00((Map.Entry) obj);
        throw null;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.P8 != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
    @Override // java.util.Set, java.util.Collection
    public final void clear() {
        this.A00.A0D();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.P8 != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
    @Override // java.util.Set, java.util.Collection
    public final boolean contains(@Nullable Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        int index = this.A00.A05(entry.getKey());
        if (index < 0) {
            return false;
        }
        Object foundVal = this.A00.A0B(index, 1);
        return P5.A04(foundVal, entry.getValue());
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.P8 != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
    @Override // java.util.Set, java.util.Collection
    public final boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.P8 != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
    @Override // java.util.Set, java.util.Collection
    public final boolean equals(Object obj) {
        return PC.A03(this, obj);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.P8 != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
    @Override // java.util.Set, java.util.Collection
    public final int hashCode() {
        int i = 0;
        for (int iA04 = this.A00.A04() - 1; iA04 >= 0; iA04--) {
            PC pc = this.A00;
            String[] strArr = A01;
            String str = strArr[6];
            String str2 = strArr[7];
            int i2 = str.length();
            int result = str2.length();
            if (i2 != result) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[6] = "tAEwYau76";
            strArr2[7] = "8QLk4N8pE";
            int iHashCode = 0;
            Object objA0B = pc.A0B(iA04, 0);
            Object objA0B2 = this.A00.A0B(iA04, 1);
            int i3 = objA0B == null ? 0 : objA0B.hashCode();
            if (objA0B2 != null) {
                iHashCode = objA0B2.hashCode();
            }
            i += iHashCode ^ i3;
        }
        return i;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.P8 != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
    @Override // java.util.Set, java.util.Collection
    public final boolean isEmpty() {
        return this.A00.A04() == 0;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.P8 != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public final Iterator<Map.Entry<K, V>> iterator() {
        return new PA(this.A00);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.P8 != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
    @Override // java.util.Set, java.util.Collection
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.P8 != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
    @Override // java.util.Set, java.util.Collection
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.P8 != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
    @Override // java.util.Set, java.util.Collection
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.P8 != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
    @Override // java.util.Set, java.util.Collection
    public final int size() {
        return this.A00.A04();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.P8 != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.P8 != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
    @Override // java.util.Set, java.util.Collection
    public final <T> T[] toArray(T[] array) {
        throw new UnsupportedOperationException();
    }
}
