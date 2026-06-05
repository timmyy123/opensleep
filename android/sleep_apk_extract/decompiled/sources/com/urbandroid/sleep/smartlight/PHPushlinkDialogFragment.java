package com.urbandroid.sleep.smartlight;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.philips.lighting.hue.sdk.PHAccessPoint;
import com.philips.lighting.hue.sdk.PHHueSDK;
import com.philips.lighting.hue.sdk.PHSDKListener;
import com.philips.lighting.model.PHBridge;
import com.philips.lighting.model.PHHueParsingError;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.gui.inflator.InflatorUtil;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class PHPushlinkDialogFragment extends DialogFragment {
    private Activity context;
    private PHHueSDK phHueSDK;
    private ProgressBar progressBar;
    private Dialog dialog = null;
    private ViewGroup rootView = null;
    private PHSDKListener listener = new PHSDKListener() { // from class: com.urbandroid.sleep.smartlight.PHPushlinkDialogFragment.1
        @Override // com.philips.lighting.hue.sdk.PHSDKListener
        public void onAccessPointsFound(List<PHAccessPoint> list) {
        }

        @Override // com.philips.lighting.hue.sdk.PHSDKListener
        public void onAuthenticationRequired(PHAccessPoint pHAccessPoint) {
            Logger.logInfo("Pushlink DIALOG: Auth required ");
        }

        @Override // com.philips.lighting.hue.sdk.PHSDKListener
        public void onBridgeConnected(PHBridge pHBridge, String str) {
            Logger.logInfo("Pushlink DIALOG: bridge connected");
            PHPushlinkDialogFragment.this.dismiss();
        }

        @Override // com.philips.lighting.hue.sdk.PHSDKListener
        public void onCacheUpdated(List<Integer> list, PHBridge pHBridge) {
        }

        @Override // com.philips.lighting.hue.sdk.PHSDKListener
        public void onConnectionLost(PHAccessPoint pHAccessPoint) {
            Logger.logInfo("Pushlink DIALOG: connectin lost");
        }

        @Override // com.philips.lighting.hue.sdk.PHSDKListener
        public void onConnectionResumed(PHBridge pHBridge) {
            Logger.logInfo("Pushlink DIALOG: connectin resumed ");
        }

        @Override // com.philips.lighting.hue.sdk.PHSDKListener
        public void onError(int i, final String str) {
            Logger.logInfo("Pushlink DIALOG: error " + i + " " + str);
            if (i == 101) {
                PHPushlinkDialogFragment.this.incrementProgress();
            } else if (i == 1158) {
                PHPushlinkDialogFragment.this.incrementProgress();
                PHPushlinkDialogFragment.this.context.runOnUiThread(new Runnable() { // from class: com.urbandroid.sleep.smartlight.PHPushlinkDialogFragment.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ((TextView) PHPushlinkDialogFragment.this.rootView.findViewById(R.id.message)).setText(str);
                        PHPushlinkDialogFragment.this.dialog.setTitle(R.string.title_error);
                    }
                });
            }
        }

        @Override // com.philips.lighting.hue.sdk.PHSDKListener
        public void onParsingErrors(List<PHHueParsingError> list) {
        }
    };

    public void incrementProgress() {
        Logger.logInfo("Pushlink DIALOG progress +1");
        this.progressBar.incrementProgressBy(1);
        if (this.progressBar.getProgress() >= this.progressBar.getMax()) {
            try {
                dismiss();
            } catch (Exception e) {
                Logger.logSevere(e);
            }
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        FragmentActivity activity = getActivity();
        this.context = activity;
        this.rootView = (ViewGroup) InflatorUtil.get(activity).inflate(R.layout.pushlink_dialog, (ViewGroup) null);
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(getActivity());
        materialAlertDialogBuilder.setTitle(R.string.txt_pushlink);
        materialAlertDialogBuilder.setNegativeButton(R.string.btn_cancel, (DialogInterface.OnClickListener) null);
        this.phHueSDK = PHHueSDK.getInstance();
        ProgressBar progressBar = (ProgressBar) this.rootView.findViewById(R.id.countdownPB);
        this.progressBar = progressBar;
        progressBar.setMax(30);
        this.phHueSDK.getNotificationManager().registerSDKListener(this.listener);
        materialAlertDialogBuilder.setView((View) this.rootView);
        this.dialog = materialAlertDialogBuilder.create();
        Logger.logInfo("Pushlink DIALOG Create");
        return this.dialog;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        Logger.logInfo("Pushlink DIALOG Dismiss");
        if (this.listener != null) {
            this.phHueSDK.getNotificationManager().unregisterSDKListener(this.listener);
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
        Logger.logInfo("Pushlink DIALOG show");
    }
}
