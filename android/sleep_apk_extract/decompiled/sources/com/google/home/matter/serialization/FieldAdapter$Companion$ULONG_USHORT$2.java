package com.google.home.matter.serialization;

import kotlin.Metadata;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class FieldAdapter$Companion$ULONG_USHORT$2 extends FunctionReferenceImpl implements Function1<UShort, ULong> {
    public static final FieldAdapter$Companion$ULONG_USHORT$2 INSTANCE = new FieldAdapter$Companion$ULONG_USHORT$2();

    public FieldAdapter$Companion$ULONG_USHORT$2() {
        super(1, UShort.class, "toULong", "toULong-s-VKNKU(S)J", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ULong invoke(UShort uShort) {
        return ULong.m2410boximpl(m563invokeAGRhNks(uShort.getData()));
    }

    /* JADX INFO: renamed from: invoke-AGRhNks, reason: not valid java name */
    public final long m563invokeAGRhNks(short s) {
        return ULong.m2411constructorimpl(((long) s) & 65535);
    }
}
