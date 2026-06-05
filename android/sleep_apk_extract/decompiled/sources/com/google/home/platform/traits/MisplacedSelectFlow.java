package com.google.home.platform.traits;

import com.google.android.gms.internal.serialization.zzaar;
import com.google.android.gms.internal.serialization.zzaay;
import com.google.android.gms.internal.serialization.zzyy;
import com.google.android.gms.internal.serialization.zzyz;
import com.google.android.gms.internal.serialization.zzzf;
import com.google.android.gms.internal.serialization.zzzg;

/* JADX INFO: loaded from: classes4.dex */
public final class MisplacedSelectFlow extends zzzg<MisplacedSelectFlow, Builder> implements zzaar {
    private static final MisplacedSelectFlow DEFAULT_INSTANCE;
    private static volatile zzaay<MisplacedSelectFlow> PARSER;

    static {
        MisplacedSelectFlow misplacedSelectFlow = new MisplacedSelectFlow();
        DEFAULT_INSTANCE = misplacedSelectFlow;
        zzzg.registerDefaultInstance(MisplacedSelectFlow.class, misplacedSelectFlow);
    }

    private MisplacedSelectFlow() {
    }

    public static MisplacedSelectFlow getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.android.gms.internal.serialization.zzzg
    public final Object dynamicMethod(zzzf zzzfVar, Object obj, Object obj2) {
        zzaay zzyzVar;
        int iOrdinal = zzzfVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        byte[] bArr = null;
        if (iOrdinal == 2) {
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0004\u0000", null);
        }
        if (iOrdinal == 3) {
            return new MisplacedSelectFlow();
        }
        if (iOrdinal == 4) {
            return new Builder(bArr);
        }
        if (iOrdinal == 5) {
            return DEFAULT_INSTANCE;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzaay<MisplacedSelectFlow> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (MisplacedSelectFlow.class) {
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

    public static final class Builder extends zzyy<MisplacedSelectFlow, Builder> implements zzaar {
        private Builder() {
            super(MisplacedSelectFlow.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
