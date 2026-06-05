package com.urbandroid.common.util.intent;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ChromeCustomTab;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.TrialFilter;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ViewIntent {
    public static void airplane(Context context) {
        try {
            Intent intent = new Intent();
            intent.setAction("android.settings.AIRPLANE_MODE_SETTINGS");
            intent.addFlags(335544320);
            context.startActivity(intent);
        } catch (Exception e) {
            Logger.logInfo("No activity to handle airplane mode", e);
            try {
                Intent intent2 = new Intent();
                intent2.setAction("android.settings.WIRELESS_SETTINGS");
                intent2.addFlags(335544320);
                context.startActivity(intent2);
            } catch (Exception e2) {
                Logger.logInfo("No activity to handle wireless mode", e2);
            }
        }
    }

    public static String getNoPermissionText(Context context, String str, int i) {
        String lowerCase = str.toLowerCase();
        try {
            try {
                lowerCase = context.getPackageManager().getPermissionGroupInfo(str, 128).loadLabel(context.getPackageManager()).toString();
                if ("android.permission.group.UNDEFINED".equals(lowerCase)) {
                    lowerCase = context.getPackageManager().getPermissionInfo(str, 128).loadLabel(context.getPackageManager()).toString();
                }
            } catch (PackageManager.NameNotFoundException e) {
                Logger.logSevere(e);
            } catch (Exception e2) {
                Logger.logSevere(e2);
            }
        } catch (PackageManager.NameNotFoundException unused) {
            lowerCase = context.getPackageManager().getPermissionGroupInfo(context.getPackageManager().getPermissionInfo(str, 128).group, 128).loadLabel(context.getPackageManager()).toString();
        } catch (Exception e3) {
            Logger.logSevere(e3);
        }
        if ("android.permission-group.UNDEFINED".equals(lowerCase)) {
            try {
                lowerCase = context.getPackageManager().getPermissionInfo(str, 128).loadLabel(context.getPackageManager()).toString();
            } catch (PackageManager.NameNotFoundException e4) {
                Logger.logSevere(e4);
                lowerCase = "NA";
            }
        }
        Logger.logInfo("Permissions: permission " + str + " localized name " + lowerCase);
        return i == -1 ? context.getResources().getString(R.string.no_permission_even_more_general, lowerCase) : context.getResources().getString(R.string.no_permission_general, context.getResources().getString(i), lowerCase);
    }

    public static MaterialAlertDialogBuilder getPermissionDenyDialogBuilder(final Activity activity, String str, String str2) {
        MaterialAlertDialogBuilder message = new MaterialAlertDialogBuilder(activity).setTitle(R.string.no_permission).setMessage((CharSequence) str2);
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, str)) {
            message.setPositiveButton(R.string.button_ok, (DialogInterface.OnClickListener) null);
            return message;
        }
        message.setPositiveButton(R.string.settings, new DialogInterface.OnClickListener() { // from class: com.urbandroid.common.util.intent.ViewIntent.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                ViewIntent.showPermissionsSettings(activity);
            }
        }).setNegativeButton(R.string.button_cancel, (DialogInterface.OnClickListener) null);
        return message;
    }

    public static Intent getSendToIntent(Context context, String str, String str2, String str3) {
        StringBuilder sbM5m = FileInsert$$ExternalSyntheticOutline0.m5m("mailto:", str, "?&subject=");
        sbM5m.append(Uri.encode(str2));
        sbM5m.append("&body=");
        sbM5m.append(Uri.encode(str3));
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse(sbM5m.toString()));
        intent.putExtra("android.intent.extra.SUBJECT", str2);
        intent.putExtra("android.intent.extra.TEXT", str3);
        return Intent.createChooser(intent, context.getString(R.string.email));
    }

    public static Intent getUrlIntent(Context context, String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.setFlags(ClientDefaults.MAX_MSG_SIZE);
        return intent;
    }

    public static void market(Context context, String str) {
        if (TrialFilter.getInstance().getVersion() == TrialFilter.Version.TRIAL || TrialFilter.getInstance().getVersion() == TrialFilter.Version.SAMSUNG) {
            url(context, "market://details?id=" + str);
        } else if (TrialFilter.getInstance().getVersion() == TrialFilter.Version.AMAZON) {
            url(context, "amzn://apps/android?p=" + str);
        } else {
            if (context == null || !(context instanceof Activity)) {
                return;
            }
            Toast.makeText(context, R.string.message_missing_feature, 1).show();
        }
    }

    public static String packageFromMarketUrl(String str) {
        if (str == null) {
            return str;
        }
        if (!str.startsWith("market://details?id=")) {
            return str.startsWith("amzn://apps/android?p=") ? str.substring(22) : str;
        }
        String strSubstring = str.substring(20);
        if (strSubstring.contains("&")) {
            return strSubstring.substring(0, strSubstring.indexOf("&"));
        }
        Logger.logInfo("URL ".concat(strSubstring));
        return strSubstring;
    }

    public static void sendTo(Context context, String str, String str2, String str3) {
        context.startActivity(getSendToIntent(context, str, str2, str3));
    }

    public static void showPermissionsSettings(Context context) {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + context.getPackageName()));
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setFlags(ClientDefaults.MAX_MSG_SIZE);
            context.startActivity(intent);
        } catch (Exception unused) {
            Toast.makeText(context, "Please go to Settings - Apps - Sleep as Android - Permissions", 1).show();
        }
    }

    public static void url(Context context, String str) {
        try {
            context.startActivity(getUrlIntent(context, str));
        } catch (Exception e) {
            Logger.logSevere(e);
            if (context == null || !(context instanceof Activity)) {
                return;
            }
            Toast.makeText(context, "Cannot open " + str, 1).show();
        }
    }

    public static void urlCustomTab(Activity activity, String str) {
        try {
            ChromeCustomTab chromeCustomTab = new ChromeCustomTab(activity);
            chromeCustomTab.show(str);
            chromeCustomTab.unbindCustomTabsService();
        } catch (Exception e) {
            Logger.logSevere(e);
            try {
                url(activity, str);
            } catch (Exception unused) {
                Logger.logSevere(e);
                if (activity != null) {
                    Toast.makeText(activity, "Cannot open " + str, 1).show();
                }
            }
        }
    }

    public static MaterialAlertDialogBuilder getPermissionDenyDialogBuilder(Activity activity, String str, int i) {
        return getPermissionDenyDialogBuilder(activity, str, getNoPermissionText(activity, str, i));
    }
}
