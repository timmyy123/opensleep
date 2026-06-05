package com.google.home.platform.traits;

import com.google.android.gms.internal.serialization.zzaar;
import com.google.android.gms.internal.serialization.zzaay;
import com.google.android.gms.internal.serialization.zzyy;
import com.google.android.gms.internal.serialization.zzyz;
import com.google.android.gms.internal.serialization.zzzf;
import com.google.android.gms.internal.serialization.zzzg;

/* JADX INFO: loaded from: classes4.dex */
public final class MapType extends zzzg<MapType, Builder> implements zzaar {
    private static final MapType DEFAULT_INSTANCE;
    public static final int KEY_TYPE_FIELD_NUMBER = 1;
    private static volatile zzaay<MapType> PARSER = null;
    public static final int VALUE_TYPE_FIELD_NUMBER = 2;
    private int bitField0_;
    private ValueType keyType_;
    private ValueType valueType_;

    static {
        MapType mapType = new MapType();
        DEFAULT_INSTANCE = mapType;
        zzzg.registerDefaultInstance(MapType.class, mapType);
    }

    private MapType() {
    }

    public static MapType getDefaultInstance() {
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
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"bitField0_", "keyType_", "valueType_"});
        }
        if (iOrdinal == 3) {
            return new MapType();
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
        zzaay<MapType> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (MapType.class) {
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

    public ValueType getKeyType() {
        ValueType valueType = this.keyType_;
        return valueType == null ? ValueType.getDefaultInstance() : valueType;
    }

    public ValueType getValueType() {
        ValueType valueType = this.valueType_;
        return valueType == null ? ValueType.getDefaultInstance() : valueType;
    }

    public static final class Builder extends zzyy<MapType, Builder> implements zzaar {
        private Builder() {
            super(MapType.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
