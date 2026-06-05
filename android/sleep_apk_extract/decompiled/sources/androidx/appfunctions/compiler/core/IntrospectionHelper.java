package androidx.appfunctions.compiler.core;

import com.squareup.kotlinpoet.AnnotationSpec;
import com.squareup.kotlinpoet.ClassName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b?\n\u0002\u0018\u0002\n\u0002\b\u001d\bÆ\u0002\u0018\u00002\u00020\u0001:\u0018RSTUVWXYZ[\\]^_`abcdefghiB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0012\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u0014\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\u0016\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0011\u0010\u0018\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000fR\u0011\u0010\u001a\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000fR\u0011\u0010\u001c\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u000fR\u0011\u0010\u001e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u000fR\u0011\u0010 \u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u000fR\u0011\u0010\"\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u000fR\u0011\u0010$\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u000fR\u0011\u0010&\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u000fR\u0011\u0010(\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u000fR\u0011\u0010*\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u000fR\u0011\u0010,\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u000fR\u0011\u0010.\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u000fR\u0011\u00100\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u000fR\u0011\u00102\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u000fR\u0011\u00104\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u000fR\u0011\u00106\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u000fR\u0011\u00108\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u000fR\u0011\u0010:\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u000fR\u0011\u0010<\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\u000fR\u0011\u0010>\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\u000fR\u0011\u0010@\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u000fR\u0011\u0010B\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\u000fR\u0011\u0010D\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bE\u0010\u000fR\u0011\u0010F\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bG\u0010\u000fR\u0011\u0010H\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bI\u0010\u000fR\u0011\u0010J\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bK\u0010\u000fR\u0011\u0010L\u001a\u00020M¢\u0006\b\n\u0000\u001a\u0004\bN\u0010OR\u0011\u0010P\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010\u000f¨\u0006j"}, d2 = {"Landroidx/appfunctions/compiler/core/IntrospectionHelper;", "", "<init>", "()V", "APP_FUNCTIONS_AGGREGATED_DEPS_PACKAGE_NAME", "", "SERIALIZABLE_PROXY_PACKAGE_NAME", "APP_FUNCTIONS_INTERNAL_PACKAGE_NAME", "APP_FUNCTIONS_SERVICE_INTERNAL_PACKAGE_NAME", "APP_FUNCTIONS_PACKAGE_NAME", "APP_FUNCTIONS_SERVICE_PACKAGE_NAME", "APP_FUNCTIONS_METADATA_PACKAGE_NAME", "APP_FUNCTION_INVENTORY_CLASS", "Lcom/squareup/kotlinpoet/ClassName;", "getAPP_FUNCTION_INVENTORY_CLASS", "()Lcom/squareup/kotlinpoet/ClassName;", "SCHEMA_APP_FUNCTION_INVENTORY_CLASS", "getSCHEMA_APP_FUNCTION_INVENTORY_CLASS", "APP_FUNCTION_METADATA_CLASS", "getAPP_FUNCTION_METADATA_CLASS", "APP_FUNCTION_FUNCTION_NOT_FOUND_EXCEPTION_CLASS", "getAPP_FUNCTION_FUNCTION_NOT_FOUND_EXCEPTION_CLASS", "APP_FUNCTION_CANCELLED_EXCEPTION_CLASS", "getAPP_FUNCTION_CANCELLED_EXCEPTION_CLASS", "APP_FUNCTION_APP_UNKNOWN_EXCEPTION_CLASS", "getAPP_FUNCTION_APP_UNKNOWN_EXCEPTION_CLASS", "APP_FUNCTION_EXCEPTION_CLASS", "getAPP_FUNCTION_EXCEPTION_CLASS", "APP_FUNCTION_SCHEMA_METADATA_CLASS", "getAPP_FUNCTION_SCHEMA_METADATA_CLASS", "APP_FUNCTION_PARAMETER_METADATA_CLASS", "getAPP_FUNCTION_PARAMETER_METADATA_CLASS", "APP_FUNCTION_DATA_TYPE_METADATA", "getAPP_FUNCTION_DATA_TYPE_METADATA", "APP_FUNCTION_DEPRECATION_METADATA_CLASS", "getAPP_FUNCTION_DEPRECATION_METADATA_CLASS", "APP_FUNCTION_UNIT_TYPE_METADATA_CLASS", "getAPP_FUNCTION_UNIT_TYPE_METADATA_CLASS", "APP_FUNCTION_BOOLEAN_TYPE_METADATA_CLASS", "getAPP_FUNCTION_BOOLEAN_TYPE_METADATA_CLASS", "APP_FUNCTION_BYTES_TYPE_METADATA_CLASS", "getAPP_FUNCTION_BYTES_TYPE_METADATA_CLASS", "APP_FUNCTION_DOUBLE_TYPE_METADATA_CLASS", "getAPP_FUNCTION_DOUBLE_TYPE_METADATA_CLASS", "APP_FUNCTION_FLOAT_TYPE_METADATA_CLASS", "getAPP_FUNCTION_FLOAT_TYPE_METADATA_CLASS", "APP_FUNCTION_LONG_TYPE_METADATA_CLASS", "getAPP_FUNCTION_LONG_TYPE_METADATA_CLASS", "APP_FUNCTION_INT_TYPE_METADATA_CLASS", "getAPP_FUNCTION_INT_TYPE_METADATA_CLASS", "APP_FUNCTION_STRING_TYPE_METADATA_CLASS", "getAPP_FUNCTION_STRING_TYPE_METADATA_CLASS", "APP_FUNCTION_PENDING_INTENT_TYPE_METADATA_CLASS", "getAPP_FUNCTION_PENDING_INTENT_TYPE_METADATA_CLASS", "APP_FUNCTION_OBJECT_TYPE_METADATA_CLASS", "getAPP_FUNCTION_OBJECT_TYPE_METADATA_CLASS", "APP_FUNCTION_ARRAY_TYPE_METADATA_CLASS", "getAPP_FUNCTION_ARRAY_TYPE_METADATA_CLASS", "APP_FUNCTION_REFERENCE_TYPE_METADATA_CLASS", "getAPP_FUNCTION_REFERENCE_TYPE_METADATA_CLASS", "APP_FUNCTION_ALL_OF_TYPE_METADATA_CLASS", "getAPP_FUNCTION_ALL_OF_TYPE_METADATA_CLASS", "APP_FUNCTION_ONE_OF_TYPE_METADATA_CLASS", "getAPP_FUNCTION_ONE_OF_TYPE_METADATA_CLASS", "APP_FUNCTION_PARCELABLE_TYPE_METADATA_CLASS", "getAPP_FUNCTION_PARCELABLE_TYPE_METADATA_CLASS", "APP_FUNCTION_COMPONENTS_METADATA_CLASS", "getAPP_FUNCTION_COMPONENTS_METADATA_CLASS", "APP_FUNCTION_RESPONSE_METADATA_CLASS", "getAPP_FUNCTION_RESPONSE_METADATA_CLASS", "DEPENDENCIES_CLASS", "getDEPENDENCIES_CLASS", "CANCELLATION_EXCEPTION_CLASS", "getCANCELLATION_EXCEPTION_CLASS", "EXCEPTION_CLASS", "getEXCEPTION_CLASS", "RESTRICT_API_TO_33_ANNOTATION", "Lcom/squareup/kotlinpoet/AnnotationSpec;", "getRESTRICT_API_TO_33_ANNOTATION", "()Lcom/squareup/kotlinpoet/AnnotationSpec;", "PARCELABLE_CLASS_NAME", "getPARCELABLE_CLASS_NAME", "DeprecatedAnnotation", "AppFunctionAnnotation", "AppFunctionEntryPointAnnotation", "AppFunctionSchemaDefinitionAnnotation", "AppFunctionOneOfTypeAnnotation", "AppFunctionSerializableAnnotation", "AppFunctionSerializableInterfaceAnnotation", "AppFunctionSerializableProxyAnnotation", "AppFunctionSchemaCapability", "AppFunctionComponentRegistryAnnotation", "AppFunctionIntValueConstraintAnnotation", "AppFunctionStringValueConstraintAnnotation", "ConfigurableAppFunctionFactoryClass", "AppFunctionContextClass", "AppFunctionServiceClass", "AppFunctionExecutionDispatcherClass", "ExecuteAppFunctionRequestClass", "ExecuteAppFunctionResponseClass", "ServiceInternalHelper", "AppFunctionInvokerClass", "AppFunctionSerializableFactoryClass", "AggregatedAppFunctionInventoryClass", "AggregatedAppFunctionInvokerClass", "AppFunctionDataClass", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IntrospectionHelper {
    public static final String APP_FUNCTIONS_AGGREGATED_DEPS_PACKAGE_NAME = "appfunctions_aggregated_deps";
    public static final String APP_FUNCTIONS_SERVICE_INTERNAL_PACKAGE_NAME = "androidx.appfunctions.service.internal";
    private static final String APP_FUNCTIONS_SERVICE_PACKAGE_NAME = "androidx.appfunctions.service";
    public static final String SERIALIZABLE_PROXY_PACKAGE_NAME = "androidx.appfunctions.internal.serializableproxies";
    public static final IntrospectionHelper INSTANCE = new IntrospectionHelper();
    public static final String APP_FUNCTIONS_INTERNAL_PACKAGE_NAME = "androidx.appfunctions.internal";
    private static final ClassName APP_FUNCTION_INVENTORY_CLASS = new ClassName(APP_FUNCTIONS_INTERNAL_PACKAGE_NAME, "AppFunctionInventory");
    private static final ClassName SCHEMA_APP_FUNCTION_INVENTORY_CLASS = new ClassName(APP_FUNCTIONS_INTERNAL_PACKAGE_NAME, "SchemaAppFunctionInventory");
    private static final String APP_FUNCTIONS_METADATA_PACKAGE_NAME = "androidx.appfunctions.metadata";
    private static final ClassName APP_FUNCTION_METADATA_CLASS = new ClassName(APP_FUNCTIONS_METADATA_PACKAGE_NAME, "CompileTimeAppFunctionMetadata");
    private static final String APP_FUNCTIONS_PACKAGE_NAME = "androidx.appfunctions";
    private static final ClassName APP_FUNCTION_FUNCTION_NOT_FOUND_EXCEPTION_CLASS = new ClassName(APP_FUNCTIONS_PACKAGE_NAME, "AppFunctionFunctionNotFoundException");
    private static final ClassName APP_FUNCTION_CANCELLED_EXCEPTION_CLASS = new ClassName(APP_FUNCTIONS_PACKAGE_NAME, "AppFunctionCancelledException");
    private static final ClassName APP_FUNCTION_APP_UNKNOWN_EXCEPTION_CLASS = new ClassName(APP_FUNCTIONS_PACKAGE_NAME, "AppFunctionAppUnknownException");
    private static final ClassName APP_FUNCTION_EXCEPTION_CLASS = new ClassName(APP_FUNCTIONS_PACKAGE_NAME, "AppFunctionException");
    private static final ClassName APP_FUNCTION_SCHEMA_METADATA_CLASS = new ClassName(APP_FUNCTIONS_METADATA_PACKAGE_NAME, "AppFunctionSchemaMetadata");
    private static final ClassName APP_FUNCTION_PARAMETER_METADATA_CLASS = new ClassName(APP_FUNCTIONS_METADATA_PACKAGE_NAME, "AppFunctionParameterMetadata");
    private static final ClassName APP_FUNCTION_DATA_TYPE_METADATA = new ClassName(APP_FUNCTIONS_METADATA_PACKAGE_NAME, "AppFunctionDataTypeMetadata");
    private static final ClassName APP_FUNCTION_DEPRECATION_METADATA_CLASS = new ClassName(APP_FUNCTIONS_METADATA_PACKAGE_NAME, "AppFunctionDeprecationMetadata");
    private static final ClassName APP_FUNCTION_UNIT_TYPE_METADATA_CLASS = new ClassName(APP_FUNCTIONS_METADATA_PACKAGE_NAME, "AppFunctionUnitTypeMetadata");
    private static final ClassName APP_FUNCTION_BOOLEAN_TYPE_METADATA_CLASS = new ClassName(APP_FUNCTIONS_METADATA_PACKAGE_NAME, "AppFunctionBooleanTypeMetadata");
    private static final ClassName APP_FUNCTION_BYTES_TYPE_METADATA_CLASS = new ClassName(APP_FUNCTIONS_METADATA_PACKAGE_NAME, "AppFunctionBytesTypeMetadata");
    private static final ClassName APP_FUNCTION_DOUBLE_TYPE_METADATA_CLASS = new ClassName(APP_FUNCTIONS_METADATA_PACKAGE_NAME, "AppFunctionDoubleTypeMetadata");
    private static final ClassName APP_FUNCTION_FLOAT_TYPE_METADATA_CLASS = new ClassName(APP_FUNCTIONS_METADATA_PACKAGE_NAME, "AppFunctionFloatTypeMetadata");
    private static final ClassName APP_FUNCTION_LONG_TYPE_METADATA_CLASS = new ClassName(APP_FUNCTIONS_METADATA_PACKAGE_NAME, "AppFunctionLongTypeMetadata");
    private static final ClassName APP_FUNCTION_INT_TYPE_METADATA_CLASS = new ClassName(APP_FUNCTIONS_METADATA_PACKAGE_NAME, "AppFunctionIntTypeMetadata");
    private static final ClassName APP_FUNCTION_STRING_TYPE_METADATA_CLASS = new ClassName(APP_FUNCTIONS_METADATA_PACKAGE_NAME, "AppFunctionStringTypeMetadata");
    private static final ClassName APP_FUNCTION_PENDING_INTENT_TYPE_METADATA_CLASS = new ClassName(APP_FUNCTIONS_METADATA_PACKAGE_NAME, "AppFunctionPendingIntentTypeMetadata");
    private static final ClassName APP_FUNCTION_OBJECT_TYPE_METADATA_CLASS = new ClassName(APP_FUNCTIONS_METADATA_PACKAGE_NAME, "AppFunctionObjectTypeMetadata");
    private static final ClassName APP_FUNCTION_ARRAY_TYPE_METADATA_CLASS = new ClassName(APP_FUNCTIONS_METADATA_PACKAGE_NAME, "AppFunctionArrayTypeMetadata");
    private static final ClassName APP_FUNCTION_REFERENCE_TYPE_METADATA_CLASS = new ClassName(APP_FUNCTIONS_METADATA_PACKAGE_NAME, "AppFunctionReferenceTypeMetadata");
    private static final ClassName APP_FUNCTION_ALL_OF_TYPE_METADATA_CLASS = new ClassName(APP_FUNCTIONS_METADATA_PACKAGE_NAME, "AppFunctionAllOfTypeMetadata");
    private static final ClassName APP_FUNCTION_ONE_OF_TYPE_METADATA_CLASS = new ClassName(APP_FUNCTIONS_METADATA_PACKAGE_NAME, "AppFunctionOneOfTypeMetadata");
    private static final ClassName APP_FUNCTION_PARCELABLE_TYPE_METADATA_CLASS = new ClassName(APP_FUNCTIONS_METADATA_PACKAGE_NAME, "AppFunctionParcelableTypeMetadata");
    private static final ClassName APP_FUNCTION_COMPONENTS_METADATA_CLASS = new ClassName(APP_FUNCTIONS_METADATA_PACKAGE_NAME, "AppFunctionComponentsMetadata");
    private static final ClassName APP_FUNCTION_RESPONSE_METADATA_CLASS = new ClassName(APP_FUNCTIONS_METADATA_PACKAGE_NAME, "AppFunctionResponseMetadata");
    private static final ClassName DEPENDENCIES_CLASS = new ClassName(APP_FUNCTIONS_INTERNAL_PACKAGE_NAME, "Dependencies");
    private static final ClassName CANCELLATION_EXCEPTION_CLASS = new ClassName("kotlinx.coroutines", "CancellationException");
    private static final ClassName EXCEPTION_CLASS = new ClassName("kotlin", "Exception");
    private static final AnnotationSpec RESTRICT_API_TO_33_ANNOTATION = AnnotationSpec.INSTANCE.builder(new ClassName("androidx.annotation", "RequiresApi")).addMember("%L", 33).build();
    private static final ClassName PARCELABLE_CLASS_NAME = new ClassName("android.os", "Parcelable");

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/appfunctions/compiler/core/IntrospectionHelper$AggregatedAppFunctionInventoryClass;", "", "<init>", "()V", "CLASS_NAME", "Lcom/squareup/kotlinpoet/ClassName;", "getCLASS_NAME", "()Lcom/squareup/kotlinpoet/ClassName;", "PROPERTY_INVENTORIES_NAME", "", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AggregatedAppFunctionInventoryClass {
        public static final String PROPERTY_INVENTORIES_NAME = "inventories";
        public static final AggregatedAppFunctionInventoryClass INSTANCE = new AggregatedAppFunctionInventoryClass();
        private static final ClassName CLASS_NAME = new ClassName(IntrospectionHelper.APP_FUNCTIONS_INTERNAL_PACKAGE_NAME, "AggregatedAppFunctionInventory");

        private AggregatedAppFunctionInventoryClass() {
        }

        public final ClassName getCLASS_NAME() {
            return CLASS_NAME;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/appfunctions/compiler/core/IntrospectionHelper$AggregatedAppFunctionInvokerClass;", "", "<init>", "()V", "CLASS_NAME", "Lcom/squareup/kotlinpoet/ClassName;", "getCLASS_NAME", "()Lcom/squareup/kotlinpoet/ClassName;", "PROPERTY_INVOKERS_NAME", "", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AggregatedAppFunctionInvokerClass {
        public static final String PROPERTY_INVOKERS_NAME = "invokers";
        public static final AggregatedAppFunctionInvokerClass INSTANCE = new AggregatedAppFunctionInvokerClass();
        private static final ClassName CLASS_NAME = new ClassName(IntrospectionHelper.APP_FUNCTIONS_SERVICE_INTERNAL_PACKAGE_NAME, "AggregatedAppFunctionInvoker");

        private AggregatedAppFunctionInvokerClass() {
        }

        public final ClassName getCLASS_NAME() {
            return CLASS_NAME;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Landroidx/appfunctions/compiler/core/IntrospectionHelper$AppFunctionAnnotation;", "", "<init>", "()V", "CLASS_NAME", "Lcom/squareup/kotlinpoet/ClassName;", "getCLASS_NAME", "()Lcom/squareup/kotlinpoet/ClassName;", "PROPERTY_IS_ENABLED", "", "PROPERTY_IS_DESCRIBED_BY_KDOC", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AppFunctionAnnotation {
        public static final String PROPERTY_IS_DESCRIBED_BY_KDOC = "isDescribedByKDoc";
        public static final String PROPERTY_IS_ENABLED = "isEnabled";
        public static final AppFunctionAnnotation INSTANCE = new AppFunctionAnnotation();
        private static final ClassName CLASS_NAME = new ClassName(IntrospectionHelper.APP_FUNCTIONS_SERVICE_PACKAGE_NAME, "AppFunction");

        private AppFunctionAnnotation() {
        }

        public final ClassName getCLASS_NAME() {
            return CLASS_NAME;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/appfunctions/compiler/core/IntrospectionHelper$AppFunctionComponentRegistryAnnotation;", "", "<init>", "()V", "CLASS_NAME", "Lcom/squareup/kotlinpoet/ClassName;", "getCLASS_NAME", "()Lcom/squareup/kotlinpoet/ClassName;", "PROPERTY_COMPONENT_CATEGORY", "", "PROPERTY_COMPONENT_NAMES", "PROPERTY_COMPONENT_DOCSTRINGS", "Category", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AppFunctionComponentRegistryAnnotation {
        public static final String PROPERTY_COMPONENT_CATEGORY = "componentCategory";
        public static final String PROPERTY_COMPONENT_DOCSTRINGS = "componentDocStrings";
        public static final String PROPERTY_COMPONENT_NAMES = "componentNames";
        public static final AppFunctionComponentRegistryAnnotation INSTANCE = new AppFunctionComponentRegistryAnnotation();
        private static final ClassName CLASS_NAME = new ClassName(IntrospectionHelper.APP_FUNCTIONS_PACKAGE_NAME, "AppFunctionComponentRegistry");

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/appfunctions/compiler/core/IntrospectionHelper$AppFunctionComponentRegistryAnnotation$Category;", "", "<init>", "()V", "INVENTORY", "", "INVOKER", "FUNCTION", "SCHEMA_DEFINITION", "SERIALIZABLE", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Category {
            public static final String FUNCTION = "FUNCTION";
            public static final Category INSTANCE = new Category();
            public static final String INVENTORY = "INVENTORY";
            public static final String INVOKER = "INVOKER";
            public static final String SCHEMA_DEFINITION = "SCHEMA_DEFINITION";
            public static final String SERIALIZABLE = "SERIALIZABLE";

            private Category() {
            }
        }

        private AppFunctionComponentRegistryAnnotation() {
        }

        public final ClassName getCLASS_NAME() {
            return CLASS_NAME;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/appfunctions/compiler/core/IntrospectionHelper$AppFunctionContextClass;", "", "<init>", "()V", "CLASS_NAME", "Lcom/squareup/kotlinpoet/ClassName;", "getCLASS_NAME", "()Lcom/squareup/kotlinpoet/ClassName;", "CONTEXT_PROPERTY_NAME", "", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AppFunctionContextClass {
        public static final String CONTEXT_PROPERTY_NAME = "context";
        public static final AppFunctionContextClass INSTANCE = new AppFunctionContextClass();
        private static final ClassName CLASS_NAME = new ClassName(IntrospectionHelper.APP_FUNCTIONS_PACKAGE_NAME, "AppFunctionContext");

        private AppFunctionContextClass() {
        }

        public final ClassName getCLASS_NAME() {
            return CLASS_NAME;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Landroidx/appfunctions/compiler/core/IntrospectionHelper$AppFunctionDataClass;", "", "<init>", "()V", "CLASS_NAME", "Lcom/squareup/kotlinpoet/ClassName;", "getCLASS_NAME", "()Lcom/squareup/kotlinpoet/ClassName;", "APP_FUNCTION_DATA_QUALIFIED_NAME_PROPERTY", "", "getAPP_FUNCTION_DATA_QUALIFIED_NAME_PROPERTY", "()Ljava/lang/String;", "BuilderClass", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AppFunctionDataClass {
        public static final AppFunctionDataClass INSTANCE = new AppFunctionDataClass();
        private static final ClassName CLASS_NAME = new ClassName(IntrospectionHelper.APP_FUNCTIONS_PACKAGE_NAME, "AppFunctionData");
        private static final String APP_FUNCTION_DATA_QUALIFIED_NAME_PROPERTY = AppFunctionSerializableFactoryClass.GetAppFunctionDataBuilder.QUALIFIED_NAME_PARAM_NAME;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/appfunctions/compiler/core/IntrospectionHelper$AppFunctionDataClass$BuilderClass;", "", "<init>", "()V", "CLASS_NAME", "Lcom/squareup/kotlinpoet/ClassName;", "getCLASS_NAME", "()Lcom/squareup/kotlinpoet/ClassName;", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class BuilderClass {
            public static final BuilderClass INSTANCE = new BuilderClass();
            private static final ClassName CLASS_NAME = new ClassName(IntrospectionHelper.APP_FUNCTIONS_PACKAGE_NAME, "AppFunctionData", "Builder");

            private BuilderClass() {
            }

            public final ClassName getCLASS_NAME() {
                return CLASS_NAME;
            }
        }

        private AppFunctionDataClass() {
        }

        public final String getAPP_FUNCTION_DATA_QUALIFIED_NAME_PROPERTY() {
            return APP_FUNCTION_DATA_QUALIFIED_NAME_PROPERTY;
        }

        public final ClassName getCLASS_NAME() {
            return CLASS_NAME;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Landroidx/appfunctions/compiler/core/IntrospectionHelper$AppFunctionEntryPointAnnotation;", "", "<init>", "()V", "CLASS_NAME", "Lcom/squareup/kotlinpoet/ClassName;", "getCLASS_NAME", "()Lcom/squareup/kotlinpoet/ClassName;", "PROPERTY_SERVICE_NAME", "", "PROPERTY_APP_FUNCTION_XML_FILE_NAME", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AppFunctionEntryPointAnnotation {
        public static final String PROPERTY_APP_FUNCTION_XML_FILE_NAME = "appFunctionXmlFileName";
        public static final String PROPERTY_SERVICE_NAME = "serviceName";
        public static final AppFunctionEntryPointAnnotation INSTANCE = new AppFunctionEntryPointAnnotation();
        private static final ClassName CLASS_NAME = new ClassName(IntrospectionHelper.APP_FUNCTIONS_SERVICE_PACKAGE_NAME, "AppFunctionEntryPoint");

        private AppFunctionEntryPointAnnotation() {
        }

        public final ClassName getCLASS_NAME() {
            return CLASS_NAME;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Landroidx/appfunctions/compiler/core/IntrospectionHelper$AppFunctionExecutionDispatcherClass;", "", "<init>", "()V", "CLASS_NAME", "Lcom/squareup/kotlinpoet/ClassName;", "getCLASS_NAME", "()Lcom/squareup/kotlinpoet/ClassName;", "ExecuteAppFunctionMethod", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AppFunctionExecutionDispatcherClass {
        public static final AppFunctionExecutionDispatcherClass INSTANCE = new AppFunctionExecutionDispatcherClass();
        private static final ClassName CLASS_NAME = new ClassName(IntrospectionHelper.APP_FUNCTIONS_SERVICE_INTERNAL_PACKAGE_NAME, "AppFunctionExecutionDispatcher");

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/appfunctions/compiler/core/IntrospectionHelper$AppFunctionExecutionDispatcherClass$ExecuteAppFunctionMethod;", "", "<init>", "()V", "METHOD_NAME", "", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class ExecuteAppFunctionMethod {
            public static final ExecuteAppFunctionMethod INSTANCE = new ExecuteAppFunctionMethod();
            public static final String METHOD_NAME = "executeAppFunction";

            private ExecuteAppFunctionMethod() {
            }
        }

        private AppFunctionExecutionDispatcherClass() {
        }

        public final ClassName getCLASS_NAME() {
            return CLASS_NAME;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/appfunctions/compiler/core/IntrospectionHelper$AppFunctionIntValueConstraintAnnotation;", "", "<init>", "()V", "CLASS_NAME", "Lcom/squareup/kotlinpoet/ClassName;", "getCLASS_NAME", "()Lcom/squareup/kotlinpoet/ClassName;", "PROPERTY_ENUM_VALUES", "", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AppFunctionIntValueConstraintAnnotation {
        public static final String PROPERTY_ENUM_VALUES = "enumValues";
        public static final AppFunctionIntValueConstraintAnnotation INSTANCE = new AppFunctionIntValueConstraintAnnotation();
        private static final ClassName CLASS_NAME = new ClassName(IntrospectionHelper.APP_FUNCTIONS_PACKAGE_NAME, "AppFunctionIntValueConstraint");

        private AppFunctionIntValueConstraintAnnotation() {
        }

        public final ClassName getCLASS_NAME() {
            return CLASS_NAME;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Landroidx/appfunctions/compiler/core/IntrospectionHelper$AppFunctionInvokerClass;", "", "<init>", "()V", "CLASS_NAME", "Lcom/squareup/kotlinpoet/ClassName;", "getCLASS_NAME", "()Lcom/squareup/kotlinpoet/ClassName;", "SUPPORTED_FUNCTION_IDS_PROPERTY_NAME", "", "UnsafeInvokeMethod", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AppFunctionInvokerClass {
        public static final String SUPPORTED_FUNCTION_IDS_PROPERTY_NAME = "supportedFunctionIds";
        public static final AppFunctionInvokerClass INSTANCE = new AppFunctionInvokerClass();
        private static final ClassName CLASS_NAME = new ClassName(IntrospectionHelper.APP_FUNCTIONS_SERVICE_INTERNAL_PACKAGE_NAME, "AppFunctionInvoker");

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/appfunctions/compiler/core/IntrospectionHelper$AppFunctionInvokerClass$UnsafeInvokeMethod;", "", "<init>", "()V", "METHOD_NAME", "", "APPLICATION_CONTEXT_PARAM_NAME", "FUNCTION_ID_PARAM_NAME", "PARAMETERS_PARAM_NAME", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class UnsafeInvokeMethod {
            public static final String APPLICATION_CONTEXT_PARAM_NAME = "appFunctionContext";
            public static final String FUNCTION_ID_PARAM_NAME = "functionIdentifier";
            public static final UnsafeInvokeMethod INSTANCE = new UnsafeInvokeMethod();
            public static final String METHOD_NAME = "unsafeInvoke";
            public static final String PARAMETERS_PARAM_NAME = "parameters";

            private UnsafeInvokeMethod() {
            }
        }

        private AppFunctionInvokerClass() {
        }

        public final ClassName getCLASS_NAME() {
            return CLASS_NAME;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Landroidx/appfunctions/compiler/core/IntrospectionHelper$AppFunctionOneOfTypeAnnotation;", "", "<init>", "()V", "CLASS_NAME", "Lcom/squareup/kotlinpoet/ClassName;", "getCLASS_NAME", "()Lcom/squareup/kotlinpoet/ClassName;", "PROPERTY_IS_DESCRIBED_BY_KDOC", "", "PROPERTY_MATCH_ONE_OF", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AppFunctionOneOfTypeAnnotation {
        public static final String PROPERTY_IS_DESCRIBED_BY_KDOC = "isDescribedByKdoc";
        public static final String PROPERTY_MATCH_ONE_OF = "matchOneOf";
        public static final AppFunctionOneOfTypeAnnotation INSTANCE = new AppFunctionOneOfTypeAnnotation();
        private static final ClassName CLASS_NAME = new ClassName(IntrospectionHelper.APP_FUNCTIONS_PACKAGE_NAME, "AppFunctionOneOfType");

        private AppFunctionOneOfTypeAnnotation() {
        }

        public final ClassName getCLASS_NAME() {
            return CLASS_NAME;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/appfunctions/compiler/core/IntrospectionHelper$AppFunctionSchemaCapability;", "", "<init>", "()V", "CLASS_NAME", "Lcom/squareup/kotlinpoet/ClassName;", "getCLASS_NAME", "()Lcom/squareup/kotlinpoet/ClassName;", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AppFunctionSchemaCapability {
        public static final AppFunctionSchemaCapability INSTANCE = new AppFunctionSchemaCapability();
        private static final ClassName CLASS_NAME = new ClassName(IntrospectionHelper.APP_FUNCTIONS_PACKAGE_NAME, "AppFunctionSchemaCapability");

        private AppFunctionSchemaCapability() {
        }

        public final ClassName getCLASS_NAME() {
            return CLASS_NAME;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Landroidx/appfunctions/compiler/core/IntrospectionHelper$AppFunctionSchemaDefinitionAnnotation;", "", "<init>", "()V", "CLASS_NAME", "Lcom/squareup/kotlinpoet/ClassName;", "getCLASS_NAME", "()Lcom/squareup/kotlinpoet/ClassName;", "PROPERTY_CATEGORY", "", "PROPERTY_NAME", "PROPERTY_VERSION", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AppFunctionSchemaDefinitionAnnotation {
        public static final String PROPERTY_CATEGORY = "category";
        public static final String PROPERTY_NAME = "name";
        public static final String PROPERTY_VERSION = "version";
        public static final AppFunctionSchemaDefinitionAnnotation INSTANCE = new AppFunctionSchemaDefinitionAnnotation();
        private static final ClassName CLASS_NAME = new ClassName(IntrospectionHelper.APP_FUNCTIONS_PACKAGE_NAME, "AppFunctionSchemaDefinition");

        private AppFunctionSchemaDefinitionAnnotation() {
        }

        public final ClassName getCLASS_NAME() {
            return CLASS_NAME;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/appfunctions/compiler/core/IntrospectionHelper$AppFunctionSerializableAnnotation;", "", "<init>", "()V", "CLASS_NAME", "Lcom/squareup/kotlinpoet/ClassName;", "getCLASS_NAME", "()Lcom/squareup/kotlinpoet/ClassName;", "PROPERTY_IS_DESCRIBED_BY_KDOC", "", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AppFunctionSerializableAnnotation {
        public static final String PROPERTY_IS_DESCRIBED_BY_KDOC = "isDescribedByKDoc";
        public static final AppFunctionSerializableAnnotation INSTANCE = new AppFunctionSerializableAnnotation();
        private static final ClassName CLASS_NAME = new ClassName(IntrospectionHelper.APP_FUNCTIONS_PACKAGE_NAME, "AppFunctionSerializable");

        private AppFunctionSerializableAnnotation() {
        }

        public final ClassName getCLASS_NAME() {
            return CLASS_NAME;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0005\b\t\n\u000b\fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/appfunctions/compiler/core/IntrospectionHelper$AppFunctionSerializableFactoryClass;", "", "<init>", "()V", "CLASS_NAME", "Lcom/squareup/kotlinpoet/ClassName;", "getCLASS_NAME", "()Lcom/squareup/kotlinpoet/ClassName;", "FromAppFunctionDataMethod", "GetAppFunctionDataBuilder", "GetAppFunctionDataWithSpec", "ToAppFunctionDataMethod", "TypeParameterClass", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AppFunctionSerializableFactoryClass {
        public static final AppFunctionSerializableFactoryClass INSTANCE = new AppFunctionSerializableFactoryClass();
        private static final ClassName CLASS_NAME = new ClassName(IntrospectionHelper.APP_FUNCTIONS_INTERNAL_PACKAGE_NAME, "AppFunctionSerializableFactory");

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/appfunctions/compiler/core/IntrospectionHelper$AppFunctionSerializableFactoryClass$FromAppFunctionDataMethod;", "", "<init>", "()V", "METHOD_NAME", "", "APP_FUNCTION_DATA_PARAM_NAME", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class FromAppFunctionDataMethod {
            public static final String APP_FUNCTION_DATA_PARAM_NAME = "appFunctionData";
            public static final FromAppFunctionDataMethod INSTANCE = new FromAppFunctionDataMethod();
            public static final String METHOD_NAME = "fromAppFunctionData";

            private FromAppFunctionDataMethod() {
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/appfunctions/compiler/core/IntrospectionHelper$AppFunctionSerializableFactoryClass$GetAppFunctionDataBuilder;", "", "<init>", "()V", "METHOD_NAME", "", "QUALIFIED_NAME_PARAM_NAME", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class GetAppFunctionDataBuilder {
            public static final GetAppFunctionDataBuilder INSTANCE = new GetAppFunctionDataBuilder();
            public static final String METHOD_NAME = "getAppFunctionDataBuilder";
            public static final String QUALIFIED_NAME_PARAM_NAME = "qualifiedName";

            private GetAppFunctionDataBuilder() {
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/appfunctions/compiler/core/IntrospectionHelper$AppFunctionSerializableFactoryClass$GetAppFunctionDataWithSpec;", "", "<init>", "()V", "METHOD_NAME", "", "QUALIFIED_NAME_PARAM_NAME", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class GetAppFunctionDataWithSpec {
            public static final GetAppFunctionDataWithSpec INSTANCE = new GetAppFunctionDataWithSpec();
            public static final String METHOD_NAME = "getAppFunctionDataWithSpec";
            public static final String QUALIFIED_NAME_PARAM_NAME = "appFunctionData";

            private GetAppFunctionDataWithSpec() {
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/appfunctions/compiler/core/IntrospectionHelper$AppFunctionSerializableFactoryClass$ToAppFunctionDataMethod;", "", "<init>", "()V", "METHOD_NAME", "", "APP_FUNCTION_SERIALIZABLE_PARAM_NAME", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class ToAppFunctionDataMethod {
            public static final String APP_FUNCTION_SERIALIZABLE_PARAM_NAME = "appFunctionSerializable";
            public static final ToAppFunctionDataMethod INSTANCE = new ToAppFunctionDataMethod();
            public static final String METHOD_NAME = "toAppFunctionData";

            private ToAppFunctionDataMethod() {
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004\b\t\n\u000bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Landroidx/appfunctions/compiler/core/IntrospectionHelper$AppFunctionSerializableFactoryClass$TypeParameterClass;", "", "<init>", "()V", "CLASS_NAME", "Lcom/squareup/kotlinpoet/ClassName;", "getCLASS_NAME", "()Lcom/squareup/kotlinpoet/ClassName;", "PrimitiveTypeParameterClass", "PrimitiveListTypeParameter", "SerializableTypeParameter", "SerializableListTypeParameter", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class TypeParameterClass {
            public static final TypeParameterClass INSTANCE = new TypeParameterClass();
            private static final ClassName CLASS_NAME = new ClassName(IntrospectionHelper.APP_FUNCTIONS_INTERNAL_PACKAGE_NAME, "AppFunctionSerializableFactory", "TypeParameter");

            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/appfunctions/compiler/core/IntrospectionHelper$AppFunctionSerializableFactoryClass$TypeParameterClass$PrimitiveListTypeParameter;", "", "<init>", "()V", "CLASS_NAME", "Lcom/squareup/kotlinpoet/ClassName;", "getCLASS_NAME", "()Lcom/squareup/kotlinpoet/ClassName;", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
            public static final class PrimitiveListTypeParameter {
                public static final PrimitiveListTypeParameter INSTANCE = new PrimitiveListTypeParameter();
                private static final ClassName CLASS_NAME = new ClassName(IntrospectionHelper.APP_FUNCTIONS_INTERNAL_PACKAGE_NAME, "AppFunctionSerializableFactory", "TypeParameter", "PrimitiveListTypeParameter");

                private PrimitiveListTypeParameter() {
                }

                public final ClassName getCLASS_NAME() {
                    return CLASS_NAME;
                }
            }

            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/appfunctions/compiler/core/IntrospectionHelper$AppFunctionSerializableFactoryClass$TypeParameterClass$PrimitiveTypeParameterClass;", "", "<init>", "()V", "CLASS_NAME", "Lcom/squareup/kotlinpoet/ClassName;", "getCLASS_NAME", "()Lcom/squareup/kotlinpoet/ClassName;", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
            public static final class PrimitiveTypeParameterClass {
                public static final PrimitiveTypeParameterClass INSTANCE = new PrimitiveTypeParameterClass();
                private static final ClassName CLASS_NAME = new ClassName(IntrospectionHelper.APP_FUNCTIONS_INTERNAL_PACKAGE_NAME, "AppFunctionSerializableFactory", "TypeParameter", "PrimitiveTypeParameter");

                private PrimitiveTypeParameterClass() {
                }

                public final ClassName getCLASS_NAME() {
                    return CLASS_NAME;
                }
            }

            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/appfunctions/compiler/core/IntrospectionHelper$AppFunctionSerializableFactoryClass$TypeParameterClass$SerializableListTypeParameter;", "", "<init>", "()V", "CLASS_NAME", "Lcom/squareup/kotlinpoet/ClassName;", "getCLASS_NAME", "()Lcom/squareup/kotlinpoet/ClassName;", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
            public static final class SerializableListTypeParameter {
                public static final SerializableListTypeParameter INSTANCE = new SerializableListTypeParameter();
                private static final ClassName CLASS_NAME = new ClassName(IntrospectionHelper.APP_FUNCTIONS_INTERNAL_PACKAGE_NAME, "AppFunctionSerializableFactory", "TypeParameter", "SerializableListTypeParameter");

                private SerializableListTypeParameter() {
                }

                public final ClassName getCLASS_NAME() {
                    return CLASS_NAME;
                }
            }

            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/appfunctions/compiler/core/IntrospectionHelper$AppFunctionSerializableFactoryClass$TypeParameterClass$SerializableTypeParameter;", "", "<init>", "()V", "CLASS_NAME", "Lcom/squareup/kotlinpoet/ClassName;", "getCLASS_NAME", "()Lcom/squareup/kotlinpoet/ClassName;", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
            public static final class SerializableTypeParameter {
                public static final SerializableTypeParameter INSTANCE = new SerializableTypeParameter();
                private static final ClassName CLASS_NAME = new ClassName(IntrospectionHelper.APP_FUNCTIONS_INTERNAL_PACKAGE_NAME, "AppFunctionSerializableFactory", "TypeParameter", "SerializableTypeParameter");

                private SerializableTypeParameter() {
                }

                public final ClassName getCLASS_NAME() {
                    return CLASS_NAME;
                }
            }

            private TypeParameterClass() {
            }

            public final ClassName getCLASS_NAME() {
                return CLASS_NAME;
            }
        }

        private AppFunctionSerializableFactoryClass() {
        }

        public final ClassName getCLASS_NAME() {
            return CLASS_NAME;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/appfunctions/compiler/core/IntrospectionHelper$AppFunctionSerializableInterfaceAnnotation;", "", "<init>", "()V", "CLASS_NAME", "Lcom/squareup/kotlinpoet/ClassName;", "getCLASS_NAME", "()Lcom/squareup/kotlinpoet/ClassName;", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AppFunctionSerializableInterfaceAnnotation {
        public static final AppFunctionSerializableInterfaceAnnotation INSTANCE = new AppFunctionSerializableInterfaceAnnotation();
        private static final ClassName CLASS_NAME = new ClassName(IntrospectionHelper.APP_FUNCTIONS_PACKAGE_NAME, "AppFunctionSerializableInterface");

        private AppFunctionSerializableInterfaceAnnotation() {
        }

        public final ClassName getCLASS_NAME() {
            return CLASS_NAME;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/appfunctions/compiler/core/IntrospectionHelper$AppFunctionSerializableProxyAnnotation;", "", "<init>", "()V", "CLASS_NAME", "Lcom/squareup/kotlinpoet/ClassName;", "getCLASS_NAME", "()Lcom/squareup/kotlinpoet/ClassName;", "PROPERTY_TARGET_CLASS", "", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AppFunctionSerializableProxyAnnotation {
        public static final String PROPERTY_TARGET_CLASS = "targetClass";
        public static final AppFunctionSerializableProxyAnnotation INSTANCE = new AppFunctionSerializableProxyAnnotation();
        private static final ClassName CLASS_NAME = new ClassName(IntrospectionHelper.APP_FUNCTIONS_PACKAGE_NAME, "AppFunctionSerializableProxy");

        private AppFunctionSerializableProxyAnnotation() {
        }

        public final ClassName getCLASS_NAME() {
            return CLASS_NAME;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Landroidx/appfunctions/compiler/core/IntrospectionHelper$AppFunctionServiceClass;", "", "<init>", "()V", "CLASS_NAME", "Lcom/squareup/kotlinpoet/ClassName;", "getCLASS_NAME", "()Lcom/squareup/kotlinpoet/ClassName;", "ExecuteFunctionMethod", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AppFunctionServiceClass {
        public static final AppFunctionServiceClass INSTANCE = new AppFunctionServiceClass();
        private static final ClassName CLASS_NAME = new ClassName(IntrospectionHelper.APP_FUNCTIONS_PACKAGE_NAME, "AppFunctionService");

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/appfunctions/compiler/core/IntrospectionHelper$AppFunctionServiceClass$ExecuteFunctionMethod;", "", "<init>", "()V", "METHOD_NAME", "", "REQUEST_PARAM_NAME", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class ExecuteFunctionMethod {
            public static final ExecuteFunctionMethod INSTANCE = new ExecuteFunctionMethod();
            public static final String METHOD_NAME = "executeFunction";
            public static final String REQUEST_PARAM_NAME = "request";

            private ExecuteFunctionMethod() {
            }
        }

        private AppFunctionServiceClass() {
        }

        public final ClassName getCLASS_NAME() {
            return CLASS_NAME;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/appfunctions/compiler/core/IntrospectionHelper$AppFunctionStringValueConstraintAnnotation;", "", "<init>", "()V", "CLASS_NAME", "Lcom/squareup/kotlinpoet/ClassName;", "getCLASS_NAME", "()Lcom/squareup/kotlinpoet/ClassName;", "PROPERTY_ENUM_VALUES", "", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AppFunctionStringValueConstraintAnnotation {
        public static final String PROPERTY_ENUM_VALUES = "enumValues";
        public static final AppFunctionStringValueConstraintAnnotation INSTANCE = new AppFunctionStringValueConstraintAnnotation();
        private static final ClassName CLASS_NAME = new ClassName(IntrospectionHelper.APP_FUNCTIONS_PACKAGE_NAME, "AppFunctionStringValueConstraint");

        private AppFunctionStringValueConstraintAnnotation() {
        }

        public final ClassName getCLASS_NAME() {
            return CLASS_NAME;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Landroidx/appfunctions/compiler/core/IntrospectionHelper$ConfigurableAppFunctionFactoryClass;", "", "<init>", "()V", "CLASS_NAME", "Lcom/squareup/kotlinpoet/ClassName;", "getCLASS_NAME", "()Lcom/squareup/kotlinpoet/ClassName;", "CreateEnclosingClassMethod", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ConfigurableAppFunctionFactoryClass {
        public static final ConfigurableAppFunctionFactoryClass INSTANCE = new ConfigurableAppFunctionFactoryClass();
        private static final ClassName CLASS_NAME = new ClassName(IntrospectionHelper.APP_FUNCTIONS_SERVICE_INTERNAL_PACKAGE_NAME, "ConfigurableAppFunctionFactory");

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/appfunctions/compiler/core/IntrospectionHelper$ConfigurableAppFunctionFactoryClass$CreateEnclosingClassMethod;", "", "<init>", "()V", "METHOD_NAME", "", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class CreateEnclosingClassMethod {
            public static final CreateEnclosingClassMethod INSTANCE = new CreateEnclosingClassMethod();
            public static final String METHOD_NAME = "createEnclosingClass";

            private CreateEnclosingClassMethod() {
            }
        }

        private ConfigurableAppFunctionFactoryClass() {
        }

        public final ClassName getCLASS_NAME() {
            return CLASS_NAME;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/appfunctions/compiler/core/IntrospectionHelper$DeprecatedAnnotation;", "", "<init>", "()V", "CLASS_NAME", "Lcom/squareup/kotlinpoet/ClassName;", "getCLASS_NAME", "()Lcom/squareup/kotlinpoet/ClassName;", "PROPERTY_MESSAGE", "", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DeprecatedAnnotation {
        public static final String PROPERTY_MESSAGE = "message";
        public static final DeprecatedAnnotation INSTANCE = new DeprecatedAnnotation();
        private static final ClassName CLASS_NAME = new ClassName("kotlin", "Deprecated");

        private DeprecatedAnnotation() {
        }

        public final ClassName getCLASS_NAME() {
            return CLASS_NAME;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/appfunctions/compiler/core/IntrospectionHelper$ExecuteAppFunctionRequestClass;", "", "<init>", "()V", "CLASS_NAME", "Lcom/squareup/kotlinpoet/ClassName;", "getCLASS_NAME", "()Lcom/squareup/kotlinpoet/ClassName;", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ExecuteAppFunctionRequestClass {
        public static final ExecuteAppFunctionRequestClass INSTANCE = new ExecuteAppFunctionRequestClass();
        private static final ClassName CLASS_NAME = new ClassName(IntrospectionHelper.APP_FUNCTIONS_PACKAGE_NAME, "ExecuteAppFunctionRequest");

        private ExecuteAppFunctionRequestClass() {
        }

        public final ClassName getCLASS_NAME() {
            return CLASS_NAME;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Landroidx/appfunctions/compiler/core/IntrospectionHelper$ExecuteAppFunctionResponseClass;", "", "<init>", "()V", "CLASS_NAME", "Lcom/squareup/kotlinpoet/ClassName;", "getCLASS_NAME", "()Lcom/squareup/kotlinpoet/ClassName;", "SUCCESS_CLASS_NAME", "getSUCCESS_CLASS_NAME", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ExecuteAppFunctionResponseClass {
        private static final ClassName CLASS_NAME;
        public static final ExecuteAppFunctionResponseClass INSTANCE = new ExecuteAppFunctionResponseClass();
        private static final ClassName SUCCESS_CLASS_NAME;

        static {
            ClassName className = new ClassName(IntrospectionHelper.APP_FUNCTIONS_PACKAGE_NAME, "ExecuteAppFunctionResponse");
            CLASS_NAME = className;
            SUCCESS_CLASS_NAME = className.nestedClass("Success");
        }

        private ExecuteAppFunctionResponseClass() {
        }

        public final ClassName getCLASS_NAME() {
            return CLASS_NAME;
        }

        public final ClassName getSUCCESS_CLASS_NAME() {
            return SUCCESS_CLASS_NAME;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/appfunctions/compiler/core/IntrospectionHelper$ServiceInternalHelper;", "", "<init>", "()V", "UNSAFE_GET_PARAMETER_VALUE_METHOD", "", "UNSAFE_BUILD_RETURN_VALUE_METHOD", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ServiceInternalHelper {
        public static final ServiceInternalHelper INSTANCE = new ServiceInternalHelper();
        public static final String UNSAFE_BUILD_RETURN_VALUE_METHOD = "unsafeBuildReturnValue";
        public static final String UNSAFE_GET_PARAMETER_VALUE_METHOD = "unsafeGetParameterValue";

        private ServiceInternalHelper() {
        }
    }

    private IntrospectionHelper() {
    }

    public final ClassName getAPP_FUNCTION_ALL_OF_TYPE_METADATA_CLASS() {
        return APP_FUNCTION_ALL_OF_TYPE_METADATA_CLASS;
    }

    public final ClassName getAPP_FUNCTION_APP_UNKNOWN_EXCEPTION_CLASS() {
        return APP_FUNCTION_APP_UNKNOWN_EXCEPTION_CLASS;
    }

    public final ClassName getAPP_FUNCTION_ARRAY_TYPE_METADATA_CLASS() {
        return APP_FUNCTION_ARRAY_TYPE_METADATA_CLASS;
    }

    public final ClassName getAPP_FUNCTION_BOOLEAN_TYPE_METADATA_CLASS() {
        return APP_FUNCTION_BOOLEAN_TYPE_METADATA_CLASS;
    }

    public final ClassName getAPP_FUNCTION_BYTES_TYPE_METADATA_CLASS() {
        return APP_FUNCTION_BYTES_TYPE_METADATA_CLASS;
    }

    public final ClassName getAPP_FUNCTION_CANCELLED_EXCEPTION_CLASS() {
        return APP_FUNCTION_CANCELLED_EXCEPTION_CLASS;
    }

    public final ClassName getAPP_FUNCTION_COMPONENTS_METADATA_CLASS() {
        return APP_FUNCTION_COMPONENTS_METADATA_CLASS;
    }

    public final ClassName getAPP_FUNCTION_DATA_TYPE_METADATA() {
        return APP_FUNCTION_DATA_TYPE_METADATA;
    }

    public final ClassName getAPP_FUNCTION_DEPRECATION_METADATA_CLASS() {
        return APP_FUNCTION_DEPRECATION_METADATA_CLASS;
    }

    public final ClassName getAPP_FUNCTION_DOUBLE_TYPE_METADATA_CLASS() {
        return APP_FUNCTION_DOUBLE_TYPE_METADATA_CLASS;
    }

    public final ClassName getAPP_FUNCTION_EXCEPTION_CLASS() {
        return APP_FUNCTION_EXCEPTION_CLASS;
    }

    public final ClassName getAPP_FUNCTION_FLOAT_TYPE_METADATA_CLASS() {
        return APP_FUNCTION_FLOAT_TYPE_METADATA_CLASS;
    }

    public final ClassName getAPP_FUNCTION_FUNCTION_NOT_FOUND_EXCEPTION_CLASS() {
        return APP_FUNCTION_FUNCTION_NOT_FOUND_EXCEPTION_CLASS;
    }

    public final ClassName getAPP_FUNCTION_INT_TYPE_METADATA_CLASS() {
        return APP_FUNCTION_INT_TYPE_METADATA_CLASS;
    }

    public final ClassName getAPP_FUNCTION_INVENTORY_CLASS() {
        return APP_FUNCTION_INVENTORY_CLASS;
    }

    public final ClassName getAPP_FUNCTION_LONG_TYPE_METADATA_CLASS() {
        return APP_FUNCTION_LONG_TYPE_METADATA_CLASS;
    }

    public final ClassName getAPP_FUNCTION_METADATA_CLASS() {
        return APP_FUNCTION_METADATA_CLASS;
    }

    public final ClassName getAPP_FUNCTION_OBJECT_TYPE_METADATA_CLASS() {
        return APP_FUNCTION_OBJECT_TYPE_METADATA_CLASS;
    }

    public final ClassName getAPP_FUNCTION_ONE_OF_TYPE_METADATA_CLASS() {
        return APP_FUNCTION_ONE_OF_TYPE_METADATA_CLASS;
    }

    public final ClassName getAPP_FUNCTION_PARAMETER_METADATA_CLASS() {
        return APP_FUNCTION_PARAMETER_METADATA_CLASS;
    }

    public final ClassName getAPP_FUNCTION_PARCELABLE_TYPE_METADATA_CLASS() {
        return APP_FUNCTION_PARCELABLE_TYPE_METADATA_CLASS;
    }

    public final ClassName getAPP_FUNCTION_PENDING_INTENT_TYPE_METADATA_CLASS() {
        return APP_FUNCTION_PENDING_INTENT_TYPE_METADATA_CLASS;
    }

    public final ClassName getAPP_FUNCTION_REFERENCE_TYPE_METADATA_CLASS() {
        return APP_FUNCTION_REFERENCE_TYPE_METADATA_CLASS;
    }

    public final ClassName getAPP_FUNCTION_RESPONSE_METADATA_CLASS() {
        return APP_FUNCTION_RESPONSE_METADATA_CLASS;
    }

    public final ClassName getAPP_FUNCTION_SCHEMA_METADATA_CLASS() {
        return APP_FUNCTION_SCHEMA_METADATA_CLASS;
    }

    public final ClassName getAPP_FUNCTION_STRING_TYPE_METADATA_CLASS() {
        return APP_FUNCTION_STRING_TYPE_METADATA_CLASS;
    }

    public final ClassName getAPP_FUNCTION_UNIT_TYPE_METADATA_CLASS() {
        return APP_FUNCTION_UNIT_TYPE_METADATA_CLASS;
    }

    public final ClassName getCANCELLATION_EXCEPTION_CLASS() {
        return CANCELLATION_EXCEPTION_CLASS;
    }

    public final ClassName getDEPENDENCIES_CLASS() {
        return DEPENDENCIES_CLASS;
    }

    public final ClassName getEXCEPTION_CLASS() {
        return EXCEPTION_CLASS;
    }

    public final ClassName getPARCELABLE_CLASS_NAME() {
        return PARCELABLE_CLASS_NAME;
    }

    public final AnnotationSpec getRESTRICT_API_TO_33_ANNOTATION() {
        return RESTRICT_API_TO_33_ANNOTATION;
    }

    public final ClassName getSCHEMA_APP_FUNCTION_INVENTORY_CLASS() {
        return SCHEMA_APP_FUNCTION_INVENTORY_CLASS;
    }
}
