package io.ktor.util;

import java.util.Iterator;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004*\u001e\b\u0007\u0010\u0007\u001a\u0004\b\u0000\u0010\u0005\"\b\u0012\u0004\u0012\u00028\u00000\u00062\b\u0012\u0004\u0012\u00028\u00000\u0006¨\u0006\b"}, d2 = {"Lio/ktor/util/Attributes;", "other", "", "putAll", "(Lio/ktor/util/Attributes;Lio/ktor/util/Attributes;)V", "T", "Lio/ktor/util/AttributeKey;", "EquatableAttributeKey", "ktor-utils"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class AttributesKt {
    public static final void putAll(Attributes attributes, Attributes attributes2) {
        attributes.getClass();
        attributes2.getClass();
        Iterator<T> it = attributes2.getAllKeys().iterator();
        while (it.hasNext()) {
            AttributeKey attributeKey = (AttributeKey) it.next();
            attributeKey.getClass();
            attributes.put(attributeKey, attributes2.get(attributeKey));
        }
    }
}
