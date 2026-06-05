package androidx.appfunctions.internal;

import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.appfunctions.compiler.processors.AppFunctionInventoryProcessor;
import androidx.appfunctions.metadata.AppFunctionComponentsMetadata;
import androidx.appfunctions.metadata.AppFunctionDataTypeMetadata;
import androidx.appfunctions.metadata.AppFunctionIntTypeMetadata;
import androidx.appfunctions.metadata.AppFunctionParameterMetadata;
import androidx.appfunctions.metadata.AppFunctionResponseMetadata;
import androidx.appfunctions.metadata.AppFunctionSchemaMetadata;
import androidx.appfunctions.metadata.AppFunctionStringTypeMetadata;
import androidx.appfunctions.metadata.CompileTimeAppFunctionMetadata;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: renamed from: androidx.appfunctions.internal.$AggregatedAppFunctionInventory_Impl, reason: invalid class name */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"androidx/appfunctions/internal/$AggregatedAppFunctionInventory_Impl", "Landroidx/appfunctions/internal/AggregatedAppFunctionInventory;", "<init>", "()V", IntrospectionHelper.AggregatedAppFunctionInventoryClass.PROPERTY_INVENTORIES_NAME, "", "Landroidx/appfunctions/internal/AppFunctionInventory;", "getInventories", "()Ljava/util/List;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class C$AggregatedAppFunctionInventory_Impl extends AggregatedAppFunctionInventory {
    private final List<AppFunctionInventory> inventories = CollectionsKt.listOf(new AppFunctionInventory() { // from class: com.urbandroid.sleep.functions.$AppFunctions_AppFunctionInventory
        private final AppFunctionComponentsMetadata componentsMetadata;
        private final Map<String, AppFunctionDataTypeMetadata> componentsMetadataDataTypesMap;
        private final Map<String, CompileTimeAppFunctionMetadata> functionIdToMetadataMap = MapsKt.mapOf(TuplesKt.to("com.urbandroid.sleep.functions.AppFunctions#createAlarm", ComUrbandroidSleepFunctionsAppFunctionsCreateAlarmMetadataObject.INSTANCE.getAPP_FUNCTION_METADATA()), TuplesKt.to("com.urbandroid.sleep.functions.AppFunctions#startSleepTracking", ComUrbandroidSleepFunctionsAppFunctionsStartSleepTrackingMetadataObject.INSTANCE.getAPP_FUNCTION_METADATA()));

        /* JADX INFO: renamed from: com.urbandroid.sleep.functions.$AppFunctions_AppFunctionInventory$ComUrbandroidSleepFunctionsAppFunctionsCreateAlarmMetadataObject */
        @Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"com/urbandroid/sleep/functions/$AppFunctions_AppFunctionInventory.ComUrbandroidSleepFunctionsAppFunctionsCreateAlarmMetadataObject", "", "<init>", "()V", AppFunctionInventoryProcessor.SCHEMA_METADATA_PROPERTY_NAME, "Landroidx/appfunctions/metadata/AppFunctionSchemaMetadata;", "PARAMETER_METADATA_HOUR_PRIMITIVE_DATA_TYPE", "Landroidx/appfunctions/metadata/AppFunctionIntTypeMetadata;", "HOUR_PARAMETER_METADATA", "Landroidx/appfunctions/metadata/AppFunctionParameterMetadata;", "PARAMETER_METADATA_MINUTE_PRIMITIVE_DATA_TYPE", "MINUTE_PARAMETER_METADATA", AppFunctionInventoryProcessor.PARAMETER_METADATA_LIST_PROPERTY_NAME, "", "PRIMITIVE_RESPONSE_VALUE_TYPE", "Landroidx/appfunctions/metadata/AppFunctionStringTypeMetadata;", AppFunctionInventoryProcessor.RESPONSE_METADATA_PROPERTY_NAME, "Landroidx/appfunctions/metadata/AppFunctionResponseMetadata;", AppFunctionInventoryProcessor.APP_FUNCTION_METADATA_PROPERTY_NAME, "Landroidx/appfunctions/metadata/CompileTimeAppFunctionMetadata;", "getAPP_FUNCTION_METADATA", "()Landroidx/appfunctions/metadata/CompileTimeAppFunctionMetadata;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class ComUrbandroidSleepFunctionsAppFunctionsCreateAlarmMetadataObject {
            private static final CompileTimeAppFunctionMetadata APP_FUNCTION_METADATA;
            private static final AppFunctionParameterMetadata HOUR_PARAMETER_METADATA;
            public static final ComUrbandroidSleepFunctionsAppFunctionsCreateAlarmMetadataObject INSTANCE = new ComUrbandroidSleepFunctionsAppFunctionsCreateAlarmMetadataObject();
            private static final AppFunctionParameterMetadata MINUTE_PARAMETER_METADATA;
            private static final AppFunctionIntTypeMetadata PARAMETER_METADATA_HOUR_PRIMITIVE_DATA_TYPE;
            private static final List<AppFunctionParameterMetadata> PARAMETER_METADATA_LIST;
            private static final AppFunctionIntTypeMetadata PARAMETER_METADATA_MINUTE_PRIMITIVE_DATA_TYPE;
            private static final AppFunctionStringTypeMetadata PRIMITIVE_RESPONSE_VALUE_TYPE;
            private static final AppFunctionResponseMetadata RESPONSE_METADATA;
            private static final AppFunctionSchemaMetadata SCHEMA_METADATA = null;

            static {
                AppFunctionIntTypeMetadata appFunctionIntTypeMetadata = new AppFunctionIntTypeMetadata(false, "", null);
                PARAMETER_METADATA_HOUR_PRIMITIVE_DATA_TYPE = appFunctionIntTypeMetadata;
                AppFunctionParameterMetadata appFunctionParameterMetadata = new AppFunctionParameterMetadata("hour", true, appFunctionIntTypeMetadata, "");
                HOUR_PARAMETER_METADATA = appFunctionParameterMetadata;
                AppFunctionIntTypeMetadata appFunctionIntTypeMetadata2 = new AppFunctionIntTypeMetadata(false, "", null);
                PARAMETER_METADATA_MINUTE_PRIMITIVE_DATA_TYPE = appFunctionIntTypeMetadata2;
                AppFunctionParameterMetadata appFunctionParameterMetadata2 = new AppFunctionParameterMetadata("minute", true, appFunctionIntTypeMetadata2, "");
                MINUTE_PARAMETER_METADATA = appFunctionParameterMetadata2;
                List<AppFunctionParameterMetadata> listListOf = CollectionsKt.listOf((Object[]) new AppFunctionParameterMetadata[]{appFunctionParameterMetadata, appFunctionParameterMetadata2});
                PARAMETER_METADATA_LIST = listListOf;
                AppFunctionStringTypeMetadata appFunctionStringTypeMetadata = new AppFunctionStringTypeMetadata(false, "", null);
                PRIMITIVE_RESPONSE_VALUE_TYPE = appFunctionStringTypeMetadata;
                AppFunctionResponseMetadata appFunctionResponseMetadata = new AppFunctionResponseMetadata(appFunctionStringTypeMetadata, "");
                RESPONSE_METADATA = appFunctionResponseMetadata;
                APP_FUNCTION_METADATA = new CompileTimeAppFunctionMetadata("com.urbandroid.sleep.functions.AppFunctions#createAlarm", true, SCHEMA_METADATA, listListOf, appFunctionResponseMetadata, null, null, null, 224, null);
            }

            private ComUrbandroidSleepFunctionsAppFunctionsCreateAlarmMetadataObject() {
            }

            public final CompileTimeAppFunctionMetadata getAPP_FUNCTION_METADATA() {
                return APP_FUNCTION_METADATA;
            }
        }

        /* JADX INFO: renamed from: com.urbandroid.sleep.functions.$AppFunctions_AppFunctionInventory$ComUrbandroidSleepFunctionsAppFunctionsStartSleepTrackingMetadataObject */
        @Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"com/urbandroid/sleep/functions/$AppFunctions_AppFunctionInventory.ComUrbandroidSleepFunctionsAppFunctionsStartSleepTrackingMetadataObject", "", "<init>", "()V", AppFunctionInventoryProcessor.SCHEMA_METADATA_PROPERTY_NAME, "Landroidx/appfunctions/metadata/AppFunctionSchemaMetadata;", AppFunctionInventoryProcessor.PARAMETER_METADATA_LIST_PROPERTY_NAME, "", "Landroidx/appfunctions/metadata/AppFunctionParameterMetadata;", "PRIMITIVE_RESPONSE_VALUE_TYPE", "Landroidx/appfunctions/metadata/AppFunctionStringTypeMetadata;", AppFunctionInventoryProcessor.RESPONSE_METADATA_PROPERTY_NAME, "Landroidx/appfunctions/metadata/AppFunctionResponseMetadata;", AppFunctionInventoryProcessor.APP_FUNCTION_METADATA_PROPERTY_NAME, "Landroidx/appfunctions/metadata/CompileTimeAppFunctionMetadata;", "getAPP_FUNCTION_METADATA", "()Landroidx/appfunctions/metadata/CompileTimeAppFunctionMetadata;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class ComUrbandroidSleepFunctionsAppFunctionsStartSleepTrackingMetadataObject {
            private static final CompileTimeAppFunctionMetadata APP_FUNCTION_METADATA;
            public static final ComUrbandroidSleepFunctionsAppFunctionsStartSleepTrackingMetadataObject INSTANCE = new ComUrbandroidSleepFunctionsAppFunctionsStartSleepTrackingMetadataObject();
            private static final List<AppFunctionParameterMetadata> PARAMETER_METADATA_LIST;
            private static final AppFunctionStringTypeMetadata PRIMITIVE_RESPONSE_VALUE_TYPE;
            private static final AppFunctionResponseMetadata RESPONSE_METADATA;
            private static final AppFunctionSchemaMetadata SCHEMA_METADATA = null;

            static {
                List<AppFunctionParameterMetadata> listEmptyList = CollectionsKt.emptyList();
                PARAMETER_METADATA_LIST = listEmptyList;
                AppFunctionStringTypeMetadata appFunctionStringTypeMetadata = new AppFunctionStringTypeMetadata(false, "", null);
                PRIMITIVE_RESPONSE_VALUE_TYPE = appFunctionStringTypeMetadata;
                AppFunctionResponseMetadata appFunctionResponseMetadata = new AppFunctionResponseMetadata(appFunctionStringTypeMetadata, "");
                RESPONSE_METADATA = appFunctionResponseMetadata;
                APP_FUNCTION_METADATA = new CompileTimeAppFunctionMetadata("com.urbandroid.sleep.functions.AppFunctions#startSleepTracking", true, SCHEMA_METADATA, listEmptyList, appFunctionResponseMetadata, null, null, null, 224, null);
            }

            private ComUrbandroidSleepFunctionsAppFunctionsStartSleepTrackingMetadataObject() {
            }

            public final CompileTimeAppFunctionMetadata getAPP_FUNCTION_METADATA() {
                return APP_FUNCTION_METADATA;
            }
        }

        {
            Map<String, AppFunctionDataTypeMetadata> mapEmptyMap = MapsKt.emptyMap();
            this.componentsMetadataDataTypesMap = mapEmptyMap;
            this.componentsMetadata = new AppFunctionComponentsMetadata(mapEmptyMap);
        }

        @Override // androidx.appfunctions.internal.AppFunctionInventory
        public AppFunctionComponentsMetadata getComponentsMetadata() {
            return this.componentsMetadata;
        }

        @Override // androidx.appfunctions.internal.AppFunctionInventory
        public Map<String, CompileTimeAppFunctionMetadata> getFunctionIdToMetadataMap() {
            return this.functionIdToMetadataMap;
        }
    });

    @Override // androidx.appfunctions.internal.AggregatedAppFunctionInventory
    public List<AppFunctionInventory> getInventories() {
        return this.inventories;
    }
}
