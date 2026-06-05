package com.google.home.platform.traits;

import com.google.android.gms.internal.serialization.zzaar;
import com.google.android.gms.internal.serialization.zzaay;
import com.google.android.gms.internal.serialization.zzyy;
import com.google.android.gms.internal.serialization.zzyz;
import com.google.android.gms.internal.serialization.zzzf;
import com.google.android.gms.internal.serialization.zzzg;

/* JADX INFO: loaded from: classes4.dex */
public final class Operand extends zzzg<Operand, Builder> implements zzaar {
    public static final int CONSTANT_FIELD_NUMBER = 1;
    private static final Operand DEFAULT_INSTANCE;
    public static final int EXPRESSION_FIELD_NUMBER = 3;
    public static final int FIELD_ID_FIELD_NUMBER = 4;
    public static final int FIELD_NAME_FIELD_NUMBER = 5;
    private static volatile zzaay<Operand> PARSER = null;
    public static final int REFERENCE_DECLARATION_FIELD_NUMBER = 6;
    public static final int REFERENCE_FIELD_NUMBER = 2;
    private int typeCase_ = 0;
    private Object type_;

    public enum TypeCase {
        CONSTANT(1),
        REFERENCE(2),
        EXPRESSION(3),
        FIELD_ID(4),
        FIELD_NAME(5),
        REFERENCE_DECLARATION(6),
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
                    return CONSTANT;
                case 2:
                    return REFERENCE;
                case 3:
                    return EXPRESSION;
                case 4:
                    return FIELD_ID;
                case 5:
                    return FIELD_NAME;
                case 6:
                    return REFERENCE_DECLARATION;
                default:
                    return null;
            }
        }
    }

    static {
        Operand operand = new Operand();
        DEFAULT_INSTANCE = operand;
        zzzg.registerDefaultInstance(Operand.class, operand);
    }

    private Operand() {
    }

    @Override // com.google.android.gms.internal.serialization.zzzg
    public final Object dynamicMethod(zzzf zzzfVar, Object obj, Object obj2) {
        zzaay zzyzVar;
        int iOrdinal = zzzfVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0004\u0006\u0001\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001<\u0000\u0002Ȼ\u0000\u0003<\u0000\u0004>\u0000\u0005Ȼ\u0000\u0006Ȼ\u0000", new Object[]{"type_", "typeCase_", Value.class, Expression.class});
        }
        if (iOrdinal == 3) {
            return new Operand();
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
        zzaay<Operand> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (Operand.class) {
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

    public Value getConstant() {
        return this.typeCase_ == 1 ? (Value) this.type_ : Value.getDefaultInstance();
    }

    public Expression getExpression() {
        return this.typeCase_ == 3 ? (Expression) this.type_ : Expression.getDefaultInstance();
    }

    public int getFieldId() {
        if (this.typeCase_ == 4) {
            return ((Integer) this.type_).intValue();
        }
        return 0;
    }

    public String getFieldName() {
        return this.typeCase_ == 5 ? (String) this.type_ : "";
    }

    public String getReference() {
        return this.typeCase_ == 2 ? (String) this.type_ : "";
    }

    public String getReferenceDeclaration() {
        return this.typeCase_ == 6 ? (String) this.type_ : "";
    }

    public TypeCase getTypeCase() {
        return TypeCase.forNumber(this.typeCase_);
    }

    public static final class Builder extends zzyy<Operand, Builder> implements zzaar {
        private Builder() {
            super(Operand.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
