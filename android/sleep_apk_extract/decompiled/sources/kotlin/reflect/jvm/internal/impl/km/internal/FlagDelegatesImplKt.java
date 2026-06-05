package kotlin.reflect.jvm.internal.impl.km.internal;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.jvm.internal.impl.km.KmClass;
import kotlin.reflect.jvm.internal.impl.km.KmConstructor;
import kotlin.reflect.jvm.internal.impl.km.KmFunction;
import kotlin.reflect.jvm.internal.impl.km.KmProperty;
import kotlin.reflect.jvm.internal.impl.km.KmPropertyAccessorAttributes;
import kotlin.reflect.jvm.internal.impl.km.KmType;
import kotlin.reflect.jvm.internal.impl.km.KmTypeAlias;
import kotlin.reflect.jvm.internal.impl.km.KmValueParameter;
import kotlin.reflect.jvm.internal.impl.km.MemberKind;
import kotlin.reflect.jvm.internal.impl.km.Modality;
import kotlin.reflect.jvm.internal.impl.km.ReturnValueStatus;
import kotlin.reflect.jvm.internal.impl.km.Visibility;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$MemberKind;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Modality;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Visibility;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal;

/* JADX INFO: loaded from: classes5.dex */
public abstract class FlagDelegatesImplKt {
    public static final BooleanFlagDelegate<KmClass> classBooleanFlag(FlagImpl flagImpl) {
        flagImpl.getClass();
        return new BooleanFlagDelegate<>(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.classBooleanFlag.1
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Integer.valueOf(((KmClass) obj).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((KmClass) obj).setFlags$kotlin_metadata(((Number) obj2).intValue());
            }
        }, flagImpl);
    }

    public static final BooleanFlagDelegate<KmConstructor> constructorBooleanFlag(FlagImpl flagImpl) {
        flagImpl.getClass();
        return new BooleanFlagDelegate<>(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.constructorBooleanFlag.1
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Integer.valueOf(((KmConstructor) obj).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((KmConstructor) obj).setFlags$kotlin_metadata(((Number) obj2).intValue());
            }
        }, flagImpl);
    }

    public static final BooleanFlagDelegate<KmFunction> functionBooleanFlag(FlagImpl flagImpl) {
        flagImpl.getClass();
        return new BooleanFlagDelegate<>(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.functionBooleanFlag.1
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Integer.valueOf(((KmFunction) obj).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((KmFunction) obj).setFlags$kotlin_metadata(((Number) obj2).intValue());
            }
        }, flagImpl);
    }

    public static final <Node> EnumFlagDelegate<Node, MemberKind> memberKindDelegate(KMutableProperty1<Node, Integer> kMutableProperty1) {
        kMutableProperty1.getClass();
        Flags.FlagField<ProtoBuf$MemberKind> flagField = Flags.MEMBER_KIND;
        flagField.getClass();
        EnumEntries<MemberKind> entries = MemberKind.getEntries();
        EnumEntries<MemberKind> entries2 = MemberKind.getEntries();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(entries2, 10));
        Iterator<MemberKind> it = entries2.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getFlag$kotlin_metadata());
        }
        return new EnumFlagDelegate<>(kMutableProperty1, flagField, entries, arrayList);
    }

    public static final <Node> EnumFlagDelegate<Node, Modality> modalityDelegate(KMutableProperty1<Node, Integer> kMutableProperty1) {
        kMutableProperty1.getClass();
        Flags.FlagField<ProtoBuf$Modality> flagField = Flags.MODALITY;
        flagField.getClass();
        EnumEntries<Modality> entries = Modality.getEntries();
        EnumEntries<Modality> entries2 = Modality.getEntries();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(entries2, 10));
        Iterator<Modality> it = entries2.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getFlag$kotlin_metadata());
        }
        return new EnumFlagDelegate<>(kMutableProperty1, flagField, entries, arrayList);
    }

    public static final BooleanFlagDelegate<KmPropertyAccessorAttributes> propertyAccessorBooleanFlag(FlagImpl flagImpl) {
        flagImpl.getClass();
        return new BooleanFlagDelegate<>(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.propertyAccessorBooleanFlag.1
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Integer.valueOf(((KmPropertyAccessorAttributes) obj).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((KmPropertyAccessorAttributes) obj).setFlags$kotlin_metadata(((Number) obj2).intValue());
            }
        }, flagImpl);
    }

    public static final BooleanFlagDelegate<KmProperty> propertyBooleanFlag(FlagImpl flagImpl) {
        flagImpl.getClass();
        return new BooleanFlagDelegate<>(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.propertyBooleanFlag.1
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Integer.valueOf(((KmProperty) obj).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((KmProperty) obj).setFlags$kotlin_metadata(((Number) obj2).intValue());
            }
        }, flagImpl);
    }

    public static final <Node> EnumFlagDelegate<Node, ReturnValueStatus> returnValueStatusDelegate(KMutableProperty1<Node, Integer> kMutableProperty1, Flags.FlagField<? extends Internal.EnumLite> flagField) {
        kMutableProperty1.getClass();
        flagField.getClass();
        EnumEntries<ReturnValueStatus> entries = ReturnValueStatus.getEntries();
        EnumEntries<ReturnValueStatus> entries2 = ReturnValueStatus.getEntries();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(entries2, 10));
        Iterator<ReturnValueStatus> it = entries2.iterator();
        while (it.hasNext()) {
            arrayList.add(new FlagImpl(flagField, it.next().ordinal()));
        }
        return new EnumFlagDelegate<>(kMutableProperty1, flagField, entries, arrayList);
    }

    public static final BooleanFlagDelegate<KmTypeAlias> typeAliasBooleanFlag(FlagImpl flagImpl) {
        flagImpl.getClass();
        return new BooleanFlagDelegate<>(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.typeAliasBooleanFlag.1
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Integer.valueOf(((KmTypeAlias) obj).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((KmTypeAlias) obj).setFlags$kotlin_metadata(((Number) obj2).intValue());
            }
        }, flagImpl);
    }

    public static final BooleanFlagDelegate<KmType> typeBooleanFlag(FlagImpl flagImpl) {
        flagImpl.getClass();
        return new BooleanFlagDelegate<>(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.typeBooleanFlag.1
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Integer.valueOf(((KmType) obj).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((KmType) obj).setFlags$kotlin_metadata(((Number) obj2).intValue());
            }
        }, flagImpl);
    }

    public static final BooleanFlagDelegate<KmValueParameter> valueParameterBooleanFlag(FlagImpl flagImpl) {
        flagImpl.getClass();
        return new BooleanFlagDelegate<>(new MutablePropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt.valueParameterBooleanFlag.1
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Integer.valueOf(((KmValueParameter) obj).getFlags$kotlin_metadata());
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((KmValueParameter) obj).setFlags$kotlin_metadata(((Number) obj2).intValue());
            }
        }, flagImpl);
    }

    public static final <Node> EnumFlagDelegate<Node, Visibility> visibilityDelegate(KMutableProperty1<Node, Integer> kMutableProperty1) {
        kMutableProperty1.getClass();
        Flags.FlagField<ProtoBuf$Visibility> flagField = Flags.VISIBILITY;
        flagField.getClass();
        EnumEntries<Visibility> entries = Visibility.getEntries();
        EnumEntries<Visibility> entries2 = Visibility.getEntries();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(entries2, 10));
        Iterator<Visibility> it = entries2.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getFlag$kotlin_metadata());
        }
        return new EnumFlagDelegate<>(kMutableProperty1, flagField, entries, arrayList);
    }
}
