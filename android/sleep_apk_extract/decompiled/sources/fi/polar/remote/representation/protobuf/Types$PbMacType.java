package fi.polar.remote.representation.protobuf;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes5.dex */
public enum Types$PbMacType implements Internal.EnumLite {
    MAC_TYPE_PUBLIC(0),
    MAC_TYPE_STATIC(1),
    MAC_TYPE_PRIVATE_NONRESOLVABLE(2),
    MAC_TYPE_PRIVATE_RESOLVABLE(3),
    MAC_TYPE_BT_CLASSIC(4);

    private static final Internal.EnumLiteMap<Types$PbMacType> internalValueMap = new Internal.EnumLiteMap<Types$PbMacType>() { // from class: fi.polar.remote.representation.protobuf.Types$PbMacType.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public Types$PbMacType findValueByNumber(int i) {
            return Types$PbMacType.forNumber(i);
        }
    };
    private final int value;

    public static final class PbMacTypeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new PbMacTypeVerifier();

        private PbMacTypeVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return Types$PbMacType.forNumber(i) != null;
        }
    }

    Types$PbMacType(int i) {
        this.value = i;
    }

    public static Types$PbMacType forNumber(int i) {
        if (i == 0) {
            return MAC_TYPE_PUBLIC;
        }
        if (i == 1) {
            return MAC_TYPE_STATIC;
        }
        if (i == 2) {
            return MAC_TYPE_PRIVATE_NONRESOLVABLE;
        }
        if (i == 3) {
            return MAC_TYPE_PRIVATE_RESOLVABLE;
        }
        if (i != 4) {
            return null;
        }
        return MAC_TYPE_BT_CLASSIC;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return PbMacTypeVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }
}
