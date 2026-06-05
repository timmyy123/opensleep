package com.urbandroid.sleep.hr;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.gui.dialog.DialogItem;
import com.urbandroid.sleep.hr.BleDeviceLookupDialogFragment;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.urbandroid.sleep.hr.BleDeviceLookupDialogFragment$createDialog$1$2", f = "BleDeviceLookupDialogFragment.kt", l = {108}, m = "invokeSuspend", v = 2)
public final class BleDeviceLookupDialogFragment$createDialog$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ArrayAdapter<DialogItem> $arrayAdapter;
    final /* synthetic */ Context $context;
    final /* synthetic */ View $dialogView;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BleDeviceLookupDialogFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BleDeviceLookupDialogFragment$createDialog$1$2(Context context, BleDeviceLookupDialogFragment bleDeviceLookupDialogFragment, ArrayAdapter<DialogItem> arrayAdapter, View view, Continuation<? super BleDeviceLookupDialogFragment$createDialog$1$2> continuation) {
        super(2, continuation);
        this.$context = context;
        this.this$0 = bleDeviceLookupDialogFragment;
        this.$arrayAdapter = arrayAdapter;
        this.$dialogView = view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(CoroutineScope coroutineScope, BleDeviceLookupDialogFragment bleDeviceLookupDialogFragment, ArrayAdapter arrayAdapter, BluetoothDevice bluetoothDevice) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new BleDeviceLookupDialogFragment$createDialog$1$2$1$1(bleDeviceLookupDialogFragment, bluetoothDevice, arrayAdapter, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$1(CoroutineScope coroutineScope, BleDeviceLookupDialogFragment bleDeviceLookupDialogFragment, ArrayAdapter arrayAdapter, DeviceDetectionResult deviceDetectionResult) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new BleDeviceLookupDialogFragment$createDialog$1$2$2$1(bleDeviceLookupDialogFragment, deviceDetectionResult, arrayAdapter, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$2(CoroutineScope coroutineScope, BleDeviceLookupDialogFragment bleDeviceLookupDialogFragment, Context context, View view) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new BleDeviceLookupDialogFragment$createDialog$1$2$3$1(bleDeviceLookupDialogFragment, context, view, null), 3, null);
        return Unit.INSTANCE;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BleDeviceLookupDialogFragment$createDialog$1$2 bleDeviceLookupDialogFragment$createDialog$1$2 = new BleDeviceLookupDialogFragment$createDialog$1$2(this.$context, this.this$0, this.$arrayAdapter, this.$dialogView, continuation);
        bleDeviceLookupDialogFragment$createDialog$1$2.L$0 = obj;
        return bleDeviceLookupDialogFragment$createDialog$1$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BleDeviceLookupDialogFragment$createDialog$1$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Exception exc;
        BleDeviceLookupDialogFragment$createDialog$1$2 bleDeviceLookupDialogFragment$createDialog$1$2;
        Context context;
        Function3<Context, BluetoothDevice, Continuation<? super DeviceDetectionResult>, Object> detectDevice;
        Function1 function1;
        Function1 function12;
        Function0 function0;
        final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        final int i2 = 1;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                try {
                    context = this.$context;
                    BleDeviceLookupDialogFragment.Mode mode = this.this$0.mode;
                    if (mode == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mode");
                        mode = null;
                    }
                    detectDevice = mode.getDetectDevice();
                    final BleDeviceLookupDialogFragment bleDeviceLookupDialogFragment = this.this$0;
                    final ArrayAdapter<DialogItem> arrayAdapter = this.$arrayAdapter;
                    final int i3 = 0;
                    function1 = new Function1() { // from class: com.urbandroid.sleep.hr.BleDeviceLookupDialogFragment$createDialog$1$2$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            switch (i3) {
                                case 0:
                                    return BleDeviceLookupDialogFragment$createDialog$1$2.invokeSuspend$lambda$0(coroutineScope, bleDeviceLookupDialogFragment, arrayAdapter, (BluetoothDevice) obj2);
                                default:
                                    return BleDeviceLookupDialogFragment$createDialog$1$2.invokeSuspend$lambda$1(coroutineScope, bleDeviceLookupDialogFragment, arrayAdapter, (DeviceDetectionResult) obj2);
                            }
                        }
                    };
                    function12 = new Function1() { // from class: com.urbandroid.sleep.hr.BleDeviceLookupDialogFragment$createDialog$1$2$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            switch (i2) {
                                case 0:
                                    return BleDeviceLookupDialogFragment$createDialog$1$2.invokeSuspend$lambda$0(coroutineScope, bleDeviceLookupDialogFragment, arrayAdapter, (BluetoothDevice) obj2);
                                default:
                                    return BleDeviceLookupDialogFragment$createDialog$1$2.invokeSuspend$lambda$1(coroutineScope, bleDeviceLookupDialogFragment, arrayAdapter, (DeviceDetectionResult) obj2);
                            }
                        }
                    };
                    final Context context2 = this.$context;
                    final View view = this.$dialogView;
                    function0 = new Function0() { // from class: com.urbandroid.sleep.hr.BleDeviceLookupDialogFragment$createDialog$1$2$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BleDeviceLookupDialogFragment$createDialog$1$2.invokeSuspend$lambda$2(coroutineScope, bleDeviceLookupDialogFragment, context2, view);
                        }
                    };
                    this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                    this.label = 1;
                    bleDeviceLookupDialogFragment$createDialog$1$2 = this;
                } catch (Exception e) {
                    e = e;
                    bleDeviceLookupDialogFragment$createDialog$1$2 = this;
                }
                try {
                    if (SmartScanKt.smartScan2$default(coroutineScope, context, detectDevice, function1, function12, null, function0, bleDeviceLookupDialogFragment$createDialog$1$2, 16, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } catch (Exception e2) {
                    e = e2;
                    exc = e;
                    Logger.logInfo(Fragment$$ExternalSyntheticOutline1.m(bleDeviceLookupDialogFragment$createDialog$1$2.this$0.logPrefix, " scan ", exc.getClass().getName(), " ", exc.getMessage()), null);
                    try {
                        bleDeviceLookupDialogFragment$createDialog$1$2.this$0.dismiss();
                    } catch (Exception unused) {
                    }
                }
            } else {
                if (i != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
        } catch (Exception e3) {
            exc = e3;
            bleDeviceLookupDialogFragment$createDialog$1$2 = this;
        }
        return Unit.INSTANCE;
    }
}
