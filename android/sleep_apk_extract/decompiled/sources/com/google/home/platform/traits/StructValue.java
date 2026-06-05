package com.google.home.platform.traits;

import com.google.android.gms.internal.serialization.zzaar;
import com.google.android.gms.internal.serialization.zzaay;
import com.google.android.gms.internal.serialization.zzyy;
import com.google.android.gms.internal.serialization.zzyz;
import com.google.android.gms.internal.serialization.zzzf;
import com.google.android.gms.internal.serialization.zzzg;
import com.google.android.gms.internal.serialization.zzzs;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class StructValue extends zzzg<StructValue, Builder> implements zzaar {
    private static final StructValue DEFAULT_INSTANCE;
    public static final int FIELDS_FIELD_NUMBER = 2;
    private static volatile zzaay<StructValue> PARSER = null;
    public static final int TYPE_ID_FIELD_NUMBER = 1;
    private String typeId_ = "";
    private zzzs<Field> fields_ = zzzg.emptyProtobufList();

    static {
        StructValue structValue = new StructValue();
        DEFAULT_INSTANCE = structValue;
        zzzg.registerDefaultInstance(StructValue.class, structValue);
    }

    private StructValue() {
    }

    public static StructValue getDefaultInstance() {
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
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0004\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"typeId_", "fields_", Field.class});
        }
        if (iOrdinal == 3) {
            return new StructValue();
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
        zzaay<StructValue> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (StructValue.class) {
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

    public List<Field> getFieldsList() {
        return this.fields_;
    }

    public static final class Field extends zzzg<Field, Builder> implements zzaar {
        private static final Field DEFAULT_INSTANCE;
        public static final int ID_FIELD_NUMBER = 1;
        public static final int NAME_FIELD_NUMBER = 2;
        private static volatile zzaay<Field> PARSER = null;
        public static final int VALUE_FIELD_NUMBER = 3;
        private int bitField0_;
        private int fieldIdentifierCase_ = 0;
        private Object fieldIdentifier_;
        private Value value_;

        static {
            Field field = new Field();
            DEFAULT_INSTANCE = field;
            zzzg.registerDefaultInstance(Field.class, field);
        }

        private Field() {
        }

        @Override // com.google.android.gms.internal.serialization.zzzg
        public final Object dynamicMethod(zzzf zzzfVar, Object obj, Object obj2) {
            zzaay zzyzVar;
            int iOrdinal = zzzfVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0004\u0003\u0001\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001>\u0000\u0002Ȼ\u0000\u0003ဉ\u0000", new Object[]{"fieldIdentifier_", "fieldIdentifierCase_", "bitField0_", "value_"});
            }
            if (iOrdinal == 3) {
                return new Field();
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
            zzaay<Field> zzaayVar = PARSER;
            if (zzaayVar != null) {
                return zzaayVar;
            }
            synchronized (Field.class) {
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

        public Value getValue() {
            Value value = this.value_;
            return value == null ? Value.getDefaultInstance() : value;
        }

        public static final class Builder extends zzyy<Field, Builder> implements zzaar {
            private Builder() {
                super(Field.DEFAULT_INSTANCE);
            }

            public /* synthetic */ Builder(byte[] bArr) {
                this();
            }
        }
    }

    public static final class Builder extends zzyy<StructValue, Builder> implements zzaar {
        private Builder() {
            super(StructValue.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
