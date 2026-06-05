package com.airbnb.lottie;

import android.os.Build;
import com.airbnb.lottie.utils.Logger;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
class LottieFeatureFlags {
    private final HashSet<LottieFeatureFlag> enabledFlags = new HashSet<>();

    public boolean enableFlag(LottieFeatureFlag lottieFeatureFlag, boolean z) {
        if (!z) {
            return this.enabledFlags.remove(lottieFeatureFlag);
        }
        if (Build.VERSION.SDK_INT >= lottieFeatureFlag.minRequiredSdkVersion) {
            return this.enabledFlags.add(lottieFeatureFlag);
        }
        Logger.warning(String.format("%s is not supported pre SDK %d", lottieFeatureFlag.name(), Integer.valueOf(lottieFeatureFlag.minRequiredSdkVersion)));
        return false;
    }

    public boolean isFlagEnabled(LottieFeatureFlag lottieFeatureFlag) {
        return this.enabledFlags.contains(lottieFeatureFlag);
    }
}
