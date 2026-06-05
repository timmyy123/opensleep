package com.urbandroid.sleep.bluetoothle;

import android.bluetooth.BluetoothGattCharacteristic;
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

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.urbandroid.sleep.bluetoothle.BLEClient$writeAndCollectNotifications$2$1", f = "BLEClient.kt", l = {366}, m = "invokeSuspend", v = 2)
public final class BLEClient$writeAndCollectNotifications$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ byte[] $bytes;
    final /* synthetic */ BluetoothGattCharacteristic $characteristic;
    final /* synthetic */ long $timeoutMillis;
    int label;
    final /* synthetic */ BLEClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BLEClient$writeAndCollectNotifications$2$1(BLEClient bLEClient, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, long j, Continuation<? super BLEClient$writeAndCollectNotifications$2$1> continuation) {
        super(2, continuation);
        this.this$0 = bLEClient;
        this.$characteristic = bluetoothGattCharacteristic;
        this.$bytes = bArr;
        this.$timeoutMillis = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BLEClient$writeAndCollectNotifications$2$1(this.this$0, this.$characteristic, this.$bytes, this.$timeoutMillis, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BLEClient$writeAndCollectNotifications$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            BLEClient bLEClient = this.this$0;
            BluetoothGattCharacteristic bluetoothGattCharacteristic = this.$characteristic;
            byte[] bArr = this.$bytes;
            long j = this.$timeoutMillis;
            this.label = 1;
            if (bLEClient.write(bluetoothGattCharacteristic, bArr, j, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
