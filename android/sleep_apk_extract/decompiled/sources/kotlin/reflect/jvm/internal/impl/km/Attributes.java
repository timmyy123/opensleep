package kotlin.reflect.jvm.internal.impl.km;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.km.internal.BooleanFlagDelegate;
import kotlin.reflect.jvm.internal.impl.km.internal.EnumFlagDelegate;
import kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt;
import kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ReturnValueStatus;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Attributes {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {new MutablePropertyReference1Impl(Attributes.class, "hasAnnotations", "getHasAnnotations(Lkotlin/metadata/KmClass;)Z", 1), new MutablePropertyReference1Impl(Attributes.class, "hasAnnotations", "getHasAnnotations(Lkotlin/metadata/KmConstructor;)Z", 1), new MutablePropertyReference1Impl(Attributes.class, "hasAnnotations", "getHasAnnotations(Lkotlin/metadata/KmFunction;)Z", 1), new MutablePropertyReference1Impl(Attributes.class, "hasAnnotations", "getHasAnnotations(Lkotlin/metadata/KmProperty;)Z", 1), new MutablePropertyReference1Impl(Attributes.class, "hasAnnotations", "getHasAnnotations(Lkotlin/metadata/KmPropertyAccessorAttributes;)Z", 1), new MutablePropertyReference1Impl(Attributes.class, "hasAnnotations", "getHasAnnotations(Lkotlin/metadata/KmValueParameter;)Z", 1), new MutablePropertyReference1Impl(Attributes.class, "hasAnnotations", "getHasAnnotations(Lkotlin/metadata/KmTypeAlias;)Z", 1), new MutablePropertyReference1Impl(Attributes.class, "modality", "getModality(Lkotlin/metadata/KmClass;)Lkotlin/metadata/Modality;", 1), new MutablePropertyReference1Impl(Attributes.class, ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY, "getVisibility(Lkotlin/metadata/KmClass;)Lkotlin/metadata/Visibility;", 1), new MutablePropertyReference1Impl(Attributes.class, "kind", "getKind(Lkotlin/metadata/KmClass;)Lkotlin/metadata/ClassKind;", 1), new MutablePropertyReference1Impl(Attributes.class, "isInner", "isInner(Lkotlin/metadata/KmClass;)Z", 1), new MutablePropertyReference1Impl(Attributes.class, "isData", "isData(Lkotlin/metadata/KmClass;)Z", 1), new MutablePropertyReference1Impl(Attributes.class, "isExternal", "isExternal(Lkotlin/metadata/KmClass;)Z", 1), new MutablePropertyReference1Impl(Attributes.class, "isExpect", "isExpect(Lkotlin/metadata/KmClass;)Z", 1), new MutablePropertyReference1Impl(Attributes.class, "isValue", "isValue(Lkotlin/metadata/KmClass;)Z", 1), new MutablePropertyReference1Impl(Attributes.class, "isFunInterface", "isFunInterface(Lkotlin/metadata/KmClass;)Z", 1), new MutablePropertyReference1Impl(Attributes.class, "hasEnumEntries", "getHasEnumEntries(Lkotlin/metadata/KmClass;)Z", 1), new MutablePropertyReference1Impl(Attributes.class, ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY, "getVisibility(Lkotlin/metadata/KmConstructor;)Lkotlin/metadata/Visibility;", 1), new MutablePropertyReference1Impl(Attributes.class, "isSecondary", "isSecondary(Lkotlin/metadata/KmConstructor;)Z", 1), new MutablePropertyReference1Impl(Attributes.class, "hasNonStableParameterNames", "getHasNonStableParameterNames(Lkotlin/metadata/KmConstructor;)Z", 1), new MutablePropertyReference1Impl(Attributes.class, "returnValueStatus", "getReturnValueStatus(Lkotlin/metadata/KmConstructor;)Lkotlin/metadata/ReturnValueStatus;", 1), new MutablePropertyReference1Impl(Attributes.class, "kind", "getKind(Lkotlin/metadata/KmFunction;)Lkotlin/metadata/MemberKind;", 1), new MutablePropertyReference1Impl(Attributes.class, ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY, "getVisibility(Lkotlin/metadata/KmFunction;)Lkotlin/metadata/Visibility;", 1), new MutablePropertyReference1Impl(Attributes.class, "modality", "getModality(Lkotlin/metadata/KmFunction;)Lkotlin/metadata/Modality;", 1), new MutablePropertyReference1Impl(Attributes.class, "isOperator", "isOperator(Lkotlin/metadata/KmFunction;)Z", 1), new MutablePropertyReference1Impl(Attributes.class, "isInfix", "isInfix(Lkotlin/metadata/KmFunction;)Z", 1), new MutablePropertyReference1Impl(Attributes.class, "isInline", "isInline(Lkotlin/metadata/KmFunction;)Z", 1), new MutablePropertyReference1Impl(Attributes.class, "isTailrec", "isTailrec(Lkotlin/metadata/KmFunction;)Z", 1), new MutablePropertyReference1Impl(Attributes.class, "isExternal", "isExternal(Lkotlin/metadata/KmFunction;)Z", 1), new MutablePropertyReference1Impl(Attributes.class, "isSuspend", "isSuspend(Lkotlin/metadata/KmFunction;)Z", 1), new MutablePropertyReference1Impl(Attributes.class, "isExpect", "isExpect(Lkotlin/metadata/KmFunction;)Z", 1), new MutablePropertyReference1Impl(Attributes.class, "hasNonStableParameterNames", "getHasNonStableParameterNames(Lkotlin/metadata/KmFunction;)Z", 1), new MutablePropertyReference1Impl(Attributes.class, "returnValueStatus", "getReturnValueStatus(Lkotlin/metadata/KmFunction;)Lkotlin/metadata/ReturnValueStatus;", 1), new MutablePropertyReference1Impl(Attributes.class, ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY, "getVisibility(Lkotlin/metadata/KmProperty;)Lkotlin/metadata/Visibility;", 1), new MutablePropertyReference1Impl(Attributes.class, "modality", "getModality(Lkotlin/metadata/KmProperty;)Lkotlin/metadata/Modality;", 1), new MutablePropertyReference1Impl(Attributes.class, "kind", "getKind(Lkotlin/metadata/KmProperty;)Lkotlin/metadata/MemberKind;", 1), new MutablePropertyReference1Impl(Attributes.class, "isVar", "isVar(Lkotlin/metadata/KmProperty;)Z", 1), new MutablePropertyReference1Impl(Attributes.class, "isConst", "isConst(Lkotlin/metadata/KmProperty;)Z", 1), new MutablePropertyReference1Impl(Attributes.class, "isLateinit", "isLateinit(Lkotlin/metadata/KmProperty;)Z", 1), new MutablePropertyReference1Impl(Attributes.class, "hasConstant", "getHasConstant(Lkotlin/metadata/KmProperty;)Z", 1), new MutablePropertyReference1Impl(Attributes.class, "isExternal", "isExternal(Lkotlin/metadata/KmProperty;)Z", 1), new MutablePropertyReference1Impl(Attributes.class, "isDelegated", "isDelegated(Lkotlin/metadata/KmProperty;)Z", 1), new MutablePropertyReference1Impl(Attributes.class, "isExpect", "isExpect(Lkotlin/metadata/KmProperty;)Z", 1), new MutablePropertyReference1Impl(Attributes.class, "returnValueStatus", "getReturnValueStatus(Lkotlin/metadata/KmProperty;)Lkotlin/metadata/ReturnValueStatus;", 1), new MutablePropertyReference1Impl(Attributes.class, ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY, "getVisibility(Lkotlin/metadata/KmPropertyAccessorAttributes;)Lkotlin/metadata/Visibility;", 1), new MutablePropertyReference1Impl(Attributes.class, "modality", "getModality(Lkotlin/metadata/KmPropertyAccessorAttributes;)Lkotlin/metadata/Modality;", 1), new MutablePropertyReference1Impl(Attributes.class, "isNotDefault", "isNotDefault(Lkotlin/metadata/KmPropertyAccessorAttributes;)Z", 1), new MutablePropertyReference1Impl(Attributes.class, "isExternal", "isExternal(Lkotlin/metadata/KmPropertyAccessorAttributes;)Z", 1), new MutablePropertyReference1Impl(Attributes.class, "isInline", "isInline(Lkotlin/metadata/KmPropertyAccessorAttributes;)Z", 1), new MutablePropertyReference1Impl(Attributes.class, "isNullable", "isNullable(Lkotlin/metadata/KmType;)Z", 1), new MutablePropertyReference1Impl(Attributes.class, "isSuspend", "isSuspend(Lkotlin/metadata/KmType;)Z", 1), new MutablePropertyReference1Impl(Attributes.class, "isDefinitelyNonNull", "isDefinitelyNonNull(Lkotlin/metadata/KmType;)Z", 1), new MutablePropertyReference1Impl(Attributes.class, "isReified", "isReified(Lkotlin/metadata/KmTypeParameter;)Z", 1), new MutablePropertyReference1Impl(Attributes.class, ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY, "getVisibility(Lkotlin/metadata/KmTypeAlias;)Lkotlin/metadata/Visibility;", 1), new MutablePropertyReference1Impl(Attributes.class, "declaresDefaultValue", "getDeclaresDefaultValue(Lkotlin/metadata/KmValueParameter;)Z", 1), new MutablePropertyReference1Impl(Attributes.class, "isCrossinline", "isCrossinline(Lkotlin/metadata/KmValueParameter;)Z", 1), new MutablePropertyReference1Impl(Attributes.class, "isNoinline", "isNoinline(Lkotlin/metadata/KmValueParameter;)Z", 1), new MutablePropertyReference1Impl(Attributes.class, "isNegated", "isNegated(Lkotlin/metadata/KmEffectExpression;)Z", 1), new MutablePropertyReference1Impl(Attributes.class, "isNullCheckPredicate", "isNullCheckPredicate(Lkotlin/metadata/KmEffectExpression;)Z", 1)};
    private static final BooleanFlagDelegate declaresDefaultValue$delegate;
    private static final BooleanFlagDelegate hasAnnotations$delegate;
    private static final BooleanFlagDelegate hasAnnotations$delegate$1;
    private static final BooleanFlagDelegate hasAnnotations$delegate$2;
    private static final BooleanFlagDelegate hasAnnotations$delegate$3;
    private static final BooleanFlagDelegate hasAnnotations$delegate$4;
    private static final BooleanFlagDelegate hasAnnotations$delegate$5;
    private static final BooleanFlagDelegate hasAnnotations$delegate$6;
    private static final BooleanFlagDelegate hasConstant$delegate;
    private static final BooleanFlagDelegate hasEnumEntries$delegate;
    private static final BooleanFlagDelegate hasNonStableParameterNames$delegate;
    private static final BooleanFlagDelegate hasNonStableParameterNames$delegate$1;
    private static final BooleanFlagDelegate isConst$delegate;
    private static final BooleanFlagDelegate isCrossinline$delegate;
    private static final BooleanFlagDelegate isData$delegate;
    private static final BooleanFlagDelegate isDefinitelyNonNull$delegate;
    private static final BooleanFlagDelegate isDelegated$delegate;
    private static final BooleanFlagDelegate isExpect$delegate;
    private static final BooleanFlagDelegate isExpect$delegate$1;
    private static final BooleanFlagDelegate isExpect$delegate$2;
    private static final BooleanFlagDelegate isExternal$delegate;
    private static final BooleanFlagDelegate isExternal$delegate$1;
    private static final BooleanFlagDelegate isExternal$delegate$2;
    private static final BooleanFlagDelegate isExternal$delegate$3;
    private static final BooleanFlagDelegate isFunInterface$delegate;
    private static final BooleanFlagDelegate isInfix$delegate;
    private static final BooleanFlagDelegate isInline$delegate;
    private static final BooleanFlagDelegate isInline$delegate$1;
    private static final BooleanFlagDelegate isInner$delegate;
    private static final BooleanFlagDelegate isLateinit$delegate;
    private static final BooleanFlagDelegate isNegated$delegate;
    private static final BooleanFlagDelegate isNoinline$delegate;
    private static final BooleanFlagDelegate isNotDefault$delegate;
    private static final BooleanFlagDelegate isNullCheckPredicate$delegate;
    private static final BooleanFlagDelegate isNullable$delegate;
    private static final BooleanFlagDelegate isOperator$delegate;
    private static final BooleanFlagDelegate isReified$delegate;
    private static final BooleanFlagDelegate isSecondary$delegate;
    private static final BooleanFlagDelegate isSuspend$delegate;
    private static final BooleanFlagDelegate isSuspend$delegate$1;
    private static final BooleanFlagDelegate isTailrec$delegate;
    private static final BooleanFlagDelegate isValue$delegate;
    private static final BooleanFlagDelegate isVar$delegate;
    private static final EnumFlagDelegate kind$delegate;
    private static final EnumFlagDelegate kind$delegate$1;
    private static final EnumFlagDelegate kind$delegate$2;
    private static final EnumFlagDelegate modality$delegate;
    private static final EnumFlagDelegate modality$delegate$1;
    private static final EnumFlagDelegate modality$delegate$2;
    private static final EnumFlagDelegate modality$delegate$3;
    private static final EnumFlagDelegate returnValueStatus$delegate;
    private static final EnumFlagDelegate returnValueStatus$delegate$1;
    private static final EnumFlagDelegate returnValueStatus$delegate$2;
    private static final EnumFlagDelegate visibility$delegate;
    private static final EnumFlagDelegate visibility$delegate$1;
    private static final EnumFlagDelegate visibility$delegate$2;
    private static final EnumFlagDelegate visibility$delegate$3;
    private static final EnumFlagDelegate visibility$delegate$4;
    private static final EnumFlagDelegate visibility$delegate$5;

    static {
        Flags.BooleanFlagField booleanFlagField = Flags.HAS_ANNOTATIONS;
        booleanFlagField.getClass();
        hasAnnotations$delegate = FlagDelegatesImplKt.classBooleanFlag(new FlagImpl(booleanFlagField));
        hasAnnotations$delegate$1 = FlagDelegatesImplKt.constructorBooleanFlag(new FlagImpl(booleanFlagField));
        hasAnnotations$delegate$2 = FlagDelegatesImplKt.functionBooleanFlag(new FlagImpl(booleanFlagField));
        hasAnnotations$delegate$3 = FlagDelegatesImplKt.propertyBooleanFlag(new FlagImpl(booleanFlagField));
        hasAnnotations$delegate$4 = FlagDelegatesImplKt.propertyAccessorBooleanFlag(new FlagImpl(booleanFlagField));
        hasAnnotations$delegate$5 = FlagDelegatesImplKt.valueParameterBooleanFlag(new FlagImpl(booleanFlagField));
        hasAnnotations$delegate$6 = FlagDelegatesImplKt.typeAliasBooleanFlag(new FlagImpl(booleanFlagField));
        modality$delegate = FlagDelegatesImplKt.modalityDelegate(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$modality$2
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Integer.valueOf(((KmClass) obj).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((KmClass) obj).setFlags$kotlin_metadata(((Number) obj2).intValue());
            }
        });
        visibility$delegate = FlagDelegatesImplKt.visibilityDelegate(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$visibility$2
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Integer.valueOf(((KmClass) obj).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((KmClass) obj).setFlags$kotlin_metadata(((Number) obj2).intValue());
            }
        });
        Attributes$kind$2 attributes$kind$2 = new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$kind$2
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Integer.valueOf(((KmClass) obj).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((KmClass) obj).setFlags$kotlin_metadata(((Number) obj2).intValue());
            }
        };
        Flags.FlagField<ProtoBuf$Class.Kind> flagField = Flags.CLASS_KIND;
        flagField.getClass();
        EnumEntries<ClassKind> entries = ClassKind.getEntries();
        EnumEntries<ClassKind> entries2 = ClassKind.getEntries();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(entries2, 10));
        Iterator<ClassKind> it = entries2.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getFlag$kotlin_metadata());
        }
        kind$delegate = new EnumFlagDelegate(attributes$kind$2, flagField, entries, arrayList);
        Flags.BooleanFlagField booleanFlagField2 = Flags.IS_INNER;
        booleanFlagField2.getClass();
        isInner$delegate = FlagDelegatesImplKt.classBooleanFlag(new FlagImpl(booleanFlagField2));
        Flags.BooleanFlagField booleanFlagField3 = Flags.IS_DATA;
        booleanFlagField3.getClass();
        isData$delegate = FlagDelegatesImplKt.classBooleanFlag(new FlagImpl(booleanFlagField3));
        Flags.BooleanFlagField booleanFlagField4 = Flags.IS_EXTERNAL_CLASS;
        booleanFlagField4.getClass();
        isExternal$delegate = FlagDelegatesImplKt.classBooleanFlag(new FlagImpl(booleanFlagField4));
        Flags.BooleanFlagField booleanFlagField5 = Flags.IS_EXPECT_CLASS;
        booleanFlagField5.getClass();
        isExpect$delegate = FlagDelegatesImplKt.classBooleanFlag(new FlagImpl(booleanFlagField5));
        Flags.BooleanFlagField booleanFlagField6 = Flags.IS_VALUE_CLASS;
        booleanFlagField6.getClass();
        isValue$delegate = FlagDelegatesImplKt.classBooleanFlag(new FlagImpl(booleanFlagField6));
        Flags.BooleanFlagField booleanFlagField7 = Flags.IS_FUN_INTERFACE;
        booleanFlagField7.getClass();
        isFunInterface$delegate = FlagDelegatesImplKt.classBooleanFlag(new FlagImpl(booleanFlagField7));
        Flags.BooleanFlagField booleanFlagField8 = Flags.HAS_ENUM_ENTRIES;
        booleanFlagField8.getClass();
        hasEnumEntries$delegate = FlagDelegatesImplKt.classBooleanFlag(new FlagImpl(booleanFlagField8));
        visibility$delegate$1 = FlagDelegatesImplKt.visibilityDelegate(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$visibility$6
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Integer.valueOf(((KmConstructor) obj).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((KmConstructor) obj).setFlags$kotlin_metadata(((Number) obj2).intValue());
            }
        });
        Flags.BooleanFlagField booleanFlagField9 = Flags.IS_SECONDARY;
        booleanFlagField9.getClass();
        isSecondary$delegate = FlagDelegatesImplKt.constructorBooleanFlag(new FlagImpl(booleanFlagField9));
        Flags.BooleanFlagField booleanFlagField10 = Flags.IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES;
        booleanFlagField10.getClass();
        hasNonStableParameterNames$delegate = FlagDelegatesImplKt.constructorBooleanFlag(new FlagImpl(booleanFlagField10));
        Attributes$returnValueStatus$2 attributes$returnValueStatus$2 = new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$returnValueStatus$2
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Integer.valueOf(((KmConstructor) obj).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((KmConstructor) obj).setFlags$kotlin_metadata(((Number) obj2).intValue());
            }
        };
        Flags.FlagField<ProtoBuf$ReturnValueStatus> flagField2 = Flags.RETURN_VALUE_STATUS_CTOR;
        flagField2.getClass();
        returnValueStatus$delegate = FlagDelegatesImplKt.returnValueStatusDelegate(attributes$returnValueStatus$2, flagField2);
        kind$delegate$1 = FlagDelegatesImplKt.memberKindDelegate(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$kind$7
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Integer.valueOf(((KmFunction) obj).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((KmFunction) obj).setFlags$kotlin_metadata(((Number) obj2).intValue());
            }
        });
        visibility$delegate$2 = FlagDelegatesImplKt.visibilityDelegate(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$visibility$10
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Integer.valueOf(((KmFunction) obj).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((KmFunction) obj).setFlags$kotlin_metadata(((Number) obj2).intValue());
            }
        });
        modality$delegate$1 = FlagDelegatesImplKt.modalityDelegate(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$modality$6
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Integer.valueOf(((KmFunction) obj).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((KmFunction) obj).setFlags$kotlin_metadata(((Number) obj2).intValue());
            }
        });
        Flags.BooleanFlagField booleanFlagField11 = Flags.IS_OPERATOR;
        booleanFlagField11.getClass();
        isOperator$delegate = FlagDelegatesImplKt.functionBooleanFlag(new FlagImpl(booleanFlagField11));
        Flags.BooleanFlagField booleanFlagField12 = Flags.IS_INFIX;
        booleanFlagField12.getClass();
        isInfix$delegate = FlagDelegatesImplKt.functionBooleanFlag(new FlagImpl(booleanFlagField12));
        Flags.BooleanFlagField booleanFlagField13 = Flags.IS_INLINE;
        booleanFlagField13.getClass();
        isInline$delegate = FlagDelegatesImplKt.functionBooleanFlag(new FlagImpl(booleanFlagField13));
        Flags.BooleanFlagField booleanFlagField14 = Flags.IS_TAILREC;
        booleanFlagField14.getClass();
        isTailrec$delegate = FlagDelegatesImplKt.functionBooleanFlag(new FlagImpl(booleanFlagField14));
        Flags.BooleanFlagField booleanFlagField15 = Flags.IS_EXTERNAL_FUNCTION;
        booleanFlagField15.getClass();
        isExternal$delegate$1 = FlagDelegatesImplKt.functionBooleanFlag(new FlagImpl(booleanFlagField15));
        Flags.BooleanFlagField booleanFlagField16 = Flags.IS_SUSPEND;
        booleanFlagField16.getClass();
        isSuspend$delegate = FlagDelegatesImplKt.functionBooleanFlag(new FlagImpl(booleanFlagField16));
        Flags.BooleanFlagField booleanFlagField17 = Flags.IS_EXPECT_FUNCTION;
        booleanFlagField17.getClass();
        isExpect$delegate$1 = FlagDelegatesImplKt.functionBooleanFlag(new FlagImpl(booleanFlagField17));
        Flags.BooleanFlagField booleanFlagField18 = Flags.IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES;
        booleanFlagField18.getClass();
        hasNonStableParameterNames$delegate$1 = FlagDelegatesImplKt.functionBooleanFlag(new FlagImpl(booleanFlagField18));
        Attributes$returnValueStatus$6 attributes$returnValueStatus$6 = new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$returnValueStatus$6
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Integer.valueOf(((KmFunction) obj).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((KmFunction) obj).setFlags$kotlin_metadata(((Number) obj2).intValue());
            }
        };
        Flags.FlagField<ProtoBuf$ReturnValueStatus> flagField3 = Flags.RETURN_VALUE_STATUS_FUNCTION;
        flagField3.getClass();
        returnValueStatus$delegate$1 = FlagDelegatesImplKt.returnValueStatusDelegate(attributes$returnValueStatus$6, flagField3);
        visibility$delegate$3 = FlagDelegatesImplKt.visibilityDelegate(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$visibility$14
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Integer.valueOf(((KmProperty) obj).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((KmProperty) obj).setFlags$kotlin_metadata(((Number) obj2).intValue());
            }
        });
        modality$delegate$2 = FlagDelegatesImplKt.modalityDelegate(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$modality$10
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Integer.valueOf(((KmProperty) obj).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((KmProperty) obj).setFlags$kotlin_metadata(((Number) obj2).intValue());
            }
        });
        kind$delegate$2 = FlagDelegatesImplKt.memberKindDelegate(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$kind$11
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Integer.valueOf(((KmProperty) obj).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((KmProperty) obj).setFlags$kotlin_metadata(((Number) obj2).intValue());
            }
        });
        Flags.BooleanFlagField booleanFlagField19 = Flags.IS_VAR;
        booleanFlagField19.getClass();
        isVar$delegate = FlagDelegatesImplKt.propertyBooleanFlag(new FlagImpl(booleanFlagField19));
        Flags.BooleanFlagField booleanFlagField20 = Flags.IS_CONST;
        booleanFlagField20.getClass();
        isConst$delegate = FlagDelegatesImplKt.propertyBooleanFlag(new FlagImpl(booleanFlagField20));
        Flags.BooleanFlagField booleanFlagField21 = Flags.IS_LATEINIT;
        booleanFlagField21.getClass();
        isLateinit$delegate = FlagDelegatesImplKt.propertyBooleanFlag(new FlagImpl(booleanFlagField21));
        Flags.BooleanFlagField booleanFlagField22 = Flags.HAS_CONSTANT;
        booleanFlagField22.getClass();
        hasConstant$delegate = FlagDelegatesImplKt.propertyBooleanFlag(new FlagImpl(booleanFlagField22));
        Flags.BooleanFlagField booleanFlagField23 = Flags.IS_EXTERNAL_PROPERTY;
        booleanFlagField23.getClass();
        isExternal$delegate$2 = FlagDelegatesImplKt.propertyBooleanFlag(new FlagImpl(booleanFlagField23));
        Flags.BooleanFlagField booleanFlagField24 = Flags.IS_DELEGATED;
        booleanFlagField24.getClass();
        isDelegated$delegate = FlagDelegatesImplKt.propertyBooleanFlag(new FlagImpl(booleanFlagField24));
        Flags.BooleanFlagField booleanFlagField25 = Flags.IS_EXPECT_PROPERTY;
        booleanFlagField25.getClass();
        isExpect$delegate$2 = FlagDelegatesImplKt.propertyBooleanFlag(new FlagImpl(booleanFlagField25));
        Attributes$returnValueStatus$10 attributes$returnValueStatus$10 = new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$returnValueStatus$10
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Integer.valueOf(((KmProperty) obj).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((KmProperty) obj).setFlags$kotlin_metadata(((Number) obj2).intValue());
            }
        };
        Flags.FlagField<ProtoBuf$ReturnValueStatus> flagField4 = Flags.RETURN_VALUE_STATUS_PROPERTY;
        flagField4.getClass();
        returnValueStatus$delegate$2 = FlagDelegatesImplKt.returnValueStatusDelegate(attributes$returnValueStatus$10, flagField4);
        visibility$delegate$4 = FlagDelegatesImplKt.visibilityDelegate(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$visibility$18
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Integer.valueOf(((KmPropertyAccessorAttributes) obj).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((KmPropertyAccessorAttributes) obj).setFlags$kotlin_metadata(((Number) obj2).intValue());
            }
        });
        modality$delegate$3 = FlagDelegatesImplKt.modalityDelegate(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$modality$14
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Integer.valueOf(((KmPropertyAccessorAttributes) obj).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((KmPropertyAccessorAttributes) obj).setFlags$kotlin_metadata(((Number) obj2).intValue());
            }
        });
        Flags.BooleanFlagField booleanFlagField26 = Flags.IS_NOT_DEFAULT;
        booleanFlagField26.getClass();
        isNotDefault$delegate = FlagDelegatesImplKt.propertyAccessorBooleanFlag(new FlagImpl(booleanFlagField26));
        Flags.BooleanFlagField booleanFlagField27 = Flags.IS_EXTERNAL_ACCESSOR;
        booleanFlagField27.getClass();
        isExternal$delegate$3 = FlagDelegatesImplKt.propertyAccessorBooleanFlag(new FlagImpl(booleanFlagField27));
        Flags.BooleanFlagField booleanFlagField28 = Flags.IS_INLINE_ACCESSOR;
        booleanFlagField28.getClass();
        isInline$delegate$1 = FlagDelegatesImplKt.propertyAccessorBooleanFlag(new FlagImpl(booleanFlagField28));
        isNullable$delegate = FlagDelegatesImplKt.typeBooleanFlag(new FlagImpl(0, 1, 1));
        Flags.BooleanFlagField booleanFlagField29 = Flags.SUSPEND_TYPE;
        isSuspend$delegate$1 = FlagDelegatesImplKt.typeBooleanFlag(new FlagImpl(booleanFlagField29.offset + 1, booleanFlagField29.bitWidth, 1));
        Flags.BooleanFlagField booleanFlagField30 = Flags.DEFINITELY_NOT_NULL_TYPE;
        isDefinitelyNonNull$delegate = FlagDelegatesImplKt.typeBooleanFlag(new FlagImpl(booleanFlagField30.offset + 1, booleanFlagField30.bitWidth, 1));
        isReified$delegate = new BooleanFlagDelegate(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes.isReified.2
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Integer.valueOf(((KmTypeParameter) obj).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((KmTypeParameter) obj).setFlags$kotlin_metadata(((Number) obj2).intValue());
            }
        }, new FlagImpl(0, 1, 1));
        visibility$delegate$5 = FlagDelegatesImplKt.visibilityDelegate(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$visibility$22
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Integer.valueOf(((KmTypeAlias) obj).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((KmTypeAlias) obj).setFlags$kotlin_metadata(((Number) obj2).intValue());
            }
        });
        Flags.BooleanFlagField booleanFlagField31 = Flags.DECLARES_DEFAULT_VALUE;
        booleanFlagField31.getClass();
        declaresDefaultValue$delegate = FlagDelegatesImplKt.valueParameterBooleanFlag(new FlagImpl(booleanFlagField31));
        Flags.BooleanFlagField booleanFlagField32 = Flags.IS_CROSSINLINE;
        booleanFlagField32.getClass();
        isCrossinline$delegate = FlagDelegatesImplKt.valueParameterBooleanFlag(new FlagImpl(booleanFlagField32));
        Flags.BooleanFlagField booleanFlagField33 = Flags.IS_NOINLINE;
        booleanFlagField33.getClass();
        isNoinline$delegate = FlagDelegatesImplKt.valueParameterBooleanFlag(new FlagImpl(booleanFlagField33));
        Attributes$isNegated$2 attributes$isNegated$2 = new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$isNegated$2
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Integer.valueOf(((KmEffectExpression) obj).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((KmEffectExpression) obj).setFlags$kotlin_metadata(((Number) obj2).intValue());
            }
        };
        Flags.BooleanFlagField booleanFlagField34 = Flags.IS_NEGATED;
        booleanFlagField34.getClass();
        isNegated$delegate = new BooleanFlagDelegate(attributes$isNegated$2, new FlagImpl(booleanFlagField34));
        Attributes$isNullCheckPredicate$2 attributes$isNullCheckPredicate$2 = new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.Attributes$isNullCheckPredicate$2
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Integer.valueOf(((KmEffectExpression) obj).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((KmEffectExpression) obj).setFlags$kotlin_metadata(((Number) obj2).intValue());
            }
        };
        Flags.BooleanFlagField booleanFlagField35 = Flags.IS_NULL_CHECK_PREDICATE;
        booleanFlagField35.getClass();
        isNullCheckPredicate$delegate = new BooleanFlagDelegate(attributes$isNullCheckPredicate$2, new FlagImpl(booleanFlagField35));
    }

    public static final boolean getDeclaresDefaultValue(KmValueParameter kmValueParameter) {
        kmValueParameter.getClass();
        return declaresDefaultValue$delegate.getValue(kmValueParameter, $$delegatedProperties[54]);
    }

    public static final ClassKind getKind(KmClass kmClass) {
        kmClass.getClass();
        return (ClassKind) kind$delegate.getValue(kmClass, $$delegatedProperties[9]);
    }

    public static final Modality getModality(KmClass kmClass) {
        kmClass.getClass();
        return (Modality) modality$delegate.getValue(kmClass, $$delegatedProperties[7]);
    }

    public static final Visibility getVisibility(KmConstructor kmConstructor) {
        kmConstructor.getClass();
        return (Visibility) visibility$delegate$1.getValue(kmConstructor, $$delegatedProperties[17]);
    }

    public static final boolean isDefinitelyNonNull(KmType kmType) {
        kmType.getClass();
        return isDefinitelyNonNull$delegate.getValue(kmType, $$delegatedProperties[51]);
    }

    public static final boolean isDelegated(KmProperty kmProperty) {
        kmProperty.getClass();
        return isDelegated$delegate.getValue(kmProperty, $$delegatedProperties[41]);
    }

    public static final boolean isExternal(KmFunction kmFunction) {
        kmFunction.getClass();
        return isExternal$delegate$1.getValue(kmFunction, $$delegatedProperties[28]);
    }

    public static final boolean isInfix(KmFunction kmFunction) {
        kmFunction.getClass();
        return isInfix$delegate.getValue(kmFunction, $$delegatedProperties[25]);
    }

    public static final boolean isInline(KmFunction kmFunction) {
        kmFunction.getClass();
        return isInline$delegate.getValue(kmFunction, $$delegatedProperties[26]);
    }

    public static final boolean isInner(KmClass kmClass) {
        kmClass.getClass();
        return isInner$delegate.getValue(kmClass, $$delegatedProperties[10]);
    }

    public static final boolean isNullable(KmType kmType) {
        kmType.getClass();
        return isNullable$delegate.getValue(kmType, $$delegatedProperties[49]);
    }

    public static final boolean isOperator(KmFunction kmFunction) {
        kmFunction.getClass();
        return isOperator$delegate.getValue(kmFunction, $$delegatedProperties[24]);
    }

    public static final boolean isReified(KmTypeParameter kmTypeParameter) {
        kmTypeParameter.getClass();
        return isReified$delegate.getValue(kmTypeParameter, $$delegatedProperties[52]);
    }

    public static final boolean isSuspend(KmFunction kmFunction) {
        kmFunction.getClass();
        return isSuspend$delegate.getValue(kmFunction, $$delegatedProperties[29]);
    }

    public static final boolean isValue(KmClass kmClass) {
        kmClass.getClass();
        return isValue$delegate.getValue(kmClass, $$delegatedProperties[14]);
    }

    public static final boolean isVar(KmProperty kmProperty) {
        kmProperty.getClass();
        return isVar$delegate.getValue(kmProperty, $$delegatedProperties[36]);
    }

    public static final void setKind(KmClass kmClass, ClassKind classKind) {
        kmClass.getClass();
        classKind.getClass();
        kind$delegate.setValue(kmClass, $$delegatedProperties[9], classKind);
    }

    public static final void setModality(KmClass kmClass, Modality modality) {
        kmClass.getClass();
        modality.getClass();
        modality$delegate.setValue(kmClass, $$delegatedProperties[7], modality);
    }

    public static final void setVisibility(KmClass kmClass, Visibility visibility) {
        kmClass.getClass();
        visibility.getClass();
        visibility$delegate.setValue(kmClass, $$delegatedProperties[8], visibility);
    }

    public static final boolean isExternal(KmPropertyAccessorAttributes kmPropertyAccessorAttributes) {
        kmPropertyAccessorAttributes.getClass();
        return isExternal$delegate$3.getValue(kmPropertyAccessorAttributes, $$delegatedProperties[47]);
    }

    public static final boolean isInline(KmPropertyAccessorAttributes kmPropertyAccessorAttributes) {
        kmPropertyAccessorAttributes.getClass();
        return isInline$delegate$1.getValue(kmPropertyAccessorAttributes, $$delegatedProperties[48]);
    }

    public static final boolean isSuspend(KmType kmType) {
        kmType.getClass();
        return isSuspend$delegate$1.getValue(kmType, $$delegatedProperties[50]);
    }

    public static final Visibility getVisibility(KmProperty kmProperty) {
        kmProperty.getClass();
        return (Visibility) visibility$delegate$3.getValue(kmProperty, $$delegatedProperties[33]);
    }
}
