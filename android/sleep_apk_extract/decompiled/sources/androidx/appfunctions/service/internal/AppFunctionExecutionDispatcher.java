package androidx.appfunctions.service.internal;

import androidx.appfunctions.AppFunctionAppUnknownException;
import androidx.appfunctions.AppFunctionCancelledException;
import androidx.appfunctions.AppFunctionException;
import androidx.appfunctions.AppFunctionFunctionNotFoundException;
import androidx.appfunctions.ExecuteAppFunctionRequest;
import androidx.appfunctions.ExecuteAppFunctionResponse;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.appfunctions.internal.AggregatedAppFunctionInventory;
import androidx.appfunctions.internal.Dependencies;
import androidx.appfunctions.metadata.AppFunctionComponentsMetadata;
import androidx.appfunctions.metadata.AppFunctionParameterMetadata;
import androidx.appfunctions.metadata.AppFunctionResponseMetadata;
import androidx.appfunctions.metadata.CompileTimeAppFunctionMetadata;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JJ\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000722\u0010\b\u001a.\b\u0001\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tH\u0086@¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/appfunctions/service/internal/AppFunctionExecutionDispatcher;", "", "<init>", "()V", IntrospectionHelper.AppFunctionExecutionDispatcherClass.ExecuteAppFunctionMethod.METHOD_NAME, "Landroidx/appfunctions/ExecuteAppFunctionResponse;", "request", "Landroidx/appfunctions/ExecuteAppFunctionRequest;", "block", "Lkotlin/Function2;", "", "", "Lkotlin/coroutines/Continuation;", "(Landroidx/appfunctions/ExecuteAppFunctionRequest;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "appfunctions-service"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppFunctionExecutionDispatcher {
    public static final AppFunctionExecutionDispatcher INSTANCE = new AppFunctionExecutionDispatcher();

    /* JADX INFO: renamed from: androidx.appfunctions.service.internal.AppFunctionExecutionDispatcher$executeAppFunction$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.appfunctions.service.internal.AppFunctionExecutionDispatcher", f = "AppFunctionExecutionDispatcher.kt", l = {69}, m = IntrospectionHelper.AppFunctionExecutionDispatcherClass.ExecuteAppFunctionMethod.METHOD_NAME, v = 1)
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
            return AppFunctionExecutionDispatcher.this.executeAppFunction(null, null, this);
        }
    }

    private AppFunctionExecutionDispatcher() {
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object executeAppFunction(ExecuteAppFunctionRequest executeAppFunctionRequest, Function2<? super Map<String, ? extends Object>, ? super Continuation<Object>, ? extends Object> function2, Continuation<? super ExecuteAppFunctionResponse> continuation) throws AppFunctionException {
        AnonymousClass1 anonymousClass1;
        AggregatedAppFunctionInventory aggregatedAppFunctionInventory;
        CompileTimeAppFunctionMetadata compileTimeAppFunctionMetadata;
        Map<String, CompileTimeAppFunctionMetadata> functionIdToMetadataMap;
        AppFunctionComponentsMetadata appFunctionComponentsMetadata;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        CompileTimeAppFunctionMetadata compileTimeAppFunctionMetadata2 = null;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                AggregatedAppFunctionInventory aggregatedAppFunctionInventory2 = Dependencies.INSTANCE.getAggregatedAppFunctionInventory();
                if (aggregatedAppFunctionInventory2 != null && (functionIdToMetadataMap = aggregatedAppFunctionInventory2.getFunctionIdToMetadataMap()) != null) {
                    compileTimeAppFunctionMetadata2 = functionIdToMetadataMap.get(executeAppFunctionRequest.getFunctionIdentifier());
                }
                if (compileTimeAppFunctionMetadata2 == null) {
                    throw new AppFunctionFunctionNotFoundException(executeAppFunctionRequest.getFunctionIdentifier() + " is not available");
                }
                Map mapCreateMapBuilder = MapsKt.createMapBuilder();
                for (AppFunctionParameterMetadata appFunctionParameterMetadata : compileTimeAppFunctionMetadata2.getParameters()) {
                    mapCreateMapBuilder.put(appFunctionParameterMetadata.getName(), AppFunctionDataParameterExtractorKt.unsafeGetParameterValue(executeAppFunctionRequest.getFunctionParameters(), appFunctionParameterMetadata));
                }
                Map mapBuild = MapsKt.build(mapCreateMapBuilder);
                anonymousClass1.L$0 = aggregatedAppFunctionInventory2;
                anonymousClass1.L$1 = compileTimeAppFunctionMetadata2;
                anonymousClass1.label = 1;
                Object objInvoke = function2.invoke(mapBuild, anonymousClass1);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                aggregatedAppFunctionInventory = aggregatedAppFunctionInventory2;
                obj = objInvoke;
                compileTimeAppFunctionMetadata = compileTimeAppFunctionMetadata2;
            } else {
                if (i2 != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                compileTimeAppFunctionMetadata = (CompileTimeAppFunctionMetadata) anonymousClass1.L$1;
                aggregatedAppFunctionInventory = (AggregatedAppFunctionInventory) anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj);
            }
            AppFunctionResponseMetadata response = compileTimeAppFunctionMetadata.getResponse();
            if (aggregatedAppFunctionInventory == null || (appFunctionComponentsMetadata = aggregatedAppFunctionInventory.getComponentsMetadata()) == null) {
                appFunctionComponentsMetadata = new AppFunctionComponentsMetadata(MapsKt.emptyMap());
            }
            return new ExecuteAppFunctionResponse.Success(AppFunctionResponseMetadataReturnValueBuilderKt.unsafeBuildReturnValue(response, obj, appFunctionComponentsMetadata));
        } catch (AppFunctionException e) {
            throw e;
        } catch (CancellationException e2) {
            throw new AppFunctionCancelledException(e2.getMessage());
        } catch (Exception e3) {
            throw new AppFunctionAppUnknownException(e3.getMessage());
        }
    }
}
