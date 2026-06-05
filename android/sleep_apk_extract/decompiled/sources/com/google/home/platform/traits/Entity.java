package com.google.home.platform.traits;

import com.google.android.gms.internal.serialization.zzaar;
import com.google.android.gms.internal.serialization.zzaay;
import com.google.android.gms.internal.serialization.zzyy;
import com.google.android.gms.internal.serialization.zzyz;
import com.google.android.gms.internal.serialization.zzzf;
import com.google.android.gms.internal.serialization.zzzg;
import com.google.android.gms.internal.serialization.zzzs;

/* JADX INFO: loaded from: classes4.dex */
public final class Entity extends zzzg<Entity, Builder> implements zzaar {
    public static final int COMPONENT_OBJECT_ID_FIELD_NUMBER = 6;
    private static final Entity DEFAULT_INSTANCE;
    public static final int ENTITY_ID_FIELD_NUMBER = 1;
    public static final int ENTITY_OBJECT_ID_FIELD_NUMBER = 5;
    public static final int NAME_FIELD_NUMBER = 3;
    private static volatile zzaay<Entity> PARSER = null;
    public static final int TYPES_FIELD_NUMBER = 4;
    public static final int TYPE_FIELD_NUMBER = 7;
    private String entityId_ = "";
    private String entityObjectId_ = "";
    private String componentObjectId_ = "";
    private String name_ = "";
    private zzzs<String> types_ = zzzg.emptyProtobufList();
    private String type_ = "";

    static {
        Entity entity = new Entity();
        DEFAULT_INSTANCE = entity;
        zzzg.registerDefaultInstance(Entity.class, entity);
    }

    private Entity() {
    }

    public static Entity getDefaultInstance() {
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
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0004\u0006\u0000\u0000\u0001\u0007\u0006\u0000\u0001\u0000\u0001Ȉ\u0003Ȉ\u0004Ț\u0005Ȉ\u0006Ȉ\u0007Ȉ", new Object[]{"entityId_", "name_", "types_", "entityObjectId_", "componentObjectId_", "type_"});
        }
        if (iOrdinal == 3) {
            return new Entity();
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
        zzaay<Entity> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (Entity.class) {
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

    public String getEntityObjectId() {
        return this.entityObjectId_;
    }

    public String getName() {
        return this.name_;
    }

    public String getType() {
        return this.type_;
    }

    public static final class Builder extends zzyy<Entity, Builder> implements zzaar {
        private Builder() {
            super(Entity.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
