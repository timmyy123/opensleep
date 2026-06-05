package com.facebook.ads.redexgen.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class RY implements InvocationHandler {
    public final /* synthetic */ ClassLoader A00;

    public RY(ClassLoader classLoader) {
        this.A00 = classLoader;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        return RZ.A00(this.A00, method);
    }
}
