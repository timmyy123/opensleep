package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.introspect.Annotated;

/* JADX INFO: loaded from: classes3.dex */
public class AnnotatedAndMetadata<A extends Annotated, M> {
    public final A annotated;
    public final M metadata;

    public AnnotatedAndMetadata(A a, M m) {
        this.annotated = a;
        this.metadata = m;
    }

    public static <A extends Annotated, M> AnnotatedAndMetadata<A, M> of(A a, M m) {
        return new AnnotatedAndMetadata<>(a, m);
    }
}
