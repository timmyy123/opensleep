package com.google.home.platform.traits;

import com.google.android.gms.internal.serialization.zzaar;
import com.google.android.gms.internal.serialization.zzaay;
import com.google.android.gms.internal.serialization.zzyy;
import com.google.android.gms.internal.serialization.zzyz;
import com.google.android.gms.internal.serialization.zzzf;
import com.google.android.gms.internal.serialization.zzzg;
import com.google.android.gms.internal.serialization.zzzs;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class SequentialFlow extends zzzg<SequentialFlow, Builder> implements zzaar {
    private static final SequentialFlow DEFAULT_INSTANCE;
    public static final int NODES_FIELD_NUMBER = 1;
    private static volatile zzaay<SequentialFlow> PARSER;
    private zzzs<Node> nodes_ = zzzg.emptyProtobufList();

    static {
        SequentialFlow sequentialFlow = new SequentialFlow();
        DEFAULT_INSTANCE = sequentialFlow;
        zzzg.registerDefaultInstance(SequentialFlow.class, sequentialFlow);
    }

    private SequentialFlow() {
    }

    public static SequentialFlow getDefaultInstance() {
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
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"nodes_", Node.class});
        }
        if (iOrdinal == 3) {
            return new SequentialFlow();
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
        zzaay<SequentialFlow> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (SequentialFlow.class) {
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

    public List<Node> getNodesList() {
        return this.nodes_;
    }

    public static final class Builder extends zzyy<SequentialFlow, Builder> implements zzaar {
        private Builder() {
            super(SequentialFlow.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
