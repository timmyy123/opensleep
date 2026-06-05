package com.google.home.platform.traits;

import com.google.android.gms.internal.serialization.zzaar;
import com.google.android.gms.internal.serialization.zzaay;
import com.google.android.gms.internal.serialization.zzyy;
import com.google.android.gms.internal.serialization.zzyz;
import com.google.android.gms.internal.serialization.zzzf;
import com.google.android.gms.internal.serialization.zzzg;
import com.google.android.gms.internal.serialization.zzzk;
import com.google.android.gms.internal.serialization.zzzl;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public final class MissingPresenceSensingSetup extends zzzg<MissingPresenceSensingSetup, Builder> implements zzaar {
    private static final MissingPresenceSensingSetup DEFAULT_INSTANCE;
    private static volatile zzaay<MissingPresenceSensingSetup> PARSER = null;
    public static final int TYPE_FIELD_NUMBER = 1;
    private int type_;

    public enum SetupType implements zzzk {
        UNSPECIFIED(0),
        STRUCTURE_PRESENCE(1),
        USER_PRESENCE(2),
        UNRECOGNIZED(-1);

        private static final zzzl<SetupType> internalValueMap = new zzzl<SetupType>() { // from class: com.google.home.platform.traits.MissingPresenceSensingSetup.SetupType.1
            @Override // com.google.android.gms.internal.serialization.zzzl
            public SetupType findValueByNumber(int i) {
                return SetupType.forNumber(i);
            }
        };
        private final int value;

        SetupType(int i) {
            this.value = i;
        }

        public static SetupType forNumber(int i) {
            if (i == 0) {
                return UNSPECIFIED;
            }
            if (i == 1) {
                return STRUCTURE_PRESENCE;
            }
            if (i != 2) {
                return null;
            }
            return USER_PRESENCE;
        }

        @Override // com.google.android.gms.internal.serialization.zzzk
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            Utf8$$ExternalSyntheticBUOutline0.m$2("Can't get the number of an unknown enum value.");
            return 0;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return Integer.toString(getNumber());
        }
    }

    static {
        MissingPresenceSensingSetup missingPresenceSensingSetup = new MissingPresenceSensingSetup();
        DEFAULT_INSTANCE = missingPresenceSensingSetup;
        zzzg.registerDefaultInstance(MissingPresenceSensingSetup.class, missingPresenceSensingSetup);
    }

    private MissingPresenceSensingSetup() {
    }

    public static MissingPresenceSensingSetup getDefaultInstance() {
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
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"type_"});
        }
        if (iOrdinal == 3) {
            return new MissingPresenceSensingSetup();
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
        zzaay<MissingPresenceSensingSetup> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (MissingPresenceSensingSetup.class) {
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

    public SetupType getType() {
        SetupType setupTypeForNumber = SetupType.forNumber(this.type_);
        return setupTypeForNumber == null ? SetupType.UNRECOGNIZED : setupTypeForNumber;
    }

    public static final class Builder extends zzyy<MissingPresenceSensingSetup, Builder> implements zzaar {
        private Builder() {
            super(MissingPresenceSensingSetup.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
