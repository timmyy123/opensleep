package com.fasterxml.jackson.core.type;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ResolvedType {
    public abstract ResolvedType getReferencedType();

    public boolean isReferenceType() {
        return getReferencedType() != null;
    }

    public abstract String toCanonical();
}
