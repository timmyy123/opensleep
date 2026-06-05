package com.google.firebase.components;

import com.google.firebase.inject.Deferred$DeferredHandler;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class OptionalProvider$$ExternalSyntheticLambda0 implements ComponentRegistrarProcessor, Deferred$DeferredHandler {
    public static /* synthetic */ void m(String str, Object obj, Object obj2) {
        throw new DependencyException(str + obj + obj2);
    }

    @Override // com.google.firebase.components.ComponentRegistrarProcessor
    public List processRegistrar(ComponentRegistrar componentRegistrar) {
        return componentRegistrar.getComponents();
    }
}
