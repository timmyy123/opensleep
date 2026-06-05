package com.google.home.platform.traits;

import com.google.android.gms.internal.serialization.zzaar;
import com.google.android.gms.internal.serialization.zzaay;
import com.google.android.gms.internal.serialization.zzyl;
import com.google.android.gms.internal.serialization.zzyy;
import com.google.android.gms.internal.serialization.zzyz;
import com.google.android.gms.internal.serialization.zzzf;
import com.google.android.gms.internal.serialization.zzzg;

/* JADX INFO: loaded from: classes4.dex */
public final class ConditionDurationOutOfRange extends zzzg<ConditionDurationOutOfRange, Builder> implements zzaar {
    private static final ConditionDurationOutOfRange DEFAULT_INSTANCE;
    public static final int DURATION_FIELD_NUMBER = 1;
    private static volatile zzaay<ConditionDurationOutOfRange> PARSER;
    private int bitField0_;
    private zzyl duration_;

    static {
        ConditionDurationOutOfRange conditionDurationOutOfRange = new ConditionDurationOutOfRange();
        DEFAULT_INSTANCE = conditionDurationOutOfRange;
        zzzg.registerDefaultInstance(ConditionDurationOutOfRange.class, conditionDurationOutOfRange);
    }

    private ConditionDurationOutOfRange() {
    }

    public static ConditionDurationOutOfRange getDefaultInstance() {
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
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0004\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "duration_"});
        }
        if (iOrdinal == 3) {
            return new ConditionDurationOutOfRange();
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
        zzaay<ConditionDurationOutOfRange> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (ConditionDurationOutOfRange.class) {
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

    public zzyl getDuration() {
        zzyl zzylVar = this.duration_;
        return zzylVar == null ? zzyl.zze() : zzylVar;
    }

    public static final class Builder extends zzyy<ConditionDurationOutOfRange, Builder> implements zzaar {
        private Builder() {
            super(ConditionDurationOutOfRange.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
