package com.google.home.matter.serialization;

import kotlin.Metadata;
import kotlin.UInt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u0019\u0010\u0004\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u0001¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0019\u0010\u0006\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u0001¢\u0006\u0004\b\u0005\u0010\u0003\u001a'\u0010\t\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\f\b\u0002\u0010\u0006\u001a\u00060\u0000j\u0002`\u0001¢\u0006\u0004\b\u0007\u0010\b*\n\u0010\n\"\u00020\u00002\u00020\u0000¨\u0006\u000b"}, d2 = {"Lkotlin/UInt;", "Lcom/google/home/matter/serialization/TagId;", "id-WZ4Q5Ns", "(I)I", "id", "vendor-WZ4Q5Ns", "vendor", "setVendor-feOb9K0", "(II)I", "setVendor", "TagId", "java.com.google.home.matter.serialization_serialization-android"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class TagIdKt {
    /* JADX INFO: renamed from: id-WZ4Q5Ns, reason: not valid java name */
    public static final int m567idWZ4Q5Ns(int i) {
        return UInt.m2389constructorimpl((char) i);
    }

    /* JADX INFO: renamed from: setVendor-feOb9K0, reason: not valid java name */
    public static final int m568setVendorfeOb9K0(int i, int i2) {
        return UInt.m2389constructorimpl(m567idWZ4Q5Ns(i) | UInt.m2389constructorimpl(i2 << 16));
    }

    /* JADX INFO: renamed from: vendor-WZ4Q5Ns, reason: not valid java name */
    public static final int m569vendorWZ4Q5Ns(int i) {
        return UInt.m2389constructorimpl((char) UInt.m2389constructorimpl(i >>> 16));
    }
}
