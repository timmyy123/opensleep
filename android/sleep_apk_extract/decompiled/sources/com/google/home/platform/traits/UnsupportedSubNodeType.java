package com.google.home.platform.traits;

import com.google.android.gms.internal.serialization.zzaar;
import com.google.android.gms.internal.serialization.zzaay;
import com.google.android.gms.internal.serialization.zzyy;
import com.google.android.gms.internal.serialization.zzyz;
import com.google.android.gms.internal.serialization.zzzf;
import com.google.android.gms.internal.serialization.zzzg;

/* JADX INFO: loaded from: classes4.dex */
public final class UnsupportedSubNodeType extends zzzg<UnsupportedSubNodeType, Builder> implements zzaar {
    private static final UnsupportedSubNodeType DEFAULT_INSTANCE;
    public static final int PARENT_NODE_TYPE_FIELD_NUMBER = 1;
    private static volatile zzaay<UnsupportedSubNodeType> PARSER = null;
    public static final int SUB_NODE_TYPE_FIELD_NUMBER = 2;
    private String parentNodeType_ = "";
    private String subNodeType_ = "";

    static {
        UnsupportedSubNodeType unsupportedSubNodeType = new UnsupportedSubNodeType();
        DEFAULT_INSTANCE = unsupportedSubNodeType;
        zzzg.registerDefaultInstance(UnsupportedSubNodeType.class, unsupportedSubNodeType);
    }

    private UnsupportedSubNodeType() {
    }

    public static UnsupportedSubNodeType getDefaultInstance() {
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
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0004\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"parentNodeType_", "subNodeType_"});
        }
        if (iOrdinal == 3) {
            return new UnsupportedSubNodeType();
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
        zzaay<UnsupportedSubNodeType> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (UnsupportedSubNodeType.class) {
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

    public String getParentNodeType() {
        return this.parentNodeType_;
    }

    public String getSubNodeType() {
        return this.subNodeType_;
    }

    public static final class Builder extends zzyy<UnsupportedSubNodeType, Builder> implements zzaar {
        private Builder() {
            super(UnsupportedSubNodeType.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
