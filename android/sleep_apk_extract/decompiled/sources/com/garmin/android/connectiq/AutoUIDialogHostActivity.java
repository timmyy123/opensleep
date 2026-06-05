package com.garmin.android.connectiq;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.urbandroid.util.VolumeUtil$$ExternalSyntheticLambda0;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes3.dex */
public class AutoUIDialogHostActivity extends Activity {
    private String message;
    private String negativeButtonText;
    private String positiveButtonText;
    private String title;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showTheAlertDialog$0(DialogInterface dialogInterface, int i) {
        try {
            getApplicationContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.garmin.android.apps.connectmobile")).addFlags(ClientDefaults.MAX_MSG_SIZE));
        } catch (ActivityNotFoundException unused) {
            getApplicationContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.garmin.android.apps.connectmobile")).addFlags(ClientDefaults.MAX_MSG_SIZE));
        }
    }

    private void showTheAlertDialog() {
        new AlertDialog.Builder(this).setTitle(this.title).setMessage(this.message).setPositiveButton(this.positiveButtonText, new VolumeUtil$$ExternalSyntheticLambda0(this, 3)).setNegativeButton(this.negativeButtonText, (DialogInterface.OnClickListener) null).show();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.title = intent.getStringExtra("EXTRA_DIALOG_TITLE");
        this.message = intent.getStringExtra("EXTRA_DIALOG_MESSAGE");
        this.positiveButtonText = intent.getStringExtra("EXTRA_DIALOG_POSITIVE_BUTTON_TEXT");
        this.negativeButtonText = intent.getStringExtra("EXTRA_DIALOG_NEGATIVE_BUTTON_TEXT");
        showTheAlertDialog();
    }
}
