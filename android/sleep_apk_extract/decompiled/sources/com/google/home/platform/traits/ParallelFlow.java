package com.google.home.platform.traits;

import com.google.android.gms.internal.serialization.zzaar;
import com.google.android.gms.internal.serialization.zzaay;
import com.google.android.gms.internal.serialization.zzyy;
import com.google.android.gms.internal.serialization.zzyz;
import com.google.android.gms.internal.serialization.zzzf;
import com.google.android.gms.internal.serialization.zzzg;
import com.google.android.gms.internal.serialization.zzzk;
import com.google.android.gms.internal.serialization.zzzl;
import com.google.android.gms.internal.serialization.zzzs;
import java.util.List;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public final class ParallelFlow extends zzzg<ParallelFlow, Builder> implements zzaar {
    private static final ParallelFlow DEFAULT_INSTANCE;
    public static final int JOIN_SEMANTIC_FIELD_NUMBER = 2;
    public static final int NODES_FIELD_NUMBER = 1;
    private static volatile zzaay<ParallelFlow> PARSER;
    private int joinSemantic_;
    private zzzs<Node> nodes_ = zzzg.emptyProtobufList();

    public enum JoinSemantic implements zzzk {
        JS_UNSPECIFIED(0),
        JS_WHEN_ALL_FINISHED(1),
        UNRECOGNIZED(-1);

        private static final zzzl<JoinSemantic> internalValueMap = new zzzl<JoinSemantic>() { // from class: com.google.home.platform.traits.ParallelFlow.JoinSemantic.1
            @Override // com.google.android.gms.internal.serialization.zzzl
            public JoinSemantic findValueByNumber(int i) {
                return JoinSemantic.forNumber(i);
            }
        };
        private final int value;

        JoinSemantic(int i) {
            this.value = i;
        }

        public static JoinSemantic forNumber(int i) {
            if (i == 0) {
                return JS_UNSPECIFIED;
            }
            if (i != 1) {
                return null;
            }
            return JS_WHEN_ALL_FINISHED;
        }

        @Override // com.google.android.gms.internal.serialization.zzzk
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            Utf8$$ExternalSyntheticBUOutline0.m$2("Can't get the number of an unknown enum value.");
            return 0;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return Integer.toString(getNumber());
        }
    }

    static {
        ParallelFlow parallelFlow = new ParallelFlow();
        DEFAULT_INSTANCE = parallelFlow;
        zzzg.registerDefaultInstance(ParallelFlow.class, parallelFlow);
    }

    private ParallelFlow() {
    }

    public static ParallelFlow getDefaultInstance() {
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
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0004\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002\f", new Object[]{"nodes_", Node.class, "joinSemantic_"});
        }
        if (iOrdinal == 3) {
            return new ParallelFlow();
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
        zzaay<ParallelFlow> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (ParallelFlow.class) {
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

    public JoinSemantic getJoinSemantic() {
        JoinSemantic joinSemanticForNumber = JoinSemantic.forNumber(this.joinSemantic_);
        return joinSemanticForNumber == null ? JoinSemantic.UNRECOGNIZED : joinSemanticForNumber;
    }

    public List<Node> getNodesList() {
        return this.nodes_;
    }

    public static final class Builder extends zzyy<ParallelFlow, Builder> implements zzaar {
        private Builder() {
            super(ParallelFlow.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
