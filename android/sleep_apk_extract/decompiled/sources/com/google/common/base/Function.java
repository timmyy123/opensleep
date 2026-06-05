package com.google.common.base;

import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes4.dex */
public interface Function<F, T> {
    T apply(F f);

    boolean equals(@CheckForNull Object obj);
}
