package com.urbandroid.common.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.ListPreference;
import com.facebook.appevents.AppEventsConstants;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.util.Experiments;
import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
public abstract class PreferencesUtils {
    public static final Long INVALID_TIME = -1L;

    public static void expandVibrationsPreference(Context context, ListPreference listPreference) {
        CharSequence[] entries = listPreference.getEntries();
        CharSequence[] entryValues = listPreference.getEntryValues();
        int length = entries.length + 1;
        CharSequence[] charSequenceArr = new CharSequence[length];
        CharSequence[] charSequenceArr2 = new CharSequence[entryValues.length + 1];
        charSequenceArr[0] = entries[0];
        charSequenceArr2[0] = entryValues[0];
        System.arraycopy(entries, 1, charSequenceArr, 2, entries.length - 1);
        System.arraycopy(entryValues, 1, charSequenceArr2, 2, entryValues.length - 1);
        charSequenceArr[1] = context.getString(R.string.from_start);
        charSequenceArr2[1] = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        for (int i = 2; i < length; i++) {
            charSequenceArr[i] = context.getString(R.string.after_time, charSequenceArr[i]);
        }
        listPreference.setEntries(charSequenceArr);
        listPreference.setEntryValues(charSequenceArr2);
    }

    public static boolean getBillStatus(Context context) {
        try {
            return context.getSharedPreferences("TVF", 0).getLong("BS", 13L) == 42;
        } catch (Exception e) {
            Logger.logSevere(e);
            return true;
        }
    }

    private static long getChecksum(long j) {
        return ((Math.abs(j - 6) * (j % 17)) / 19) + 11;
    }

    public static boolean hadEverSamsung(Context context) {
        return context.getSharedPreferences("TVF", 0).getLong("HSMSG", 89L) == 33;
    }

    public static boolean hadEverUnlock(Context context) {
        return context.getSharedPreferences("TVF", 0).getLong("HUNLK", 89L) == 33;
    }

    public static boolean isBillStatusSetToSomething(Context context) {
        long j = context.getSharedPreferences("TVF", 0).getLong("BS", 13L);
        return j == 42 || j == 17;
    }

    public static boolean isCloudPremiumStatus(Context context) {
        return Experiments.getInstance().isOurExperimentalPhone() || context.getSharedPreferences("TVF", 0).getLong("CP", 13L) == 42;
    }

    public static boolean isCloudPremiumStatusUnknown(Context context) {
        return !Experiments.getInstance().isOurExperimentalPhone() && context.getSharedPreferences("TVF", 0).getLong("CP", 13L) == 13;
    }

    public static boolean isUnlockAcked(Context context) {
        return context.getSharedPreferences("TVF", 0).getLong("UNLKACK", 55L) == 66;
    }

    public static Long loadFirstUseTime(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("TVF", 0);
        long jLongValue = sharedPreferences.getLong("TTM", 0L);
        long j = sharedPreferences.getLong("CCS", 0L);
        Logger.logInfo("Loading first time " + jLongValue);
        if (jLongValue == 0) {
            return null;
        }
        if (j != getChecksum(jLongValue)) {
            jLongValue = INVALID_TIME.longValue();
        }
        return Long.valueOf(jLongValue);
    }

    public static void setHadSamsungVersion(Context context) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("TVF", 0).edit();
        editorEdit.putLong("HSMSG", 33L);
        editorEdit.commit();
    }

    public static void setHadUnlock(Context context) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("TVF", 0).edit();
        editorEdit.putLong("HUNLK", 33L);
        editorEdit.commit();
    }

    public static void setUnlockAck(Context context) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("TVF", 0).edit();
        editorEdit.putLong("UNLKACK", 66L);
        editorEdit.commit();
    }

    public static void storeBillStatus(Context context, boolean z) {
        Logger.logInfo("INAPP: store bill status " + z);
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("TVF", 0).edit();
        editorEdit.putLong("BS", z ? 42L : 17L);
        editorEdit.apply();
    }

    public static void storeCloudPremiumStatus(Context context, boolean z) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("TVF", 0).edit();
        editorEdit.putLong("CP", z ? 42L : 17L);
        editorEdit.commit();
    }

    public static void storeCloudPremiumStatusUnknown(Context context) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("TVF", 0).edit();
        editorEdit.putLong("CP", 13L);
        editorEdit.commit();
    }

    public static long storeFirstUseTime(Context context) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("TVF", 0).edit();
        long time = new Date().getTime();
        long checksum = getChecksum(time);
        Logger.logInfo("Storing first time " + time);
        editorEdit.putLong("TTM", time);
        editorEdit.putLong("CCS", checksum);
        editorEdit.commit();
        return time;
    }
}
