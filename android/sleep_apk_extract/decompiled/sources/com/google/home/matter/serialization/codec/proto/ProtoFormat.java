package com.google.home.matter.serialization.codec.proto;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b4\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001EB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\r\u001a\u00060\tj\u0002`\n2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00060\tj\u0002`\n2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\fJ\u0015\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\bJ\u0015\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\bJ\u0015\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0004¢\u0006\u0004\b\u0016\u0010\bJ\u0015\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0017\u0010\bJ5\u0010\u001e\u001a\u00020\u00042\n\u0010\u0018\u001a\u00060\tj\u0002`\n2\u0006\u0010\u0019\u001a\u00020\u00122\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010 \u001a\u00020\u00042\n\u0010\u0018\u001a\u00060\tj\u0002`\n¢\u0006\u0004\b\u001f\u0010\fR\u001a\u0010!\u001a\u00020\u00048\u0006X\u0086D¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020\u00048\u0006X\u0086D¢\u0006\f\n\u0004\b%\u0010\"\u001a\u0004\b&\u0010$R\u0017\u0010'\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b'\u0010\"\u001a\u0004\b(\u0010$R\u001a\u0010)\u001a\u00020\u00048\u0006X\u0086D¢\u0006\f\n\u0004\b)\u0010\"\u001a\u0004\b*\u0010$R\u0017\u0010+\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b+\u0010\"\u001a\u0004\b,\u0010$R\u0017\u0010-\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b-\u0010\"\u001a\u0004\b.\u0010$R\u001a\u0010/\u001a\u00020\u00048\u0006X\u0086D¢\u0006\f\n\u0004\b/\u0010\"\u001a\u0004\b0\u0010$R\u0017\u00101\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b1\u0010\"\u001a\u0004\b2\u0010$R\u0017\u00103\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b3\u0010\"\u001a\u0004\b4\u0010$R\u001a\u00105\u001a\u00020\u00048\u0006X\u0086D¢\u0006\f\n\u0004\b5\u0010\"\u001a\u0004\b6\u0010$R\u0017\u00107\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b7\u0010\"\u001a\u0004\b8\u0010$R\u0017\u00109\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b9\u0010\"\u001a\u0004\b:\u0010$R\u001a\u0010;\u001a\u00020\u00048\u0006X\u0086D¢\u0006\f\n\u0004\b;\u0010\"\u001a\u0004\b<\u0010$R\u0017\u0010=\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b=\u0010\"\u001a\u0004\b>\u0010$R\u0017\u0010?\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b?\u0010\"\u001a\u0004\b@\u0010$R\u001a\u0010A\u001a\u00020\u00048\u0006X\u0086D¢\u0006\f\n\u0004\bA\u0010\"\u001a\u0004\bB\u0010$R\u001a\u0010C\u001a\u00020\u00048\u0006X\u0086D¢\u0006\f\n\u0004\bC\u0010\"\u001a\u0004\bD\u0010$¨\u0006F"}, d2 = {"Lcom/google/home/matter/serialization/codec/proto/ProtoFormat;", "", "<init>", "()V", "", "fieldNumber", "", "isReserved", "(I)Z", "Lkotlin/UInt;", "Lcom/google/home/matter/serialization/TagId;", "getContainerIdFromFieldNumber-OGnWXxg", "(I)I", "getContainerIdFromFieldNumber", "getIdFromFieldNumber-OGnWXxg", "getIdFromFieldNumber", "getIsListFromFieldNumber", "getIsVendorFromFieldNumber", "Lcom/google/home/matter/serialization/codec/proto/ProtoFormat$Type;", "getTypeFromFieldNumber", "(I)Lcom/google/home/matter/serialization/codec/proto/ProtoFormat$Type;", "protoTag", "getIsLengthDelimitedFromTagNumber", "getIsPrimitiveFromFieldNumber", "id", "type", "isList", "isVendor", "makeFieldNumber-SGjrQA4", "(ILcom/google/home/matter/serialization/codec/proto/ProtoFormat$Type;ZZ)I", "makeFieldNumber", "makeContainerFieldNumber-WZ4Q5Ns", "makeContainerFieldNumber", "FIELD_NUMBER_BITS_TYPE", "I", "getFIELD_NUMBER_BITS_TYPE", "()I", "FIELD_NUMBER_SHIFT_TYPE", "getFIELD_NUMBER_SHIFT_TYPE", "FIELD_NUMBER_MASK_TYPE", "getFIELD_NUMBER_MASK_TYPE", "FIELD_NUMBER_BITS_LIST", "getFIELD_NUMBER_BITS_LIST", "FIELD_NUMBER_SHIFT_LIST", "getFIELD_NUMBER_SHIFT_LIST", "FIELD_NUMBER_MASK_LIST", "getFIELD_NUMBER_MASK_LIST", "FIELD_NUMBER_BITS_ID", "getFIELD_NUMBER_BITS_ID", "FIELD_NUMBER_SHIFT_ID", "getFIELD_NUMBER_SHIFT_ID", "FIELD_NUMBER_MASK_ID", "getFIELD_NUMBER_MASK_ID", "FIELD_NUMBER_BITS_VENDOR", "getFIELD_NUMBER_BITS_VENDOR", "FIELD_NUMBER_SHIFT_VENDOR", "getFIELD_NUMBER_SHIFT_VENDOR", "FIELD_NUMBER_MASK_VENDOR", "getFIELD_NUMBER_MASK_VENDOR", "FIELD_NUMBER_BITS_RESERVED", "getFIELD_NUMBER_BITS_RESERVED", "FIELD_NUMBER_SHIFT_RESERVED", "getFIELD_NUMBER_SHIFT_RESERVED", "FIELD_NUMBER_MASK_RESERVED", "getFIELD_NUMBER_MASK_RESERVED", "WIRETYPE_LENGTH_DELIMITED", "getWIRETYPE_LENGTH_DELIMITED", "FIELD_NUMBER_UDDM_INCREMENT", "getFIELD_NUMBER_UDDM_INCREMENT", "Type", "java.com.google.home.matter.serialization.codec.proto_proto-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProtoFormat {
    public static final ProtoFormat INSTANCE = new ProtoFormat();
    private static final int FIELD_NUMBER_BITS_TYPE = 4;
    private static final int FIELD_NUMBER_SHIFT_TYPE = 0;
    private static final int FIELD_NUMBER_MASK_TYPE = 15 << FIELD_NUMBER_SHIFT_TYPE;
    private static final int FIELD_NUMBER_BITS_LIST = 1;
    private static final int FIELD_NUMBER_SHIFT_LIST = 4;
    private static final int FIELD_NUMBER_MASK_LIST = 16;
    private static final int FIELD_NUMBER_BITS_ID = 16;
    private static final int FIELD_NUMBER_SHIFT_ID = 5;
    private static final int FIELD_NUMBER_MASK_ID = 2097120;
    private static final int FIELD_NUMBER_BITS_VENDOR = 1;
    private static final int FIELD_NUMBER_SHIFT_VENDOR = 21;
    private static final int FIELD_NUMBER_MASK_VENDOR = 2097152;
    private static final int FIELD_NUMBER_BITS_RESERVED = 1;
    private static final int FIELD_NUMBER_SHIFT_RESERVED = 22;
    private static final int FIELD_NUMBER_MASK_RESERVED = 4194304;
    private static final int WIRETYPE_LENGTH_DELIMITED = 2;
    private static final int FIELD_NUMBER_UDDM_INCREMENT = 1;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/google/home/matter/serialization/codec/proto/ProtoFormat$Type;", "", SDKConstants.PARAM_VALUE, "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UINT", "INT", "BOOL", "CHAR_STRING", "BYTE_STRING", "STRUCT", "FLOAT", "DOUBLE", "NULL", "Companion", "java.com.google.home.matter.serialization.codec.proto_proto-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Type {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Type[] $VALUES;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        private final int value;
        public static final Type UINT = new Type("UINT", 0, 1);
        public static final Type INT = new Type("INT", 1, 2);
        public static final Type BOOL = new Type("BOOL", 2, 3);
        public static final Type CHAR_STRING = new Type("CHAR_STRING", 3, 4);
        public static final Type BYTE_STRING = new Type("BYTE_STRING", 4, 5);
        public static final Type STRUCT = new Type("STRUCT", 5, 6);
        public static final Type FLOAT = new Type("FLOAT", 6, 7);
        public static final Type DOUBLE = new Type("DOUBLE", 7, 8);
        public static final Type NULL = new Type("NULL", 8, 14);

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/google/home/matter/serialization/codec/proto/ProtoFormat$Type$Companion;", "", "<init>", "()V", "fromInt", "Lcom/google/home/matter/serialization/codec/proto/ProtoFormat$Type;", SDKConstants.PARAM_VALUE, "", "java.com.google.home.matter.serialization.codec.proto_proto-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final Type fromInt(int value) {
                Type type = Type.UINT;
                if (value == type.getValue()) {
                    return type;
                }
                Type type2 = Type.INT;
                if (value == type2.getValue()) {
                    return type2;
                }
                Type type3 = Type.BOOL;
                if (value == type3.getValue()) {
                    return type3;
                }
                Type type4 = Type.CHAR_STRING;
                if (value == type4.getValue()) {
                    return type4;
                }
                Type type5 = Type.BYTE_STRING;
                if (value == type5.getValue()) {
                    return type5;
                }
                Type type6 = Type.STRUCT;
                if (value == type6.getValue()) {
                    return type6;
                }
                Type type7 = Type.FLOAT;
                if (value == type7.getValue()) {
                    return type7;
                }
                Type type8 = Type.DOUBLE;
                if (value == type8.getValue()) {
                    return type8;
                }
                Type type9 = Type.NULL;
                if (value == type9.getValue()) {
                    return type9;
                }
                Utf8$$ExternalSyntheticBUOutline0.m$2(zzba$$ExternalSyntheticOutline0.m(value, "Invalid ProtoFormat.Type value: ", new StringBuilder(String.valueOf(value).length() + 32)));
                return null;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{UINT, INT, BOOL, CHAR_STRING, BYTE_STRING, STRUCT, FLOAT, DOUBLE, NULL};
        }

        static {
            Type[] typeArr$values = $values();
            $VALUES = typeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(typeArr$values);
            INSTANCE = new Companion(null);
        }

        private Type(String str, int i, int i2) {
            this.value = i2;
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }
    }

    private ProtoFormat() {
    }

    private final boolean isReserved(int fieldNumber) {
        return fieldNumber >= 19000 && fieldNumber <= 19999;
    }

    /* JADX INFO: renamed from: getContainerIdFromFieldNumber-OGnWXxg, reason: not valid java name */
    public final int m604getContainerIdFromFieldNumberOGnWXxg(int fieldNumber) {
        return UInt.m2389constructorimpl(WireFormat.INSTANCE.getTagFieldNumber(fieldNumber) - FIELD_NUMBER_UDDM_INCREMENT);
    }

    /* JADX INFO: renamed from: getIdFromFieldNumber-OGnWXxg, reason: not valid java name */
    public final int m605getIdFromFieldNumberOGnWXxg(int fieldNumber) {
        return UInt.m2389constructorimpl((FIELD_NUMBER_MASK_ID & fieldNumber) >> FIELD_NUMBER_SHIFT_ID);
    }

    public final boolean getIsLengthDelimitedFromTagNumber(int protoTag) {
        return WireFormat.INSTANCE.getTagWireType(protoTag) == WIRETYPE_LENGTH_DELIMITED;
    }

    public final boolean getIsListFromFieldNumber(int fieldNumber) {
        return ((FIELD_NUMBER_MASK_LIST & fieldNumber) >> FIELD_NUMBER_SHIFT_LIST) != 0;
    }

    public final boolean getIsPrimitiveFromFieldNumber(int fieldNumber) {
        Type typeFromFieldNumber = getTypeFromFieldNumber(fieldNumber);
        return typeFromFieldNumber == Type.UINT || typeFromFieldNumber == Type.INT || typeFromFieldNumber == Type.BOOL || typeFromFieldNumber == Type.FLOAT || typeFromFieldNumber == Type.DOUBLE;
    }

    public final boolean getIsVendorFromFieldNumber(int fieldNumber) {
        return ((FIELD_NUMBER_MASK_VENDOR & fieldNumber) >> FIELD_NUMBER_SHIFT_VENDOR) != 0;
    }

    public final Type getTypeFromFieldNumber(int fieldNumber) {
        return Type.INSTANCE.fromInt((fieldNumber & FIELD_NUMBER_MASK_TYPE) >> FIELD_NUMBER_SHIFT_TYPE);
    }

    public final int getWIRETYPE_LENGTH_DELIMITED() {
        return WIRETYPE_LENGTH_DELIMITED;
    }

    /* JADX INFO: renamed from: makeContainerFieldNumber-WZ4Q5Ns, reason: not valid java name */
    public final int m606makeContainerFieldNumberWZ4Q5Ns(int id) {
        return id + FIELD_NUMBER_UDDM_INCREMENT;
    }

    /* JADX INFO: renamed from: makeFieldNumber-SGjrQA4, reason: not valid java name */
    public final int m607makeFieldNumberSGjrQA4(int id, Type type, boolean isList, boolean isVendor) {
        type.getClass();
        int value = (type.getValue() << FIELD_NUMBER_SHIFT_TYPE) & FIELD_NUMBER_MASK_TYPE;
        int i = ((isList ? 1 : 0) << FIELD_NUMBER_SHIFT_LIST) & FIELD_NUMBER_MASK_LIST;
        int i2 = (id << FIELD_NUMBER_SHIFT_ID) & FIELD_NUMBER_MASK_ID;
        int i3 = i2 | value | i;
        int i4 = i3 | (((isVendor ? 1 : 0) << FIELD_NUMBER_SHIFT_VENDOR) & FIELD_NUMBER_MASK_VENDOR);
        boolean zIsReserved = isReserved(i4);
        return (((zIsReserved ? 1 : 0) << FIELD_NUMBER_SHIFT_RESERVED) & FIELD_NUMBER_MASK_RESERVED) | i4;
    }
}
