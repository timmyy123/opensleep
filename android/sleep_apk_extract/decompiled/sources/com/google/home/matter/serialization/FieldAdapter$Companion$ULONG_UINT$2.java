package com.google.home.matter.serialization;

import kotlin.Metadata;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class FieldAdapter$Companion$ULONG_UINT$2 extends FunctionReferenceImpl implements Function1<UInt, ULong> {
    public static final FieldAdapter$Companion$ULONG_UINT$2 INSTANCE = new FieldAdapter$Companion$ULONG_UINT$2();

    public FieldAdapter$Companion$ULONG_UINT$2() {
        super(1, UInt.class, "toULong", "toULong-s-VKNKU(I)J", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ULong invoke(UInt uInt) {
        return ULong.m2410boximpl(m561invokej8A87jM(uInt.getData()));
    }

    /* JADX INFO: renamed from: invoke-j8A87jM, reason: not valid java name */
    public final long m561invokej8A87jM(int i) {
        return ULong.m2411constructorimpl(((long) i) & 4294967295L);
    }
}
