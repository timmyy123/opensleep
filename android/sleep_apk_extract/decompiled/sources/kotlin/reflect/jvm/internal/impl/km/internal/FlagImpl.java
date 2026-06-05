package kotlin.reflect.jvm.internal.impl.km.internal;

import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;

/* JADX INFO: loaded from: classes5.dex */
public final class FlagImpl {
    private final int bitWidth;
    private final int offset;
    private final int value;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FlagImpl(Flags.FlagField<?> flagField, int i) {
        this(flagField.offset, flagField.bitWidth, i);
        flagField.getClass();
    }

    public final int getBitWidth$kotlin_metadata() {
        return this.bitWidth;
    }

    public final int getOffset$kotlin_metadata() {
        return this.offset;
    }

    public final int getValue$kotlin_metadata() {
        return this.value;
    }

    public final boolean invoke(int i) {
        return ((i >>> this.offset) & ((1 << this.bitWidth) - 1)) == this.value;
    }

    public final int plus$kotlin_metadata(int i) {
        int i2 = (1 << this.bitWidth) - 1;
        int i3 = this.offset;
        return (i & (~(i2 << i3))) + (this.value << i3);
    }

    public FlagImpl(int i, int i2, int i3) {
        this.offset = i;
        this.bitWidth = i2;
        this.value = i3;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FlagImpl(Flags.BooleanFlagField booleanFlagField) {
        this(booleanFlagField, 1);
        booleanFlagField.getClass();
    }
}
