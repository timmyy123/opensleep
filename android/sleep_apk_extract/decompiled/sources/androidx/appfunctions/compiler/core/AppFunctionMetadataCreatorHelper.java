package androidx.appfunctions.compiler.core;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.appfunctions.compiler.core.AnnotatedAppFunctionSerializableProxy;
import androidx.appfunctions.compiler.core.AppFunctionTypeReference;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.appfunctions.compiler.core.metadata.AppFunctionAllOfTypeMetadata;
import androidx.appfunctions.compiler.core.metadata.AppFunctionArrayTypeMetadata;
import androidx.appfunctions.compiler.core.metadata.AppFunctionBooleanTypeMetadata;
import androidx.appfunctions.compiler.core.metadata.AppFunctionBytesTypeMetadata;
import androidx.appfunctions.compiler.core.metadata.AppFunctionDataTypeMetadata;
import androidx.appfunctions.compiler.core.metadata.AppFunctionDoubleTypeMetadata;
import androidx.appfunctions.compiler.core.metadata.AppFunctionFloatTypeMetadata;
import androidx.appfunctions.compiler.core.metadata.AppFunctionIntTypeMetadata;
import androidx.appfunctions.compiler.core.metadata.AppFunctionLongTypeMetadata;
import androidx.appfunctions.compiler.core.metadata.AppFunctionObjectTypeMetadata;
import androidx.appfunctions.compiler.core.metadata.AppFunctionOneOfTypeMetadata;
import androidx.appfunctions.compiler.core.metadata.AppFunctionParameterMetadata;
import androidx.appfunctions.compiler.core.metadata.AppFunctionParcelableTypeMetadata;
import androidx.appfunctions.compiler.core.metadata.AppFunctionReferenceTypeMetadata;
import androidx.appfunctions.compiler.core.metadata.AppFunctionSchemaMetadata;
import androidx.appfunctions.compiler.core.metadata.AppFunctionStringTypeMetadata;
import androidx.appfunctions.compiler.core.metadata.AppFunctionUnitTypeMetadata;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.devtools.ksp.UtilsKt;
import com.google.devtools.ksp.symbol.KSAnnotation;
import com.google.devtools.ksp.symbol.KSClassDeclaration;
import com.google.devtools.ksp.symbol.KSPropertyDeclaration;
import com.google.devtools.ksp.symbol.KSTypeReference;
import com.google.devtools.ksp.symbol.KSValueParameter;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt__StringsKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001<B\u001d\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nJd\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003JP\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\n0\u001fJV\u0010 \u001a\u00020\u0015*\u00020\u001d2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00172\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u00042\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0\u001fH\u0002JV\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020(0\u00142\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00172\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0002JV\u0010)\u001a\u00020$2\u0006\u0010%\u001a\u00020*2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020(0\u00142\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00172\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0002Jl\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00042\f\u0010.\u001a\b\u0012\u0004\u0012\u00020(0\r2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020(0\u00142\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00172\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\u0004H\u0002JX\u00100\u001a\u00020,2\u0006\u00101\u001a\u00020\u00042\f\u00102\u001a\b\u0012\u0004\u0012\u00020(0\r2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00172\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\u0004H\u0002J\f\u00103\u001a\u000204*\u000205H\u0002J\f\u00106\u001a\u000204*\u000205H\u0002J\u0018\u00107\u001a\u00020*2\u0006\u00108\u001a\u0002052\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J.\u00109\u001a\u00020\u00152\u0006\u0010:\u001a\u0002042\u0006\u0010;\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u00042\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0\u001fH\u0002R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Landroidx/appfunctions/compiler/core/AppFunctionMetadataCreatorHelper;", "", "sharedDataTypeDescriptionMap", "", "", "<init>", "(Ljava/util/Map;)V", "computeAppFunctionAnnotationProperties", "Landroidx/appfunctions/compiler/core/AppFunctionMetadataCreatorHelper$AppFunctionAnnotationProperties;", "appFunctionAnnotation", "Lcom/google/devtools/ksp/symbol/KSAnnotation;", "schemaDefinitionAnnotation", "buildParameterTypeMetadataList", "", "Landroidx/appfunctions/compiler/core/metadata/AppFunctionParameterMetadata;", IntrospectionHelper.AppFunctionInvokerClass.UnsafeInvokeMethod.PARAMETERS_PARAM_NAME, "Lcom/google/devtools/ksp/symbol/KSValueParameter;", "resolvedAnnotatedSerializableProxies", "Landroidx/appfunctions/compiler/core/AnnotatedAppFunctionSerializableProxy$ResolvedAnnotatedSerializableProxies;", "sharedDataTypeMap", "", "Landroidx/appfunctions/compiler/core/metadata/AppFunctionDataTypeMetadata;", "seenDataTypeQualifiers", "", "allowSerializableInterfaceTypes", "", "parameterDescriptionMap", "buildResponseTypeMetadata", "returnType", "Lcom/google/devtools/ksp/symbol/KSTypeReference;", "functionAnnotations", "Lkotlin/sequences/Sequence;", "toAppFunctionDataTypeMetadata", "description", "annotations", "addOneOfSerializableTypeMetadataToSharedDataTypeMap", "", "annotatedSerializable", "Landroidx/appfunctions/compiler/core/AnnotatedOneOfAppFunctionSerializable;", "unvisitedSerializableProperties", "Landroidx/appfunctions/compiler/core/AppFunctionPropertyDeclaration;", "addSerializableTypeMetadataToSharedDataTypeMap", "Landroidx/appfunctions/compiler/core/AppFunctionSerializableType;", "buildObjectTypeMetadataForObjectParameters", "Landroidx/appfunctions/compiler/core/metadata/AppFunctionObjectTypeMetadata;", "typeQualifiedName", "currentPropertiesList", "serializableDescription", "buildObjectTypeMetadataForObjectProperty", "serializableTypeQualifiedName", "currentSerializableProperties", "toAppFunctionDataType", "", "Landroidx/appfunctions/compiler/core/AppFunctionTypeReference;", "determineArrayItemType", "getAnnotatedAppFunctionSerializable", "appFunctionTypeReference", "createPrimitiveDataTypeMetadata", "primitiveType", "isNullable", "AppFunctionAnnotationProperties", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppFunctionMetadataCreatorHelper {
    private final Map<String, String> sharedDataTypeDescriptionMap;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003JJ\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0014\u0010\u001d\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001f\u001a\u00020 HÖ\u0081\u0004J\n\u0010!\u001a\u00020\u0006HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0002\u0010\fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0004\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006\""}, d2 = {"Landroidx/appfunctions/compiler/core/AppFunctionMetadataCreatorHelper$AppFunctionAnnotationProperties;", "", "isEnabledByDefault", "", "isDescribedByKDoc", "schemaName", "", "schemaVersion", "", "schemaCategory", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSchemaName", "()Ljava/lang/String;", "getSchemaVersion", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSchemaCategory", "getAppFunctionSchemaMetadata", "Landroidx/appfunctions/compiler/core/metadata/AppFunctionSchemaMetadata;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)Landroidx/appfunctions/compiler/core/AppFunctionMetadataCreatorHelper$AppFunctionAnnotationProperties;", "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class AppFunctionAnnotationProperties {
        private final Boolean isDescribedByKDoc;
        private final Boolean isEnabledByDefault;
        private final String schemaCategory;
        private final String schemaName;
        private final Long schemaVersion;

        public AppFunctionAnnotationProperties(Boolean bool, Boolean bool2, String str, Long l, String str2) {
            this.isEnabledByDefault = bool;
            this.isDescribedByKDoc = bool2;
            this.schemaName = str;
            this.schemaVersion = l;
            this.schemaCategory = str2;
        }

        public static /* synthetic */ AppFunctionAnnotationProperties copy$default(AppFunctionAnnotationProperties appFunctionAnnotationProperties, Boolean bool, Boolean bool2, String str, Long l, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                bool = appFunctionAnnotationProperties.isEnabledByDefault;
            }
            if ((i & 2) != 0) {
                bool2 = appFunctionAnnotationProperties.isDescribedByKDoc;
            }
            if ((i & 4) != 0) {
                str = appFunctionAnnotationProperties.schemaName;
            }
            if ((i & 8) != 0) {
                l = appFunctionAnnotationProperties.schemaVersion;
            }
            if ((i & 16) != 0) {
                str2 = appFunctionAnnotationProperties.schemaCategory;
            }
            String str3 = str2;
            String str4 = str;
            return appFunctionAnnotationProperties.copy(bool, bool2, str4, l, str3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Boolean getIsEnabledByDefault() {
            return this.isEnabledByDefault;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Boolean getIsDescribedByKDoc() {
            return this.isDescribedByKDoc;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getSchemaName() {
            return this.schemaName;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Long getSchemaVersion() {
            return this.schemaVersion;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getSchemaCategory() {
            return this.schemaCategory;
        }

        public final AppFunctionAnnotationProperties copy(Boolean isEnabledByDefault, Boolean isDescribedByKDoc, String schemaName, Long schemaVersion, String schemaCategory) {
            return new AppFunctionAnnotationProperties(isEnabledByDefault, isDescribedByKDoc, schemaName, schemaVersion, schemaCategory);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AppFunctionAnnotationProperties)) {
                return false;
            }
            AppFunctionAnnotationProperties appFunctionAnnotationProperties = (AppFunctionAnnotationProperties) other;
            return Intrinsics.areEqual(this.isEnabledByDefault, appFunctionAnnotationProperties.isEnabledByDefault) && Intrinsics.areEqual(this.isDescribedByKDoc, appFunctionAnnotationProperties.isDescribedByKDoc) && Intrinsics.areEqual(this.schemaName, appFunctionAnnotationProperties.schemaName) && Intrinsics.areEqual(this.schemaVersion, appFunctionAnnotationProperties.schemaVersion) && Intrinsics.areEqual(this.schemaCategory, appFunctionAnnotationProperties.schemaCategory);
        }

        public final AppFunctionSchemaMetadata getAppFunctionSchemaMetadata() {
            String str = this.schemaName;
            if (str != null) {
                String str2 = this.schemaCategory;
                if (str2 != null) {
                    Long l = this.schemaVersion;
                    if (l != null) {
                        return new AppFunctionSchemaMetadata(str2, str, l.longValue());
                    }
                    Utf8$$ExternalSyntheticBUOutline0.m$3("Required value was null.");
                    return null;
                }
                Utf8$$ExternalSyntheticBUOutline0.m$3("Required value was null.");
            }
            return null;
        }

        public final String getSchemaCategory() {
            return this.schemaCategory;
        }

        public final String getSchemaName() {
            return this.schemaName;
        }

        public final Long getSchemaVersion() {
            return this.schemaVersion;
        }

        public int hashCode() {
            Boolean bool = this.isEnabledByDefault;
            int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
            Boolean bool2 = this.isDescribedByKDoc;
            int iHashCode2 = (iHashCode + (bool2 == null ? 0 : bool2.hashCode())) * 31;
            String str = this.schemaName;
            int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            Long l = this.schemaVersion;
            int iHashCode4 = (iHashCode3 + (l == null ? 0 : l.hashCode())) * 31;
            String str2 = this.schemaCategory;
            return iHashCode4 + (str2 != null ? str2.hashCode() : 0);
        }

        public final Boolean isDescribedByKDoc() {
            return this.isDescribedByKDoc;
        }

        public final Boolean isEnabledByDefault() {
            return this.isEnabledByDefault;
        }

        public String toString() {
            Boolean bool = this.isEnabledByDefault;
            Boolean bool2 = this.isDescribedByKDoc;
            String str = this.schemaName;
            Long l = this.schemaVersion;
            String str2 = this.schemaCategory;
            StringBuilder sb = new StringBuilder("AppFunctionAnnotationProperties(isEnabledByDefault=");
            sb.append(bool);
            sb.append(", isDescribedByKDoc=");
            sb.append(bool2);
            sb.append(", schemaName=");
            sb.append(str);
            sb.append(", schemaVersion=");
            sb.append(l);
            sb.append(", schemaCategory=");
            return FileInsert$$ExternalSyntheticOutline0.m(sb, str2, ")");
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AppFunctionTypeReference.AppFunctionSupportedTypeCategory.values().length];
            try {
                iArr[AppFunctionTypeReference.AppFunctionSupportedTypeCategory.PRIMITIVE_SINGULAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AppFunctionTypeReference.AppFunctionSupportedTypeCategory.PRIMITIVE_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AppFunctionTypeReference.AppFunctionSupportedTypeCategory.PRIMITIVE_LIST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AppFunctionTypeReference.AppFunctionSupportedTypeCategory.SERIALIZABLE_INTERFACE_SINGULAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AppFunctionTypeReference.AppFunctionSupportedTypeCategory.SERIALIZABLE_SINGULAR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AppFunctionTypeReference.AppFunctionSupportedTypeCategory.SERIALIZABLE_INTERFACE_LIST.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[AppFunctionTypeReference.AppFunctionSupportedTypeCategory.SERIALIZABLE_LIST.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[AppFunctionTypeReference.AppFunctionSupportedTypeCategory.SERIALIZABLE_PROXY_SINGULAR.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[AppFunctionTypeReference.AppFunctionSupportedTypeCategory.SERIALIZABLE_PROXY_LIST.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[AppFunctionTypeReference.AppFunctionSupportedTypeCategory.PARCELABLE_SINGULAR.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[AppFunctionTypeReference.AppFunctionSupportedTypeCategory.PARCELABLE_LIST.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ AppFunctionMetadataCreatorHelper(Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? MapsKt.emptyMap() : map);
    }

    private final void addOneOfSerializableTypeMetadataToSharedDataTypeMap(AnnotatedOneOfAppFunctionSerializable annotatedSerializable, Map<String, AppFunctionPropertyDeclaration> unvisitedSerializableProperties, Map<String, AppFunctionDataTypeMetadata> sharedDataTypeMap, Set<String> seenDataTypeQualifiers, AnnotatedAppFunctionSerializableProxy.ResolvedAnnotatedSerializableProxies resolvedAnnotatedSerializableProxies, boolean allowSerializableInterfaceTypes) {
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        for (AnnotatedAppFunctionSerializable annotatedAppFunctionSerializable : annotatedSerializable.getOneOfSerializables()) {
            List<AppFunctionPropertyDeclaration> properties = annotatedAppFunctionSerializable.getProperties(this.sharedDataTypeDescriptionMap);
            LinkedHashMap linkedHashMap = new LinkedHashMap(FileInsert$$ExternalSyntheticOutline0.m((Iterable) properties, 10, 16));
            for (Object obj : properties) {
                String name = ((AppFunctionPropertyDeclaration) obj).getName();
                if (name == null) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("Required value was null.");
                    return;
                }
                linkedHashMap.put(name, obj);
            }
            unvisitedSerializableProperties.putAll(MapsKt.toMutableMap(linkedHashMap));
            Unit unit = Unit.INSTANCE;
            addSerializableTypeMetadataToSharedDataTypeMap(annotatedAppFunctionSerializable, unvisitedSerializableProperties, sharedDataTypeMap, seenDataTypeQualifiers, resolvedAnnotatedSerializableProxies, allowSerializableInterfaceTypes);
            listCreateListBuilder.add(new AppFunctionReferenceTypeMetadata(annotatedAppFunctionSerializable.getJvmQualifiedName(), true, ""));
        }
        sharedDataTypeMap.put(annotatedSerializable.getJvmQualifiedName(), new AppFunctionOneOfTypeMetadata(CollectionsKt.build(listCreateListBuilder), annotatedSerializable.getJvmQualifiedName(), true, annotatedSerializable.getDescription(this.sharedDataTypeDescriptionMap)));
    }

    private final void addSerializableTypeMetadataToSharedDataTypeMap(AppFunctionSerializableType annotatedSerializable, Map<String, AppFunctionPropertyDeclaration> unvisitedSerializableProperties, Map<String, AppFunctionDataTypeMetadata> sharedDataTypeMap, Set<String> seenDataTypeQualifiers, AnnotatedAppFunctionSerializableProxy.ResolvedAnnotatedSerializableProxies resolvedAnnotatedSerializableProxies, boolean allowSerializableInterfaceTypes) {
        String str;
        if (annotatedSerializable instanceof AnnotatedOneOfAppFunctionSerializable) {
            addOneOfSerializableTypeMetadataToSharedDataTypeMap((AnnotatedOneOfAppFunctionSerializable) annotatedSerializable, unvisitedSerializableProperties, sharedDataTypeMap, seenDataTypeQualifiers, resolvedAnnotatedSerializableProxies, allowSerializableInterfaceTypes);
            return;
        }
        Map<String, AppFunctionPropertyDeclaration> map = unvisitedSerializableProperties;
        Map<String, AppFunctionDataTypeMetadata> map2 = sharedDataTypeMap;
        Set<String> set = seenDataTypeQualifiers;
        AnnotatedAppFunctionSerializableProxy.ResolvedAnnotatedSerializableProxies resolvedAnnotatedSerializableProxies2 = resolvedAnnotatedSerializableProxies;
        String jvmQualifiedName = annotatedSerializable instanceof AnnotatedAppFunctionSerializableProxy ? KspUtilsKt.getJvmQualifiedName(((AnnotatedAppFunctionSerializableProxy) annotatedSerializable).getTargetClassDeclaration()) : annotatedSerializable.getJvmQualifiedName();
        if (set.contains(jvmQualifiedName)) {
            return;
        }
        set.add(jvmQualifiedName);
        String description = annotatedSerializable.getDescription(this.sharedDataTypeDescriptionMap);
        Set<KSClassDeclaration> setFindSuperTypesWithSerializableAnnotation = annotatedSerializable.findSuperTypesWithSerializableAnnotation();
        Set<KSClassDeclaration> setFindSuperTypesWithCapabilityAnnotation = annotatedSerializable.findSuperTypesWithCapabilityAnnotation();
        if (setFindSuperTypesWithSerializableAnnotation.isEmpty() && setFindSuperTypesWithCapabilityAnnotation.isEmpty()) {
            map2.put(jvmQualifiedName, buildObjectTypeMetadataForObjectParameters(jvmQualifiedName, annotatedSerializable.getProperties(this.sharedDataTypeDescriptionMap), map, map2, set, resolvedAnnotatedSerializableProxies2, allowSerializableInterfaceTypes, description));
            return;
        }
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        for (KSClassDeclaration kSClassDeclaration : setFindSuperTypesWithSerializableAnnotation) {
            Map<String, AppFunctionPropertyDeclaration> map3 = map;
            Map<String, AppFunctionDataTypeMetadata> map4 = map2;
            Set<String> set2 = set;
            AnnotatedAppFunctionSerializableProxy.ResolvedAnnotatedSerializableProxies resolvedAnnotatedSerializableProxies3 = resolvedAnnotatedSerializableProxies2;
            addSerializableTypeMetadataToSharedDataTypeMap(new AnnotatedAppFunctionSerializable(kSClassDeclaration), map3, map4, set2, resolvedAnnotatedSerializableProxies3, allowSerializableInterfaceTypes);
            resolvedAnnotatedSerializableProxies2 = resolvedAnnotatedSerializableProxies3;
            set = set2;
            map2 = map4;
            map = map3;
            String canonicalName = KspUtilsKt.toClassName(kSClassDeclaration).getCanonicalName();
            if (canonicalName == null) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("Required value was null.");
                return;
            }
            listCreateListBuilder.add(new AppFunctionReferenceTypeMetadata(canonicalName, true, ""));
        }
        for (KSClassDeclaration kSClassDeclaration2 : setFindSuperTypesWithCapabilityAnnotation) {
            String canonicalName2 = KspUtilsKt.toClassName(kSClassDeclaration2).getCanonicalName();
            if (canonicalName2 == null) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("Required value was null.");
                return;
            }
            listCreateListBuilder.add(buildObjectTypeMetadataForObjectParameters(canonicalName2, SequencesKt.toList(SequencesKt.map(UtilsKt.getDeclaredProperties(kSClassDeclaration2), new AppFunctionMetadataCreatorHelper$$ExternalSyntheticLambda0(this, 0))), map, map2, set, resolvedAnnotatedSerializableProxies2, allowSerializableInterfaceTypes, description));
        }
        if (map.isEmpty()) {
            str = jvmQualifiedName;
        } else {
            str = jvmQualifiedName;
            listCreateListBuilder.add(buildObjectTypeMetadataForObjectParameters(str, CollectionsKt.toList(map.values()), map, map2, set, resolvedAnnotatedSerializableProxies2, allowSerializableInterfaceTypes, description));
        }
        map2.put(str, new AppFunctionAllOfTypeMetadata(CollectionsKt.build(listCreateListBuilder), str, true, description));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppFunctionPropertyDeclaration addSerializableTypeMetadataToSharedDataTypeMap$lambda$0$0(AppFunctionMetadataCreatorHelper appFunctionMetadataCreatorHelper, KSPropertyDeclaration kSPropertyDeclaration) {
        kSPropertyDeclaration.getClass();
        return new AppFunctionPropertyDeclaration(kSPropertyDeclaration, false, true, appFunctionMetadataCreatorHelper.sharedDataTypeDescriptionMap);
    }

    private final AppFunctionObjectTypeMetadata buildObjectTypeMetadataForObjectParameters(String typeQualifiedName, List<AppFunctionPropertyDeclaration> currentPropertiesList, Map<String, AppFunctionPropertyDeclaration> unvisitedSerializableProperties, Map<String, AppFunctionDataTypeMetadata> sharedDataTypeMap, Set<String> seenDataTypeQualifiers, AnnotatedAppFunctionSerializableProxy.ResolvedAnnotatedSerializableProxies resolvedAnnotatedSerializableProxies, boolean allowSerializableInterfaceTypes, String serializableDescription) {
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        for (AppFunctionPropertyDeclaration appFunctionPropertyDeclaration : currentPropertiesList) {
            AppFunctionPropertyDeclaration appFunctionPropertyDeclarationRemove = unvisitedSerializableProperties.remove(appFunctionPropertyDeclaration.getName());
            if (appFunctionPropertyDeclarationRemove == null) {
                Utf8$$ExternalSyntheticBUOutline0.m((Object) FileInsert$$ExternalSyntheticOutline0.m$1(appFunctionPropertyDeclaration.getName(), " is not in unvisitedSerializableProperties"));
                return null;
            }
            listCreateListBuilder.add(appFunctionPropertyDeclarationRemove);
        }
        return buildObjectTypeMetadataForObjectProperty(typeQualifiedName, CollectionsKt.build(listCreateListBuilder), sharedDataTypeMap, seenDataTypeQualifiers, resolvedAnnotatedSerializableProxies, allowSerializableInterfaceTypes, serializableDescription);
    }

    private final AppFunctionObjectTypeMetadata buildObjectTypeMetadataForObjectProperty(String serializableTypeQualifiedName, List<AppFunctionPropertyDeclaration> currentSerializableProperties, Map<String, AppFunctionDataTypeMetadata> sharedDataTypeMap, Set<String> seenDataTypeQualifiers, AnnotatedAppFunctionSerializableProxy.ResolvedAnnotatedSerializableProxies resolvedAnnotatedSerializableProxies, boolean allowSerializableInterfaceTypes, String serializableDescription) {
        ArrayList arrayList = new ArrayList();
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        for (AppFunctionPropertyDeclaration appFunctionPropertyDeclaration : currentSerializableProperties) {
            appFunctionPropertyDeclaration.getType();
            String str = this.sharedDataTypeDescriptionMap.get(StringsKt__StringsKt.substringBefore$default(serializableTypeQualifiedName, "<", (String) null, 2, (Object) null) + "#" + appFunctionPropertyDeclaration.getName());
            if (str == null) {
                str = "";
            }
            mapCreateMapBuilder.put(appFunctionPropertyDeclaration.getName(), toAppFunctionDataTypeMetadata(null, sharedDataTypeMap, seenDataTypeQualifiers, resolvedAnnotatedSerializableProxies, allowSerializableInterfaceTypes, str, appFunctionPropertyDeclaration.getPropertyAnnotations()));
            if (appFunctionPropertyDeclaration.isRequired()) {
                arrayList.add(appFunctionPropertyDeclaration.getName());
            }
        }
        return new AppFunctionObjectTypeMetadata(MapsKt.build(mapCreateMapBuilder), arrayList, serializableTypeQualifiedName, true, serializableDescription);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ List buildParameterTypeMetadataList$default(AppFunctionMetadataCreatorHelper appFunctionMetadataCreatorHelper, List list, AnnotatedAppFunctionSerializableProxy.ResolvedAnnotatedSerializableProxies resolvedAnnotatedSerializableProxies, Map map, Set set, boolean z, Map map2, int i, Object obj) {
        if ((i & 16) != 0) {
            z = false;
        }
        boolean z2 = z;
        if ((i & 32) != 0) {
            map2 = MapsKt.emptyMap();
        }
        return appFunctionMetadataCreatorHelper.buildParameterTypeMetadataList(list, resolvedAnnotatedSerializableProxies, map, set, z2, map2);
    }

    public static /* synthetic */ AppFunctionDataTypeMetadata buildResponseTypeMetadata$default(AppFunctionMetadataCreatorHelper appFunctionMetadataCreatorHelper, KSTypeReference kSTypeReference, AnnotatedAppFunctionSerializableProxy.ResolvedAnnotatedSerializableProxies resolvedAnnotatedSerializableProxies, Map map, Set set, boolean z, Sequence sequence, int i, Object obj) {
        if ((i & 16) != 0) {
            z = false;
        }
        return appFunctionMetadataCreatorHelper.buildResponseTypeMetadata(kSTypeReference, resolvedAnnotatedSerializableProxies, map, set, z, sequence);
    }

    public static /* synthetic */ AppFunctionAnnotationProperties computeAppFunctionAnnotationProperties$default(AppFunctionMetadataCreatorHelper appFunctionMetadataCreatorHelper, KSAnnotation kSAnnotation, KSAnnotation kSAnnotation2, int i, Object obj) {
        if ((i & 1) != 0) {
            kSAnnotation = null;
        }
        if ((i & 2) != 0) {
            kSAnnotation2 = null;
        }
        return appFunctionMetadataCreatorHelper.computeAppFunctionAnnotationProperties(kSAnnotation, kSAnnotation2);
    }

    private final AppFunctionDataTypeMetadata createPrimitiveDataTypeMetadata(int primitiveType, boolean isNullable, String description, Sequence<? extends KSAnnotation> annotations) {
        switch (primitiveType) {
            case 0:
                return new AppFunctionUnitTypeMetadata(isNullable, description);
            case 1:
                return new AppFunctionBooleanTypeMetadata(isNullable, description);
            case 2:
                return new AppFunctionBytesTypeMetadata(isNullable, description);
            case 3:
            default:
                Utf8$$ExternalSyntheticBUOutline0.m$3(FileInsert$$ExternalSyntheticOutline0.m(primitiveType, "Unsupported primitive type: "));
                return null;
            case 4:
                return new AppFunctionDoubleTypeMetadata(isNullable, description);
            case 5:
                return new AppFunctionFloatTypeMetadata(isNullable, description);
            case 6:
                return new AppFunctionLongTypeMetadata(isNullable, description);
            case 7:
                return AppFunctionIntTypeMetadata.INSTANCE.create(isNullable, description, annotations);
            case 8:
                return AppFunctionStringTypeMetadata.INSTANCE.create(isNullable, description, annotations);
        }
    }

    private final int determineArrayItemType(AppFunctionTypeReference appFunctionTypeReference) {
        switch (WhenMappings.$EnumSwitchMapping$0[appFunctionTypeReference.getTypeCategory().ordinal()]) {
            case 1:
            case 4:
            case 5:
            case 8:
            case 10:
                appFunctionTypeReference.getSelfTypeReference();
                KspUtilsKt.ensureQualifiedTypeName(null);
                throw null;
            case 2:
                AppFunctionTypeReference.Companion companion = AppFunctionTypeReference.INSTANCE;
                appFunctionTypeReference.getSelfTypeReference();
                return companion.toAppFunctionDatatype(null);
            case 3:
                AppFunctionTypeReference.Companion companion2 = AppFunctionTypeReference.INSTANCE;
                appFunctionTypeReference.getItemTypeReference();
                return companion2.toAppFunctionDatatype(null);
            case 6:
            case 7:
            case 9:
                return 3;
            case 11:
                return 13;
            default:
                Home$$ExternalSyntheticBUOutline0.m();
                return 0;
        }
    }

    private final AppFunctionSerializableType getAnnotatedAppFunctionSerializable(AppFunctionTypeReference appFunctionTypeReference, boolean allowSerializableInterfaceTypes) {
        appFunctionTypeReference.getSelfOrItemTypeReference();
        throw null;
    }

    private final int toAppFunctionDataType(AppFunctionTypeReference appFunctionTypeReference) {
        switch (WhenMappings.$EnumSwitchMapping$0[appFunctionTypeReference.getTypeCategory().ordinal()]) {
            case 1:
                AppFunctionTypeReference.Companion companion = AppFunctionTypeReference.INSTANCE;
                appFunctionTypeReference.getSelfTypeReference();
                return companion.toAppFunctionDatatype(null);
            case 2:
            case 3:
            case 6:
            case 7:
            case 9:
                return 10;
            case 4:
            case 5:
            case 8:
                return 3;
            case 10:
            case 11:
                return 13;
            default:
                Home$$ExternalSyntheticBUOutline0.m();
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppFunctionDataTypeMetadata toAppFunctionDataTypeMetadata(KSTypeReference kSTypeReference, Map<String, AppFunctionDataTypeMetadata> map, Set<String> set, AnnotatedAppFunctionSerializableProxy.ResolvedAnnotatedSerializableProxies resolvedAnnotatedSerializableProxies, boolean z, String str, Sequence<? extends KSAnnotation> sequence) {
        AppFunctionTypeReference appFunctionTypeReference = new AppFunctionTypeReference(kSTypeReference);
        switch (WhenMappings.$EnumSwitchMapping$0[appFunctionTypeReference.getTypeCategory().ordinal()]) {
            case 1:
                return createPrimitiveDataTypeMetadata(toAppFunctionDataType(appFunctionTypeReference), appFunctionTypeReference.isNullable(), str, sequence);
            case 2:
                return new AppFunctionArrayTypeMetadata(createPrimitiveDataTypeMetadata(determineArrayItemType(appFunctionTypeReference), false, "", sequence), appFunctionTypeReference.isNullable(), str);
            case 3:
                int iDetermineArrayItemType = determineArrayItemType(appFunctionTypeReference);
                appFunctionTypeReference.getItemTypeReference();
                return new AppFunctionArrayTypeMetadata(createPrimitiveDataTypeMetadata(iDetermineArrayItemType, new AppFunctionTypeReference(null).isNullable(), "", sequence), appFunctionTypeReference.isNullable(), str);
            case 4:
            case 5:
                AppFunctionSerializableType annotatedAppFunctionSerializable = getAnnotatedAppFunctionSerializable(appFunctionTypeReference, z);
                List<AppFunctionPropertyDeclaration> properties = annotatedAppFunctionSerializable.getProperties(this.sharedDataTypeDescriptionMap);
                LinkedHashMap linkedHashMap = new LinkedHashMap(FileInsert$$ExternalSyntheticOutline0.m((Iterable) properties, 10, 16));
                for (Object obj : properties) {
                    String name = ((AppFunctionPropertyDeclaration) obj).getName();
                    if (name == null) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("Required value was null.");
                        return null;
                    }
                    linkedHashMap.put(name, obj);
                }
                addSerializableTypeMetadataToSharedDataTypeMap(annotatedAppFunctionSerializable, MapsKt.toMutableMap(linkedHashMap), map, set, resolvedAnnotatedSerializableProxies, z);
                return new AppFunctionReferenceTypeMetadata(annotatedAppFunctionSerializable.getJvmQualifiedName(), appFunctionTypeReference.isNullable(), str);
            case 6:
            case 7:
                AppFunctionSerializableType annotatedAppFunctionSerializable2 = getAnnotatedAppFunctionSerializable(appFunctionTypeReference, z);
                List<AppFunctionPropertyDeclaration> properties2 = annotatedAppFunctionSerializable2.getProperties(this.sharedDataTypeDescriptionMap);
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(FileInsert$$ExternalSyntheticOutline0.m((Iterable) properties2, 10, 16));
                for (Object obj2 : properties2) {
                    String name2 = ((AppFunctionPropertyDeclaration) obj2).getName();
                    if (name2 == null) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("Required value was null.");
                        return null;
                    }
                    linkedHashMap2.put(name2, obj2);
                }
                addSerializableTypeMetadataToSharedDataTypeMap(annotatedAppFunctionSerializable2, MapsKt.toMutableMap(linkedHashMap2), map, set, resolvedAnnotatedSerializableProxies, z);
                String jvmQualifiedName = annotatedAppFunctionSerializable2.getJvmQualifiedName();
                appFunctionTypeReference.getItemTypeReference();
                return new AppFunctionArrayTypeMetadata(new AppFunctionReferenceTypeMetadata(jvmQualifiedName, new AppFunctionTypeReference(null).isNullable(), ""), appFunctionTypeReference.isNullable(), str);
            case 8:
                AnnotatedAppFunctionSerializableProxy serializableProxyForTypeReference = resolvedAnnotatedSerializableProxies.getSerializableProxyForTypeReference(appFunctionTypeReference);
                List<AppFunctionPropertyDeclaration> properties3 = serializableProxyForTypeReference.getProperties(this.sharedDataTypeDescriptionMap);
                LinkedHashMap linkedHashMap3 = new LinkedHashMap(FileInsert$$ExternalSyntheticOutline0.m((Iterable) properties3, 10, 16));
                for (Object obj3 : properties3) {
                    String name3 = ((AppFunctionPropertyDeclaration) obj3).getName();
                    if (name3 == null) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("Required value was null.");
                        return null;
                    }
                    linkedHashMap3.put(name3, obj3);
                }
                addSerializableTypeMetadataToSharedDataTypeMap(serializableProxyForTypeReference, MapsKt.toMutableMap(linkedHashMap3), map, set, resolvedAnnotatedSerializableProxies, z);
                appFunctionTypeReference.getSelfTypeReference();
                return new AppFunctionReferenceTypeMetadata(KspUtilsKt.ignoreNullable(KspUtilsKt.toTypeName((KSTypeReference) null)).toString(), appFunctionTypeReference.isNullable(), str);
            case 9:
                AnnotatedAppFunctionSerializableProxy serializableProxyForTypeReference2 = resolvedAnnotatedSerializableProxies.getSerializableProxyForTypeReference(appFunctionTypeReference);
                List<AppFunctionPropertyDeclaration> properties4 = serializableProxyForTypeReference2.getProperties(this.sharedDataTypeDescriptionMap);
                LinkedHashMap linkedHashMap4 = new LinkedHashMap(FileInsert$$ExternalSyntheticOutline0.m((Iterable) properties4, 10, 16));
                for (Object obj4 : properties4) {
                    String name4 = ((AppFunctionPropertyDeclaration) obj4).getName();
                    if (name4 == null) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("Required value was null.");
                        return null;
                    }
                    linkedHashMap4.put(name4, obj4);
                }
                addSerializableTypeMetadataToSharedDataTypeMap(serializableProxyForTypeReference2, MapsKt.toMutableMap(linkedHashMap4), map, set, resolvedAnnotatedSerializableProxies, z);
                appFunctionTypeReference.getItemTypeReference();
                String string = KspUtilsKt.ignoreNullable(KspUtilsKt.toTypeName((KSTypeReference) null)).toString();
                appFunctionTypeReference.getItemTypeReference();
                return new AppFunctionArrayTypeMetadata(new AppFunctionReferenceTypeMetadata(string, new AppFunctionTypeReference(null).isNullable(), ""), appFunctionTypeReference.isNullable(), str);
            case 10:
                appFunctionTypeReference.getSelfTypeReference();
                return new AppFunctionParcelableTypeMetadata(KspUtilsKt.ignoreNullable(KspUtilsKt.toTypeName((KSTypeReference) null)).toString(), appFunctionTypeReference.isNullable(), str);
            case 11:
                appFunctionTypeReference.getItemTypeReference();
                String string2 = KspUtilsKt.ignoreNullable(KspUtilsKt.toTypeName((KSTypeReference) null)).toString();
                appFunctionTypeReference.getItemTypeReference();
                return new AppFunctionArrayTypeMetadata(new AppFunctionParcelableTypeMetadata(string2, new AppFunctionTypeReference(null).isNullable(), ""), appFunctionTypeReference.isNullable(), str);
            default:
                Home$$ExternalSyntheticBUOutline0.m();
                return null;
        }
    }

    public final List<AppFunctionParameterMetadata> buildParameterTypeMetadataList(List<? extends KSValueParameter> parameters, AnnotatedAppFunctionSerializableProxy.ResolvedAnnotatedSerializableProxies resolvedAnnotatedSerializableProxies, Map<String, AppFunctionDataTypeMetadata> sharedDataTypeMap, Set<String> seenDataTypeQualifiers, boolean allowSerializableInterfaceTypes, Map<String, String> parameterDescriptionMap) {
        parameters.getClass();
        resolvedAnnotatedSerializableProxies.getClass();
        sharedDataTypeMap.getClass();
        seenDataTypeQualifiers.getClass();
        parameterDescriptionMap.getClass();
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        Iterator<? extends KSValueParameter> it = parameters.iterator();
        if (it.hasNext()) {
            throw FileInsert$$ExternalSyntheticOutline0.m((Iterator) it);
        }
        return CollectionsKt.build(listCreateListBuilder);
    }

    public final AppFunctionDataTypeMetadata buildResponseTypeMetadata(KSTypeReference returnType, AnnotatedAppFunctionSerializableProxy.ResolvedAnnotatedSerializableProxies resolvedAnnotatedSerializableProxies, Map<String, AppFunctionDataTypeMetadata> sharedDataTypeMap, Set<String> seenDataTypeQualifiers, boolean allowSerializableInterfaceTypes, Sequence<? extends KSAnnotation> functionAnnotations) {
        returnType.getClass();
        resolvedAnnotatedSerializableProxies.getClass();
        sharedDataTypeMap.getClass();
        seenDataTypeQualifiers.getClass();
        functionAnnotations.getClass();
        return toAppFunctionDataTypeMetadata(returnType, sharedDataTypeMap, seenDataTypeQualifiers, resolvedAnnotatedSerializableProxies, allowSerializableInterfaceTypes, "", functionAnnotations);
    }

    public final AppFunctionAnnotationProperties computeAppFunctionAnnotationProperties(KSAnnotation appFunctionAnnotation, KSAnnotation schemaDefinitionAnnotation) {
        Class cls = Boolean.TYPE;
        return new AppFunctionAnnotationProperties(appFunctionAnnotation != null ? (Boolean) KspUtilsKt.requirePropertyValueOfType(appFunctionAnnotation, IntrospectionHelper.AppFunctionAnnotation.PROPERTY_IS_ENABLED, Reflection.getOrCreateKotlinClass(cls)) : null, appFunctionAnnotation != null ? (Boolean) KspUtilsKt.requirePropertyValueOfType(appFunctionAnnotation, "isDescribedByKDoc", Reflection.getOrCreateKotlinClass(cls)) : null, schemaDefinitionAnnotation != null ? (String) KspUtilsKt.requirePropertyValueOfType(schemaDefinitionAnnotation, "name", Reflection.getOrCreateKotlinClass(String.class)) : null, schemaDefinitionAnnotation != null ? Long.valueOf(((Number) KspUtilsKt.requirePropertyValueOfType(schemaDefinitionAnnotation, "version", Reflection.getOrCreateKotlinClass(Integer.TYPE))).intValue()) : null, schemaDefinitionAnnotation != null ? (String) KspUtilsKt.requirePropertyValueOfType(schemaDefinitionAnnotation, IntrospectionHelper.AppFunctionSchemaDefinitionAnnotation.PROPERTY_CATEGORY, Reflection.getOrCreateKotlinClass(String.class)) : null);
    }

    public AppFunctionMetadataCreatorHelper(Map<String, String> map) {
        map.getClass();
        this.sharedDataTypeDescriptionMap = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AppFunctionMetadataCreatorHelper() {
        this(null, 1, 0 == true ? 1 : 0);
    }
}
