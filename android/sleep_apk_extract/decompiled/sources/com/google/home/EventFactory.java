package com.google.home;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\rH\u0017¢\u0006\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/google/home/EventFactory;", "", "T", "Lcom/google/home/InternalEventFactory;", "factory", "<init>", "(Lcom/google/home/InternalEventFactory;)V", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getEventFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getEventFieldById", "", "name", "getEventFieldByName", "(Ljava/lang/String;)Lcom/google/home/Field;", "Lcom/google/home/InternalEventFactory;", "getFactory", "()Lcom/google/home/InternalEventFactory;", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class EventFactory<T> {
    private final InternalEventFactory<T> factory;

    public EventFactory(InternalEventFactory<T> internalEventFactory) {
        internalEventFactory.getClass();
        this.factory = internalEventFactory;
    }

    /* JADX INFO: renamed from: getEventFieldById-WZ4Q5Ns, reason: not valid java name */
    public Field m437getEventFieldByIdWZ4Q5Ns(int tagId) {
        return null;
    }

    public Field getEventFieldByName(String name) {
        name.getClass();
        return null;
    }
}
