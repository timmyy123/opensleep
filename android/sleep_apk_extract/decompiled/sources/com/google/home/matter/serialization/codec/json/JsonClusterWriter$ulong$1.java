package com.google.home.matter.serialization.codec.json;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class JsonClusterWriter$ulong$1 extends FunctionReferenceImpl implements Function1<ULong, Unit> {
    public JsonClusterWriter$ulong$1(Object obj) {
        super(1, obj, JsonClusterWriter.class, SDKConstants.PARAM_VALUE, "value-VKZWuLQ(J)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ULong uLong) {
        m578invokeVKZWuLQ(uLong.getData());
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke-VKZWuLQ, reason: not valid java name */
    public final void m578invokeVKZWuLQ(long j) {
        ((JsonClusterWriter) this.receiver).m576valueVKZWuLQ(j);
    }
}
