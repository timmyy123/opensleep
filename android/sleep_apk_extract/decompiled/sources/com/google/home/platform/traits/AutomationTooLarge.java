package com.google.home.platform.traits;

import com.google.android.gms.internal.serialization.zzaar;
import com.google.android.gms.internal.serialization.zzaay;
import com.google.android.gms.internal.serialization.zzyy;
import com.google.android.gms.internal.serialization.zzyz;
import com.google.android.gms.internal.serialization.zzzf;
import com.google.android.gms.internal.serialization.zzzg;

/* JADX INFO: loaded from: classes4.dex */
public final class AutomationTooLarge extends zzzg<AutomationTooLarge, Builder> implements zzaar {
    public static final int BYTE_COUNT_FIELD_NUMBER = 1;
    public static final int BYTE_COUNT_LIMIT_FIELD_NUMBER = 2;
    private static final AutomationTooLarge DEFAULT_INSTANCE;
    private static volatile zzaay<AutomationTooLarge> PARSER;
    private long byteCountLimit_;
    private long byteCount_;

    static {
        AutomationTooLarge automationTooLarge = new AutomationTooLarge();
        DEFAULT_INSTANCE = automationTooLarge;
        zzzg.registerDefaultInstance(AutomationTooLarge.class, automationTooLarge);
    }

    private AutomationTooLarge() {
    }

    public static AutomationTooLarge getDefaultInstance() {
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
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0004\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0003\u0002\u0003", new Object[]{"byteCount_", "byteCountLimit_"});
        }
        if (iOrdinal == 3) {
            return new AutomationTooLarge();
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
        zzaay<AutomationTooLarge> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (AutomationTooLarge.class) {
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

    public long getByteCount() {
        return this.byteCount_;
    }

    public long getByteCountLimit() {
        return this.byteCountLimit_;
    }

    public static final class Builder extends zzyy<AutomationTooLarge, Builder> implements zzaar {
        private Builder() {
            super(AutomationTooLarge.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
