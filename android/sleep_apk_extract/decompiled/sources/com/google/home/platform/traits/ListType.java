package com.google.home.platform.traits;

import com.google.android.gms.internal.serialization.zzaar;
import com.google.android.gms.internal.serialization.zzaay;
import com.google.android.gms.internal.serialization.zzyy;
import com.google.android.gms.internal.serialization.zzyz;
import com.google.android.gms.internal.serialization.zzzf;
import com.google.android.gms.internal.serialization.zzzg;

/* JADX INFO: loaded from: classes4.dex */
public final class ListType extends zzzg<ListType, Builder> implements zzaar {
    private static final ListType DEFAULT_INSTANCE;
    public static final int ELEMENT_TYPE_FIELD_NUMBER = 1;
    private static volatile zzaay<ListType> PARSER;
    private int bitField0_;
    private ValueType elementType_;

    static {
        ListType listType = new ListType();
        DEFAULT_INSTANCE = listType;
        zzzg.registerDefaultInstance(ListType.class, listType);
    }

    private ListType() {
    }

    public static ListType getDefaultInstance() {
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
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0004\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "elementType_"});
        }
        if (iOrdinal == 3) {
            return new ListType();
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
        zzaay<ListType> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (ListType.class) {
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

    public ValueType getElementType() {
        ValueType valueType = this.elementType_;
        return valueType == null ? ValueType.getDefaultInstance() : valueType;
    }

    public static final class Builder extends zzyy<ListType, Builder> implements zzaar {
        private Builder() {
            super(ListType.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
