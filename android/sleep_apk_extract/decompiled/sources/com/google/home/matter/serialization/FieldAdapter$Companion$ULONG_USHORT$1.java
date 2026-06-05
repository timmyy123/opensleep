package com.google.home.matter.serialization;

import kotlin.Metadata;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class FieldAdapter$Companion$ULONG_USHORT$1 extends FunctionReferenceImpl implements Function1<ULong, UShort> {
    public static final FieldAdapter$Companion$ULONG_USHORT$1 INSTANCE = new FieldAdapter$Companion$ULONG_USHORT$1();

    public FieldAdapter$Companion$ULONG_USHORT$1() {
        super(1, ULong.class, "toUShort", "toUShort-Mh2AYeg(J)S", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ UShort invoke(ULong uLong) {
        return UShort.m2432boximpl(m562invokeZO3KGMw(uLong.getData()));
    }

    /* JADX INFO: renamed from: invoke-ZO3KGMw, reason: not valid java name */
    public final short m562invokeZO3KGMw(long j) {
        return UShort.m2433constructorimpl((short) j);
    }
}
