package com.google.home.platform.traits;

import com.google.android.gms.internal.serialization.zzaar;
import com.google.android.gms.internal.serialization.zzaay;
import com.google.android.gms.internal.serialization.zzyy;
import com.google.android.gms.internal.serialization.zzyz;
import com.google.android.gms.internal.serialization.zzzf;
import com.google.android.gms.internal.serialization.zzzg;

/* JADX INFO: loaded from: classes4.dex */
public final class UnsupportedEntityParameterValue extends zzzg<UnsupportedEntityParameterValue, Builder> implements zzaar {
    public static final int COMMAND_ID_FIELD_NUMBER = 9;
    private static final UnsupportedEntityParameterValue DEFAULT_INSTANCE;
    public static final int ENTITY_OBJECT_ID_FIELD_NUMBER = 10;
    public static final int ENTITY_TYPE_FIELD_NUMBER = 11;
    public static final int EVENT_ID_FIELD_NUMBER = 8;
    public static final int FIELD_ID_FIELD_NUMBER = 6;
    public static final int PARAMETER_NAME_FIELD_NUMBER = 1;
    private static volatile zzaay<UnsupportedEntityParameterValue> PARSER = null;
    public static final int TRAIT_ID_FIELD_NUMBER = 7;
    public static final int VALUE_CONSTRAINT_FIELD_NUMBER = 5;
    public static final int VALUE_FIELD_NUMBER = 4;
    private Object behaviorType_;
    private int bitField0_;
    private int fieldId_;
    private ValueTypeConstraint valueConstraint_;
    private Value value_;
    private int behaviorTypeCase_ = 0;
    private String parameterName_ = "";
    private String entityObjectId_ = "";
    private String entityType_ = "";

    public enum BehaviorTypeCase {
        TRAIT_ID(7),
        EVENT_ID(8),
        COMMAND_ID(9),
        BEHAVIORTYPE_NOT_SET(0);

        private final int value;

        BehaviorTypeCase(int i) {
            this.value = i;
        }

        public static BehaviorTypeCase forNumber(int i) {
            if (i == 0) {
                return BEHAVIORTYPE_NOT_SET;
            }
            if (i == 7) {
                return TRAIT_ID;
            }
            if (i == 8) {
                return EVENT_ID;
            }
            if (i != 9) {
                return null;
            }
            return COMMAND_ID;
        }
    }

    static {
        UnsupportedEntityParameterValue unsupportedEntityParameterValue = new UnsupportedEntityParameterValue();
        DEFAULT_INSTANCE = unsupportedEntityParameterValue;
        zzzg.registerDefaultInstance(UnsupportedEntityParameterValue.class, unsupportedEntityParameterValue);
    }

    private UnsupportedEntityParameterValue() {
    }

    public static UnsupportedEntityParameterValue getDefaultInstance() {
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
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0004\t\u0001\u0001\u0001\u000b\t\u0000\u0000\u0000\u0001Ȉ\u0004ဉ\u0000\u0005ဉ\u0001\u0006\u000b\u0007Ȼ\u0000\bȻ\u0000\tȻ\u0000\nȈ\u000bȈ", new Object[]{"behaviorType_", "behaviorTypeCase_", "bitField0_", "parameterName_", "value_", "valueConstraint_", "fieldId_", "entityObjectId_", "entityType_"});
        }
        if (iOrdinal == 3) {
            return new UnsupportedEntityParameterValue();
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
        zzaay<UnsupportedEntityParameterValue> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (UnsupportedEntityParameterValue.class) {
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
        return this.behaviorTypeCase_ == 9 ? (String) this.behaviorType_ : "";
    }

    public String getEntityObjectId() {
        return this.entityObjectId_;
    }

    public String getEntityType() {
        return this.entityType_;
    }

    public String getEventId() {
        return this.behaviorTypeCase_ == 8 ? (String) this.behaviorType_ : "";
    }

    public int getFieldId() {
        return this.fieldId_;
    }

    public String getParameterName() {
        return this.parameterName_;
    }

    public String getTraitId() {
        return this.behaviorTypeCase_ == 7 ? (String) this.behaviorType_ : "";
    }

    public Value getValue() {
        Value value = this.value_;
        return value == null ? Value.getDefaultInstance() : value;
    }

    public ValueTypeConstraint getValueConstraint() {
        ValueTypeConstraint valueTypeConstraint = this.valueConstraint_;
        return valueTypeConstraint == null ? ValueTypeConstraint.getDefaultInstance() : valueTypeConstraint;
    }

    public static final class Builder extends zzyy<UnsupportedEntityParameterValue, Builder> implements zzaar {
        private Builder() {
            super(UnsupportedEntityParameterValue.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
