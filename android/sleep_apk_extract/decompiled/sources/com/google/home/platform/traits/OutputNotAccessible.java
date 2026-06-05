package com.google.home.platform.traits;

import com.google.android.gms.internal.serialization.zzaar;
import com.google.android.gms.internal.serialization.zzaay;
import com.google.android.gms.internal.serialization.zzyy;
import com.google.android.gms.internal.serialization.zzyz;
import com.google.android.gms.internal.serialization.zzzf;
import com.google.android.gms.internal.serialization.zzzg;

/* JADX INFO: loaded from: classes4.dex */
public final class OutputNotAccessible extends zzzg<OutputNotAccessible, Builder> implements zzaar {
    private static final OutputNotAccessible DEFAULT_INSTANCE;
    public static final int OUTPUT_FIELD_NUMBER = 1;
    private static volatile zzaay<OutputNotAccessible> PARSER;
    private String output_ = "";

    static {
        OutputNotAccessible outputNotAccessible = new OutputNotAccessible();
        DEFAULT_INSTANCE = outputNotAccessible;
        zzzg.registerDefaultInstance(OutputNotAccessible.class, outputNotAccessible);
    }

    private OutputNotAccessible() {
    }

    public static OutputNotAccessible getDefaultInstance() {
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
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"output_"});
        }
        if (iOrdinal == 3) {
            return new OutputNotAccessible();
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
        zzaay<OutputNotAccessible> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (OutputNotAccessible.class) {
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

    public String getOutput() {
        return this.output_;
    }

    public static final class Builder extends zzyy<OutputNotAccessible, Builder> implements zzaar {
        private Builder() {
            super(OutputNotAccessible.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
