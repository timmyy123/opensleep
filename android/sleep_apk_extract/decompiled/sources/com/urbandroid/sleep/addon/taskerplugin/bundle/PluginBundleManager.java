package com.urbandroid.sleep.addon.taskerplugin.bundle;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.urbandroid.sleep.addon.taskerplugin.Constants;

/* JADX INFO: loaded from: classes4.dex */
public abstract class PluginBundleManager {
    public static Bundle generateBundle(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("com.urbandroid.sleep.taskerplugin.extra.INT_VERSION_CODE", Constants.getVersionCode(context));
        bundle.putString("com.urbandroid.sleep.taskerplugin.extra.EVENT", str);
        return bundle;
    }

    public static boolean isBundleValid(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        if (!bundle.containsKey("com.urbandroid.sleep.taskerplugin.extra.EVENT")) {
            Log.e("SleepAsAndroid", "bundle must contain extra com.urbandroid.sleep.taskerplugin.extra.EVENT");
            return false;
        }
        if (!bundle.containsKey("com.urbandroid.sleep.taskerplugin.extra.INT_VERSION_CODE")) {
            Log.e("SleepAsAndroid", "bundle must contain extra com.urbandroid.sleep.taskerplugin.extra.INT_VERSION_CODE");
            return false;
        }
        if (bundle.keySet().size() != 2) {
            Log.e("SleepAsAndroid", String.format("bundle must contain 2 keys, but currently contains %d keys: %s", Integer.valueOf(bundle.keySet().size()), bundle.keySet()));
            return false;
        }
        if (bundle.getInt("com.urbandroid.sleep.taskerplugin.extra.INT_VERSION_CODE", 0) == bundle.getInt("com.urbandroid.sleep.taskerplugin.extra.INT_VERSION_CODE", 1)) {
            return true;
        }
        Log.e("SleepAsAndroid", "bundle extra com.urbandroid.sleep.taskerplugin.extra.INT_VERSION_CODE appears to be the wrong type.  It must be an int");
        return false;
    }
}
