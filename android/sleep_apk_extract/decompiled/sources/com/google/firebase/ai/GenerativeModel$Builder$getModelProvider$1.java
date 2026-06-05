package com.google.firebase.ai;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class GenerativeModel$Builder$getModelProvider$1 extends FunctionReferenceImpl implements Function0<Boolean> {
    public GenerativeModel$Builder$getModelProvider$1(Object obj) {
        super(0, obj, NetworkStatusChecker.class, "isDeviceOnline", "isDeviceOnline()Z", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Boolean invoke() {
        return Boolean.valueOf(((NetworkStatusChecker) this.receiver).isDeviceOnline());
    }
}
