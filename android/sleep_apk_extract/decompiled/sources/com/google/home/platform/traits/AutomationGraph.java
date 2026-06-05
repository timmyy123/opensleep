package com.google.home.platform.traits;

import com.google.android.gms.internal.serialization.zzaar;
import com.google.android.gms.internal.serialization.zzaay;
import com.google.android.gms.internal.serialization.zzyy;
import com.google.android.gms.internal.serialization.zzyz;
import com.google.android.gms.internal.serialization.zzzf;
import com.google.android.gms.internal.serialization.zzzg;

/* JADX INFO: loaded from: classes4.dex */
public final class AutomationGraph extends zzzg<AutomationGraph, Builder> implements zzaar {
    private static final AutomationGraph DEFAULT_INSTANCE;
    private static volatile zzaay<AutomationGraph> PARSER = null;
    public static final int SEQUENTIAL_FIELD_NUMBER = 1;
    private int bitField0_;
    private SequentialFlow sequential_;

    static {
        AutomationGraph automationGraph = new AutomationGraph();
        DEFAULT_INSTANCE = automationGraph;
        zzzg.registerDefaultInstance(AutomationGraph.class, automationGraph);
    }

    private AutomationGraph() {
    }

    public static AutomationGraph getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static AutomationGraph parseFrom(byte[] bArr) {
        return (AutomationGraph) zzzg.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    @Override // com.google.android.gms.internal.serialization.zzzg
    public final Object dynamicMethod(zzzf zzzfVar, Object obj, Object obj2) {
        zzaay zzyzVar;
        int iOrdinal = zzzfVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0004\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "sequential_"});
        }
        if (iOrdinal == 3) {
            return new AutomationGraph();
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
        zzaay<AutomationGraph> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (AutomationGraph.class) {
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

    public SequentialFlow getSequential() {
        SequentialFlow sequentialFlow = this.sequential_;
        return sequentialFlow == null ? SequentialFlow.getDefaultInstance() : sequentialFlow;
    }

    public static final class Builder extends zzyy<AutomationGraph, Builder> implements zzaar {
        private Builder() {
            super(AutomationGraph.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
