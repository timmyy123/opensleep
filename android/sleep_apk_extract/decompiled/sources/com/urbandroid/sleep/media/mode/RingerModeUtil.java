package com.urbandroid.sleep.media.mode;

import android.content.Context;
import android.media.AudioManager;
import android.provider.Settings;
import com.urbandroid.common.logging.Logger;

/* JADX INFO: loaded from: classes4.dex */
public abstract class RingerModeUtil {
    private static int getMode(Context context) {
        return ((AudioManager) context.getSystemService("audio")).getRingerMode();
    }

    public static boolean isModeSilent(Context context) {
        return getMode(context) == 0;
    }

    public static boolean isStreamInSilent(Context context, int i) {
        boolean z = (Settings.System.getInt(context.getContentResolver(), "mode_ringer_streams_affected", 0) & (1 << i)) == 0;
        Logger.logDebug("RingerModeUtil: Stream hearable in silent " + z + " stream: " + i);
        return z;
    }

    public static void resetAlarmSilentSettings(Context context, com.urbandroid.sleep.service.Settings settings, int i) {
        if (!settings.isAlarmInSilent() || isStreamInSilent(context, i)) {
            return;
        }
        setStreamInSilent(context, true, i);
    }

    public static void setStreamInSilent(Context context, boolean z, int i) {
        int i2 = 1 << i;
        int i3 = Settings.System.getInt(context.getContentResolver(), "mode_ringer_streams_affected", 0);
        int i4 = z ? (~i2) & i3 : i2 | i3;
        Logger.logDebug("RingerModeUtil: RingerMode " + i4 + " " + z + " stream " + i);
        try {
            Settings.System.putInt(context.getContentResolver(), "mode_ringer_streams_affected", i4);
        } catch (SecurityException unused) {
            Logger.logDebug("RingerModeUtil: no permission to set stream in silent");
        }
    }

    public static void resetAlarmSilentSettings(Context context, com.urbandroid.sleep.service.Settings settings) {
        resetAlarmSilentSettings(context, settings, 4);
    }
}
