package kotlin.reflect.jvm.internal;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.lang.annotation.Annotation;
import java.lang.annotation.Inherited;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference;
import kotlin.jvm.internal.RepeatableContainer;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KParameter;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;
import kotlin.reflect.jvm.KClassesJvm;
import kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectAnnotationSource;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectJavaClassFinderKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeSourceElementFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotation;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaElement;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinarySourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ErrorValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.NullValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.TypedArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.types.AbstractKType;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u008c\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0019\u0010\u0002\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a+\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0001*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\t\u0010\n\u001a5\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00012\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\u000f\u001a\u001b\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0001*\u0006\u0012\u0002\b\u00030\u0001H\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0013*\u00020\u0012H\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0019\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017*\u00020\u0016H\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0013\u0010\u001c\u001a\u00020\u001b*\u00020\u0018H\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001b\u0010\u001c\u001a\u00020\u001b*\n\u0012\u0006\b\u0001\u0012\u00020\u00180\u001eH\u0002¢\u0006\u0004\b\u001c\u0010\u001f\u001a'\u0010!\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180\u001e2\u000e\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180\u001eH\u0002¢\u0006\u0004\b!\u0010\"\u001a\u0013\u0010#\u001a\u00020\u001b*\u00020\u0018H\u0000¢\u0006\u0004\b#\u0010\u001d\u001a\u001f\u0010%\u001a\u00020\u001b2\u000e\u0010$\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180\u001eH\u0002¢\u0006\u0004\b%\u0010\u001f\u001a\u001f\u0010&\u001a\u00020\u001b2\u000e\u0010$\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180\u001eH\u0002¢\u0006\u0004\b&\u0010\u001f\u001a\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017*\b\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\u0004\b'\u0010(\u001a\u0015\u0010*\u001a\u0004\u0018\u00010\u0018*\u00020)H\u0002¢\u0006\u0004\b*\u0010+\u001a!\u0010.\u001a\u0004\u0018\u00010-*\u0006\u0012\u0002\b\u00030,2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b.\u0010/\u001a\u001d\u00101\u001a\u0004\u0018\u00010-*\u0002002\u0006\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b1\u00102\u001a\u0017\u00104\u001a\u0004\u0018\u000103*\u0004\u0018\u00010-H\u0000¢\u0006\u0004\b4\u00105\u001a\u001b\u00107\u001a\b\u0012\u0002\b\u0003\u0018\u000106*\u0004\u0018\u00010-H\u0000¢\u0006\u0004\b7\u00108\u001a\u001b\u0010:\u001a\b\u0012\u0002\b\u0003\u0018\u000109*\u0004\u0018\u00010-H\u0000¢\u0006\u0004\b:\u0010;\u001a\u0019\u0010>\u001a\u0004\u0018\u00010-2\u0006\u0010=\u001a\u00020<H\u0000¢\u0006\u0004\b>\u0010?\u001a=\u0010D\u001a\u0004\u0018\u00010C*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010@\u001a\u00020\f2\u001a\u0010B\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00010A\"\u0006\u0012\u0002\b\u00030\u0001H\u0000¢\u0006\u0004\bD\u0010E\u001a\u0013\u0010G\u001a\u00020\u001b*\u00020FH\u0000¢\u0006\u0004\bG\u0010H\u001a\u0017\u0010K\u001a\u00020J2\u0006\u0010I\u001a\u00020\fH\u0000¢\u0006\u0004\bK\u0010L\u001a\u0017\u0010M\u001a\u00020\f*\u0006\u0012\u0002\b\u00030\u001eH\u0000¢\u0006\u0004\bM\u0010N\u001a\u0015\u0010O\u001a\u0004\u0018\u00010F*\u00020FH\u0000¢\u0006\u0004\bO\u0010P\u001a#\u0010S\u001a\u00020R*\u00020\u00042\u0006\u0010I\u001a\u00020\f2\u0006\u0010Q\u001a\u00020\u001bH\u0000¢\u0006\u0004\bS\u0010T\u001a3\u0010W\u001a\u0006\u0012\u0002\b\u00030\u0001*\u00020\u00042\u0006\u0010I\u001a\u00020\f2\b\b\u0002\u0010U\u001a\u00020\u00072\b\b\u0002\u0010V\u001a\u00020\u0007H\u0002¢\u0006\u0004\bW\u0010X\u001a'\u0010\\\u001a\u00028\u0000\"\u0004\b\u0000\u0010Y2\f\u0010[\u001a\b\u0012\u0004\u0012\u00028\u00000ZH\u0080\bø\u0001\u0000¢\u0006\u0004\b\\\u0010]\u001as\u0010o\u001a\u00028\u0001\"\b\b\u0000\u0010_*\u00020^\"\b\b\u0001\u0010a*\u00020`2\n\u0010b\u001a\u0006\u0012\u0002\b\u00030\u00012\b\u0010d\u001a\u0004\u0018\u00010c2\u0006\u0010e\u001a\u00028\u00002\u0006\u0010g\u001a\u00020f2\u0006\u0010i\u001a\u00020h2\u0006\u0010k\u001a\u00020j2\u0018\u0010n\u001a\u0014\u0012\u0004\u0012\u00020m\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010lH\u0000¢\u0006\u0004\bo\u0010p\"\u001a\u0010r\u001a\u00020q8\u0000X\u0080\u0004¢\u0006\f\n\u0004\br\u0010s\u001a\u0004\bt\u0010u\"\u0014\u0010v\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bv\u0010w\" \u0010z\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180\u001e*\u00020\u00188@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bx\u0010y\"\u0018\u0010{\u001a\u00020\u001b*\u00020F8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b{\u0010H\"\u0018\u0010}\u001a\u00020\u001b*\u00020|8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b}\u0010~\"\"\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0080\u0001*\u0006\u0012\u0002\b\u00030\u007f8@X\u0080\u0004¢\u0006\b\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0084\u0001"}, d2 = {"Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "Ljava/lang/Class;", "toJavaClass", "(Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;)Ljava/lang/Class;", "Ljava/lang/ClassLoader;", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "kotlinClassId", "", "arrayDimensions", "loadClass", "(Ljava/lang/ClassLoader;Lkotlin/reflect/jvm/internal/impl/name/ClassId;I)Ljava/lang/Class;", "classLoader", "", "packageName", "className", "(Ljava/lang/ClassLoader;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/Class;", "createArrayType", "(Ljava/lang/Class;)Ljava/lang/Class;", "Lkotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibility;", "Lkotlin/reflect/KVisibility;", "toKVisibility", "(Lkotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibility;)Lkotlin/reflect/KVisibility;", "Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/Annotated;", "", "", "computeAnnotations", "(Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/Annotated;)Ljava/util/List;", "", "hasInherited", "(Ljava/lang/annotation/Annotation;)Z", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Z", "containerClass", "getRepeatableContainerComponentType", "(Lkotlin/reflect/KClass;)Lkotlin/reflect/KClass;", "isRepeatableContainerForNonInheritedAnnotation", "klass", "isKotlinRepeatableContainer", "isJavaRepeatableContainer", "unwrapKotlinRepeatableAnnotations", "(Ljava/util/List;)Ljava/util/List;", "Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptor;", "toAnnotationInstance", "(Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptor;)Ljava/lang/annotation/Annotation;", "Lkotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValue;", "", "toRuntimeValue", "(Lkotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValue;Ljava/lang/ClassLoader;)Ljava/lang/Object;", "Lkotlin/reflect/jvm/internal/impl/resolve/constants/ArrayValue;", "arrayToRuntimeValue", "(Lkotlin/reflect/jvm/internal/impl/resolve/constants/ArrayValue;Ljava/lang/ClassLoader;)Ljava/lang/Object;", "Lkotlin/reflect/jvm/internal/ReflectKFunction;", "asReflectFunction", "(Ljava/lang/Object;)Lkotlin/reflect/jvm/internal/ReflectKFunction;", "Lkotlin/reflect/jvm/internal/ReflectKProperty;", "asReflectProperty", "(Ljava/lang/Object;)Lkotlin/reflect/jvm/internal/ReflectKProperty;", "Lkotlin/reflect/jvm/internal/ReflectKCallable;", "asReflectCallable", "(Ljava/lang/Object;)Lkotlin/reflect/jvm/internal/ReflectKCallable;", "Ljava/lang/reflect/Type;", "type", "defaultPrimitiveValue", "(Ljava/lang/reflect/Type;)Ljava/lang/Object;", "name", "", "parameterTypes", "Ljava/lang/reflect/Method;", "getDeclaredMethodOrNull", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "Lkotlin/reflect/KType;", "isNullableType", "(Lkotlin/reflect/KType;)Z", "desc", "Lkotlin/reflect/jvm/internal/FunctionJvmDescriptor;", "parseJvmDescriptor", "(Ljava/lang/String;)Lkotlin/reflect/jvm/internal/FunctionJvmDescriptor;", "toJvmDescriptor", "(Lkotlin/reflect/KClass;)Ljava/lang/String;", "unsubstitutedUnderlyingType", "(Lkotlin/reflect/KType;)Lkotlin/reflect/KType;", "loadReturnType", "Lkotlin/reflect/jvm/internal/FunctionJvmDescriptorLoaded;", "parseAndLoadDescriptor", "(Ljava/lang/ClassLoader;Ljava/lang/String;Z)Lkotlin/reflect/jvm/internal/FunctionJvmDescriptorLoaded;", "begin", "end", "parseAndLoadType", "(Ljava/lang/ClassLoader;Ljava/lang/String;II)Ljava/lang/Class;", "R", "Lkotlin/Function0;", "block", "reflectionCall", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;", "M", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;", "D", "moduleAnchor", "Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/descriptors/DeserializedContainerSource;", "containerSource", "proto", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/NameResolver;", "nameResolver", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/TypeTable;", "typeTable", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/BinaryVersion;", "metadataVersion", "Lkotlin/Function2;", "Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer;", "createDescriptor", "deserializeToDescriptor", "(Ljava/lang/Class;Lorg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedContainerSource;Lorg/jetbrains/kotlin/protobuf/MessageLite;Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;Lorg/jetbrains/kotlin/metadata/deserialization/BinaryVersion;Lkotlin/jvm/functions/Function2;)Lorg/jetbrains/kotlin/descriptors/CallableDescriptor;", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "JVM_STATIC", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "getJVM_STATIC", "()Lorg/jetbrains/kotlin/name/FqName;", "SUSPEND_FUNCTION_PREFIX", "Ljava/lang/String;", "getUnwrappedAnnotationClass", "(Ljava/lang/annotation/Annotation;)Lkotlin/reflect/KClass;", "unwrappedAnnotationClass", "isInlineClassType", "Lkotlin/reflect/KParameter;", "isAlwaysBoxedByCompiler", "(Lkotlin/reflect/KParameter;)Z", "Lkotlin/reflect/jvm/internal/DescriptorKCallable;", "Lkotlin/reflect/jvm/internal/impl/descriptors/ReceiverParameterDescriptor;", "getInstanceReceiverParameter", "(Lkotlin/reflect/jvm/internal/DescriptorKCallable;)Lorg/jetbrains/kotlin/descriptors/ReceiverParameterDescriptor;", "instanceReceiverParameter", "kotlin-reflection"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class UtilKt {
    private static final FqName JVM_STATIC = new FqName("kotlin.jvm.JvmStatic");
    private static final String SUSPEND_FUNCTION_PREFIX;

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PrimitiveType.values().length];
            try {
                iArr[PrimitiveType.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PrimitiveType.CHAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PrimitiveType.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PrimitiveType.SHORT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PrimitiveType.INT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PrimitiveType.FLOAT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PrimitiveType.LONG.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[PrimitiveType.DOUBLE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        FunctionTypeKind.SuspendFunction suspendFunction = FunctionTypeKind.SuspendFunction.INSTANCE;
        sb.append(suspendFunction.getPackageFqName().asString());
        sb.append('.');
        sb.append(suspendFunction.getClassNamePrefix());
        SUSPEND_FUNCTION_PREFIX = sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KType _get_isAlwaysBoxedByCompiler_$lambda$0(KType kType) {
        kType.getClass();
        return unsubstitutedUnderlyingType(kType);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final Object arrayToRuntimeValue(ArrayValue arrayValue, ClassLoader classLoader) {
        KotlinType type;
        Class clsLoadClass$default;
        TypedArrayValue typedArrayValue = arrayValue instanceof TypedArrayValue ? (TypedArrayValue) arrayValue : null;
        if (typedArrayValue != null && (type = typedArrayValue.getType()) != null) {
            List<? extends ConstantValue<?>> value = arrayValue.getValue();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(value, 10));
            Iterator<T> it = value.iterator();
            while (it.hasNext()) {
                arrayList.add(toRuntimeValue((ConstantValue) it.next(), classLoader));
            }
            PrimitiveType primitiveArrayElementType = KotlinBuiltIns.getPrimitiveArrayElementType(type);
            int i = 0;
            switch (primitiveArrayElementType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[primitiveArrayElementType.ordinal()]) {
                case -1:
                    if (!KotlinBuiltIns.isArray(type)) {
                        Utf8$$ExternalSyntheticBUOutline0.m$1("Not an array type: ", type);
                    } else {
                        KotlinType type2 = ((TypeProjection) CollectionsKt.single((List) type.getArguments())).getType();
                        type2.getClass();
                        ClassifierDescriptor classifierDescriptorMo2510getDeclarationDescriptor = type2.getConstructor().mo2510getDeclarationDescriptor();
                        ClassDescriptor classDescriptor = classifierDescriptorMo2510getDeclarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) classifierDescriptorMo2510getDeclarationDescriptor : null;
                        if (classDescriptor == null) {
                            Utf8$$ExternalSyntheticBUOutline0.m("Not a class type: ", type2);
                            return null;
                        }
                        if (KotlinBuiltIns.isString(type2)) {
                            int size = arrayValue.getValue().size();
                            String[] strArr = new String[size];
                            while (i < size) {
                                Object obj = arrayList.get(i);
                                obj.getClass();
                                strArr[i] = obj;
                                i++;
                            }
                            return strArr;
                        }
                        if (KotlinBuiltIns.isKClass(classDescriptor)) {
                            int size2 = arrayValue.getValue().size();
                            Class[] clsArr = new Class[size2];
                            while (i < size2) {
                                Object obj2 = arrayList.get(i);
                                obj2.getClass();
                                clsArr[i] = obj2;
                                i++;
                            }
                            return clsArr;
                        }
                        ClassId classId = DescriptorUtilsKt.getClassId(classDescriptor);
                        if (classId != null && (clsLoadClass$default = loadClass$default(classLoader, classId, 0, 2, null)) != null) {
                            Object objNewInstance = Array.newInstance((Class<?>) clsLoadClass$default, arrayValue.getValue().size());
                            objNewInstance.getClass();
                            Object[] objArr = (Object[]) objNewInstance;
                            int size3 = arrayList.size();
                            while (i < size3) {
                                objArr[i] = arrayList.get(i);
                                i++;
                            }
                            return objArr;
                        }
                    }
                    break;
                case 0:
                default:
                    Home$$ExternalSyntheticBUOutline0.m();
                    return null;
                case 1:
                    int size4 = arrayValue.getValue().size();
                    boolean[] zArr = new boolean[size4];
                    while (i < size4) {
                        Object obj3 = arrayList.get(i);
                        obj3.getClass();
                        zArr[i] = ((Boolean) obj3).booleanValue();
                        i++;
                    }
                    return zArr;
                case 2:
                    int size5 = arrayValue.getValue().size();
                    char[] cArr = new char[size5];
                    while (i < size5) {
                        Object obj4 = arrayList.get(i);
                        obj4.getClass();
                        cArr[i] = ((Character) obj4).charValue();
                        i++;
                    }
                    return cArr;
                case 3:
                    int size6 = arrayValue.getValue().size();
                    byte[] bArr = new byte[size6];
                    while (i < size6) {
                        Object obj5 = arrayList.get(i);
                        obj5.getClass();
                        bArr[i] = ((Byte) obj5).byteValue();
                        i++;
                    }
                    return bArr;
                case 4:
                    int size7 = arrayValue.getValue().size();
                    short[] sArr = new short[size7];
                    while (i < size7) {
                        Object obj6 = arrayList.get(i);
                        obj6.getClass();
                        sArr[i] = ((Short) obj6).shortValue();
                        i++;
                    }
                    return sArr;
                case 5:
                    int size8 = arrayValue.getValue().size();
                    int[] iArr = new int[size8];
                    while (i < size8) {
                        Object obj7 = arrayList.get(i);
                        obj7.getClass();
                        iArr[i] = ((Integer) obj7).intValue();
                        i++;
                    }
                    return iArr;
                case 6:
                    int size9 = arrayValue.getValue().size();
                    float[] fArr = new float[size9];
                    while (i < size9) {
                        Object obj8 = arrayList.get(i);
                        obj8.getClass();
                        fArr[i] = ((Float) obj8).floatValue();
                        i++;
                    }
                    return fArr;
                case 7:
                    int size10 = arrayValue.getValue().size();
                    long[] jArr = new long[size10];
                    while (i < size10) {
                        Object obj9 = arrayList.get(i);
                        obj9.getClass();
                        jArr[i] = ((Long) obj9).longValue();
                        i++;
                    }
                    return jArr;
                case 8:
                    int size11 = arrayValue.getValue().size();
                    double[] dArr = new double[size11];
                    while (i < size11) {
                        Object obj10 = arrayList.get(i);
                        obj10.getClass();
                        dArr[i] = ((Double) obj10).doubleValue();
                        i++;
                    }
                    return dArr;
            }
        }
        return null;
    }

    public static final ReflectKCallable<?> asReflectCallable(Object obj) {
        if (obj instanceof LazyKProperty) {
            return asReflectCallable(((LazyKProperty) obj).getDelegate());
        }
        if (obj instanceof ReflectKCallable) {
            return (ReflectKCallable) obj;
        }
        if (obj instanceof CallableReference) {
            KCallable kCallableCompute = ((CallableReference) obj).compute();
            if (kCallableCompute == obj) {
                kCallableCompute = null;
            }
            if (kCallableCompute != null) {
                return asReflectCallable(kCallableCompute);
            }
        }
        return null;
    }

    public static final ReflectKFunction asReflectFunction(Object obj) {
        if (obj instanceof ReflectKFunction) {
            return (ReflectKFunction) obj;
        }
        if (obj instanceof FunctionReference) {
            KCallable kCallableCompute = ((FunctionReference) obj).compute();
            if (kCallableCompute instanceof ReflectKFunction) {
                return (ReflectKFunction) kCallableCompute;
            }
        }
        return null;
    }

    public static final ReflectKProperty<?> asReflectProperty(Object obj) {
        if (obj instanceof LazyKProperty) {
            return asReflectProperty(((LazyKProperty) obj).getDelegate());
        }
        if (obj instanceof ReflectKProperty) {
            return (ReflectKProperty) obj;
        }
        if (obj instanceof PropertyReference) {
            KCallable kCallableCompute = ((PropertyReference) obj).compute();
            if (kCallableCompute == obj) {
                kCallableCompute = null;
            }
            if (kCallableCompute != null) {
                return asReflectProperty(kCallableCompute);
            }
        }
        return null;
    }

    public static final List<Annotation> computeAnnotations(Annotated annotated) {
        Annotation annotationInstance;
        annotated.getClass();
        Annotations annotations = annotated.getAnnotations();
        ArrayList arrayList = new ArrayList();
        for (AnnotationDescriptor annotationDescriptor : annotations) {
            SourceElement source = annotationDescriptor.getSource();
            if (source instanceof ReflectAnnotationSource) {
                annotationInstance = ((ReflectAnnotationSource) source).getAnnotation();
            } else if (source instanceof RuntimeSourceElementFactory.RuntimeSourceElement) {
                ReflectJavaElement javaElement = ((RuntimeSourceElementFactory.RuntimeSourceElement) source).getJavaElement();
                ReflectJavaAnnotation reflectJavaAnnotation = javaElement instanceof ReflectJavaAnnotation ? (ReflectJavaAnnotation) javaElement : null;
                annotationInstance = reflectJavaAnnotation != null ? reflectJavaAnnotation.getAnnotation() : null;
            } else {
                annotationInstance = toAnnotationInstance(annotationDescriptor);
            }
            if (annotationInstance != null) {
                arrayList.add(annotationInstance);
            }
        }
        return unwrapKotlinRepeatableAnnotations(arrayList);
    }

    public static final Class<?> createArrayType(Class<?> cls) {
        cls.getClass();
        return Array.newInstance(cls, 0).getClass();
    }

    public static final Object defaultPrimitiveValue(Type type) {
        type.getClass();
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (cls.isPrimitive()) {
                if (Intrinsics.areEqual(cls, Boolean.TYPE)) {
                    return Boolean.FALSE;
                }
                if (Intrinsics.areEqual(cls, Character.TYPE)) {
                    return (char) 0;
                }
                if (Intrinsics.areEqual(cls, Byte.TYPE)) {
                    return (byte) 0;
                }
                if (Intrinsics.areEqual(cls, Short.TYPE)) {
                    return (short) 0;
                }
                if (Intrinsics.areEqual(cls, Integer.TYPE)) {
                    return 0;
                }
                if (Intrinsics.areEqual(cls, Float.TYPE)) {
                    return Float.valueOf(0.0f);
                }
                if (Intrinsics.areEqual(cls, Long.TYPE)) {
                    return 0L;
                }
                if (Intrinsics.areEqual(cls, Double.TYPE)) {
                    return Double.valueOf(0.0d);
                }
                if (Intrinsics.areEqual(cls, Void.TYPE)) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("Parameter with void type is illegal");
                    return null;
                }
                Events$$ExternalSyntheticBUOutline0.m("Unknown primitive: ", type);
            }
        }
        return null;
    }

    public static final <M extends MessageLite, D extends CallableDescriptor> D deserializeToDescriptor(Class<?> cls, DeserializedContainerSource deserializedContainerSource, M m, NameResolver nameResolver, TypeTable typeTable, BinaryVersion binaryVersion, Function2<? super MemberDeserializer, ? super M, ? extends D> function2) {
        List<ProtoBuf$TypeParameter> typeParameterList;
        cls.getClass();
        m.getClass();
        nameResolver.getClass();
        typeTable.getClass();
        binaryVersion.getClass();
        function2.getClass();
        RuntimeModuleData orCreateModule = ModuleByClassLoaderKt.getOrCreateModule(cls);
        if (m instanceof ProtoBuf$Function) {
            typeParameterList = ((ProtoBuf$Function) m).getTypeParameterList();
        } else {
            if (!(m instanceof ProtoBuf$Property)) {
                Utf8$$ExternalSyntheticBUOutline0.m("Unsupported message: ", m);
                return null;
            }
            typeParameterList = ((ProtoBuf$Property) m).getTypeParameterList();
        }
        List<ProtoBuf$TypeParameter> list = typeParameterList;
        DeserializationComponents deserialization = orCreateModule.getDeserialization();
        ModuleDescriptor module = orCreateModule.getModule();
        VersionRequirementTable empty = VersionRequirementTable.Companion.getEMPTY();
        list.getClass();
        return function2.invoke(new MemberDeserializer(new DeserializationContext(deserialization, nameResolver, module, typeTable, empty, binaryVersion, deserializedContainerSource, null, list)), m);
    }

    public static final Method getDeclaredMethodOrNull(Class<?> cls, String str, Class<?>... clsArr) {
        cls.getClass();
        str.getClass();
        clsArr.getClass();
        try {
            return cls.getDeclaredMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public static final ReceiverParameterDescriptor getInstanceReceiverParameter(DescriptorKCallable<?> descriptorKCallable) {
        descriptorKCallable.getClass();
        ReceiverParameterDescriptor instanceReceiverParameter = descriptorKCallable.getOverriddenStorage().getInstanceReceiverParameter();
        if (instanceReceiverParameter != null) {
            return instanceReceiverParameter;
        }
        CallableMemberDescriptor descriptor = descriptorKCallable.getDescriptor();
        if (descriptor instanceof ConstructorDescriptor) {
            return ((ConstructorDescriptor) descriptor).getDispatchReceiverParameter();
        }
        if (descriptor.getDispatchReceiverParameter() == null) {
            return null;
        }
        DeclarationDescriptor containingDeclaration = descriptor.getContainingDeclaration();
        containingDeclaration.getClass();
        return ((ClassDescriptor) containingDeclaration).getThisAsReceiverParameter();
    }

    public static final FqName getJVM_STATIC() {
        return JVM_STATIC;
    }

    private static final KClass<? extends Annotation> getRepeatableContainerComponentType(KClass<? extends Annotation> kClass) {
        Class<?> componentType = JvmClassMappingKt.getJavaClass(kClass).getDeclaredMethod(SDKConstants.PARAM_VALUE, null).getReturnType().getComponentType();
        componentType.getClass();
        KClass<? extends Annotation> kotlinClass = JvmClassMappingKt.getKotlinClass(componentType);
        kotlinClass.getClass();
        return kotlinClass;
    }

    public static final KClass<? extends Annotation> getUnwrappedAnnotationClass(Annotation annotation) {
        annotation.getClass();
        KClass<? extends Annotation> annotationClass = JvmClassMappingKt.getAnnotationClass(annotation);
        return isJavaRepeatableContainer(annotationClass) ? getRepeatableContainerComponentType(annotationClass) : annotationClass;
    }

    private static final boolean hasInherited(KClass<? extends Annotation> kClass) {
        return JvmClassMappingKt.getJavaClass(kClass).getAnnotation(Inherited.class) != null;
    }

    public static final boolean isAlwaysBoxedByCompiler(KParameter kParameter) {
        kParameter.getClass();
        if (!(kParameter instanceof ReflectKParameter) || !((ReflectKParameter) kParameter).getDeclaresDefaultValue() || !isInlineClassType(kParameter.getType())) {
            return false;
        }
        Iterator it = SequencesKt.drop(SequencesKt.generateSequence(kParameter.getType(), new Function1() { // from class: kotlin.reflect.jvm.internal.UtilKt$$Lambda$0
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return UtilKt._get_isAlwaysBoxedByCompiler_$lambda$0((KType) obj);
            }
        }), 1).iterator();
        while (it.hasNext()) {
            if (isNullableType((KType) it.next())) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isInlineClassType(KType kType) {
        kType.getClass();
        KClassifier classifier = kType.getClassifier();
        KClassImpl kClassImpl = classifier instanceof KClassImpl ? (KClassImpl) classifier : null;
        return kClassImpl != null && kClassImpl.isValue();
    }

    private static final boolean isJavaRepeatableContainer(KClass<? extends Annotation> kClass) {
        Class<?> componentType;
        Annotation annotation;
        Object objInvoke;
        Class javaClass = JvmClassMappingKt.getJavaClass(kClass);
        Method declaredMethodOrNull = getDeclaredMethodOrNull(javaClass, SDKConstants.PARAM_VALUE, new Class[0]);
        if (declaredMethodOrNull == null || (componentType = declaredMethodOrNull.getReturnType().getComponentType()) == null || !componentType.isAnnotation()) {
            return false;
        }
        Annotation[] annotations = componentType.getAnnotations();
        annotations.getClass();
        int length = annotations.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                annotation = null;
                break;
            }
            annotation = annotations[i];
            if (Intrinsics.areEqual(JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(annotation)).getName(), JvmAnnotationNames.REPEATABLE_ANNOTATION.asString())) {
                break;
            }
            i++;
        }
        if (annotation == null || (objInvoke = JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(annotation)).getMethod(SDKConstants.PARAM_VALUE, null).invoke(annotation, null)) == null) {
            return false;
        }
        return Intrinsics.areEqual(javaClass, objInvoke);
    }

    private static final boolean isKotlinRepeatableContainer(KClass<? extends Annotation> kClass) {
        Class javaClass = JvmClassMappingKt.getJavaClass(kClass);
        return Intrinsics.areEqual(javaClass.getSimpleName(), "Container") && javaClass.getAnnotation(RepeatableContainer.class) != null;
    }

    public static final boolean isNullableType(KType kType) {
        kType.getClass();
        if (kType.getIsMarkedNullable()) {
            return true;
        }
        AbstractKType abstractKType = (AbstractKType) kType;
        AbstractKType upperBound = abstractKType.getUpperBound();
        if (upperBound != null && isNullableType(upperBound)) {
            return true;
        }
        if (abstractKType.getIsDefinitelyNotNullType()) {
            return false;
        }
        KClassifier classifier = kType.getClassifier();
        if (classifier instanceof KTypeParameter) {
            List<KType> upperBounds = ((KTypeParameter) classifier).getUpperBounds();
            if (!(upperBounds instanceof Collection) || !upperBounds.isEmpty()) {
                Iterator<T> it = upperBounds.iterator();
                while (it.hasNext()) {
                    if (isNullableType((KType) it.next())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static final boolean isRepeatableContainerForNonInheritedAnnotation(Annotation annotation) {
        annotation.getClass();
        return isJavaRepeatableContainer(JvmClassMappingKt.getAnnotationClass(annotation)) && !hasInherited(getRepeatableContainerComponentType(JvmClassMappingKt.getAnnotationClass(annotation)));
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static final Class<?> loadClass(ClassLoader classLoader, String str, String str2, int i) {
        if (Intrinsics.areEqual(str, "kotlin")) {
            switch (str2.hashCode()) {
                case -901856463:
                    if (str2.equals("BooleanArray")) {
                        return boolean[].class;
                    }
                    break;
                case -763279523:
                    if (str2.equals("ShortArray")) {
                        return short[].class;
                    }
                    break;
                case -755911549:
                    if (str2.equals("CharArray")) {
                        return char[].class;
                    }
                    break;
                case -74930671:
                    if (str2.equals("ByteArray")) {
                        return byte[].class;
                    }
                    break;
                case 22374632:
                    if (str2.equals("DoubleArray")) {
                        return double[].class;
                    }
                    break;
                case 63537721:
                    if (str2.equals("Array")) {
                        return Object[].class;
                    }
                    break;
                case 601811914:
                    if (str2.equals("IntArray")) {
                        return int[].class;
                    }
                    break;
                case 948852093:
                    if (str2.equals("FloatArray")) {
                        return float[].class;
                    }
                    break;
                case 2104330525:
                    if (str2.equals("LongArray")) {
                        return long[].class;
                    }
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        if (i > 0) {
            for (int i2 = 0; i2 < i; i2++) {
                sb.append("[");
            }
            sb.append("L");
        }
        if (str.length() > 0) {
            sb.append(str.concat("."));
        }
        sb.append(StringsKt__StringsJVMKt.replace$default(str2, '.', '$', false, 4, (Object) null));
        if (i > 0) {
            sb.append(";");
        }
        return ReflectJavaClassFinderKt.tryLoadClass(classLoader, sb.toString());
    }

    public static /* synthetic */ Class loadClass$default(ClassLoader classLoader, ClassId classId, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return loadClass(classLoader, classId, i);
    }

    public static final FunctionJvmDescriptorLoaded parseAndLoadDescriptor(ClassLoader classLoader, String str, boolean z) {
        classLoader.getClass();
        str.getClass();
        FunctionJvmDescriptor jvmDescriptor = parseJvmDescriptor(str);
        List<String> parameters = jvmDescriptor.getParameters();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(parameters, 10));
        Iterator<T> it = parameters.iterator();
        while (it.hasNext()) {
            ClassLoader classLoader2 = classLoader;
            arrayList.add(parseAndLoadType$default(classLoader2, (String) it.next(), 0, 0, 6, null));
            classLoader = classLoader2;
        }
        return new FunctionJvmDescriptorLoaded(arrayList, z ? parseAndLoadType$default(classLoader, jvmDescriptor.getReturnType(), 0, 0, 6, null) : null);
    }

    private static final Class<?> parseAndLoadType(ClassLoader classLoader, String str, int i, int i2) throws ClassNotFoundException {
        char cCharAt = str.charAt(i);
        if (cCharAt == 'F') {
            return Float.TYPE;
        }
        if (cCharAt == 'L') {
            Class<?> clsLoadClass = classLoader.loadClass(StringsKt__StringsJVMKt.replace$default(str.substring(i + 1, i2 - 1), '/', '.', false, 4, (Object) null));
            clsLoadClass.getClass();
            return clsLoadClass;
        }
        if (cCharAt == 'S') {
            return Short.TYPE;
        }
        if (cCharAt == 'V') {
            Class<?> cls = Void.TYPE;
            cls.getClass();
            return cls;
        }
        if (cCharAt == 'I') {
            return Integer.TYPE;
        }
        if (cCharAt == 'J') {
            return Long.TYPE;
        }
        if (cCharAt == 'Z') {
            return Boolean.TYPE;
        }
        if (cCharAt == '[') {
            return createArrayType(parseAndLoadType(classLoader, str, i + 1, i2));
        }
        switch (cCharAt) {
            case 'B':
                return Byte.TYPE;
            case 'C':
                return Character.TYPE;
            case 'D':
                return Double.TYPE;
            default:
                throw new KotlinReflectionInternalError("Unknown type prefix in the method signature: ".concat(str));
        }
    }

    public static /* synthetic */ Class parseAndLoadType$default(ClassLoader classLoader, String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = str.length();
        }
        return parseAndLoadType(classLoader, str, i, i2);
    }

    public static final FunctionJvmDescriptor parseJvmDescriptor(String str) {
        int iIndexOf$default;
        str.getClass();
        ArrayList arrayList = new ArrayList();
        int i = 1;
        while (str.charAt(i) != ')') {
            int i2 = i;
            while (str.charAt(i2) == '[') {
                i2++;
            }
            char cCharAt = str.charAt(i2);
            if (StringsKt__StringsKt.contains$default("VZCBSIFJD", cCharAt, false, 2, (Object) null)) {
                iIndexOf$default = i2 + 1;
            } else {
                if (cCharAt != 'L') {
                    throw new KotlinReflectionInternalError("Unknown type prefix in the method signature: ".concat(str));
                }
                iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, ';', i, false, 4, (Object) null) + 1;
            }
            arrayList.add(str.substring(i, iIndexOf$default));
            i = iIndexOf$default;
        }
        return new FunctionJvmDescriptor(arrayList, str.substring(i + 1));
    }

    private static final Annotation toAnnotationInstance(AnnotationDescriptor annotationDescriptor) {
        ClassDescriptor annotationClass = DescriptorUtilsKt.getAnnotationClass(annotationDescriptor);
        Class<?> javaClass = annotationClass != null ? toJavaClass(annotationClass) : null;
        if (javaClass == null) {
            javaClass = null;
        }
        if (javaClass == null) {
            return null;
        }
        Set<Map.Entry<Name, ConstantValue<?>>> setEntrySet = annotationDescriptor.getAllValueArguments().entrySet();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Name name = (Name) entry.getKey();
            ConstantValue constantValue = (ConstantValue) entry.getValue();
            ClassLoader classLoader = javaClass.getClassLoader();
            classLoader.getClass();
            Object runtimeValue = toRuntimeValue(constantValue, classLoader);
            Pair pair = runtimeValue != null ? TuplesKt.to(name.asString(), runtimeValue) : null;
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        return (Annotation) AnnotationConstructorCallerKt.createAnnotationInstance$default(javaClass, MapsKt.toMap(arrayList), null, 4, null);
    }

    public static final Class<?> toJavaClass(ClassDescriptor classDescriptor) {
        classDescriptor.getClass();
        SourceElement source = classDescriptor.getSource();
        source.getClass();
        if (source instanceof KotlinJvmBinarySourceElement) {
            KotlinJvmBinaryClass binaryClass = ((KotlinJvmBinarySourceElement) source).getBinaryClass();
            binaryClass.getClass();
            return ((ReflectKotlinClass) binaryClass).getKlass();
        }
        if (source instanceof RuntimeSourceElementFactory.RuntimeSourceElement) {
            ReflectJavaElement javaElement = ((RuntimeSourceElementFactory.RuntimeSourceElement) source).getJavaElement();
            javaElement.getClass();
            return ((ReflectJavaClass) javaElement).getElement();
        }
        ClassId classId = DescriptorUtilsKt.getClassId(classDescriptor);
        if (classId == null) {
            return null;
        }
        return loadClass$default(ReflectClassUtilKt.getSafeClassLoader(classDescriptor.getClass()), classId, 0, 2, null);
    }

    public static final String toJvmDescriptor(KClass<?> kClass) {
        kClass.getClass();
        return "L" + StringsKt__StringsJVMKt.replace$default(KClassesJvm.getJvmName(kClass), '.', '/', false, 4, (Object) null) + ';';
    }

    public static final KVisibility toKVisibility(DescriptorVisibility descriptorVisibility) {
        descriptorVisibility.getClass();
        if (Intrinsics.areEqual(descriptorVisibility, DescriptorVisibilities.PUBLIC)) {
            return KVisibility.PUBLIC;
        }
        if (Intrinsics.areEqual(descriptorVisibility, DescriptorVisibilities.PROTECTED)) {
            return KVisibility.PROTECTED;
        }
        if (Intrinsics.areEqual(descriptorVisibility, DescriptorVisibilities.INTERNAL)) {
            return KVisibility.INTERNAL;
        }
        if (Intrinsics.areEqual(descriptorVisibility, DescriptorVisibilities.PRIVATE) || Intrinsics.areEqual(descriptorVisibility, DescriptorVisibilities.PRIVATE_TO_THIS)) {
            return KVisibility.PRIVATE;
        }
        return null;
    }

    private static final Object toRuntimeValue(ConstantValue<?> constantValue, ClassLoader classLoader) {
        if (constantValue instanceof AnnotationValue) {
            return toAnnotationInstance(((AnnotationValue) constantValue).getValue());
        }
        if (constantValue instanceof ArrayValue) {
            return arrayToRuntimeValue((ArrayValue) constantValue, classLoader);
        }
        if (constantValue instanceof EnumValue) {
            Pair<? extends ClassId, ? extends Name> value = ((EnumValue) constantValue).getValue();
            ClassId classIdComponent1 = value.component1();
            Name nameComponent2 = value.component2();
            Class clsLoadClass$default = loadClass$default(classLoader, classIdComponent1, 0, 2, null);
            if (clsLoadClass$default != null) {
                return Util.getEnumConstantByName(clsLoadClass$default, nameComponent2.asString());
            }
            return null;
        }
        if (!(constantValue instanceof KClassValue)) {
            if ((constantValue instanceof ErrorValue) || (constantValue instanceof NullValue)) {
                return null;
            }
            return constantValue.getValue();
        }
        KClassValue.Value value2 = ((KClassValue) constantValue).getValue();
        if (value2 instanceof KClassValue.Value.NormalClass) {
            KClassValue.Value.NormalClass normalClass = (KClassValue.Value.NormalClass) value2;
            return loadClass(classLoader, normalClass.getClassId(), normalClass.getArrayDimensions());
        }
        if (!(value2 instanceof KClassValue.Value.LocalClass)) {
            Home$$ExternalSyntheticBUOutline0.m();
            return null;
        }
        ClassifierDescriptor classifierDescriptorMo2510getDeclarationDescriptor = ((KClassValue.Value.LocalClass) value2).getType().getConstructor().mo2510getDeclarationDescriptor();
        ClassDescriptor classDescriptor = classifierDescriptorMo2510getDeclarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) classifierDescriptorMo2510getDeclarationDescriptor : null;
        if (classDescriptor != null) {
            return toJavaClass(classDescriptor);
        }
        return null;
    }

    public static final KType unsubstitutedUnderlyingType(KType kType) {
        kType.getClass();
        KClassifier classifier = kType.getClassifier();
        KClassImpl kClassImpl = classifier instanceof KClassImpl ? (KClassImpl) classifier : null;
        if (kClassImpl != null) {
            return kClassImpl.getInlineClassUnderlyingType$kotlin_reflection();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Object, java.util.List<? extends java.lang.annotation.Annotation>] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.util.ArrayList, java.util.Collection] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.util.List<java.lang.annotation.Annotation>] */
    public static final List<Annotation> unwrapKotlinRepeatableAnnotations(List<? extends Annotation> list) throws IllegalAccessException, InvocationTargetException {
        List listListOf;
        list.getClass();
        Iterable<Annotation> iterable = (Iterable) list;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            Iterator it = iterable.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (Intrinsics.areEqual(JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass((Annotation) it.next())).getSimpleName(), "Container")) {
                    list = new ArrayList<>();
                    for (Annotation annotation : iterable) {
                        KClass annotationClass = JvmClassMappingKt.getAnnotationClass(annotation);
                        if (isKotlinRepeatableContainer(annotationClass)) {
                            Object objInvoke = JvmClassMappingKt.getJavaClass(annotationClass).getDeclaredMethod(SDKConstants.PARAM_VALUE, null).invoke(annotation, null);
                            objInvoke.getClass();
                            listListOf = ArraysKt.asList((Annotation[]) objInvoke);
                        } else {
                            listListOf = CollectionsKt.listOf(annotation);
                        }
                        CollectionsKt__MutableCollectionsKt.addAll((Collection) list, listListOf);
                    }
                }
            }
        }
        return list;
    }

    public static final boolean hasInherited(Annotation annotation) {
        annotation.getClass();
        return hasInherited((KClass<? extends Annotation>) JvmClassMappingKt.getAnnotationClass(annotation));
    }

    public static final Class<?> loadClass(ClassLoader classLoader, ClassId classId, int i) {
        classLoader.getClass();
        classId.getClass();
        FqNameUnsafe unsafe = classId.asSingleFqName().toUnsafe();
        Integer intOrNull = StringsKt.toIntOrNull(StringsKt__StringsKt.substringAfter$default(unsafe.asString(), SUSPEND_FUNCTION_PREFIX, (String) null, 2, (Object) null));
        if (intOrNull != null) {
            return loadClass(classLoader, FunctionTypeKind.Function.INSTANCE.numberedClassId(intOrNull.intValue() + 1), i);
        }
        ClassId classIdMapKotlinToJava = JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(unsafe);
        if (classIdMapKotlinToJava == null) {
            classIdMapKotlinToJava = classId;
        }
        if (!Intrinsics.areEqual(classIdMapKotlinToJava, classId)) {
            classLoader = ReflectClassUtilKt.getSafeClassLoader(Unit.class);
        }
        return loadClass(classLoader, classIdMapKotlinToJava.getPackageFqName().asString(), classIdMapKotlinToJava.getRelativeClassName().asString(), i);
    }
}
