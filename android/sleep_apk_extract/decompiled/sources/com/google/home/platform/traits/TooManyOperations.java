package com.google.home.platform.traits;

import com.google.android.gms.internal.serialization.zzaar;
import com.google.android.gms.internal.serialization.zzaay;
import com.google.android.gms.internal.serialization.zzyy;
import com.google.android.gms.internal.serialization.zzyz;
import com.google.android.gms.internal.serialization.zzzf;
import com.google.android.gms.internal.serialization.zzzg;

/* JADX INFO: loaded from: classes4.dex */
public final class TooManyOperations extends zzzg<TooManyOperations, Builder> implements zzaar {
    private static final TooManyOperations DEFAULT_INSTANCE;
    public static final int OPERATION_COUNT_FIELD_NUMBER = 1;
    public static final int OPERATION_COUNT_LIMIT_FIELD_NUMBER = 2;
    private static volatile zzaay<TooManyOperations> PARSER;
    private int operationCountLimit_;
    private int operationCount_;

    static {
        TooManyOperations tooManyOperations = new TooManyOperations();
        DEFAULT_INSTANCE = tooManyOperations;
        zzzg.registerDefaultInstance(TooManyOperations.class, tooManyOperations);
    }

    private TooManyOperations() {
    }

    public static TooManyOperations getDefaultInstance() {
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
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0004\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[]{"operationCount_", "operationCountLimit_"});
        }
        if (iOrdinal == 3) {
            return new TooManyOperations();
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
        zzaay<TooManyOperations> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (TooManyOperations.class) {
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

    public int getOperationCount() {
        return this.operationCount_;
    }

    public int getOperationCountLimit() {
        return this.operationCountLimit_;
    }

    public static final class Builder extends zzyy<TooManyOperations, Builder> implements zzaar {
        private Builder() {
            super(TooManyOperations.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
