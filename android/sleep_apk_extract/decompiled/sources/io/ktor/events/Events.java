package io.ktor.events;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import io.ktor.util.collections.CopyOnWriteHashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\t\u001a\u00020\b\"\u0004\b\u0000\u0010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\b\t\u0010\nR$\u0010\f\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u00010\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lio/ktor/events/Events;", "", "<init>", "()V", "T", "Lio/ktor/events/EventDefinition;", "definition", SDKConstants.PARAM_VALUE, "", "raise", "(Lio/ktor/events/EventDefinition;Ljava/lang/Object;)V", "Lio/ktor/util/collections/CopyOnWriteHashMap;", "handlers", "Lio/ktor/util/collections/CopyOnWriteHashMap;", "ktor-events"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Events {
    private final CopyOnWriteHashMap<EventDefinition<?>, Object> handlers = new CopyOnWriteHashMap<>();

    public final <T> void raise(EventDefinition<T> definition, T value) {
        definition.getClass();
        if (this.handlers.get(definition) == null) {
            return;
        }
        Events$$ExternalSyntheticBUOutline0.m();
    }
}
