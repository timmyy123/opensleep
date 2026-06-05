package com.facebook.ads.redexgen.core;

import com.google.common.collect.ParametricNullness;
import java.util.Collection;
import java.util.Comparator;
import java.util.SortedMap;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

/* JADX INFO: Add missing generic type declarations: [K] */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.18, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class AnonymousClass18<K> extends C2L<K, V>.KeySet implements SortedSet<K> {
    public final /* synthetic */ C2L A00;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.18 != com.google.common.collect.AbstractMapBasedMultimap<K, V>$SortedKeySet */
    public AnonymousClass18(final C2L this$0, SortedMap<K, Collection<V>> subMap) {
        super(this$0, subMap);
        this.A00 = this$0;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.18 != com.google.common.collect.AbstractMapBasedMultimap<K, V>$SortedKeySet */
    public SortedMap<K, Collection<V>> A04() {
        return (SortedMap) super.A00();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.18 != com.google.common.collect.AbstractMapBasedMultimap<K, V>$SortedKeySet */
    @Override // java.util.SortedSet
    @CheckForNull
    public final Comparator<? super K> comparator() {
        return A04().comparator();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.18 != com.google.common.collect.AbstractMapBasedMultimap<K, V>$SortedKeySet */
    @Override // java.util.SortedSet
    @ParametricNullness
    public final K first() {
        return A04().firstKey();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.18 != com.google.common.collect.AbstractMapBasedMultimap<K, V>$SortedKeySet */
    @Override // java.util.SortedSet
    public SortedSet<K> headSet(@ParametricNullness K toElement) {
        return new AnonymousClass18(this.A00, A04().headMap(toElement));
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.18 != com.google.common.collect.AbstractMapBasedMultimap<K, V>$SortedKeySet */
    @Override // java.util.SortedSet
    @ParametricNullness
    public final K last() {
        return A04().lastKey();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.18 != com.google.common.collect.AbstractMapBasedMultimap<K, V>$SortedKeySet */
    @Override // java.util.SortedSet
    public SortedSet<K> subSet(@ParametricNullness K fromElement, @ParametricNullness K toElement) {
        return new AnonymousClass18(this.A00, A04().subMap(fromElement, toElement));
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.18 != com.google.common.collect.AbstractMapBasedMultimap<K, V>$SortedKeySet */
    @Override // java.util.SortedSet
    public SortedSet<K> tailSet(@ParametricNullness K fromElement) {
        return new AnonymousClass18(this.A00, A04().tailMap(fromElement));
    }
}
