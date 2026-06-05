package com.google.home.platform.traits;

import com.google.android.gms.internal.serialization.zzaar;
import com.google.android.gms.internal.serialization.zzaay;
import com.google.android.gms.internal.serialization.zzyy;
import com.google.android.gms.internal.serialization.zzyz;
import com.google.android.gms.internal.serialization.zzzf;
import com.google.android.gms.internal.serialization.zzzg;

/* JADX INFO: loaded from: classes4.dex */
public final class UnsupportedCandidateReason extends zzzg<UnsupportedCandidateReason, Builder> implements zzaar {
    private static final UnsupportedCandidateReason DEFAULT_INSTANCE;
    public static final int MISSING_PRESENCE_SENSING_SETUP_FIELD_NUMBER = 4;
    public static final int MISSING_STRUCTURE_ADDRESS_SETUP_FIELD_NUMBER = 3;
    public static final int MISSING_SUBSCRIPTION_FIELD_NUMBER = 5;
    private static volatile zzaay<UnsupportedCandidateReason> PARSER = null;
    public static final int REASON_TYPE_FIELD_NUMBER = 2;
    private int reasonCase_ = 0;
    private String reasonType_ = "";
    private Object reason_;

    public enum ReasonCase {
        MISSING_STRUCTURE_ADDRESS_SETUP(3),
        MISSING_PRESENCE_SENSING_SETUP(4),
        MISSING_SUBSCRIPTION(5),
        REASON_NOT_SET(0);

        private final int value;

        ReasonCase(int i) {
            this.value = i;
        }

        public static ReasonCase forNumber(int i) {
            if (i == 0) {
                return REASON_NOT_SET;
            }
            if (i == 3) {
                return MISSING_STRUCTURE_ADDRESS_SETUP;
            }
            if (i == 4) {
                return MISSING_PRESENCE_SENSING_SETUP;
            }
            if (i != 5) {
                return null;
            }
            return MISSING_SUBSCRIPTION;
        }
    }

    static {
        UnsupportedCandidateReason unsupportedCandidateReason = new UnsupportedCandidateReason();
        DEFAULT_INSTANCE = unsupportedCandidateReason;
        zzzg.registerDefaultInstance(UnsupportedCandidateReason.class, unsupportedCandidateReason);
    }

    private UnsupportedCandidateReason() {
    }

    @Override // com.google.android.gms.internal.serialization.zzzg
    public final Object dynamicMethod(zzzf zzzfVar, Object obj, Object obj2) {
        zzaay zzyzVar;
        int iOrdinal = zzzfVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0004\u0004\u0001\u0000\u0002\u0005\u0004\u0000\u0000\u0000\u0002Ȉ\u0003<\u0000\u0004<\u0000\u0005<\u0000", new Object[]{"reason_", "reasonCase_", "reasonType_", MissingStructureAddressSetup.class, MissingPresenceSensingSetup.class, MissingSubscription.class});
        }
        if (iOrdinal == 3) {
            return new UnsupportedCandidateReason();
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
        zzaay<UnsupportedCandidateReason> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (UnsupportedCandidateReason.class) {
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

    public MissingPresenceSensingSetup getMissingPresenceSensingSetup() {
        return this.reasonCase_ == 4 ? (MissingPresenceSensingSetup) this.reason_ : MissingPresenceSensingSetup.getDefaultInstance();
    }

    public ReasonCase getReasonCase() {
        return ReasonCase.forNumber(this.reasonCase_);
    }

    public static final class Builder extends zzyy<UnsupportedCandidateReason, Builder> implements zzaar {
        private Builder() {
            super(UnsupportedCandidateReason.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
