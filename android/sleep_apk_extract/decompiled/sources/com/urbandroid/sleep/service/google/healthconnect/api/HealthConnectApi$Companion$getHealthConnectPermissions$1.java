package com.urbandroid.sleep.service.google.healthconnect.api;

import androidx.health.connect.client.HealthConnectClient;
import androidx.health.connect.client.PermissionController;
import com.urbandroid.common.logging.Logger;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.urbandroid.sleep.service.google.healthconnect.api.HealthConnectApi$Companion$getHealthConnectPermissions$1", f = "HealthConnectApi.kt", l = {416}, m = "invokeSuspend", v = 2)
public final class HealthConnectApi$Companion$getHealthConnectPermissions$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Set<? extends String>>, Object> {
    final /* synthetic */ HealthConnectClient $healthConnectClient;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HealthConnectApi$Companion$getHealthConnectPermissions$1(HealthConnectClient healthConnectClient, Continuation<? super HealthConnectApi$Companion$getHealthConnectPermissions$1> continuation) {
        super(2, continuation);
        this.$healthConnectClient = healthConnectClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HealthConnectApi$Companion$getHealthConnectPermissions$1(this.$healthConnectClient, continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Set<String>> continuation) {
        return ((HealthConnectApi$Companion$getHealthConnectPermissions$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            PermissionController permissionController = this.$healthConnectClient.getPermissionController();
            this.label = 1;
            Object grantedPermissions = permissionController.getGrantedPermissions(this);
            return grantedPermissions == coroutine_suspended ? coroutine_suspended : grantedPermissions;
        } catch (Exception e) {
            Logger.logSevere(null, e);
            return SetsKt.emptySet();
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Set<? extends String>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Set<String>>) continuation);
    }
}
