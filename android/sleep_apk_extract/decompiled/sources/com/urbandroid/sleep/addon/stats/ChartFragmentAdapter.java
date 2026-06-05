package com.urbandroid.sleep.addon.stats;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.service.Settings;

/* JADX INFO: loaded from: classes4.dex */
public class ChartFragmentAdapter extends FragmentPagerAdapter {
    private Context context;

    public ChartFragmentAdapter(FragmentManager fragmentManager, Context context) {
        super(fragmentManager);
        this.context = context;
    }

    private int[] getTabTitles() {
        return new Settings(this.context).getCurrentGoal() != null ? new int[]{R.string.trend, R.string.tag, R.string.chronotype, R.string.advice, R.string.goal} : new int[]{R.string.trend, R.string.tag, R.string.chronotype, R.string.advice};
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return getTabTitles().length;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        return ChartFragment.newInstance(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        return -1;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.context.getString(getTabTitles()[i]).toUpperCase();
    }
}
