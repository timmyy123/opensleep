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
public final class MissingRequiredFields extends zzzg<MissingRequiredFields, Builder> implements zzaar {
    private static final MissingRequiredFields DEFAULT_INSTANCE;
    public static final int FIELD_NAMES_FIELD_NUMBER = 2;
    public static final int MESSAGE_NAME_FIELD_NUMBER = 1;
    private static volatile zzaay<MissingRequiredFields> PARSER;
    private String messageName_ = "";
    private zzzs<String> fieldNames_ = zzzg.emptyProtobufList();

    static {
        MissingRequiredFields missingRequiredFields = new MissingRequiredFields();
        DEFAULT_INSTANCE = missingRequiredFields;
        zzzg.registerDefaultInstance(MissingRequiredFields.class, missingRequiredFields);
    }

    private MissingRequiredFields() {
    }

    public static MissingRequiredFields getDefaultInstance() {
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
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0004\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002Ț", new Object[]{"messageName_", "fieldNames_"});
        }
        if (iOrdinal == 3) {
            return new MissingRequiredFields();
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
        zzaay<MissingRequiredFields> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (MissingRequiredFields.class) {
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

    public List<String> getFieldNamesList() {
        return this.fieldNames_;
    }

    public static final class Builder extends zzyy<MissingRequiredFields, Builder> implements zzaar {
        private Builder() {
            super(MissingRequiredFields.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
