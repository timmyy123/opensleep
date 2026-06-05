package com.google.home.matter.serialization.codec.json;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.internal.serialization.zzvv;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class JsonClusterWriter$double$1 extends FunctionReferenceImpl implements Function1<Double, Unit> {
    public JsonClusterWriter$double$1(Object obj) {
        super(1, obj, zzvv.class, SDKConstants.PARAM_VALUE, "value(D)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Double d) {
        invoke(d.doubleValue());
        return Unit.INSTANCE;
    }

    public final void invoke(double d) {
        ((zzvv) this.receiver).zzi(d);
    }
}
