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
public final class InvalidOperand extends zzzg<InvalidOperand, Builder> implements zzaar {
    private static final InvalidOperand DEFAULT_INSTANCE;
    public static final int OPERAND_INDEX_FIELD_NUMBER = 2;
    public static final int OPERAND_TYPE_FIELD_NUMBER = 3;
    public static final int OPERATOR_FIELD_NUMBER = 1;
    private static volatile zzaay<InvalidOperand> PARSER = null;
    public static final int VALID_OPERAND_TYPES_FIELD_NUMBER = 4;
    private int operandIndex_;
    private String operator_ = "";
    private String operandType_ = "";
    private zzzs<String> validOperandTypes_ = zzzg.emptyProtobufList();

    static {
        InvalidOperand invalidOperand = new InvalidOperand();
        DEFAULT_INSTANCE = invalidOperand;
        zzzg.registerDefaultInstance(InvalidOperand.class, invalidOperand);
    }

    private InvalidOperand() {
    }

    public static InvalidOperand getDefaultInstance() {
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
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0004\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0001\u0000\u0001Ȉ\u0002\u000b\u0003Ȉ\u0004Ț", new Object[]{"operator_", "operandIndex_", "operandType_", "validOperandTypes_"});
        }
        if (iOrdinal == 3) {
            return new InvalidOperand();
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
        zzaay<InvalidOperand> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (InvalidOperand.class) {
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

    public int getOperandIndex() {
        return this.operandIndex_;
    }

    public String getOperandType() {
        return this.operandType_;
    }

    public String getOperator() {
        return this.operator_;
    }

    public List<String> getValidOperandTypesList() {
        return this.validOperandTypes_;
    }

    public static final class Builder extends zzyy<InvalidOperand, Builder> implements zzaar {
        private Builder() {
            super(InvalidOperand.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
