package com.google.home.platform.traits;

import com.google.android.gms.internal.serialization.zzaar;
import com.google.android.gms.internal.serialization.zzaay;
import com.google.android.gms.internal.serialization.zzyy;
import com.google.android.gms.internal.serialization.zzyz;
import com.google.android.gms.internal.serialization.zzzf;
import com.google.android.gms.internal.serialization.zzzg;

/* JADX INFO: loaded from: classes4.dex */
public final class UnsupportedActionBehavior extends zzzg<UnsupportedActionBehavior, Builder> implements zzaar {
    public static final int BEHAVIOR_TYPE_FIELD_NUMBER = 1;
    private static final UnsupportedActionBehavior DEFAULT_INSTANCE;
    private static volatile zzaay<UnsupportedActionBehavior> PARSER;
    private String behaviorType_ = "";

    static {
        UnsupportedActionBehavior unsupportedActionBehavior = new UnsupportedActionBehavior();
        DEFAULT_INSTANCE = unsupportedActionBehavior;
        zzzg.registerDefaultInstance(UnsupportedActionBehavior.class, unsupportedActionBehavior);
    }

    private UnsupportedActionBehavior() {
    }

    public static UnsupportedActionBehavior getDefaultInstance() {
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
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"behaviorType_"});
        }
        if (iOrdinal == 3) {
            return new UnsupportedActionBehavior();
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
        zzaay<UnsupportedActionBehavior> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (UnsupportedActionBehavior.class) {
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

    public String getBehaviorType() {
        return this.behaviorType_;
    }

    public static final class Builder extends zzyy<UnsupportedActionBehavior, Builder> implements zzaar {
        private Builder() {
            super(UnsupportedActionBehavior.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
