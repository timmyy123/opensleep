package kotlin.reflect.jvm.internal.impl.km.internal;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes5.dex */
public final class BooleanFlagDelegate<Node> {
    private final FlagImpl flag;
    private final KMutableProperty1<Node, Integer> flags;
    private final int mask;

    public BooleanFlagDelegate(KMutableProperty1<Node, Integer> kMutableProperty1, FlagImpl flagImpl) {
        kMutableProperty1.getClass();
        flagImpl.getClass();
        this.flags = kMutableProperty1;
        this.flag = flagImpl;
        if (flagImpl.getBitWidth$kotlin_metadata() == 1 && flagImpl.getValue$kotlin_metadata() == 1) {
            this.mask = 1 << flagImpl.getOffset$kotlin_metadata();
        } else {
            Home$$ExternalSyntheticBUOutline0.m("BooleanFlagDelegate can work only with boolean flags (bitWidth = 1 and value = 1), but ", flagImpl, " was passed");
            throw null;
        }
    }

    public final boolean getValue(Node node, KProperty<?> kProperty) {
        kProperty.getClass();
        return this.flag.invoke(this.flags.get(node).intValue());
    }

    public final void setValue(Node node, KProperty<?> kProperty, boolean z) {
        kProperty.getClass();
        int iIntValue = this.flags.get(node).intValue();
        this.flags.set(node, Integer.valueOf(z ? iIntValue | this.mask : iIntValue & (~this.mask)));
    }
}
