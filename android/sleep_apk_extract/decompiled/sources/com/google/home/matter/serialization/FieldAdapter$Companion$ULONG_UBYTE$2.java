package com.google.home.matter.serialization;

import kotlin.Metadata;
import kotlin.UByte;
import kotlin.ULong;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class FieldAdapter$Companion$ULONG_UBYTE$2 extends FunctionReferenceImpl implements Function1<UByte, ULong> {
    public static final FieldAdapter$Companion$ULONG_UBYTE$2 INSTANCE = new FieldAdapter$Companion$ULONG_UBYTE$2();

    public FieldAdapter$Companion$ULONG_UBYTE$2() {
        super(1, UByte.class, "toULong", "toULong-s-VKNKU(B)J", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ULong invoke(UByte uByte) {
        return ULong.m2410boximpl(m559invokeqRK8ubM(uByte.getData()));
    }

    /* JADX INFO: renamed from: invoke-qRK8ubM, reason: not valid java name */
    public final long m559invokeqRK8ubM(byte b) {
        return ULong.m2411constructorimpl(((long) b) & 255);
    }
}
