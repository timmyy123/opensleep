package com.urbandroid.sleep.service.google.healthconnect;

import androidx.health.connect.client.HealthConnectClient;
import com.urbandroid.sleep.service.google.healthconnect.api.HealthConnectApi;
import java.util.Set;
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

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.urbandroid.sleep.service.google.healthconnect.HealthConnectSyncActivity$onResume$1$permissions$1", f = "HealthConnectSyncActivity.kt", l = {}, m = "invokeSuspend", v = 2)
public final class HealthConnectSyncActivity$onResume$1$permissions$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Set<? extends String>>, Object> {
    int label;
    final /* synthetic */ HealthConnectSyncActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HealthConnectSyncActivity$onResume$1$permissions$1(HealthConnectSyncActivity healthConnectSyncActivity, Continuation<? super HealthConnectSyncActivity$onResume$1$permissions$1> continuation) {
        super(2, continuation);
        this.this$0 = healthConnectSyncActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HealthConnectSyncActivity$onResume$1$permissions$1(this.this$0, continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Set<String>> continuation) {
        return ((HealthConnectSyncActivity$onResume$1$permissions$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return HealthConnectApi.INSTANCE.getHealthConnectPermissions(HealthConnectClient.Companion.getOrCreate$default(HealthConnectClient.INSTANCE, this.this$0, null, 2, null));
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
        return null;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Set<? extends String>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Set<String>>) continuation);
    }
}
