package com.urbandroid.common.error;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class AssertionFailureCounter {
    private final Set<Integer> assertionReportCounts;
    private final Context context;

    public AssertionFailureCounter(Context context) {
        this.context = context;
        HashSet hashSet = new HashSet();
        this.assertionReportCounts = hashSet;
        hashSet.add(1);
        hashSet.add(10);
        hashSet.add(100);
    }

    private int getPreferenceCount(AssertionType assertionType) {
        return PreferenceManager.getDefaultSharedPreferences(this.context).getInt("assertion_failed2_" + assertionType.getPreferenceCode(), 0);
    }

    private void savePreferenceCount(AssertionType assertionType, int i) {
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(this.context).edit();
        editorEdit.putInt("assertion_failed2_" + assertionType.getPreferenceCode(), i);
        editorEdit.commit();
    }

    public Integer assertionFailed(AssertionType assertionType) {
        int preferenceCount = getPreferenceCount(assertionType) + 1;
        savePreferenceCount(assertionType, preferenceCount);
        if (this.assertionReportCounts.contains(Integer.valueOf(preferenceCount))) {
            return Integer.valueOf(preferenceCount);
        }
        return null;
    }
}
