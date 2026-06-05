package com.google.home.matter.serialization;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class FieldAdapter$Companion$LONG_SHORT$1 extends FunctionReferenceImpl implements Function1<Long, Short> {
    public static final FieldAdapter$Companion$LONG_SHORT$1 INSTANCE = new FieldAdapter$Companion$LONG_SHORT$1();

    public FieldAdapter$Companion$LONG_SHORT$1() {
        super(1, Long.TYPE, "toShort", "shortValue()S", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Short invoke(Long l) {
        return invoke(l.longValue());
    }

    public final Short invoke(long j) {
        return Short.valueOf((short) j);
    }
}
