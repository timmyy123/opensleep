package com.google.home.platform.traits;

import com.google.android.gms.internal.serialization.zzaar;
import com.google.android.gms.internal.serialization.zzaay;
import com.google.android.gms.internal.serialization.zzyy;
import com.google.android.gms.internal.serialization.zzyz;
import com.google.android.gms.internal.serialization.zzzf;
import com.google.android.gms.internal.serialization.zzzg;

/* JADX INFO: loaded from: classes4.dex */
public final class BitmapValue extends zzzg<BitmapValue, Builder> implements zzaar {
    private static final BitmapValue DEFAULT_INSTANCE;
    private static volatile zzaay<BitmapValue> PARSER = null;
    public static final int TYPE_ID_FIELD_NUMBER = 1;
    public static final int VALUE_FIELD_NUMBER = 2;
    private String typeId_ = "";
    private long value_;

    static {
        BitmapValue bitmapValue = new BitmapValue();
        DEFAULT_INSTANCE = bitmapValue;
        zzzg.registerDefaultInstance(BitmapValue.class, bitmapValue);
    }

    private BitmapValue() {
    }

    public static BitmapValue getDefaultInstance() {
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
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0004\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\u0003", new Object[]{"typeId_", "value_"});
        }
        if (iOrdinal == 3) {
            return new BitmapValue();
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
        zzaay<BitmapValue> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (BitmapValue.class) {
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

    public String getTypeId() {
        return this.typeId_;
    }

    public long getValue() {
        return this.value_;
    }

    public static final class Builder extends zzyy<BitmapValue, Builder> implements zzaar {
        private Builder() {
            super(BitmapValue.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
