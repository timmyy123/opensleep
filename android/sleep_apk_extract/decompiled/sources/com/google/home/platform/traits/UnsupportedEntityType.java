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
public final class UnsupportedEntityType extends zzzg<UnsupportedEntityType, Builder> implements zzaar {
    private static final UnsupportedEntityType DEFAULT_INSTANCE;
    public static final int ENTITY_OBJECT_ID_FIELD_NUMBER = 5;
    public static final int ENTITY_TYPE_FIELD_NUMBER = 1;
    private static volatile zzaay<UnsupportedEntityType> PARSER = null;
    public static final int SUPPORTED_TYPES_FIELD_NUMBER = 4;
    private String entityType_ = "";
    private zzzs<String> supportedTypes_ = zzzg.emptyProtobufList();
    private String entityObjectId_ = "";

    static {
        UnsupportedEntityType unsupportedEntityType = new UnsupportedEntityType();
        DEFAULT_INSTANCE = unsupportedEntityType;
        zzzg.registerDefaultInstance(UnsupportedEntityType.class, unsupportedEntityType);
    }

    private UnsupportedEntityType() {
    }

    public static UnsupportedEntityType getDefaultInstance() {
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
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0004\u0003\u0000\u0000\u0001\u0005\u0003\u0000\u0001\u0000\u0001Ȉ\u0004Ț\u0005Ȉ", new Object[]{"entityType_", "supportedTypes_", "entityObjectId_"});
        }
        if (iOrdinal == 3) {
            return new UnsupportedEntityType();
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
        zzaay<UnsupportedEntityType> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (UnsupportedEntityType.class) {
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

    public List<String> getSupportedTypesList() {
        return this.supportedTypes_;
    }

    public static final class Builder extends zzyy<UnsupportedEntityType, Builder> implements zzaar {
        private Builder() {
            super(UnsupportedEntityType.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
