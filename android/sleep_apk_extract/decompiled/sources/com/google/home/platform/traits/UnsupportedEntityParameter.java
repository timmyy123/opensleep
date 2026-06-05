package com.google.home.platform.traits;

import com.google.android.gms.internal.serialization.zzaar;
import com.google.android.gms.internal.serialization.zzaay;
import com.google.android.gms.internal.serialization.zzyy;
import com.google.android.gms.internal.serialization.zzyz;
import com.google.android.gms.internal.serialization.zzzf;
import com.google.android.gms.internal.serialization.zzzg;

/* JADX INFO: loaded from: classes4.dex */
public final class UnsupportedEntityParameter extends zzzg<UnsupportedEntityParameter, Builder> implements zzaar {
    public static final int COMMAND_ID_FIELD_NUMBER = 7;
    private static final UnsupportedEntityParameter DEFAULT_INSTANCE;
    public static final int ENTITY_OBJECT_ID_FIELD_NUMBER = 8;
    public static final int ENTITY_TYPE_FIELD_NUMBER = 9;
    public static final int EVENT_ID_FIELD_NUMBER = 6;
    public static final int FIELD_ID_FIELD_NUMBER = 4;
    public static final int PARAMETER_NAME_FIELD_NUMBER = 1;
    private static volatile zzaay<UnsupportedEntityParameter> PARSER = null;
    public static final int TRAIT_ID_FIELD_NUMBER = 5;
    private Object behaviorType_;
    private int fieldId_;
    private int behaviorTypeCase_ = 0;
    private String parameterName_ = "";
    private String entityObjectId_ = "";
    private String entityType_ = "";

    static {
        UnsupportedEntityParameter unsupportedEntityParameter = new UnsupportedEntityParameter();
        DEFAULT_INSTANCE = unsupportedEntityParameter;
        zzzg.registerDefaultInstance(UnsupportedEntityParameter.class, unsupportedEntityParameter);
    }

    private UnsupportedEntityParameter() {
    }

    public static UnsupportedEntityParameter getDefaultInstance() {
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
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0004\u0007\u0001\u0000\u0001\t\u0007\u0000\u0000\u0000\u0001Ȉ\u0004\u000b\u0005Ȼ\u0000\u0006Ȼ\u0000\u0007Ȼ\u0000\bȈ\tȈ", new Object[]{"behaviorType_", "behaviorTypeCase_", "parameterName_", "fieldId_", "entityObjectId_", "entityType_"});
        }
        if (iOrdinal == 3) {
            return new UnsupportedEntityParameter();
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
        zzaay<UnsupportedEntityParameter> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (UnsupportedEntityParameter.class) {
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

    public String getCommandId() {
        return this.behaviorTypeCase_ == 7 ? (String) this.behaviorType_ : "";
    }

    public String getEntityObjectId() {
        return this.entityObjectId_;
    }

    public String getEntityType() {
        return this.entityType_;
    }

    public String getEventId() {
        return this.behaviorTypeCase_ == 6 ? (String) this.behaviorType_ : "";
    }

    public int getFieldId() {
        return this.fieldId_;
    }

    public String getParameterName() {
        return this.parameterName_;
    }

    public String getTraitId() {
        return this.behaviorTypeCase_ == 5 ? (String) this.behaviorType_ : "";
    }

    public static final class Builder extends zzyy<UnsupportedEntityParameter, Builder> implements zzaar {
        private Builder() {
            super(UnsupportedEntityParameter.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
