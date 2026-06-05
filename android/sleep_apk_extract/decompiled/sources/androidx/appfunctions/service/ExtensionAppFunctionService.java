package androidx.appfunctions.service;

import android.content.Context;
import androidx.appfunctions.AppFunctionAppUnknownException;
import androidx.appfunctions.AppFunctionException;
import androidx.appfunctions.ExecuteAppFunctionRequest;
import androidx.appfunctions.ExecuteAppFunctionResponse;
import androidx.appfunctions.ExtensionsAppFunctionService;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.appfunctions.internal.AggregatedAppFunctionInventory;
import androidx.appfunctions.internal.Dependencies;
import androidx.appfunctions.internal.Dispatchers;
import androidx.appfunctions.service.internal.ServiceDependencies;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/appfunctions/service/ExtensionAppFunctionService;", "Landroidx/appfunctions/ExtensionsAppFunctionService;", "<init>", "()V", "delegate", "Landroidx/appfunctions/service/AppFunctionServiceDelegate;", "onCreate", "", IntrospectionHelper.AppFunctionServiceClass.ExecuteFunctionMethod.METHOD_NAME, "Landroidx/appfunctions/ExecuteAppFunctionResponse;", "request", "Landroidx/appfunctions/ExecuteAppFunctionRequest;", "(Landroidx/appfunctions/ExecuteAppFunctionRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "appfunctions-service"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExtensionAppFunctionService extends ExtensionsAppFunctionService {
    private AppFunctionServiceDelegate delegate;

    /* JADX INFO: renamed from: androidx.appfunctions.service.ExtensionAppFunctionService$executeFunction$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.appfunctions.service.ExtensionAppFunctionService", f = "ExtensionAppFunctionService.kt", l = {54}, m = IntrospectionHelper.AppFunctionServiceClass.ExecuteFunctionMethod.METHOD_NAME, v = 1)
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ExtensionAppFunctionService.this.executeFunction(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.appfunctions.ExtensionsAppFunctionService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object executeFunction(ExecuteAppFunctionRequest executeAppFunctionRequest, Continuation<? super ExecuteAppFunctionResponse> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object objExecuteFunction = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        AppFunctionServiceDelegate appFunctionServiceDelegate = null;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objExecuteFunction);
                AppFunctionServiceDelegate appFunctionServiceDelegate2 = this.delegate;
                if (appFunctionServiceDelegate2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("delegate");
                } else {
                    appFunctionServiceDelegate = appFunctionServiceDelegate2;
                }
                anonymousClass1.label = 1;
                objExecuteFunction = appFunctionServiceDelegate.executeFunction(executeAppFunctionRequest, anonymousClass1);
                if (objExecuteFunction == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(objExecuteFunction);
            }
            return (ExecuteAppFunctionResponse) objExecuteFunction;
        } catch (AppFunctionException e) {
            return new ExecuteAppFunctionResponse.Error(e);
        } catch (Exception e2) {
            return new ExecuteAppFunctionResponse.Error(new AppFunctionAppUnknownException(e2.getMessage()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate() {
        super.onCreate();
        Context context = (Context) this;
        CoroutineDispatcher main = Dispatchers.INSTANCE.getMain();
        Dependencies dependencies = Dependencies.INSTANCE;
        AggregatedAppFunctionInventory aggregatedAppFunctionInventory = dependencies.getAggregatedAppFunctionInventory();
        if (aggregatedAppFunctionInventory != null) {
            this.delegate = new AppFunctionServiceDelegate(context, main, aggregatedAppFunctionInventory, ServiceDependencies.INSTANCE.getAggregatedAppFunctionInvoker$appfunctions_service(), dependencies.getTranslatorSelector());
        } else {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Required value was null.");
        }
    }
}
