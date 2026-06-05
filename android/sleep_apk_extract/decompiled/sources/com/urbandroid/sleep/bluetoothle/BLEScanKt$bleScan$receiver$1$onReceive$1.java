package com.urbandroid.sleep.bluetoothle;

import android.bluetooth.BluetoothDevice;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.SendChannel;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.urbandroid.sleep.bluetoothle.BLEScanKt$bleScan$receiver$1$onReceive$1", f = "BLEScan.kt", l = {60}, m = "invokeSuspend", v = 2)
public final class BLEScanKt$bleScan$receiver$1$onReceive$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Channel<BluetoothDevice> $channel;
    final /* synthetic */ BluetoothDevice $device;
    int I$0;
    Object L$0;
    int label;
    final /* synthetic */ BLEScanKt$bleScan$receiver$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BLEScanKt$bleScan$receiver$1$onReceive$1(BluetoothDevice bluetoothDevice, BLEScanKt$bleScan$receiver$1 bLEScanKt$bleScan$receiver$1, Channel<BluetoothDevice> channel, Continuation<? super BLEScanKt$bleScan$receiver$1$onReceive$1> continuation) {
        super(2, continuation);
        this.$device = bluetoothDevice;
        this.this$0 = bLEScanKt$bleScan$receiver$1;
        this.$channel = channel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BLEScanKt$bleScan$receiver$1$onReceive$1(this.$device, this.this$0, this.$channel, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BLEScanKt$bleScan$receiver$1$onReceive$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v8 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                BluetoothDevice bluetoothDevice = this.$device;
                this = this;
                if (bluetoothDevice != null) {
                    Channel<BluetoothDevice> channel = this.$channel;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(bluetoothDevice);
                    this.I$0 = 0;
                    this.label = 1;
                    Object objSend = channel.send(bluetoothDevice, this);
                    this = objSend;
                    if (objSend == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                this = this;
            }
        } catch (Exception e) {
            BLEScanKt.logMinorFailure(e);
            this.this$0.shutdown();
            SendChannel.close$default(this.$channel, null, 1, null);
        }
        return Unit.INSTANCE;
    }
}
