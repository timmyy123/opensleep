package com.urbandroid.sleep.alarmclock.directorypicker;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.urbandroid.common.logging.Logger;

/* JADX INFO: loaded from: classes4.dex */
public abstract class DirectoryPicker {
    public static boolean isOpenDocumentTreeAvailable(Context context) {
        Intent intentPrepareIntent = prepareIntent(context);
        Logger.logInfo("DirectoryPicker: " + intentPrepareIntent);
        ComponentName componentNameResolveActivity = intentPrepareIntent.resolveActivity(context.getPackageManager());
        Logger.logInfo("DirectoryPicker: " + componentNameResolveActivity);
        return componentNameResolveActivity != null || Build.VERSION.SDK_INT >= 30;
    }

    public static void open(Activity activity, int i) {
        activity.startActivityForResult(prepareIntent(activity), i);
    }

    public static Uri parseDirectoryPicked(Context context, Intent intent) {
        Uri data2 = intent.getData();
        Logger.logInfo("Dir/File picked: " + data2);
        context.getContentResolver().takePersistableUriPermission(data2, intent.getFlags() & 3);
        return data2;
    }

    private static Intent prepareIntent(Context context) {
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
        intent.putExtra("android.content.extra.SHOW_ADVANCED", true);
        return intent;
    }
}
