package com.google.home.matter.serialization.codec.json;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class JsonClusterWriter$long$1 extends FunctionReferenceImpl implements Function1<Long, Unit> {
    public JsonClusterWriter$long$1(Object obj) {
        super(1, obj, JsonClusterWriter.class, SDKConstants.PARAM_VALUE, "value(J)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke(l.longValue());
        return Unit.INSTANCE;
    }

    public final void invoke(long j) {
        ((JsonClusterWriter) this.receiver).value(j);
    }
}
