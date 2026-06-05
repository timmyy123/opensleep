package com.google.home.platform.traits;

import com.google.android.gms.internal.serialization.zzaar;
import com.google.android.gms.internal.serialization.zzaay;
import com.google.android.gms.internal.serialization.zzyy;
import com.google.android.gms.internal.serialization.zzyz;
import com.google.android.gms.internal.serialization.zzzf;
import com.google.android.gms.internal.serialization.zzzg;
import com.google.android.gms.internal.serialization.zzzk;
import com.google.android.gms.internal.serialization.zzzl;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public final class ValueType extends zzzg<ValueType, Builder> implements zzaar {
    private static final ValueType DEFAULT_INSTANCE;
    public static final int DEFINITION_TYPE_FIELD_NUMBER = 8;
    public static final int ENTITY_TYPE_FIELD_NUMBER = 7;
    public static final int ENUM_TYPE_FIELD_NUMBER = 3;
    public static final int LIST_TYPE_FIELD_NUMBER = 4;
    public static final int MAP_TYPE_FIELD_NUMBER = 6;
    private static volatile zzaay<ValueType> PARSER = null;
    public static final int PRIMITIVE_TYPE_FIELD_NUMBER = 1;
    public static final int STRUCT_TYPE_FIELD_NUMBER = 2;
    public static final int WILDCARD_TYPE_FIELD_NUMBER = 5;
    private int typeCase_ = 0;
    private Object type_;

    public enum DefinitionType implements zzzk {
        DT_UNSPECIFIED(0),
        DT_ENTITY_TYPE(1),
        UNRECOGNIZED(-1);

        private static final zzzl<DefinitionType> internalValueMap = new zzzl<DefinitionType>() { // from class: com.google.home.platform.traits.ValueType.DefinitionType.1
            @Override // com.google.android.gms.internal.serialization.zzzl
            public DefinitionType findValueByNumber(int i) {
                return DefinitionType.forNumber(i);
            }
        };
        private final int value;

        DefinitionType(int i) {
            this.value = i;
        }

        public static DefinitionType forNumber(int i) {
            if (i == 0) {
                return DT_UNSPECIFIED;
            }
            if (i != 1) {
                return null;
            }
            return DT_ENTITY_TYPE;
        }

        @Override // com.google.android.gms.internal.serialization.zzzk
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            Utf8$$ExternalSyntheticBUOutline0.m$2("Can't get the number of an unknown enum value.");
            return 0;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return Integer.toString(getNumber());
        }
    }

    public enum PrimitiveType implements zzzk {
        PT_UNSPECIFIED(0),
        PT_INT(1),
        PT_UINT(2),
        PT_DOUBLE(3),
        PT_STRING(4),
        PT_BOOL(5),
        PT_BYTES(6),
        UNRECOGNIZED(-1);

        private static final zzzl<PrimitiveType> internalValueMap = new zzzl<PrimitiveType>() { // from class: com.google.home.platform.traits.ValueType.PrimitiveType.1
            @Override // com.google.android.gms.internal.serialization.zzzl
            public PrimitiveType findValueByNumber(int i) {
                return PrimitiveType.forNumber(i);
            }
        };
        private final int value;

        PrimitiveType(int i) {
            this.value = i;
        }

        public static PrimitiveType forNumber(int i) {
            switch (i) {
                case 0:
                    return PT_UNSPECIFIED;
                case 1:
                    return PT_INT;
                case 2:
                    return PT_UINT;
                case 3:
                    return PT_DOUBLE;
                case 4:
                    return PT_STRING;
                case 5:
                    return PT_BOOL;
                case 6:
                    return PT_BYTES;
                default:
                    return null;
            }
        }

        @Override // com.google.android.gms.internal.serialization.zzzk
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            Utf8$$ExternalSyntheticBUOutline0.m$2("Can't get the number of an unknown enum value.");
            return 0;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return Integer.toString(getNumber());
        }
    }

    public enum TypeCase {
        PRIMITIVE_TYPE(1),
        DEFINITION_TYPE(8),
        STRUCT_TYPE(2),
        ENUM_TYPE(3),
        LIST_TYPE(4),
        MAP_TYPE(6),
        ENTITY_TYPE(7),
        WILDCARD_TYPE(5),
        TYPE_NOT_SET(0);

        private final int value;

        TypeCase(int i) {
            this.value = i;
        }

        public static TypeCase forNumber(int i) {
            switch (i) {
                case 0:
                    return TYPE_NOT_SET;
                case 1:
                    return PRIMITIVE_TYPE;
                case 2:
                    return STRUCT_TYPE;
                case 3:
                    return ENUM_TYPE;
                case 4:
                    return LIST_TYPE;
                case 5:
                    return WILDCARD_TYPE;
                case 6:
                    return MAP_TYPE;
                case 7:
                    return ENTITY_TYPE;
                case 8:
                    return DEFINITION_TYPE;
                default:
                    return null;
            }
        }
    }

    static {
        ValueType valueType = new ValueType();
        DEFAULT_INSTANCE = valueType;
        zzzg.registerDefaultInstance(ValueType.class, valueType);
    }

    private ValueType() {
    }

    public static ValueType getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.android.gms.internal.serialization.zzzg
    public final Object dynamicMethod(zzzf zzzfVar, Object obj, Object obj2) {
        zzaay zzyzVar;
        int iOrdinal = zzzfVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0004\b\u0001\u0000\u0001\b\b\u0000\u0000\u0000\u0001?\u0000\u0002Ȼ\u0000\u0003Ȼ\u0000\u0004<\u0000\u0005Ȼ\u0000\u0006<\u0000\u0007Ȼ\u0000\b?\u0000", new Object[]{"type_", "typeCase_", ListType.class, MapType.class});
        }
        if (iOrdinal == 3) {
            return new ValueType();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new Builder(bArr);
        }
        if (iOrdinal == 5) {
            return DEFAULT_INSTANCE;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzaay<ValueType> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (ValueType.class) {
            try {
                zzyzVar = PARSER;
                if (zzyzVar == null) {
                    zzyzVar = new zzyz(DEFAULT_INSTANCE);
                    PARSER = zzyzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzyzVar;
    }

    public DefinitionType getDefinitionType() {
        if (this.typeCase_ != 8) {
            return DefinitionType.DT_UNSPECIFIED;
        }
        DefinitionType definitionTypeForNumber = DefinitionType.forNumber(((Integer) this.type_).intValue());
        return definitionTypeForNumber == null ? DefinitionType.UNRECOGNIZED : definitionTypeForNumber;
    }

    public String getEntityType() {
        return this.typeCase_ == 7 ? (String) this.type_ : "";
    }

    public String getEnumType() {
        return this.typeCase_ == 3 ? (String) this.type_ : "";
    }

    public ListType getListType() {
        return this.typeCase_ == 4 ? (ListType) this.type_ : ListType.getDefaultInstance();
    }

    public MapType getMapType() {
        return this.typeCase_ == 6 ? (MapType) this.type_ : MapType.getDefaultInstance();
    }

    public PrimitiveType getPrimitiveType() {
        if (this.typeCase_ != 1) {
            return PrimitiveType.PT_UNSPECIFIED;
        }
        PrimitiveType primitiveTypeForNumber = PrimitiveType.forNumber(((Integer) this.type_).intValue());
        return primitiveTypeForNumber == null ? PrimitiveType.UNRECOGNIZED : primitiveTypeForNumber;
    }

    public String getStructType() {
        return this.typeCase_ == 2 ? (String) this.type_ : "";
    }

    public TypeCase getTypeCase() {
        return TypeCase.forNumber(this.typeCase_);
    }

    public String getWildcardType() {
        return this.typeCase_ == 5 ? (String) this.type_ : "";
    }

    public static final class Builder extends zzyy<ValueType, Builder> implements zzaar {
        private Builder() {
            super(ValueType.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
