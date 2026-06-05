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
public final class DuplicateStarterNode extends zzzg<DuplicateStarterNode, Builder> implements zzaar {
    private static final DuplicateStarterNode DEFAULT_INSTANCE;
    public static final int EXISTING_STARTER_NODE_IDS_FIELD_NUMBER = 1;
    private static volatile zzaay<DuplicateStarterNode> PARSER;
    private zzzs<String> existingStarterNodeIds_ = zzzg.emptyProtobufList();

    static {
        DuplicateStarterNode duplicateStarterNode = new DuplicateStarterNode();
        DEFAULT_INSTANCE = duplicateStarterNode;
        zzzg.registerDefaultInstance(DuplicateStarterNode.class, duplicateStarterNode);
    }

    private DuplicateStarterNode() {
    }

    public static DuplicateStarterNode getDefaultInstance() {
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
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001Ț", new Object[]{"existingStarterNodeIds_"});
        }
        if (iOrdinal == 3) {
            return new DuplicateStarterNode();
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
        zzaay<DuplicateStarterNode> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (DuplicateStarterNode.class) {
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

    public List<String> getExistingStarterNodeIdsList() {
        return this.existingStarterNodeIds_;
    }

    public static final class Builder extends zzyy<DuplicateStarterNode, Builder> implements zzaar {
        private Builder() {
            super(DuplicateStarterNode.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
