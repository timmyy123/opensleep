package com.google.home.platform.traits;

import com.google.android.gms.internal.serialization.zzaar;
import com.google.android.gms.internal.serialization.zzaay;
import com.google.android.gms.internal.serialization.zzyy;
import com.google.android.gms.internal.serialization.zzyz;
import com.google.android.gms.internal.serialization.zzzf;
import com.google.android.gms.internal.serialization.zzzg;

/* JADX INFO: loaded from: classes4.dex */
public final class InvalidField extends zzzg<InvalidField, Builder> implements zzaar {
    private static final InvalidField DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int NAME_FIELD_NUMBER = 2;
    public static final int OPERAND_INDEX_FIELD_NUMBER = 3;
    private static volatile zzaay<InvalidField> PARSER;
    private int fieldCase_ = 0;
    private Object field_;
    private int operandIndex_;

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
        InvalidField invalidField = new InvalidField();
        DEFAULT_INSTANCE = invalidField;
        zzzg.registerDefaultInstance(InvalidField.class, invalidField);
    }

    private InvalidField() {
    }

    public static InvalidField getDefaultInstance() {
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
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0004\u0003\u0001\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001>\u0000\u0002Ȼ\u0000\u0003\u000b", new Object[]{"field_", "fieldCase_", "operandIndex_"});
        }
        if (iOrdinal == 3) {
            return new InvalidField();
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
        zzaay<InvalidField> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (InvalidField.class) {
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

    public int getOperandIndex() {
        return this.operandIndex_;
    }

    public static final class Builder extends zzyy<InvalidField, Builder> implements zzaar {
        private Builder() {
            super(InvalidField.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
