package com.facebook.ads.redexgen.core;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: Add missing generic type declarations: [E] */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Aw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C0369Aw<E> extends AbstractC2002qh<E> {
    public final /* synthetic */ Set A00;
    public final /* synthetic */ Set A01;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0369Aw(final Set val$set1, final Set val$set2) {
        super(null);
        this.A00 = val$set1;
        this.A01 = val$set2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final C4C<E> iterator() {
        return new AbstractC0394Bv<E>() { // from class: com.facebook.ads.redexgen.X.27
            public final Iterator<E> A00;

            {
                this.A00 = this.A01.A00.iterator();
            }

            @Override // com.facebook.ads.redexgen.core.AbstractC0394Bv
            @CheckForNull
            public final E A02() {
                while (this.A00.hasNext()) {
                    E next = this.A00.next();
                    if (this.A01.A01.contains(next)) {
                        return next;
                    }
                }
                E e = A01();
                return e;
            }
        };
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(@CheckForNull Object object) {
        return this.A00.contains(object) && this.A01.contains(object);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean containsAll(Collection<?> collection) {
        return this.A00.containsAll(collection) && this.A01.containsAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return Collections.disjoint(this.A01, this.A00);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        int i = 0;
        Iterator<E> it = this.A00.iterator();
        while (it.hasNext()) {
            if (this.A01.contains(it.next())) {
                i++;
            }
        }
        return i;
    }
}
