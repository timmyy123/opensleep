package com.urbandroid.sleep.addon.taskerplugin.bundle;

import android.content.Intent;
import android.os.Bundle;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BundleScrubber {
    public static boolean scrub(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        try {
            bundle.containsKey(null);
            return false;
        } catch (Exception unused) {
            bundle.clear();
            return true;
        }
    }

    public static boolean scrub(Intent intent) {
        if (intent == null) {
            return false;
        }
        return scrub(intent.getExtras());
    }
}
