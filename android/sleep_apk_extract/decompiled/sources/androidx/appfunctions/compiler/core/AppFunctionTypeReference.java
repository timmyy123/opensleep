package androidx.appfunctions.compiler.core;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.AppEventsConstants;
import com.google.devtools.ksp.symbol.KSTypeReference;
import com.squareup.kotlinpoet.TypeName;
import com.squareup.kotlinpoet.TypeNames;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.ZoneId;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001c\u001dB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\tJ\u0006\u0010\u001a\u001a\u00020\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u000e\u0010\u0010R\u001b\u0010\u0012\u001a\u00020\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0013\u0010\u0007R\u001b\u0010\u0015\u001a\u00020\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0016\u0010\u0007¨\u0006\u001e"}, d2 = {"Landroidx/appfunctions/compiler/core/AppFunctionTypeReference;", "", "selfTypeReference", "Lcom/google/devtools/ksp/symbol/KSTypeReference;", "<init>", "(Lcom/google/devtools/ksp/symbol/KSTypeReference;)V", "getSelfTypeReference", "()Lcom/google/devtools/ksp/symbol/KSTypeReference;", "typeCategory", "Landroidx/appfunctions/compiler/core/AppFunctionTypeReference$AppFunctionSupportedTypeCategory;", "getTypeCategory", "()Landroidx/appfunctions/compiler/core/AppFunctionTypeReference$AppFunctionSupportedTypeCategory;", "typeCategory$delegate", "Lkotlin/Lazy;", "isNullable", "", "()Z", "isNullable$delegate", "itemTypeReference", "getItemTypeReference", "itemTypeReference$delegate", "selfOrItemTypeReference", "getSelfOrItemTypeReference", "selfOrItemTypeReference$delegate", "isOfTypeCategory", IntrospectionHelper.AppFunctionSchemaDefinitionAnnotation.PROPERTY_CATEGORY, "getTypeDefaultValueAsString", "", "AppFunctionSupportedTypeCategory", "Companion", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppFunctionTypeReference {
    private static final String ANDROID_URI = "android.net.Uri";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Set<String> SUPPORTED_ARRAY_PRIMITIVE_TYPES;
    private static final Set<String> SUPPORTED_PRIMITIVE_TYPES_IN_LIST;
    private static final Set<String> SUPPORTED_SINGLE_PRIMITIVE_TYPES;
    private static final Set<String> SUPPORTED_SINGLE_SERIALIZABLE_PROXY_TYPES;
    private static final Set<String> SUPPORTED_TYPES;
    private static final String SUPPORTED_TYPES_STRING;
    private static final Map<String, String> TYPE_TO_DEFAULT_VALUE_MAP;

    /* JADX INFO: renamed from: isNullable$delegate, reason: from kotlin metadata */
    private final Lazy isNullable;

    /* JADX INFO: renamed from: itemTypeReference$delegate, reason: from kotlin metadata */
    private final Lazy itemTypeReference;

    /* JADX INFO: renamed from: selfOrItemTypeReference$delegate, reason: from kotlin metadata */
    private final Lazy selfOrItemTypeReference;
    private final KSTypeReference selfTypeReference;

    /* JADX INFO: renamed from: typeCategory$delegate, reason: from kotlin metadata */
    private final Lazy typeCategory;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Landroidx/appfunctions/compiler/core/AppFunctionTypeReference$AppFunctionSupportedTypeCategory;", "", "<init>", "(Ljava/lang/String;I)V", "PRIMITIVE_SINGULAR", "PRIMITIVE_ARRAY", "PRIMITIVE_LIST", "SERIALIZABLE_SINGULAR", "SERIALIZABLE_LIST", "SERIALIZABLE_PROXY_SINGULAR", "SERIALIZABLE_PROXY_LIST", "SERIALIZABLE_INTERFACE_SINGULAR", "SERIALIZABLE_INTERFACE_LIST", "PARCELABLE_SINGULAR", "PARCELABLE_LIST", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AppFunctionSupportedTypeCategory {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ AppFunctionSupportedTypeCategory[] $VALUES;
        public static final AppFunctionSupportedTypeCategory PRIMITIVE_SINGULAR = new AppFunctionSupportedTypeCategory("PRIMITIVE_SINGULAR", 0);
        public static final AppFunctionSupportedTypeCategory PRIMITIVE_ARRAY = new AppFunctionSupportedTypeCategory("PRIMITIVE_ARRAY", 1);
        public static final AppFunctionSupportedTypeCategory PRIMITIVE_LIST = new AppFunctionSupportedTypeCategory("PRIMITIVE_LIST", 2);
        public static final AppFunctionSupportedTypeCategory SERIALIZABLE_SINGULAR = new AppFunctionSupportedTypeCategory("SERIALIZABLE_SINGULAR", 3);
        public static final AppFunctionSupportedTypeCategory SERIALIZABLE_LIST = new AppFunctionSupportedTypeCategory("SERIALIZABLE_LIST", 4);
        public static final AppFunctionSupportedTypeCategory SERIALIZABLE_PROXY_SINGULAR = new AppFunctionSupportedTypeCategory("SERIALIZABLE_PROXY_SINGULAR", 5);
        public static final AppFunctionSupportedTypeCategory SERIALIZABLE_PROXY_LIST = new AppFunctionSupportedTypeCategory("SERIALIZABLE_PROXY_LIST", 6);
        public static final AppFunctionSupportedTypeCategory SERIALIZABLE_INTERFACE_SINGULAR = new AppFunctionSupportedTypeCategory("SERIALIZABLE_INTERFACE_SINGULAR", 7);
        public static final AppFunctionSupportedTypeCategory SERIALIZABLE_INTERFACE_LIST = new AppFunctionSupportedTypeCategory("SERIALIZABLE_INTERFACE_LIST", 8);
        public static final AppFunctionSupportedTypeCategory PARCELABLE_SINGULAR = new AppFunctionSupportedTypeCategory("PARCELABLE_SINGULAR", 9);
        public static final AppFunctionSupportedTypeCategory PARCELABLE_LIST = new AppFunctionSupportedTypeCategory("PARCELABLE_LIST", 10);

        private static final /* synthetic */ AppFunctionSupportedTypeCategory[] $values() {
            return new AppFunctionSupportedTypeCategory[]{PRIMITIVE_SINGULAR, PRIMITIVE_ARRAY, PRIMITIVE_LIST, SERIALIZABLE_SINGULAR, SERIALIZABLE_LIST, SERIALIZABLE_PROXY_SINGULAR, SERIALIZABLE_PROXY_LIST, SERIALIZABLE_INTERFACE_SINGULAR, SERIALIZABLE_INTERFACE_LIST, PARCELABLE_SINGULAR, PARCELABLE_LIST};
        }

        static {
            AppFunctionSupportedTypeCategory[] appFunctionSupportedTypeCategoryArr$values = $values();
            $VALUES = appFunctionSupportedTypeCategoryArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(appFunctionSupportedTypeCategoryArr$values);
        }

        private AppFunctionSupportedTypeCategory(String str, int i) {
        }

        public static EnumEntries<AppFunctionSupportedTypeCategory> getEntries() {
            return $ENTRIES;
        }

        public static AppFunctionSupportedTypeCategory valueOf(String str) {
            return (AppFunctionSupportedTypeCategory) Enum.valueOf(AppFunctionSupportedTypeCategory.class, str);
        }

        public static AppFunctionSupportedTypeCategory[] values() {
            return (AppFunctionSupportedTypeCategory[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\b\n\u0002\u0010$\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u0005J\n\u0010\u000b\u001a\u00020\f*\u00020\u0007J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\f\u0010\u0016\u001a\u00020\u0005*\u00020\u0007H\u0002J\f\u0010\u0017\u001a\u00020\u0018*\u00020\u0018H\u0002J\f\u0010\u0019\u001a\u00020\u001a*\u00020\u0007H\u0002R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001a0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\"\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001a\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0&X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Landroidx/appfunctions/compiler/core/AppFunctionTypeReference$Companion;", "", "<init>", "()V", "isAllowToBeOptional", "", "typeReference", "Lcom/google/devtools/ksp/symbol/KSTypeReference;", "isSupportedType", "typeReferenceArgument", "allowSerializableInterfaceTypes", "toAppFunctionDatatype", "", "isSupportedPrimitiveListType", "isAppFunctionSerializableListType", "isAppFunctionSerializableType", "isAppFunctionSerializableProxyListType", "isAppFunctionSerializableProxyType", "isAppFunctionSerializableInterfaceType", "isAppFunctionSerializableInterfaceListType", "isParcelableType", "isParcelableListType", "isListType", "ignoreNullable", "Lcom/squareup/kotlinpoet/TypeName;", "asStringWithoutNullQualifier", "", "ANDROID_URI", "SUPPORTED_ARRAY_PRIMITIVE_TYPES", "", "SUPPORTED_SINGLE_PRIMITIVE_TYPES", "SUPPORTED_SINGLE_SERIALIZABLE_PROXY_TYPES", "SUPPORTED_PRIMITIVE_TYPES_IN_LIST", "SUPPORTED_TYPES", "SUPPORTED_TYPES_STRING", "getSUPPORTED_TYPES_STRING", "()Ljava/lang/String;", "TYPE_TO_DEFAULT_VALUE_MAP", "", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String asStringWithoutNullQualifier(KSTypeReference kSTypeReference) {
            return ignoreNullable(KspUtilsKt.toTypeName(kSTypeReference)).toString();
        }

        private final TypeName ignoreNullable(TypeName typeName) {
            return TypeName.copy$default(typeName, false, null, 2, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isAppFunctionSerializableInterfaceListType(KSTypeReference typeReferenceArgument) throws ProcessingException {
            if (!isListType(typeReferenceArgument)) {
                return false;
            }
            KspUtilsKt.resolveListParameterizedType(typeReferenceArgument);
            return isAppFunctionSerializableInterfaceType(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isAppFunctionSerializableInterfaceType(KSTypeReference typeReferenceArgument) {
            typeReferenceArgument.resolve();
            throw null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isAppFunctionSerializableListType(KSTypeReference typeReferenceArgument) throws ProcessingException {
            if (!isListType(typeReferenceArgument)) {
                return false;
            }
            KspUtilsKt.resolveListParameterizedType(typeReferenceArgument);
            return isAppFunctionSerializableType(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isAppFunctionSerializableProxyListType(KSTypeReference typeReferenceArgument) throws ProcessingException {
            if (!isListType(typeReferenceArgument)) {
                return false;
            }
            KspUtilsKt.resolveListParameterizedType(typeReferenceArgument);
            return isAppFunctionSerializableProxyType(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isAppFunctionSerializableProxyType(KSTypeReference typeReferenceArgument) {
            if (AppFunctionTypeReference.SUPPORTED_SINGLE_SERIALIZABLE_PROXY_TYPES.contains(asStringWithoutNullQualifier(typeReferenceArgument))) {
                return true;
            }
            typeReferenceArgument.resolve();
            throw null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isAppFunctionSerializableType(KSTypeReference typeReferenceArgument) {
            typeReferenceArgument.resolve();
            throw null;
        }

        private final boolean isListType(KSTypeReference kSTypeReference) {
            return KspUtilsKt.isOfType(kSTypeReference, TypeNames.LIST);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isParcelableListType(KSTypeReference typeReference) throws ProcessingException {
            if (!isListType(typeReference)) {
                return false;
            }
            KspUtilsKt.resolveListParameterizedType(typeReference);
            return isParcelableType(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isParcelableType(KSTypeReference typeReference) {
            typeReference.resolve();
            throw null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isSupportedPrimitiveListType(KSTypeReference typeReferenceArgument) throws ProcessingException {
            if (!isListType(typeReferenceArgument)) {
                return false;
            }
            Set set = AppFunctionTypeReference.SUPPORTED_PRIMITIVE_TYPES_IN_LIST;
            KspUtilsKt.resolveListParameterizedType(typeReferenceArgument);
            return set.contains(asStringWithoutNullQualifier(null));
        }

        public static /* synthetic */ boolean isSupportedType$default(Companion companion, KSTypeReference kSTypeReference, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return companion.isSupportedType(kSTypeReference, z);
        }

        public final String getSUPPORTED_TYPES_STRING() {
            return AppFunctionTypeReference.SUPPORTED_TYPES_STRING;
        }

        public final boolean isAllowToBeOptional(KSTypeReference typeReference) {
            typeReference.getClass();
            typeReference.resolve();
            throw null;
        }

        public final boolean isSupportedType(KSTypeReference typeReferenceArgument, boolean allowSerializableInterfaceTypes) {
            typeReferenceArgument.getClass();
            return (allowSerializableInterfaceTypes && (isAppFunctionSerializableInterfaceType(typeReferenceArgument) || isAppFunctionSerializableInterfaceListType(typeReferenceArgument))) || AppFunctionTypeReference.SUPPORTED_TYPES.contains(asStringWithoutNullQualifier(typeReferenceArgument)) || isSupportedPrimitiveListType(typeReferenceArgument) || isAppFunctionSerializableType(typeReferenceArgument) || isAppFunctionSerializableListType(typeReferenceArgument) || isAppFunctionSerializableProxyListType(typeReferenceArgument) || isParcelableType(typeReferenceArgument) || isParcelableListType(typeReferenceArgument);
        }

        public final int toAppFunctionDatatype(KSTypeReference kSTypeReference) {
            kSTypeReference.getClass();
            String string = ignoreNullable(KspUtilsKt.toTypeName(kSTypeReference)).toString();
            if (Intrinsics.areEqual(string, KspUtilsKt.ensureQualifiedName((KClass<?>) Reflection.getOrCreateKotlinClass(String.class)))) {
                return 8;
            }
            if (Intrinsics.areEqual(string, KspUtilsKt.ensureQualifiedName((KClass<?>) Reflection.getOrCreateKotlinClass(Integer.TYPE)))) {
                return 7;
            }
            if (Intrinsics.areEqual(string, KspUtilsKt.ensureQualifiedName((KClass<?>) Reflection.getOrCreateKotlinClass(Long.TYPE)))) {
                return 6;
            }
            if (Intrinsics.areEqual(string, KspUtilsKt.ensureQualifiedName((KClass<?>) Reflection.getOrCreateKotlinClass(Float.TYPE)))) {
                return 5;
            }
            if (Intrinsics.areEqual(string, KspUtilsKt.ensureQualifiedName((KClass<?>) Reflection.getOrCreateKotlinClass(Double.TYPE)))) {
                return 4;
            }
            if (Intrinsics.areEqual(string, KspUtilsKt.ensureQualifiedName((KClass<?>) Reflection.getOrCreateKotlinClass(Boolean.TYPE)))) {
                return 1;
            }
            if (Intrinsics.areEqual(string, KspUtilsKt.ensureQualifiedName((KClass<?>) Reflection.getOrCreateKotlinClass(Unit.class)))) {
                return 0;
            }
            if (Intrinsics.areEqual(string, KspUtilsKt.ensureQualifiedName((KClass<?>) Reflection.getOrCreateKotlinClass(Byte.TYPE)))) {
                return 2;
            }
            if (Intrinsics.areEqual(string, KspUtilsKt.ensureQualifiedName((KClass<?>) Reflection.getOrCreateKotlinClass(int[].class)))) {
                return 7;
            }
            if (Intrinsics.areEqual(string, KspUtilsKt.ensureQualifiedName((KClass<?>) Reflection.getOrCreateKotlinClass(long[].class)))) {
                return 6;
            }
            if (Intrinsics.areEqual(string, KspUtilsKt.ensureQualifiedName((KClass<?>) Reflection.getOrCreateKotlinClass(float[].class)))) {
                return 5;
            }
            if (Intrinsics.areEqual(string, KspUtilsKt.ensureQualifiedName((KClass<?>) Reflection.getOrCreateKotlinClass(double[].class)))) {
                return 4;
            }
            if (Intrinsics.areEqual(string, KspUtilsKt.ensureQualifiedName((KClass<?>) Reflection.getOrCreateKotlinClass(boolean[].class)))) {
                return 1;
            }
            if (Intrinsics.areEqual(string, KspUtilsKt.ensureQualifiedName((KClass<?>) Reflection.getOrCreateKotlinClass(byte[].class)))) {
                return 2;
            }
            KspUtilsKt.ensureQualifiedTypeName(kSTypeReference);
            throw null;
        }

        private Companion() {
        }
    }

    static {
        Set<String> of = SetsKt.setOf((Object[]) new String[]{KspUtilsKt.ensureQualifiedName((KClass<?>) Reflection.getOrCreateKotlinClass(int[].class)), KspUtilsKt.ensureQualifiedName((KClass<?>) Reflection.getOrCreateKotlinClass(long[].class)), KspUtilsKt.ensureQualifiedName((KClass<?>) Reflection.getOrCreateKotlinClass(float[].class)), KspUtilsKt.ensureQualifiedName((KClass<?>) Reflection.getOrCreateKotlinClass(double[].class)), KspUtilsKt.ensureQualifiedName((KClass<?>) Reflection.getOrCreateKotlinClass(boolean[].class))});
        SUPPORTED_ARRAY_PRIMITIVE_TYPES = of;
        Set<String> of2 = SetsKt.setOf((Object[]) new String[]{KspUtilsKt.ensureQualifiedName((KClass<?>) Reflection.getOrCreateKotlinClass(Integer.TYPE)), KspUtilsKt.ensureQualifiedName((KClass<?>) Reflection.getOrCreateKotlinClass(Long.TYPE)), KspUtilsKt.ensureQualifiedName((KClass<?>) Reflection.getOrCreateKotlinClass(Float.TYPE)), KspUtilsKt.ensureQualifiedName((KClass<?>) Reflection.getOrCreateKotlinClass(Double.TYPE)), KspUtilsKt.ensureQualifiedName((KClass<?>) Reflection.getOrCreateKotlinClass(Boolean.TYPE)), KspUtilsKt.ensureQualifiedName((KClass<?>) Reflection.getOrCreateKotlinClass(String.class)), KspUtilsKt.ensureQualifiedName((KClass<?>) Reflection.getOrCreateKotlinClass(Unit.class)), KspUtilsKt.ensureQualifiedName((KClass<?>) Reflection.getOrCreateKotlinClass(byte[].class))});
        SUPPORTED_SINGLE_PRIMITIVE_TYPES = of2;
        Set<String> of3 = SetsKt.setOf((Object[]) new String[]{KspUtilsKt.ensureQualifiedName((KClass<?>) Reflection.getOrCreateKotlinClass(LocalDateTime.class)), ANDROID_URI, KspUtilsKt.ensureQualifiedName((KClass<?>) Reflection.getOrCreateKotlinClass(ZoneId.class)), KspUtilsKt.ensureQualifiedName((KClass<?>) Reflection.getOrCreateKotlinClass(Instant.class))});
        SUPPORTED_SINGLE_SERIALIZABLE_PROXY_TYPES = of3;
        Set<String> of4 = SetsKt.setOf(KspUtilsKt.ensureQualifiedName((KClass<?>) Reflection.getOrCreateKotlinClass(String.class)));
        SUPPORTED_PRIMITIVE_TYPES_IN_LIST = of4;
        Set<String> setPlus = SetsKt.plus(SetsKt.plus((Set) of2, (Iterable) of), (Iterable) of3);
        SUPPORTED_TYPES = setPlus;
        SUPPORTED_TYPES_STRING = FileInsert$$ExternalSyntheticOutline0.m$1(CollectionsKt.joinToString$default(setPlus, ",\n", null, null, null, 62), "\nLists of ", CollectionsKt.joinToString$default(of4, ", ", null, null, null, 62));
        TYPE_TO_DEFAULT_VALUE_MAP = MapsKt.mapOf(TuplesKt.to(TypeNames.INT.getCanonicalName(), AppEventsConstants.EVENT_PARAM_VALUE_NO), TuplesKt.to(TypeNames.LONG.getCanonicalName(), "0L"), TuplesKt.to(TypeNames.DOUBLE.getCanonicalName(), "0.0"), TuplesKt.to(TypeNames.FLOAT.getCanonicalName(), "0.0f"), TuplesKt.to(TypeNames.BOOLEAN.getCanonicalName(), "false"), TuplesKt.to(TypeNames.INT_ARRAY.getCanonicalName(), "intArrayOf()"), TuplesKt.to(TypeNames.LONG_ARRAY.getCanonicalName(), "longArrayOf()"), TuplesKt.to(TypeNames.BYTE_ARRAY.getCanonicalName(), "byteArrayOf()"), TuplesKt.to(TypeNames.DOUBLE_ARRAY.getCanonicalName(), "doubleArrayOf()"), TuplesKt.to(TypeNames.FLOAT_ARRAY.getCanonicalName(), "floatArrayOf()"), TuplesKt.to(TypeNames.BOOLEAN_ARRAY.getCanonicalName(), "booleanArrayOf()"), TuplesKt.to(TypeNames.LIST.getCanonicalName(), "emptyList()"));
    }

    public AppFunctionTypeReference(KSTypeReference kSTypeReference) {
        kSTypeReference.getClass();
        final int i = 0;
        this.typeCategory = LazyKt.lazy(new Function0(this) { // from class: androidx.appfunctions.compiler.core.AppFunctionTypeReference$$ExternalSyntheticLambda0
            public final /* synthetic */ AppFunctionTypeReference f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() throws ProcessingException {
                int i2 = i;
                AppFunctionTypeReference appFunctionTypeReference = this.f$0;
                switch (i2) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        AppFunctionTypeReference.itemTypeReference_delegate$lambda$0(appFunctionTypeReference);
                        break;
                    default:
                        AppFunctionTypeReference.selfOrItemTypeReference_delegate$lambda$0(appFunctionTypeReference);
                        break;
                }
                return null;
            }
        });
        final int i2 = 1;
        this.isNullable = LazyKt.lazy(new Function0(this) { // from class: androidx.appfunctions.compiler.core.AppFunctionTypeReference$$ExternalSyntheticLambda0
            public final /* synthetic */ AppFunctionTypeReference f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() throws ProcessingException {
                int i22 = i2;
                AppFunctionTypeReference appFunctionTypeReference = this.f$0;
                switch (i22) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        AppFunctionTypeReference.itemTypeReference_delegate$lambda$0(appFunctionTypeReference);
                        break;
                    default:
                        AppFunctionTypeReference.selfOrItemTypeReference_delegate$lambda$0(appFunctionTypeReference);
                        break;
                }
                return null;
            }
        });
        final int i3 = 2;
        this.itemTypeReference = LazyKt.lazy(new Function0(this) { // from class: androidx.appfunctions.compiler.core.AppFunctionTypeReference$$ExternalSyntheticLambda0
            public final /* synthetic */ AppFunctionTypeReference f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() throws ProcessingException {
                int i22 = i3;
                AppFunctionTypeReference appFunctionTypeReference = this.f$0;
                switch (i22) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        AppFunctionTypeReference.itemTypeReference_delegate$lambda$0(appFunctionTypeReference);
                        break;
                    default:
                        AppFunctionTypeReference.selfOrItemTypeReference_delegate$lambda$0(appFunctionTypeReference);
                        break;
                }
                return null;
            }
        });
        final int i4 = 3;
        this.selfOrItemTypeReference = LazyKt.lazy(new Function0(this) { // from class: androidx.appfunctions.compiler.core.AppFunctionTypeReference$$ExternalSyntheticLambda0
            public final /* synthetic */ AppFunctionTypeReference f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() throws ProcessingException {
                int i22 = i4;
                AppFunctionTypeReference appFunctionTypeReference = this.f$0;
                switch (i22) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        AppFunctionTypeReference.itemTypeReference_delegate$lambda$0(appFunctionTypeReference);
                        break;
                    default:
                        AppFunctionTypeReference.selfOrItemTypeReference_delegate$lambda$0(appFunctionTypeReference);
                        break;
                }
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isNullable_delegate$lambda$0(AppFunctionTypeReference appFunctionTypeReference) {
        appFunctionTypeReference.getClass();
        return KspUtilsKt.toTypeName((KSTypeReference) null).getIsNullable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KSTypeReference itemTypeReference_delegate$lambda$0(AppFunctionTypeReference appFunctionTypeReference) throws ProcessingException {
        appFunctionTypeReference.getClass();
        if (KspUtilsKt.isOfType(null, TypeNames.LIST)) {
            KspUtilsKt.resolveListParameterizedType(null);
            return null;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("Type reference is not a list");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KSTypeReference selfOrItemTypeReference_delegate$lambda$0(AppFunctionTypeReference appFunctionTypeReference) {
        appFunctionTypeReference.getClass();
        if (KspUtilsKt.isOfType(null, TypeNames.LIST)) {
            appFunctionTypeReference.getItemTypeReference();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppFunctionSupportedTypeCategory typeCategory_delegate$lambda$0(AppFunctionTypeReference appFunctionTypeReference) {
        Set<String> set = SUPPORTED_SINGLE_PRIMITIVE_TYPES;
        Companion companion = INSTANCE;
        appFunctionTypeReference.getClass();
        if (set.contains(companion.asStringWithoutNullQualifier(null))) {
            return AppFunctionSupportedTypeCategory.PRIMITIVE_SINGULAR;
        }
        if (SUPPORTED_ARRAY_PRIMITIVE_TYPES.contains(companion.asStringWithoutNullQualifier(null))) {
            return AppFunctionSupportedTypeCategory.PRIMITIVE_ARRAY;
        }
        if (companion.isAppFunctionSerializableProxyType(null)) {
            return AppFunctionSupportedTypeCategory.SERIALIZABLE_PROXY_SINGULAR;
        }
        if (companion.isSupportedPrimitiveListType(null)) {
            return AppFunctionSupportedTypeCategory.PRIMITIVE_LIST;
        }
        if (companion.isAppFunctionSerializableProxyListType(null)) {
            return AppFunctionSupportedTypeCategory.SERIALIZABLE_PROXY_LIST;
        }
        if (companion.isAppFunctionSerializableListType(null)) {
            return AppFunctionSupportedTypeCategory.SERIALIZABLE_LIST;
        }
        if (companion.isAppFunctionSerializableType(null)) {
            return AppFunctionSupportedTypeCategory.SERIALIZABLE_SINGULAR;
        }
        if (companion.isAppFunctionSerializableInterfaceType(null)) {
            return AppFunctionSupportedTypeCategory.SERIALIZABLE_INTERFACE_SINGULAR;
        }
        if (companion.isAppFunctionSerializableInterfaceListType(null)) {
            return AppFunctionSupportedTypeCategory.SERIALIZABLE_INTERFACE_LIST;
        }
        if (companion.isParcelableType(null)) {
            return AppFunctionSupportedTypeCategory.PARCELABLE_SINGULAR;
        }
        if (companion.isParcelableListType(null)) {
            return AppFunctionSupportedTypeCategory.PARCELABLE_LIST;
        }
        KspUtilsKt.ensureQualifiedTypeName(null);
        throw null;
    }

    public final KSTypeReference getItemTypeReference() {
        if (this.itemTypeReference.getValue() == null) {
            return null;
        }
        Events$$ExternalSyntheticBUOutline0.m();
        return null;
    }

    public final KSTypeReference getSelfOrItemTypeReference() {
        if (this.selfOrItemTypeReference.getValue() == null) {
            return null;
        }
        Events$$ExternalSyntheticBUOutline0.m();
        return null;
    }

    public final KSTypeReference getSelfTypeReference() {
        return null;
    }

    public final AppFunctionSupportedTypeCategory getTypeCategory() {
        return (AppFunctionSupportedTypeCategory) this.typeCategory.getValue();
    }

    public final String getTypeDefaultValueAsString() {
        KspUtilsKt.ensureQualifiedTypeName(null);
        throw null;
    }

    public final boolean isNullable() {
        return ((Boolean) this.isNullable.getValue()).booleanValue();
    }

    public final boolean isOfTypeCategory(AppFunctionSupportedTypeCategory category) {
        category.getClass();
        return getTypeCategory() == category;
    }
}
