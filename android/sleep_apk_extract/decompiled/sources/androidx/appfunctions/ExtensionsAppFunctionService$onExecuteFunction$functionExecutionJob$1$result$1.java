package androidx.appfunctions;

import androidx.appfunctions.metadata.AppFunctionMetadata;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroidx/appfunctions/ExecuteAppFunctionResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.appfunctions.ExtensionsAppFunctionService$onExecuteFunction$functionExecutionJob$1$result$1", f = "ExtensionsAppFunctionService.kt", l = {94}, m = "invokeSuspend", v = 1)
public final class ExtensionsAppFunctionService$onExecuteFunction$functionExecutionJob$1$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ExecuteAppFunctionResponse>, Object> {
    final /* synthetic */ AppFunctionMetadata $appFunctionMetadata;
    final /* synthetic */ com.android.extensions.appfunctions.ExecuteAppFunctionRequest $request;
    int label;
    final /* synthetic */ ExtensionsAppFunctionService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExtensionsAppFunctionService$onExecuteFunction$functionExecutionJob$1$result$1(ExtensionsAppFunctionService extensionsAppFunctionService, com.android.extensions.appfunctions.ExecuteAppFunctionRequest executeAppFunctionRequest, AppFunctionMetadata appFunctionMetadata, Continuation<? super ExtensionsAppFunctionService$onExecuteFunction$functionExecutionJob$1$result$1> continuation) {
        super(2, continuation);
        this.this$0 = extensionsAppFunctionService;
        this.$request = executeAppFunctionRequest;
        this.$appFunctionMetadata = appFunctionMetadata;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ExtensionsAppFunctionService$onExecuteFunction$functionExecutionJob$1$result$1(this.this$0, this.$request, this.$appFunctionMetadata, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ExecuteAppFunctionResponse> continuation) {
        return ((ExtensionsAppFunctionService$onExecuteFunction$functionExecutionJob$1$result$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(obj);
        ExtensionsAppFunctionService extensionsAppFunctionService = this.this$0;
        ExecuteAppFunctionRequest executeAppFunctionRequestFromPlatformExtensionClass$appfunctions = ExecuteAppFunctionRequest.INSTANCE.fromPlatformExtensionClass$appfunctions(this.$request, this.$appFunctionMetadata);
        this.label = 1;
        Object objExecuteFunction = extensionsAppFunctionService.executeFunction(executeAppFunctionRequestFromPlatformExtensionClass$appfunctions, this);
        return objExecuteFunction == coroutine_suspended ? coroutine_suspended : objExecuteFunction;
    }
}
