package com.google.home.platform.traits;

import com.google.android.gms.internal.serialization.zzaar;
import com.google.android.gms.internal.serialization.zzaay;
import com.google.android.gms.internal.serialization.zzyy;
import com.google.android.gms.internal.serialization.zzyz;
import com.google.android.gms.internal.serialization.zzzf;
import com.google.android.gms.internal.serialization.zzzg;

/* JADX INFO: loaded from: classes4.dex */
public final class CombinedBitsDescriptor extends zzzg<CombinedBitsDescriptor, Builder> implements zzaar {
    public static final int BIT_POSITION_END_FIELD_NUMBER = 2;
    public static final int BIT_POSITION_START_FIELD_NUMBER = 1;
    private static final CombinedBitsDescriptor DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 3;
    private static volatile zzaay<CombinedBitsDescriptor> PARSER;
    private int bitPositionEnd_;
    private int bitPositionStart_;
    private String name_ = "";

    static {
        CombinedBitsDescriptor combinedBitsDescriptor = new CombinedBitsDescriptor();
        DEFAULT_INSTANCE = combinedBitsDescriptor;
        zzzg.registerDefaultInstance(CombinedBitsDescriptor.class, combinedBitsDescriptor);
    }

    private CombinedBitsDescriptor() {
    }

    @Override // com.google.android.gms.internal.serialization.zzzg
    public final Object dynamicMethod(zzzf zzzfVar, Object obj, Object obj2) {
        zzaay zzyzVar;
        int iOrdinal = zzzfVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\u000b\u0003Ȉ", new Object[]{"bitPositionStart_", "bitPositionEnd_", "name_"});
        }
        if (iOrdinal == 3) {
            return new CombinedBitsDescriptor();
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
        zzaay<CombinedBitsDescriptor> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (CombinedBitsDescriptor.class) {
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

    public int getBitPositionEnd() {
        return this.bitPositionEnd_;
    }

    public int getBitPositionStart() {
        return this.bitPositionStart_;
    }

    public String getName() {
        return this.name_;
    }

    public static final class Builder extends zzyy<CombinedBitsDescriptor, Builder> implements zzaar {
        private Builder() {
            super(CombinedBitsDescriptor.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
