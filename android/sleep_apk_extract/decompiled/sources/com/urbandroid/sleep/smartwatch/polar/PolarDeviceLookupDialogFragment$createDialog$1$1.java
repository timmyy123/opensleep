package com.urbandroid.sleep.smartwatch.polar;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.widget.ArrayAdapter;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.polar.sdk.api.PolarBleApi;
import com.polar.sdk.api.PolarBleApiDefaultImpl;
import com.polar.sdk.api.model.PolarDeviceInfo;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.gui.dialog.DialogItem;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Consumer;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.urbandroid.sleep.smartwatch.polar.PolarDeviceLookupDialogFragment$createDialog$1$1", f = "PolarDeviceLookupDialogFragment.kt", l = {}, m = "invokeSuspend", v = 2)
public final class PolarDeviceLookupDialogFragment$createDialog$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ArrayAdapter<DialogItem> $arrayAdapter;
    final /* synthetic */ Context $context;
    int label;
    final /* synthetic */ PolarDeviceLookupDialogFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolarDeviceLookupDialogFragment$createDialog$1$1(PolarDeviceLookupDialogFragment polarDeviceLookupDialogFragment, Context context, ArrayAdapter<DialogItem> arrayAdapter, Continuation<? super PolarDeviceLookupDialogFragment$createDialog$1$1> continuation) {
        super(2, continuation);
        this.this$0 = polarDeviceLookupDialogFragment;
        this.$context = context;
        this.$arrayAdapter = arrayAdapter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PolarDeviceLookupDialogFragment$createDialog$1$1(this.this$0, this.$context, this.$arrayAdapter, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PolarDeviceLookupDialogFragment$createDialog$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(obj);
        try {
            this.this$0.setApi(PolarBleApiDefaultImpl.defaultImplementation(this.$context, SetsKt.setOf(PolarBleApi.PolarBleSdkFeature.FEATURE_DEVICE_INFO)));
            PolarBleApi api = this.this$0.getApi();
            if (api != null) {
                final PolarDeviceLookupDialogFragment polarDeviceLookupDialogFragment = this.this$0;
                final ArrayAdapter<DialogItem> arrayAdapter = this.$arrayAdapter;
                api.searchForDevice().observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() { // from class: com.urbandroid.sleep.smartwatch.polar.PolarDeviceLookupDialogFragment$createDialog$1$1$1$1
                    @Override // io.reactivex.rxjava3.functions.Consumer
                    public final void accept(PolarDeviceInfo polarDeviceInfo) {
                        polarDeviceInfo.getClass();
                        String deviceId = polarDeviceInfo.getDeviceId();
                        String address = polarDeviceInfo.getAddress();
                        int rssi = polarDeviceInfo.getRssi();
                        String name = polarDeviceInfo.getName();
                        boolean isConnectable = polarDeviceInfo.getIsConnectable();
                        StringBuilder sbM6m = FileInsert$$ExternalSyntheticOutline0.m6m("Polar: device found id: ", deviceId, " address: ", address, " rssi: ");
                        sbM6m.append(rssi);
                        sbM6m.append(" name: ");
                        sbM6m.append(name);
                        sbM6m.append(" isConnectable: ");
                        sbM6m.append(isConnectable);
                        Logger.logInfo(sbM6m.toString());
                        if (polarDeviceInfo.getIsConnectable()) {
                            String deviceId2 = polarDeviceInfo.getDeviceId();
                            String address2 = polarDeviceInfo.getAddress();
                            int rssi2 = polarDeviceInfo.getRssi();
                            String name2 = polarDeviceInfo.getName();
                            boolean isConnectable2 = polarDeviceInfo.getIsConnectable();
                            StringBuilder sbM6m2 = FileInsert$$ExternalSyntheticOutline0.m6m("Polar: connect() ", deviceId2, " address: ", address2, " rssi: ");
                            sbM6m2.append(rssi2);
                            sbM6m2.append(" name: ");
                            sbM6m2.append(name2);
                            sbM6m2.append(" isConnectable: ");
                            zza$$ExternalSyntheticOutline0.m(sbM6m2, isConnectable2);
                            polarDeviceLookupDialogFragment.addDevice(polarDeviceInfo, arrayAdapter);
                        }
                    }
                }, new Consumer() { // from class: com.urbandroid.sleep.smartwatch.polar.PolarDeviceLookupDialogFragment$createDialog$1$1$1$2
                    @Override // io.reactivex.rxjava3.functions.Consumer
                    public final void accept(Throwable th) {
                        th.getClass();
                        Logger.logSevere(th);
                    }
                }, new Polar$$ExternalSyntheticLambda1(1));
            }
        } catch (Exception e) {
            Logger.logInfo(Fragment$$ExternalSyntheticOutline1.m(this.this$0.logPrefix, " scan ", e.getClass().getName(), " ", e.getMessage()), null);
            PolarBleApi api2 = this.this$0.getApi();
            if (api2 != null) {
                api2.shutDown();
            }
            try {
                this.this$0.dismiss();
            } catch (Exception unused) {
            }
        }
        return Unit.INSTANCE;
    }
}
