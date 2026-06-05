package com.google.firebase.components;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface ComponentRegistrarProcessor {
    public static final ComponentRegistrarProcessor NOOP = new OptionalProvider$$ExternalSyntheticLambda0();

    List<Component<?>> processRegistrar(ComponentRegistrar componentRegistrar);
}
