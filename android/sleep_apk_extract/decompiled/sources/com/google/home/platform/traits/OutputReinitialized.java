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
public final class OutputReinitialized extends zzzg<OutputReinitialized, Builder> implements zzaar {
    private static final OutputReinitialized DEFAULT_INSTANCE;
    public static final int OTHER_NODE_IDS_FIELD_NUMBER = 2;
    public static final int OUTPUT_FIELD_NUMBER = 1;
    private static volatile zzaay<OutputReinitialized> PARSER;
    private String output_ = "";
    private zzzs<String> otherNodeIds_ = zzzg.emptyProtobufList();

    static {
        OutputReinitialized outputReinitialized = new OutputReinitialized();
        DEFAULT_INSTANCE = outputReinitialized;
        zzzg.registerDefaultInstance(OutputReinitialized.class, outputReinitialized);
    }

    private OutputReinitialized() {
    }

    public static OutputReinitialized getDefaultInstance() {
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
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0004\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002Ț", new Object[]{"output_", "otherNodeIds_"});
        }
        if (iOrdinal == 3) {
            return new OutputReinitialized();
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
        zzaay<OutputReinitialized> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (OutputReinitialized.class) {
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

    public List<String> getOtherNodeIdsList() {
        return this.otherNodeIds_;
    }

    public String getOutput() {
        return this.output_;
    }

    public static final class Builder extends zzyy<OutputReinitialized, Builder> implements zzaar {
        private Builder() {
            super(OutputReinitialized.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
