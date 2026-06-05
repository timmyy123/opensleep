package com.google.home.platform.traits;

import com.google.android.gms.internal.serialization.zzaar;
import com.google.android.gms.internal.serialization.zzaay;
import com.google.android.gms.internal.serialization.zzyy;
import com.google.android.gms.internal.serialization.zzyz;
import com.google.android.gms.internal.serialization.zzzf;
import com.google.android.gms.internal.serialization.zzzg;

/* JADX INFO: loaded from: classes4.dex */
public final class ListConstraint extends zzzg<ListConstraint, Builder> implements zzaar {
    private static final ListConstraint DEFAULT_INSTANCE;
    public static final int ELEMENTS_CONSTRAINT_FIELD_NUMBER = 1;
    private static volatile zzaay<ListConstraint> PARSER;
    private int bitField0_;
    private ValueTypeConstraint elementsConstraint_;

    static {
        ListConstraint listConstraint = new ListConstraint();
        DEFAULT_INSTANCE = listConstraint;
        zzzg.registerDefaultInstance(ListConstraint.class, listConstraint);
    }

    private ListConstraint() {
    }

    public static ListConstraint getDefaultInstance() {
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
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "elementsConstraint_"});
        }
        if (iOrdinal == 3) {
            return new ListConstraint();
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
        zzaay<ListConstraint> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (ListConstraint.class) {
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

    public ValueTypeConstraint getElementsConstraint() {
        ValueTypeConstraint valueTypeConstraint = this.elementsConstraint_;
        return valueTypeConstraint == null ? ValueTypeConstraint.getDefaultInstance() : valueTypeConstraint;
    }

    public static final class Builder extends zzyy<ListConstraint, Builder> implements zzaar {
        private Builder() {
            super(ListConstraint.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
