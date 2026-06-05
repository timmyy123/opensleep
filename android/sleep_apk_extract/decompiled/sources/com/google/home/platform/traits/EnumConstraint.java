package com.google.home.platform.traits;

import com.google.android.gms.internal.serialization.zzaaj;
import com.google.android.gms.internal.serialization.zzaak;
import com.google.android.gms.internal.serialization.zzaar;
import com.google.android.gms.internal.serialization.zzaay;
import com.google.android.gms.internal.serialization.zzace;
import com.google.android.gms.internal.serialization.zzyy;
import com.google.android.gms.internal.serialization.zzyz;
import com.google.android.gms.internal.serialization.zzzf;
import com.google.android.gms.internal.serialization.zzzg;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class EnumConstraint extends zzzg<EnumConstraint, Builder> implements zzaar {
    private static final EnumConstraint DEFAULT_INSTANCE;
    public static final int ENUM_VALUES_FIELD_NUMBER = 2;
    private static volatile zzaay<EnumConstraint> PARSER = null;
    public static final int TYPE_ID_FIELD_NUMBER = 1;
    private zzaak<String, Integer> enumValues_ = zzaak.zza();
    private String typeId_ = "";

    public static final class EnumValuesDefaultEntryHolder {
        static final zzaaj<String, Integer> defaultEntry = zzaaj.zza(zzace.zzi, "", zzace.zze, 0);
    }

    static {
        EnumConstraint enumConstraint = new EnumConstraint();
        DEFAULT_INSTANCE = enumConstraint;
        zzzg.registerDefaultInstance(EnumConstraint.class, enumConstraint);
    }

    private EnumConstraint() {
    }

    public static EnumConstraint getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private zzaak<String, Integer> internalGetEnumValues() {
        return this.enumValues_;
    }

    @Override // com.google.android.gms.internal.serialization.zzzg
    public final Object dynamicMethod(zzzf zzzfVar, Object obj, Object obj2) {
        zzaay zzyzVar;
        int iOrdinal = zzzfVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0001\u0000\u0000\u0001Ȉ\u00022", new Object[]{"typeId_", "enumValues_", EnumValuesDefaultEntryHolder.defaultEntry});
        }
        if (iOrdinal == 3) {
            return new EnumConstraint();
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
        zzaay<EnumConstraint> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (EnumConstraint.class) {
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

    public Map<String, Integer> getEnumValuesMap() {
        return Collections.unmodifiableMap(internalGetEnumValues());
    }

    public String getTypeId() {
        return this.typeId_;
    }

    public static final class Builder extends zzyy<EnumConstraint, Builder> implements zzaar {
        private Builder() {
            super(EnumConstraint.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
