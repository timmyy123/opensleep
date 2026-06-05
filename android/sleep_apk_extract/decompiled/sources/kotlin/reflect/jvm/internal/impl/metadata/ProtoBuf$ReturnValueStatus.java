package kotlin.reflect.jvm.internal.impl.metadata;

import kotlin.reflect.jvm.internal.impl.protobuf.Internal;

/* JADX INFO: loaded from: classes5.dex */
public enum ProtoBuf$ReturnValueStatus implements Internal.EnumLite {
    UNSPECIFIED(0, 0),
    MUST_USE(1, 1),
    EXPLICITLY_IGNORABLE(2, 2);

    private static Internal.EnumLiteMap<ProtoBuf$ReturnValueStatus> internalValueMap = new Internal.EnumLiteMap<ProtoBuf$ReturnValueStatus>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ReturnValueStatus.1
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLiteMap
        public ProtoBuf$ReturnValueStatus findValueByNumber(int i) {
            return ProtoBuf$ReturnValueStatus.valueOf(i);
        }
    };
    private final int value;

    ProtoBuf$ReturnValueStatus(int i, int i2) {
        this.value = i2;
    }

    public static ProtoBuf$ReturnValueStatus valueOf(int i) {
        if (i == 0) {
            return UNSPECIFIED;
        }
        if (i == 1) {
            return MUST_USE;
        }
        if (i != 2) {
            return null;
        }
        return EXPLICITLY_IGNORABLE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }
}
