package com.urbandroid.sleep.fragment.preview;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/urbandroid/sleep/fragment/preview/PreviewPagerAdapter;", "Landroidx/fragment/app/FragmentStatePagerAdapter;", "Landroidx/fragment/app/FragmentManager;", "fm", "", "Lcom/urbandroid/sleep/fragment/preview/PreviewPage;", "pages", "<init>", "(Landroidx/fragment/app/FragmentManager;Ljava/util/List;)V", "", "position", "Landroidx/fragment/app/Fragment;", "getItem", "(I)Landroidx/fragment/app/Fragment;", "getCount", "()I", "Ljava/util/List;", "getPages", "()Ljava/util/List;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PreviewPagerAdapter extends FragmentStatePagerAdapter {
    private final List<PreviewPage> pages;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreviewPagerAdapter(FragmentManager fragmentManager, List<PreviewPage> list) {
        super(fragmentManager, 1);
        fragmentManager.getClass();
        list.getClass();
        this.pages = list;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.pages.size();
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int position) {
        PreviewPageFragment previewPageFragment = new PreviewPageFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("page", this.pages.get(position));
        previewPageFragment.setArguments(bundle);
        return previewPageFragment;
    }

    public final List<PreviewPage> getPages() {
        return this.pages;
    }
}
