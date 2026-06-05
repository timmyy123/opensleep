package kotlin.reflect.jvm.internal.impl.km.internal;

import java.lang.Enum;
import java.util.List;
import kotlin.enums.EnumEntries;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal;

/* JADX INFO: loaded from: classes5.dex */
public final class EnumFlagDelegate<Node, E extends Enum<E>> {
    private final EnumEntries<E> entries;
    private final List<FlagImpl> flagValues;
    private final KMutableProperty1<Node, Integer> flags;
    private final Flags.FlagField<? extends Internal.EnumLite> protoSet;

    public EnumFlagDelegate(KMutableProperty1<Node, Integer> kMutableProperty1, Flags.FlagField<? extends Internal.EnumLite> flagField, EnumEntries<E> enumEntries, List<FlagImpl> list) {
        kMutableProperty1.getClass();
        flagField.getClass();
        enumEntries.getClass();
        list.getClass();
        this.flags = kMutableProperty1;
        this.protoSet = flagField;
        this.entries = enumEntries;
        this.flagValues = list;
    }

    public final E getValue(Node node, KProperty<?> kProperty) {
        kProperty.getClass();
        return this.entries.get(this.protoSet.get(this.flags.get(node).intValue()).getNumber());
    }

    public final void setValue(Node node, KProperty<?> kProperty, E e) {
        kProperty.getClass();
        e.getClass();
        this.flags.set(node, Integer.valueOf(this.flagValues.get(e.ordinal()).plus$kotlin_metadata(this.flags.get(node).intValue())));
    }
}
