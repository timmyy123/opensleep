package com.google.home.platform.traits;

import com.google.android.gms.internal.serialization.zzaar;
import com.google.android.gms.internal.serialization.zzaay;
import com.google.android.gms.internal.serialization.zzyl;
import com.google.android.gms.internal.serialization.zzyy;
import com.google.android.gms.internal.serialization.zzyz;
import com.google.android.gms.internal.serialization.zzzf;
import com.google.android.gms.internal.serialization.zzzg;
import com.google.android.gms.internal.serialization.zzzk;
import com.google.android.gms.internal.serialization.zzzl;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public final class SolarTime extends zzzg<SolarTime, Builder> implements zzaar {
    private static final SolarTime DEFAULT_INSTANCE;
    public static final int OFFSET_FIELD_NUMBER = 2;
    private static volatile zzaay<SolarTime> PARSER = null;
    public static final int TYPE_FIELD_NUMBER = 1;
    private int bitField0_;
    private zzyl offset_;
    private int type_;

    public enum SolarTimeType implements zzzk {
        UNKNOWN(0),
        SUNRISE(1),
        SUNSET(2),
        UNRECOGNIZED(-1);

        private static final zzzl<SolarTimeType> internalValueMap = new zzzl<SolarTimeType>() { // from class: com.google.home.platform.traits.SolarTime.SolarTimeType.1
            @Override // com.google.android.gms.internal.serialization.zzzl
            public SolarTimeType findValueByNumber(int i) {
                return SolarTimeType.forNumber(i);
            }
        };
        private final int value;

        SolarTimeType(int i) {
            this.value = i;
        }

        public static SolarTimeType forNumber(int i) {
            if (i == 0) {
                return UNKNOWN;
            }
            if (i == 1) {
                return SUNRISE;
            }
            if (i != 2) {
                return null;
            }
            return SUNSET;
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
        SolarTime solarTime = new SolarTime();
        DEFAULT_INSTANCE = solarTime;
        zzzg.registerDefaultInstance(SolarTime.class, solarTime);
    }

    private SolarTime() {
    }

    public static SolarTime getDefaultInstance() {
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
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002ဉ\u0000", new Object[]{"bitField0_", "type_", "offset_"});
        }
        if (iOrdinal == 3) {
            return new SolarTime();
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
        zzaay<SolarTime> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (SolarTime.class) {
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

    public zzyl getOffset() {
        zzyl zzylVar = this.offset_;
        return zzylVar == null ? zzyl.zze() : zzylVar;
    }

    public SolarTimeType getType() {
        SolarTimeType solarTimeTypeForNumber = SolarTimeType.forNumber(this.type_);
        return solarTimeTypeForNumber == null ? SolarTimeType.UNRECOGNIZED : solarTimeTypeForNumber;
    }

    public static final class Builder extends zzyy<SolarTime, Builder> implements zzaar {
        private Builder() {
            super(SolarTime.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
