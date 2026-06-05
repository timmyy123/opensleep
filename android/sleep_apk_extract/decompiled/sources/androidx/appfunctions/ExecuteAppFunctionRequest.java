package androidx.appfunctions;

import android.app.AppInteractionAttribution;
import android.app.appfunctions.ExecuteAppFunctionRequest;
import android.app.appsearch.GenericDocument;
import android.os.Build;
import android.os.Bundle;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.appfunctions.metadata.AppFunctionMetadata;
import com.android.extensions.appfunctions.ExecuteAppFunctionRequest;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB5\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\rB)\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\u000eJ\r\u0010\u0018\u001a\u00020\u0019H\u0000¢\u0006\u0002\b\u001aJ\b\u0010\u001b\u001a\u00020\u001cH\u0007J\b\u0010\u001d\u001a\u00020\u0003H\u0016J0\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\nH\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\t\u001a\u00020\n8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006 "}, d2 = {"Landroidx/appfunctions/ExecuteAppFunctionRequest;", "", "targetPackageName", "", IntrospectionHelper.AppFunctionInvokerClass.UnsafeInvokeMethod.FUNCTION_ID_PARAM_NAME, "functionParameters", "Landroidx/appfunctions/AppFunctionData;", "attribution", "Landroid/app/AppInteractionAttribution;", "useJetpackSchema", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroidx/appfunctions/AppFunctionData;Landroid/app/AppInteractionAttribution;Z)V", "(Ljava/lang/String;Ljava/lang/String;Landroidx/appfunctions/AppFunctionData;)V", "(Ljava/lang/String;Ljava/lang/String;Landroidx/appfunctions/AppFunctionData;Landroid/app/AppInteractionAttribution;)V", "getTargetPackageName", "()Ljava/lang/String;", "getFunctionIdentifier", "getFunctionParameters", "()Landroidx/appfunctions/AppFunctionData;", "getAttribution", "()Landroid/app/AppInteractionAttribution;", "getUseJetpackSchema", "()Z", "toPlatformExtensionClass", "Lcom/android/extensions/appfunctions/ExecuteAppFunctionRequest;", "toPlatformExtensionClass$appfunctions", "toPlatformExecuteAppFunctionRequest", "Landroid/app/appfunctions/ExecuteAppFunctionRequest;", InAppPurchaseConstants.METHOD_TO_STRING, "copy", "Companion", "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExecuteAppFunctionRequest {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String EXTRA_PARAMETERS = "androidXAppfunctionsExtraParameters";
    public static final String EXTRA_USE_JETPACK_SCHEMA = "androidXAppfunctionsExtraUseJetpackSchema";
    private final AppInteractionAttribution attribution;
    private final String functionIdentifier;
    private final AppFunctionData functionParameters;
    private final String targetPackageName;
    private final boolean useJetpackSchema;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0001¢\u0006\u0002\b\rJ\u0014\u0010\u000e\u001a\u00020\b*\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/appfunctions/ExecuteAppFunctionRequest$Companion;", "", "<init>", "()V", "EXTRA_PARAMETERS", "", "EXTRA_USE_JETPACK_SCHEMA", "fromPlatformExtensionClass", "Landroidx/appfunctions/ExecuteAppFunctionRequest;", "request", "Lcom/android/extensions/appfunctions/ExecuteAppFunctionRequest;", "functionMetadata", "Landroidx/appfunctions/metadata/AppFunctionMetadata;", "fromPlatformExtensionClass$appfunctions", "toCompatExecuteAppFunctionRequest", "Landroid/app/appfunctions/ExecuteAppFunctionRequest;", "createAppFunctionDataWithParameterSpec", "Landroidx/appfunctions/AppFunctionData;", "parametersAfd", "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final AppFunctionData createAppFunctionDataWithParameterSpec(AppFunctionMetadata functionMetadata, AppFunctionData parametersAfd) {
            return parametersAfd.replaceSpecWith$appfunctions(functionMetadata.getParameters(), functionMetadata.getComponents());
        }

        public final ExecuteAppFunctionRequest fromPlatformExtensionClass$appfunctions(com.android.extensions.appfunctions.ExecuteAppFunctionRequest request, AppFunctionMetadata functionMetadata) {
            request.getClass();
            functionMetadata.getClass();
            String targetPackageName = request.getTargetPackageName();
            targetPackageName.getClass();
            String functionIdentifier = request.getFunctionIdentifier();
            functionIdentifier.getClass();
            GenericDocument parameters = request.getParameters();
            parameters.getClass();
            Bundle bundle = request.getExtras().getBundle(ExecuteAppFunctionRequest.EXTRA_PARAMETERS);
            if (bundle == null) {
                bundle = Bundle.EMPTY;
            }
            bundle.getClass();
            return new ExecuteAppFunctionRequest(targetPackageName, functionIdentifier, createAppFunctionDataWithParameterSpec(functionMetadata, new AppFunctionData(parameters, bundle)), null, request.getExtras().getBoolean(ExecuteAppFunctionRequest.EXTRA_USE_JETPACK_SCHEMA, false), 8, null);
        }

        public final ExecuteAppFunctionRequest toCompatExecuteAppFunctionRequest(android.app.appfunctions.ExecuteAppFunctionRequest executeAppFunctionRequest, AppFunctionMetadata appFunctionMetadata) {
            executeAppFunctionRequest.getClass();
            appFunctionMetadata.getClass();
            String targetPackageName = executeAppFunctionRequest.getTargetPackageName();
            targetPackageName.getClass();
            String functionIdentifier = executeAppFunctionRequest.getFunctionIdentifier();
            functionIdentifier.getClass();
            GenericDocument parameters = executeAppFunctionRequest.getParameters();
            parameters.getClass();
            Bundle bundle = executeAppFunctionRequest.getExtras().getBundle(ExecuteAppFunctionRequest.EXTRA_PARAMETERS);
            if (bundle == null) {
                bundle = Bundle.EMPTY;
            }
            bundle.getClass();
            return new ExecuteAppFunctionRequest(targetPackageName, functionIdentifier, createAppFunctionDataWithParameterSpec(appFunctionMetadata, new AppFunctionData(parameters, bundle)), Build.VERSION.SDK_INT >= 37 ? executeAppFunctionRequest.getAttribution() : null, executeAppFunctionRequest.getExtras().getBoolean(ExecuteAppFunctionRequest.EXTRA_USE_JETPACK_SCHEMA, false));
        }

        private Companion() {
        }
    }

    public ExecuteAppFunctionRequest(String str, String str2, AppFunctionData appFunctionData, AppInteractionAttribution appInteractionAttribution, boolean z) {
        str.getClass();
        str2.getClass();
        appFunctionData.getClass();
        this.targetPackageName = str;
        this.functionIdentifier = str2;
        this.functionParameters = appFunctionData;
        this.attribution = appInteractionAttribution;
        this.useJetpackSchema = z;
    }

    public static /* synthetic */ ExecuteAppFunctionRequest copy$default(ExecuteAppFunctionRequest executeAppFunctionRequest, String str, String str2, AppFunctionData appFunctionData, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = executeAppFunctionRequest.targetPackageName;
        }
        if ((i & 2) != 0) {
            str2 = executeAppFunctionRequest.functionIdentifier;
        }
        if ((i & 4) != 0) {
            appFunctionData = executeAppFunctionRequest.functionParameters;
        }
        if ((i & 8) != 0) {
            z = executeAppFunctionRequest.useJetpackSchema;
        }
        return executeAppFunctionRequest.copy(str, str2, appFunctionData, z);
    }

    public static final ExecuteAppFunctionRequest toCompatExecuteAppFunctionRequest(android.app.appfunctions.ExecuteAppFunctionRequest executeAppFunctionRequest, AppFunctionMetadata appFunctionMetadata) {
        return INSTANCE.toCompatExecuteAppFunctionRequest(executeAppFunctionRequest, appFunctionMetadata);
    }

    public final ExecuteAppFunctionRequest copy(String targetPackageName, String functionIdentifier, AppFunctionData functionParameters, boolean useJetpackSchema) {
        targetPackageName.getClass();
        functionIdentifier.getClass();
        functionParameters.getClass();
        return new ExecuteAppFunctionRequest(targetPackageName, functionIdentifier, functionParameters, this.attribution, useJetpackSchema);
    }

    public final AppInteractionAttribution getAttribution() {
        return this.attribution;
    }

    public final String getFunctionIdentifier() {
        return this.functionIdentifier;
    }

    public final AppFunctionData getFunctionParameters() {
        return this.functionParameters;
    }

    public final String getTargetPackageName() {
        return this.targetPackageName;
    }

    public final boolean getUseJetpackSchema() {
        return this.useJetpackSchema;
    }

    public final android.app.appfunctions.ExecuteAppFunctionRequest toPlatformExecuteAppFunctionRequest() {
        AppInteractionAttribution appInteractionAttribution;
        ExecuteAppFunctionRequest.Builder parameters = new ExecuteAppFunctionRequest.Builder(this.targetPackageName, this.functionIdentifier).setParameters(this.functionParameters.getGenericDocument());
        Bundle bundle = new Bundle();
        bundle.putBundle(EXTRA_PARAMETERS, this.functionParameters.getExtras());
        bundle.putBoolean(EXTRA_USE_JETPACK_SCHEMA, this.useJetpackSchema);
        ExecuteAppFunctionRequest.Builder extras = parameters.setExtras(bundle);
        if (Build.VERSION.SDK_INT >= 37 && (appInteractionAttribution = this.attribution) != null) {
            extras.setAttribution(appInteractionAttribution);
        }
        android.app.appfunctions.ExecuteAppFunctionRequest executeAppFunctionRequestBuild = extras.build();
        executeAppFunctionRequestBuild.getClass();
        return executeAppFunctionRequestBuild;
    }

    public final com.android.extensions.appfunctions.ExecuteAppFunctionRequest toPlatformExtensionClass$appfunctions() {
        ExecuteAppFunctionRequest.Builder parameters = new ExecuteAppFunctionRequest.Builder(this.targetPackageName, this.functionIdentifier).setParameters(this.functionParameters.getGenericDocument());
        Bundle bundle = new Bundle();
        bundle.putBundle(EXTRA_PARAMETERS, this.functionParameters.getExtras());
        bundle.putBoolean(EXTRA_USE_JETPACK_SCHEMA, this.useJetpackSchema);
        com.android.extensions.appfunctions.ExecuteAppFunctionRequest executeAppFunctionRequestBuild = parameters.setExtras(bundle).build();
        executeAppFunctionRequestBuild.getClass();
        return executeAppFunctionRequestBuild;
    }

    public String toString() {
        return "ExecuteAppFunctionRequest(functionMetadata.packageName=" + this.targetPackageName + ", functionMetadata.id=" + this.functionIdentifier + ", functionParameters=" + this.functionParameters + ')';
    }

    public /* synthetic */ ExecuteAppFunctionRequest(String str, String str2, AppFunctionData appFunctionData, AppInteractionAttribution appInteractionAttribution, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, appFunctionData, (i & 8) != 0 ? null : appInteractionAttribution, z);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExecuteAppFunctionRequest(String str, String str2, AppFunctionData appFunctionData) {
        this(str, str2, appFunctionData, null, true);
        str.getClass();
        str2.getClass();
        appFunctionData.getClass();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExecuteAppFunctionRequest(String str, String str2, AppFunctionData appFunctionData, AppInteractionAttribution appInteractionAttribution) {
        this(str, str2, appFunctionData, appInteractionAttribution, true);
        str.getClass();
        str2.getClass();
        appFunctionData.getClass();
        appInteractionAttribution.getClass();
    }
}
