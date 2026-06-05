package androidx.appfunctions.internal;

import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.appfunctions.metadata.AppFunctionDeprecationMetadata;
import androidx.appfunctions.metadata.AppFunctionMetadata;
import androidx.appfunctions.metadata.AppFunctionName;
import androidx.appfunctions.metadata.AppFunctionPackageMetadata;
import androidx.appfunctions.metadata.AppFunctionParameterMetadata;
import androidx.appfunctions.metadata.AppFunctionResponseMetadata;
import androidx.appfunctions.metadata.AppFunctionSchemaMetadata;
import androidx.appfunctions.metadata.CompileTimeAppFunctionMetadata;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/appfunctions/internal/AppFunctionMetadataUtils;", "", "<init>", "()V", "getAppFunctionMetadata", "Landroidx/appfunctions/metadata/AppFunctionMetadata;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", IntrospectionHelper.AppFunctionInvokerClass.UnsafeInvokeMethod.FUNCTION_ID_PARAM_NAME, "", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppFunctionMetadataUtils {
    public static final AppFunctionMetadataUtils INSTANCE = new AppFunctionMetadataUtils();

    private AppFunctionMetadataUtils() {
    }

    public final Object getAppFunctionMetadata(Context context, String str, Continuation<? super AppFunctionMetadata> continuation) {
        Dependencies dependencies = Dependencies.INSTANCE;
        AppFunctionInventory appFunctionInventory$appfunctions = dependencies.getAppFunctionInventory$appfunctions();
        if (appFunctionInventory$appfunctions == null) {
            AppSearchAppFunctionReader appSearchAppFunctionReader = new AppSearchAppFunctionReader(context, dependencies.getSchemaAppFunctionInventory$appfunctions());
            String packageName = context.getPackageName();
            packageName.getClass();
            return appSearchAppFunctionReader.getAppFunctionMetadata(str, packageName, continuation);
        }
        CompileTimeAppFunctionMetadata compileTimeAppFunctionMetadata = appFunctionInventory$appfunctions.getFunctionIdToMetadataMap().get(str);
        if (compileTimeAppFunctionMetadata == null) {
            return null;
        }
        String packageName2 = context.getPackageName();
        packageName2.getClass();
        AppFunctionName appFunctionName = new AppFunctionName(packageName2, compileTimeAppFunctionMetadata.getId());
        AppFunctionSchemaMetadata schema = compileTimeAppFunctionMetadata.getSchema();
        List<AppFunctionParameterMetadata> parameters = compileTimeAppFunctionMetadata.getParameters();
        AppFunctionResponseMetadata response = compileTimeAppFunctionMetadata.getResponse();
        String packageName3 = context.getPackageName();
        packageName3.getClass();
        return new AppFunctionMetadata(appFunctionName, schema, parameters, response, new AppFunctionPackageMetadata(packageName3, appFunctionInventory$appfunctions.getComponentsMetadata()), compileTimeAppFunctionMetadata.isEnabledByDefault(), compileTimeAppFunctionMetadata.getDescription(), (AppFunctionDeprecationMetadata) null, 128, (DefaultConstructorMarker) null);
    }
}
