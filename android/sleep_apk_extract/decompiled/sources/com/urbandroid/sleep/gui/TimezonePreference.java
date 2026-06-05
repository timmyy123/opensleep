package com.urbandroid.sleep.gui;

import android.content.Context;
import android.content.res.TypedArray;
import android.preference.ListPreference;
import android.util.AttributeSet;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.gui.TimezoneList;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
public class TimezonePreference extends ListPreference {
    public TimezonePreference(Context context) {
        super(context);
        init();
    }

    private void init() {
        TimezoneList timezoneListBuild = new TimezoneList.Builder().addTimezonesWithoutNames().addTimezonesWithCityNames().build();
        setEntries(timezoneListBuild.getEntries());
        setEntryValues(timezoneListBuild.getValues());
    }

    @Override // android.preference.ListPreference, android.preference.Preference
    public CharSequence getSummary() {
        String string = getEntry() != null ? getEntry().toString() : null;
        return (string == null || string.length() == 0) ? getContext().getResources().getString(R.string.disabled) : string;
    }

    @Override // android.preference.ListPreference, android.preference.Preference
    public Object onGetDefaultValue(TypedArray typedArray, int i) {
        String string = typedArray.getString(i);
        return (string == null || string.length() == 0) ? Calendar.getInstance().getTimeZone().getID() : string;
    }

    public TimezonePreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }
}
