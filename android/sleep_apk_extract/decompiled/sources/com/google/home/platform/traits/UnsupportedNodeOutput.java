package com.google.home.platform.traits;

import com.google.android.gms.internal.serialization.zzaar;
import com.google.android.gms.internal.serialization.zzaay;
import com.google.android.gms.internal.serialization.zzyy;
import com.google.android.gms.internal.serialization.zzyz;
import com.google.android.gms.internal.serialization.zzzf;
import com.google.android.gms.internal.serialization.zzzg;

/* JADX INFO: loaded from: classes4.dex */
public final class UnsupportedNodeOutput extends zzzg<UnsupportedNodeOutput, Builder> implements zzaar {
    private static final UnsupportedNodeOutput DEFAULT_INSTANCE;
    public static final int NODE_TYPE_FIELD_NUMBER = 1;
    private static volatile zzaay<UnsupportedNodeOutput> PARSER;
    private String nodeType_ = "";

    static {
        UnsupportedNodeOutput unsupportedNodeOutput = new UnsupportedNodeOutput();
        DEFAULT_INSTANCE = unsupportedNodeOutput;
        zzzg.registerDefaultInstance(UnsupportedNodeOutput.class, unsupportedNodeOutput);
    }

    private UnsupportedNodeOutput() {
    }

    public static UnsupportedNodeOutput getDefaultInstance() {
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
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"nodeType_"});
        }
        if (iOrdinal == 3) {
            return new UnsupportedNodeOutput();
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
        zzaay<UnsupportedNodeOutput> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (UnsupportedNodeOutput.class) {
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

    public String getNodeType() {
        return this.nodeType_;
    }

    public static final class Builder extends zzyy<UnsupportedNodeOutput, Builder> implements zzaar {
        private Builder() {
            super(UnsupportedNodeOutput.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
