package com.google.home.platform.traits;

import com.google.android.gms.internal.serialization.zzaar;
import com.google.android.gms.internal.serialization.zzaay;
import com.google.android.gms.internal.serialization.zzwr;
import com.google.android.gms.internal.serialization.zzyy;
import com.google.android.gms.internal.serialization.zzyz;
import com.google.android.gms.internal.serialization.zzzf;
import com.google.android.gms.internal.serialization.zzzg;

/* JADX INFO: loaded from: classes4.dex */
public final class FirstPartyClientMetadata extends zzzg<FirstPartyClientMetadata, Builder> implements zzaar {
    public static final int CLIENT_FORMAT_FIELD_NUMBER = 1;
    private static final FirstPartyClientMetadata DEFAULT_INSTANCE;
    public static final int HIDE_FROM_AUTOMATIONS_TAB_FIELD_NUMBER = 2;
    public static final int LINEAGE_FIELD_NUMBER = 3;
    private static volatile zzaay<FirstPartyClientMetadata> PARSER;
    private int clientFormat_;
    private boolean hideFromAutomationsTab_;
    private int lineage_;

    static {
        FirstPartyClientMetadata firstPartyClientMetadata = new FirstPartyClientMetadata();
        DEFAULT_INSTANCE = firstPartyClientMetadata;
        zzzg.registerDefaultInstance(FirstPartyClientMetadata.class, firstPartyClientMetadata);
    }

    private FirstPartyClientMetadata() {
    }

    public static FirstPartyClientMetadata parseFrom(zzwr zzwrVar) {
        return (FirstPartyClientMetadata) zzzg.parseFrom(DEFAULT_INSTANCE, zzwrVar);
    }

    @Override // com.google.android.gms.internal.serialization.zzzg
    public final Object dynamicMethod(zzzf zzzfVar, Object obj, Object obj2) {
        zzaay zzyzVar;
        int iOrdinal = zzzfVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0004\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002\u0007\u0003\f", new Object[]{"clientFormat_", "hideFromAutomationsTab_", "lineage_"});
        }
        if (iOrdinal == 3) {
            return new FirstPartyClientMetadata();
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
        zzaay<FirstPartyClientMetadata> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (FirstPartyClientMetadata.class) {
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

    public static final class Builder extends zzyy<FirstPartyClientMetadata, Builder> implements zzaar {
        private Builder() {
            super(FirstPartyClientMetadata.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
