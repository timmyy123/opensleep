package androidx.appfunctions;

import android.content.Context;
import android.os.Build;
import android.os.UserManager;
import androidx.appfunctions.ExecuteAppFunctionResponse;
import androidx.appfunctions.compiler.core.AppFunctionXmlGenerator;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.appfunctions.internal.AppFunctionManagerApi;
import androidx.appfunctions.internal.AppFunctionReader;
import androidx.appfunctions.internal.AppSearchAppFunctionReader;
import androidx.appfunctions.internal.Dependencies;
import androidx.appfunctions.internal.ExtensionAppFunctionManagerApi;
import androidx.appfunctions.internal.NullTranslatorSelector;
import androidx.appfunctions.internal.PlatformAppFunctionManagerApi;
import androidx.appfunctions.internal.Translator;
import androidx.appfunctions.internal.TranslatorSelector;
import androidx.appfunctions.metadata.AppFunctionMetadata;
import androidx.appfunctions.metadata.AppFunctionPackageMetadata;
import androidx.appfunctions.metadata.AppFunctionSchemaMetadata;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.flow.Flow;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 *2\u00020\u0001:\u0002)*B+\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010\u0010J\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0087@¢\u0006\u0002\u0010\u0012J\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0086@¢\u0006\u0002\u0010\u0017J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0087@¢\u0006\u0002\u0010\u001cJ$\u0010\u001d\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020\u0019H\u0002J\u001c\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0%0$2\u0006\u0010'\u001a\u00020(H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Landroidx/appfunctions/AppFunctionManager;", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "appFunctionReader", "Landroidx/appfunctions/internal/AppFunctionReader;", "appFunctionManagerApi", "Landroidx/appfunctions/internal/AppFunctionManagerApi;", "translatorSelector", "Landroidx/appfunctions/internal/TranslatorSelector;", "<init>", "(Landroid/content/Context;Landroidx/appfunctions/internal/AppFunctionReader;Landroidx/appfunctions/internal/AppFunctionManagerApi;Landroidx/appfunctions/internal/TranslatorSelector;)V", "isAppFunctionEnabled", "", AppFunctionXmlGenerator.APP_FUNCTION_ID_TAG, "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "packageName", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setAppFunctionEnabled", "", "newEnabledState", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", IntrospectionHelper.AppFunctionExecutionDispatcherClass.ExecuteAppFunctionMethod.METHOD_NAME, "Landroidx/appfunctions/ExecuteAppFunctionResponse;", "request", "Landroidx/appfunctions/ExecuteAppFunctionRequest;", "(Landroidx/appfunctions/ExecuteAppFunctionRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processResponse", "translator", "Landroidx/appfunctions/internal/Translator;", "functionMetadata", "Landroidx/appfunctions/metadata/AppFunctionMetadata;", "response", "observeAppFunctions", "Lkotlinx/coroutines/flow/Flow;", "", "Landroidx/appfunctions/metadata/AppFunctionPackageMetadata;", "searchSpec", "Landroidx/appfunctions/AppFunctionSearchSpec;", "EnabledState", "Companion", "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppFunctionManager {
    public static final int APP_FUNCTION_STATE_DEFAULT = 0;
    public static final int APP_FUNCTION_STATE_DISABLED = 2;
    public static final int APP_FUNCTION_STATE_ENABLED = 1;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long LEGACY_SDK_GLOBAL_SCHEMA_VERSION = 1;
    private final AppFunctionManagerApi appFunctionManagerApi;
    private final AppFunctionReader appFunctionReader;
    private final Context context;
    private final TranslatorSelector translatorSelector;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/appfunctions/AppFunctionManager$Companion;", "", "<init>", "()V", "APP_FUNCTION_STATE_DEFAULT", "", "APP_FUNCTION_STATE_ENABLED", "APP_FUNCTION_STATE_DISABLED", "LEGACY_SDK_GLOBAL_SCHEMA_VERSION", "", "isExtensionLibraryAvailable", "", "getInstance", "Landroidx/appfunctions/AppFunctionManager;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean isExtensionLibraryAvailable() {
            try {
                Class.forName("com.android.extensions.appfunctions.AppFunctionManager");
                return true;
            } catch (ClassNotFoundException unused) {
                return false;
            }
        }

        public final AppFunctionManager getInstance(Context context) {
            context.getClass();
            int i = Build.VERSION.SDK_INT;
            if (i < 34) {
                return null;
            }
            UserManager userManager = (UserManager) context.getSystemService(UserManager.class);
            if (userManager != null && userManager.isProfile()) {
                return null;
            }
            if (i >= 36) {
                Dependencies dependencies = Dependencies.INSTANCE;
                return new AppFunctionManager(context, new AppSearchAppFunctionReader(context, dependencies.getSchemaAppFunctionInventory$appfunctions()), new PlatformAppFunctionManagerApi(context), dependencies.getTranslatorSelector());
            }
            if (!isExtensionLibraryAvailable()) {
                return null;
            }
            Dependencies dependencies2 = Dependencies.INSTANCE;
            return new AppFunctionManager(context, new AppSearchAppFunctionReader(context, dependencies2.getSchemaAppFunctionInventory$appfunctions()), new ExtensionAppFunctionManagerApi(context), dependencies2.getTranslatorSelector());
        }

        private Companion() {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Landroidx/appfunctions/AppFunctionManager$EnabledState;", "", "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public @interface EnabledState {
    }

    /* JADX INFO: renamed from: androidx.appfunctions.AppFunctionManager$executeAppFunction$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.appfunctions.AppFunctionManager", f = "AppFunctionManager.kt", l = {115, 149}, m = IntrospectionHelper.AppFunctionExecutionDispatcherClass.ExecuteAppFunctionMethod.METHOD_NAME, v = 1)
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AppFunctionManager.this.executeAppFunction(null, this);
        }
    }

    public AppFunctionManager(Context context, AppFunctionReader appFunctionReader, AppFunctionManagerApi appFunctionManagerApi, TranslatorSelector translatorSelector) {
        context.getClass();
        appFunctionReader.getClass();
        appFunctionManagerApi.getClass();
        translatorSelector.getClass();
        this.context = context;
        this.appFunctionReader = appFunctionReader;
        this.appFunctionManagerApi = appFunctionManagerApi;
        this.translatorSelector = translatorSelector;
    }

    public static final AppFunctionManager getInstance(Context context) {
        return INSTANCE.getInstance(context);
    }

    private final ExecuteAppFunctionResponse processResponse(Translator translator, AppFunctionMetadata functionMetadata, ExecuteAppFunctionResponse response) {
        AppFunctionData returnValue;
        if (!(response instanceof ExecuteAppFunctionResponse.Success)) {
            return response;
        }
        if (translator == null || (returnValue = translator.upgradeResponse(((ExecuteAppFunctionResponse.Success) response).getReturnValue())) == null) {
            returnValue = ((ExecuteAppFunctionResponse.Success) response).getReturnValue();
        }
        return functionMetadata == null ? new ExecuteAppFunctionResponse.Success(returnValue) : new ExecuteAppFunctionResponse.Success(returnValue.replaceSpecWith$appfunctions(functionMetadata.getResponse(), functionMetadata.getComponents()));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object executeAppFunction(ExecuteAppFunctionRequest executeAppFunctionRequest, Continuation<? super ExecuteAppFunctionResponse> continuation) {
        AnonymousClass1 anonymousClass1;
        AppFunctionMetadata appFunctionMetadata;
        Translator translator;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object appFunctionMetadata2 = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        Translator translator2 = null;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(appFunctionMetadata2);
                AppFunctionReader appFunctionReader = this.appFunctionReader;
                String functionIdentifier = executeAppFunctionRequest.getFunctionIdentifier();
                String targetPackageName = executeAppFunctionRequest.getTargetPackageName();
                anonymousClass1.L$0 = executeAppFunctionRequest;
                anonymousClass1.label = 1;
                appFunctionMetadata2 = appFunctionReader.getAppFunctionMetadata(functionIdentifier, targetPackageName, anonymousClass1);
                if (appFunctionMetadata2 == coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                translator = (Translator) anonymousClass1.L$1;
                appFunctionMetadata = (AppFunctionMetadata) anonymousClass1.L$0;
                ResultKt.throwOnFailure(appFunctionMetadata2);
                return processResponse(translator, appFunctionMetadata, (ExecuteAppFunctionResponse) appFunctionMetadata2);
            }
            executeAppFunctionRequest = (ExecuteAppFunctionRequest) anonymousClass1.L$0;
            ResultKt.throwOnFailure(appFunctionMetadata2);
            ExecuteAppFunctionRequest executeAppFunctionRequestCopy$default = executeAppFunctionRequest;
            AppFunctionMetadata appFunctionMetadata3 = (AppFunctionMetadata) appFunctionMetadata2;
            if (appFunctionMetadata3 == null) {
                throw new AppFunctionFunctionNotFoundException("App function not found with identifier: " + executeAppFunctionRequestCopy$default.getFunctionIdentifier() + " under package: " + executeAppFunctionRequestCopy$default.getTargetPackageName());
            }
            AppFunctionSchemaMetadata schema = appFunctionMetadata3.getSchema();
            if (schema != null && schema.getVersion() == 1) {
                translator2 = this.translatorSelector.getTranslator(appFunctionMetadata3.getSchema());
            }
            if (translator2 != null) {
                executeAppFunctionRequestCopy$default = ExecuteAppFunctionRequest.copy$default(executeAppFunctionRequestCopy$default, null, null, translator2.downgradeRequest(executeAppFunctionRequestCopy$default.getFunctionParameters()), false, 11, null);
            }
            AppFunctionManagerApi appFunctionManagerApi = this.appFunctionManagerApi;
            anonymousClass1.L$0 = appFunctionMetadata3;
            anonymousClass1.L$1 = translator2;
            anonymousClass1.label = 2;
            appFunctionMetadata2 = appFunctionManagerApi.executeAppFunction(executeAppFunctionRequestCopy$default, appFunctionMetadata3, anonymousClass1);
            if (appFunctionMetadata2 != coroutine_suspended) {
                appFunctionMetadata = appFunctionMetadata3;
                translator = translator2;
                return processResponse(translator, appFunctionMetadata, (ExecuteAppFunctionResponse) appFunctionMetadata2);
            }
            return coroutine_suspended;
        } catch (AppFunctionFunctionNotFoundException e) {
            return new ExecuteAppFunctionResponse.Error(e);
        } catch (Exception e2) {
            return new ExecuteAppFunctionResponse.Error(new AppFunctionSystemUnknownException("Something went wrong when querying the app function from AppSearch: " + e2.getMessage()));
        }
    }

    public final Object isAppFunctionEnabled(String str, Continuation<? super Boolean> continuation) {
        String packageName = this.context.getPackageName();
        packageName.getClass();
        return isAppFunctionEnabled(packageName, str, continuation);
    }

    public final Flow<List<AppFunctionPackageMetadata>> observeAppFunctions(AppFunctionSearchSpec searchSpec) {
        searchSpec.getClass();
        return this.appFunctionReader.searchAppFunctions(searchSpec);
    }

    public final Object setAppFunctionEnabled(String str, int i, Continuation<? super Unit> continuation) {
        Object appFunctionEnabled = this.appFunctionManagerApi.setAppFunctionEnabled(str, i, continuation);
        return appFunctionEnabled == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? appFunctionEnabled : Unit.INSTANCE;
    }

    public final Object isAppFunctionEnabled(String str, String str2, Continuation<? super Boolean> continuation) {
        return this.appFunctionManagerApi.isAppFunctionEnabled(str, str2, continuation);
    }

    public /* synthetic */ AppFunctionManager(Context context, AppFunctionReader appFunctionReader, AppFunctionManagerApi appFunctionManagerApi, TranslatorSelector translatorSelector, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, appFunctionReader, appFunctionManagerApi, (i & 8) != 0 ? new NullTranslatorSelector() : translatorSelector);
    }
}
