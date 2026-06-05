package com.urbandroid.sleep.service.google.fit.api;

import com.google.android.gms.fitness.HistoryClient;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.service.health.ResultStatus;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "<anonymous>"}, k = 3, mv = {2, 3, 0})
@DebugMetadata(c = "com.urbandroid.sleep.service.google.fit.api.GoogleFitApi$deleteData$1$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1", f = "GoogleFitApi.kt", l = {177}, m = "invokeSuspend", v = 2)
public final class GoogleFitApi$deleteData$1$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ResultStatus>, Object> {
    final /* synthetic */ DataDeleteRequest $request$inlined;
    final /* synthetic */ HistoryClient $this_deleteData$inlined;
    int I$0;
    int label;
    final /* synthetic */ GoogleFitApi this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoogleFitApi$deleteData$1$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1(Continuation continuation, HistoryClient historyClient, DataDeleteRequest dataDeleteRequest, GoogleFitApi googleFitApi) {
        super(2, continuation);
        this.$this_deleteData$inlined = historyClient;
        this.$request$inlined = dataDeleteRequest;
        this.this$0 = googleFitApi;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GoogleFitApi$deleteData$1$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1(continuation, this.$this_deleteData$inlined, this.$request$inlined, this.this$0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ResultStatus> continuation) {
        return ((GoogleFitApi$deleteData$1$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
        this.I$0 = 0;
        this.label = 1;
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(this), 1);
        cancellableContinuationImpl.initCancellability();
        Task<Void> taskAddOnSuccessListener = this.$this_deleteData$inlined.deleteData(this.$request$inlined).addOnSuccessListener(new GoogleFitApi$sam$com_google_android_gms_tasks_OnSuccessListener$0(new Function1<Void, Unit>() { // from class: com.urbandroid.sleep.service.google.fit.api.GoogleFitApi$deleteData$1$1$1
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Void r1) {
                Continuation<ResultStatus> continuation = cancellableContinuationImpl;
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m2357constructorimpl(ResultStatus.SUCCESS));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                invoke2(r1);
                return Unit.INSTANCE;
            }
        }));
        final GoogleFitApi googleFitApi = this.this$0;
        taskAddOnSuccessListener.addOnFailureListener(new OnFailureListener() { // from class: com.urbandroid.sleep.service.google.fit.api.GoogleFitApi$deleteData$1$1$2
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                exc.getClass();
                Logger.logWarning(Logger.defaultTag, zza$$ExternalSyntheticOutline0.m(googleFitApi, new StringBuilder(), ": ", "HistoryClient.deleteData failure: " + exc), null);
                Continuation<ResultStatus> continuation = cancellableContinuationImpl;
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m2357constructorimpl(ResultStatus.FAILURE));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(this);
        }
        return result == coroutine_suspended ? coroutine_suspended : result;
    }
}
