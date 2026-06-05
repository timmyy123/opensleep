package com.google.home.platform.traits;

import com.google.android.gms.internal.serialization.zzaar;
import com.google.android.gms.internal.serialization.zzaay;
import com.google.android.gms.internal.serialization.zzyy;
import com.google.android.gms.internal.serialization.zzyz;
import com.google.android.gms.internal.serialization.zzzf;
import com.google.android.gms.internal.serialization.zzzg;
import com.google.android.gms.internal.serialization.zzzr;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class UIntSetConstraint extends zzzg<UIntSetConstraint, Builder> implements zzaar {
    public static final int DATA_TYPE_FIELD_NUMBER = 2;
    private static final UIntSetConstraint DEFAULT_INSTANCE;
    private static volatile zzaay<UIntSetConstraint> PARSER = null;
    public static final int VALUES_FIELD_NUMBER = 1;
    private int bitField0_;
    private int dataType_;
    private int valuesMemoizedSerializedSize = -1;
    private zzzr values_ = zzzg.emptyLongList();

    static {
        UIntSetConstraint uIntSetConstraint = new UIntSetConstraint();
        DEFAULT_INSTANCE = uIntSetConstraint;
        zzzg.registerDefaultInstance(UIntSetConstraint.class, uIntSetConstraint);
    }

    private UIntSetConstraint() {
    }

    public static UIntSetConstraint getDefaultInstance() {
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
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001&\u0002ဌ\u0000", new Object[]{"bitField0_", "values_", "dataType_"});
        }
        if (iOrdinal == 3) {
            return new UIntSetConstraint();
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
        zzaay<UIntSetConstraint> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (UIntSetConstraint.class) {
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

    public List<Long> getValuesList() {
        return this.values_;
    }

    public static final class Builder extends zzyy<UIntSetConstraint, Builder> implements zzaar {
        private Builder() {
            super(UIntSetConstraint.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
