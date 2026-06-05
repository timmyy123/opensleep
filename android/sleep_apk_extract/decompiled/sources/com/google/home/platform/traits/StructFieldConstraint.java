package com.google.home.platform.traits;

import com.google.android.gms.internal.serialization.zzaar;
import com.google.android.gms.internal.serialization.zzaay;
import com.google.android.gms.internal.serialization.zzyy;
import com.google.android.gms.internal.serialization.zzyz;
import com.google.android.gms.internal.serialization.zzzf;
import com.google.android.gms.internal.serialization.zzzg;

/* JADX INFO: loaded from: classes4.dex */
public final class StructFieldConstraint extends zzzg<StructFieldConstraint, Builder> implements zzaar {
    public static final int CONSTRAINT_FIELD_NUMBER = 3;
    private static final StructFieldConstraint DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int NAME_FIELD_NUMBER = 2;
    private static volatile zzaay<StructFieldConstraint> PARSER;
    private int bitField0_;
    private ValueTypeConstraint constraint_;
    private int id_;
    private String name_ = "";

    static {
        StructFieldConstraint structFieldConstraint = new StructFieldConstraint();
        DEFAULT_INSTANCE = structFieldConstraint;
        zzzg.registerDefaultInstance(StructFieldConstraint.class, structFieldConstraint);
    }

    private StructFieldConstraint() {
    }

    @Override // com.google.android.gms.internal.serialization.zzzg
    public final Object dynamicMethod(zzzf zzzfVar, Object obj, Object obj2) {
        zzaay zzyzVar;
        int iOrdinal = zzzfVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002Ȉ\u0003ဉ\u0000", new Object[]{"bitField0_", "id_", "name_", "constraint_"});
        }
        if (iOrdinal == 3) {
            return new StructFieldConstraint();
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
        zzaay<StructFieldConstraint> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (StructFieldConstraint.class) {
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

    public ValueTypeConstraint getConstraint() {
        ValueTypeConstraint valueTypeConstraint = this.constraint_;
        return valueTypeConstraint == null ? ValueTypeConstraint.getDefaultInstance() : valueTypeConstraint;
    }

    public int getId() {
        return this.id_;
    }

    public static final class Builder extends zzyy<StructFieldConstraint, Builder> implements zzaar {
        private Builder() {
            super(StructFieldConstraint.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
