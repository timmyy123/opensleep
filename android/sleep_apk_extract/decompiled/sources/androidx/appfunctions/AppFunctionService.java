package androidx.appfunctions;

import android.content.pm.SigningInfo;
import android.os.CancellationSignal;
import android.os.OutcomeReceiver;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.appfunctions.internal.Dispatchers;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J:\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\u0016H§@¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0007H\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Landroidx/appfunctions/AppFunctionService;", "Landroid/app/appfunctions/AppFunctionService;", "<init>", "()V", "workerCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "onExecuteFunction", "", "request", "Landroid/app/appfunctions/ExecuteAppFunctionRequest;", "callingPackage", "", "signingInfo", "Landroid/content/pm/SigningInfo;", "cancellationSignal", "Landroid/os/CancellationSignal;", "callback", "Landroid/os/OutcomeReceiver;", "Landroid/app/appfunctions/ExecuteAppFunctionResponse;", "Landroid/app/appfunctions/AppFunctionException;", IntrospectionHelper.AppFunctionServiceClass.ExecuteFunctionMethod.METHOD_NAME, "Landroidx/appfunctions/ExecuteAppFunctionResponse;", "Landroidx/appfunctions/ExecuteAppFunctionRequest;", "(Landroidx/appfunctions/ExecuteAppFunctionRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDestroy", "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AppFunctionService extends android.app.appfunctions.AppFunctionService {
    private final CoroutineScope workerCoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.INSTANCE.getWorker());

    public abstract Object executeFunction(ExecuteAppFunctionRequest executeAppFunctionRequest, Continuation<? super ExecuteAppFunctionResponse> continuation);

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        CoroutineScopeKt.cancel$default(this.workerCoroutineScope, null, 1, null);
    }

    public final void onExecuteFunction(android.app.appfunctions.ExecuteAppFunctionRequest request, String callingPackage, SigningInfo signingInfo, CancellationSignal cancellationSignal, OutcomeReceiver callback) {
        request.getClass();
        callingPackage.getClass();
        signingInfo.getClass();
        cancellationSignal.getClass();
        callback.getClass();
        cancellationSignal.setOnCancelListener(new AppFunctionService$$ExternalSyntheticLambda0(BuildersKt__Builders_commonKt.launch$default(this.workerCoroutineScope, null, null, new AppFunctionService$onExecuteFunction$functionExecutionJob$1(this, request, callingPackage, callback, null), 3, null), 0));
    }
}
