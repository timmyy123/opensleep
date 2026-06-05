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
public final class UnsupportedEntityTrait extends zzzg<UnsupportedEntityTrait, Builder> implements zzaar {
    private static final UnsupportedEntityTrait DEFAULT_INSTANCE;
    public static final int ENTITY_OBJECT_ID_FIELD_NUMBER = 5;
    public static final int ENTITY_TYPE_FIELD_NUMBER = 6;
    private static volatile zzaay<UnsupportedEntityTrait> PARSER = null;
    public static final int TRAIT_ID_FIELD_NUMBER = 1;
    public static final int UNSUPPORTED_REASONS_FIELD_NUMBER = 4;
    private String traitId_ = "";
    private zzzs<UnsupportedCandidateReason> unsupportedReasons_ = zzzg.emptyProtobufList();
    private String entityObjectId_ = "";
    private String entityType_ = "";

    static {
        UnsupportedEntityTrait unsupportedEntityTrait = new UnsupportedEntityTrait();
        DEFAULT_INSTANCE = unsupportedEntityTrait;
        zzzg.registerDefaultInstance(UnsupportedEntityTrait.class, unsupportedEntityTrait);
    }

    private UnsupportedEntityTrait() {
    }

    public static UnsupportedEntityTrait getDefaultInstance() {
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
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0004\u0004\u0000\u0000\u0001\u0006\u0004\u0000\u0001\u0000\u0001Ȉ\u0004\u001b\u0005Ȉ\u0006Ȉ", new Object[]{"traitId_", "unsupportedReasons_", UnsupportedCandidateReason.class, "entityObjectId_", "entityType_"});
        }
        if (iOrdinal == 3) {
            return new UnsupportedEntityTrait();
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
        zzaay<UnsupportedEntityTrait> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (UnsupportedEntityTrait.class) {
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

    public String getTraitId() {
        return this.traitId_;
    }

    public List<UnsupportedCandidateReason> getUnsupportedReasonsList() {
        return this.unsupportedReasons_;
    }

    public static final class Builder extends zzyy<UnsupportedEntityTrait, Builder> implements zzaar {
        private Builder() {
            super(UnsupportedEntityTrait.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
