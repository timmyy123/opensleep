package com.facebook.ads.redexgen.core;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: Add missing generic type declarations: [K] */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class P9<K> implements Set<K> {
    public static String[] A01 = {"edFq1RSzVbogperxRnGO2mwS9T0C3jXY", "CE90aEI9KYNoN0DMFbwcn9PMt89CsnEy", "tPPb", "CijerYzHuYsgCporrbQrcy6DwpkaY1hX", "Nwp2N8bBhYR0nMsdl7Yct", "Yte1vUSgji4S3VNobeKxGdrgBkFaACT", "hyxYDNsU9Fu2EdzaavUXH", "kSbZdYOgqhrWj8RnTgPZsuZs4QqXHZoL"};
    public final /* synthetic */ PC A00;

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.P9 != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
    public P9(PC pc) {
        this.A00 = pc;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.P9 != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
    @Override // java.util.Set, java.util.Collection
    public final boolean add(@Nullable K object) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.P9 != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
    @Override // java.util.Set, java.util.Collection
    public final boolean addAll(Collection<? extends K> collection) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.P9 != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
    @Override // java.util.Set, java.util.Collection
    public final void clear() {
        this.A00.A0D();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.P9 != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
    @Override // java.util.Set, java.util.Collection
    public final boolean contains(@Nullable Object obj) {
        return this.A00.A05(obj) >= 0;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.P9 != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
    @Override // java.util.Set, java.util.Collection
    public final boolean containsAll(Collection<?> collection) {
        return PC.A00(this.A00.A07(), collection);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.P9 != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
    @Override // java.util.Set, java.util.Collection
    public final boolean equals(Object obj) {
        return PC.A03(this, obj);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.P9 != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
    @Override // java.util.Set, java.util.Collection
    public final int hashCode() {
        int i = 0;
        int result = this.A00.A04();
        for (int i2 = result - 1; i2 >= 0; i2--) {
            int i3 = 0;
            Object objA0B = this.A00.A0B(i2, 0);
            if (objA0B != null) {
                i3 = objA0B.hashCode();
            }
            i += i3;
        }
        return i;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.P9 != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
    @Override // java.util.Set, java.util.Collection
    public final boolean isEmpty() {
        return this.A00.A04() == 0;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.P9 != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public final Iterator<K> iterator() {
        return new P7(this.A00, 0);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.P9 != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
    @Override // java.util.Set, java.util.Collection
    public final boolean remove(Object obj) {
        int iA05 = this.A00.A05(obj);
        if (iA05 >= 0) {
            this.A00.A0E(iA05);
            String[] strArr = A01;
            String str = strArr[1];
            String str2 = strArr[2];
            int length = str.length();
            int index = str2.length();
            if (length == index) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[4] = "xtpBes5HGReh40nAQqVKY";
            strArr2[6] = "hpfnMqiRo4gFf5SPN0UOy";
            return true;
        }
        return false;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.P9 != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
    @Override // java.util.Set, java.util.Collection
    public final boolean removeAll(Collection<?> collection) {
        return PC.A01(this.A00.A07(), collection);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.P9 != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
    @Override // java.util.Set, java.util.Collection
    public final boolean retainAll(Collection<?> collection) {
        return PC.A02(this.A00.A07(), collection);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.P9 != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
    @Override // java.util.Set, java.util.Collection
    public final int size() {
        return this.A00.A04();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.P9 != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray() {
        return this.A00.A0G(0);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.P9 != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
    @Override // java.util.Set, java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        return (T[]) this.A00.A0H(tArr, 0);
    }
}
