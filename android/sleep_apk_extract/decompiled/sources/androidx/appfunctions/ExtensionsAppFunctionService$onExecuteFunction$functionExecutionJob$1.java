package androidx.appfunctions;

import android.content.Context;
import android.os.OutcomeReceiver;
import androidx.appfunctions.ExecuteAppFunctionResponse;
import androidx.appfunctions.internal.AppFunctionMetadataUtils;
import androidx.appfunctions.internal.Dispatchers;
import androidx.appfunctions.metadata.AppFunctionMetadata;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.appfunctions.ExtensionsAppFunctionService$onExecuteFunction$functionExecutionJob$1", f = "ExtensionsAppFunctionService.kt", l = {86, 93}, m = "invokeSuspend", v = 1)
public final class ExtensionsAppFunctionService$onExecuteFunction$functionExecutionJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ OutcomeReceiver $callback;
    final /* synthetic */ String $callingPackage;
    final /* synthetic */ com.android.extensions.appfunctions.ExecuteAppFunctionRequest $request;
    int label;
    final /* synthetic */ ExtensionsAppFunctionService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExtensionsAppFunctionService$onExecuteFunction$functionExecutionJob$1(ExtensionsAppFunctionService extensionsAppFunctionService, com.android.extensions.appfunctions.ExecuteAppFunctionRequest executeAppFunctionRequest, String str, OutcomeReceiver outcomeReceiver, Continuation<? super ExtensionsAppFunctionService$onExecuteFunction$functionExecutionJob$1> continuation) {
        super(2, continuation);
        this.this$0 = extensionsAppFunctionService;
        this.$request = executeAppFunctionRequest;
        this.$callingPackage = str;
        this.$callback = outcomeReceiver;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ExtensionsAppFunctionService$onExecuteFunction$functionExecutionJob$1(this.this$0, this.$request, this.$callingPackage, this.$callback, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ExtensionsAppFunctionService$onExecuteFunction$functionExecutionJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0055, code lost:
    
        if (r8 == r1) goto L22;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ExecuteAppFunctionResponse error;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
        } catch (AppFunctionException e) {
            error = new ExecuteAppFunctionResponse.Error(e);
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AppFunctionMetadataUtils appFunctionMetadataUtils = AppFunctionMetadataUtils.INSTANCE;
            Context context = (Context) this.this$0;
            String functionIdentifier = this.$request.getFunctionIdentifier();
            functionIdentifier.getClass();
            this.label = 1;
            obj = appFunctionMetadataUtils.getAppFunctionMetadata(context, functionIdentifier, this);
            if (obj == coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            error = (ExecuteAppFunctionResponse) obj;
            if (error instanceof ExecuteAppFunctionResponse.Success) {
                ExecuteAppFunctionResponse.Success success = (ExecuteAppFunctionResponse.Success) error;
                success.grantUriAccess$appfunctions((Context) this.this$0, this.$callingPackage);
                this.$callback.onResult(success.toPlatformExtensionClass$appfunctions());
            } else {
                if (!(error instanceof ExecuteAppFunctionResponse.Error)) {
                    Home$$ExternalSyntheticBUOutline0.m();
                    return null;
                }
                this.$callback.onError((Throwable) ((ExecuteAppFunctionResponse.Error) error).getError().toPlatformExtensionsClass());
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        AppFunctionMetadata appFunctionMetadata = (AppFunctionMetadata) obj;
        if (appFunctionMetadata == null) {
            throw new AppFunctionFunctionNotFoundException("No function found with identifier: " + this.$request.getFunctionIdentifier() + " in package: " + this.this$0.getPackageName());
        }
        CoroutineDispatcher main = Dispatchers.INSTANCE.getMain();
        ExtensionsAppFunctionService$onExecuteFunction$functionExecutionJob$1$result$1 extensionsAppFunctionService$onExecuteFunction$functionExecutionJob$1$result$1 = new ExtensionsAppFunctionService$onExecuteFunction$functionExecutionJob$1$result$1(this.this$0, this.$request, appFunctionMetadata, null);
        this.label = 2;
        obj = BuildersKt.withContext(main, extensionsAppFunctionService$onExecuteFunction$functionExecutionJob$1$result$1, this);
    }
}
