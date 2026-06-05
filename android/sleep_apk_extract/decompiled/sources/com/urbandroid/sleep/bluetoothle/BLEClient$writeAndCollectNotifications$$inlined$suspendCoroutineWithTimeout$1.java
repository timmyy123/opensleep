package com.urbandroid.sleep.bluetoothle;

import android.bluetooth.BluetoothGattCharacteristic;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlinx.coroutines.BuildersKt__Builders_concurrentKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "<anonymous>"}, k = 3, mv = {2, 3, 0})
@DebugMetadata(c = "com.urbandroid.sleep.bluetoothle.BLEClient$writeAndCollectNotifications$$inlined$suspendCoroutineWithTimeout$1", f = "BLEClient.kt", l = {177}, m = "invokeSuspend", v = 2)
public final class BLEClient$writeAndCollectNotifications$$inlined$suspendCoroutineWithTimeout$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Void>, Object> {
    final /* synthetic */ byte[] $bytes$inlined;
    final /* synthetic */ BluetoothGattCharacteristic $characteristic$inlined;
    final /* synthetic */ DataConsumer $consumer$inlined;
    final /* synthetic */ long $timeoutMillis$inlined;
    final /* synthetic */ Ref$BooleanRef $writeSucceeded$inlined;
    int I$0;
    int label;
    final /* synthetic */ BLEClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BLEClient$writeAndCollectNotifications$$inlined$suspendCoroutineWithTimeout$1(Continuation continuation, BLEClient bLEClient, DataConsumer dataConsumer, BluetoothGattCharacteristic bluetoothGattCharacteristic, Ref$BooleanRef ref$BooleanRef, byte[] bArr, long j) {
        super(2, continuation);
        this.this$0 = bLEClient;
        this.$consumer$inlined = dataConsumer;
        this.$characteristic$inlined = bluetoothGattCharacteristic;
        this.$writeSucceeded$inlined = ref$BooleanRef;
        this.$bytes$inlined = bArr;
        this.$timeoutMillis$inlined = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BLEClient$writeAndCollectNotifications$$inlined$suspendCoroutineWithTimeout$1(continuation, this.this$0, this.$consumer$inlined, this.$characteristic$inlined, this.$writeSucceeded$inlined, this.$bytes$inlined, this.$timeoutMillis$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Void> continuation) {
        return ((BLEClient$writeAndCollectNotifications$$inlined$suspendCoroutineWithTimeout$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(this), 1);
        cancellableContinuationImpl.initCancellability();
        this.this$0.gattCallback.setExpectedNotificationsConsumer(this.$consumer$inlined);
        this.this$0.gattCallback.setExpectedNotificationsCharacteristic(this.$characteristic$inlined);
        this.this$0.gattCallback.setExpectedNotificationsContinuation(cancellableContinuationImpl);
        try {
            BuildersKt__Builders_concurrentKt.runBlockingK$default(null, new BLEClient$writeAndCollectNotifications$2$1(this.this$0, this.$characteristic$inlined, this.$bytes$inlined, this.$timeoutMillis$inlined, null), 1, null);
            this.$writeSucceeded$inlined.element = true;
        } catch (BluetoothException e) {
            try {
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuationImpl.resumeWith(Result.m2357constructorimpl(ResultKt.createFailure(e)));
            } catch (IllegalStateException e2) {
                this.this$0.bleLogger.major("", e2);
                throw e;
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(this);
        }
        return result == coroutine_suspended ? coroutine_suspended : result;
    }
}
