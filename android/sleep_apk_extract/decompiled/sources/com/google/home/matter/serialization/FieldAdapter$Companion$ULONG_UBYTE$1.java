package com.google.home.matter.serialization;

import kotlin.Metadata;
import kotlin.UByte;
import kotlin.ULong;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class FieldAdapter$Companion$ULONG_UBYTE$1 extends FunctionReferenceImpl implements Function1<ULong, UByte> {
    public static final FieldAdapter$Companion$ULONG_UBYTE$1 INSTANCE = new FieldAdapter$Companion$ULONG_UBYTE$1();

    public FieldAdapter$Companion$ULONG_UBYTE$1() {
        super(1, ULong.class, "toUByte", "toUByte-w2LRezQ(J)B", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ UByte invoke(ULong uLong) {
        return UByte.m2366boximpl(m558invokeNsiRcpg(uLong.getData()));
    }

    /* JADX INFO: renamed from: invoke-NsiRcpg, reason: not valid java name */
    public final byte m558invokeNsiRcpg(long j) {
        return UByte.m2367constructorimpl((byte) j);
    }
}
