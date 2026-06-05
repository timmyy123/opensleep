package com.google.home.platform.traits;

import com.google.android.gms.internal.serialization.zzaar;
import com.google.android.gms.internal.serialization.zzaay;
import com.google.android.gms.internal.serialization.zzyy;
import com.google.android.gms.internal.serialization.zzyz;
import com.google.android.gms.internal.serialization.zzzf;
import com.google.android.gms.internal.serialization.zzzg;

/* JADX INFO: loaded from: classes4.dex */
public final class InvalidParameter extends zzzg<InvalidParameter, Builder> implements zzaar {
    public static final int BEHAVIOR_ID_FIELD_NUMBER = 2;
    public static final int COMMAND_ID_FIELD_NUMBER = 5;
    private static final InvalidParameter DEFAULT_INSTANCE;
    public static final int EVENT_ID_FIELD_NUMBER = 4;
    public static final int PARAMETER_NAME_FIELD_NUMBER = 1;
    private static volatile zzaay<InvalidParameter> PARSER = null;
    public static final int TRAIT_ID_FIELD_NUMBER = 3;
    private Object behaviorType_;
    private int behaviorTypeCase_ = 0;
    private String parameterName_ = "";
    private String behaviorId_ = "";

    public enum BehaviorTypeCase {
        TRAIT_ID(3),
        EVENT_ID(4),
        COMMAND_ID(5),
        BEHAVIORTYPE_NOT_SET(0);

        private final int value;

        BehaviorTypeCase(int i) {
            this.value = i;
        }

        public static BehaviorTypeCase forNumber(int i) {
            if (i == 0) {
                return BEHAVIORTYPE_NOT_SET;
            }
            if (i == 3) {
                return TRAIT_ID;
            }
            if (i == 4) {
                return EVENT_ID;
            }
            if (i != 5) {
                return null;
            }
            return COMMAND_ID;
        }
    }

    static {
        InvalidParameter invalidParameter = new InvalidParameter();
        DEFAULT_INSTANCE = invalidParameter;
        zzzg.registerDefaultInstance(InvalidParameter.class, invalidParameter);
    }

    private InvalidParameter() {
    }

    public static InvalidParameter getDefaultInstance() {
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
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0004\u0005\u0001\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȼ\u0000\u0004Ȼ\u0000\u0005Ȼ\u0000", new Object[]{"behaviorType_", "behaviorTypeCase_", "parameterName_", "behaviorId_"});
        }
        if (iOrdinal == 3) {
            return new InvalidParameter();
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
        zzaay<InvalidParameter> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (InvalidParameter.class) {
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

    public BehaviorTypeCase getBehaviorTypeCase() {
        return BehaviorTypeCase.forNumber(this.behaviorTypeCase_);
    }

    public String getCommandId() {
        return this.behaviorTypeCase_ == 5 ? (String) this.behaviorType_ : "";
    }

    public String getEventId() {
        return this.behaviorTypeCase_ == 4 ? (String) this.behaviorType_ : "";
    }

    public String getParameterName() {
        return this.parameterName_;
    }

    public String getTraitId() {
        return this.behaviorTypeCase_ == 3 ? (String) this.behaviorType_ : "";
    }

    public static final class Builder extends zzyy<InvalidParameter, Builder> implements zzaar {
        private Builder() {
            super(InvalidParameter.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
