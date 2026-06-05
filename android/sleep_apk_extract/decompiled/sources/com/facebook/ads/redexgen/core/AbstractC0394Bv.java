package com.facebook.ads.redexgen.core;

import com.google.common.collect.ElementTypesAreNonnullByDefault;
import com.google.common.collect.ParametricNullness;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Bv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@ElementTypesAreNonnullByDefault
public abstract class AbstractC0394Bv<T> extends C4C<T> {
    public EnumC1714lk A00 = EnumC1714lk.A04;

    @CheckForNull
    public T A01;

    @CheckForNull
    public abstract T A02();

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Bv != com.google.common.collect.AbstractIterator<T> */
    private boolean A00() {
        this.A00 = EnumC1714lk.A03;
        this.A01 = A02();
        if (this.A00 != EnumC1714lk.A02) {
            this.A00 = EnumC1714lk.A05;
            return true;
        }
        return false;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Bv != com.google.common.collect.AbstractIterator<T> */
    @CheckForNull
    public final T A01() {
        this.A00 = EnumC1714lk.A02;
        return null;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Bv != com.google.common.collect.AbstractIterator<T> */
    @Override // java.util.Iterator
    public final boolean hasNext() {
        AbstractC1651ki.A0D(this.A00 != EnumC1714lk.A03);
        switch (this.A00) {
            case A05:
                return true;
            case A04:
            default:
                return A00();
            case A02:
                return false;
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Bv != com.google.common.collect.AbstractIterator<T> */
    @Override // java.util.Iterator
    @ParametricNullness
    public final T next() {
        if (hasNext()) {
            this.A00 = EnumC1714lk.A04;
            T t = (T) AbstractC1978qF.A01(this.A01);
            this.A01 = null;
            return t;
        }
        throw new NoSuchElementException();
    }
}
