package com.google.home.platform.traits;

import com.google.android.gms.internal.serialization.zzaar;
import com.google.android.gms.internal.serialization.zzaay;
import com.google.android.gms.internal.serialization.zzyy;
import com.google.android.gms.internal.serialization.zzyz;
import com.google.android.gms.internal.serialization.zzzf;
import com.google.android.gms.internal.serialization.zzzg;

/* JADX INFO: loaded from: classes4.dex */
public final class InvalidEntity extends zzzg<InvalidEntity, Builder> implements zzaar {
    private static final InvalidEntity DEFAULT_INSTANCE;
    public static final int ENTITY_OBJECT_ID_FIELD_NUMBER = 3;
    public static final int ENTITY_TYPE_FIELD_NUMBER = 4;
    private static volatile zzaay<InvalidEntity> PARSER;
    private String entityObjectId_ = "";
    private String entityType_ = "";

    static {
        InvalidEntity invalidEntity = new InvalidEntity();
        DEFAULT_INSTANCE = invalidEntity;
        zzzg.registerDefaultInstance(InvalidEntity.class, invalidEntity);
    }

    private InvalidEntity() {
    }

    public static InvalidEntity getDefaultInstance() {
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
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0004\u0002\u0000\u0000\u0003\u0004\u0002\u0000\u0000\u0000\u0003Ȉ\u0004Ȉ", new Object[]{"entityObjectId_", "entityType_"});
        }
        if (iOrdinal == 3) {
            return new InvalidEntity();
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
        zzaay<InvalidEntity> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (InvalidEntity.class) {
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

    public String getEntityType() {
        return this.entityType_;
    }

    public static final class Builder extends zzyy<InvalidEntity, Builder> implements zzaar {
        private Builder() {
            super(InvalidEntity.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
