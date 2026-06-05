package com.urbandroid.sleep.hr;

import android.widget.ArrayAdapter;
import com.urbandroid.sleep.gui.dialog.DialogItem;
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

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.urbandroid.sleep.hr.BleDeviceLookupDialogFragment$createDialog$1$2$2$1", f = "BleDeviceLookupDialogFragment.kt", l = {}, m = "invokeSuspend", v = 2)
public final class BleDeviceLookupDialogFragment$createDialog$1$2$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ArrayAdapter<DialogItem> $arrayAdapter;
    final /* synthetic */ DeviceDetectionResult $deviceInfo;
    int label;
    final /* synthetic */ BleDeviceLookupDialogFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BleDeviceLookupDialogFragment$createDialog$1$2$2$1(BleDeviceLookupDialogFragment bleDeviceLookupDialogFragment, DeviceDetectionResult deviceDetectionResult, ArrayAdapter<DialogItem> arrayAdapter, Continuation<? super BleDeviceLookupDialogFragment$createDialog$1$2$2$1> continuation) {
        super(2, continuation);
        this.this$0 = bleDeviceLookupDialogFragment;
        this.$deviceInfo = deviceDetectionResult;
        this.$arrayAdapter = arrayAdapter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BleDeviceLookupDialogFragment$createDialog$1$2$2$1(this.this$0, this.$deviceInfo, this.$arrayAdapter, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BleDeviceLookupDialogFragment$createDialog$1$2$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(obj);
        this.this$0.highlightRecognizedDevice(this.$deviceInfo.getDevice(), this.$arrayAdapter);
        return Unit.INSTANCE;
    }
}
