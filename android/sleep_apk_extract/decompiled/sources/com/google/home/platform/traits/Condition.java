package com.google.home.platform.traits;

import com.google.android.gms.internal.serialization.zzaay;
import com.google.android.gms.internal.serialization.zzyl;
import com.google.android.gms.internal.serialization.zzyy;
import com.google.android.gms.internal.serialization.zzyz;
import com.google.android.gms.internal.serialization.zzzf;
import com.google.android.gms.internal.serialization.zzzg;

/* JADX INFO: loaded from: classes4.dex */
public final class Condition extends zzzg<Condition, Builder> implements ConditionOrBuilder {
    private static final Condition DEFAULT_INSTANCE;
    public static final int EXPRESSION_FIELD_NUMBER = 2;
    public static final int EXPRESSION_STRING_FIELD_NUMBER = 1;
    public static final int FOR_DURATION_FIELD_NUMBER = 5;
    public static final int ON_EXPRESSION_TRANSITIONING_TO_TRUE_FIELD_NUMBER = 4;
    private static volatile zzaay<Condition> PARSER = null;
    public static final int REFERENCE_FIELD_NUMBER = 3;
    private int bitField0_;
    private Object expressionType_;
    private zzyl forDuration_;
    private boolean onExpressionTransitioningToTrue_;
    private int expressionTypeCase_ = 0;
    private String expressionString_ = "";

    public enum ExpressionTypeCase {
        EXPRESSION(2),
        REFERENCE(3),
        EXPRESSIONTYPE_NOT_SET(0);

        private final int value;

        ExpressionTypeCase(int i) {
            this.value = i;
        }

        public static ExpressionTypeCase forNumber(int i) {
            if (i == 0) {
                return EXPRESSIONTYPE_NOT_SET;
            }
            if (i == 2) {
                return EXPRESSION;
            }
            if (i != 3) {
                return null;
            }
            return REFERENCE;
        }
    }

    static {
        Condition condition = new Condition();
        DEFAULT_INSTANCE = condition;
        zzzg.registerDefaultInstance(Condition.class, condition);
    }

    private Condition() {
    }

    public static Condition getDefaultInstance() {
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
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0004\u0005\u0001\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ለ\u0000\u0002<\u0000\u0003Ȼ\u0000\u0004ဇ\u0001\u0005ဉ\u0002", new Object[]{"expressionType_", "expressionTypeCase_", "bitField0_", "expressionString_", Expression.class, "onExpressionTransitioningToTrue_", "forDuration_"});
        }
        if (iOrdinal == 3) {
            return new Condition();
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
        zzaay<Condition> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (Condition.class) {
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

    public Expression getExpression() {
        return this.expressionTypeCase_ == 2 ? (Expression) this.expressionType_ : Expression.getDefaultInstance();
    }

    public ExpressionTypeCase getExpressionTypeCase() {
        return ExpressionTypeCase.forNumber(this.expressionTypeCase_);
    }

    @Override // com.google.home.platform.traits.ConditionOrBuilder
    public zzyl getForDuration() {
        zzyl zzylVar = this.forDuration_;
        return zzylVar == null ? zzyl.zze() : zzylVar;
    }

    public String getReference() {
        return this.expressionTypeCase_ == 3 ? (String) this.expressionType_ : "";
    }

    @Override // com.google.home.platform.traits.ConditionOrBuilder
    public boolean hasForDuration() {
        return (this.bitField0_ & 4) != 0;
    }

    public static final class Builder extends zzyy<Condition, Builder> implements ConditionOrBuilder {
        private Builder() {
            super(Condition.DEFAULT_INSTANCE);
        }

        @Override // com.google.home.platform.traits.ConditionOrBuilder
        public zzyl getForDuration() {
            return ((Condition) this.instance).getForDuration();
        }

        @Override // com.google.home.platform.traits.ConditionOrBuilder
        public boolean hasForDuration() {
            return ((Condition) this.instance).hasForDuration();
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
