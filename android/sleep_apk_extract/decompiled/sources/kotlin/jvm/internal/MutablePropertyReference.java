package kotlin.jvm.internal;

import kotlin.reflect.KMutableProperty;

/* JADX INFO: loaded from: classes5.dex */
public abstract class MutablePropertyReference extends PropertyReference implements KMutableProperty {
    public MutablePropertyReference(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }
}
