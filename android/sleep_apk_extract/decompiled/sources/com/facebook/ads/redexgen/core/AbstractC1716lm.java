package com.facebook.ads.redexgen.core;

import com.google.common.collect.ParametricNullness;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import javax.annotation.CheckForNull;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.lm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1716lm<T> implements Iterator<T> {
    public static String[] A05 = {"yj7R8PNFUN0fUwX4ptDHVgb9mciI6y8S", "w28O54ZRsma9hL5SDt3wymltcx69iHvf", "YcrQeuLRolqkQfaDcqM9IKWqy1ikOF9U", "DKWy1m0QH6rgUafvBHDUPpGtl2BaSlV6", "o1aBNcvHQhMY4jdZXZXshBAdWZXBL6DV", "37Z8EQ1QZKWXRGLFu1IhCyfwxu1s5rVt", "AbJFenTKTViZI", "TvP3YStRcjl"};

    @CheckForNull
    public K A00 = null;

    @CheckForNull
    public Collection<V> A01 = null;
    public Iterator<V> A02 = AbstractC1911p9.A02();
    public final Iterator<Map.Entry<K, Collection<V>>> A03;
    public final /* synthetic */ C2L A04;

    public abstract T A00(@ParametricNullness K key, @ParametricNullness V value);

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.lm != com.google.common.collect.AbstractMapBasedMultimap<K, V>$Itr<T> */
    public AbstractC1716lm(final C2L this$0) {
        this.A04 = this$0;
        this.A03 = this$0.A01.entrySet().iterator();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.lm != com.google.common.collect.AbstractMapBasedMultimap<K, V>$Itr<T> */
    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (!this.A03.hasNext()) {
            boolean zHasNext = this.A02.hasNext();
            if (A05[6].length() == 21) {
                throw new RuntimeException();
            }
            String[] strArr = A05;
            strArr[5] = "pECQkiKXDW2sGX88ia3JmL5aCpMJahaX";
            strArr[4] = "40BbvxkWBVb1JaKod9nJScM88XX6buwm";
            if (!zHasNext) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.lm != com.google.common.collect.AbstractMapBasedMultimap<K, V>$Itr<T> */
    /* JADX WARN: Type inference failed for: r0v7, types: [K, java.lang.Object] */
    @Override // java.util.Iterator
    @ParametricNullness
    public final T next() {
        if (!this.A02.hasNext()) {
            Map.Entry entry = (Map.Entry) this.A03.next();
            this.A00 = entry.getKey();
            this.A01 = (Collection) entry.getValue();
            Iterator<V> it = this.A01.iterator();
            if (A05[6].length() == 21) {
                throw new RuntimeException();
            }
            String[] strArr = A05;
            strArr[2] = "8KgPjQMUi9vsfEA6OvWHRw30OGi5ygpx";
            strArr[0] = "pWw8h70m8FKHbc1TiSoELMLej3it9wyW";
            this.A02 = it;
        }
        return A00(AbstractC1978qF.A01(this.A00), this.A02.next());
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.lm != com.google.common.collect.AbstractMapBasedMultimap<K, V>$Itr<T> */
    @Override // java.util.Iterator
    public final void remove() {
        this.A02.remove();
        if (((Collection) Objects.requireNonNull(this.A01)).isEmpty()) {
            this.A03.remove();
        }
        C2L.A01(this.A04);
    }
}
