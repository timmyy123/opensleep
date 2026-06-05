package com.google.home.platform.traits;

import com.google.android.gms.internal.serialization.zzaar;
import com.google.android.gms.internal.serialization.zzaay;
import com.google.android.gms.internal.serialization.zzyy;
import com.google.android.gms.internal.serialization.zzyz;
import com.google.android.gms.internal.serialization.zzzf;
import com.google.android.gms.internal.serialization.zzzg;
import com.google.android.gms.internal.serialization.zzzs;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class EntityBehavior extends zzzg<EntityBehavior, Builder> implements zzaar {
    public static final int COMMAND_ID_FIELD_NUMBER = 4;
    private static final EntityBehavior DEFAULT_INSTANCE;
    public static final int ENTITY_FIELD_NUMBER = 1;
    public static final int ENTITY_FILTER_FIELD_NUMBER = 7;
    public static final int ENTITY_VARIABLE_FIELD_NUMBER = 6;
    public static final int EVENT_ID_FIELD_NUMBER = 3;
    public static final int PARAMETERS_FIELD_NUMBER = 5;
    private static volatile zzaay<EntityBehavior> PARSER = null;
    public static final int TRAIT_ID_FIELD_NUMBER = 2;
    private Object behaviorType_;
    private Object targetType_;
    private int targetTypeCase_ = 0;
    private int behaviorTypeCase_ = 0;
    private zzzs<Parameter> parameters_ = zzzg.emptyProtobufList();

    public enum BehaviorTypeCase {
        TRAIT_ID(2),
        EVENT_ID(3),
        COMMAND_ID(4),
        BEHAVIORTYPE_NOT_SET(0);

        private final int value;

        BehaviorTypeCase(int i) {
            this.value = i;
        }

        public static BehaviorTypeCase forNumber(int i) {
            if (i == 0) {
                return BEHAVIORTYPE_NOT_SET;
            }
            if (i == 2) {
                return TRAIT_ID;
            }
            if (i == 3) {
                return EVENT_ID;
            }
            if (i != 4) {
                return null;
            }
            return COMMAND_ID;
        }
    }

    public enum TargetTypeCase {
        ENTITY(1),
        ENTITY_VARIABLE(6),
        ENTITY_FILTER(7),
        TARGETTYPE_NOT_SET(0);

        private final int value;

        TargetTypeCase(int i) {
            this.value = i;
        }

        public static TargetTypeCase forNumber(int i) {
            if (i == 0) {
                return TARGETTYPE_NOT_SET;
            }
            if (i == 1) {
                return ENTITY;
            }
            if (i == 6) {
                return ENTITY_VARIABLE;
            }
            if (i != 7) {
                return null;
            }
            return ENTITY_FILTER;
        }
    }

    static {
        EntityBehavior entityBehavior = new EntityBehavior();
        DEFAULT_INSTANCE = entityBehavior;
        zzzg.registerDefaultInstance(EntityBehavior.class, entityBehavior);
    }

    private EntityBehavior() {
    }

    public static EntityBehavior getDefaultInstance() {
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
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0004\u0007\u0002\u0000\u0001\u0007\u0007\u0000\u0001\u0000\u0001<\u0000\u0002Ȼ\u0001\u0003Ȼ\u0001\u0004Ȼ\u0001\u0005\u001b\u0006Ȼ\u0000\u0007<\u0000", new Object[]{"targetType_", "targetTypeCase_", "behaviorType_", "behaviorTypeCase_", Entity.class, "parameters_", Parameter.class, Expression.class});
        }
        if (iOrdinal == 3) {
            return new EntityBehavior();
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
        zzaay<EntityBehavior> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (EntityBehavior.class) {
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
        return this.behaviorTypeCase_ == 4 ? (String) this.behaviorType_ : "";
    }

    public Entity getEntity() {
        return this.targetTypeCase_ == 1 ? (Entity) this.targetType_ : Entity.getDefaultInstance();
    }

    public String getEventId() {
        return this.behaviorTypeCase_ == 3 ? (String) this.behaviorType_ : "";
    }

    public List<Parameter> getParametersList() {
        return this.parameters_;
    }

    public TargetTypeCase getTargetTypeCase() {
        return TargetTypeCase.forNumber(this.targetTypeCase_);
    }

    public String getTraitId() {
        return this.behaviorTypeCase_ == 2 ? (String) this.behaviorType_ : "";
    }

    public static final class Builder extends zzyy<EntityBehavior, Builder> implements zzaar {
        private Builder() {
            super(EntityBehavior.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
