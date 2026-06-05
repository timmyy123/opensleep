package com.urbandroid.sleep.fragment.dashboard;

import android.os.Bundle;
import android.preference.Preference;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import androidx.fragment.app.FragmentActivity;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.fragment.ILazyFragment;
import com.urbandroid.sleep.gui.fab.ScrollAnimator;
import com.urbandroid.sleep.gui.pref.PreferenceFragment;
import com.urbandroid.sleep.service.SharedApplicationContext;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000f\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u000f\u0010\rJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0014\u0010\u0004R$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/TabTuneFragment;", "Lcom/urbandroid/sleep/gui/pref/PreferenceFragment;", "Lcom/urbandroid/sleep/fragment/ILazyFragment;", "<init>", "()V", "Landroid/preference/Preference;", "p", "", InAppPurchaseConstants.METHOD_SET_LISTENER, "(Landroid/preference/Preference;)V", "Landroid/os/Bundle;", "paramBundle", "onCreate", "(Landroid/os/Bundle;)V", "savedInstanceState", "onActivityCreated", "", "isAlreadyLoaded", "()Z", "setVisible", "setInvisible", "Lcom/urbandroid/sleep/gui/fab/ScrollAnimator;", "scrollAnimator", "Lcom/urbandroid/sleep/gui/fab/ScrollAnimator;", "getScrollAnimator", "()Lcom/urbandroid/sleep/gui/fab/ScrollAnimator;", "setScrollAnimator", "(Lcom/urbandroid/sleep/gui/fab/ScrollAnimator;)V", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class TabTuneFragment extends PreferenceFragment implements ILazyFragment {
    private ScrollAnimator scrollAnimator;

    private final void setListener(Preference p) {
        Logger.logInfo("Tab: " + p.getKey());
        p.setOnPreferenceChangeListener(new TabTuneFragment$$ExternalSyntheticLambda0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setListener$lambda$0(Preference preference, Object obj) {
        if (SharedApplicationContext.getSettings().getTabCount() == 1) {
            obj.getClass();
            if (!((Boolean) obj).booleanValue()) {
                return false;
            }
        }
        SharedApplicationContext.getSettings().setActiveTab(0);
        return true;
    }

    public final ScrollAnimator getScrollAnimator() {
        return this.scrollAnimator;
    }

    @Override // com.urbandroid.sleep.fragment.ILazyFragment
    public boolean isAlreadyLoaded() {
        return true;
    }

    @Override // com.urbandroid.sleep.gui.pref.PreferenceFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ListView listView = getListView();
        if (listView != null) {
            listView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.urbandroid.sleep.fragment.dashboard.TabTuneFragment.onActivityCreated.1
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    absListView.getClass();
                    FragmentActivity activity = TabTuneFragment.this.getActivity();
                    if (activity != null) {
                        TabTuneFragment tabTuneFragment = TabTuneFragment.this;
                        FragmentActivity activity2 = tabTuneFragment.getActivity();
                        View viewFindViewById = activity2 != null ? activity2.findViewById(R.id.fab) : null;
                        if (tabTuneFragment.getScrollAnimator() == null) {
                            tabTuneFragment.setScrollAnimator(new ScrollAnimator(activity, viewFindViewById, 0, false, 12, null));
                        }
                        ScrollAnimator scrollAnimator = tabTuneFragment.getScrollAnimator();
                        if (scrollAnimator != null) {
                            scrollAnimator.scroll(i);
                        }
                    }
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int scrollState) {
                    absListView.getClass();
                }
            });
        }
    }

    @Override // com.urbandroid.sleep.gui.pref.PreferenceFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        addPreferencesFromResource(R.xml.settings_tabs);
        Preference preferenceFindPreference = findPreference("tab_dashboard");
        preferenceFindPreference.getClass();
        setListener(preferenceFindPreference);
        Preference preferenceFindPreference2 = findPreference("tab_stats");
        preferenceFindPreference2.getClass();
        setListener(preferenceFindPreference2);
        Preference preferenceFindPreference3 = findPreference("tab_noise");
        preferenceFindPreference3.getClass();
        setListener(preferenceFindPreference3);
        Preference preferenceFindPreference4 = findPreference("tab_graphs");
        preferenceFindPreference4.getClass();
        setListener(preferenceFindPreference4);
    }

    @Override // com.urbandroid.sleep.fragment.ILazyFragment
    public void setInvisible() {
    }

    public final void setScrollAnimator(ScrollAnimator scrollAnimator) {
        this.scrollAnimator = scrollAnimator;
    }

    @Override // com.urbandroid.sleep.fragment.ILazyFragment
    public void setVisible() {
    }
}
