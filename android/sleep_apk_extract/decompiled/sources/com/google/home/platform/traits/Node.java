package com.google.home.platform.traits;

import com.google.android.gms.internal.serialization.zzaar;
import com.google.android.gms.internal.serialization.zzaay;
import com.google.android.gms.internal.serialization.zzyl;
import com.google.android.gms.internal.serialization.zzyy;
import com.google.android.gms.internal.serialization.zzyz;
import com.google.android.gms.internal.serialization.zzzf;
import com.google.android.gms.internal.serialization.zzzg;

/* JADX INFO: loaded from: classes4.dex */
public final class Node extends zzzg<Node, Builder> implements zzaar {
    public static final int ACTION_FIELD_NUMBER = 4;
    public static final int CONDITION_FIELD_NUMBER = 3;
    private static final Node DEFAULT_INSTANCE;
    public static final int DELAY_FIELD_NUMBER = 8;
    public static final int MANUAL_STARTER_FIELD_NUMBER = 12;
    public static final int NODE_ID_FIELD_NUMBER = 7;
    public static final int OUTPUT_FIELD_NUMBER = 1;
    public static final int PARALLEL_FIELD_NUMBER = 9;
    private static volatile zzaay<Node> PARSER = null;
    public static final int SELECT_FIELD_NUMBER = 11;
    public static final int SEQUENTIAL_FIELD_NUMBER = 6;
    public static final int STARTER_FIELD_NUMBER = 2;
    public static final int STATE_READER_FIELD_NUMBER = 5;
    public static final int SUPPRESSION_FIELD_NUMBER = 10;
    private int bitField0_;
    private Object node_;
    private int nodeCase_ = 0;
    private String nodeId_ = "";
    private String output_ = "";

    public enum NodeCase {
        SEQUENTIAL(6),
        PARALLEL(9),
        SELECT(11),
        MANUAL_STARTER(12),
        STARTER(2),
        STATE_READER(5),
        CONDITION(3),
        ACTION(4),
        DELAY(8),
        SUPPRESSION(10),
        NODE_NOT_SET(0);

        private final int value;

        NodeCase(int i) {
            this.value = i;
        }

        public static NodeCase forNumber(int i) {
            switch (i) {
                case 0:
                    return NODE_NOT_SET;
                case 1:
                case 7:
                default:
                    return null;
                case 2:
                    return STARTER;
                case 3:
                    return CONDITION;
                case 4:
                    return ACTION;
                case 5:
                    return STATE_READER;
                case 6:
                    return SEQUENTIAL;
                case 8:
                    return DELAY;
                case 9:
                    return PARALLEL;
                case 10:
                    return SUPPRESSION;
                case 11:
                    return SELECT;
                case 12:
                    return MANUAL_STARTER;
            }
        }
    }

    static {
        Node node = new Node();
        DEFAULT_INSTANCE = node;
        zzzg.registerDefaultInstance(Node.class, node);
    }

    private Node() {
    }

    @Override // com.google.android.gms.internal.serialization.zzzg
    public final Object dynamicMethod(zzzf zzzfVar, Object obj, Object obj2) {
        zzaay zzyzVar;
        int iOrdinal = zzzfVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0004\f\u0001\u0001\u0001\f\f\u0000\u0000\u0000\u0001ለ\u0001\u0002<\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000\u0006<\u0000\u0007ለ\u0000\b<\u0000\t<\u0000\n<\u0000\u000b<\u0000\f<\u0000", new Object[]{"node_", "nodeCase_", "bitField0_", "output_", EntityBehavior.class, Condition.class, EntityBehavior.class, EntityBehavior.class, SequentialFlow.class, "nodeId_", zzyl.class, ParallelFlow.class, zzyl.class, SelectFlow.class, ManualStarter.class});
        }
        if (iOrdinal == 3) {
            return new Node();
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
        zzaay<Node> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (Node.class) {
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

    public EntityBehavior getAction() {
        return this.nodeCase_ == 4 ? (EntityBehavior) this.node_ : EntityBehavior.getDefaultInstance();
    }

    public Condition getCondition() {
        return this.nodeCase_ == 3 ? (Condition) this.node_ : Condition.getDefaultInstance();
    }

    public zzyl getDelay() {
        return this.nodeCase_ == 8 ? (zzyl) this.node_ : zzyl.zze();
    }

    public NodeCase getNodeCase() {
        return NodeCase.forNumber(this.nodeCase_);
    }

    public String getNodeId() {
        return this.nodeId_;
    }

    public String getOutput() {
        return this.output_;
    }

    public ParallelFlow getParallel() {
        return this.nodeCase_ == 9 ? (ParallelFlow) this.node_ : ParallelFlow.getDefaultInstance();
    }

    public SelectFlow getSelect() {
        return this.nodeCase_ == 11 ? (SelectFlow) this.node_ : SelectFlow.getDefaultInstance();
    }

    public SequentialFlow getSequential() {
        return this.nodeCase_ == 6 ? (SequentialFlow) this.node_ : SequentialFlow.getDefaultInstance();
    }

    public EntityBehavior getStarter() {
        return this.nodeCase_ == 2 ? (EntityBehavior) this.node_ : EntityBehavior.getDefaultInstance();
    }

    public EntityBehavior getStateReader() {
        return this.nodeCase_ == 5 ? (EntityBehavior) this.node_ : EntityBehavior.getDefaultInstance();
    }

    public zzyl getSuppression() {
        return this.nodeCase_ == 10 ? (zzyl) this.node_ : zzyl.zze();
    }

    public static final class Builder extends zzyy<Node, Builder> implements zzaar {
        private Builder() {
            super(Node.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
