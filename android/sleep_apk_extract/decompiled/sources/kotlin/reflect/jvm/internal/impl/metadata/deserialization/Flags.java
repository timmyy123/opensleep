package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$MemberKind;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Modality;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ReturnValueStatus;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Visibility;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Flags {
    public static final FlagField<ProtoBuf$Class.Kind> CLASS_KIND;
    public static final BooleanFlagField DECLARES_DEFAULT_VALUE;
    public static final BooleanFlagField DEFINITELY_NOT_NULL_TYPE;
    public static final BooleanFlagField HAS_ANNOTATIONS;
    public static final BooleanFlagField HAS_CONSTANT;
    public static final BooleanFlagField HAS_ENUM_ENTRIES;
    public static final BooleanFlagField HAS_GETTER;
    public static final BooleanFlagField HAS_SETTER;
    public static final BooleanFlagField IS_CONST;
    public static final BooleanFlagField IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES;
    public static final BooleanFlagField IS_CROSSINLINE;
    public static final BooleanFlagField IS_DATA;
    public static final BooleanFlagField IS_DELEGATED;
    public static final BooleanFlagField IS_EXPECT_CLASS;
    public static final BooleanFlagField IS_EXPECT_FUNCTION;
    public static final BooleanFlagField IS_EXPECT_PROPERTY;
    public static final BooleanFlagField IS_EXTERNAL_ACCESSOR;
    public static final BooleanFlagField IS_EXTERNAL_CLASS;
    public static final BooleanFlagField IS_EXTERNAL_FUNCTION;
    public static final BooleanFlagField IS_EXTERNAL_PROPERTY;
    public static final BooleanFlagField IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES;
    public static final BooleanFlagField IS_FUN_INTERFACE;
    public static final BooleanFlagField IS_INFIX;
    public static final BooleanFlagField IS_INLINE;
    public static final BooleanFlagField IS_INLINE_ACCESSOR;
    public static final BooleanFlagField IS_INNER;
    public static final BooleanFlagField IS_LATEINIT;
    public static final BooleanFlagField IS_NEGATED;
    public static final BooleanFlagField IS_NOINLINE;
    public static final BooleanFlagField IS_NOT_DEFAULT;
    public static final BooleanFlagField IS_NULL_CHECK_PREDICATE;
    public static final BooleanFlagField IS_OPERATOR;
    public static final BooleanFlagField IS_SECONDARY;
    public static final BooleanFlagField IS_SUSPEND;
    public static final BooleanFlagField IS_TAILREC;
    public static final BooleanFlagField IS_UNSIGNED;
    public static final BooleanFlagField IS_VALUE_CLASS;
    public static final BooleanFlagField IS_VAR;
    public static final FlagField<ProtoBuf$MemberKind> MEMBER_KIND;
    public static final FlagField<ProtoBuf$Modality> MODALITY;
    public static final FlagField<ProtoBuf$ReturnValueStatus> RETURN_VALUE_STATUS_CTOR;
    public static final FlagField<ProtoBuf$ReturnValueStatus> RETURN_VALUE_STATUS_FUNCTION;
    public static final FlagField<ProtoBuf$ReturnValueStatus> RETURN_VALUE_STATUS_PROPERTY;
    public static final BooleanFlagField SUSPEND_TYPE;
    public static final FlagField<ProtoBuf$Visibility> VISIBILITY;

    public static class BooleanFlagField extends FlagField<Boolean> {
        public BooleanFlagField(int i) {
            super(i, 1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.FlagField
        public Boolean get(int i) {
            return Boolean.valueOf(((1 << this.offset) & i) != 0);
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.FlagField
        public int toFlags(Boolean bool) {
            if (bool.booleanValue()) {
                return 1 << this.offset;
            }
            return 0;
        }
    }

    public static class EnumLiteFlagField<E extends Internal.EnumLite> extends FlagField<E> {
        private final E[] values;

        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            throw new IllegalArgumentException("Argument for @NotNull parameter 'enumEntries' of kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$EnumLiteFlagField.bitWidth must not be null");
        }

        public EnumLiteFlagField(int i, E[] eArr) {
            super(i, bitWidth(eArr));
            this.values = eArr;
        }

        private static <E> int bitWidth(E[] eArr) {
            if (eArr == null) {
                $$$reportNull$$$0(0);
            }
            int length = eArr.length - 1;
            if (length == 0) {
                return 1;
            }
            for (int i = 31; i >= 0; i--) {
                if (((1 << i) & length) != 0) {
                    return i + 1;
                }
            }
            Home$$ExternalSyntheticBUOutline0.m("Empty enum: ", (Object) eArr.getClass());
            return 0;
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.FlagField
        public E get(int i) {
            int i2 = (1 << this.bitWidth) - 1;
            int i3 = this.offset;
            int i4 = (i & (i2 << i3)) >> i3;
            for (E e : this.values) {
                if (e.getNumber() == i4) {
                    return e;
                }
            }
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.FlagField
        public int toFlags(E e) {
            return e.getNumber() << this.offset;
        }
    }

    public static abstract class FlagField<E> {
        public final int bitWidth;
        public final int offset;

        private FlagField(int i, int i2) {
            this.offset = i;
            this.bitWidth = i2;
        }

        /* JADX WARN: Incorrect types in method signature: <E::Lkotlin/reflect/jvm/internal/impl/protobuf/Internal$EnumLite;>(Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$FlagField<*>;[TE;)Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$FlagField<TE;>; */
        public static FlagField after(FlagField flagField, Internal.EnumLite[] enumLiteArr) {
            return new EnumLiteFlagField(flagField.offset + flagField.bitWidth, enumLiteArr);
        }

        public static BooleanFlagField booleanAfter(FlagField<?> flagField) {
            return new BooleanFlagField(flagField.offset + flagField.bitWidth);
        }

        public static BooleanFlagField booleanFirst() {
            return new BooleanFlagField(0);
        }

        public abstract E get(int i);

        public abstract int toFlags(E e);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        Object[] objArr = new Object[3];
        if (i == 1) {
            objArr[0] = "modality";
        } else if (i == 2) {
            objArr[0] = "kind";
        } else if (i != 5) {
            if (i == 6) {
                objArr[0] = "memberKind";
            } else if (i != 8) {
                if (i != 9) {
                    if (i != 11) {
                        objArr[0] = ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY;
                    }
                }
            }
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags";
        switch (i) {
            case 3:
                objArr[2] = "getConstructorFlags";
                break;
            case 4:
            case 5:
            case 6:
                objArr[2] = "getFunctionFlags";
                break;
            case 7:
            case 8:
            case 9:
                objArr[2] = "getPropertyFlags";
                break;
            case 10:
            case 11:
                objArr[2] = "getAccessorFlags";
                break;
            default:
                objArr[2] = "getClassFlags";
                break;
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    static {
        BooleanFlagField booleanFlagFieldBooleanFirst = FlagField.booleanFirst();
        SUSPEND_TYPE = booleanFlagFieldBooleanFirst;
        DEFINITELY_NOT_NULL_TYPE = FlagField.booleanAfter(booleanFlagFieldBooleanFirst);
        BooleanFlagField booleanFlagFieldBooleanFirst2 = FlagField.booleanFirst();
        HAS_ANNOTATIONS = booleanFlagFieldBooleanFirst2;
        FlagField<ProtoBuf$Visibility> flagFieldAfter = FlagField.after(booleanFlagFieldBooleanFirst2, ProtoBuf$Visibility.values());
        VISIBILITY = flagFieldAfter;
        FlagField<ProtoBuf$Modality> flagFieldAfter2 = FlagField.after(flagFieldAfter, ProtoBuf$Modality.values());
        MODALITY = flagFieldAfter2;
        FlagField<ProtoBuf$Class.Kind> flagFieldAfter3 = FlagField.after(flagFieldAfter2, ProtoBuf$Class.Kind.values());
        CLASS_KIND = flagFieldAfter3;
        BooleanFlagField booleanFlagFieldBooleanAfter = FlagField.booleanAfter(flagFieldAfter3);
        IS_INNER = booleanFlagFieldBooleanAfter;
        BooleanFlagField booleanFlagFieldBooleanAfter2 = FlagField.booleanAfter(booleanFlagFieldBooleanAfter);
        IS_DATA = booleanFlagFieldBooleanAfter2;
        BooleanFlagField booleanFlagFieldBooleanAfter3 = FlagField.booleanAfter(booleanFlagFieldBooleanAfter2);
        IS_EXTERNAL_CLASS = booleanFlagFieldBooleanAfter3;
        BooleanFlagField booleanFlagFieldBooleanAfter4 = FlagField.booleanAfter(booleanFlagFieldBooleanAfter3);
        IS_EXPECT_CLASS = booleanFlagFieldBooleanAfter4;
        BooleanFlagField booleanFlagFieldBooleanAfter5 = FlagField.booleanAfter(booleanFlagFieldBooleanAfter4);
        IS_VALUE_CLASS = booleanFlagFieldBooleanAfter5;
        BooleanFlagField booleanFlagFieldBooleanAfter6 = FlagField.booleanAfter(booleanFlagFieldBooleanAfter5);
        IS_FUN_INTERFACE = booleanFlagFieldBooleanAfter6;
        HAS_ENUM_ENTRIES = FlagField.booleanAfter(booleanFlagFieldBooleanAfter6);
        BooleanFlagField booleanFlagFieldBooleanAfter7 = FlagField.booleanAfter(flagFieldAfter);
        IS_SECONDARY = booleanFlagFieldBooleanAfter7;
        BooleanFlagField booleanFlagFieldBooleanAfter8 = FlagField.booleanAfter(booleanFlagFieldBooleanAfter7);
        IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES = booleanFlagFieldBooleanAfter8;
        RETURN_VALUE_STATUS_CTOR = FlagField.after(booleanFlagFieldBooleanAfter8, ProtoBuf$ReturnValueStatus.values());
        FlagField<ProtoBuf$MemberKind> flagFieldAfter4 = FlagField.after(flagFieldAfter2, ProtoBuf$MemberKind.values());
        MEMBER_KIND = flagFieldAfter4;
        BooleanFlagField booleanFlagFieldBooleanAfter9 = FlagField.booleanAfter(flagFieldAfter4);
        IS_OPERATOR = booleanFlagFieldBooleanAfter9;
        BooleanFlagField booleanFlagFieldBooleanAfter10 = FlagField.booleanAfter(booleanFlagFieldBooleanAfter9);
        IS_INFIX = booleanFlagFieldBooleanAfter10;
        BooleanFlagField booleanFlagFieldBooleanAfter11 = FlagField.booleanAfter(booleanFlagFieldBooleanAfter10);
        IS_INLINE = booleanFlagFieldBooleanAfter11;
        BooleanFlagField booleanFlagFieldBooleanAfter12 = FlagField.booleanAfter(booleanFlagFieldBooleanAfter11);
        IS_TAILREC = booleanFlagFieldBooleanAfter12;
        BooleanFlagField booleanFlagFieldBooleanAfter13 = FlagField.booleanAfter(booleanFlagFieldBooleanAfter12);
        IS_EXTERNAL_FUNCTION = booleanFlagFieldBooleanAfter13;
        BooleanFlagField booleanFlagFieldBooleanAfter14 = FlagField.booleanAfter(booleanFlagFieldBooleanAfter13);
        IS_SUSPEND = booleanFlagFieldBooleanAfter14;
        BooleanFlagField booleanFlagFieldBooleanAfter15 = FlagField.booleanAfter(booleanFlagFieldBooleanAfter14);
        IS_EXPECT_FUNCTION = booleanFlagFieldBooleanAfter15;
        BooleanFlagField booleanFlagFieldBooleanAfter16 = FlagField.booleanAfter(booleanFlagFieldBooleanAfter15);
        IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES = booleanFlagFieldBooleanAfter16;
        RETURN_VALUE_STATUS_FUNCTION = FlagField.after(booleanFlagFieldBooleanAfter16, ProtoBuf$ReturnValueStatus.values());
        BooleanFlagField booleanFlagFieldBooleanAfter17 = FlagField.booleanAfter(flagFieldAfter4);
        IS_VAR = booleanFlagFieldBooleanAfter17;
        BooleanFlagField booleanFlagFieldBooleanAfter18 = FlagField.booleanAfter(booleanFlagFieldBooleanAfter17);
        HAS_GETTER = booleanFlagFieldBooleanAfter18;
        BooleanFlagField booleanFlagFieldBooleanAfter19 = FlagField.booleanAfter(booleanFlagFieldBooleanAfter18);
        HAS_SETTER = booleanFlagFieldBooleanAfter19;
        BooleanFlagField booleanFlagFieldBooleanAfter20 = FlagField.booleanAfter(booleanFlagFieldBooleanAfter19);
        IS_CONST = booleanFlagFieldBooleanAfter20;
        BooleanFlagField booleanFlagFieldBooleanAfter21 = FlagField.booleanAfter(booleanFlagFieldBooleanAfter20);
        IS_LATEINIT = booleanFlagFieldBooleanAfter21;
        BooleanFlagField booleanFlagFieldBooleanAfter22 = FlagField.booleanAfter(booleanFlagFieldBooleanAfter21);
        HAS_CONSTANT = booleanFlagFieldBooleanAfter22;
        BooleanFlagField booleanFlagFieldBooleanAfter23 = FlagField.booleanAfter(booleanFlagFieldBooleanAfter22);
        IS_EXTERNAL_PROPERTY = booleanFlagFieldBooleanAfter23;
        BooleanFlagField booleanFlagFieldBooleanAfter24 = FlagField.booleanAfter(booleanFlagFieldBooleanAfter23);
        IS_DELEGATED = booleanFlagFieldBooleanAfter24;
        BooleanFlagField booleanFlagFieldBooleanAfter25 = FlagField.booleanAfter(booleanFlagFieldBooleanAfter24);
        IS_EXPECT_PROPERTY = booleanFlagFieldBooleanAfter25;
        RETURN_VALUE_STATUS_PROPERTY = FlagField.after(booleanFlagFieldBooleanAfter25, ProtoBuf$ReturnValueStatus.values());
        BooleanFlagField booleanFlagFieldBooleanAfter26 = FlagField.booleanAfter(booleanFlagFieldBooleanFirst2);
        DECLARES_DEFAULT_VALUE = booleanFlagFieldBooleanAfter26;
        BooleanFlagField booleanFlagFieldBooleanAfter27 = FlagField.booleanAfter(booleanFlagFieldBooleanAfter26);
        IS_CROSSINLINE = booleanFlagFieldBooleanAfter27;
        IS_NOINLINE = FlagField.booleanAfter(booleanFlagFieldBooleanAfter27);
        BooleanFlagField booleanFlagFieldBooleanAfter28 = FlagField.booleanAfter(flagFieldAfter2);
        IS_NOT_DEFAULT = booleanFlagFieldBooleanAfter28;
        BooleanFlagField booleanFlagFieldBooleanAfter29 = FlagField.booleanAfter(booleanFlagFieldBooleanAfter28);
        IS_EXTERNAL_ACCESSOR = booleanFlagFieldBooleanAfter29;
        IS_INLINE_ACCESSOR = FlagField.booleanAfter(booleanFlagFieldBooleanAfter29);
        BooleanFlagField booleanFlagFieldBooleanFirst3 = FlagField.booleanFirst();
        IS_NEGATED = booleanFlagFieldBooleanFirst3;
        IS_NULL_CHECK_PREDICATE = FlagField.booleanAfter(booleanFlagFieldBooleanFirst3);
        IS_UNSIGNED = FlagField.booleanFirst();
    }

    public static int getAccessorFlags(boolean z, ProtoBuf$Visibility protoBuf$Visibility, ProtoBuf$Modality protoBuf$Modality, boolean z2, boolean z3, boolean z4) {
        if (protoBuf$Visibility == null) {
            $$$reportNull$$$0(10);
        }
        if (protoBuf$Modality == null) {
            $$$reportNull$$$0(11);
        }
        return HAS_ANNOTATIONS.toFlags(Boolean.valueOf(z)) | MODALITY.toFlags(protoBuf$Modality) | VISIBILITY.toFlags(protoBuf$Visibility) | IS_NOT_DEFAULT.toFlags(Boolean.valueOf(z2)) | IS_EXTERNAL_ACCESSOR.toFlags(Boolean.valueOf(z3)) | IS_INLINE_ACCESSOR.toFlags(Boolean.valueOf(z4));
    }
}
