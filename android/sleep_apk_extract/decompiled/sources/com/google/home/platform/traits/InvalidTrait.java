package com.google.home.platform.traits;

import com.google.android.gms.internal.serialization.zzaar;
import com.google.android.gms.internal.serialization.zzaay;
import com.google.android.gms.internal.serialization.zzyy;
import com.google.android.gms.internal.serialization.zzyz;
import com.google.android.gms.internal.serialization.zzzf;
import com.google.android.gms.internal.serialization.zzzg;

/* JADX INFO: loaded from: classes4.dex */
public final class InvalidTrait extends zzzg<InvalidTrait, Builder> implements zzaar {
    private static final InvalidTrait DEFAULT_INSTANCE;
    public static final int EXPECTED_BEHAVIOR_TYPE_FIELD_NUMBER = 2;
    private static volatile zzaay<InvalidTrait> PARSER = null;
    public static final int TRAIT_ID_FIELD_NUMBER = 1;
    private int bitField0_;
    private String traitId_ = "";
    private String expectedBehaviorType_ = "";

    static {
        InvalidTrait invalidTrait = new InvalidTrait();
        DEFAULT_INSTANCE = invalidTrait;
        zzzg.registerDefaultInstance(InvalidTrait.class, invalidTrait);
    }

    private InvalidTrait() {
    }

    public static InvalidTrait getDefaultInstance() {
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
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002ለ\u0000", new Object[]{"bitField0_", "traitId_", "expectedBehaviorType_"});
        }
        if (iOrdinal == 3) {
            return new InvalidTrait();
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
        zzaay<InvalidTrait> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (InvalidTrait.class) {
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

    public String getExpectedBehaviorType() {
        return this.expectedBehaviorType_;
    }

    public String getTraitId() {
        return this.traitId_;
    }

    public static final class Builder extends zzyy<InvalidTrait, Builder> implements zzaar {
        private Builder() {
            super(InvalidTrait.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
