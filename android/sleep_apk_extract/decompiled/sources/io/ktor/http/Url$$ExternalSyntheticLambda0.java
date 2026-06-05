package io.ktor.http;

import androidx.appfunctions.internal.ExtensionAppFunctionManagerApi;
import androidx.appfunctions.internal.PlatformAppFunctionManagerApi;
import androidx.appfunctions.internal.SchemaAppFunctionInventory;
import androidx.appfunctions.service.internal.AggregatedAppFunctionInvoker;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper;
import androidx.view.SavedStateHandleSupport;
import androidx.view.SavedStateRegistryController;
import androidx.view.SavedStateRegistryOwner;
import androidx.view.ViewModelStoreOwner;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkManagerImpl;
import com.squareup.kotlinpoet.AnnotationSpec;
import com.squareup.kotlinpoet.TypeName;
import com.urbandroid.sleep.activityrecognition.ActivityRecognitionInitializer;
import com.urbandroid.sleep.hr.AutoDetectClient;
import com.urbandroid.sleep.sensor.extra.EnsembleExtraDataCollector;
import com.urbandroid.sleep.smartlight.UnifiedSmartLight;
import com.urbandroid.sleep.smartwatch.polar.Polar;
import com.urbandroid.sleep.trial.Billing;
import com.urbandroid.smartlight.ikea.tradfri.Client;
import io.ktor.client.engine.okhttp.OkHttpEngineKt;
import io.ktor.http.content.OutgoingContent;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.KTypeParameterBase;
import kotlin.time.AbstractLongTimeSource;
import kotlinx.serialization.descriptors.SerialDescriptorImpl;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Url$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ Url$$ExternalSyntheticLambda0(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        int i = this.$r8$classId;
        Object obj = this.f$0;
        switch (i) {
            case 0:
                return Url.segments_delegate$lambda$1((List) obj);
            case 1:
                return ExtensionAppFunctionManagerApi.appFunctionManager_delegate$lambda$0((ExtensionAppFunctionManagerApi) obj);
            case 2:
                return PlatformAppFunctionManagerApi.appFunctionManager_delegate$lambda$0((PlatformAppFunctionManagerApi) obj);
            case 3:
                return SchemaAppFunctionInventory.schemaFunctionsMap_delegate$lambda$0((SchemaAppFunctionInventory) obj);
            case 4:
                return AggregatedAppFunctionInvoker.supportedFunctionIds_delegate$lambda$0((AggregatedAppFunctionInvoker) obj);
            case 5:
                return SavedStateHandleSupport.getSavedStateHandlesVM((ViewModelStoreOwner) obj);
            case 6:
                return SavedStateRegistryController.Companion.create$lambda$0((SavedStateRegistryOwner) obj);
            case 7:
                return FrameworkSQLiteOpenHelper.lazyDelegate$lambda$0((FrameworkSQLiteOpenHelper) obj);
            case 8:
                return ((WorkContinuationImpl) obj).lambda$enqueue$0();
            case 9:
                return ((WorkManagerImpl) obj).lambda$rescheduleEligibleWork$0();
            case 10:
                return AnnotationSpec.cachedString_delegate$lambda$1((AnnotationSpec) obj);
            case 11:
                return TypeName.cachedString_delegate$lambda$1((TypeName) obj);
            case 12:
                return ActivityRecognitionInitializer.client_delegate$lambda$0((ActivityRecognitionInitializer) obj);
            case 13:
                return Boolean.valueOf(AutoDetectClient._init_$lambda$0((AutoDetectClient) obj));
            case 14:
                return EnsembleExtraDataCollector.apneaAlarmDetector_delegate$lambda$0((EnsembleExtraDataCollector) obj);
            case 15:
                return UnifiedSmartLight.controller_delegate$lambda$0((UnifiedSmartLight) obj);
            case 16:
                return Polar.api_delegate$lambda$0((Polar) obj);
            case 17:
                return Billing.prefs_delegate$lambda$0((Billing) obj);
            case 18:
                return Client.Authenticated.endpoint_delegate$lambda$4((Client.Authenticated) obj);
            case 19:
                return Client.Plain.endpoint_delegate$lambda$3((Client.Plain) obj);
            case 20:
                return OkHttpEngineKt.convertToOkHttpBody$lambda$3((OutgoingContent.ReadChannelContent) obj);
            case 21:
                return KTypeParameterBase.javaContainingDeclaration_delegate$lambda$0((KTypeParameterBase) obj);
            case 22:
                return Long.valueOf(((AbstractLongTimeSource) obj).read());
            default:
                return Integer.valueOf(SerialDescriptorImpl._hashCode_delegate$lambda$1((SerialDescriptorImpl) obj));
        }
    }
}
