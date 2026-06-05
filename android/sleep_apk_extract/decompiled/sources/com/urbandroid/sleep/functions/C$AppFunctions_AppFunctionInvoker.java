package com.urbandroid.sleep.functions;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.appfunctions.AppFunctionContext;
import androidx.appfunctions.AppFunctionFunctionNotFoundException;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.appfunctions.service.internal.AppFunctionInvoker;
import androidx.appfunctions.service.internal.ConfigurableAppFunctionFactory;
import io.ktor.client.HttpClientConfig$$ExternalSyntheticLambda4;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.urbandroid.sleep.functions.$AppFunctions_AppFunctionInvoker, reason: invalid class name */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\n0\u000fH\u0096@¢\u0006\u0002\u0010\u0010R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"com/urbandroid/sleep/functions/$AppFunctions_AppFunctionInvoker", "Landroidx/appfunctions/service/internal/AppFunctionInvoker;", "<init>", "()V", IntrospectionHelper.AppFunctionInvokerClass.SUPPORTED_FUNCTION_IDS_PROPERTY_NAME, "", "", "getSupportedFunctionIds", "()Ljava/util/Set;", IntrospectionHelper.AppFunctionInvokerClass.UnsafeInvokeMethod.METHOD_NAME, "", IntrospectionHelper.AppFunctionInvokerClass.UnsafeInvokeMethod.APPLICATION_CONTEXT_PARAM_NAME, "Landroidx/appfunctions/AppFunctionContext;", IntrospectionHelper.AppFunctionInvokerClass.UnsafeInvokeMethod.FUNCTION_ID_PARAM_NAME, IntrospectionHelper.AppFunctionInvokerClass.UnsafeInvokeMethod.PARAMETERS_PARAM_NAME, "", "(Landroidx/appfunctions/AppFunctionContext;Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class C$AppFunctions_AppFunctionInvoker implements AppFunctionInvoker {
    private final Set<String> supportedFunctionIds = SetsKt.setOf((Object[]) new String[]{"com.urbandroid.sleep.functions.AppFunctions#createAlarm", "com.urbandroid.sleep.functions.AppFunctions#startSleepTracking"});

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppFunctions unsafeInvoke$lambda$0() {
        return new AppFunctions();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppFunctions unsafeInvoke$lambda$1() {
        return new AppFunctions();
    }

    @Override // androidx.appfunctions.service.internal.AppFunctionInvoker
    public Set<String> getSupportedFunctionIds() {
        return this.supportedFunctionIds;
    }

    @Override // androidx.appfunctions.service.internal.AppFunctionInvoker
    public Object unsafeInvoke(AppFunctionContext appFunctionContext, String str, Map<String, ? extends Object> map, Continuation<Object> continuation) throws AppFunctionFunctionNotFoundException {
        if (!Intrinsics.areEqual(str, "com.urbandroid.sleep.functions.AppFunctions#createAlarm")) {
            if (Intrinsics.areEqual(str, "com.urbandroid.sleep.functions.AppFunctions#startSleepTracking")) {
                return ((AppFunctions) new ConfigurableAppFunctionFactory(appFunctionContext.getContext(), new HttpClientConfig$$ExternalSyntheticLambda4(3)).createEnclosingClass(AppFunctions.class)).startSleepTracking(appFunctionContext);
            }
            throw new AppFunctionFunctionNotFoundException(FileInsert$$ExternalSyntheticOutline0.m("Unable to find ", str));
        }
        AppFunctions appFunctions = (AppFunctions) new ConfigurableAppFunctionFactory(appFunctionContext.getContext(), new HttpClientConfig$$ExternalSyntheticLambda4(2)).createEnclosingClass(AppFunctions.class);
        Object obj = map.get("hour");
        obj.getClass();
        int iIntValue = ((Integer) obj).intValue();
        Object obj2 = map.get("minute");
        obj2.getClass();
        return appFunctions.createAlarm(appFunctionContext, iIntValue, ((Integer) obj2).intValue());
    }
}
