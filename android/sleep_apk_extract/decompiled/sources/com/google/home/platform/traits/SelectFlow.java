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
public final class SelectFlow extends zzzg<SelectFlow, Builder> implements zzaar {
    private static final SelectFlow DEFAULT_INSTANCE;
    public static final int NODES_FIELD_NUMBER = 1;
    private static volatile zzaay<SelectFlow> PARSER;
    private zzzs<Node> nodes_ = zzzg.emptyProtobufList();

    static {
        SelectFlow selectFlow = new SelectFlow();
        DEFAULT_INSTANCE = selectFlow;
        zzzg.registerDefaultInstance(SelectFlow.class, selectFlow);
    }

    private SelectFlow() {
    }

    public static SelectFlow getDefaultInstance() {
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
            return new SelectFlow();
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
        zzaay<SelectFlow> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (SelectFlow.class) {
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

    public static final class Builder extends zzyy<SelectFlow, Builder> implements zzaar {
        private Builder() {
            super(SelectFlow.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
