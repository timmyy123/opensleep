package com.google.home.platform.traits;

import com.google.android.gms.internal.serialization.zzaar;
import com.google.android.gms.internal.serialization.zzaay;
import com.google.android.gms.internal.serialization.zzyy;
import com.google.android.gms.internal.serialization.zzyz;
import com.google.android.gms.internal.serialization.zzzf;
import com.google.android.gms.internal.serialization.zzzg;

/* JADX INFO: loaded from: classes4.dex */
public final class TooManyNodes extends zzzg<TooManyNodes, Builder> implements zzaar {
    private static final TooManyNodes DEFAULT_INSTANCE;
    public static final int NODE_COUNT_FIELD_NUMBER = 1;
    public static final int NODE_COUNT_LIMIT_FIELD_NUMBER = 2;
    private static volatile zzaay<TooManyNodes> PARSER;
    private int nodeCountLimit_;
    private int nodeCount_;

    static {
        TooManyNodes tooManyNodes = new TooManyNodes();
        DEFAULT_INSTANCE = tooManyNodes;
        zzzg.registerDefaultInstance(TooManyNodes.class, tooManyNodes);
    }

    private TooManyNodes() {
    }

    public static TooManyNodes getDefaultInstance() {
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
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0004\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[]{"nodeCount_", "nodeCountLimit_"});
        }
        if (iOrdinal == 3) {
            return new TooManyNodes();
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
        zzaay<TooManyNodes> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (TooManyNodes.class) {
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

    public int getNodeCount() {
        return this.nodeCount_;
    }

    public int getNodeCountLimit() {
        return this.nodeCountLimit_;
    }

    public static final class Builder extends zzyy<TooManyNodes, Builder> implements zzaar {
        private Builder() {
            super(TooManyNodes.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
