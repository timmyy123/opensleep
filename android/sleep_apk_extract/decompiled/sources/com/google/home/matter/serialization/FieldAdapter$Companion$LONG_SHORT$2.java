package com.google.home.matter.serialization;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class FieldAdapter$Companion$LONG_SHORT$2 extends FunctionReferenceImpl implements Function1<Short, Long> {
    public static final FieldAdapter$Companion$LONG_SHORT$2 INSTANCE = new FieldAdapter$Companion$LONG_SHORT$2();

    public FieldAdapter$Companion$LONG_SHORT$2() {
        super(1, Short.TYPE, "toLong", "longValue()J", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Long invoke(Short sh) {
        return invoke(sh.shortValue());
    }

    public final Long invoke(short s) {
        return Long.valueOf(s);
    }
}
