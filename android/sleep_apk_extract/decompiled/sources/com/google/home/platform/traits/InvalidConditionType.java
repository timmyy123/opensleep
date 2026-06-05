package com.google.home.platform.traits;

import com.google.android.gms.internal.serialization.zzaar;
import com.google.android.gms.internal.serialization.zzaay;
import com.google.android.gms.internal.serialization.zzyy;
import com.google.android.gms.internal.serialization.zzyz;
import com.google.android.gms.internal.serialization.zzzf;
import com.google.android.gms.internal.serialization.zzzg;

/* JADX INFO: loaded from: classes4.dex */
public final class InvalidConditionType extends zzzg<InvalidConditionType, Builder> implements zzaar {
    public static final int ACTUAL_FIELD_NUMBER = 2;
    private static final InvalidConditionType DEFAULT_INSTANCE;
    public static final int EXPECTED_FIELD_NUMBER = 1;
    private static volatile zzaay<InvalidConditionType> PARSER;
    private ValueType actual_;
    private int bitField0_;
    private ValueType expected_;

    static {
        InvalidConditionType invalidConditionType = new InvalidConditionType();
        DEFAULT_INSTANCE = invalidConditionType;
        zzzg.registerDefaultInstance(InvalidConditionType.class, invalidConditionType);
    }

    private InvalidConditionType() {
    }

    public static InvalidConditionType getDefaultInstance() {
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
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"bitField0_", "expected_", "actual_"});
        }
        if (iOrdinal == 3) {
            return new InvalidConditionType();
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
        zzaay<InvalidConditionType> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (InvalidConditionType.class) {
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

    public static final class Builder extends zzyy<InvalidConditionType, Builder> implements zzaar {
        private Builder() {
            super(InvalidConditionType.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
