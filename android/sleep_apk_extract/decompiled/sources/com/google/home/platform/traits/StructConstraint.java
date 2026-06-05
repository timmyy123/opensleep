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
import com.google.android.gms.internal.serialization.zzzs;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class StructConstraint extends zzzg<StructConstraint, Builder> implements zzaar {
    private static final StructConstraint DEFAULT_INSTANCE;
    public static final int FIELD_CONSTRAINTS_FIELD_NUMBER = 1;
    private static volatile zzaay<StructConstraint> PARSER = null;
    public static final int STRUCT_FIELD_CONSTRAINTS_FIELD_NUMBER = 3;
    private zzaak<String, ValueTypeConstraint> fieldConstraints_ = zzaak.zza();
    private zzzs<StructFieldConstraint> structFieldConstraints_ = zzzg.emptyProtobufList();

    public static final class FieldConstraintsDefaultEntryHolder {
        static final zzaaj<String, ValueTypeConstraint> defaultEntry = zzaaj.zza(zzace.zzi, "", zzace.zzk, ValueTypeConstraint.getDefaultInstance());
    }

    static {
        StructConstraint structConstraint = new StructConstraint();
        DEFAULT_INSTANCE = structConstraint;
        zzzg.registerDefaultInstance(StructConstraint.class, structConstraint);
    }

    private StructConstraint() {
    }

    public static StructConstraint getDefaultInstance() {
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
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0001\u0001\u0000\u00012\u0003\u001b", new Object[]{"fieldConstraints_", FieldConstraintsDefaultEntryHolder.defaultEntry, "structFieldConstraints_", StructFieldConstraint.class});
        }
        if (iOrdinal == 3) {
            return new StructConstraint();
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
        zzaay<StructConstraint> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (StructConstraint.class) {
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

    public List<StructFieldConstraint> getStructFieldConstraintsList() {
        return this.structFieldConstraints_;
    }

    public static final class Builder extends zzyy<StructConstraint, Builder> implements zzaar {
        private Builder() {
            super(StructConstraint.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
