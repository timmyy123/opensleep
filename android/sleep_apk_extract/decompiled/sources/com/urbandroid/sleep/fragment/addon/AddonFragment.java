package com.urbandroid.sleep.fragment.addon;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.fragment.app.FragmentActivity;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.ActivityUtils;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.domain.addon.AddonApp;
import com.urbandroid.sleep.domain.addon.AddonItem;
import com.urbandroid.sleep.domain.addon.AddonSection;
import com.urbandroid.sleep.fragment.LazyFragment;
import com.urbandroid.sleep.gui.fab.ScrollAnimator;
import com.urbandroid.sleep.service.Settings;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class AddonFragment extends LazyFragment {
    private View floating;
    private ListView list;
    private int firstVisibleItem = 0;
    private boolean singleActivity = false;
    private ScrollAnimator scrollAnimator = null;

    @Override // com.urbandroid.sleep.fragment.ILazyFragment
    public View createBaseView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_addon, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.urbandroid.sleep.fragment.ILazyFragment
    public void populateBaseView(View view, LayoutInflater layoutInflater, Bundle bundle) {
        FragmentActivity activity = getActivity();
        if (getActivity() == null) {
            return;
        }
        new Settings(activity.getApplicationContext());
        this.floating = getActivity().findViewById(R.id.fab);
        int iMin = Math.min(Math.max(ActivityUtils.getDip(view.getContext(), 36), 64), 144);
        int dip = (iMin - ActivityUtils.getDip(view.getContext(), 24)) / 2;
        ListView listView = (ListView) view.findViewById(R.id.list);
        this.list = listView;
        listView.setVerticalFadingEdgeEnabled(false);
        ArrayList arrayList = new ArrayList();
        AddonApp.Companion companion = AddonApp.INSTANCE;
        arrayList.addAll(companion.from(view.getContext(), getResources().getStringArray(R.array.addons_entries), false));
        arrayList.add(new AddonSection(getString(R.string.integrated_title)));
        List<AddonItem> listFrom = companion.from(view.getContext(), getResources().getStringArray(R.array.integrated_entries));
        if (listFrom.isEmpty()) {
            arrayList.remove(arrayList.size() - 1);
        } else {
            arrayList.addAll(listFrom);
        }
        arrayList.add(new AddonSection(getString(R.string.featured_title)));
        List<AddonItem> listFrom2 = companion.from(view.getContext(), getResources().getStringArray(R.array.featured_entries));
        if (listFrom2.isEmpty()) {
            arrayList.remove(arrayList.size() - 1);
        } else {
            arrayList.addAll(listFrom2);
        }
        arrayList.add(new AddonSection(getString(R.string.friend_title)));
        List<AddonItem> listFrom3 = companion.from(view.getContext(), getResources().getStringArray(R.array.friend_entries));
        Logger.logInfo("Addon: " + listFrom3.size());
        if (listFrom3.isEmpty()) {
            arrayList.remove(arrayList.size() - 1);
        } else {
            arrayList.addAll(listFrom3);
        }
        arrayList.add(new AddonSection(getString(R.string.addon_thanks)));
        arrayList.add(new AddonSection(""));
        this.list.setAdapter((ListAdapter) new AddonAdapter(getActivity().getApplicationContext(), arrayList, iMin, dip));
        final ImageButton imageButton = (ImageButton) view.findViewById(R.id.tab_switch_addon);
        imageButton.setVisibility(8);
        final Animation animationLoadAnimation = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), android.R.anim.fade_in);
        final Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.fade_fast);
        this.list.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.urbandroid.sleep.fragment.addon.AddonFragment.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (i > 0 && imageButton.getVisibility() != 8) {
                    imageButton.startAnimation(animationLoadAnimation2);
                    imageButton.setVisibility(8);
                } else if (i == 0 && imageButton.getVisibility() == 8) {
                    imageButton.setVisibility(0);
                    imageButton.startAnimation(animationLoadAnimation);
                }
                if (AddonFragment.this.isFramentVisible()) {
                    if (AddonFragment.this.scrollAnimator == null) {
                        AddonFragment.this.scrollAnimator = new ScrollAnimator(AddonFragment.this.getActivity(), AddonFragment.this.floating);
                    }
                    AddonFragment.this.scrollAnimator.scroll(i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                View currentFocus;
                if (1 != i || AddonFragment.this.getActivity() == null || (currentFocus = AddonFragment.this.getActivity().getCurrentFocus()) == null) {
                    return;
                }
                currentFocus.clearFocus();
            }
        });
    }
}
