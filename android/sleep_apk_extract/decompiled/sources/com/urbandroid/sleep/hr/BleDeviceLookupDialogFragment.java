package com.urbandroid.sleep.hr;

import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.core.view.KeyEventDispatcher;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import androidx.fragment.app.FragmentActivity;
import com.facebook.GraphResponse;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.getpebble.android.kit.Constants;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt$contextScope$scope$1;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.gui.dialog.DialogItem;
import com.urbandroid.sleep.gui.dialog.FixedDialogFragment;
import com.urbandroid.sleep.gui.inflator.InflatorUtil;
import com.urbandroid.util.VolumeUtil$$ExternalSyntheticLambda0;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.SupervisorKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0003,-.B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u001e\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0002J\u001e\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0002J\u001c\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060!2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0018\u0010\"\u001a\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020$H\u0002J \u0010%\u001a\u0004\u0018\u00010\u001e2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010&\u001a\u00020\u0006H\u0002J\u001e\u0010'\u001a\u00020\u000e2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010&\u001a\u00020\u0006H\u0002J\u0010\u0010(\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010+\u001a\u00020\u0014H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/urbandroid/sleep/hr/BleDeviceLookupDialogFragment;", "Lcom/urbandroid/sleep/gui/dialog/FixedDialogFragment;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "logPrefix", "", "supervisorJob", "Lkotlinx/coroutines/CompletableJob;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", GraphResponse.SUCCESS_KEY, "", "dialog", "Landroidx/appcompat/app/AlertDialog;", "mode", "Lcom/urbandroid/sleep/hr/BleDeviceLookupDialogFragment$Mode;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "createDialog", "Landroid/app/Dialog;", "addDevice", DeviceRequestsHelper.DEVICE_INFO_DEVICE, "Landroid/bluetooth/BluetoothDevice;", "arrayAdapter", "Landroid/widget/ArrayAdapter;", "Lcom/urbandroid/sleep/gui/dialog/DialogItem;", "highlightRecognizedDevice", "getNameAndAddress", "Lkotlin/Pair;", "createDialogItem", Constants.CUST_ICON, "", "find", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "contains", "onDismiss", "Landroid/content/DialogInterface;", "callbackSuccess", "callbackFailure", "BleDeviceSelectionListener", "Mode", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class BleDeviceLookupDialogFragment extends FixedDialogFragment implements CoroutineScope {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final CoroutineContext coroutineContext;
    private AlertDialog dialog;
    private final String logPrefix = "BtHrDialogFragment:";
    private Mode mode;
    private boolean success;
    private final CompletableJob supervisorJob;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/urbandroid/sleep/hr/BleDeviceLookupDialogFragment$BleDeviceSelectionListener;", "", "onBleDeviceSelectionResult", "", "mode", "Lcom/urbandroid/sleep/hr/BleDeviceLookupDialogFragment$Mode;", DeviceRequestsHelper.DEVICE_INFO_DEVICE, "Landroid/bluetooth/BluetoothDevice;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public interface BleDeviceSelectionListener {
        void onBleDeviceSelectionResult(Mode mode, BluetoothDevice device);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/urbandroid/sleep/hr/BleDeviceLookupDialogFragment$Companion;", "", "<init>", "()V", "EXTRA_MODE", "", "newInstance", "Lcom/urbandroid/sleep/hr/BleDeviceLookupDialogFragment;", "mode", "Lcom/urbandroid/sleep/hr/BleDeviceLookupDialogFragment$Mode;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BleDeviceLookupDialogFragment newInstance(Mode mode) {
            mode.getClass();
            BleDeviceLookupDialogFragment bleDeviceLookupDialogFragment = new BleDeviceLookupDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString("EXTRA_MODE", mode.name());
            bleDeviceLookupDialogFragment.setArguments(bundle);
            return bleDeviceLookupDialogFragment;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B;\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012(\u0010\u0004\u001a$\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0005¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR5\u0010\u0004\u001a$\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/urbandroid/sleep/hr/BleDeviceLookupDialogFragment$Mode;", "", "recognizedDeviceIcon", "", "detectDevice", "Lkotlin/Function3;", "Landroid/content/Context;", "Landroid/bluetooth/BluetoothDevice;", "Lkotlin/coroutines/Continuation;", "Lcom/urbandroid/sleep/hr/DeviceDetectionResult;", "", "<init>", "(Ljava/lang/String;IILkotlin/jvm/functions/Function3;)V", "getRecognizedDeviceIcon", "()I", "getDetectDevice", "()Lkotlin/jvm/functions/Function3;", "Lkotlin/jvm/functions/Function3;", "HR_OR_OXIMETER", "FULL_TRACKING", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Mode {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Mode[] $VALUES;
        private final Function3<Context, BluetoothDevice, Continuation<? super DeviceDetectionResult>, Object> detectDevice;
        private final int recognizedDeviceIcon;
        public static final Mode HR_OR_OXIMETER = new Mode("HR_OR_OXIMETER", 0, R.drawable.ic_action_love, new AnonymousClass1(null));
        public static final Mode FULL_TRACKING = new Mode("FULL_TRACKING", 1, R.drawable.ic_action_watch, new AnonymousClass2(null));

        /* JADX INFO: renamed from: com.urbandroid.sleep.hr.BleDeviceLookupDialogFragment$Mode$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "Lcom/urbandroid/sleep/hr/DeviceDetectionResult;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", DeviceRequestsHelper.DEVICE_INFO_DEVICE, "Landroid/bluetooth/BluetoothDevice;"}, k = 3, mv = {2, 3, 0}, xi = 48)
        @DebugMetadata(c = "com.urbandroid.sleep.hr.BleDeviceLookupDialogFragment$Mode$1", f = "BleDeviceLookupDialogFragment.kt", l = {232}, m = "invokeSuspend", v = 2)
        public static final class AnonymousClass1 extends SuspendLambda implements Function3<Context, BluetoothDevice, Continuation<? super DeviceDetectionResult>, Object> {
            /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            int label;

            public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                super(3, continuation);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Context context, BluetoothDevice bluetoothDevice, Continuation<? super DeviceDetectionResult> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
                anonymousClass1.L$0 = context;
                anonymousClass1.L$1 = bluetoothDevice;
                return anonymousClass1.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Context context = (Context) this.L$0;
                BluetoothDevice bluetoothDevice = (BluetoothDevice) this.L$1;
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
                DetectDevice detectDevice = DetectDevice.INSTANCE;
                this.L$0 = SpillingKt.nullOutSpilledVariable(context);
                this.L$1 = SpillingKt.nullOutSpilledVariable(bluetoothDevice);
                this.label = 1;
                Object objDetectHrDevice = detectDevice.detectHrDevice(context, bluetoothDevice, this);
                return objDetectHrDevice == coroutine_suspended ? coroutine_suspended : objDetectHrDevice;
            }
        }

        /* JADX INFO: renamed from: com.urbandroid.sleep.hr.BleDeviceLookupDialogFragment$Mode$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "Lcom/urbandroid/sleep/hr/DeviceDetectionResult;", "c", "Landroid/content/Context;", "d", "Landroid/bluetooth/BluetoothDevice;"}, k = 3, mv = {2, 3, 0}, xi = 48)
        @DebugMetadata(c = "com.urbandroid.sleep.hr.BleDeviceLookupDialogFragment$Mode$2", f = "BleDeviceLookupDialogFragment.kt", l = {237}, m = "invokeSuspend", v = 2)
        public static final class AnonymousClass2 extends SuspendLambda implements Function3<Context, BluetoothDevice, Continuation<? super DeviceDetectionResult>, Object> {
            /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            int label;

            public AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
                super(3, continuation);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Context context, BluetoothDevice bluetoothDevice, Continuation<? super DeviceDetectionResult> continuation) {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
                anonymousClass2.L$0 = context;
                anonymousClass2.L$1 = bluetoothDevice;
                return anonymousClass2.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Context context = (Context) this.L$0;
                BluetoothDevice bluetoothDevice = (BluetoothDevice) this.L$1;
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
                DetectDevice detectDevice = DetectDevice.INSTANCE;
                this.L$0 = SpillingKt.nullOutSpilledVariable(context);
                this.L$1 = SpillingKt.nullOutSpilledVariable(bluetoothDevice);
                this.label = 1;
                Object objDetectAccelDevice = detectDevice.detectAccelDevice(context, bluetoothDevice, this);
                return objDetectAccelDevice == coroutine_suspended ? coroutine_suspended : objDetectAccelDevice;
            }
        }

        private static final /* synthetic */ Mode[] $values() {
            return new Mode[]{HR_OR_OXIMETER, FULL_TRACKING};
        }

        static {
            Mode[] modeArr$values = $values();
            $VALUES = modeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(modeArr$values);
        }

        private Mode(String str, int i, int i2, Function3 function3) {
            this.recognizedDeviceIcon = i2;
            this.detectDevice = function3;
        }

        public static Mode valueOf(String str) {
            return (Mode) Enum.valueOf(Mode.class, str);
        }

        public static Mode[] values() {
            return (Mode[]) $VALUES.clone();
        }

        public final Function3<Context, BluetoothDevice, Continuation<? super DeviceDetectionResult>, Object> getDetectDevice() {
            return this.detectDevice;
        }

        public final int getRecognizedDeviceIcon() {
            return this.recognizedDeviceIcon;
        }
    }

    public BleDeviceLookupDialogFragment() {
        CompletableJob completableJobSupervisorJob$default = SupervisorKt.SupervisorJob$default(null, 1, null);
        this.supervisorJob = completableJobSupervisorJob$default;
        this.coroutineContext = Dispatchers.getMain().plus(completableJobSupervisorJob$default);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addDevice(BluetoothDevice device, ArrayAdapter<DialogItem> arrayAdapter) {
        Pair<String, String> nameAndAddress = getNameAndAddress(device);
        String strComponent1 = nameAndAddress.component1();
        String strComponent2 = nameAndAddress.component2();
        Logger.logInfo(Fragment$$ExternalSyntheticOutline1.m(this.logPrefix, " Discovered device: ", strComponent1, " ", strComponent2), null);
        if (contains(arrayAdapter, strComponent2)) {
            return;
        }
        arrayAdapter.insert(createDialogItem(device, R.drawable.ic_bluetooth), 0);
        arrayAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void callbackFailure() {
        KeyEventDispatcher.Component activity = getActivity();
        BleDeviceSelectionListener bleDeviceSelectionListener = activity instanceof BleDeviceSelectionListener ? (BleDeviceSelectionListener) activity : null;
        if (bleDeviceSelectionListener != null) {
            Mode mode = this.mode;
            if (mode == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mode");
                mode = null;
            }
            bleDeviceSelectionListener.onBleDeviceSelectionResult(mode, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void callbackSuccess(BluetoothDevice device) {
        KeyEventDispatcher.Component activity = getActivity();
        Mode mode = null;
        BleDeviceSelectionListener bleDeviceSelectionListener = activity instanceof BleDeviceSelectionListener ? (BleDeviceSelectionListener) activity : null;
        if (bleDeviceSelectionListener != null) {
            Mode mode2 = this.mode;
            if (mode2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mode");
            } else {
                mode = mode2;
            }
            bleDeviceSelectionListener.onBleDeviceSelectionResult(mode, device);
        }
    }

    private final boolean contains(ArrayAdapter<DialogItem> arrayAdapter, String address) {
        return find(arrayAdapter, address) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createDialog$lambda$0$2(ArrayAdapter arrayAdapter, DialogInterface dialogInterface, int i) {
        DialogItem dialogItem = (DialogItem) arrayAdapter.getItem(i);
        if (dialogItem != null) {
            dialogItem.onClick();
        }
    }

    private final DialogItem createDialogItem(final BluetoothDevice device, int icon) {
        Pair<String, String> nameAndAddress = getNameAndAddress(device);
        String strComponent1 = nameAndAddress.component1();
        String strComponent2 = nameAndAddress.component2();
        DialogItem dialogItem = new DialogItem(strComponent2, icon) { // from class: com.urbandroid.sleep.hr.BleDeviceLookupDialogFragment.createDialogItem.1
            @Override // com.urbandroid.sleep.gui.dialog.DialogItem
            public void onClick() {
                this.callbackSuccess(device);
                this.success = true;
                this.dismiss();
            }
        };
        if (!Intrinsics.areEqual(strComponent1, strComponent2)) {
            dialogItem.setSubtitle(strComponent1);
        }
        return dialogItem;
    }

    private final DialogItem find(ArrayAdapter<DialogItem> arrayAdapter, String address) {
        int count = arrayAdapter.getCount();
        for (int i = 0; i < count; i++) {
            DialogItem item = arrayAdapter.getItem(i);
            if (item != null && (Intrinsics.areEqual(item.getTitle(), address) || Intrinsics.areEqual(item.getSubtitle(), address))) {
                return item;
            }
        }
        return null;
    }

    private final Pair<String, String> getNameAndAddress(BluetoothDevice device) {
        String name = device.getName();
        if (name == null) {
            name = device.getAddress();
        }
        return new Pair<>(name, device.getAddress());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void highlightRecognizedDevice(BluetoothDevice device, ArrayAdapter<DialogItem> arrayAdapter) {
        Pair<String, String> nameAndAddress = getNameAndAddress(device);
        String strComponent1 = nameAndAddress.component1();
        String strComponent2 = nameAndAddress.component2();
        Mode mode = null;
        Logger.logInfo(Fragment$$ExternalSyntheticOutline1.m(this.logPrefix, " Recognized device: ", strComponent1, " ", strComponent2), null);
        DialogItem dialogItemFind = find(arrayAdapter, strComponent2);
        if (dialogItemFind != null) {
            arrayAdapter.remove(dialogItemFind);
            arrayAdapter.notifyDataSetChanged();
        }
        Mode mode2 = this.mode;
        if (mode2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mode");
        } else {
            mode = mode2;
        }
        arrayAdapter.insert(createDialogItem(device, mode.getRecognizedDeviceIcon()), 0);
        arrayAdapter.notifyDataSetChanged();
    }

    @Override // com.urbandroid.sleep.gui.dialog.FixedDialogFragment
    public Dialog createDialog() {
        Context contextRequireContext = requireContext();
        contextRequireContext.getClass();
        final FragmentActivity activity = getActivity();
        if (activity == null) {
            return new Dialog(contextRequireContext);
        }
        View viewInflate = activity.getLayoutInflater().inflate(R.layout.dialog_btle, (ViewGroup) null);
        viewInflate.findViewById(R.id.hr_img).startAnimation(AnimationUtils.loadAnimation(activity, R.anim.pulse));
        ArrayAdapter<DialogItem> arrayAdapter = new ArrayAdapter<DialogItem>() { // from class: com.urbandroid.sleep.hr.BleDeviceLookupDialogFragment$createDialog$1$arrayAdapter$1
            {
                super(this.$fragmentActivity, R.layout.drawer_item_entry_subtitle);
            }

            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public View getView(int position, View convertView, ViewGroup parent) {
                parent.getClass();
                if (convertView == null) {
                    convertView = InflatorUtil.INSTANCE.get(this.$fragmentActivity).inflate(R.layout.drawer_item_entry_subtitle, parent, false);
                }
                DialogItem item = getItem(position);
                if (item != null) {
                    String title = item.getTitle();
                    String subtitle = item.getSubtitle();
                    int iconRes = item.getIconRes();
                    ((TextView) convertView.findViewById(R.id.title)).setText(title);
                    TextView textView = (TextView) convertView.findViewById(R.id.subtitle);
                    if (subtitle != null) {
                        textView.setText(subtitle);
                        textView.setVisibility(0);
                    } else {
                        textView.setVisibility(8);
                    }
                    ((ImageView) convertView.findViewById(R.id.icon)).setImageResource(iconRes);
                }
                convertView.getClass();
                return convertView;
            }
        };
        FragmentActivity activity2 = getActivity();
        activity2.getClass();
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(activity2);
        ContextExtKt$contextScope$scope$1 contextExtKt$contextScope$scope$1 = new ContextExtKt$contextScope$scope$1(contextRequireContext);
        String value = contextExtKt$contextScope$scope$1.getValue(R.string.search);
        String lowerCase = contextExtKt$contextScope$scope$1.getValue(R.string.in_progress).toLowerCase(Locale.ROOT);
        lowerCase.getClass();
        MaterialAlertDialogBuilder view = materialAlertDialogBuilder.setTitle((CharSequence) (value + " " + lowerCase)).setPositiveButton(R.string.cancel, (DialogInterface.OnClickListener) new VolumeUtil$$ExternalSyntheticLambda0(this, 13)).setAdapter((ListAdapter) arrayAdapter, (DialogInterface.OnClickListener) new VolumeUtil$$ExternalSyntheticLambda0(arrayAdapter, 14)).setView(viewInflate);
        view.getClass();
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null) {
            FragmentActivity activity3 = getActivity();
            activity3.getClass();
            MaterialAlertDialogBuilder view2 = new MaterialAlertDialogBuilder(activity3).setMessage(R.string.general_unspecified_error).setPositiveButton(R.string.button_ok, (DialogInterface.OnClickListener) null).setView(viewInflate);
            view2.getClass();
            callbackFailure();
            AlertDialog alertDialogCreate = view2.create();
            alertDialogCreate.getClass();
            return alertDialogCreate;
        }
        if (!defaultAdapter.isEnabled()) {
            defaultAdapter.enable();
        }
        Set<BluetoothDevice> bondedDevices = defaultAdapter.getBondedDevices();
        if (bondedDevices != null) {
            for (BluetoothDevice bluetoothDevice : bondedDevices) {
                bluetoothDevice.getClass();
                addDevice(bluetoothDevice, arrayAdapter);
            }
        }
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new BleDeviceLookupDialogFragment$createDialog$1$2(contextRequireContext, this, arrayAdapter, viewInflate, null), 3, null);
        AlertDialog alertDialogCreate2 = view.create();
        this.dialog = alertDialogCreate2;
        alertDialogCreate2.getClass();
        return alertDialogCreate2;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        String string;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString("EXTRA_MODE")) == null) {
            string = "NONE";
        }
        this.mode = Mode.valueOf(string);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        dialog.getClass();
        super.onDismiss(dialog);
        JobKt__JobKt.cancelChildren$default(this.supervisorJob, null, 1, null);
        if (this.success) {
            return;
        }
        callbackFailure();
    }
}
