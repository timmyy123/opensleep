package com.google.home.matter.serialization;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class FieldAdapter$Companion$LONG_BYTE$2 extends FunctionReferenceImpl implements Function1<Byte, Long> {
    public static final FieldAdapter$Companion$LONG_BYTE$2 INSTANCE = new FieldAdapter$Companion$LONG_BYTE$2();

    public FieldAdapter$Companion$LONG_BYTE$2() {
        super(1, Byte.TYPE, "toLong", "longValue()J", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Long invoke(Byte b) {
        return invoke(b.byteValue());
    }

    public final Long invoke(byte b) {
        return Long.valueOf(b);
    }
}
