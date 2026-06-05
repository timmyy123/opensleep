package com.urbandroid.sleep;

import android.content.Context;
import android.net.Uri;
import java.io.File;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"com/urbandroid/sleep/SleepUtils__SleepCommonsKt"}, k = 4, mv = {2, 3, 0}, xi = 48)
public abstract class SleepUtils {
    public static final Uri getActualDefaultRingtoneUri(Context context) {
        return SleepUtils__SleepCommonsKt.getActualDefaultRingtoneUri(context);
    }

    public static final boolean isOurExperimentalPhone() {
        return SleepUtils__SleepCommonsKt.isOurExperimentalPhone();
    }

    public static final String md5(String str) {
        return SleepUtils__SleepCommonsKt.md5(str);
    }

    public static final Uri toUri(File file, Context context) {
        return SleepUtils__SleepCommonsKt.toUri(file, context);
    }
}
