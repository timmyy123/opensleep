package com.google.home.platform.traits;

import com.google.android.gms.internal.serialization.zzaar;
import com.google.android.gms.internal.serialization.zzaay;
import com.google.android.gms.internal.serialization.zzyy;
import com.google.android.gms.internal.serialization.zzyz;
import com.google.android.gms.internal.serialization.zzzf;
import com.google.android.gms.internal.serialization.zzzg;

/* JADX INFO: loaded from: classes4.dex */
public final class UIntRangeConstraint extends zzzg<UIntRangeConstraint, Builder> implements zzaar {
    public static final int DATA_TYPE_FIELD_NUMBER = 4;
    private static final UIntRangeConstraint DEFAULT_INSTANCE;
    public static final int LOWER_BOUND_FIELD_NUMBER = 1;
    private static volatile zzaay<UIntRangeConstraint> PARSER = null;
    public static final int STEP_FIELD_NUMBER = 3;
    public static final int UPPER_BOUND_FIELD_NUMBER = 2;
    private int bitField0_;
    private int dataType_;
    private long lowerBound_;
    private long step_;
    private long upperBound_;

    static {
        UIntRangeConstraint uIntRangeConstraint = new UIntRangeConstraint();
        DEFAULT_INSTANCE = uIntRangeConstraint;
        zzzg.registerDefaultInstance(UIntRangeConstraint.class, uIntRangeConstraint);
    }

    private UIntRangeConstraint() {
    }

    public static UIntRangeConstraint getDefaultInstance() {
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
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဃ\u0000\u0002ဃ\u0001\u0003ဃ\u0002\u0004ဌ\u0003", new Object[]{"bitField0_", "lowerBound_", "upperBound_", "step_", "dataType_"});
        }
        if (iOrdinal == 3) {
            return new UIntRangeConstraint();
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
        zzaay<UIntRangeConstraint> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (UIntRangeConstraint.class) {
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

    public long getLowerBound() {
        return this.lowerBound_;
    }

    public long getStep() {
        return this.step_;
    }

    public long getUpperBound() {
        return this.upperBound_;
    }

    public static final class Builder extends zzyy<UIntRangeConstraint, Builder> implements zzaar {
        private Builder() {
            super(UIntRangeConstraint.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
