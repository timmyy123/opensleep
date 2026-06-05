package com.google.home.platform.traits;

import com.google.android.gms.internal.serialization.zzaar;
import com.google.android.gms.internal.serialization.zzaay;
import com.google.android.gms.internal.serialization.zzage;
import com.google.android.gms.internal.serialization.zzagg;
import com.google.android.gms.internal.serialization.zzwr;
import com.google.android.gms.internal.serialization.zzyl;
import com.google.android.gms.internal.serialization.zzyy;
import com.google.android.gms.internal.serialization.zzyz;
import com.google.android.gms.internal.serialization.zzzf;
import com.google.android.gms.internal.serialization.zzzg;

/* JADX INFO: loaded from: classes4.dex */
public final class Value extends zzzg<Value, Builder> implements zzaar {
    public static final int BITMAP_VALUE_FIELD_NUMBER = 17;
    public static final int BOOL_VALUE_FIELD_NUMBER = 5;
    public static final int BYTES_VALUE_FIELD_NUMBER = 18;
    public static final int DAY_OF_WEEK_FIELD_NUMBER = 8;
    private static final Value DEFAULT_INSTANCE;
    public static final int DOUBLE_VALUE_FIELD_NUMBER = 3;
    public static final int DURATION_FIELD_NUMBER = 10;
    public static final int ENTITY_FIELD_NUMBER = 21;
    public static final int ENTITY_TYPE_ID_FIELD_NUMBER = 22;
    public static final int ENUM_VALUE_FIELD_NUMBER = 14;
    public static final int FLOAT_VALUE_FIELD_NUMBER = 13;
    public static final int INT_VALUE_FIELD_NUMBER = 1;
    public static final int LIST_VALUE_FIELD_NUMBER = 15;
    public static final int LONG_VALUE_FIELD_NUMBER = 2;
    public static final int MAP_VALUE_FIELD_NUMBER = 20;
    public static final int NULL_VALUE_FIELD_NUMBER = 19;
    private static volatile zzaay<Value> PARSER = null;
    public static final int SOLAR_TIME_FIELD_NUMBER = 9;
    public static final int STRING_VALUE_FIELD_NUMBER = 4;
    public static final int STRUCT_VALUE_FIELD_NUMBER = 16;
    public static final int TIME_OF_DAY_FIELD_NUMBER = 7;
    public static final int UINT_VALUE_FIELD_NUMBER = 11;
    public static final int ULONG_VALUE_FIELD_NUMBER = 12;
    private int valueCase_ = 0;
    private Object value_;

    public enum ValueCase {
        INT_VALUE(1),
        LONG_VALUE(2),
        UINT_VALUE(11),
        ULONG_VALUE(12),
        FLOAT_VALUE(13),
        DOUBLE_VALUE(3),
        STRING_VALUE(4),
        BOOL_VALUE(5),
        BYTES_VALUE(18),
        ENUM_VALUE(14),
        LIST_VALUE(15),
        MAP_VALUE(20),
        STRUCT_VALUE(16),
        BITMAP_VALUE(17),
        TIME_OF_DAY(7),
        DAY_OF_WEEK(8),
        SOLAR_TIME(9),
        DURATION(10),
        ENTITY(21),
        ENTITY_TYPE_ID(22),
        NULL_VALUE(19),
        VALUE_NOT_SET(0);

        private final int value;

        ValueCase(int i) {
            this.value = i;
        }

        public static ValueCase forNumber(int i) {
            switch (i) {
                case 0:
                    return VALUE_NOT_SET;
                case 1:
                    return INT_VALUE;
                case 2:
                    return LONG_VALUE;
                case 3:
                    return DOUBLE_VALUE;
                case 4:
                    return STRING_VALUE;
                case 5:
                    return BOOL_VALUE;
                case 6:
                default:
                    return null;
                case 7:
                    return TIME_OF_DAY;
                case 8:
                    return DAY_OF_WEEK;
                case 9:
                    return SOLAR_TIME;
                case 10:
                    return DURATION;
                case 11:
                    return UINT_VALUE;
                case 12:
                    return ULONG_VALUE;
                case 13:
                    return FLOAT_VALUE;
                case 14:
                    return ENUM_VALUE;
                case 15:
                    return LIST_VALUE;
                case 16:
                    return STRUCT_VALUE;
                case 17:
                    return BITMAP_VALUE;
                case 18:
                    return BYTES_VALUE;
                case 19:
                    return NULL_VALUE;
                case 20:
                    return MAP_VALUE;
                case 21:
                    return ENTITY;
                case 22:
                    return ENTITY_TYPE_ID;
            }
        }
    }

    static {
        Value value = new Value();
        DEFAULT_INSTANCE = value;
        zzzg.registerDefaultInstance(Value.class, value);
    }

    private Value() {
    }

    public static Value getDefaultInstance() {
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
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0004\u0015\u0001\u0000\u0001\u0016\u0015\u0000\u0000\u0000\u00017\u0000\u00025\u0000\u00033\u0000\u0004Ȼ\u0000\u0005:\u0000\u0007<\u0000\b?\u0000\t<\u0000\n<\u0000\u000b>\u0000\f6\u0000\r4\u0000\u000e<\u0000\u000f<\u0000\u0010<\u0000\u0011<\u0000\u0012=\u0000\u0013\u083f\u0000\u0014<\u0000\u0015<\u0000\u0016Ȼ\u0000", new Object[]{"value_", "valueCase_", zzagg.class, SolarTime.class, zzyl.class, EnumValue.class, ListValue.class, StructValue.class, BitmapValue.class, NullValue.internalGetVerifier(), MapValue.class, Entity.class});
        }
        if (iOrdinal == 3) {
            return new Value();
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
        zzaay<Value> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (Value.class) {
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

    public BitmapValue getBitmapValue() {
        return this.valueCase_ == 17 ? (BitmapValue) this.value_ : BitmapValue.getDefaultInstance();
    }

    public boolean getBoolValue() {
        if (this.valueCase_ == 5) {
            return ((Boolean) this.value_).booleanValue();
        }
        return false;
    }

    public zzwr getBytesValue() {
        return this.valueCase_ == 18 ? (zzwr) this.value_ : zzwr.zzb;
    }

    public zzage getDayOfWeek() {
        if (this.valueCase_ != 8) {
            return zzage.DAY_OF_WEEK_UNSPECIFIED;
        }
        zzage zzageVarZza = zzage.zza(((Integer) this.value_).intValue());
        return zzageVarZza == null ? zzage.UNRECOGNIZED : zzageVarZza;
    }

    public double getDoubleValue() {
        if (this.valueCase_ == 3) {
            return ((Double) this.value_).doubleValue();
        }
        return 0.0d;
    }

    public zzyl getDuration() {
        return this.valueCase_ == 10 ? (zzyl) this.value_ : zzyl.zze();
    }

    public String getEntityTypeId() {
        return this.valueCase_ == 22 ? (String) this.value_ : "";
    }

    public EnumValue getEnumValue() {
        return this.valueCase_ == 14 ? (EnumValue) this.value_ : EnumValue.getDefaultInstance();
    }

    public float getFloatValue() {
        if (this.valueCase_ == 13) {
            return ((Float) this.value_).floatValue();
        }
        return 0.0f;
    }

    public int getIntValue() {
        if (this.valueCase_ == 1) {
            return ((Integer) this.value_).intValue();
        }
        return 0;
    }

    public ListValue getListValue() {
        return this.valueCase_ == 15 ? (ListValue) this.value_ : ListValue.getDefaultInstance();
    }

    public long getLongValue() {
        if (this.valueCase_ == 2) {
            return ((Long) this.value_).longValue();
        }
        return 0L;
    }

    public MapValue getMapValue() {
        return this.valueCase_ == 20 ? (MapValue) this.value_ : MapValue.getDefaultInstance();
    }

    public SolarTime getSolarTime() {
        return this.valueCase_ == 9 ? (SolarTime) this.value_ : SolarTime.getDefaultInstance();
    }

    public String getStringValue() {
        return this.valueCase_ == 4 ? (String) this.value_ : "";
    }

    public StructValue getStructValue() {
        return this.valueCase_ == 16 ? (StructValue) this.value_ : StructValue.getDefaultInstance();
    }

    public zzagg getTimeOfDay() {
        return this.valueCase_ == 7 ? (zzagg) this.value_ : zzagg.zzg();
    }

    public int getUintValue() {
        if (this.valueCase_ == 11) {
            return ((Integer) this.value_).intValue();
        }
        return 0;
    }

    public long getUlongValue() {
        if (this.valueCase_ == 12) {
            return ((Long) this.value_).longValue();
        }
        return 0L;
    }

    public ValueCase getValueCase() {
        return ValueCase.forNumber(this.valueCase_);
    }

    public boolean hasListValue() {
        return this.valueCase_ == 15;
    }

    public boolean hasNullValue() {
        return this.valueCase_ == 19;
    }

    public static final class Builder extends zzyy<Value, Builder> implements zzaar {
        private Builder() {
            super(Value.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
