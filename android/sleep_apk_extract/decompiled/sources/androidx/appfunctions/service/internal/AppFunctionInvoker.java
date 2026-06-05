package androidx.appfunctions.service.internal;

import androidx.appfunctions.AppFunctionContext;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J6\u0010\u0007\u001a\u0004\u0018\u00010\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fH¦@¢\u0006\u0002\u0010\rR\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Landroidx/appfunctions/service/internal/AppFunctionInvoker;", "", IntrospectionHelper.AppFunctionInvokerClass.SUPPORTED_FUNCTION_IDS_PROPERTY_NAME, "", "", "getSupportedFunctionIds", "()Ljava/util/Set;", IntrospectionHelper.AppFunctionInvokerClass.UnsafeInvokeMethod.METHOD_NAME, IntrospectionHelper.AppFunctionInvokerClass.UnsafeInvokeMethod.APPLICATION_CONTEXT_PARAM_NAME, "Landroidx/appfunctions/AppFunctionContext;", IntrospectionHelper.AppFunctionInvokerClass.UnsafeInvokeMethod.FUNCTION_ID_PARAM_NAME, IntrospectionHelper.AppFunctionInvokerClass.UnsafeInvokeMethod.PARAMETERS_PARAM_NAME, "", "(Landroidx/appfunctions/AppFunctionContext;Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "appfunctions-service"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface AppFunctionInvoker {
    Set<String> getSupportedFunctionIds();

    Object unsafeInvoke(AppFunctionContext appFunctionContext, String str, Map<String, ? extends Object> map, Continuation<Object> continuation);
}
