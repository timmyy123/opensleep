package com.google.home.platform.traits;

import com.google.android.gms.internal.serialization.zzaar;
import com.google.android.gms.internal.serialization.zzaay;
import com.google.android.gms.internal.serialization.zzyy;
import com.google.android.gms.internal.serialization.zzyz;
import com.google.android.gms.internal.serialization.zzzf;
import com.google.android.gms.internal.serialization.zzzg;
import com.google.android.gms.internal.serialization.zzzk;
import com.google.android.gms.internal.serialization.zzzl;
import com.google.android.gms.internal.serialization.zzzs;
import java.util.List;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public final class Expression extends zzzg<Expression, Builder> implements zzaar {
    private static final Expression DEFAULT_INSTANCE;
    public static final int EXPRESSION_ID_FIELD_NUMBER = 3;
    public static final int OPERANDS_FIELD_NUMBER = 2;
    public static final int OP_FIELD_NUMBER = 1;
    private static volatile zzaay<Expression> PARSER;
    private int bitField0_;
    private int op_;
    private zzzs<Operand> operands_ = zzzg.emptyProtobufList();
    private String expressionId_ = "";

    public enum Operator implements zzzk {
        OP_UNSPECIFIED(0),
        PLUS(1),
        MINUS(2),
        MULTIPLY(3),
        DIVIDE(4),
        EQUAL(5),
        NOT_EQUAL(6),
        GREATER_THAN(7),
        LESS_THAN(8),
        GREATER_THAN_OR_EQUAL(9),
        LESS_THAN_OR_EQUAL(10),
        BETWEEN(16),
        BETWEEN_TIMES(11),
        AND(12),
        OR(13),
        NOT(14),
        FIELD_SELECT(15),
        LIST_SIZE(17),
        LIST_IN(18),
        LIST_CONTAINS(19),
        LIST_GET(25),
        LIST_COMPREHENSION_ALL(20),
        LIST_COMPREHENSION_ANY(21),
        LIST_COMPREHENSION_NONE(22),
        LIST_COMPREHENSION_MAP(23),
        LIST_COMPREHENSION_FILTER(24),
        MAP_KEYS(26),
        MAP_VALUES(27),
        MAP_SIZE(28),
        MAP_COMPREHENSION_FILTER(29),
        GET_DEVICES_OF_TYPE(30),
        UNRECOGNIZED(-1);

        private static final zzzl<Operator> internalValueMap = new zzzl<Operator>() { // from class: com.google.home.platform.traits.Expression.Operator.1
            @Override // com.google.android.gms.internal.serialization.zzzl
            public Operator findValueByNumber(int i) {
                return Operator.forNumber(i);
            }
        };
        private final int value;

        Operator(int i) {
            this.value = i;
        }

        public static Operator forNumber(int i) {
            switch (i) {
                case 0:
                    return OP_UNSPECIFIED;
                case 1:
                    return PLUS;
                case 2:
                    return MINUS;
                case 3:
                    return MULTIPLY;
                case 4:
                    return DIVIDE;
                case 5:
                    return EQUAL;
                case 6:
                    return NOT_EQUAL;
                case 7:
                    return GREATER_THAN;
                case 8:
                    return LESS_THAN;
                case 9:
                    return GREATER_THAN_OR_EQUAL;
                case 10:
                    return LESS_THAN_OR_EQUAL;
                case 11:
                    return BETWEEN_TIMES;
                case 12:
                    return AND;
                case 13:
                    return OR;
                case 14:
                    return NOT;
                case 15:
                    return FIELD_SELECT;
                case 16:
                    return BETWEEN;
                case 17:
                    return LIST_SIZE;
                case 18:
                    return LIST_IN;
                case 19:
                    return LIST_CONTAINS;
                case 20:
                    return LIST_COMPREHENSION_ALL;
                case 21:
                    return LIST_COMPREHENSION_ANY;
                case 22:
                    return LIST_COMPREHENSION_NONE;
                case 23:
                    return LIST_COMPREHENSION_MAP;
                case 24:
                    return LIST_COMPREHENSION_FILTER;
                case 25:
                    return LIST_GET;
                case 26:
                    return MAP_KEYS;
                case 27:
                    return MAP_VALUES;
                case 28:
                    return MAP_SIZE;
                case 29:
                    return MAP_COMPREHENSION_FILTER;
                case 30:
                    return GET_DEVICES_OF_TYPE;
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

    static {
        Expression expression = new Expression();
        DEFAULT_INSTANCE = expression;
        zzzg.registerDefaultInstance(Expression.class, expression);
    }

    private Expression() {
    }

    public static Expression getDefaultInstance() {
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
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\f\u0002\u001b\u0003ለ\u0000", new Object[]{"bitField0_", "op_", "operands_", Operand.class, "expressionId_"});
        }
        if (iOrdinal == 3) {
            return new Expression();
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
        zzaay<Expression> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (Expression.class) {
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

    public String getExpressionId() {
        return this.expressionId_;
    }

    public Operator getOp() {
        Operator operatorForNumber = Operator.forNumber(this.op_);
        return operatorForNumber == null ? Operator.UNRECOGNIZED : operatorForNumber;
    }

    public List<Operand> getOperandsList() {
        return this.operands_;
    }

    public static final class Builder extends zzyy<Expression, Builder> implements zzaar {
        private Builder() {
            super(Expression.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
