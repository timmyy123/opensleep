package com.urbandroid.sleep.gui.pref;

import android.content.Context;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import android.util.AttributeSet;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.service.Settings;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class LamerPreferenceCategory extends HelpPreferenceCategory {
    private int expanded;
    private List<Preference> removedPreferences;
    private int showTitle;

    public LamerPreferenceCategory(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.expanded = 1;
        this.showTitle = 0;
        this.removedPreferences = new ArrayList();
        handleAttributes(attributeSet);
    }

    private void handleAttributes(AttributeSet attributeSet) {
        for (int i = 0; i < attributeSet.getAttributeCount(); i++) {
            String attributeName = attributeSet.getAttributeName(i);
            String attributeValue = attributeSet.getAttributeValue(i);
            if (attributeName.equalsIgnoreCase("show")) {
                this.expanded = Integer.parseInt(attributeValue);
            }
            if (attributeName.equalsIgnoreCase("showTitle")) {
                this.showTitle = Integer.parseInt(attributeValue);
            }
        }
    }

    public static void init(Context context, PreferenceScreen preferenceScreen, boolean z, String... strArr) {
        for (String str : strArr) {
            Preference preferenceFindPreference = preferenceScreen.findPreference(str);
            if (preferenceFindPreference instanceof LamerPreferenceCategory) {
                LamerPreferenceCategory lamerPreferenceCategory = (LamerPreferenceCategory) preferenceFindPreference;
                if (z) {
                    lamerPreferenceCategory.inactivate();
                } else {
                    lamerPreferenceCategory.collapse();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$collapse$0(Preference preference) {
        expand();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$expand$1(Preference preference) {
        collapse();
        return true;
    }

    public void collapse(int i) {
        this.expanded = i;
        int preferenceCount = getPreferenceCount() - 1;
        Preference preference = getPreference(preferenceCount);
        if (this.showTitle > 0) {
            preference.setTitle(getContext().getString(R.string.settings_category_advanced));
        } else {
            preference.setTitle((CharSequence) null);
        }
        preference.setIcon(R.drawable.arrow_down);
        int i2 = 0;
        preference.setOnPreferenceClickListener(new LamerPreferenceCategory$$ExternalSyntheticLambda0(this, i2));
        while (i2 < preferenceCount) {
            if (i2 >= i) {
                this.removedPreferences.add(getPreference(i2));
            }
            i2++;
        }
        StringBuilder sb = new StringBuilder();
        String str = "";
        for (Preference preference2 : this.removedPreferences) {
            removePreference(preference2);
            if (preference2.getTitle() != null) {
                sb.append(str);
                sb.append(preference2.getTitle());
                str = ", ";
            }
        }
        preference.setSummary(sb.toString());
    }

    public void expand() {
        Iterator<Preference> it = this.removedPreferences.iterator();
        while (it.hasNext()) {
            addPreference(it.next());
        }
        this.removedPreferences.clear();
        Preference preference = getPreference(getPreferenceCount() - 1);
        preference.setTitle(getContext().getString(R.string.hide));
        preference.setSummary("");
        preference.setIcon(R.drawable.arrow_up);
        preference.setOnPreferenceClickListener(new LamerPreferenceCategory$$ExternalSyntheticLambda0(this, 1));
    }

    public void inactivate() {
        int preferenceCount = getPreferenceCount();
        if (preferenceCount > 0) {
            Preference preference = getPreference(preferenceCount - 1);
            if (preference.getTitle() == null || !"Advance settings".equals(preference.getTitle().toString())) {
                return;
            }
            removePreference(preference);
        }
    }

    public void setExpanded(int i) {
        this.expanded = i;
    }

    public LamerPreferenceCategory(Context context) {
        super(context);
        this.expanded = 1;
        this.showTitle = 0;
        this.removedPreferences = new ArrayList();
    }

    public LamerPreferenceCategory(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.expanded = 1;
        this.showTitle = 0;
        this.removedPreferences = new ArrayList();
        handleAttributes(attributeSet);
    }

    public LamerPreferenceCategory(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.expanded = 1;
        this.showTitle = 0;
        this.removedPreferences = new ArrayList();
        handleAttributes(attributeSet);
    }

    public static void init(Context context, PreferenceScreen preferenceScreen, String... strArr) {
        init(context, preferenceScreen, new Settings(context).isExpandAllSettings(), strArr);
    }

    public void collapse() {
        collapse(this.expanded);
    }
}
