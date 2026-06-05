package org.aspectj.lang;

/* JADX INFO: loaded from: classes5.dex */
public interface JoinPoint {

    public interface StaticPart {
        String toString();
    }

    Object getTarget();
}
