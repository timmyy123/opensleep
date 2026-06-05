package com.google.home.platform.traits;

import com.google.android.gms.internal.serialization.zzaar;
import com.google.android.gms.internal.serialization.zzaay;
import com.google.android.gms.internal.serialization.zzyy;
import com.google.android.gms.internal.serialization.zzyz;
import com.google.android.gms.internal.serialization.zzzf;
import com.google.android.gms.internal.serialization.zzzg;

/* JADX INFO: loaded from: classes4.dex */
public final class InvalidArgumentCount extends zzzg<InvalidArgumentCount, Builder> implements zzaar {
    private static final InvalidArgumentCount DEFAULT_INSTANCE;
    public static final int MAX_OPERANDS_FIELD_NUMBER = 3;
    public static final int MIN_OPERANDS_FIELD_NUMBER = 2;
    public static final int OPERATOR_FIELD_NUMBER = 1;
    private static volatile zzaay<InvalidArgumentCount> PARSER;
    private int bitField0_;
    private int maxOperands_;
    private int minOperands_;
    private String operator_ = "";

    static {
        InvalidArgumentCount invalidArgumentCount = new InvalidArgumentCount();
        DEFAULT_INSTANCE = invalidArgumentCount;
        zzzg.registerDefaultInstance(InvalidArgumentCount.class, invalidArgumentCount);
    }

    private InvalidArgumentCount() {
    }

    public static InvalidArgumentCount getDefaultInstance() {
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
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002ဋ\u0000\u0003ဋ\u0001", new Object[]{"bitField0_", "operator_", "minOperands_", "maxOperands_"});
        }
        if (iOrdinal == 3) {
            return new InvalidArgumentCount();
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
        zzaay<InvalidArgumentCount> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (InvalidArgumentCount.class) {
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

    public int getMaxOperands() {
        return this.maxOperands_;
    }

    public int getMinOperands() {
        return this.minOperands_;
    }

    public String getOperator() {
        return this.operator_;
    }

    public static final class Builder extends zzyy<InvalidArgumentCount, Builder> implements zzaar {
        private Builder() {
            super(InvalidArgumentCount.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
