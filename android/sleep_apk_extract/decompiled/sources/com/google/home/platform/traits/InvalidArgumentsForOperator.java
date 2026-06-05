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
public final class InvalidArgumentsForOperator extends zzzg<InvalidArgumentsForOperator, Builder> implements zzaar {
    public static final int ACTUAL_FIELD_NUMBER = 2;
    public static final int CANDIDATES_FIELD_NUMBER = 3;
    private static final InvalidArgumentsForOperator DEFAULT_INSTANCE;
    public static final int OP_FIELD_NUMBER = 1;
    private static volatile zzaay<InvalidArgumentsForOperator> PARSER;
    private ArgumentTypes actual_;
    private int bitField0_;
    private String op_ = "";
    private zzzs<ArgumentTypes> candidates_ = zzzg.emptyProtobufList();

    static {
        InvalidArgumentsForOperator invalidArgumentsForOperator = new InvalidArgumentsForOperator();
        DEFAULT_INSTANCE = invalidArgumentsForOperator;
        zzzg.registerDefaultInstance(InvalidArgumentsForOperator.class, invalidArgumentsForOperator);
    }

    private InvalidArgumentsForOperator() {
    }

    public static InvalidArgumentsForOperator getDefaultInstance() {
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
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001Ȉ\u0002ဉ\u0000\u0003\u001b", new Object[]{"bitField0_", "op_", "actual_", "candidates_", ArgumentTypes.class});
        }
        if (iOrdinal == 3) {
            return new InvalidArgumentsForOperator();
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
        zzaay<InvalidArgumentsForOperator> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (InvalidArgumentsForOperator.class) {
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

    public ArgumentTypes getActual() {
        ArgumentTypes argumentTypes = this.actual_;
        return argumentTypes == null ? ArgumentTypes.getDefaultInstance() : argumentTypes;
    }

    public List<ArgumentTypes> getCandidatesList() {
        return this.candidates_;
    }

    public String getOp() {
        return this.op_;
    }

    public static final class ArgumentTypes extends zzzg<ArgumentTypes, Builder> implements zzaar {
        private static final ArgumentTypes DEFAULT_INSTANCE;
        public static final int PARAMETERS_FIELD_NUMBER = 1;
        private static volatile zzaay<ArgumentTypes> PARSER;
        private zzzs<ValueType> parameters_ = zzzg.emptyProtobufList();

        static {
            ArgumentTypes argumentTypes = new ArgumentTypes();
            DEFAULT_INSTANCE = argumentTypes;
            zzzg.registerDefaultInstance(ArgumentTypes.class, argumentTypes);
        }

        private ArgumentTypes() {
        }

        public static ArgumentTypes getDefaultInstance() {
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
                return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"parameters_", ValueType.class});
            }
            if (iOrdinal == 3) {
                return new ArgumentTypes();
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
            zzaay<ArgumentTypes> zzaayVar = PARSER;
            if (zzaayVar != null) {
                return zzaayVar;
            }
            synchronized (ArgumentTypes.class) {
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

        public List<ValueType> getParametersList() {
            return this.parameters_;
        }

        public static final class Builder extends zzyy<ArgumentTypes, Builder> implements zzaar {
            private Builder() {
                super(ArgumentTypes.DEFAULT_INSTANCE);
            }

            public /* synthetic */ Builder(byte[] bArr) {
                this();
            }
        }
    }

    public static final class Builder extends zzyy<InvalidArgumentsForOperator, Builder> implements zzaar {
        private Builder() {
            super(InvalidArgumentsForOperator.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
