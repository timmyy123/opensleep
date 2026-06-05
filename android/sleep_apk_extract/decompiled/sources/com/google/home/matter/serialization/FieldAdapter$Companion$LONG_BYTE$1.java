package com.google.home.matter.serialization;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class FieldAdapter$Companion$LONG_BYTE$1 extends FunctionReferenceImpl implements Function1<Long, Byte> {
    public static final FieldAdapter$Companion$LONG_BYTE$1 INSTANCE = new FieldAdapter$Companion$LONG_BYTE$1();

    public FieldAdapter$Companion$LONG_BYTE$1() {
        super(1, Long.TYPE, "toByte", "byteValue()B", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Byte invoke(Long l) {
        return invoke(l.longValue());
    }

    public final Byte invoke(long j) {
        return Byte.valueOf((byte) j);
    }
}
