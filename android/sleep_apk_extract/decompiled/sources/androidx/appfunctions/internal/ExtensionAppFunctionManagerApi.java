package androidx.appfunctions.internal;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.os.CancellationSignal;
import android.os.OutcomeReceiver;
import androidx.appfunctions.AppFunctionException;
import androidx.appfunctions.AppFunctionFunctionNotFoundException;
import androidx.appfunctions.AppFunctionSystemUnknownException;
import androidx.appfunctions.ExecuteAppFunctionRequest;
import androidx.appfunctions.ExecuteAppFunctionResponse;
import androidx.appfunctions.compiler.core.AppFunctionXmlGenerator;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.appfunctions.metadata.AppFunctionMetadata;
import androidx.arch.core.executor.ArchTaskExecutor$$ExternalSyntheticLambda0;
import com.android.extensions.appfunctions.AppFunctionManager;
import io.ktor.http.Url$$ExternalSyntheticLambda0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u0012J\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0096@¢\u0006\u0002\u0010\u0018J\u001e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001cH\u0096@¢\u0006\u0002\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fH\u0002J\u0010\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u001cH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006#"}, d2 = {"Landroidx/appfunctions/internal/ExtensionAppFunctionManagerApi;", "Landroidx/appfunctions/internal/AppFunctionManagerApi;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "appFunctionManager", "Lcom/android/extensions/appfunctions/AppFunctionManager;", "getAppFunctionManager", "()Lcom/android/extensions/appfunctions/AppFunctionManager;", "appFunctionManager$delegate", "Lkotlin/Lazy;", IntrospectionHelper.AppFunctionExecutionDispatcherClass.ExecuteAppFunctionMethod.METHOD_NAME, "Landroidx/appfunctions/ExecuteAppFunctionResponse;", "request", "Landroidx/appfunctions/ExecuteAppFunctionRequest;", "functionMetadata", "Landroidx/appfunctions/metadata/AppFunctionMetadata;", "(Landroidx/appfunctions/ExecuteAppFunctionRequest;Landroidx/appfunctions/metadata/AppFunctionMetadata;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isAppFunctionEnabled", "", "packageName", "", AppFunctionXmlGenerator.APP_FUNCTION_ID_TAG, "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setAppFunctionEnabled", "", "newEnabledState", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fixAppFunctionExceptionErrorType", "Landroidx/appfunctions/AppFunctionException;", "exception", "convertToPlatformExtensionEnabledState", "enabledState", "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExtensionAppFunctionManagerApi implements AppFunctionManagerApi {

    /* JADX INFO: renamed from: appFunctionManager$delegate, reason: from kotlin metadata */
    private final Lazy appFunctionManager;
    private final Context context;

    public ExtensionAppFunctionManagerApi(Context context) {
        context.getClass();
        this.context = context;
        this.appFunctionManager = LazyKt.lazy(new Url$$ExternalSyntheticLambda0(this, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppFunctionManager appFunctionManager_delegate$lambda$0(ExtensionAppFunctionManagerApi extensionAppFunctionManagerApi) {
        return new AppFunctionManager(extensionAppFunctionManagerApi.context);
    }

    private final int convertToPlatformExtensionEnabledState(int enabledState) {
        if (enabledState == 0) {
            return 0;
        }
        if (enabledState == 1) {
            return 1;
        }
        if (enabledState == 2) {
            return 2;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m(enabledState, "Unknown enabled state "));
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppFunctionException fixAppFunctionExceptionErrorType(AppFunctionException exception) {
        return ((exception instanceof AppFunctionSystemUnknownException) && Intrinsics.areEqual(exception.getErrorMessage(), "IllegalArgumentException: App function not found.")) ? new AppFunctionFunctionNotFoundException("App function not found.") : exception;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppFunctionManager getAppFunctionManager() {
        return (AppFunctionManager) this.appFunctionManager.getValue();
    }

    @Override // androidx.appfunctions.internal.AppFunctionManagerApi
    public Object executeAppFunction(ExecuteAppFunctionRequest executeAppFunctionRequest, final AppFunctionMetadata appFunctionMetadata, Continuation<? super ExecuteAppFunctionResponse> continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellationSignal cancellationSignal = new CancellationSignal();
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.appfunctions.internal.ExtensionAppFunctionManagerApi$executeAppFunction$2$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                cancellationSignal.cancel();
            }
        });
        getAppFunctionManager().executeAppFunction(executeAppFunctionRequest.toPlatformExtensionClass$appfunctions(), new ArchTaskExecutor$$ExternalSyntheticLambda0(1), cancellationSignal, new OutcomeReceiver() { // from class: androidx.appfunctions.internal.ExtensionAppFunctionManagerApi$executeAppFunction$2$3
            public void onError(com.android.extensions.appfunctions.AppFunctionException error) {
                error.getClass();
                AppFunctionException appFunctionExceptionFixAppFunctionExceptionErrorType = this.fixAppFunctionExceptionErrorType(AppFunctionException.INSTANCE.fromPlatformExtensionsClass(error));
                CancellableContinuation<ExecuteAppFunctionResponse> cancellableContinuation = cancellableContinuationImpl;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m2357constructorimpl(new ExecuteAppFunctionResponse.Error(appFunctionExceptionFixAppFunctionExceptionErrorType)));
            }

            public void onResult(com.android.extensions.appfunctions.ExecuteAppFunctionResponse result) {
                result.getClass();
                CancellableContinuation<ExecuteAppFunctionResponse> cancellableContinuation = cancellableContinuationImpl;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m2357constructorimpl(ExecuteAppFunctionResponse.Success.INSTANCE.fromPlatformExtensionClass$appfunctions(result, appFunctionMetadata)));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @Override // androidx.appfunctions.internal.AppFunctionManagerApi
    public Object isAppFunctionEnabled(String str, String str2, Continuation<? super Boolean> continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        getAppFunctionManager().isAppFunctionEnabled(str2, str, new ArchTaskExecutor$$ExternalSyntheticLambda0(1), new OutcomeReceiver() { // from class: androidx.appfunctions.internal.ExtensionAppFunctionManagerApi$isAppFunctionEnabled$2$2
            public void onError(Exception error) {
                error.getClass();
                CancellableContinuation<Boolean> cancellableContinuation = cancellableContinuationImpl;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m2357constructorimpl(ResultKt.createFailure(error)));
            }

            public void onResult(Boolean result) {
                CancellableContinuation<Boolean> cancellableContinuation = cancellableContinuationImpl;
                if (result != null) {
                    cancellableContinuation.resumeWith(Result.m2357constructorimpl(result));
                } else {
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m2357constructorimpl(ResultKt.createFailure(new IllegalStateException("Something went wrong"))));
                }
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @Override // androidx.appfunctions.internal.AppFunctionManagerApi
    public Object setAppFunctionEnabled(String str, int i, Continuation<? super Unit> continuation) {
        int iConvertToPlatformExtensionEnabledState = convertToPlatformExtensionEnabledState(i);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        getAppFunctionManager().setAppFunctionEnabled(str, iConvertToPlatformExtensionEnabledState, new ArchTaskExecutor$$ExternalSyntheticLambda0(1), new OutcomeReceiver() { // from class: androidx.appfunctions.internal.ExtensionAppFunctionManagerApi$setAppFunctionEnabled$2$2
            public void onError(Exception error) {
                error.getClass();
                CancellableContinuation<Unit> cancellableContinuation = cancellableContinuationImpl;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m2357constructorimpl(ResultKt.createFailure(error)));
            }

            public void onResult(Void result) {
                CancellableContinuation<Unit> cancellableContinuation = cancellableContinuationImpl;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m2357constructorimpl(Unit.INSTANCE));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }
}
