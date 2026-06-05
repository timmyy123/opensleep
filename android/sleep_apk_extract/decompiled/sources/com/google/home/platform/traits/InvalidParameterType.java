package com.google.home.platform.traits;

import com.google.android.gms.internal.serialization.zzaar;
import com.google.android.gms.internal.serialization.zzaay;
import com.google.android.gms.internal.serialization.zzyy;
import com.google.android.gms.internal.serialization.zzyz;
import com.google.android.gms.internal.serialization.zzzf;
import com.google.android.gms.internal.serialization.zzzg;

/* JADX INFO: loaded from: classes4.dex */
public final class InvalidParameterType extends zzzg<InvalidParameterType, Builder> implements zzaar {
    public static final int ACTUAL_FIELD_NUMBER = 4;
    private static final InvalidParameterType DEFAULT_INSTANCE;
    public static final int EXPECTED_FIELD_NUMBER = 3;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int NAME_FIELD_NUMBER = 2;
    private static volatile zzaay<InvalidParameterType> PARSER;
    private ValueType actual_;
    private int bitField0_;
    private ValueType expected_;
    private int fieldCase_ = 0;
    private Object field_;

    public enum FieldCase {
        ID(1),
        NAME(2),
        FIELD_NOT_SET(0);

        private final int value;

        FieldCase(int i) {
            this.value = i;
        }

        public static FieldCase forNumber(int i) {
            if (i == 0) {
                return FIELD_NOT_SET;
            }
            if (i == 1) {
                return ID;
            }
            if (i != 2) {
                return null;
            }
            return NAME;
        }
    }

    static {
        InvalidParameterType invalidParameterType = new InvalidParameterType();
        DEFAULT_INSTANCE = invalidParameterType;
        zzzg.registerDefaultInstance(InvalidParameterType.class, invalidParameterType);
    }

    private InvalidParameterType() {
    }

    public static InvalidParameterType getDefaultInstance() {
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
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0004\u0004\u0001\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001>\u0000\u0002Ȼ\u0000\u0003ဉ\u0000\u0004ဉ\u0001", new Object[]{"field_", "fieldCase_", "bitField0_", "expected_", "actual_"});
        }
        if (iOrdinal == 3) {
            return new InvalidParameterType();
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
        zzaay<InvalidParameterType> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (InvalidParameterType.class) {
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

    public ValueType getActual() {
        ValueType valueType = this.actual_;
        return valueType == null ? ValueType.getDefaultInstance() : valueType;
    }

    public ValueType getExpected() {
        ValueType valueType = this.expected_;
        return valueType == null ? ValueType.getDefaultInstance() : valueType;
    }

    public FieldCase getFieldCase() {
        return FieldCase.forNumber(this.fieldCase_);
    }

    public int getId() {
        if (this.fieldCase_ == 1) {
            return ((Integer) this.field_).intValue();
        }
        return 0;
    }

    public String getName() {
        return this.fieldCase_ == 2 ? (String) this.field_ : "";
    }

    public static final class Builder extends zzyy<InvalidParameterType, Builder> implements zzaar {
        private Builder() {
            super(InvalidParameterType.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
