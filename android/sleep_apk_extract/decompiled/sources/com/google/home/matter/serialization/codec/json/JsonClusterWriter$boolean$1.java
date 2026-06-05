package com.google.home.matter.serialization.codec.json;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.internal.serialization.zzvv;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class JsonClusterWriter$boolean$1 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    public JsonClusterWriter$boolean$1(Object obj) {
        super(1, obj, zzvv.class, SDKConstants.PARAM_VALUE, "value(Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        ((zzvv) this.receiver).zzh(z);
    }
}
