package kotlin.reflect.jvm.internal;

import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.KotlinGenericDeclaration;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KFunction;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.full.KClasses;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.TypeParameterTable;
import kotlin.reflect.jvm.internal.impl.SpecialJvmAnnotations;
import kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMapping;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EmptyPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.Java16SealedRecordLoader;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.km.Attributes;
import kotlin.reflect.jvm.internal.impl.km.ClassKind;
import kotlin.reflect.jvm.internal.impl.km.KmClass;
import kotlin.reflect.jvm.internal.impl.km.KmClassifier;
import kotlin.reflect.jvm.internal.impl.km.KmConstructor;
import kotlin.reflect.jvm.internal.impl.km.KmProperty;
import kotlin.reflect.jvm.internal.impl.km.KmType;
import kotlin.reflect.jvm.internal.impl.km.KmTypeParameter;
import kotlin.reflect.jvm.internal.impl.km.internal.ReadersKt;
import kotlin.reflect.jvm.internal.impl.km.jvm.JvmExtensionsKt;
import kotlin.reflect.jvm.internal.impl.km.jvm.KotlinClassMetadata;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.types.DescriptorKType;
import kotlin.reflect.jvm.internal.types.KTypeSubstitutor;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000î\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u0081\u0001*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\b\u0012\u0004\u0012\u00028\u00000\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\u0006\u0082\u0001\u0083\u0001\u0081\u0001B\u0015\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0013\u0010\u0011J\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!J\u001a\u0010#\u001a\u00020\u001c2\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b#\u0010\u001eJ\u000f\u0010$\u001a\u00020\u0014H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(J)\u0010.\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030-0\u000e2\u0006\u0010*\u001a\u00020)2\u0006\u0010,\u001a\u00020+H\u0002¢\u0006\u0004\b.\u0010/J\u001f\u00105\u001a\u0002042\u0006\u00101\u001a\u0002002\u0006\u00103\u001a\u000202H\u0002¢\u0006\u0004\b5\u00106J\u001f\u00107\u001a\u0002042\u0006\u00101\u001a\u0002002\u0006\u00103\u001a\u000202H\u0002¢\u0006\u0004\b7\u00106R \u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u00108\u001a\u0004\b9\u0010:R'\u0010=\u001a\u0012\u0012\u000e\u0012\f0<R\b\u0012\u0004\u0012\u00028\u00000\u00000;8\u0006¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u001a\u0010D\u001a\b\u0012\u0004\u0012\u00020A0\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bB\u0010CR\u001a\u0010G\u001a\b\u0012\u0004\u0012\u00020E0\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bF\u0010CR\u0016\u0010I\u001a\u0004\u0018\u00010&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bH\u0010(R\u0016\u0010K\u001a\u0004\u0018\u00010&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010(R \u0010N\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000L0\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bM\u0010CR\u001a\u0010S\u001a\b\u0012\u0004\u0012\u00020P0O8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010RR\u0014\u0010W\u001a\u00020T8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bU\u0010VR\u001a\u0010Z\u001a\b\u0012\u0004\u0012\u00020X0O8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bY\u0010RR\u0014\u0010[\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b[\u0010\\R\u0014\u0010]\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b]\u0010\\R\u0014\u0010^\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b^\u0010\\R\u0016\u0010`\u001a\u0004\u0018\u00010&8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b_\u0010(R\u0016\u0010c\u001a\u0004\u0018\u00010X8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\ba\u0010bR\u0016\u0010e\u001a\u0004\u0018\u00010&8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bd\u0010(R\u0011\u0010h\u001a\u0002048F¢\u0006\u0006\u001a\u0004\bf\u0010gR\u0016\u0010l\u001a\u0004\u0018\u00010i8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bj\u0010kR\u0014\u00101\u001a\u0002008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bm\u0010nR\u0014\u0010r\u001a\u00020o8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bp\u0010qR\u0014\u0010u\u001a\u00020)8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bs\u0010tR\u0014\u0010w\u001a\u00020)8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bv\u0010tR\u001a\u0010z\u001a\b\u0012\u0004\u0012\u00020x0\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\by\u0010CR\u001a\u0010|\u001a\b\u0012\u0004\u0012\u00020\u00180\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b{\u0010CR\u0015\u0010\u0080\u0001\u001a\u00020}8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b~\u0010\u007f¨\u0006\u0084\u0001"}, d2 = {"Lkotlin/reflect/jvm/internal/KClassImpl;", "", "T", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/reflect/KClass;", "Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;", "Lkotlin/reflect/jvm/internal/impl/types/model/TypeConstructorMarker;", "Lkotlin/jvm/internal/KotlinGenericDeclaration;", "Ljava/lang/Class;", "jClass", "<init>", "(Ljava/lang/Class;)V", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "name", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "getProperties", "(Lkotlin/reflect/jvm/internal/impl/name/Name;)Ljava/util/Collection;", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "getFunctions", "", "index", "getLocalPropertyDescriptor", "(I)Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "Lkotlin/reflect/jvm/internal/impl/km/KmProperty;", "getLocalPropertyMetadata", "(I)Lkotlin/reflect/jvm/internal/impl/km/KmProperty;", SDKConstants.PARAM_VALUE, "", "isInstance", "(Ljava/lang/Object;)Z", "Ljava/lang/reflect/GenericDeclaration;", "findJavaDeclaration", "()Ljava/lang/reflect/GenericDeclaration;", "other", "equals", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "scope", "Lkotlin/reflect/jvm/internal/KClassImpl$MemberBelonginess;", "belonginess", "Lkotlin/reflect/jvm/internal/DescriptorKCallable;", "getMembers", "(Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;Lkotlin/reflect/jvm/internal/KClassImpl$MemberBelonginess;)Ljava/util/Collection;", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "classId", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/RuntimeModuleData;", "moduleData", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "createSyntheticClassOrFail", "(Lkotlin/reflect/jvm/internal/impl/name/ClassId;Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/RuntimeModuleData;)Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "createSyntheticClass", "Ljava/lang/Class;", "getJClass", "()Ljava/lang/Class;", "Lkotlin/Lazy;", "Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "data", "Lkotlin/Lazy;", "getData", "()Lkotlin/Lazy;", "Lkotlin/reflect/jvm/internal/impl/km/KmConstructor;", "getConstructorsMetadata", "()Ljava/util/Collection;", "constructorsMetadata", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "constructorDescriptors", "getSimpleName", "simpleName", "getQualifiedName", IntrospectionHelper.AppFunctionSerializableFactoryClass.GetAppFunctionDataBuilder.QUALIFIED_NAME_PARAM_NAME, "Lkotlin/reflect/KFunction;", "getConstructors", "constructors", "", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "()Ljava/util/List;", "typeParameters", "Lkotlin/reflect/jvm/internal/TypeParameterTable;", "getTypeParameterTable$kotlin_reflection", "()Lkotlin/reflect/jvm/internal/TypeParameterTable;", "typeParameterTable", "Lkotlin/reflect/KType;", "getSupertypes", "supertypes", "isFinal", "()Z", "isInner", "isValue", "getInlineClassUnderlyingPropertyName$kotlin_reflection", "inlineClassUnderlyingPropertyName", "getInlineClassUnderlyingType$kotlin_reflection", "()Lkotlin/reflect/KType;", "inlineClassUnderlyingType", "getModuleName$kotlin_reflection", "moduleName", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/km/KmClass;", "getKmClass", "()Lkotlin/metadata/KmClass;", "kmClass", "getClassId", "()Lorg/jetbrains/kotlin/name/ClassId;", "Lkotlin/reflect/jvm/internal/impl/km/ClassKind;", "getClassKind$kotlin_reflection", "()Lkotlin/metadata/ClassKind;", "classKind", "getMemberScope$kotlin_reflection", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "memberScope", "getStaticScope$kotlin_reflection", "staticScope", "Lkotlin/reflect/jvm/internal/impl/km/KmFunction;", "getFunctionsMetadata", "functionsMetadata", "getPropertiesMetadata", "propertiesMetadata", "Lkotlin/reflect/jvm/internal/impl/km/Modality;", "getModality", "()Lkotlin/metadata/Modality;", "modality", "Companion", "Data", "MemberBelonginess", "kotlin-reflection"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class KClassImpl<T> extends KDeclarationContainerImpl implements KotlinGenericDeclaration, KClass<T>, KTypeParameterOwnerImpl, TypeConstructorMarker {
    private static final Set<String> SPECIAL_JVM_ANNOTATION_NAMES;
    private final Lazy<KClassImpl<T>.Data> data;
    private final Class<T> jClass;

    @Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001b\n\u0002\b\n\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\b\u001a\u00020\u00072\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001c\u001a\u00020\u00178FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR!\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\rR\u001d\u0010$\u001a\u0004\u0018\u00010\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0019\u001a\u0004\b\"\u0010#R\u001d\u0010'\u001a\u0004\u0018\u00010\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0019\u001a\u0004\b&\u0010#R-\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000)0(8FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b*\u0010\u0019\u0012\u0004\b-\u0010.\u001a\u0004\b+\u0010,R%\u00103\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003000(8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\u0019\u001a\u0004\b2\u0010,R#\u00108\u001a\u0004\u0018\u00018\u00008FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b4\u0010\u0013\u0012\u0004\b7\u0010.\u001a\u0004\b5\u00106R!\u0010<\u001a\b\u0012\u0004\u0012\u0002090\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b:\u0010\u0019\u001a\u0004\b;\u0010\rR\u001b\u0010A\u001a\u00020=8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b>\u0010\u0019\u001a\u0004\b?\u0010@R!\u0010D\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bB\u0010\u0019\u001a\u0004\bC\u0010\rR)\u0010G\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u0000000\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bE\u0010\u0019\u001a\u0004\bF\u0010\rR\u001d\u0010K\u001a\u0004\u0018\u00010\u000b8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\bH\u0010\u0013\u001a\u0004\bI\u0010JR%\u0010O\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030L0(8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bM\u0010\u0019\u001a\u0004\bN\u0010,R%\u0010R\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030L0(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bP\u0010\u0019\u001a\u0004\bQ\u0010,R%\u0010U\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030L0(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bS\u0010\u0019\u001a\u0004\bT\u0010,R%\u0010X\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030L0(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bV\u0010\u0019\u001a\u0004\bW\u0010,R%\u0010[\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030L0(8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bY\u0010\u0019\u001a\u0004\bZ\u0010,R%\u0010^\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030L0(8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\\\u0010\u0019\u001a\u0004\b]\u0010,R%\u0010a\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030L0(8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b_\u0010\u0019\u001a\u0004\b`\u0010,R%\u0010d\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030L0(8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bb\u0010\u0019\u001a\u0004\bc\u0010,R\u001b\u0010i\u001a\u00020e8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\bf\u0010\u0019\u001a\u0004\bg\u0010hR\u0018\u0010j\u001a\u00020\u000e*\u00020\u001d8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bj\u0010k¨\u0006l"}, d2 = {"Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "<init>", "(Lkotlin/reflect/jvm/internal/KClassImpl;)V", "Ljava/lang/Class;", "jClass", "", "calculateLocalClassName", "(Ljava/lang/Class;)Ljava/lang/String;", "", "Lkotlin/reflect/KType;", "computeLegacySupertypes", "()Ljava/util/List;", "", "useK1ImplementationForFakeOverrides", "()Z", "Lkotlin/reflect/jvm/internal/impl/km/KmClass;", "kmClass$delegate", "Lkotlin/Lazy;", "getKmClass", "()Lkotlin/metadata/KmClass;", "kmClass", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "descriptor", "", "annotations$delegate", "getAnnotations", "annotations", "simpleName$delegate", "getSimpleName", "()Ljava/lang/String;", "simpleName", "qualifiedName$delegate", "getQualifiedName", IntrospectionHelper.AppFunctionSerializableFactoryClass.GetAppFunctionDataBuilder.QUALIFIED_NAME_PARAM_NAME, "", "Lkotlin/reflect/KFunction;", "constructors$delegate", "getConstructors", "()Ljava/util/Collection;", "getConstructors$annotations", "()V", "constructors", "Lkotlin/reflect/KClass;", "nestedClasses$delegate", "getNestedClasses", "nestedClasses", "objectInstance$delegate", "getObjectInstance", "()Ljava/lang/Object;", "getObjectInstance$annotations", "objectInstance", "Lkotlin/reflect/KTypeParameter;", "typeParameters$delegate", "getTypeParameters", "typeParameters", "Lkotlin/reflect/jvm/internal/TypeParameterTable;", "typeParameterTable$delegate", "getTypeParameterTable$kotlin_reflection", "()Lkotlin/reflect/jvm/internal/TypeParameterTable;", "typeParameterTable", "supertypes$delegate", "getSupertypes", "supertypes", "sealedSubclasses$delegate", "getSealedSubclasses", "sealedSubclasses", "inlineClassUnderlyingType$delegate", "getInlineClassUnderlyingType$kotlin_reflection", "()Lkotlin/reflect/KType;", "inlineClassUnderlyingType", "Lkotlin/reflect/jvm/internal/DescriptorKCallable;", "declaredNonStaticMembers$delegate", "getDeclaredNonStaticMembers", "declaredNonStaticMembers", "declaredStaticMembers$delegate", "getDeclaredStaticMembers", "declaredStaticMembers", "inheritedNonStaticMembers_k1Impl$delegate", "getInheritedNonStaticMembers_k1Impl", "inheritedNonStaticMembers_k1Impl", "inheritedStaticMembers_k1Impl$delegate", "getInheritedStaticMembers_k1Impl", "inheritedStaticMembers_k1Impl", "allNonStaticMembers$delegate", "getAllNonStaticMembers", "allNonStaticMembers", "allStaticMembers$delegate", "getAllStaticMembers", "allStaticMembers", "declaredMembers$delegate", "getDeclaredMembers", "declaredMembers", "allMembers$delegate", "getAllMembers", "allMembers", "Lkotlin/reflect/jvm/internal/FakeOverrideMembers;", "fakeOverrideMembers$delegate", "getFakeOverrideMembers$kotlin_reflection", "()Lkotlin/reflect/jvm/internal/FakeOverrideMembers;", "fakeOverrideMembers", "isInheritable", "(Ljava/lang/annotation/Annotation;)Z", "kotlin-reflection"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public final class Data extends KDeclarationContainerImpl.Data {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {new PropertyReference1Impl(Data.class, "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", 0), new PropertyReference1Impl(Data.class, "annotations", "getAnnotations()Ljava/util/List;", 0), new PropertyReference1Impl(Data.class, "simpleName", "getSimpleName()Ljava/lang/String;", 0), new PropertyReference1Impl(Data.class, IntrospectionHelper.AppFunctionSerializableFactoryClass.GetAppFunctionDataBuilder.QUALIFIED_NAME_PARAM_NAME, "getQualifiedName()Ljava/lang/String;", 0), new PropertyReference1Impl(Data.class, "constructors", "getConstructors()Ljava/util/Collection;", 0), new PropertyReference1Impl(Data.class, "nestedClasses", "getNestedClasses()Ljava/util/Collection;", 0), new PropertyReference1Impl(Data.class, "typeParameters", "getTypeParameters()Ljava/util/List;", 0), new PropertyReference1Impl(Data.class, "typeParameterTable", "getTypeParameterTable$kotlin_reflection()Lkotlin/reflect/jvm/internal/TypeParameterTable;", 0), new PropertyReference1Impl(Data.class, "supertypes", "getSupertypes()Ljava/util/List;", 0), new PropertyReference1Impl(Data.class, "sealedSubclasses", "getSealedSubclasses()Ljava/util/List;", 0), new PropertyReference1Impl(Data.class, "declaredNonStaticMembers", "getDeclaredNonStaticMembers()Ljava/util/Collection;", 0), new PropertyReference1Impl(Data.class, "declaredStaticMembers", "getDeclaredStaticMembers()Ljava/util/Collection;", 0), new PropertyReference1Impl(Data.class, "inheritedNonStaticMembers_k1Impl", "getInheritedNonStaticMembers_k1Impl()Ljava/util/Collection;", 0), new PropertyReference1Impl(Data.class, "inheritedStaticMembers_k1Impl", "getInheritedStaticMembers_k1Impl()Ljava/util/Collection;", 0), new PropertyReference1Impl(Data.class, "allNonStaticMembers", "getAllNonStaticMembers()Ljava/util/Collection;", 0), new PropertyReference1Impl(Data.class, "allStaticMembers", "getAllStaticMembers()Ljava/util/Collection;", 0), new PropertyReference1Impl(Data.class, "declaredMembers", "getDeclaredMembers()Ljava/util/Collection;", 0), new PropertyReference1Impl(Data.class, "allMembers", "getAllMembers()Ljava/util/Collection;", 0), new PropertyReference1Impl(Data.class, "fakeOverrideMembers", "getFakeOverrideMembers$kotlin_reflection()Lkotlin/reflect/jvm/internal/FakeOverrideMembers;", 0)};

        /* JADX INFO: renamed from: allMembers$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal allMembers;

        /* JADX INFO: renamed from: allNonStaticMembers$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal allNonStaticMembers;

        /* JADX INFO: renamed from: allStaticMembers$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal allStaticMembers;

        /* JADX INFO: renamed from: annotations$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal annotations;

        /* JADX INFO: renamed from: constructors$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal constructors;

        /* JADX INFO: renamed from: declaredMembers$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal declaredMembers;

        /* JADX INFO: renamed from: declaredNonStaticMembers$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal declaredNonStaticMembers;

        /* JADX INFO: renamed from: declaredStaticMembers$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal declaredStaticMembers;

        /* JADX INFO: renamed from: descriptor$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal descriptor;

        /* JADX INFO: renamed from: fakeOverrideMembers$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal fakeOverrideMembers;

        /* JADX INFO: renamed from: inheritedNonStaticMembers_k1Impl$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal inheritedNonStaticMembers_k1Impl;

        /* JADX INFO: renamed from: inheritedStaticMembers_k1Impl$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal inheritedStaticMembers_k1Impl;

        /* JADX INFO: renamed from: inlineClassUnderlyingType$delegate, reason: from kotlin metadata */
        private final Lazy inlineClassUnderlyingType;

        /* JADX INFO: renamed from: kmClass$delegate, reason: from kotlin metadata */
        private final Lazy kmClass;

        /* JADX INFO: renamed from: nestedClasses$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal nestedClasses;

        /* JADX INFO: renamed from: objectInstance$delegate, reason: from kotlin metadata */
        private final Lazy objectInstance;

        /* JADX INFO: renamed from: qualifiedName$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal qualifiedName;

        /* JADX INFO: renamed from: sealedSubclasses$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal sealedSubclasses;

        /* JADX INFO: renamed from: simpleName$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal simpleName;

        /* JADX INFO: renamed from: supertypes$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal supertypes;

        /* JADX INFO: renamed from: typeParameterTable$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal typeParameterTable;

        /* JADX INFO: renamed from: typeParameters$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal typeParameters;

        public Data() {
            super();
            LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
            this.kmClass = LazyKt.lazy(lazyThreadSafetyMode, new Function0(KClassImpl.this, this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$0
                private final KClassImpl arg$0;
                private final KClassImpl.Data arg$1;

                {
                    this.arg$0 = kClassImpl;
                    this.arg$1 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    return KClassImpl.Data.kmClass_delegate$lambda$0(this.arg$0, this.arg$1);
                }
            });
            this.descriptor = ReflectProperties.lazySoft(new Function0(KClassImpl.this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$1
                private final KClassImpl arg$0;

                {
                    this.arg$0 = kClassImpl;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    return KClassImpl.Data.descriptor_delegate$lambda$0(this.arg$0);
                }
            });
            this.annotations = ReflectProperties.lazySoft(new Function0(KClassImpl.this, this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$2
                private final KClassImpl arg$0;
                private final KClassImpl.Data arg$1;

                {
                    this.arg$0 = kClassImpl;
                    this.arg$1 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    return KClassImpl.Data.annotations_delegate$lambda$0(this.arg$0, this.arg$1);
                }
            });
            this.simpleName = ReflectProperties.lazySoft(new Function0(KClassImpl.this, this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$3
                private final KClassImpl arg$0;
                private final KClassImpl.Data arg$1;

                {
                    this.arg$0 = kClassImpl;
                    this.arg$1 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    return KClassImpl.Data.simpleName_delegate$lambda$0(this.arg$0, this.arg$1);
                }
            });
            this.qualifiedName = ReflectProperties.lazySoft(new Function0(KClassImpl.this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$4
                private final KClassImpl arg$0;

                {
                    this.arg$0 = kClassImpl;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    return KClassImpl.Data.qualifiedName_delegate$lambda$0(this.arg$0);
                }
            });
            this.constructors = ReflectProperties.lazySoft(new Function0(KClassImpl.this, this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$5
                private final KClassImpl arg$0;
                private final KClassImpl.Data arg$1;

                {
                    this.arg$0 = kClassImpl;
                    this.arg$1 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    return KClassImpl.Data.constructors_delegate$lambda$0(this.arg$0, this.arg$1);
                }
            });
            this.nestedClasses = ReflectProperties.lazySoft(new Function0(this, KClassImpl.this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$6
                private final KClassImpl.Data arg$0;
                private final KClassImpl arg$1;

                {
                    this.arg$0 = this;
                    this.arg$1 = kClassImpl;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    return KClassImpl.Data.nestedClasses_delegate$lambda$0(this.arg$0, this.arg$1);
                }
            });
            this.objectInstance = LazyKt.lazy(lazyThreadSafetyMode, new Function0(this, KClassImpl.this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$7
                private final KClassImpl.Data arg$0;
                private final KClassImpl arg$1;

                {
                    this.arg$0 = this;
                    this.arg$1 = kClassImpl;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    return KClassImpl.Data.objectInstance_delegate$lambda$0(this.arg$0, this.arg$1);
                }
            });
            this.typeParameters = ReflectProperties.lazySoft(new Function0(this, KClassImpl.this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$8
                private final KClassImpl.Data arg$0;
                private final KClassImpl arg$1;

                {
                    this.arg$0 = this;
                    this.arg$1 = kClassImpl;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    return KClassImpl.Data.typeParameters_delegate$lambda$0(this.arg$0, this.arg$1);
                }
            });
            this.typeParameterTable = ReflectProperties.lazySoft(new Function0(this, KClassImpl.this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$9
                private final KClassImpl.Data arg$0;
                private final KClassImpl arg$1;

                {
                    this.arg$0 = this;
                    this.arg$1 = kClassImpl;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    return KClassImpl.Data.typeParameterTable_delegate$lambda$0(this.arg$0, this.arg$1);
                }
            });
            this.supertypes = ReflectProperties.lazySoft(new Function0(KClassImpl.this, this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$10
                private final KClassImpl arg$0;
                private final KClassImpl.Data arg$1;

                {
                    this.arg$0 = kClassImpl;
                    this.arg$1 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    return KClassImpl.Data.supertypes_delegate$lambda$0(this.arg$0, this.arg$1);
                }
            });
            this.sealedSubclasses = ReflectProperties.lazySoft(new Function0(KClassImpl.this, this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$11
                private final KClassImpl arg$0;
                private final KClassImpl.Data arg$1;

                {
                    this.arg$0 = kClassImpl;
                    this.arg$1 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    return KClassImpl.Data.sealedSubclasses_delegate$lambda$0(this.arg$0, this.arg$1);
                }
            });
            this.inlineClassUnderlyingType = LazyKt.lazy(lazyThreadSafetyMode, new Function0(this, KClassImpl.this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$12
                private final KClassImpl.Data arg$0;
                private final KClassImpl arg$1;

                {
                    this.arg$0 = this;
                    this.arg$1 = kClassImpl;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    return KClassImpl.Data.inlineClassUnderlyingType_delegate$lambda$0(this.arg$0, this.arg$1);
                }
            });
            this.declaredNonStaticMembers = ReflectProperties.lazySoft(new Function0(KClassImpl.this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$13
                private final KClassImpl arg$0;

                {
                    this.arg$0 = kClassImpl;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    return KClassImpl.Data.declaredNonStaticMembers_delegate$lambda$0(this.arg$0);
                }
            });
            this.declaredStaticMembers = ReflectProperties.lazySoft(new Function0(KClassImpl.this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$14
                private final KClassImpl arg$0;

                {
                    this.arg$0 = kClassImpl;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    return KClassImpl.Data.declaredStaticMembers_delegate$lambda$0(this.arg$0);
                }
            });
            this.inheritedNonStaticMembers_k1Impl = ReflectProperties.lazySoft(new Function0(KClassImpl.this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$15
                private final KClassImpl arg$0;

                {
                    this.arg$0 = kClassImpl;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    return KClassImpl.Data.inheritedNonStaticMembers_k1Impl_delegate$lambda$0(this.arg$0);
                }
            });
            this.inheritedStaticMembers_k1Impl = ReflectProperties.lazySoft(new Function0(KClassImpl.this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$16
                private final KClassImpl arg$0;

                {
                    this.arg$0 = kClassImpl;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    return KClassImpl.Data.inheritedStaticMembers_k1Impl_delegate$lambda$0(this.arg$0);
                }
            });
            this.allNonStaticMembers = ReflectProperties.lazySoft(new Function0(this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$17
                private final KClassImpl.Data arg$0;

                {
                    this.arg$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    return KClassImpl.Data.allNonStaticMembers_delegate$lambda$0(this.arg$0);
                }
            });
            this.allStaticMembers = ReflectProperties.lazySoft(new Function0(this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$18
                private final KClassImpl.Data arg$0;

                {
                    this.arg$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    return KClassImpl.Data.allStaticMembers_delegate$lambda$0(this.arg$0);
                }
            });
            this.declaredMembers = ReflectProperties.lazySoft(new Function0(this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$19
                private final KClassImpl.Data arg$0;

                {
                    this.arg$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    return KClassImpl.Data.declaredMembers_delegate$lambda$0(this.arg$0);
                }
            });
            this.allMembers = ReflectProperties.lazySoft(new Function0(this, KClassImpl.this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$20
                private final KClassImpl.Data arg$0;
                private final KClassImpl arg$1;

                {
                    this.arg$0 = this;
                    this.arg$1 = kClassImpl;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    return KClassImpl.Data.allMembers_delegate$lambda$0(this.arg$0, this.arg$1);
                }
            });
            this.fakeOverrideMembers = ReflectProperties.lazySoft(new Function0(KClassImpl.this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$21
                private final KClassImpl arg$0;

                {
                    this.arg$0 = kClassImpl;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    return FakeOverridesKt.computeFakeOverrideMembers(this.arg$0);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Collection allMembers_delegate$lambda$0(Data data2, KClassImpl kClassImpl) {
            boolean zUseK1ImplementationForFakeOverrides = data2.useK1ImplementationForFakeOverrides();
            if (zUseK1ImplementationForFakeOverrides) {
                return CollectionsKt.plus((Collection) data2.getAllNonStaticMembers(), (Iterable) data2.getAllStaticMembers());
            }
            if (!zUseK1ImplementationForFakeOverrides) {
                return FakeOverridesKt.getAllMembers(kClassImpl);
            }
            Home$$ExternalSyntheticBUOutline0.m();
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List allNonStaticMembers_delegate$lambda$0(Data data2) {
            boolean zUseK1ImplementationForFakeOverrides = data2.useK1ImplementationForFakeOverrides();
            if (zUseK1ImplementationForFakeOverrides) {
                return CollectionsKt.plus((Collection) data2.getDeclaredNonStaticMembers(), (Iterable) data2.getInheritedNonStaticMembers_k1Impl());
            }
            if (zUseK1ImplementationForFakeOverrides) {
                Home$$ExternalSyntheticBUOutline0.m();
                return null;
            }
            Collection<DescriptorKCallable<?>> allMembers = data2.getAllMembers();
            ArrayList arrayList = new ArrayList();
            for (T t : allMembers) {
                if (!FakeOverridesKt.isStatic((DescriptorKCallable) t)) {
                    arrayList.add(t);
                }
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List allStaticMembers_delegate$lambda$0(Data data2) {
            boolean zUseK1ImplementationForFakeOverrides = data2.useK1ImplementationForFakeOverrides();
            if (zUseK1ImplementationForFakeOverrides) {
                return CollectionsKt.plus((Collection) data2.getDeclaredStaticMembers(), (Iterable) data2.getInheritedStaticMembers_k1Impl());
            }
            if (zUseK1ImplementationForFakeOverrides) {
                Home$$ExternalSyntheticBUOutline0.m();
                return null;
            }
            Collection<DescriptorKCallable<?>> allMembers = data2.getAllMembers();
            ArrayList arrayList = new ArrayList();
            for (T t : allMembers) {
                if (FakeOverridesKt.isStatic((DescriptorKCallable) t)) {
                    arrayList.add(t);
                }
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0053  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static final List annotations_delegate$lambda$0(KClassImpl kClassImpl, Data data2) {
            List arrayList;
            Annotation[] annotations = kClassImpl.getJClass().getAnnotations();
            if (annotations.length != kClassImpl.getJClass().getDeclaredAnnotations().length) {
                ArrayList arrayList2 = new ArrayList();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                Class<T> jClass = kClassImpl.getJClass();
                do {
                    Annotation[] declaredAnnotations = jClass.getDeclaredAnnotations();
                    int length = declaredAnnotations.length;
                    while (true) {
                        length--;
                        if (-1 >= length) {
                            break;
                        }
                        Annotation annotation = declaredAnnotations[length];
                        if (!KClassImpl.SPECIAL_JVM_ANNOTATION_NAMES.contains(JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(annotation)).getName())) {
                            if (jClass != kClassImpl.getJClass()) {
                                annotation.getClass();
                                if (data2.isInheritable(annotation)) {
                                    annotation.getClass();
                                    KClass<? extends Annotation> unwrappedAnnotationClass = UtilKt.getUnwrappedAnnotationClass(annotation);
                                    Class cls = (Class) linkedHashMap.get(unwrappedAnnotationClass);
                                    if (cls == null) {
                                        linkedHashMap.put(unwrappedAnnotationClass, jClass);
                                    }
                                    if (cls == null || Intrinsics.areEqual(cls, jClass)) {
                                        arrayList2.add(annotation);
                                    }
                                }
                            }
                        }
                    }
                    jClass = jClass.getSuperclass();
                } while (jClass != null);
                arrayList = CollectionsKt.reversed(arrayList2);
            } else {
                arrayList = new ArrayList();
                for (Annotation annotation2 : annotations) {
                    if (!KClassImpl.SPECIAL_JVM_ANNOTATION_NAMES.contains(JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(annotation2)).getName())) {
                        arrayList.add(annotation2);
                    }
                }
            }
            return UtilKt.unwrapKotlinRepeatableAnnotations(arrayList);
        }

        private final String calculateLocalClassName(Class<?> jClass) {
            String simpleName = jClass.getSimpleName();
            Method enclosingMethod = jClass.getEnclosingMethod();
            if (enclosingMethod != null) {
                return StringsKt__StringsKt.substringAfter$default(simpleName, enclosingMethod.getName() + '$', (String) null, 2, (Object) null);
            }
            Constructor<?> enclosingConstructor = jClass.getEnclosingConstructor();
            if (enclosingConstructor == null) {
                return StringsKt__StringsKt.substringAfter$default(simpleName, '$', (String) null, 2, (Object) null);
            }
            return StringsKt__StringsKt.substringAfter$default(simpleName, enclosingConstructor.getName() + '$', (String) null, 2, (Object) null);
        }

        private final List<KType> computeLegacySupertypes() {
            Collection<KotlinType> collectionMo2511getSupertypes = getDescriptor().getTypeConstructor().mo2511getSupertypes();
            collectionMo2511getSupertypes.getClass();
            ArrayList arrayList = new ArrayList(collectionMo2511getSupertypes.size());
            final KClassImpl<T> kClassImpl = KClassImpl.this;
            for (final KotlinType kotlinType : collectionMo2511getSupertypes) {
                kotlinType.getClass();
                arrayList.add(new DescriptorKType(kotlinType, new Function0(kotlinType, kClassImpl) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$22
                    private final KotlinType arg$0;
                    private final KClassImpl arg$1;

                    {
                        this.arg$0 = kotlinType;
                        this.arg$1 = kClassImpl;
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public Object invoke() {
                        return KClassImpl.Data.computeLegacySupertypes$lambda$0$0(this.arg$0, this.arg$1);
                    }
                }));
            }
            if (!KotlinBuiltIns.isSpecialClassWithNoSupertypes(getDescriptor())) {
                if (arrayList.isEmpty()) {
                    arrayList.add(StandardKTypes.INSTANCE.getANY());
                } else {
                    Iterator<T> it = arrayList.iterator();
                    while (it.hasNext()) {
                        KClassifier classifier = ((KType) it.next()).getClassifier();
                        KClassImpl kClassImpl2 = classifier instanceof KClassImpl ? (KClassImpl) classifier : null;
                        if (kClassImpl2 == null || (kClassImpl2.getClassKind$kotlin_reflection() != ClassKind.INTERFACE && kClassImpl2.getClassKind$kotlin_reflection() != ClassKind.ANNOTATION_CLASS)) {
                            break;
                        }
                    }
                    arrayList.add(StandardKTypes.INSTANCE.getANY());
                }
            }
            return kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.compact(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Type computeLegacySupertypes$lambda$0$0(KotlinType kotlinType, KClassImpl kClassImpl) {
            ClassifierDescriptor classifierDescriptorMo2510getDeclarationDescriptor = kotlinType.getConstructor().mo2510getDeclarationDescriptor();
            if (!(classifierDescriptorMo2510getDeclarationDescriptor instanceof ClassDescriptor)) {
                Events$$ExternalSyntheticBUOutline0.m$1("Supertype not a class: ", classifierDescriptorMo2510getDeclarationDescriptor);
                return null;
            }
            Class<?> javaClass = UtilKt.toJavaClass((ClassDescriptor) classifierDescriptorMo2510getDeclarationDescriptor);
            if (javaClass == null) {
                Events$$ExternalSyntheticBUOutline0.m$4("Unsupported superclass of ", kClassImpl, ": ", classifierDescriptorMo2510getDeclarationDescriptor);
                return null;
            }
            if (Intrinsics.areEqual(kClassImpl.getJClass().getSuperclass(), javaClass)) {
                Type genericSuperclass = kClassImpl.getJClass().getGenericSuperclass();
                genericSuperclass.getClass();
                return genericSuperclass;
            }
            Class<?>[] interfaces = kClassImpl.getJClass().getInterfaces();
            interfaces.getClass();
            int iIndexOf = ArraysKt.indexOf(interfaces, javaClass);
            if (iIndexOf < 0) {
                Events$$ExternalSyntheticBUOutline0.m$4("No superclass of ", kClassImpl, " in Java reflection for ", classifierDescriptorMo2510getDeclarationDescriptor);
                return null;
            }
            Type type = kClassImpl.getJClass().getGenericInterfaces()[iIndexOf];
            type.getClass();
            return type;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List constructors_delegate$lambda$0(KClassImpl kClassImpl, Data data2) {
            if (kClassImpl.getClassKind$kotlin_reflection() == ClassKind.INTERFACE || kClassImpl.getClassKind$kotlin_reflection() == ClassKind.OBJECT || kClassImpl.getClassKind$kotlin_reflection() == ClassKind.COMPANION_OBJECT || kClassImpl.getClassKind$kotlin_reflection() == ClassKind.ENUM_ENTRY) {
                return CollectionsKt.emptyList();
            }
            if (SystemPropertiesKt.getUseK1Implementation() || data2.getKmClass() == null) {
                Collection<ConstructorDescriptor> constructorDescriptors = kClassImpl.getConstructorDescriptors();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(constructorDescriptors, 10));
                Iterator<T> it = constructorDescriptors.iterator();
                while (it.hasNext()) {
                    arrayList.add(new DescriptorKFunction(kClassImpl, (ConstructorDescriptor) it.next(), null, 4, null));
                }
                return arrayList;
            }
            Collection<KmConstructor> constructorsMetadata = kClassImpl.getConstructorsMetadata();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(constructorsMetadata, 10));
            Iterator<T> it2 = constructorsMetadata.iterator();
            while (it2.hasNext()) {
                KotlinKFunction kotlinKFunctionCreateUnboundConstructor = ConvertFromMetadataKt.createUnboundConstructor((KmConstructor) it2.next(), kClassImpl);
                kotlinKFunctionCreateUnboundConstructor.getClass();
                arrayList2.add(kotlinKFunctionCreateUnboundConstructor);
            }
            return arrayList2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List declaredMembers_delegate$lambda$0(Data data2) {
            return CollectionsKt.plus((Collection) data2.getDeclaredNonStaticMembers(), (Iterable) data2.getDeclaredStaticMembers());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Collection declaredNonStaticMembers_delegate$lambda$0(KClassImpl kClassImpl) {
            return kClassImpl.getMembers(kClassImpl.getMemberScope$kotlin_reflection(), MemberBelonginess.DECLARED);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Collection declaredStaticMembers_delegate$lambda$0(KClassImpl kClassImpl) {
            return kClassImpl.getMembers(kClassImpl.getStaticScope$kotlin_reflection(), MemberBelonginess.DECLARED);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final ClassDescriptor descriptor_delegate$lambda$0(KClassImpl kClassImpl) {
            ClassId classId = kClassImpl.getClassId();
            RuntimeModuleData moduleData = kClassImpl.getData().getValue().getModuleData();
            ClassDescriptor classDescriptorDeserializeClass = (classId.isLocal() && kClassImpl.getJClass().isAnnotationPresent(Metadata.class)) ? moduleData.getDeserialization().deserializeClass(classId) : FindClassInModuleKt.findClassAcrossModuleDependencies(moduleData.getModule(), classId);
            return classDescriptorDeserializeClass == null ? kClassImpl.createSyntheticClassOrFail(classId, moduleData) : classDescriptorDeserializeClass;
        }

        private final Collection<DescriptorKCallable<?>> getDeclaredStaticMembers() {
            T value = this.declaredStaticMembers.getValue(this, $$delegatedProperties[11]);
            value.getClass();
            return (Collection) value;
        }

        private final Collection<DescriptorKCallable<?>> getInheritedNonStaticMembers_k1Impl() {
            T value = this.inheritedNonStaticMembers_k1Impl.getValue(this, $$delegatedProperties[12]);
            value.getClass();
            return (Collection) value;
        }

        private final Collection<DescriptorKCallable<?>> getInheritedStaticMembers_k1Impl() {
            T value = this.inheritedStaticMembers_k1Impl.getValue(this, $$delegatedProperties[13]);
            value.getClass();
            return (Collection) value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Collection inheritedNonStaticMembers_k1Impl_delegate$lambda$0(KClassImpl kClassImpl) {
            return kClassImpl.getMembers(kClassImpl.getMemberScope$kotlin_reflection(), MemberBelonginess.INHERITED);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Collection inheritedStaticMembers_k1Impl_delegate$lambda$0(KClassImpl kClassImpl) {
            return kClassImpl.getMembers(kClassImpl.getStaticScope$kotlin_reflection(), MemberBelonginess.INHERITED);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final KType inlineClassUnderlyingType_delegate$lambda$0(Data data2, KClassImpl kClassImpl) {
            KmClass kmClass = data2.getKmClass();
            if (kmClass != null && Attributes.isValue(kmClass)) {
                if (kmClass.getInlineClassUnderlyingType() != null) {
                    KmType inlineClassUnderlyingType = kmClass.getInlineClassUnderlyingType();
                    if (inlineClassUnderlyingType == null) {
                        return null;
                    }
                    ClassLoader classLoader = kClassImpl.getJClass().getClassLoader();
                    classLoader.getClass();
                    return ConvertFromMetadataKt.toKType$default(inlineClassUnderlyingType, classLoader, data2.getTypeParameterTable$kotlin_reflection(), null, 4, null);
                }
                boolean z = false;
                KmProperty kmProperty = null;
                for (T t : kmClass.getProperties()) {
                    KmProperty kmProperty2 = (KmProperty) t;
                    if (Intrinsics.areEqual(kmProperty2.getName(), kmClass.getInlineClassUnderlyingPropertyName()) && kmProperty2.getContextParameters().isEmpty() && kmProperty2.getReceiverParameterType() == null) {
                        if (z) {
                            Utf8$$ExternalSyntheticBUOutline0.m$2("Collection contains more than one matching element.");
                            return null;
                        }
                        z = true;
                        kmProperty = t;
                    }
                }
                if (z) {
                    KmType returnType = kmProperty.getReturnType();
                    ClassLoader classLoader2 = kClassImpl.getJClass().getClassLoader();
                    classLoader2.getClass();
                    return ConvertFromMetadataKt.toKType$default(returnType, classLoader2, data2.getTypeParameterTable$kotlin_reflection(), null, 4, null);
                }
                Events$$ExternalSyntheticBUOutline0.m$1("Collection contains no element matching the predicate.");
            }
            return null;
        }

        private final boolean isInheritable(Annotation annotation) {
            return UtilKt.hasInherited(annotation) && !UtilKt.isRepeatableContainerForNonInheritedAnnotation(annotation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final KmClass kmClass_delegate$lambda$0(KClassImpl kClassImpl, Data data2) {
            if (SystemPropertiesKt.getLoadMetadataDirectly()) {
                Metadata metadata = (Metadata) kClassImpl.getJClass().getAnnotation(Metadata.class);
                if (metadata != null) {
                    KotlinClassMetadata lenient = KotlinClassMetadata.Companion.readLenient(metadata);
                    KotlinClassMetadata.Class r8 = lenient instanceof KotlinClassMetadata.Class ? (KotlinClassMetadata.Class) lenient : null;
                    if (r8 != null) {
                        return r8.getKmClass();
                    }
                }
                return null;
            }
            ClassDescriptor descriptor = data2.getDescriptor();
            if (!(descriptor instanceof FunctionClassDescriptor)) {
                DeserializedClassDescriptor deserializedClassDescriptor = descriptor instanceof DeserializedClassDescriptor ? (DeserializedClassDescriptor) descriptor : null;
                if (deserializedClassDescriptor != null) {
                    return ReadersKt.toKmClass$default(deserializedClassDescriptor.getClassProto(), deserializedClassDescriptor.getC().getNameResolver(), false, null, 6, null);
                }
                return null;
            }
            FunctionClassDescriptor functionClassDescriptor = (FunctionClassDescriptor) descriptor;
            if (functionClassDescriptor.getFunctionTypeKind() instanceof FunctionTypeKind.Function) {
                return BuiltinsKt.createFunctionKmClass(functionClassDescriptor.getArity());
            }
            Events$$ExternalSyntheticBUOutline0.m$3("Unsupported function type kind: ", functionClassDescriptor.getFunctionTypeKind(), " (", descriptor);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List nestedClasses_delegate$lambda$0(Data data2, KClassImpl kClassImpl) {
            KmClass kmClass = data2.getKmClass();
            if (kmClass == null) {
                Class<?>[] declaredClasses = kClassImpl.getJClass().getDeclaredClasses();
                declaredClasses.getClass();
                ArrayList arrayList = new ArrayList();
                for (Class<?> cls : declaredClasses) {
                    cls.getClass();
                    KClass kotlinClass = JvmClassMappingKt.getKotlinClass(cls);
                    if (kotlinClass != null) {
                        arrayList.add(kotlinClass);
                    }
                }
                return arrayList;
            }
            ClassId classId = ConvertFromMetadataKt.toClassId(kmClass.getName());
            ClassLoader safeClassLoader = ReflectClassUtilKt.getSafeClassLoader(kClassImpl.getJClass());
            List<String> nestedClasses = kmClass.getNestedClasses();
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it = nestedClasses.iterator();
            while (it.hasNext()) {
                Name nameIdentifier = Name.identifier((String) it.next());
                nameIdentifier.getClass();
                Class clsLoadClass$default = UtilKt.loadClass$default(safeClassLoader, classId.createNestedClassId(nameIdentifier), 0, 2, null);
                KClass kotlinClass2 = clsLoadClass$default != null ? JvmClassMappingKt.getKotlinClass(clsLoadClass$default) : null;
                if (kotlinClass2 != null) {
                    arrayList2.add(kotlinClass2);
                }
            }
            return arrayList2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Object objectInstance_delegate$lambda$0(Data data2, KClassImpl kClassImpl) throws IllegalAccessException {
            KmClass kmClass = data2.getKmClass();
            if (kmClass == null || !(Attributes.getKind(kmClass) == ClassKind.OBJECT || Attributes.getKind(kmClass) == ClassKind.COMPANION_OBJECT)) {
                return null;
            }
            Object obj = ((Attributes.getKind(kmClass) != ClassKind.COMPANION_OBJECT || CollectionsKt.contains(CompanionObjectMapping.INSTANCE.getClassIds(), ConvertFromMetadataKt.toClassId(kmClass.getName()).getOuterClassId())) ? kClassImpl.getJClass().getDeclaredField("INSTANCE") : kClassImpl.getJClass().getEnclosingClass().getDeclaredField(ConvertFromMetadataKt.toNonLocalSimpleName(kmClass.getName()))).get(null);
            obj.getClass();
            return obj;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String qualifiedName_delegate$lambda$0(KClassImpl kClassImpl) {
            if (kClassImpl.getJClass().isAnonymousClass()) {
                return null;
            }
            ClassId classId = kClassImpl.getClassId();
            if (classId.isLocal()) {
                return null;
            }
            return classId.asSingleFqName().asString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List sealedSubclasses_delegate$lambda$0(KClassImpl kClassImpl, Data data2) throws IllegalAccessException, InvocationTargetException {
            List listEmptyList;
            ClassLoader safeClassLoader = ReflectClassUtilKt.getSafeClassLoader(kClassImpl.getJClass());
            KmClass kmClass = data2.getKmClass();
            if (kmClass != null) {
                List<String> sealedSubclasses = kmClass.getSealedSubclasses();
                listEmptyList = new ArrayList();
                Iterator<T> it = sealedSubclasses.iterator();
                while (it.hasNext()) {
                    KClass<?> kClassLoadKClass = ConvertFromMetadataKt.loadKClass(safeClassLoader, (String) it.next());
                    if (kClassLoadKClass != null) {
                        listEmptyList.add(kClassLoadKClass);
                    }
                }
            } else {
                Java16SealedRecordLoader java16SealedRecordLoader = Java16SealedRecordLoader.INSTANCE;
                if (Intrinsics.areEqual(java16SealedRecordLoader.loadIsSealed(kClassImpl.getJClass()), Boolean.TRUE)) {
                    Class<?>[] clsArrLoadGetPermittedSubclasses = java16SealedRecordLoader.loadGetPermittedSubclasses(kClassImpl.getJClass());
                    if (clsArrLoadGetPermittedSubclasses != null) {
                        listEmptyList = new ArrayList(clsArrLoadGetPermittedSubclasses.length);
                        for (Class<?> cls : clsArrLoadGetPermittedSubclasses) {
                            listEmptyList.add(JvmClassMappingKt.getKotlinClass(cls));
                        }
                    } else {
                        listEmptyList = null;
                    }
                    if (listEmptyList == null) {
                        listEmptyList = CollectionsKt.emptyList();
                    }
                } else {
                    listEmptyList = CollectionsKt.emptyList();
                }
            }
            listEmptyList.getClass();
            return listEmptyList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String simpleName_delegate$lambda$0(KClassImpl kClassImpl, Data data2) {
            if (kClassImpl.getJClass().isAnonymousClass()) {
                return null;
            }
            ClassId classId = kClassImpl.getClassId();
            if (classId.isLocal()) {
                return data2.calculateLocalClassName(kClassImpl.getJClass());
            }
            String strAsString = classId.getShortClassName().asString();
            strAsString.getClass();
            return strAsString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List supertypes_delegate$lambda$0(final KClassImpl kClassImpl, Data data2) {
            String qualifiedName;
            String name;
            final ClassId classId;
            if (Intrinsics.areEqual(kClassImpl.getJClass(), Object.class)) {
                return CollectionsKt.emptyList();
            }
            if (SystemPropertiesKt.getUseK1Implementation()) {
                return data2.computeLegacySupertypes();
            }
            ArrayList arrayList = new ArrayList();
            KmClass kmClass = data2.getKmClass();
            List<KmType> supertypes = kmClass != null ? kmClass.getSupertypes() : null;
            if (supertypes != null) {
                for (KmType kmType : supertypes) {
                    KmClassifier classifier = kmType.getClassifier();
                    KmClassifier.Class r5 = classifier instanceof KmClassifier.Class ? (KmClassifier.Class) classifier : null;
                    if (r5 == null || (name = r5.getName()) == null || (classId = ConvertFromMetadataKt.toClassId(name)) == null) {
                        StringBuilder sb = new StringBuilder("Supertype of ");
                        sb.append(kClassImpl);
                        KmClassifier classifier2 = kmType.getClassifier();
                        sb.append(" not a class: ");
                        sb.append(classifier2);
                        throw new KotlinReflectionInternalError(sb.toString());
                    }
                    final Class clsLoadClass$default = UtilKt.loadClass$default(ReflectClassUtilKt.getSafeClassLoader(kClassImpl.getJClass()), classId, 0, 2, null);
                    if (clsLoadClass$default == null) {
                        Events$$ExternalSyntheticBUOutline0.m$4("Unsupported superclass of ", kClassImpl, ": ", classId);
                        return null;
                    }
                    arrayList.add(ConvertFromMetadataKt.toKType(kmType, ReflectClassUtilKt.getSafeClassLoader(kClassImpl.getJClass()), data2.getTypeParameterTable$kotlin_reflection(), new Function0(kClassImpl, clsLoadClass$default, classId) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$23
                        private final KClassImpl arg$0;
                        private final Class arg$1;
                        private final ClassId arg$2;

                        {
                            this.arg$0 = kClassImpl;
                            this.arg$1 = clsLoadClass$default;
                            this.arg$2 = classId;
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public Object invoke() {
                            return KClassImpl.Data.supertypes_delegate$lambda$0$0$0(this.arg$0, this.arg$1, this.arg$2);
                        }
                    }));
                }
                if (kClassImpl.getJClass().isArray()) {
                    arrayList.add(StandardKTypes.INSTANCE.getCLONEABLE());
                }
                if (Serializable.class.isAssignableFrom(kClassImpl.getJClass())) {
                    StandardKTypes standardKTypes = StandardKTypes.INSTANCE;
                    if (!arrayList.contains(standardKTypes.getSERIALIZABLE()) && (qualifiedName = data2.getQualifiedName()) != null && StringsKt.startsWith$default(qualifiedName, "kotlin.")) {
                        arrayList.add(standardKTypes.getSERIALIZABLE());
                    }
                }
            } else {
                Type genericSuperclass = kClassImpl.getJClass().getGenericSuperclass();
                if (genericSuperclass != null) {
                    Type type = !Intrinsics.areEqual(genericSuperclass, Object.class) ? genericSuperclass : null;
                    if (type != null) {
                        arrayList.add(ConvertFromJavaKt.toKType$default(type, MapsKt.emptyMap(), TypeNullability.NOT_NULL, false, 4, null));
                    }
                }
                Type[] genericInterfaces = kClassImpl.getJClass().getGenericInterfaces();
                genericInterfaces.getClass();
                for (Type type2 : genericInterfaces) {
                    type2.getClass();
                    arrayList.add(ConvertFromJavaKt.toKType$default(type2, MapsKt.emptyMap(), TypeNullability.NOT_NULL, false, 4, null));
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.add(StandardKTypes.INSTANCE.getANY());
            } else {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    KClassifier classifier3 = ((KType) it.next()).getClassifier();
                    KClassImpl kClassImpl2 = classifier3 instanceof KClassImpl ? (KClassImpl) classifier3 : null;
                    if (kClassImpl2 == null || (kClassImpl2.getClassKind$kotlin_reflection() != ClassKind.INTERFACE && kClassImpl2.getClassKind$kotlin_reflection() != ClassKind.ANNOTATION_CLASS)) {
                        break;
                    }
                }
                arrayList.add(StandardKTypes.INSTANCE.getANY());
            }
            return kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.compact(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Type supertypes_delegate$lambda$0$0$0(KClassImpl kClassImpl, Class cls, ClassId classId) {
            if (Intrinsics.areEqual(kClassImpl.getJClass().getSuperclass(), cls)) {
                Type genericSuperclass = kClassImpl.getJClass().getGenericSuperclass();
                genericSuperclass.getClass();
                return genericSuperclass;
            }
            Class<?>[] interfaces = kClassImpl.getJClass().getInterfaces();
            interfaces.getClass();
            int iIndexOf = ArraysKt.indexOf(interfaces, cls);
            if (iIndexOf < 0) {
                Events$$ExternalSyntheticBUOutline0.m$4("No superclass of ", kClassImpl, " in Java reflection for ", classId);
                return null;
            }
            Type type = kClassImpl.getJClass().getGenericInterfaces()[iIndexOf];
            type.getClass();
            return type;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static final TypeParameterTable typeParameterTable_delegate$lambda$0(Data data2, KClassImpl kClassImpl) {
            KClass kotlinClass;
            Lazy<KClassImpl<T>.Data> data3;
            KClassImpl<T>.Data value;
            if (data2.getKmClass() == null) {
                return TypeParameterTable.EMPTY;
            }
            TypeParameterTable.Companion companion = TypeParameterTable.INSTANCE;
            KmClass kmClass = data2.getKmClass();
            kmClass.getClass();
            List<KmTypeParameter> typeParameters = kmClass.getTypeParameters();
            Class<?> enclosingClass = kClassImpl.getJClass().getEnclosingClass();
            TypeParameterTable typeParameterTable$kotlin_reflection = null;
            if (enclosingClass != null) {
                KmClass kmClass2 = data2.getKmClass();
                kmClass2.getClass();
                if (!Attributes.isInner(kmClass2)) {
                    enclosingClass = null;
                }
                kotlinClass = enclosingClass != null ? JvmClassMappingKt.getKotlinClass(enclosingClass) : null;
            }
            KClassImpl kClassImpl2 = kotlinClass instanceof KClassImpl ? (KClassImpl) kotlinClass : null;
            if (kClassImpl2 != null && (data3 = kClassImpl2.getData()) != null && (value = data3.getValue()) != null) {
                typeParameterTable$kotlin_reflection = value.getTypeParameterTable$kotlin_reflection();
            }
            return companion.create(typeParameters, typeParameterTable$kotlin_reflection, kClassImpl, ReflectClassUtilKt.getSafeClassLoader(kClassImpl.getJClass()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List typeParameters_delegate$lambda$0(Data data2, KClassImpl kClassImpl) {
            if (!SystemPropertiesKt.getUseK1Implementation()) {
                if (data2.getKmClass() != null) {
                    return data2.getTypeParameterTable$kotlin_reflection().getOwnTypeParameters();
                }
                TypeVariable<Class<T>>[] typeParameters = kClassImpl.getJClass().getTypeParameters();
                typeParameters.getClass();
                return ConvertFromJavaKt.toKTypeParameters(typeParameters);
            }
            List<TypeParameterDescriptor> declaredTypeParameters = data2.getDescriptor().getDeclaredTypeParameters();
            declaredTypeParameters.getClass();
            List<TypeParameterDescriptor> list = declaredTypeParameters;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (TypeParameterDescriptor typeParameterDescriptor : list) {
                typeParameterDescriptor.getClass();
                arrayList.add(new KTypeParameterImpl(kClassImpl, typeParameterDescriptor, (KTypeSubstitutor) null, 4, (DefaultConstructorMarker) null));
            }
            return arrayList;
        }

        private final boolean useK1ImplementationForFakeOverrides() {
            return !SystemPropertiesKt.getNewFakeOverridesImplementation() || SystemPropertiesKt.getUseK1Implementation() || KClasses.isSubclassOf(KClassImpl.this, Reflection.getOrCreateKotlinClass(Iterable.class)) || KClasses.isSubclassOf(KClassImpl.this, Reflection.getOrCreateKotlinClass(Map.class)) || KClasses.isSubclassOf(KClassImpl.this, Reflection.getOrCreateKotlinClass(CharSequence.class)) || KClasses.isSubclassOf(KClassImpl.this, Reflection.getOrCreateKotlinClass(Number.class));
        }

        public final Collection<DescriptorKCallable<?>> getAllMembers() {
            T value = this.allMembers.getValue(this, $$delegatedProperties[17]);
            value.getClass();
            return (Collection) value;
        }

        public final Collection<DescriptorKCallable<?>> getAllNonStaticMembers() {
            T value = this.allNonStaticMembers.getValue(this, $$delegatedProperties[14]);
            value.getClass();
            return (Collection) value;
        }

        public final Collection<DescriptorKCallable<?>> getAllStaticMembers() {
            T value = this.allStaticMembers.getValue(this, $$delegatedProperties[15]);
            value.getClass();
            return (Collection) value;
        }

        public final Collection<KFunction<T>> getConstructors() {
            T value = this.constructors.getValue(this, $$delegatedProperties[4]);
            value.getClass();
            return (Collection) value;
        }

        public final Collection<DescriptorKCallable<?>> getDeclaredMembers() {
            T value = this.declaredMembers.getValue(this, $$delegatedProperties[16]);
            value.getClass();
            return (Collection) value;
        }

        public final Collection<DescriptorKCallable<?>> getDeclaredNonStaticMembers() {
            T value = this.declaredNonStaticMembers.getValue(this, $$delegatedProperties[10]);
            value.getClass();
            return (Collection) value;
        }

        public final ClassDescriptor getDescriptor() {
            T value = this.descriptor.getValue(this, $$delegatedProperties[0]);
            value.getClass();
            return (ClassDescriptor) value;
        }

        public final FakeOverrideMembers getFakeOverrideMembers$kotlin_reflection() {
            T value = this.fakeOverrideMembers.getValue(this, $$delegatedProperties[18]);
            value.getClass();
            return (FakeOverrideMembers) value;
        }

        public final KType getInlineClassUnderlyingType$kotlin_reflection() {
            return (KType) this.inlineClassUnderlyingType.getValue();
        }

        public final KmClass getKmClass() {
            return (KmClass) this.kmClass.getValue();
        }

        public final String getQualifiedName() {
            return (String) this.qualifiedName.getValue(this, $$delegatedProperties[3]);
        }

        public final String getSimpleName() {
            return (String) this.simpleName.getValue(this, $$delegatedProperties[2]);
        }

        public final List<KType> getSupertypes() {
            T value = this.supertypes.getValue(this, $$delegatedProperties[8]);
            value.getClass();
            return (List) value;
        }

        public final TypeParameterTable getTypeParameterTable$kotlin_reflection() {
            T value = this.typeParameterTable.getValue(this, $$delegatedProperties[7]);
            value.getClass();
            return (TypeParameterTable) value;
        }

        public final List<KTypeParameter> getTypeParameters() {
            T value = this.typeParameters.getValue(this, $$delegatedProperties[6]);
            value.getClass();
            return (List) value;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tj\u0002\b\u0004j\u0002\b\u0005¨\u0006\n"}, d2 = {"Lkotlin/reflect/jvm/internal/KClassImpl$MemberBelonginess;", "", "<init>", "(Ljava/lang/String;I)V", "DECLARED", "INHERITED", "accept", "", "member", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "kotlin-reflection"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class MemberBelonginess {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ MemberBelonginess[] $VALUES;
        public static final MemberBelonginess DECLARED = new MemberBelonginess("DECLARED", 0);
        public static final MemberBelonginess INHERITED = new MemberBelonginess("INHERITED", 1);

        private static final /* synthetic */ MemberBelonginess[] $values() {
            return new MemberBelonginess[]{DECLARED, INHERITED};
        }

        static {
            MemberBelonginess[] memberBelonginessArr$values = $values();
            $VALUES = memberBelonginessArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(memberBelonginessArr$values);
        }

        private MemberBelonginess(String str, int i) {
        }

        public static MemberBelonginess valueOf(String str) {
            return (MemberBelonginess) Enum.valueOf(MemberBelonginess.class, str);
        }

        public static MemberBelonginess[] values() {
            return (MemberBelonginess[]) $VALUES.clone();
        }

        public final boolean accept(CallableMemberDescriptor member) {
            member.getClass();
            return member.getKind().isReal() == (this == DECLARED);
        }
    }

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KotlinClassHeader.Kind.values().length];
            try {
                iArr[KotlinClassHeader.Kind.FILE_FACADE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KotlinClassHeader.Kind.MULTIFILE_CLASS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KotlinClassHeader.Kind.MULTIFILE_CLASS_PART.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[KotlinClassHeader.Kind.SYNTHETIC_CLASS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[KotlinClassHeader.Kind.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[KotlinClassHeader.Kind.CLASS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        Set<ClassId> special_annotations = SpecialJvmAnnotations.INSTANCE.getSPECIAL_ANNOTATIONS();
        HashSet hashSet = new HashSet();
        Iterator<T> it = special_annotations.iterator();
        while (it.hasNext()) {
            hashSet.add(((ClassId) it.next()).asSingleFqName().toString());
        }
        SPECIAL_JVM_ANNOTATION_NAMES = hashSet;
    }

    public KClassImpl(Class<T> cls) {
        cls.getClass();
        this.jClass = cls;
        this.data = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0(this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$$Lambda$0
            private final KClassImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return KClassImpl.data$lambda$0(this.arg$0);
            }
        });
    }

    private final ClassDescriptor createSyntheticClass(ClassId classId, RuntimeModuleData moduleData) {
        final ClassDescriptorImpl classDescriptorImpl = new ClassDescriptorImpl(new EmptyPackageFragmentDescriptor(moduleData.getModule(), classId.getPackageFqName()), classId.getShortClassName(), Modality.FINAL, kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.CLASS, CollectionsKt.listOf(moduleData.getModule().getBuiltIns().getAny().getDefaultType()), SourceElement.NO_SOURCE, false, moduleData.getDeserialization().getStorageManager());
        final StorageManager storageManager = moduleData.getDeserialization().getStorageManager();
        classDescriptorImpl.initialize(new GivenFunctionsMemberScope(classDescriptorImpl, storageManager) { // from class: kotlin.reflect.jvm.internal.KClassImpl$createSyntheticClass$1$1
            @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope
            public List<FunctionDescriptor> computeDeclaredFunctions() {
                return CollectionsKt.emptyList();
            }
        }, SetsKt.emptySet(), null);
        return classDescriptorImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClassDescriptor createSyntheticClassOrFail(ClassId classId, RuntimeModuleData moduleData) {
        KotlinClassHeader classHeader;
        if (getJClass().isSynthetic()) {
            return createSyntheticClass(classId, moduleData);
        }
        ReflectKotlinClass reflectKotlinClassCreate = ReflectKotlinClass.Factory.create(getJClass());
        KotlinClassHeader.Kind kind = (reflectKotlinClassCreate == null || (classHeader = reflectKotlinClassCreate.getClassHeader()) == null) ? null : classHeader.getKind();
        switch (kind == null ? -1 : WhenMappings.$EnumSwitchMapping$0[kind.ordinal()]) {
            case -1:
            case 6:
                Events$$ExternalSyntheticBUOutline0.m$3("Unresolved class: ", getJClass(), " (kind = ", kind);
                return null;
            case 0:
            default:
                Home$$ExternalSyntheticBUOutline0.m();
                return null;
            case 1:
            case 2:
            case 3:
            case 4:
                return createSyntheticClass(classId, moduleData);
            case 5:
                Events$$ExternalSyntheticBUOutline0.m$3("Unknown class: ", getJClass(), " (kind = ", kind);
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Data data$lambda$0(KClassImpl kClassImpl) {
        return new Data();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClassId getClassId() {
        return RuntimeTypeMapper.INSTANCE.mapJvmClassToKotlinClassId(getJClass());
    }

    private final KmClass getKmClass() {
        return this.data.getValue().getKmClass();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PropertyDescriptor getLocalPropertyDescriptor$lambda$0$0$0(MemberDeserializer memberDeserializer, ProtoBuf$Property protoBuf$Property) {
        memberDeserializer.getClass();
        protoBuf$Property.getClass();
        return memberDeserializer.loadProperty(protoBuf$Property, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Collection<DescriptorKCallable<?>> getMembers(MemberScope scope, MemberBelonginess belonginess) {
        DescriptorKCallable descriptorKCallable;
        CreateKCallableVisitor createKCallableVisitor = new CreateKCallableVisitor(this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$getMembers$visitor$1
            {
                super(this);
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorVisitorEmptyBodies, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
            public DescriptorKCallable<?> visitConstructorDescriptor(ConstructorDescriptor constructorDescriptor, Unit unit) {
                constructorDescriptor.getClass();
                unit.getClass();
                throw new IllegalStateException("No constructors should appear here: " + constructorDescriptor);
            }
        };
        Collection<DeclarationDescriptor> contributedDescriptors$default = ResolutionScope.DefaultImpls.getContributedDescriptors$default(scope, null, null, 3, null);
        ArrayList arrayList = new ArrayList();
        for (DeclarationDescriptor declarationDescriptor : contributedDescriptors$default) {
            if (declarationDescriptor instanceof CallableMemberDescriptor) {
                CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor) declarationDescriptor;
                descriptorKCallable = (Intrinsics.areEqual(callableMemberDescriptor.getVisibility(), DescriptorVisibilities.INVISIBLE_FAKE) || !belonginess.accept(callableMemberDescriptor)) ? null : (DescriptorKCallable) declarationDescriptor.accept(createKCallableVisitor, Unit.INSTANCE);
            }
            if (descriptorKCallable != null) {
                arrayList.add(descriptorKCallable);
            }
        }
        return CollectionsKt.toList(arrayList);
    }

    private final kotlin.reflect.jvm.internal.impl.km.Modality getModality() {
        kotlin.reflect.jvm.internal.impl.km.Modality modality;
        KmClass kmClass = getKmClass();
        return (kmClass == null || (modality = Attributes.getModality(kmClass)) == null) ? (getJClass().isAnnotation() || getJClass().isEnum()) ? kotlin.reflect.jvm.internal.impl.km.Modality.FINAL : Intrinsics.areEqual(Java16SealedRecordLoader.INSTANCE.loadIsSealed(getJClass()), Boolean.TRUE) ? kotlin.reflect.jvm.internal.impl.km.Modality.SEALED : Modifier.isAbstract(getJClass().getModifiers()) ? kotlin.reflect.jvm.internal.impl.km.Modality.ABSTRACT : !Modifier.isFinal(getJClass().getModifiers()) ? kotlin.reflect.jvm.internal.impl.km.Modality.OPEN : kotlin.reflect.jvm.internal.impl.km.Modality.FINAL : modality;
    }

    public boolean equals(Object other) {
        return (other instanceof KClassImpl) && Intrinsics.areEqual(JvmClassMappingKt.getJavaObjectType(this), JvmClassMappingKt.getJavaObjectType((KClass) other));
    }

    @Override // kotlin.jvm.internal.KotlinGenericDeclaration
    public GenericDeclaration findJavaDeclaration() {
        return getJClass();
    }

    public final ClassKind getClassKind$kotlin_reflection() {
        ClassKind kind;
        KmClass kmClass = getKmClass();
        return (kmClass == null || (kind = Attributes.getKind(kmClass)) == null) ? getJClass().isAnnotation() ? ClassKind.ANNOTATION_CLASS : getJClass().isInterface() ? ClassKind.INTERFACE : getJClass().isEnum() ? ClassKind.ENUM_CLASS : getJClass().getSuperclass().isEnum() ? ClassKind.ENUM_ENTRY : ClassKind.CLASS : kind;
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public Collection<ConstructorDescriptor> getConstructorDescriptors() {
        Collection<ClassConstructorDescriptor> constructors = getDescriptor().getConstructors();
        constructors.getClass();
        return constructors;
    }

    @Override // kotlin.reflect.KClass
    public Collection<KFunction<T>> getConstructors() {
        return this.data.getValue().getConstructors();
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public Collection<KmConstructor> getConstructorsMetadata() {
        KmClass kmClass = getKmClass();
        List<KmConstructor> constructors = kmClass != null ? kmClass.getConstructors() : null;
        if (constructors == null) {
            constructors = CollectionsKt.emptyList();
        }
        return constructors;
    }

    public final Lazy<KClassImpl<T>.Data> getData() {
        return this.data;
    }

    public final ClassDescriptor getDescriptor() {
        return this.data.getValue().getDescriptor();
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public Collection<FunctionDescriptor> getFunctions(Name name) {
        name.getClass();
        MemberScope memberScope$kotlin_reflection = getMemberScope$kotlin_reflection();
        NoLookupLocation noLookupLocation = NoLookupLocation.FROM_REFLECTION;
        return CollectionsKt.plus((Collection) memberScope$kotlin_reflection.getContributedFunctions(name, noLookupLocation), (Iterable) getStaticScope$kotlin_reflection().getContributedFunctions(name, noLookupLocation));
    }

    public final String getInlineClassUnderlyingPropertyName$kotlin_reflection() {
        KmClass kmClass = getKmClass();
        if (kmClass != null) {
            return kmClass.getInlineClassUnderlyingPropertyName();
        }
        return null;
    }

    public final KType getInlineClassUnderlyingType$kotlin_reflection() {
        return this.data.getValue().getInlineClassUnderlyingType$kotlin_reflection();
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    public Class<T> getJClass() {
        return this.jClass;
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public PropertyDescriptor getLocalPropertyDescriptor(int index) {
        ClassDescriptor descriptor = getDescriptor();
        DeserializedClassDescriptor deserializedClassDescriptor = descriptor instanceof DeserializedClassDescriptor ? (DeserializedClassDescriptor) descriptor : null;
        if (deserializedClassDescriptor != null) {
            ProtoBuf$Class classProto = deserializedClassDescriptor.getClassProto();
            GeneratedMessageLite.GeneratedExtension<ProtoBuf$Class, List<ProtoBuf$Property>> generatedExtension = JvmProtoBuf.classLocalVariable;
            generatedExtension.getClass();
            ProtoBuf$Property protoBuf$Property = (ProtoBuf$Property) ProtoBufUtilKt.getExtensionOrNull(classProto, generatedExtension, index);
            if (protoBuf$Property != null) {
                return (PropertyDescriptor) UtilKt.deserializeToDescriptor(getJClass(), new LocalDelegatedPropertyFakeContainerSource(this), protoBuf$Property, deserializedClassDescriptor.getC().getNameResolver(), deserializedClassDescriptor.getC().getTypeTable(), deserializedClassDescriptor.getMetadataVersion(), new Function2() { // from class: kotlin.reflect.jvm.internal.KClassImpl$$Lambda$1
                    @Override // kotlin.jvm.functions.Function2
                    public Object invoke(Object obj, Object obj2) {
                        return KClassImpl.getLocalPropertyDescriptor$lambda$0$0$0((MemberDeserializer) obj, (ProtoBuf$Property) obj2);
                    }
                });
            }
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public KmProperty getLocalPropertyMetadata(int index) {
        List<KmProperty> localDelegatedProperties;
        KmClass kmClass = getKmClass();
        if (kmClass == null || (localDelegatedProperties = JvmExtensionsKt.getLocalDelegatedProperties(kmClass)) == null) {
            return null;
        }
        return (KmProperty) CollectionsKt.getOrNull(localDelegatedProperties, index);
    }

    public final MemberScope getMemberScope$kotlin_reflection() {
        return getDescriptor().getDefaultType().getMemberScope();
    }

    public final String getModuleName$kotlin_reflection() {
        KmClass kmClass = getKmClass();
        if (kmClass != null) {
            return JvmExtensionsKt.getModuleName(kmClass);
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public Collection<PropertyDescriptor> getProperties(Name name) {
        name.getClass();
        MemberScope memberScope$kotlin_reflection = getMemberScope$kotlin_reflection();
        NoLookupLocation noLookupLocation = NoLookupLocation.FROM_REFLECTION;
        return CollectionsKt.plus((Collection) memberScope$kotlin_reflection.getContributedVariables(name, noLookupLocation), (Iterable) getStaticScope$kotlin_reflection().getContributedVariables(name, noLookupLocation));
    }

    @Override // kotlin.reflect.KClass
    public String getQualifiedName() {
        return this.data.getValue().getQualifiedName();
    }

    @Override // kotlin.reflect.KClass
    public String getSimpleName() {
        return this.data.getValue().getSimpleName();
    }

    public final MemberScope getStaticScope$kotlin_reflection() {
        MemberScope staticScope = getDescriptor().getStaticScope();
        staticScope.getClass();
        return staticScope;
    }

    @Override // kotlin.reflect.KClass
    public List<KType> getSupertypes() {
        return this.data.getValue().getSupertypes();
    }

    public final TypeParameterTable getTypeParameterTable$kotlin_reflection() {
        return this.data.getValue().getTypeParameterTable$kotlin_reflection();
    }

    @Override // kotlin.reflect.KClass
    public List<KTypeParameter> getTypeParameters() {
        return this.data.getValue().getTypeParameters();
    }

    @Override // kotlin.reflect.KClass
    public int hashCode() {
        return JvmClassMappingKt.getJavaObjectType(this).hashCode();
    }

    public boolean isFinal() {
        return getModality() == kotlin.reflect.jvm.internal.impl.km.Modality.FINAL;
    }

    @Override // kotlin.reflect.KClass
    public boolean isInner() {
        KmClass kmClass = getKmClass();
        return kmClass == null ? (getJClass().getDeclaringClass() == null || Modifier.isStatic(getJClass().getModifiers())) ? false : true : Attributes.isInner(kmClass);
    }

    @Override // kotlin.reflect.KClass
    public boolean isInstance(Object value) {
        Integer functionClassArity = ReflectClassUtilKt.getFunctionClassArity(getJClass());
        if (functionClassArity != null) {
            return TypeIntrinsics.isFunctionOfArity(value, functionClassArity.intValue());
        }
        Class wrapperByPrimitive = ReflectClassUtilKt.getWrapperByPrimitive(getJClass());
        if (wrapperByPrimitive == null) {
            wrapperByPrimitive = getJClass();
        }
        return wrapperByPrimitive.isInstance(value);
    }

    @Override // kotlin.reflect.KClass
    public boolean isValue() {
        KmClass kmClass = getKmClass();
        return kmClass != null && Attributes.isValue(kmClass);
    }

    public String toString() {
        String str;
        ClassId classId = getClassId();
        FqName packageFqName = classId.getPackageFqName();
        if (packageFqName.isRoot()) {
            str = "";
        } else {
            str = packageFqName.asString() + '.';
        }
        return "class ".concat(str + StringsKt__StringsJVMKt.replace$default(classId.getRelativeClassName().asString(), '.', '$', false, 4, (Object) null));
    }
}
