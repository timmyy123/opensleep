package com.google.home.matter.serialization.codec.json;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.internal.serialization.zzvv;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class JsonClusterWriter$string$1 extends FunctionReferenceImpl implements Function1<String, Unit> {
    public JsonClusterWriter$string$1(Object obj) {
        super(1, obj, zzvv.class, SDKConstants.PARAM_VALUE, "value(Ljava/lang/String;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        str.getClass();
        ((zzvv) this.receiver).zzf(str);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.INSTANCE;
    }
}
