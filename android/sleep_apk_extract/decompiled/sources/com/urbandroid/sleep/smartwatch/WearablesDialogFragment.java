package com.urbandroid.sleep.smartwatch;

import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListAdapter;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.gui.GraphListClickHandler$$ExternalSyntheticLambda2;
import com.urbandroid.sleep.service.Settings;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class WearablesDialogFragment extends DialogFragment {
    private Activity context;
    private Wearable selectedWearable;

    public interface OnCloseListener {
        void bleWearableSelected(Activity activity, Wearable wearable);

        void regularWearableSelected(Activity activity, Wearable wearable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateDialog$0(List list, DialogInterface dialogInterface, int i) {
        Wearable wearable = (Wearable) list.get(i);
        if ((wearable != null && wearable.isDirectBleWearable()) || new Settings(this.context).setWearableOrInstallAddon(wearable)) {
            this.selectedWearable = wearable;
        }
        dialogInterface.cancel();
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        this.context = getActivity();
        ArrayList arrayList = new ArrayList();
        arrayList.add(Wearable.NONE);
        arrayList.add(Wearable.WEAR_OS_3_PLUS);
        arrayList.add(Wearable.SAMSUNG_WEAR);
        arrayList.add(Wearable.REPEBBLE);
        arrayList.add(Wearable.ADDON_URBANDROID_GARMIN);
        arrayList.add(Wearable.POLAR_SDK);
        arrayList.add(Wearable.POLAR);
        arrayList.add(Wearable.PINE_TIME_INFINI_TIME);
        arrayList.add(Wearable.ADDON_3RD_PARTY_MI_BAND_TOOLS);
        arrayList.add(Wearable.ADDON_3RD_PARTY_MI_BAND_NOTIFY_FITNESS);
        arrayList.add(Wearable.ADDON_3RD_PARTY_MI_BAND_NOTIFY_FITNESS_FOR_XIAOMI);
        arrayList.add(Wearable.ADDON_3RD_PARTY_MI_BAND_NOTIFY_FITNESS_HUAWEI);
        arrayList.add(Wearable.ADDON_3RD_PARTY_MI_BAND_NOTIFY_FITNESS_FOR_XIAOMI_HUAWEI);
        arrayList.add(Wearable.ADDON_3RD_PARTY_AMAZFIT_TOOLS);
        arrayList.add(Wearable.ADDON_3RD_PARTY_AMAZFIT_NOTIFY_FITNESS);
        arrayList.add(Wearable.ADDON_3RD_PARTY_AMAZFIT_NOTIFY_FITNESS_HUAWEI);
        arrayList.add(Wearable.FITBIT);
        arrayList.add(Wearable.ADDON_URBANDROID_SAMSUNG_NEW);
        arrayList.add(Wearable.WEAR_OS);
        arrayList.add(Wearable.PEBBLE_TIME);
        arrayList.add(Wearable.PEBBLE_GADGETBRIDGE);
        arrayList.add(Wearable.ADDON_3RD_PARTY_GO2SLEEP);
        arrayList.add(Wearable.ADDON_3RD_PARTY_O2RING);
        arrayList.add(Wearable.ADDON_3RD_PARTY_MAXIM_INTEGRATED);
        arrayList.add(Wearable.ADDON_3RD_PARTY_GARMIN);
        arrayList.add(Wearable.BANGLE_JS);
        arrayList.add(Wearable.ADDON_3RD_PARTY_AMAZFIT_ANDROID_AMAZMOD);
        arrayList.add(Wearable.CUSTOM);
        arrayList.add(Wearable.AUTO);
        MaterialAlertDialogBuilder adapter = new MaterialAlertDialogBuilder(this.context).setAdapter((ListAdapter) new WearablesListAdapter(getActivity(), arrayList), (DialogInterface.OnClickListener) new GraphListClickHandler$$ExternalSyntheticLambda2(this, arrayList, 6));
        adapter.setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null);
        adapter.setTitle(R.string.smartwatch);
        return adapter.create();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        FragmentActivity activity = getActivity();
        if (activity != null && (activity instanceof OnCloseListener)) {
            Wearable wearable = this.selectedWearable;
            if (wearable != null && wearable.isDirectBleWearable()) {
                ((OnCloseListener) getActivity()).bleWearableSelected(getActivity(), this.selectedWearable);
                return;
            }
            ((OnCloseListener) getActivity()).regularWearableSelected(getActivity(), this.selectedWearable);
            Wearable wearable2 = this.selectedWearable;
            if (wearable2 == null || !wearable2.isShowAddOnAfterSelect()) {
                return;
            }
            try {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(this.selectedWearable.addonPackageName, this.selectedWearable.addonPackageName + ".MainActivity"));
                getActivity().startActivity(intent);
            } catch (Exception e) {
                Logger.logSevere(e);
                ViewIntent.market(activity, this.selectedWearable.addonPackageName);
            }
        }
    }
}
