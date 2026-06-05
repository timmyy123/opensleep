package com.google.home.platform.traits;

import com.google.android.gms.internal.serialization.zzaar;
import com.google.android.gms.internal.serialization.zzaay;
import com.google.android.gms.internal.serialization.zzyy;
import com.google.android.gms.internal.serialization.zzyz;
import com.google.android.gms.internal.serialization.zzzf;
import com.google.android.gms.internal.serialization.zzzg;

/* JADX INFO: loaded from: classes4.dex */
public final class Parameter extends zzzg<Parameter, Builder> implements zzaar {
    public static final int CONSTANT_FIELD_NUMBER = 3;
    private static final Parameter DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 4;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile zzaay<Parameter> PARSER;
    private Object field_;
    private Object value_;
    private int fieldCase_ = 0;
    private int valueCase_ = 0;

    static {
        Parameter parameter = new Parameter();
        DEFAULT_INSTANCE = parameter;
        zzzg.registerDefaultInstance(Parameter.class, parameter);
    }

    private Parameter() {
    }

    @Override // com.google.android.gms.internal.serialization.zzzg
    public final Object dynamicMethod(zzzf zzzfVar, Object obj, Object obj2) {
        zzaay zzyzVar;
        int iOrdinal = zzzfVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0004\u0003\u0002\u0000\u0001\u0004\u0003\u0000\u0000\u0000\u0001Ȼ\u0000\u0003<\u0001\u0004>\u0000", new Object[]{"field_", "fieldCase_", "value_", "valueCase_", Value.class});
        }
        if (iOrdinal == 3) {
            return new Parameter();
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
        zzaay<Parameter> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (Parameter.class) {
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

    public Value getConstant() {
        return this.valueCase_ == 3 ? (Value) this.value_ : Value.getDefaultInstance();
    }

    public int getId() {
        if (this.fieldCase_ == 4) {
            return ((Integer) this.field_).intValue();
        }
        return 0;
    }

    public String getName() {
        return this.fieldCase_ == 1 ? (String) this.field_ : "";
    }

    public boolean hasId() {
        return this.fieldCase_ == 4;
    }

    public static final class Builder extends zzyy<Parameter, Builder> implements zzaar {
        private Builder() {
            super(Parameter.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
