package com.urbandroid.util;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.core.content.ContextCompat;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ%\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\u0018J)\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\bH\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ)\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\bH\u0007¢\u0006\u0004\b\u001d\u0010\u001cJ\r\u0010\u001e\u001a\u00020\u0006¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/urbandroid/util/SleepPermissionCompat;", "", "<init>", "()V", "Landroid/app/Activity;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "", "permission", "", "shouldShowRequestPermissionRationale", "(Landroid/app/Activity;Ljava/lang/String;)Z", "", "requestCode", "", "requestPermission", "(Landroid/app/Activity;Ljava/lang/String;I)V", "", "permissions", "requestPermissions", "(Landroid/app/Activity;[Ljava/lang/String;I)V", "Landroid/content/Context;", "checkSelfPermission", "(Landroid/content/Context;Ljava/lang/String;)I", "isPermissionGranted", "(Landroid/content/Context;Ljava/lang/String;)Z", "rqCode", "requireFineOnApi29", "requestLocationPermission", "(Landroid/app/Activity;IZ)Z", "requestLocationPermissionForBt", "getRequiredLocationPermissionForBluetoothLe", "()Ljava/lang/String;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SleepPermissionCompat {
    public static final SleepPermissionCompat INSTANCE = new SleepPermissionCompat();

    private SleepPermissionCompat() {
    }

    public static /* synthetic */ boolean requestLocationPermission$default(SleepPermissionCompat sleepPermissionCompat, Activity activity, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return sleepPermissionCompat.requestLocationPermission(activity, i, z);
    }

    public final int checkSelfPermission(Context context, String permission) {
        context.getClass();
        permission.getClass();
        try {
            return ContextCompat.checkSelfPermission(context, permission);
        } catch (Exception e) {
            Logger.logSevere(e);
            return 0;
        }
    }

    public final String getRequiredLocationPermissionForBluetoothLe() {
        int i = Build.VERSION.SDK_INT;
        return i >= 31 ? "android.permission.BLUETOOTH_SCAN" : i >= 29 ? "android.permission.ACCESS_FINE_LOCATION" : "android.permission.ACCESS_COARSE_LOCATION";
    }

    public final boolean isPermissionGranted(Context context, String permission) {
        context.getClass();
        permission.getClass();
        return checkSelfPermission(context, permission) == 0;
    }

    public final boolean requestLocationPermission(Activity context, int rqCode, boolean requireFineOnApi29) {
        context.getClass();
        boolean zIsPermissionGranted = isPermissionGranted(context, "android.permission.ACCESS_COARSE_LOCATION");
        boolean zIsPermissionGranted2 = isPermissionGranted(context, "android.permission.ACCESS_FINE_LOCATION");
        boolean z = requireFineOnApi29 && Build.VERSION.SDK_INT >= 29;
        int i = Build.VERSION.SDK_INT;
        StringBuilder sb = new StringBuilder("Permissions: fine=");
        sb.append(zIsPermissionGranted2);
        sb.append(" coarse=");
        sb.append(zIsPermissionGranted);
        sb.append(" requireFineOnApi29=");
        sb.append(requireFineOnApi29);
        sb.append(" version=");
        sb.append(i);
        sb.append(" requiresFine=");
        zza$$ExternalSyntheticOutline0.m(sb, z);
        if (zIsPermissionGranted2) {
            return false;
        }
        if (z) {
            Logger.logInfo("Permissions: LOCATION FINE Request ");
            requestPermission(context, "android.permission.ACCESS_FINE_LOCATION", rqCode);
            return true;
        }
        if (zIsPermissionGranted) {
            return false;
        }
        Logger.logInfo("Permissions: LOCATION FINE Request ");
        requestPermission(context, "android.permission.ACCESS_FINE_LOCATION", rqCode);
        return true;
    }

    public final boolean requestLocationPermissionForBt(Activity context, int rqCode, boolean requireFineOnApi29) {
        context.getClass();
        int i = Build.VERSION.SDK_INT;
        if (i >= 33 && i >= 31) {
            if (isPermissionGranted(context, "android.permission.BLUETOOTH_SCAN") && isPermissionGranted(context, "android.permission.BLUETOOTH_CONNECT") && isPermissionGranted(context, "android.permission.BLUETOOTH_ADVERTISE") && isPermissionGranted(context, "android.permission.NEARBY_WIFI_DEVICES")) {
                return false;
            }
            requestPermissions(context, new String[]{"android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_CONNECT", "android.permission.BLUETOOTH_ADVERTISE", "android.permission.NEARBY_WIFI_DEVICES"}, rqCode);
            return true;
        }
        if (i >= 31) {
            if (isPermissionGranted(context, "android.permission.BLUETOOTH_SCAN") && isPermissionGranted(context, "android.permission.BLUETOOTH_CONNECT") && isPermissionGranted(context, "android.permission.BLUETOOTH_ADVERTISE")) {
                return false;
            }
            requestPermissions(context, new String[]{"android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_CONNECT", "android.permission.BLUETOOTH_ADVERTISE"}, rqCode);
            return true;
        }
        boolean zIsPermissionGranted = isPermissionGranted(context, "android.permission.ACCESS_COARSE_LOCATION");
        boolean zIsPermissionGranted2 = isPermissionGranted(context, "android.permission.ACCESS_FINE_LOCATION");
        boolean z = requireFineOnApi29 && i >= 29;
        StringBuilder sb = new StringBuilder("Permissions: fine=");
        sb.append(zIsPermissionGranted2);
        sb.append(" coarse=");
        sb.append(zIsPermissionGranted);
        sb.append(" requireFineOnApi29=");
        sb.append(requireFineOnApi29);
        sb.append(" version=");
        sb.append(i);
        sb.append(" requiresFine=");
        zza$$ExternalSyntheticOutline0.m(sb, z);
        if (zIsPermissionGranted2) {
            return false;
        }
        if (z) {
            Logger.logInfo("Permissions: LOCATION FINE Request ");
            requestPermission(context, "android.permission.ACCESS_FINE_LOCATION", rqCode);
            return true;
        }
        if (zIsPermissionGranted) {
            return false;
        }
        Logger.logInfo("Permissions: LOCATION FINE Request ");
        requestPermission(context, "android.permission.ACCESS_FINE_LOCATION", rqCode);
        return true;
    }

    public final void requestPermission(Activity context, String permission, int requestCode) {
        context.getClass();
        permission.getClass();
        requestPermissions(context, new String[]{permission}, requestCode);
    }

    public final void requestPermissions(Activity context, String[] permissions, int requestCode) {
        context.getClass();
        permissions.getClass();
        try {
            context.requestPermissions(permissions, requestCode);
        } catch (Exception e) {
            Logger.logSevere(e);
        }
    }

    public final boolean shouldShowRequestPermissionRationale(Activity context, String permission) {
        context.getClass();
        permission.getClass();
        try {
            return context.shouldShowRequestPermissionRationale(permission);
        } catch (Exception e) {
            Logger.logSevere(e);
            return false;
        }
    }

    public final boolean requestLocationPermission(Activity activity, int i) {
        activity.getClass();
        return requestLocationPermission$default(this, activity, i, false, 4, null);
    }
}
