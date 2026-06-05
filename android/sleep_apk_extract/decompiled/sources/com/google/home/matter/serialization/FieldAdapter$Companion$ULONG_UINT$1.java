package com.google.home.matter.serialization;

import kotlin.Metadata;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class FieldAdapter$Companion$ULONG_UINT$1 extends FunctionReferenceImpl implements Function1<ULong, UInt> {
    public static final FieldAdapter$Companion$ULONG_UINT$1 INSTANCE = new FieldAdapter$Companion$ULONG_UINT$1();

    public FieldAdapter$Companion$ULONG_UINT$1() {
        super(1, ULong.class, "toUInt", "toUInt-pVg5ArA(J)I", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ UInt invoke(ULong uLong) {
        return UInt.m2388boximpl(m560invoke4l20Xc(uLong.getData()));
    }

    /* JADX INFO: renamed from: invoke--4l20Xc, reason: not valid java name */
    public final int m560invoke4l20Xc(long j) {
        return UInt.m2389constructorimpl((int) j);
    }
}
