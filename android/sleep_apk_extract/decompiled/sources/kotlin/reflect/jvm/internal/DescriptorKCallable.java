package kotlin.reflect.jvm.internal;

import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KParameter;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.JavaDescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedSimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.types.DescriptorKType;
import kotlin.reflect.jvm.internal.types.KTypeSubstitutor;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H$¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0004\u001a\u00020\u0003H ¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u000f*\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R.\u0010\u001d\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u001b \u001c*\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u000f0\u000f0\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR.\u0010\u001f\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0010 \u001c*\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f0\u000f0\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u001eR.\u0010 \u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0010 \u001c*\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f0\u000f0\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u001eR\"\u0010\"\u001a\u0010\u0012\f\u0012\n \u001c*\u0004\u0018\u00010!0!0\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u001eR.\u0010$\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020# \u001c*\n\u0012\u0004\u0012\u00020#\u0018\u00010\u000f0\u000f0\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010\u001eR\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010&R\u0014\u0010,\u001a\u00020!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020-0\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010&R\u0016\u00103\u001a\u0004\u0018\u0001008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u0014\u00106\u001a\u00020\r8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\u0014\u00109\u001a\u00020\u00138&X¦\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u0014\u0010=\u001a\u00020:8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<¨\u0006>"}, d2 = {"Lkotlin/reflect/jvm/internal/DescriptorKCallable;", "R", "Lkotlin/reflect/jvm/internal/ReflectKCallableImpl;", "Lkotlin/reflect/jvm/internal/KCallableOverriddenStorage;", "overriddenStorage", "<init>", "(Lkotlin/reflect/jvm/internal/KCallableOverriddenStorage;)V", "Lkotlin/reflect/jvm/internal/types/DescriptorKType;", "computeReturnType", "()Lkotlin/reflect/jvm/internal/types/DescriptorKType;", "shallowCopy$kotlin_reflection", "(Lkotlin/reflect/jvm/internal/KCallableOverriddenStorage;)Lkotlin/reflect/jvm/internal/DescriptorKCallable;", "shallowCopy", "", "includeReceivers", "", "Lkotlin/reflect/KParameter;", "computeParameters", "(Z)Ljava/util/List;", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "Lkotlin/reflect/jvm/internal/impl/descriptors/ValueParameterDescriptor;", "computeContextParameters", "(Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;)Ljava/util/List;", "Lkotlin/reflect/jvm/internal/KCallableOverriddenStorage;", "getOverriddenStorage$kotlin_reflection", "()Lkotlin/reflect/jvm/internal/KCallableOverriddenStorage;", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "", "kotlin.jvm.PlatformType", "_annotations", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "_allParameters", "_parameters", "Lkotlin/reflect/KType;", "_returnType", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "_typeParameters", "getAllParameters", "()Ljava/util/List;", "allParameters", "getParameters", IntrospectionHelper.AppFunctionInvokerClass.UnsafeInvokeMethod.PARAMETERS_PARAM_NAME, "getReturnType", "()Lkotlin/reflect/KType;", "returnType", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "typeParameters", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY, "isPackagePrivate$kotlin_reflection", "()Z", "isPackagePrivate", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/Modality;", "getModality$kotlin_reflection", "()Lorg/jetbrains/kotlin/descriptors/Modality;", "modality", "kotlin-reflection"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class DescriptorKCallable<R> extends ReflectKCallableImpl<R> {
    private final ReflectProperties.LazySoftVal<List<KParameter>> _allParameters;
    private final ReflectProperties.LazySoftVal<List<Annotation>> _annotations;
    private final ReflectProperties.LazySoftVal<List<KParameter>> _parameters;
    private final ReflectProperties.LazySoftVal<KType> _returnType;
    private final ReflectProperties.LazySoftVal<List<KTypeParameterImpl>> _typeParameters;
    private final KCallableOverriddenStorage overriddenStorage;

    public DescriptorKCallable(KCallableOverriddenStorage kCallableOverriddenStorage) {
        kCallableOverriddenStorage.getClass();
        this.overriddenStorage = kCallableOverriddenStorage;
        ReflectProperties.LazySoftVal<List<Annotation>> lazySoftValLazySoft = ReflectProperties.lazySoft(new Function0(this) { // from class: kotlin.reflect.jvm.internal.DescriptorKCallable$$Lambda$0
            private final DescriptorKCallable arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return DescriptorKCallable._annotations$lambda$0(this.arg$0);
            }
        });
        lazySoftValLazySoft.getClass();
        this._annotations = lazySoftValLazySoft;
        ReflectProperties.LazySoftVal<List<KParameter>> lazySoftValLazySoft2 = ReflectProperties.lazySoft(new Function0(this) { // from class: kotlin.reflect.jvm.internal.DescriptorKCallable$$Lambda$1
            private final DescriptorKCallable arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return DescriptorKCallable._allParameters$lambda$0(this.arg$0);
            }
        });
        lazySoftValLazySoft2.getClass();
        this._allParameters = lazySoftValLazySoft2;
        ReflectProperties.LazySoftVal<List<KParameter>> lazySoftValLazySoft3 = ReflectProperties.lazySoft(new Function0(this) { // from class: kotlin.reflect.jvm.internal.DescriptorKCallable$$Lambda$2
            private final DescriptorKCallable arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return DescriptorKCallable._parameters$lambda$0(this.arg$0);
            }
        });
        lazySoftValLazySoft3.getClass();
        this._parameters = lazySoftValLazySoft3;
        ReflectProperties.LazySoftVal<KType> lazySoftValLazySoft4 = ReflectProperties.lazySoft(new Function0(this) { // from class: kotlin.reflect.jvm.internal.DescriptorKCallable$$Lambda$3
            private final DescriptorKCallable arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return DescriptorKCallable._returnType$lambda$0(this.arg$0);
            }
        });
        lazySoftValLazySoft4.getClass();
        this._returnType = lazySoftValLazySoft4;
        ReflectProperties.LazySoftVal<List<KTypeParameterImpl>> lazySoftValLazySoft5 = ReflectProperties.lazySoft(new Function0(this) { // from class: kotlin.reflect.jvm.internal.DescriptorKCallable$$Lambda$4
            private final DescriptorKCallable arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return DescriptorKCallable._typeParameters$lambda$0(this.arg$0);
            }
        });
        lazySoftValLazySoft5.getClass();
        this._typeParameters = lazySoftValLazySoft5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List _allParameters$lambda$0(DescriptorKCallable descriptorKCallable) {
        return descriptorKCallable.computeParameters(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List _annotations$lambda$0(DescriptorKCallable descriptorKCallable) {
        return UtilKt.computeAnnotations(descriptorKCallable.getDescriptor());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List _parameters$lambda$0(DescriptorKCallable descriptorKCallable) {
        return ReflectKCallableKt.isBound(descriptorKCallable) ? descriptorKCallable.computeParameters(false) : descriptorKCallable.getAllParameters();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KType _returnType$lambda$0(DescriptorKCallable descriptorKCallable) {
        KType type = KTypeSubstitutor.substitute$default(descriptorKCallable.overriddenStorage.getTypeSubstitutor(), descriptorKCallable.computeReturnType(), null, 2, null).getType();
        if (type != null) {
            return type;
        }
        FakeOverridesKt.starProjectionInTopLevelTypeIsNotPossible(descriptorKCallable.getName());
        Utf8$$ExternalSyntheticBUOutline0.m();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List _typeParameters$lambda$0(DescriptorKCallable descriptorKCallable) {
        List<TypeParameterDescriptor> typeParameters = descriptorKCallable.getDescriptor().getTypeParameters();
        typeParameters.getClass();
        List<TypeParameterDescriptor> list = typeParameters;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (TypeParameterDescriptor typeParameterDescriptor : list) {
            typeParameterDescriptor.getClass();
            arrayList.add(new KTypeParameterImpl(descriptorKCallable, typeParameterDescriptor, descriptorKCallable.overriddenStorage.getTypeSubstitutor()));
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<ValueParameterDescriptor> computeContextParameters(CallableMemberDescriptor callableMemberDescriptor) {
        Pair pair;
        CallableMemberDescriptor callableMemberDescriptor2 = callableMemberDescriptor;
        if (callableMemberDescriptor2 instanceof DeserializedSimpleFunctionDescriptor) {
            DeserializedSimpleFunctionDescriptor deserializedSimpleFunctionDescriptor = (DeserializedSimpleFunctionDescriptor) callableMemberDescriptor2;
            pair = TuplesKt.to(deserializedSimpleFunctionDescriptor.getNameResolver(), deserializedSimpleFunctionDescriptor.getProto().getContextParameterList());
        } else if (callableMemberDescriptor2 instanceof DeserializedPropertyDescriptor) {
            DeserializedPropertyDescriptor deserializedPropertyDescriptor = (DeserializedPropertyDescriptor) callableMemberDescriptor2;
            pair = TuplesKt.to(deserializedPropertyDescriptor.getNameResolver(), deserializedPropertyDescriptor.getProto().getContextParameterList());
        } else if (callableMemberDescriptor2 instanceof PropertyAccessorDescriptor) {
            PropertyDescriptor correspondingProperty = ((PropertyAccessorDescriptor) callableMemberDescriptor2).getCorrespondingProperty();
            DeserializedPropertyDescriptor deserializedPropertyDescriptor2 = correspondingProperty instanceof DeserializedPropertyDescriptor ? (DeserializedPropertyDescriptor) correspondingProperty : null;
            pair = deserializedPropertyDescriptor2 != null ? TuplesKt.to(deserializedPropertyDescriptor2.getNameResolver(), deserializedPropertyDescriptor2.getProto().getContextParameterList()) : null;
        }
        if (pair == null) {
            return CollectionsKt.emptyList();
        }
        NameResolver nameResolver = (NameResolver) pair.component1();
        List list = (List) pair.component2();
        List<ReceiverParameterDescriptor> contextReceiverParameters = callableMemberDescriptor2.getContextReceiverParameters();
        contextReceiverParameters.getClass();
        List<ReceiverParameterDescriptor> list2 = contextReceiverParameters;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        int i = 0;
        for (Object obj : list2) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ReceiverParameterDescriptor receiverParameterDescriptor = (ReceiverParameterDescriptor) obj;
            Annotations annotations = receiverParameterDescriptor.getAnnotations();
            Name nameGuessByFirstCharacter = Name.guessByFirstCharacter(nameResolver.getString(((ProtoBuf$ValueParameter) list.get(i)).getName()));
            nameGuessByFirstCharacter.getClass();
            KotlinType type = receiverParameterDescriptor.getType();
            type.getClass();
            SourceElement source = receiverParameterDescriptor.getSource();
            source.getClass();
            arrayList.add(new ValueParameterDescriptorImpl(callableMemberDescriptor2, null, i, annotations, nameGuessByFirstCharacter, type, false, false, false, null, source));
            callableMemberDescriptor2 = callableMemberDescriptor;
            i = i2;
        }
        return arrayList;
    }

    private final List<KParameter> computeParameters(boolean includeReceivers) {
        final CallableMemberDescriptor descriptor = getDescriptor();
        ArrayList arrayList = new ArrayList();
        if (includeReceivers) {
            final ReceiverParameterDescriptor instanceReceiverParameter = UtilKt.getInstanceReceiverParameter(this);
            if (instanceReceiverParameter != null) {
                arrayList.add(new DescriptorKParameter(this, arrayList.size(), KParameter.Kind.INSTANCE, new Function0(instanceReceiverParameter) { // from class: kotlin.reflect.jvm.internal.DescriptorKCallable$$Lambda$5
                    private final ReceiverParameterDescriptor arg$0;

                    {
                        this.arg$0 = instanceReceiverParameter;
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public Object invoke() {
                        return DescriptorKCallable.computeParameters$lambda$0(this.arg$0);
                    }
                }));
            }
            final List<ValueParameterDescriptor> listComputeContextParameters = computeContextParameters(descriptor);
            int size = listComputeContextParameters.size();
            for (final int i = 0; i < size; i++) {
                arrayList.add(new DescriptorKParameter(this, arrayList.size(), KParameter.Kind.CONTEXT, new Function0(listComputeContextParameters, i) { // from class: kotlin.reflect.jvm.internal.DescriptorKCallable$$Lambda$6
                    private final List arg$0;
                    private final int arg$1;

                    {
                        this.arg$0 = listComputeContextParameters;
                        this.arg$1 = i;
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public Object invoke() {
                        return DescriptorKCallable.computeParameters$lambda$1(this.arg$0, this.arg$1);
                    }
                }));
            }
            final ReceiverParameterDescriptor extensionReceiverParameter = descriptor.getExtensionReceiverParameter();
            if (extensionReceiverParameter != null) {
                arrayList.add(new DescriptorKParameter(this, arrayList.size(), KParameter.Kind.EXTENSION_RECEIVER, new Function0(extensionReceiverParameter) { // from class: kotlin.reflect.jvm.internal.DescriptorKCallable$$Lambda$7
                    private final ReceiverParameterDescriptor arg$0;

                    {
                        this.arg$0 = extensionReceiverParameter;
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public Object invoke() {
                        return DescriptorKCallable.computeParameters$lambda$2(this.arg$0);
                    }
                }));
            }
        }
        int size2 = descriptor.getValueParameters().size();
        for (final int i2 = 0; i2 < size2; i2++) {
            arrayList.add(new DescriptorKParameter(this, arrayList.size(), KParameter.Kind.VALUE, new Function0(descriptor, i2) { // from class: kotlin.reflect.jvm.internal.DescriptorKCallable$$Lambda$8
                private final CallableMemberDescriptor arg$0;
                private final int arg$1;

                {
                    this.arg$0 = descriptor;
                    this.arg$1 = i2;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    return DescriptorKCallable.computeParameters$lambda$3(this.arg$0, this.arg$1);
                }
            }));
        }
        if (ReflectKCallableKt.isAnnotationConstructor(this) && (descriptor instanceof JavaCallableMemberDescriptor) && arrayList.size() > 1) {
            CollectionsKt.sortWith(arrayList, new Comparator() { // from class: kotlin.reflect.jvm.internal.DescriptorKCallable$computeParameters$$inlined$sortBy$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(((KParameter) t).getName(), ((KParameter) t2).getName());
                }
            });
        }
        arrayList.trimToSize();
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParameterDescriptor computeParameters$lambda$0(ReceiverParameterDescriptor receiverParameterDescriptor) {
        return receiverParameterDescriptor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParameterDescriptor computeParameters$lambda$1(List list, int i) {
        return (ParameterDescriptor) list.get(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParameterDescriptor computeParameters$lambda$2(ReceiverParameterDescriptor receiverParameterDescriptor) {
        return receiverParameterDescriptor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParameterDescriptor computeParameters$lambda$3(CallableMemberDescriptor callableMemberDescriptor, int i) {
        ValueParameterDescriptor valueParameterDescriptor = callableMemberDescriptor.getValueParameters().get(i);
        valueParameterDescriptor.getClass();
        return valueParameterDescriptor;
    }

    public abstract DescriptorKType computeReturnType();

    @Override // kotlin.reflect.jvm.internal.ReflectKCallable
    public List<KParameter> getAllParameters() {
        List<KParameter> listInvoke = this._allParameters.invoke();
        listInvoke.getClass();
        return listInvoke;
    }

    public abstract CallableMemberDescriptor getDescriptor();

    public final Modality getModality$kotlin_reflection() {
        Modality modality = this.overriddenStorage.getModality();
        if (modality != null) {
            return modality;
        }
        Modality modality2 = getDescriptor().getModality();
        modality2.getClass();
        return modality2;
    }

    /* JADX INFO: renamed from: getOverriddenStorage$kotlin_reflection, reason: from getter */
    public final KCallableOverriddenStorage getOverriddenStorage() {
        return this.overriddenStorage;
    }

    @Override // kotlin.reflect.KCallable
    public List<KParameter> getParameters() {
        List<KParameter> listInvoke = this._parameters.invoke();
        listInvoke.getClass();
        return listInvoke;
    }

    @Override // kotlin.reflect.KCallable
    public KType getReturnType() {
        KType kTypeInvoke = this._returnType.invoke();
        kTypeInvoke.getClass();
        return kTypeInvoke;
    }

    @Override // kotlin.reflect.KCallable
    public List<KTypeParameter> getTypeParameters() {
        List<KTypeParameterImpl> listInvoke = this._typeParameters.invoke();
        listInvoke.getClass();
        return listInvoke;
    }

    public KVisibility getVisibility() {
        DescriptorVisibility visibility = getDescriptor().getVisibility();
        visibility.getClass();
        return UtilKt.toKVisibility(visibility);
    }

    public final boolean isPackagePrivate$kotlin_reflection() {
        return Intrinsics.areEqual(getDescriptor().getVisibility(), JavaDescriptorVisibilities.PACKAGE_VISIBILITY);
    }

    public abstract DescriptorKCallable<R> shallowCopy$kotlin_reflection(KCallableOverriddenStorage overriddenStorage);
}
