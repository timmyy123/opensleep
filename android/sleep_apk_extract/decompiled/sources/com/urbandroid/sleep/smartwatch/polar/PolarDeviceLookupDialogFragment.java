package com.urbandroid.sleep.smartwatch.polar;

import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
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
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import androidx.fragment.app.FragmentActivity;
import com.facebook.GraphResponse;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.getpebble.android.kit.Constants;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.polar.sdk.api.PolarBleApi;
import com.polar.sdk.api.model.PolarDeviceInfo;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt$contextScope$scope$1;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.gui.dialog.DialogItem;
import com.urbandroid.sleep.gui.dialog.FixedDialogFragment;
import com.urbandroid.sleep.gui.inflator.InflatorUtil;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.util.VolumeUtil$$ExternalSyntheticLambda0;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 >2\u00020\u00012\u00020\u0002:\u0001>B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J%\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0016\u001a\u0004\u0018\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0015\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\u0019\u001a\u00020\u00182\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0015\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001d\u0010\u0004J\u0019\u0010 \u001a\u00020\n2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020\n2\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020\u000e8\u0002X\u0082D¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010,\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u001a\u0010/\u001a\u00020.8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u0016\u00103\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u0010&\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u00106R$\u00108\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=¨\u0006?"}, d2 = {"Lcom/urbandroid/sleep/smartwatch/polar/PolarDeviceLookupDialogFragment;", "Lcom/urbandroid/sleep/gui/dialog/FixedDialogFragment;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "Lcom/polar/sdk/api/model/PolarDeviceInfo;", DeviceRequestsHelper.DEVICE_INFO_DEVICE, "Landroid/widget/ArrayAdapter;", "Lcom/urbandroid/sleep/gui/dialog/DialogItem;", "arrayAdapter", "", "addDevice", "(Lcom/polar/sdk/api/model/PolarDeviceInfo;Landroid/widget/ArrayAdapter;)V", "Lkotlin/Pair;", "", "getNameAndAddress", "(Lcom/polar/sdk/api/model/PolarDeviceInfo;)Lkotlin/Pair;", "", Constants.CUST_ICON, "createDialogItem", "(Lcom/polar/sdk/api/model/PolarDeviceInfo;I)Lcom/urbandroid/sleep/gui/dialog/DialogItem;", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "find", "(Landroid/widget/ArrayAdapter;Ljava/lang/String;)Lcom/urbandroid/sleep/gui/dialog/DialogItem;", "", "contains", "(Landroid/widget/ArrayAdapter;Ljava/lang/String;)Z", "callbackSuccess", "(Lcom/polar/sdk/api/model/PolarDeviceInfo;)V", "callbackFailure", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/app/Dialog;", "createDialog", "()Landroid/app/Dialog;", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "(Landroid/content/DialogInterface;)V", "logPrefix", "Ljava/lang/String;", "Lkotlinx/coroutines/CompletableJob;", "supervisorJob", "Lkotlinx/coroutines/CompletableJob;", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", GraphResponse.SUCCESS_KEY, "Z", "Landroidx/appcompat/app/AlertDialog;", "Landroidx/appcompat/app/AlertDialog;", "Lcom/polar/sdk/api/PolarBleApi;", "api", "Lcom/polar/sdk/api/PolarBleApi;", "getApi", "()Lcom/polar/sdk/api/PolarBleApi;", "setApi", "(Lcom/polar/sdk/api/PolarBleApi;)V", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PolarDeviceLookupDialogFragment extends FixedDialogFragment implements CoroutineScope {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private PolarBleApi api;
    private final CoroutineContext coroutineContext;
    private AlertDialog dialog;
    private final String logPrefix = "Polar:";
    private boolean success;
    private final CompletableJob supervisorJob;

    /* JADX INFO: loaded from: classes4.dex */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/urbandroid/sleep/smartwatch/polar/PolarDeviceLookupDialogFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/urbandroid/sleep/smartwatch/polar/PolarDeviceLookupDialogFragment;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PolarDeviceLookupDialogFragment newInstance() {
            PolarDeviceLookupDialogFragment polarDeviceLookupDialogFragment = new PolarDeviceLookupDialogFragment();
            polarDeviceLookupDialogFragment.setArguments(new Bundle());
            return polarDeviceLookupDialogFragment;
        }

        private Companion() {
        }
    }

    public PolarDeviceLookupDialogFragment() {
        CompletableJob completableJobSupervisorJob$default = SupervisorKt.SupervisorJob$default(null, 1, null);
        this.supervisorJob = completableJobSupervisorJob$default;
        this.coroutineContext = Dispatchers.getMain().plus(completableJobSupervisorJob$default);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addDevice(PolarDeviceInfo device, ArrayAdapter<DialogItem> arrayAdapter) {
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
        PolarBleApi polarBleApi = this.api;
        if (polarBleApi != null) {
            polarBleApi.shutDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void callbackSuccess(PolarDeviceInfo device) {
        PolarBleApi polarBleApi = this.api;
        if (polarBleApi != null) {
            polarBleApi.shutDown();
        }
        SharedApplicationContext.getSettings().setPolarSdkDevice(device);
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

    private final DialogItem createDialogItem(final PolarDeviceInfo device, int icon) {
        Pair<String, String> nameAndAddress = getNameAndAddress(device);
        String strComponent1 = nameAndAddress.component1();
        String strComponent2 = nameAndAddress.component2();
        DialogItem dialogItem = new DialogItem(strComponent2, icon) { // from class: com.urbandroid.sleep.smartwatch.polar.PolarDeviceLookupDialogFragment.createDialogItem.1
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

    private final Pair<String, String> getNameAndAddress(PolarDeviceInfo device) {
        String name = device.getName();
        if (name == null) {
            name = device.getAddress();
        }
        return new Pair<>(name, device.getAddress());
    }

    @Override // com.urbandroid.sleep.gui.dialog.FixedDialogFragment
    public Dialog createDialog() {
        final Context contextRequireContext = requireContext();
        contextRequireContext.getClass();
        final FragmentActivity activity = getActivity();
        if (activity == null) {
            return new Dialog(contextRequireContext);
        }
        View viewInflate = activity.getLayoutInflater().inflate(R.layout.dialog_btle, (ViewGroup) null);
        viewInflate.findViewById(R.id.hr_img).startAnimation(AnimationUtils.loadAnimation(activity, R.anim.pulse));
        ArrayAdapter<DialogItem> arrayAdapter = new ArrayAdapter<DialogItem>(activity) { // from class: com.urbandroid.sleep.smartwatch.polar.PolarDeviceLookupDialogFragment$createDialog$1$arrayAdapter$1
            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public View getView(int position, View convertView, ViewGroup parent) {
                parent.getClass();
                if (convertView == null) {
                    convertView = InflatorUtil.INSTANCE.get(contextRequireContext).inflate(R.layout.drawer_item_entry_subtitle, parent, false);
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
        MaterialAlertDialogBuilder view = materialAlertDialogBuilder.setTitle((CharSequence) (value + " " + lowerCase)).setPositiveButton(R.string.cancel, (DialogInterface.OnClickListener) new VolumeUtil$$ExternalSyntheticLambda0(this, 16)).setAdapter((ListAdapter) arrayAdapter, (DialogInterface.OnClickListener) new VolumeUtil$$ExternalSyntheticLambda0(arrayAdapter, 17)).setView(viewInflate);
        view.getClass();
        if (BluetoothAdapter.getDefaultAdapter() != null) {
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new PolarDeviceLookupDialogFragment$createDialog$1$1(this, contextRequireContext, arrayAdapter, null), 3, null);
            AlertDialog alertDialogCreate = view.create();
            this.dialog = alertDialogCreate;
            alertDialogCreate.getClass();
            return alertDialogCreate;
        }
        FragmentActivity activity3 = getActivity();
        activity3.getClass();
        MaterialAlertDialogBuilder view2 = new MaterialAlertDialogBuilder(activity3).setMessage(R.string.general_unspecified_error).setPositiveButton(R.string.button_ok, (DialogInterface.OnClickListener) null).setView(viewInflate);
        view2.getClass();
        callbackFailure();
        AlertDialog alertDialogCreate2 = view2.create();
        alertDialogCreate2.getClass();
        return alertDialogCreate2;
    }

    public final PolarBleApi getApi() {
        return this.api;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        dialog.getClass();
        super.onDismiss(dialog);
        PolarBleApi polarBleApi = this.api;
        if (polarBleApi != null) {
            polarBleApi.shutDown();
        }
        JobKt__JobKt.cancelChildren$default(this.supervisorJob, null, 1, null);
        if (this.success) {
            return;
        }
        callbackFailure();
    }

    public final void setApi(PolarBleApi polarBleApi) {
        this.api = polarBleApi;
    }
}
