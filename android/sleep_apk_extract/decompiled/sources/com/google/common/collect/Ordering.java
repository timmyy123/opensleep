package com.google.common.collect;

import com.google.common.base.Function;
import java.util.Comparator;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Ordering<T> implements Comparator<T> {
    public static <T> Ordering<T> from(Comparator<T> comparator) {
        return comparator instanceof Ordering ? (Ordering) comparator : new ComparatorOrdering(comparator);
    }

    public static <C extends Comparable> Ordering<C> natural() {
        return NaturalOrdering.INSTANCE;
    }

    @Override // java.util.Comparator
    public abstract int compare(T t, T t2);

    public <F> Ordering<F> onResultOf(Function<F, ? extends T> function) {
        return new ByFunctionOrdering(function, this);
    }
}
