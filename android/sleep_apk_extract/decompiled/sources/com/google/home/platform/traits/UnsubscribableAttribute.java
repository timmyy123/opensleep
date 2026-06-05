package com.google.home.platform.traits;

import com.google.android.gms.internal.serialization.zzaar;
import com.google.android.gms.internal.serialization.zzaay;
import com.google.android.gms.internal.serialization.zzyy;
import com.google.android.gms.internal.serialization.zzyz;
import com.google.android.gms.internal.serialization.zzzf;
import com.google.android.gms.internal.serialization.zzzg;

/* JADX INFO: loaded from: classes4.dex */
public final class UnsubscribableAttribute extends zzzg<UnsubscribableAttribute, Builder> implements zzaar {
    public static final int ATTRIBUTE_NAME_FIELD_NUMBER = 2;
    private static final UnsubscribableAttribute DEFAULT_INSTANCE;
    private static volatile zzaay<UnsubscribableAttribute> PARSER = null;
    public static final int TRAIT_ID_FIELD_NUMBER = 1;
    private String traitId_ = "";
    private String attributeName_ = "";

    static {
        UnsubscribableAttribute unsubscribableAttribute = new UnsubscribableAttribute();
        DEFAULT_INSTANCE = unsubscribableAttribute;
        zzzg.registerDefaultInstance(UnsubscribableAttribute.class, unsubscribableAttribute);
    }

    private UnsubscribableAttribute() {
    }

    public static UnsubscribableAttribute getDefaultInstance() {
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
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0004\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"traitId_", "attributeName_"});
        }
        if (iOrdinal == 3) {
            return new UnsubscribableAttribute();
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
        zzaay<UnsubscribableAttribute> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (UnsubscribableAttribute.class) {
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

    public String getAttributeName() {
        return this.attributeName_;
    }

    public String getTraitId() {
        return this.traitId_;
    }

    public static final class Builder extends zzyy<UnsubscribableAttribute, Builder> implements zzaar {
        private Builder() {
            super(UnsubscribableAttribute.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
