package com.google.home;

import com.google.home.Trait;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0017¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0017R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/google/home/TraitFactory;", "T", "Lcom/google/home/Trait;", "", "factory", "Lcom/google/home/InternalTraitFactory;", "<init>", "(Lcom/google/home/InternalTraitFactory;)V", "getFactory", "()Lcom/google/home/InternalTraitFactory;", "getAttributeById", "Lcom/google/home/Field;", "tagId", "Lkotlin/UInt;", "getAttributeById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getAttributeByName", "name", "", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class TraitFactory<T extends Trait> {
    private final InternalTraitFactory<T> factory;

    public TraitFactory(InternalTraitFactory<T> internalTraitFactory) {
        internalTraitFactory.getClass();
        this.factory = internalTraitFactory;
    }

    /* JADX INFO: renamed from: getAttributeById-WZ4Q5Ns, reason: not valid java name */
    public Field mo449getAttributeByIdWZ4Q5Ns(int tagId) {
        return null;
    }

    public Field getAttributeByName(String name) {
        name.getClass();
        return null;
    }

    public final InternalTraitFactory<T> getFactory() {
        return this.factory;
    }
}
