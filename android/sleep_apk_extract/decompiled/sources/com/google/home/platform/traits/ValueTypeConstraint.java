package com.google.home.platform.traits;

import com.google.android.gms.internal.serialization.zzaar;
import com.google.android.gms.internal.serialization.zzaay;
import com.google.android.gms.internal.serialization.zzyy;
import com.google.android.gms.internal.serialization.zzyz;
import com.google.android.gms.internal.serialization.zzzf;
import com.google.android.gms.internal.serialization.zzzg;
import com.google.home.platform.traits.metadata.Unit;

/* JADX INFO: loaded from: classes4.dex */
public final class ValueTypeConstraint extends zzzg<ValueTypeConstraint, Builder> implements zzaar {
    public static final int BITMAP_CONSTRAINT_FIELD_NUMBER = 13;
    public static final int BOOLEAN_CONSTRAINT_FIELD_NUMBER = 2;
    public static final int BYTE_CONSTRAINT_FIELD_NUMBER = 15;
    private static final ValueTypeConstraint DEFAULT_INSTANCE;
    public static final int DOUBLE_RANGE_FIELD_NUMBER = 8;
    public static final int ENUM_CONSTRAINT_FIELD_NUMBER = 4;
    public static final int INT_RANGE_FIELD_NUMBER = 3;
    public static final int IS_NULLABLE_FIELD_NUMBER = 14;
    public static final int LIST_CONSTRAINT_FIELD_NUMBER = 11;
    private static volatile zzaay<ValueTypeConstraint> PARSER = null;
    public static final int STRING_ALLOW_LIST_FIELD_NUMBER = 10;
    public static final int STRING_CONSTRAINT_FIELD_NUMBER = 9;
    public static final int STRUCT_CONSTRAINT_FIELD_NUMBER = 5;
    public static final int UINT_RANGE_FIELD_NUMBER = 6;
    public static final int UINT_SET_FIELD_NUMBER = 7;
    public static final int UNIT_FIELD_NUMBER = 12;
    private int bitField0_;
    private int constraintCase_ = 0;
    private Object constraint_;
    private boolean isNullable_;
    private Unit unit_;

    public enum ConstraintCase {
        BOOLEAN_CONSTRAINT(2),
        INT_RANGE(3),
        UINT_RANGE(6),
        UINT_SET(7),
        DOUBLE_RANGE(8),
        ENUM_CONSTRAINT(4),
        STRUCT_CONSTRAINT(5),
        STRING_CONSTRAINT(9),
        STRING_ALLOW_LIST(10),
        LIST_CONSTRAINT(11),
        BITMAP_CONSTRAINT(13),
        BYTE_CONSTRAINT(15),
        CONSTRAINT_NOT_SET(0);

        private final int value;

        ConstraintCase(int i) {
            this.value = i;
        }

        public static ConstraintCase forNumber(int i) {
            if (i == 0) {
                return CONSTRAINT_NOT_SET;
            }
            if (i == 13) {
                return BITMAP_CONSTRAINT;
            }
            if (i == 15) {
                return BYTE_CONSTRAINT;
            }
            switch (i) {
                case 2:
                    return BOOLEAN_CONSTRAINT;
                case 3:
                    return INT_RANGE;
                case 4:
                    return ENUM_CONSTRAINT;
                case 5:
                    return STRUCT_CONSTRAINT;
                case 6:
                    return UINT_RANGE;
                case 7:
                    return UINT_SET;
                case 8:
                    return DOUBLE_RANGE;
                case 9:
                    return STRING_CONSTRAINT;
                case 10:
                    return STRING_ALLOW_LIST;
                case 11:
                    return LIST_CONSTRAINT;
                default:
                    return null;
            }
        }
    }

    static {
        ValueTypeConstraint valueTypeConstraint = new ValueTypeConstraint();
        DEFAULT_INSTANCE = valueTypeConstraint;
        zzzg.registerDefaultInstance(ValueTypeConstraint.class, valueTypeConstraint);
    }

    private ValueTypeConstraint() {
    }

    public static ValueTypeConstraint getDefaultInstance() {
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
            return zzzg.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u000e\u0001\u0001\u0002\u000f\u000e\u0000\u0000\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000\u0006<\u0000\u0007<\u0000\b<\u0000\t<\u0000\n<\u0000\u000b<\u0000\fဉ\u0000\r<\u0000\u000e\u0007\u000f<\u0000", new Object[]{"constraint_", "constraintCase_", "bitField0_", BooleanConstraint.class, IntRangeConstraint.class, EnumConstraint.class, StructConstraint.class, UIntRangeConstraint.class, UIntSetConstraint.class, DoubleRangeConstraint.class, StringConstraint.class, StringAllowListConstraint.class, ListConstraint.class, "unit_", BitmapConstraint.class, "isNullable_", ByteConstraint.class});
        }
        if (iOrdinal == 3) {
            return new ValueTypeConstraint();
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
        zzaay<ValueTypeConstraint> zzaayVar = PARSER;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (ValueTypeConstraint.class) {
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

    public BitmapConstraint getBitmapConstraint() {
        return this.constraintCase_ == 13 ? (BitmapConstraint) this.constraint_ : BitmapConstraint.getDefaultInstance();
    }

    public ByteConstraint getByteConstraint() {
        return this.constraintCase_ == 15 ? (ByteConstraint) this.constraint_ : ByteConstraint.getDefaultInstance();
    }

    public ConstraintCase getConstraintCase() {
        return ConstraintCase.forNumber(this.constraintCase_);
    }

    public DoubleRangeConstraint getDoubleRange() {
        return this.constraintCase_ == 8 ? (DoubleRangeConstraint) this.constraint_ : DoubleRangeConstraint.getDefaultInstance();
    }

    public EnumConstraint getEnumConstraint() {
        return this.constraintCase_ == 4 ? (EnumConstraint) this.constraint_ : EnumConstraint.getDefaultInstance();
    }

    public IntRangeConstraint getIntRange() {
        return this.constraintCase_ == 3 ? (IntRangeConstraint) this.constraint_ : IntRangeConstraint.getDefaultInstance();
    }

    public ListConstraint getListConstraint() {
        return this.constraintCase_ == 11 ? (ListConstraint) this.constraint_ : ListConstraint.getDefaultInstance();
    }

    public StringAllowListConstraint getStringAllowList() {
        return this.constraintCase_ == 10 ? (StringAllowListConstraint) this.constraint_ : StringAllowListConstraint.getDefaultInstance();
    }

    public StringConstraint getStringConstraint() {
        return this.constraintCase_ == 9 ? (StringConstraint) this.constraint_ : StringConstraint.getDefaultInstance();
    }

    public StructConstraint getStructConstraint() {
        return this.constraintCase_ == 5 ? (StructConstraint) this.constraint_ : StructConstraint.getDefaultInstance();
    }

    public UIntRangeConstraint getUintRange() {
        return this.constraintCase_ == 6 ? (UIntRangeConstraint) this.constraint_ : UIntRangeConstraint.getDefaultInstance();
    }

    public UIntSetConstraint getUintSet() {
        return this.constraintCase_ == 7 ? (UIntSetConstraint) this.constraint_ : UIntSetConstraint.getDefaultInstance();
    }

    public Unit getUnit() {
        Unit unit = this.unit_;
        return unit == null ? Unit.getDefaultInstance() : unit;
    }

    public static final class Builder extends zzyy<ValueTypeConstraint, Builder> implements zzaar {
        private Builder() {
            super(ValueTypeConstraint.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(byte[] bArr) {
            this();
        }
    }
}
