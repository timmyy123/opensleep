package com.facebook.ads.redexgen.core;

import com.google.common.collect.ElementTypesAreNonnullByDefault;
import com.google.common.collect.ParametricNullness;
import java.util.Comparator;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ns, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@ElementTypesAreNonnullByDefault
public abstract class AbstractC1833ns {
    public static final AbstractC1833ns A00 = new C0377Be();
    public static final AbstractC1833ns A02 = new C0375Bc(-1);
    public static final AbstractC1833ns A01 = new C0375Bc(1);

    public abstract int A05();

    public abstract AbstractC1833ns A06(int left, int right);

    public abstract AbstractC1833ns A07(long left, long right);

    public abstract <T> AbstractC1833ns A08(@ParametricNullness T left, @ParametricNullness T right, Comparator<T> comparator);

    public abstract AbstractC1833ns A09(boolean left, boolean right);

    public abstract AbstractC1833ns A0A(boolean left, boolean right);

    public AbstractC1833ns() {
    }

    public /* synthetic */ AbstractC1833ns(C0377Be c0377Be) {
        this();
    }

    public static AbstractC1833ns A01() {
        return A00;
    }
}
