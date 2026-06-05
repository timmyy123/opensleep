package com.google.home.platform.traits.metadata;

import com.google.android.gms.internal.serialization.zzaar;
import com.google.android.gms.internal.serialization.zzaay;
import com.google.android.gms.internal.serialization.zzyy;
import com.google.android.gms.internal.serialization.zzyz;
import com.google.android.gms.internal.serialization.zzzf;
import com.google.android.gms.internal.serialization.zzzg;

/* JADX INFO: loaded from: classes4.dex */
public final class Unit extends zzzg<Unit, Builder> implements zzaar {
    public static final int BASE_UNIT_FIELD_NUMBER = 1;
    private static final Unit DEFAULT_INSTANCE;
    private static volatile zzaay<Unit> PARSER = null;
    public static final int SCALE_FIELD_NUMBER = 2;
    private int baseUnit_;
    private int bitField0_;
    private double scale_;

    static {
        Unit unit = new Unit();
        DEFAULT_INSTANCE = unit;
        zzzg.registerDefaultInstance(Unit.class, unit);
    }

    private Unit() {
    }

    public static Unit getDefaultInstance() {
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
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002က\u0000", new Object[]{"bitField0_", "baseUnit_", "scale_"});
        }
        if (iOrdinal == 3) {
            return new Unit();
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
        zzaay<Unit> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (Unit.class) {
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

    public BaseUnit getBaseUnit() {
        BaseUnit baseUnitForNumber = BaseUnit.forNumber(this.baseUnit_);
        return baseUnitForNumber == null ? BaseUnit.UNRECOGNIZED : baseUnitForNumber;
    }

    public double getScale() {
        return this.scale_;
    }

    public static final class Builder extends zzyy<Unit, Builder> implements zzaar {
        private Builder() {
            super(Unit.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
