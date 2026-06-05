package com.fasterxml.jackson.databind.util;

import java.lang.annotation.Annotation;

/* JADX INFO: loaded from: classes3.dex */
public interface Annotations {
    <A extends Annotation> A get(Class<A> cls);

    boolean has(Class<?> cls);

    boolean hasOneOf(Class<? extends Annotation>[] clsArr);

    int size();
}
