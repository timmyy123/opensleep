package com.urbandroid.sleep.gui;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import android.widget.ListView;
import com.urbandroid.common.BaseActivity;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.gui.pref.PreferenceFragment;

/* JADX INFO: loaded from: classes.dex */
public abstract class PreferenceActivity extends BaseActivity {
    private Bundle savedState;

    public static class PrefsFragment extends PreferenceFragment {
        @Override // com.urbandroid.sleep.gui.pref.PreferenceFragment, androidx.fragment.app.Fragment
        public void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);
            PreferenceActivity preferenceActivity = (PreferenceActivity) getActivity();
            int[] preferenceResources = preferenceActivity.getPreferenceResources();
            if (preferenceResources != null) {
                for (int i : preferenceResources) {
                    addPreferencesFromResource(i);
                    preferenceActivity.afterPrefAdded(i);
                }
            } else {
                addPreferencesFromResource(preferenceActivity.getPreferenceResource());
            }
            preferenceActivity.onCreatePreference(preferenceActivity.savedState);
        }

        @Override // com.urbandroid.sleep.gui.pref.PreferenceFragment, androidx.fragment.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
        }

        @Override // com.urbandroid.sleep.gui.pref.PreferenceFragment, com.urbandroid.sleep.gui.pref.PreferenceManagerCompat.OnPreferenceTreeClickListener
        public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
            return ((PreferenceActivity) getActivity()).onPreferenceTreeClick(preferenceScreen, preference);
        }
    }

    private PrefsFragment getFragment() {
        return (PrefsFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
    }

    public void afterPrefAdded(int i) {
    }

    public <T extends Preference> T findPreference(CharSequence charSequence) {
        if (getFragment() != null) {
            return (T) getFragment().findPreference(charSequence);
        }
        return null;
    }

    public abstract int getContentLayout();

    public ListView getListView() {
        if (getFragment() != null) {
            return getFragment().getListView();
        }
        return null;
    }

    public abstract int getPreferenceResource();

    public int[] getPreferenceResources() {
        return new int[]{getPreferenceResource()};
    }

    public PreferenceScreen getPreferenceScreen() {
        if (getFragment() == null) {
            return null;
        }
        return getFragment().getPreferenceScreen();
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        GlobalInitializator.initializeIfRequired(this);
        TintUtil.tint(this);
        this.savedState = bundle;
        setContentView(getContentLayout());
    }

    public abstract void onCreatePreference(Bundle bundle);

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        if (getListView() != null) {
            getListView().setVerticalFadingEdgeEnabled(false);
        }
    }

    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
        return false;
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }
}
