package com.urbandroid.sleep.captcha;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import androidx.appcompat.app.AlertDialog;
import com.facebook.internal.NativeProtocol;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.gui.dialog.DialogUtil;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class IntentIntegrator {
    private final Activity activity;
    public static final Collection<String> PRODUCT_CODE_TYPES = list("UPC_A", "UPC_E", "EAN_8", "EAN_13", "RSS_14");
    public static final Collection<String> ONE_D_CODE_TYPES = list("UPC_A", "UPC_E", "EAN_8", "EAN_13", "CODE_39", "CODE_93", "CODE_128", "ITF", "RSS_14", "RSS_EXPANDED");
    public static final Collection<String> QR_CODE_TYPES = Collections.singleton("QR_CODE");
    public static final Collection<String> DATA_MATRIX_TYPES = Collections.singleton("DATA_MATRIX");
    public static final Collection<String> ALL_CODE_TYPES = null;
    public static final Collection<String> TARGET_BARCODE_SCANNER_ONLY = Collections.singleton("com.google.zxing.client.android");
    public static final Collection<String> TARGET_ALL_KNOWN = list("com.google.zxing.client.android", "com.srowen.bs.android", "com.srowen.bs.android.simple", "com.google.android.apps.unveil", "la.droid.qr", "la.droid.qr.priva", "me.scan.android.client", "tools.scanner.barcodescan", "com.urbandroid.sleep");
    private String title = "Install Barcode Scanner?";
    private String message = "This application requires Barcode Scanner. Would you like to install it?";
    private String buttonYes = "Yes";
    private String buttonNo = "No";
    private Collection<String> targetApplications = TARGET_ALL_KNOWN;

    public IntentIntegrator(Activity activity) {
        this.activity = activity;
    }

    private String findTargetAppPackage(Intent intent) {
        List<ResolveInfo> listQueryIntentActivities = this.activity.getPackageManager().queryIntentActivities(intent, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
        if (listQueryIntentActivities == null) {
            return null;
        }
        Iterator<ResolveInfo> it = listQueryIntentActivities.iterator();
        while (it.hasNext()) {
            String str = it.next().activityInfo.packageName;
            if (this.targetApplications.contains(str)) {
                return str;
            }
        }
        return null;
    }

    private static Collection<String> list(String... strArr) {
        return Collections.unmodifiableCollection(Arrays.asList(strArr));
    }

    public static IntentResult parseActivityResult(int i, int i2, Intent intent) {
        if (i2 != -1) {
            return new IntentResult();
        }
        String stringExtra = intent.getStringExtra("SCAN_RESULT");
        if ("com.urbandroid.sleep.ERROR_CANNOT_SCAN_CODE".equals(stringExtra)) {
            Logger.logSevere("Error Scanning QR code");
            return null;
        }
        String stringExtra2 = intent.getStringExtra("SCAN_RESULT_FORMAT");
        byte[] byteArrayExtra = intent.getByteArrayExtra("SCAN_RESULT_BYTES");
        int intExtra = intent.getIntExtra("SCAN_RESULT_ORIENTATION", Integer.MIN_VALUE);
        return new IntentResult(stringExtra, stringExtra2, byteArrayExtra, intExtra != Integer.MIN_VALUE ? Integer.valueOf(intExtra) : null, intent.getStringExtra("SCAN_RESULT_ERROR_CORRECTION_LEVEL"));
    }

    private AlertDialog showDownloadDialog() {
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(this.activity);
        materialAlertDialogBuilder.setTitle((CharSequence) this.title);
        materialAlertDialogBuilder.setMessage((CharSequence) this.message);
        materialAlertDialogBuilder.setPositiveButton((CharSequence) this.buttonYes, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.captcha.IntentIntegrator.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                ViewIntent.market(IntentIntegrator.this.activity, "com.google.zxing.client.android");
            }
        });
        materialAlertDialogBuilder.setNegativeButton((CharSequence) this.buttonNo, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.captcha.IntentIntegrator.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        return DialogUtil.fixButtonsAndDivider(materialAlertDialogBuilder.show(), R.color.white);
    }

    public AlertDialog initiateScan(Collection<String> collection, int i) {
        Intent intent = new Intent("com.google.zxing.client.android.SCAN");
        intent.putExtra("SAVE_HISTORY", false);
        intent.addCategory("android.intent.category.DEFAULT");
        if (collection != null) {
            StringBuilder sb = new StringBuilder();
            for (String str : collection) {
                if (sb.length() > 0) {
                    sb.append(',');
                }
                sb.append(str);
            }
            intent.putExtra("SCAN_FORMATS", sb.toString());
        }
        if (findTargetAppPackage(intent) == null) {
            return showDownloadDialog();
        }
        intent.addFlags(67108864);
        intent.addFlags(524288);
        this.activity.startActivityForResult(intent, i);
        return null;
    }
}
