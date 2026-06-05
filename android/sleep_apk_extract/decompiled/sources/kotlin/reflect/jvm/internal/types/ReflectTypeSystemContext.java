package kotlin.reflect.jvm.internal.types;

import com.facebook.internal.AnalyticsEvents;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;
import kotlin.reflect.jvm.internal.ErrorTypeParameter;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.KTypeParameterImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.km.ClassKind;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.model.ArgumentList;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DynamicTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import twitter4j.TwitterImpl$$ExternalSyntheticOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0001\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005*\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\u0004\u0018\u00010\b*\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\f\u001a\u00020\u000b*\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u000e*\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u000b*\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\rJ\u0013\u0010\u0012\u001a\u00020\u0005*\u00020\bH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u0005*\u00020\bH\u0016¢\u0006\u0004\b\u0014\u0010\u0013J\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0016*\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u0019*\u00020\u0005H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u0015*\u00020\u0019H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u001f\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0013\u0010!\u001a\u00020\u000b*\u00020\u0004H\u0016¢\u0006\u0004\b!\u0010\rJ\u001b\u0010#\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\"\u001a\u00020\u000bH\u0016¢\u0006\u0004\b#\u0010$J\u0013\u0010&\u001a\u00020%*\u00020\u0005H\u0016¢\u0006\u0004\b&\u0010'J\u001b\u0010#\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\"\u001a\u00020\u000bH\u0016¢\u0006\u0004\b#\u0010 J\u0013\u0010(\u001a\u00020\u000b*\u00020\u0016H\u0016¢\u0006\u0004\b(\u0010)J\u0013\u0010&\u001a\u00020**\u00020\u0016H\u0016¢\u0006\u0004\b&\u0010+J\u0013\u0010-\u001a\u00020,*\u00020\u0016H\u0016¢\u0006\u0004\b-\u0010.J\u0013\u0010/\u001a\u00020\u000b*\u00020\u0016H\u0017¢\u0006\u0004\b/\u0010)J\u0013\u00101\u001a\u000200*\u00020*H\u0016¢\u0006\u0004\b1\u00102J\u0013\u00104\u001a\u000203*\u00020\u0004H\u0016¢\u0006\u0004\b4\u00105J\u001b\u00107\u001a\u000200*\u00020\u00042\u0006\u00106\u001a\u000203H\u0016¢\u0006\u0004\b7\u00108J\u0019\u0010:\u001a\b\u0012\u0004\u0012\u00020009*\u00020\u0004H\u0016¢\u0006\u0004\b:\u0010;J\u0013\u0010<\u001a\u00020\u000b*\u00020\u0005H\u0016¢\u0006\u0004\b<\u0010=J\u0013\u0010>\u001a\u00020\u000b*\u00020\u0005H\u0016¢\u0006\u0004\b>\u0010=J\u0013\u0010?\u001a\u000200*\u00020\u0004H\u0016¢\u0006\u0004\b?\u0010@J\u0015\u0010A\u001a\u0004\u0018\u00010\u0004*\u00020\u0016H\u0016¢\u0006\u0004\bA\u0010BJ\u0013\u0010C\u001a\u00020\u000b*\u000200H\u0016¢\u0006\u0004\bC\u0010DJ\u0013\u0010F\u001a\u00020E*\u000200H\u0016¢\u0006\u0004\bF\u0010GJ\u0015\u0010H\u001a\u0004\u0018\u00010\u0004*\u000200H\u0016¢\u0006\u0004\bH\u0010IJ\u0013\u0010J\u001a\u000203*\u00020%H\u0016¢\u0006\u0004\bJ\u0010KJ\u001b\u0010M\u001a\u00020L*\u00020%2\u0006\u00106\u001a\u000203H\u0016¢\u0006\u0004\bM\u0010NJ\u0019\u0010O\u001a\b\u0012\u0004\u0012\u00020L09*\u00020%H\u0016¢\u0006\u0004\bO\u0010PJ\u0019\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00040Q*\u00020%H\u0016¢\u0006\u0004\bR\u0010SJ\u0013\u0010T\u001a\u00020\u000b*\u00020%H\u0016¢\u0006\u0004\bT\u0010UJ\u0013\u0010V\u001a\u00020\u000b*\u00020%H\u0016¢\u0006\u0004\bV\u0010UJ\u0013\u0010W\u001a\u00020\u000b*\u00020%H\u0016¢\u0006\u0004\bW\u0010UJ\u0015\u0010X\u001a\u0004\u0018\u00010L*\u00020%H\u0016¢\u0006\u0004\bX\u0010YJ\u0013\u0010F\u001a\u00020E*\u00020LH\u0016¢\u0006\u0004\bF\u0010ZJ\u0019\u0010[\u001a\b\u0012\u0004\u0012\u00020\u000409*\u00020LH\u0016¢\u0006\u0004\b[\u0010\\J\u001d\u0010^\u001a\u00020\u000b*\u00020L2\b\u0010]\u001a\u0004\u0018\u00010%H\u0016¢\u0006\u0004\b^\u0010_J\u001f\u0010b\u001a\u00020\u000b2\u0006\u0010`\u001a\u00020%2\u0006\u0010a\u001a\u00020%H\u0016¢\u0006\u0004\bb\u0010cJ\u0013\u0010d\u001a\u00020\u000b*\u00020%H\u0016¢\u0006\u0004\bd\u0010UJ\u0013\u0010e\u001a\u00020\u000b*\u00020\u0004H\u0016¢\u0006\u0004\be\u0010\rJ\u0019\u0010f\u001a\b\u0012\u0004\u0012\u00020\u00040Q*\u00020\u0005H\u0016¢\u0006\u0004\bf\u0010gJ\u0013\u0010h\u001a\u00020\u000b*\u00020%H\u0016¢\u0006\u0004\bh\u0010UJ!\u0010k\u001a\u0004\u0018\u00010\u00052\u0006\u0010i\u001a\u00020\u00052\u0006\u0010j\u001a\u00020,H\u0016¢\u0006\u0004\bk\u0010lJ\u0013\u0010n\u001a\u00020m*\u00020\u0005H\u0016¢\u0006\u0004\bn\u0010oJ\u0013\u0010p\u001a\u00020\u000b*\u00020%H\u0016¢\u0006\u0004\bp\u0010UJ\u0013\u0010q\u001a\u00020\u000b*\u00020%H\u0016¢\u0006\u0004\bq\u0010UJ\u0013\u0010r\u001a\u00020\u000b*\u00020\u0005H\u0016¢\u0006\u0004\br\u0010=J\u001d\u0010t\u001a\u00020\u00042\f\u0010s\u001a\b\u0012\u0004\u0012\u00020\u00040QH\u0016¢\u0006\u0004\bt\u0010uJ\u0017\u0010w\u001a\u00020v2\u0006\u0010i\u001a\u00020\u0005H\u0016¢\u0006\u0004\bw\u0010xJ\u0013\u0010y\u001a\u00020\u000b*\u00020\u0004H\u0016¢\u0006\u0004\by\u0010\rJ\u0013\u0010z\u001a\u00020\u000b*\u00020\u0004H\u0016¢\u0006\u0004\bz\u0010\rJ\u0013\u0010|\u001a\u00020E*\u00020{H\u0002¢\u0006\u0004\b|\u0010}J\u0016\u0010\u0080\u0001\u001a\u00020\u007f*\u00020~H\u0002¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\u0013\u0010\f\u001a\u00020\u000b*\u00020%H\u0016¢\u0006\u0004\b\f\u0010UJ\u0015\u0010\u0082\u0001\u001a\u00020\u000b*\u00020\u0004H\u0016¢\u0006\u0005\b\u0082\u0001\u0010\rJ\u0014\u0010\u001f\u001a\u00020\u0005*\u00020\u0005H\u0016¢\u0006\u0005\b\u001f\u0010\u0083\u0001J\u0015\u0010\u0084\u0001\u001a\u00020\u000b*\u00020\u0005H\u0016¢\u0006\u0005\b\u0084\u0001\u0010=J\u0016\u0010\u0085\u0001\u001a\u00020%*\u00020%H\u0016¢\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001J\u001f\u0010\u0088\u0001\u001a\u000200*\u0002002\u0007\u0010\u0087\u0001\u001a\u00020\u0004H\u0016¢\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J\u0015\u0010\u008a\u0001\u001a\u00020\u000b*\u00020%H\u0016¢\u0006\u0005\b\u008a\u0001\u0010UJ\u0015\u0010\u008b\u0001\u001a\u00020\u000b*\u00020%H\u0016¢\u0006\u0005\b\u008b\u0001\u0010UJ\u0015\u0010\u008c\u0001\u001a\u00020\u000b*\u00020%H\u0016¢\u0006\u0005\b\u008c\u0001\u0010UJ\u0015\u0010\u008d\u0001\u001a\u00020\u000b*\u00020%H\u0016¢\u0006\u0005\b\u008d\u0001\u0010UJ\u0015\u0010\u008e\u0001\u001a\u00020\u000b*\u00020%H\u0016¢\u0006\u0005\b\u008e\u0001\u0010UJ\u0015\u0010\u008f\u0001\u001a\u00020\u000b*\u00020%H\u0016¢\u0006\u0005\b\u008f\u0001\u0010UJ\u0016\u0010\u0090\u0001\u001a\u000203*\u00020LH\u0016¢\u0006\u0006\b\u0090\u0001\u0010\u0091\u0001J\u001e\u0010\u0092\u0001\u001a\u00020\u0004*\u00020L2\u0006\u00106\u001a\u000203H\u0016¢\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001J\u001c\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u00042\u0006\u0010i\u001a\u00020\u0004H\u0016¢\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001J\u0015\u0010\u0096\u0001\u001a\u00020\u000b*\u00020%H\u0016¢\u0006\u0005\b\u0096\u0001\u0010UJ\u001e\u0010t\u001a\u00020\u00152\f\u0010s\u001a\b\u0012\u0004\u0012\u00020\u00150QH\u0016¢\u0006\u0005\bt\u0010\u0097\u0001J\u001c\u0010\u0099\u0001\u001a\t\u0012\u0005\u0012\u00030\u0098\u000109*\u00020\u0004H\u0016¢\u0006\u0005\b\u0099\u0001\u0010;J)\u0010\u009d\u0001\u001a\u00030\u009c\u00012\u0014\u0010\u009b\u0001\u001a\u000f\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00040\u009a\u0001H\u0016¢\u0006\u0006\b\u009d\u0001\u0010\u009e\u0001J\u0013\u0010\u009f\u0001\u001a\u00030\u009c\u0001H\u0016¢\u0006\u0006\b\u009f\u0001\u0010 \u0001R\u001d\u0010£\u0001\u001a\u0004\u0018\u00010L*\u00020~8VX\u0096\u0004¢\u0006\b\u001a\u0006\b¡\u0001\u0010¢\u0001¨\u0006¤\u0001"}, d2 = {"Lkotlin/reflect/jvm/internal/types/ReflectTypeSystemContext;", "Lkotlin/reflect/jvm/internal/impl/types/model/TypeSystemContext;", "<init>", "()V", "Lkotlin/reflect/jvm/internal/impl/types/model/KotlinTypeMarker;", "Lkotlin/reflect/jvm/internal/impl/types/model/RigidTypeMarker;", "asRigidType", "(Lkotlin/reflect/jvm/internal/impl/types/model/KotlinTypeMarker;)Lkotlin/reflect/jvm/internal/impl/types/model/RigidTypeMarker;", "Lkotlin/reflect/jvm/internal/impl/types/model/FlexibleTypeMarker;", "asFlexibleType", "(Lkotlin/reflect/jvm/internal/impl/types/model/KotlinTypeMarker;)Lkotlin/reflect/jvm/internal/impl/types/model/FlexibleTypeMarker;", "", "isError", "(Lkotlin/reflect/jvm/internal/impl/types/model/KotlinTypeMarker;)Z", "Lkotlin/reflect/jvm/internal/impl/types/model/DynamicTypeMarker;", "asDynamicType", "(Lkotlin/reflect/jvm/internal/impl/types/model/FlexibleTypeMarker;)Lkotlin/reflect/jvm/internal/impl/types/model/DynamicTypeMarker;", "isRawType", "upperBound", "(Lkotlin/reflect/jvm/internal/impl/types/model/FlexibleTypeMarker;)Lkotlin/reflect/jvm/internal/impl/types/model/RigidTypeMarker;", "lowerBound", "Lkotlin/reflect/jvm/internal/impl/types/model/SimpleTypeMarker;", "Lkotlin/reflect/jvm/internal/impl/types/model/CapturedTypeMarker;", "asCapturedType", "(Lkotlin/reflect/jvm/internal/impl/types/model/SimpleTypeMarker;)Lkotlin/reflect/jvm/internal/impl/types/model/CapturedTypeMarker;", "Lkotlin/reflect/jvm/internal/impl/types/model/DefinitelyNotNullTypeMarker;", "asDefinitelyNotNullType", "(Lkotlin/reflect/jvm/internal/impl/types/model/RigidTypeMarker;)Lkotlin/reflect/jvm/internal/impl/types/model/DefinitelyNotNullTypeMarker;", "original", "(Lkotlin/reflect/jvm/internal/impl/types/model/DefinitelyNotNullTypeMarker;)Lkotlin/reflect/jvm/internal/impl/types/model/SimpleTypeMarker;", "preserveAttributes", "makeDefinitelyNotNullOrNotNull", "(Lkotlin/reflect/jvm/internal/impl/types/model/KotlinTypeMarker;Z)Lkotlin/reflect/jvm/internal/impl/types/model/KotlinTypeMarker;", "isMarkedNullable", "nullable", "withNullability", "(Lkotlin/reflect/jvm/internal/impl/types/model/RigidTypeMarker;Z)Lkotlin/reflect/jvm/internal/impl/types/model/RigidTypeMarker;", "Lkotlin/reflect/jvm/internal/impl/types/model/TypeConstructorMarker;", "typeConstructor", "(Lkotlin/reflect/jvm/internal/impl/types/model/RigidTypeMarker;)Lkotlin/reflect/jvm/internal/impl/types/model/TypeConstructorMarker;", "isOldCapturedType", "(Lkotlin/reflect/jvm/internal/impl/types/model/CapturedTypeMarker;)Z", "Lkotlin/reflect/jvm/internal/impl/types/model/CapturedTypeConstructorMarker;", "(Lkotlin/reflect/jvm/internal/impl/types/model/CapturedTypeMarker;)Lkotlin/reflect/jvm/internal/impl/types/model/CapturedTypeConstructorMarker;", "Lkotlin/reflect/jvm/internal/impl/types/model/CaptureStatus;", "captureStatus", "(Lkotlin/reflect/jvm/internal/impl/types/model/CapturedTypeMarker;)Lkotlin/reflect/jvm/internal/impl/types/model/CaptureStatus;", "isProjectionNotNull", "Lkotlin/reflect/jvm/internal/impl/types/model/TypeArgumentMarker;", "projection", "(Lkotlin/reflect/jvm/internal/impl/types/model/CapturedTypeConstructorMarker;)Lkotlin/reflect/jvm/internal/impl/types/model/TypeArgumentMarker;", "", "argumentsCount", "(Lkotlin/reflect/jvm/internal/impl/types/model/KotlinTypeMarker;)I", "index", "getArgument", "(Lkotlin/reflect/jvm/internal/impl/types/model/KotlinTypeMarker;I)Lkotlin/reflect/jvm/internal/impl/types/model/TypeArgumentMarker;", "", "getArguments", "(Lkotlin/reflect/jvm/internal/impl/types/model/KotlinTypeMarker;)Ljava/util/List;", "isStubType", "(Lkotlin/reflect/jvm/internal/impl/types/model/RigidTypeMarker;)Z", "isStubTypeForBuilderInference", "asTypeArgument", "(Lkotlin/reflect/jvm/internal/impl/types/model/KotlinTypeMarker;)Lkotlin/reflect/jvm/internal/impl/types/model/TypeArgumentMarker;", "lowerType", "(Lkotlin/reflect/jvm/internal/impl/types/model/CapturedTypeMarker;)Lkotlin/reflect/jvm/internal/impl/types/model/KotlinTypeMarker;", "isStarProjection", "(Lkotlin/reflect/jvm/internal/impl/types/model/TypeArgumentMarker;)Z", "Lkotlin/reflect/jvm/internal/impl/types/model/TypeVariance;", "getVariance", "(Lkotlin/reflect/jvm/internal/impl/types/model/TypeArgumentMarker;)Lkotlin/reflect/jvm/internal/impl/types/model/TypeVariance;", "getType", "(Lkotlin/reflect/jvm/internal/impl/types/model/TypeArgumentMarker;)Lkotlin/reflect/jvm/internal/impl/types/model/KotlinTypeMarker;", "parametersCount", "(Lkotlin/reflect/jvm/internal/impl/types/model/TypeConstructorMarker;)I", "Lkotlin/reflect/jvm/internal/impl/types/model/TypeParameterMarker;", "getParameter", "(Lkotlin/reflect/jvm/internal/impl/types/model/TypeConstructorMarker;I)Lkotlin/reflect/jvm/internal/impl/types/model/TypeParameterMarker;", "getParameters", "(Lkotlin/reflect/jvm/internal/impl/types/model/TypeConstructorMarker;)Ljava/util/List;", "", "supertypes", "(Lkotlin/reflect/jvm/internal/impl/types/model/TypeConstructorMarker;)Ljava/util/Collection;", "isIntersection", "(Lkotlin/reflect/jvm/internal/impl/types/model/TypeConstructorMarker;)Z", "isClassTypeConstructor", "isIntegerLiteralTypeConstructor", "getTypeParameterClassifier", "(Lkotlin/reflect/jvm/internal/impl/types/model/TypeConstructorMarker;)Lkotlin/reflect/jvm/internal/impl/types/model/TypeParameterMarker;", "(Lkotlin/reflect/jvm/internal/impl/types/model/TypeParameterMarker;)Lkotlin/reflect/jvm/internal/impl/types/model/TypeVariance;", "getUpperBounds", "(Lkotlin/reflect/jvm/internal/impl/types/model/TypeParameterMarker;)Ljava/util/List;", "selfConstructor", "hasRecursiveBounds", "(Lkotlin/reflect/jvm/internal/impl/types/model/TypeParameterMarker;Lkotlin/reflect/jvm/internal/impl/types/model/TypeConstructorMarker;)Z", "c1", "c2", "areEqualTypeConstructors", "(Lkotlin/reflect/jvm/internal/impl/types/model/TypeConstructorMarker;Lkotlin/reflect/jvm/internal/impl/types/model/TypeConstructorMarker;)Z", "isDenotable", "isNullableType", "possibleIntegerTypes", "(Lkotlin/reflect/jvm/internal/impl/types/model/RigidTypeMarker;)Ljava/util/Collection;", "isCommonFinalClassConstructor", "type", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, "captureFromArguments", "(Lkotlin/reflect/jvm/internal/impl/types/model/RigidTypeMarker;Lkotlin/reflect/jvm/internal/impl/types/model/CaptureStatus;)Lkotlin/reflect/jvm/internal/impl/types/model/RigidTypeMarker;", "Lkotlin/reflect/jvm/internal/impl/types/model/TypeArgumentListMarker;", "asArgumentList", "(Lkotlin/reflect/jvm/internal/impl/types/model/RigidTypeMarker;)Lkotlin/reflect/jvm/internal/impl/types/model/TypeArgumentListMarker;", "isAnyConstructor", "isNothingConstructor", "isSingleClassifierType", "types", "intersectTypes", "(Ljava/util/Collection;)Lkotlin/reflect/jvm/internal/impl/types/model/KotlinTypeMarker;", "Lkotlin/reflect/jvm/internal/impl/types/TypeCheckerState$SupertypesPolicy;", "substitutionSupertypePolicy", "(Lkotlin/reflect/jvm/internal/impl/types/model/RigidTypeMarker;)Lkotlin/reflect/jvm/internal/impl/types/TypeCheckerState$SupertypesPolicy;", "isTypeVariableType", "isDynamic", "Lkotlin/reflect/KVariance;", "convertVariance", "(Lkotlin/reflect/KVariance;)Lkotlin/reflect/jvm/internal/impl/types/model/TypeVariance;", "", "", "shouldNotBeCalled", "(Ljava/lang/Object;)Ljava/lang/Void;", "isUninferredParameter", "(Lkotlin/reflect/jvm/internal/impl/types/model/RigidTypeMarker;)Lkotlin/reflect/jvm/internal/impl/types/model/RigidTypeMarker;", "isStubTypeForVariableInSubtyping", "unwrapStubTypeVariableConstructor", "(Lkotlin/reflect/jvm/internal/impl/types/model/TypeConstructorMarker;)Lkotlin/reflect/jvm/internal/impl/types/model/TypeConstructorMarker;", "newType", "replaceType", "(Lkotlin/reflect/jvm/internal/impl/types/model/TypeArgumentMarker;Lkotlin/reflect/jvm/internal/impl/types/model/KotlinTypeMarker;)Lkotlin/reflect/jvm/internal/impl/types/model/TypeArgumentMarker;", "isInterface", "isIntegerLiteralConstantTypeConstructor", "isIntegerConstantOperatorTypeConstructor", "isLocalType", "isAnonymous", "isTypeParameterTypeConstructor", "upperBoundCount", "(Lkotlin/reflect/jvm/internal/impl/types/model/TypeParameterMarker;)I", "getUpperBound", "(Lkotlin/reflect/jvm/internal/impl/types/model/TypeParameterMarker;I)Lkotlin/reflect/jvm/internal/impl/types/model/KotlinTypeMarker;", "captureFromExpression", "(Lkotlin/reflect/jvm/internal/impl/types/model/KotlinTypeMarker;)Lkotlin/reflect/jvm/internal/impl/types/model/KotlinTypeMarker;", "isArrayConstructor", "(Ljava/util/Collection;)Lkotlin/reflect/jvm/internal/impl/types/model/SimpleTypeMarker;", "Lkotlin/reflect/jvm/internal/impl/types/model/AnnotationMarker;", "getAttributes", "", "map", "Lkotlin/reflect/jvm/internal/impl/types/model/TypeSubstitutorMarker;", "typeSubstitutorByTypeConstructor", "(Ljava/util/Map;)Lkotlin/reflect/jvm/internal/impl/types/model/TypeSubstitutorMarker;", "createEmptySubstitutor", "()Lkotlin/reflect/jvm/internal/impl/types/model/TypeSubstitutorMarker;", "getTypeParameter", "(Lorg/jetbrains/kotlin/types/model/TypeVariableTypeConstructorMarker;)Lorg/jetbrains/kotlin/types/model/TypeParameterMarker;", "typeParameter", "kotlin-reflection"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ReflectTypeSystemContext implements TypeSystemContext {
    public static final ReflectTypeSystemContext INSTANCE = new ReflectTypeSystemContext();

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KVariance.values().length];
            try {
                iArr[KVariance.INVARIANT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KVariance.IN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KVariance.OUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private ReflectTypeSystemContext() {
    }

    private final TypeVariance convertVariance(KVariance kVariance) {
        int i = WhenMappings.$EnumSwitchMapping$0[kVariance.ordinal()];
        if (i == 1) {
            return TypeVariance.INV;
        }
        if (i == 2) {
            return TypeVariance.IN;
        }
        if (i == 3) {
            return TypeVariance.OUT;
        }
        Home$$ExternalSyntheticBUOutline0.m();
        return null;
    }

    private final Void shouldNotBeCalled(Object obj) {
        throw new KotlinReflectionInternalError("This method should not be called on " + obj + " with a new kotlin-reflect implementation. Please file an issue at https://kotl.in/issue");
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean areEqualTypeConstructors(TypeConstructorMarker c1, TypeConstructorMarker c2) {
        c1.getClass();
        c2.getClass();
        return Intrinsics.areEqual(c1, c2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public int argumentsCount(KotlinTypeMarker kotlinTypeMarker) {
        kotlinTypeMarker.getClass();
        return ((KType) kotlinTypeMarker).getArguments().size();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeArgumentListMarker asArgumentList(RigidTypeMarker rigidTypeMarker) {
        rigidTypeMarker.getClass();
        return (TypeArgumentListMarker) rigidTypeMarker;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public CapturedTypeMarker asCapturedType(SimpleTypeMarker simpleTypeMarker) {
        simpleTypeMarker.getClass();
        if (simpleTypeMarker instanceof CapturedTypeMarker) {
            return (CapturedTypeMarker) simpleTypeMarker;
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ CapturedTypeMarker asCapturedTypeUnwrappingDnn(RigidTypeMarker rigidTypeMarker) {
        return default$asCapturedTypeUnwrappingDnn(rigidTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public DefinitelyNotNullTypeMarker asDefinitelyNotNullType(RigidTypeMarker rigidTypeMarker) {
        rigidTypeMarker.getClass();
        if ((rigidTypeMarker instanceof AbstractKType) && ((AbstractKType) rigidTypeMarker).getIsDefinitelyNotNullType()) {
            return (DefinitelyNotNullTypeMarker) rigidTypeMarker;
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public DynamicTypeMarker asDynamicType(FlexibleTypeMarker flexibleTypeMarker) {
        flexibleTypeMarker.getClass();
        shouldNotBeCalled(flexibleTypeMarker);
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public FlexibleTypeMarker asFlexibleType(KotlinTypeMarker kotlinTypeMarker) {
        kotlinTypeMarker.getClass();
        if (!(kotlinTypeMarker instanceof AbstractKType) || ((AbstractKType) kotlinTypeMarker).getLowerBound() == null) {
            return null;
        }
        return (FlexibleTypeMarker) kotlinTypeMarker;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public RigidTypeMarker asRigidType(KotlinTypeMarker kotlinTypeMarker) {
        kotlinTypeMarker.getClass();
        if (asFlexibleType(kotlinTypeMarker) != null) {
            return null;
        }
        return (RigidTypeMarker) kotlinTypeMarker;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeArgumentMarker asTypeArgument(KotlinTypeMarker kotlinTypeMarker) {
        kotlinTypeMarker.getClass();
        shouldNotBeCalled(kotlinTypeMarker);
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public RigidTypeMarker captureFromArguments(RigidTypeMarker type, CaptureStatus status) {
        type.getClass();
        status.getClass();
        return (AbstractKType) CapturedKTypeKt.captureKTypeFromArguments((KType) type);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public CaptureStatus captureStatus(CapturedTypeMarker capturedTypeMarker) {
        capturedTypeMarker.getClass();
        return CaptureStatus.FOR_SUBTYPING;
    }

    public CapturedTypeMarker default$asCapturedTypeUnwrappingDnn(RigidTypeMarker rigidTypeMarker) {
        rigidTypeMarker.getClass();
        return asCapturedType(originalIfDefinitelyNotNullable(rigidTypeMarker));
    }

    public List<SimpleTypeMarker> default$fastCorrespondingSupertypes(RigidTypeMarker rigidTypeMarker, TypeConstructorMarker typeConstructorMarker) {
        rigidTypeMarker.getClass();
        typeConstructorMarker.getClass();
        return null;
    }

    public TypeArgumentMarker default$get(TypeArgumentListMarker typeArgumentListMarker, int i) {
        typeArgumentListMarker.getClass();
        if (typeArgumentListMarker instanceof SimpleTypeMarker) {
            return getArgument((KotlinTypeMarker) typeArgumentListMarker, i);
        }
        if (typeArgumentListMarker instanceof ArgumentList) {
            TypeArgumentMarker typeArgumentMarker = ((ArgumentList) typeArgumentListMarker).get(i);
            typeArgumentMarker.getClass();
            return typeArgumentMarker;
        }
        StringBuilder sb = new StringBuilder("unknown type argument list type: ");
        sb.append(typeArgumentListMarker);
        Utf8$$ExternalSyntheticBUOutline0.m(sb, (Object) ", ", (Object) Reflection.getOrCreateKotlinClass(typeArgumentListMarker.getClass()));
        return null;
    }

    public TypeArgumentMarker default$getArgumentOrNull(RigidTypeMarker rigidTypeMarker, int i) {
        rigidTypeMarker.getClass();
        if (i < 0 || i >= argumentsCount(rigidTypeMarker)) {
            return null;
        }
        return getArgument(rigidTypeMarker, i);
    }

    public boolean default$hasFlexibleNullability(KotlinTypeMarker kotlinTypeMarker) {
        kotlinTypeMarker.getClass();
        return isMarkedNullable(lowerBoundIfFlexible(kotlinTypeMarker)) != isMarkedNullable(upperBoundIfFlexible(kotlinTypeMarker));
    }

    public boolean default$identicalArguments(RigidTypeMarker rigidTypeMarker, RigidTypeMarker rigidTypeMarker2) {
        rigidTypeMarker.getClass();
        rigidTypeMarker2.getClass();
        return false;
    }

    public boolean default$isCapturedType(KotlinTypeMarker kotlinTypeMarker) {
        kotlinTypeMarker.getClass();
        RigidTypeMarker rigidTypeMarkerAsRigidType = asRigidType(kotlinTypeMarker);
        return (rigidTypeMarkerAsRigidType != null ? asCapturedTypeUnwrappingDnn(rigidTypeMarkerAsRigidType) : null) != null;
    }

    public boolean default$isClassType(RigidTypeMarker rigidTypeMarker) {
        rigidTypeMarker.getClass();
        return isClassTypeConstructor(typeConstructor(rigidTypeMarker));
    }

    public boolean default$isDefinitelyNotNullType(KotlinTypeMarker kotlinTypeMarker) {
        kotlinTypeMarker.getClass();
        RigidTypeMarker rigidTypeMarkerAsRigidType = asRigidType(kotlinTypeMarker);
        return (rigidTypeMarkerAsRigidType != null ? asDefinitelyNotNullType(rigidTypeMarkerAsRigidType) : null) != null;
    }

    public boolean default$isFlexible(KotlinTypeMarker kotlinTypeMarker) {
        kotlinTypeMarker.getClass();
        return asFlexibleType(kotlinTypeMarker) != null;
    }

    public boolean default$isFlexibleWithDifferentTypeConstructors(KotlinTypeMarker kotlinTypeMarker) {
        kotlinTypeMarker.getClass();
        return !Intrinsics.areEqual(typeConstructor(lowerBoundIfFlexible(kotlinTypeMarker)), typeConstructor(upperBoundIfFlexible(kotlinTypeMarker)));
    }

    public boolean default$isIntegerLiteralType(RigidTypeMarker rigidTypeMarker) {
        rigidTypeMarker.getClass();
        return isIntegerLiteralTypeConstructor(typeConstructor(rigidTypeMarker));
    }

    public boolean default$isNotNullTypeParameter(KotlinTypeMarker kotlinTypeMarker) {
        kotlinTypeMarker.getClass();
        return false;
    }

    public boolean default$isNothing(KotlinTypeMarker kotlinTypeMarker) {
        kotlinTypeMarker.getClass();
        return isNothingConstructor(typeConstructor(kotlinTypeMarker)) && !isNullableType(kotlinTypeMarker);
    }

    public RigidTypeMarker default$lowerBoundIfFlexible(KotlinTypeMarker kotlinTypeMarker) {
        RigidTypeMarker rigidTypeMarkerLowerBound;
        kotlinTypeMarker.getClass();
        FlexibleTypeMarker flexibleTypeMarkerAsFlexibleType = asFlexibleType(kotlinTypeMarker);
        if (flexibleTypeMarkerAsFlexibleType != null && (rigidTypeMarkerLowerBound = lowerBound(flexibleTypeMarkerAsFlexibleType)) != null) {
            return rigidTypeMarkerLowerBound;
        }
        RigidTypeMarker rigidTypeMarkerAsRigidType = asRigidType(kotlinTypeMarker);
        rigidTypeMarkerAsRigidType.getClass();
        return rigidTypeMarkerAsRigidType;
    }

    public KotlinTypeMarker default$makeDefinitelyNotNullOrNotNull(KotlinTypeMarker kotlinTypeMarker) {
        kotlinTypeMarker.getClass();
        return makeDefinitelyNotNullOrNotNull(kotlinTypeMarker, false);
    }

    public SimpleTypeMarker default$originalIfDefinitelyNotNullable(RigidTypeMarker rigidTypeMarker) {
        SimpleTypeMarker simpleTypeMarkerOriginal;
        rigidTypeMarker.getClass();
        DefinitelyNotNullTypeMarker definitelyNotNullTypeMarkerAsDefinitelyNotNullType = asDefinitelyNotNullType(rigidTypeMarker);
        return (definitelyNotNullTypeMarkerAsDefinitelyNotNullType == null || (simpleTypeMarkerOriginal = original(definitelyNotNullTypeMarkerAsDefinitelyNotNullType)) == null) ? (SimpleTypeMarker) rigidTypeMarker : simpleTypeMarkerOriginal;
    }

    public int default$size(TypeArgumentListMarker typeArgumentListMarker) {
        typeArgumentListMarker.getClass();
        if (typeArgumentListMarker instanceof RigidTypeMarker) {
            return argumentsCount((KotlinTypeMarker) typeArgumentListMarker);
        }
        if (typeArgumentListMarker instanceof ArgumentList) {
            return ((ArgumentList) typeArgumentListMarker).size();
        }
        StringBuilder sb = new StringBuilder("unknown type argument list type: ");
        sb.append(typeArgumentListMarker);
        Utf8$$ExternalSyntheticBUOutline0.m(sb, (Object) ", ", (Object) Reflection.getOrCreateKotlinClass(typeArgumentListMarker.getClass()));
        return 0;
    }

    public TypeConstructorMarker default$typeConstructor(KotlinTypeMarker kotlinTypeMarker) {
        kotlinTypeMarker.getClass();
        RigidTypeMarker rigidTypeMarkerAsRigidType = asRigidType(kotlinTypeMarker);
        if (rigidTypeMarkerAsRigidType == null) {
            rigidTypeMarkerAsRigidType = lowerBoundIfFlexible(kotlinTypeMarker);
        }
        return typeConstructor(rigidTypeMarkerAsRigidType);
    }

    public RigidTypeMarker default$upperBoundIfFlexible(KotlinTypeMarker kotlinTypeMarker) {
        RigidTypeMarker rigidTypeMarkerUpperBound;
        kotlinTypeMarker.getClass();
        FlexibleTypeMarker flexibleTypeMarkerAsFlexibleType = asFlexibleType(kotlinTypeMarker);
        if (flexibleTypeMarkerAsFlexibleType != null && (rigidTypeMarkerUpperBound = upperBound(flexibleTypeMarkerAsFlexibleType)) != null) {
            return rigidTypeMarkerUpperBound;
        }
        RigidTypeMarker rigidTypeMarkerAsRigidType = asRigidType(kotlinTypeMarker);
        rigidTypeMarkerAsRigidType.getClass();
        return rigidTypeMarkerAsRigidType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ List<SimpleTypeMarker> fastCorrespondingSupertypes(RigidTypeMarker rigidTypeMarker, TypeConstructorMarker typeConstructorMarker) {
        return default$fastCorrespondingSupertypes(rigidTypeMarker, typeConstructorMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ TypeArgumentMarker get(TypeArgumentListMarker typeArgumentListMarker, int i) {
        return default$get(typeArgumentListMarker, i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeArgumentMarker getArgument(KotlinTypeMarker kotlinTypeMarker, int i) {
        kotlinTypeMarker.getClass();
        return new KTypeProjectionAsTypeArgumentMarker(((KType) kotlinTypeMarker).getArguments().get(i));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ TypeArgumentMarker getArgumentOrNull(RigidTypeMarker rigidTypeMarker, int i) {
        return default$getArgumentOrNull(rigidTypeMarker, i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public List<TypeArgumentMarker> getArguments(KotlinTypeMarker kotlinTypeMarker) {
        kotlinTypeMarker.getClass();
        shouldNotBeCalled(kotlinTypeMarker);
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeParameterMarker getParameter(TypeConstructorMarker typeConstructorMarker, int i) {
        typeConstructorMarker.getClass();
        KTypeParameter kTypeParameter = CapturedKTypeKt.allTypeParameters((KClass) typeConstructorMarker).get(i);
        kTypeParameter.getClass();
        return (KTypeParameterImpl) kTypeParameter;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public List<TypeParameterMarker> getParameters(TypeConstructorMarker typeConstructorMarker) {
        typeConstructorMarker.getClass();
        shouldNotBeCalled(typeConstructorMarker);
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public KotlinTypeMarker getType(TypeArgumentMarker typeArgumentMarker) {
        typeArgumentMarker.getClass();
        return (KotlinTypeMarker) ((KTypeProjectionAsTypeArgumentMarker) typeArgumentMarker).getValue().getType();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeParameterMarker getTypeParameterClassifier(TypeConstructorMarker typeConstructorMarker) {
        typeConstructorMarker.getClass();
        shouldNotBeCalled(typeConstructorMarker);
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public List<KotlinTypeMarker> getUpperBounds(TypeParameterMarker typeParameterMarker) {
        typeParameterMarker.getClass();
        shouldNotBeCalled(typeParameterMarker);
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeVariance getVariance(TypeArgumentMarker typeArgumentMarker) {
        TypeVariance typeVarianceConvertVariance;
        typeArgumentMarker.getClass();
        KVariance variance = ((KTypeProjectionAsTypeArgumentMarker) typeArgumentMarker).getValue().getVariance();
        return (variance == null || (typeVarianceConvertVariance = convertVariance(variance)) == null) ? TypeVariance.OUT : typeVarianceConvertVariance;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ boolean hasFlexibleNullability(KotlinTypeMarker kotlinTypeMarker) {
        return default$hasFlexibleNullability(kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean hasRecursiveBounds(TypeParameterMarker typeParameterMarker, TypeConstructorMarker typeConstructorMarker) {
        typeParameterMarker.getClass();
        shouldNotBeCalled(typeParameterMarker);
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemOptimizationContext
    public /* bridge */ boolean identicalArguments(RigidTypeMarker rigidTypeMarker, RigidTypeMarker rigidTypeMarker2) {
        return default$identicalArguments(rigidTypeMarker, rigidTypeMarker2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public KotlinTypeMarker intersectTypes(Collection<? extends KotlinTypeMarker> types) {
        types.getClass();
        shouldNotBeCalled(this);
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isAnyConstructor(TypeConstructorMarker typeConstructorMarker) {
        typeConstructorMarker.getClass();
        return Intrinsics.areEqual(typeConstructorMarker, Reflection.getOrCreateKotlinClass(Object.class));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ boolean isCapturedType(KotlinTypeMarker kotlinTypeMarker) {
        return default$isCapturedType(kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ boolean isClassType(RigidTypeMarker rigidTypeMarker) {
        return default$isClassType(rigidTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isClassTypeConstructor(TypeConstructorMarker typeConstructorMarker) {
        typeConstructorMarker.getClass();
        return typeConstructorMarker instanceof KClass;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isCommonFinalClassConstructor(TypeConstructorMarker typeConstructorMarker) {
        typeConstructorMarker.getClass();
        if (!(typeConstructorMarker instanceof KClassImpl)) {
            return false;
        }
        KClassImpl kClassImpl = (KClassImpl) typeConstructorMarker;
        return (!kClassImpl.isFinal() || kClassImpl.getClassKind$kotlin_reflection() == ClassKind.ENUM_CLASS || kClassImpl.getClassKind$kotlin_reflection() == ClassKind.ENUM_ENTRY || kClassImpl.getClassKind$kotlin_reflection() == ClassKind.ANNOTATION_CLASS) ? false : true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ boolean isDefinitelyNotNullType(KotlinTypeMarker kotlinTypeMarker) {
        return default$isDefinitelyNotNullType(kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isDenotable(TypeConstructorMarker typeConstructorMarker) {
        typeConstructorMarker.getClass();
        return !(typeConstructorMarker instanceof CapturedKTypeConstructor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isDynamic(KotlinTypeMarker kotlinTypeMarker) {
        kotlinTypeMarker.getClass();
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isError(KotlinTypeMarker kotlinTypeMarker) {
        KotlinType type;
        kotlinTypeMarker.getClass();
        if (!(kotlinTypeMarker instanceof AbstractKType) || !(((AbstractKType) kotlinTypeMarker).getClassifier() instanceof ErrorTypeParameter)) {
            DescriptorKType descriptorKType = kotlinTypeMarker instanceof DescriptorKType ? (DescriptorKType) kotlinTypeMarker : null;
            if (descriptorKType == null || (type = descriptorKType.getType()) == null || !KotlinTypeKt.isError(type)) {
                return false;
            }
        }
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ boolean isFlexible(KotlinTypeMarker kotlinTypeMarker) {
        return default$isFlexible(kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ boolean isFlexibleWithDifferentTypeConstructors(KotlinTypeMarker kotlinTypeMarker) {
        return default$isFlexibleWithDifferentTypeConstructors(kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ boolean isIntegerLiteralType(RigidTypeMarker rigidTypeMarker) {
        return default$isIntegerLiteralType(rigidTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isIntegerLiteralTypeConstructor(TypeConstructorMarker typeConstructorMarker) {
        typeConstructorMarker.getClass();
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isIntersection(TypeConstructorMarker typeConstructorMarker) {
        typeConstructorMarker.getClass();
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isMarkedNullable(KotlinTypeMarker kotlinTypeMarker) {
        kotlinTypeMarker.getClass();
        return ((KType) kotlinTypeMarker).getIsMarkedNullable();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ boolean isNotNullTypeParameter(KotlinTypeMarker kotlinTypeMarker) {
        return default$isNotNullTypeParameter(kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ boolean isNothing(KotlinTypeMarker kotlinTypeMarker) {
        return default$isNothing(kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isNothingConstructor(TypeConstructorMarker typeConstructorMarker) {
        typeConstructorMarker.getClass();
        return Intrinsics.areEqual(typeConstructorMarker, NothingKClass.INSTANCE);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isNullableType(KotlinTypeMarker kotlinTypeMarker) {
        kotlinTypeMarker.getClass();
        shouldNotBeCalled(kotlinTypeMarker);
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isOldCapturedType(CapturedTypeMarker capturedTypeMarker) {
        capturedTypeMarker.getClass();
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isProjectionNotNull(CapturedTypeMarker capturedTypeMarker) {
        capturedTypeMarker.getClass();
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isRawType(KotlinTypeMarker kotlinTypeMarker) {
        kotlinTypeMarker.getClass();
        shouldNotBeCalled(kotlinTypeMarker);
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isSingleClassifierType(RigidTypeMarker rigidTypeMarker) {
        rigidTypeMarker.getClass();
        shouldNotBeCalled(rigidTypeMarker);
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isStarProjection(TypeArgumentMarker typeArgumentMarker) {
        typeArgumentMarker.getClass();
        return Intrinsics.areEqual(((KTypeProjectionAsTypeArgumentMarker) typeArgumentMarker).getValue(), KTypeProjection.INSTANCE.getSTAR());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isStubType(RigidTypeMarker rigidTypeMarker) {
        rigidTypeMarker.getClass();
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isStubTypeForBuilderInference(RigidTypeMarker rigidTypeMarker) {
        rigidTypeMarker.getClass();
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isTypeVariableType(KotlinTypeMarker kotlinTypeMarker) {
        kotlinTypeMarker.getClass();
        shouldNotBeCalled(kotlinTypeMarker);
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public RigidTypeMarker lowerBound(FlexibleTypeMarker flexibleTypeMarker) {
        flexibleTypeMarker.getClass();
        AbstractKType lowerBound = ((AbstractKType) flexibleTypeMarker).getLowerBound();
        lowerBound.getClass();
        return lowerBound;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ RigidTypeMarker lowerBoundIfFlexible(KotlinTypeMarker kotlinTypeMarker) {
        return default$lowerBoundIfFlexible(kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public KotlinTypeMarker lowerType(CapturedTypeMarker capturedTypeMarker) {
        capturedTypeMarker.getClass();
        return (KotlinTypeMarker) ((CapturedKType) capturedTypeMarker).getLowerType();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public KotlinTypeMarker makeDefinitelyNotNullOrNotNull(KotlinTypeMarker kotlinTypeMarker, boolean z) {
        kotlinTypeMarker.getClass();
        shouldNotBeCalled(kotlinTypeMarker);
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public SimpleTypeMarker original(DefinitelyNotNullTypeMarker definitelyNotNullTypeMarker) {
        definitelyNotNullTypeMarker.getClass();
        shouldNotBeCalled(definitelyNotNullTypeMarker);
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ SimpleTypeMarker originalIfDefinitelyNotNullable(RigidTypeMarker rigidTypeMarker) {
        return default$originalIfDefinitelyNotNullable(rigidTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public int parametersCount(TypeConstructorMarker typeConstructorMarker) {
        typeConstructorMarker.getClass();
        if (typeConstructorMarker instanceof KClass) {
            return CapturedKTypeKt.allTypeParameters((KClass) typeConstructorMarker).size();
        }
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public Collection<KotlinTypeMarker> possibleIntegerTypes(RigidTypeMarker rigidTypeMarker) {
        rigidTypeMarker.getClass();
        shouldNotBeCalled(rigidTypeMarker);
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeArgumentMarker projection(CapturedTypeConstructorMarker capturedTypeConstructorMarker) {
        capturedTypeConstructorMarker.getClass();
        return new KTypeProjectionAsTypeArgumentMarker(((CapturedKTypeConstructor) capturedTypeConstructorMarker).getProjection());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ int size(TypeArgumentListMarker typeArgumentListMarker) {
        return default$size(typeArgumentListMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeCheckerState.SupertypesPolicy substitutionSupertypePolicy(RigidTypeMarker type) {
        type.getClass();
        final KTypeSubstitutor kTypeSubstitutorCreate = KTypeSubstitutor.INSTANCE.create((KType) type);
        return new TypeCheckerState.SupertypesPolicy.DoCustomTransform() { // from class: kotlin.reflect.jvm.internal.types.ReflectTypeSystemContext.substitutionSupertypePolicy.1
            @Override // kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.SupertypesPolicy
            /* JADX INFO: renamed from: transformType */
            public RigidTypeMarker mo2514transformType(TypeCheckerState state, KotlinTypeMarker type2) {
                state.getClass();
                type2.getClass();
                KTypeSubstitutor kTypeSubstitutor = kTypeSubstitutorCreate;
                RigidTypeMarker rigidTypeMarkerLowerBoundIfFlexible = ReflectTypeSystemContext.INSTANCE.lowerBoundIfFlexible(type2);
                rigidTypeMarkerLowerBoundIfFlexible.getClass();
                KType type3 = KTypeSubstitutor.substitute$default(kTypeSubstitutor, (KType) rigidTypeMarkerLowerBoundIfFlexible, null, 2, null).getType();
                type3.getClass();
                return (AbstractKType) type3;
            }
        };
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public Collection<KotlinTypeMarker> supertypes(TypeConstructorMarker typeConstructorMarker) {
        typeConstructorMarker.getClass();
        if (typeConstructorMarker instanceof KClass) {
            List<KType> supertypes = ((KClass) typeConstructorMarker).getSupertypes();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(supertypes, 10));
            for (KType kType : supertypes) {
                kType.getClass();
                arrayList.add((KotlinTypeMarker) kType);
            }
            return arrayList;
        }
        if (typeConstructorMarker instanceof KTypeParameter) {
            List<KType> upperBounds = ((KTypeParameter) typeConstructorMarker).getUpperBounds();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(upperBounds, 10));
            for (KType kType2 : upperBounds) {
                kType2.getClass();
                arrayList2.add((KotlinTypeMarker) kType2);
            }
            return arrayList2;
        }
        if (!(typeConstructorMarker instanceof CapturedKTypeConstructor)) {
            StringBuilder sbM = TwitterImpl$$ExternalSyntheticOutline0.m("Unsupported type constructor: ", typeConstructorMarker, " (");
            sbM.append(typeConstructorMarker.getClass().getName());
            sbM.append(')');
            throw new IllegalStateException(sbM.toString().toString());
        }
        List<KType> supertypes2 = ((CapturedKTypeConstructor) typeConstructorMarker).getSupertypes();
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(supertypes2, 10));
        for (KType kType3 : supertypes2) {
            kType3.getClass();
            arrayList3.add((KotlinTypeMarker) kType3);
        }
        return arrayList3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeConstructorMarker typeConstructor(RigidTypeMarker rigidTypeMarker) {
        Class<?> componentType;
        rigidTypeMarker.getClass();
        if (rigidTypeMarker instanceof CapturedKType) {
            return ((CapturedKType) rigidTypeMarker).getTypeConstructor();
        }
        AbstractKType abstractKType = (AbstractKType) rigidTypeMarker;
        if (abstractKType.getIsNothingType()) {
            return NothingKClass.INSTANCE;
        }
        KClassifier classifier = abstractKType.getClassifier();
        KClassImpl kClassImpl = classifier instanceof KClassImpl ? (KClassImpl) classifier : null;
        if (kClassImpl != null && (componentType = JvmClassMappingKt.getJavaClass(kClassImpl).getComponentType()) != null && !componentType.isPrimitive()) {
            return (TypeConstructorMarker) Reflection.getOrCreateKotlinClass(Object[].class);
        }
        KClassifier mutableCollectionClass = abstractKType.getMutableCollectionClass();
        if (mutableCollectionClass == null) {
            mutableCollectionClass = abstractKType.getClassifier();
        }
        mutableCollectionClass.getClass();
        return (TypeConstructorMarker) mutableCollectionClass;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public RigidTypeMarker upperBound(FlexibleTypeMarker flexibleTypeMarker) {
        flexibleTypeMarker.getClass();
        AbstractKType upperBound = ((AbstractKType) flexibleTypeMarker).getUpperBound();
        upperBound.getClass();
        return upperBound;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ RigidTypeMarker upperBoundIfFlexible(KotlinTypeMarker kotlinTypeMarker) {
        return default$upperBoundIfFlexible(kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public KotlinTypeMarker withNullability(KotlinTypeMarker kotlinTypeMarker, boolean z) {
        kotlinTypeMarker.getClass();
        shouldNotBeCalled(kotlinTypeMarker);
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ boolean isDefinitelyNotNullType(RigidTypeMarker rigidTypeMarker) {
        return default$isDefinitelyNotNullType(rigidTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ KotlinTypeMarker makeDefinitelyNotNullOrNotNull(KotlinTypeMarker kotlinTypeMarker) {
        return default$makeDefinitelyNotNullOrNotNull(kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public RigidTypeMarker withNullability(RigidTypeMarker rigidTypeMarker, boolean z) {
        rigidTypeMarker.getClass();
        return ((AbstractKType) rigidTypeMarker).makeNullableAsSpecified(z);
    }

    public boolean default$isDefinitelyNotNullType(RigidTypeMarker rigidTypeMarker) {
        rigidTypeMarker.getClass();
        return asDefinitelyNotNullType(rigidTypeMarker) != null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeVariance getVariance(TypeParameterMarker typeParameterMarker) {
        typeParameterMarker.getClass();
        return convertVariance(((KTypeParameter) typeParameterMarker).getVariance());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public /* bridge */ TypeConstructorMarker typeConstructor(KotlinTypeMarker kotlinTypeMarker) {
        return default$typeConstructor(kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public CapturedTypeConstructorMarker typeConstructor(CapturedTypeMarker capturedTypeMarker) {
        capturedTypeMarker.getClass();
        return ((CapturedKType) capturedTypeMarker).getTypeConstructor();
    }
}
