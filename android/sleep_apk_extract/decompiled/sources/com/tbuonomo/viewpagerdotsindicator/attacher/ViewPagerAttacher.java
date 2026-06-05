package com.tbuonomo.viewpagerdotsindicator.attacher;

import android.database.DataSetObserver;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tbuonomo.viewpagerdotsindicator.BaseDotsIndicator;
import com.tbuonomo.viewpagerdotsindicator.ExtensionsKt;
import com.tbuonomo.viewpagerdotsindicator.OnPageChangeListenerHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0003H\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J&\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/tbuonomo/viewpagerdotsindicator/attacher/ViewPagerAttacher;", "Lcom/tbuonomo/viewpagerdotsindicator/attacher/DotsIndicatorAttacher;", "Landroidx/viewpager/widget/ViewPager;", "Landroidx/viewpager/widget/PagerAdapter;", "()V", "buildPager", "Lcom/tbuonomo/viewpagerdotsindicator/BaseDotsIndicator$Pager;", "attachable", "adapter", "getAdapterFromAttachable", "registerAdapterDataChangedObserver", "", "onChanged", "Lkotlin/Function0;", "viewpagerdotsindicator_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ViewPagerAttacher extends DotsIndicatorAttacher<ViewPager, PagerAdapter> {
    @Override // com.tbuonomo.viewpagerdotsindicator.attacher.DotsIndicatorAttacher
    public BaseDotsIndicator.Pager buildPager(final ViewPager attachable, PagerAdapter adapter) {
        attachable.getClass();
        adapter.getClass();
        return new BaseDotsIndicator.Pager() { // from class: com.tbuonomo.viewpagerdotsindicator.attacher.ViewPagerAttacher.buildPager.1
            private ViewPager.OnPageChangeListener onPageChangeListener;

            @Override // com.tbuonomo.viewpagerdotsindicator.BaseDotsIndicator.Pager
            public void addOnPageChangeListener(final OnPageChangeListenerHelper onPageChangeListenerHelper) {
                onPageChangeListenerHelper.getClass();
                ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.tbuonomo.viewpagerdotsindicator.attacher.ViewPagerAttacher$buildPager$1$addOnPageChangeListener$1
                    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                    public void onPageScrollStateChanged(int state) {
                    }

                    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                        onPageChangeListenerHelper.onPageScrolled(position, positionOffset);
                    }

                    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                    public void onPageSelected(int position) {
                    }
                };
                this.onPageChangeListener = onPageChangeListener;
                attachable.addOnPageChangeListener(onPageChangeListener);
            }

            @Override // com.tbuonomo.viewpagerdotsindicator.BaseDotsIndicator.Pager
            public int getCount() {
                PagerAdapter adapter2 = attachable.getAdapter();
                if (adapter2 != null) {
                    return adapter2.getCount();
                }
                return 0;
            }

            @Override // com.tbuonomo.viewpagerdotsindicator.BaseDotsIndicator.Pager
            public int getCurrentItem() {
                return attachable.getCurrentItem();
            }

            @Override // com.tbuonomo.viewpagerdotsindicator.BaseDotsIndicator.Pager
            public boolean isNotEmpty() {
                return ExtensionsKt.isNotEmpty(attachable);
            }

            @Override // com.tbuonomo.viewpagerdotsindicator.BaseDotsIndicator.Pager
            public void removeOnPageChangeListener() {
                ViewPager.OnPageChangeListener onPageChangeListener = this.onPageChangeListener;
                if (onPageChangeListener != null) {
                    attachable.removeOnPageChangeListener(onPageChangeListener);
                }
            }

            @Override // com.tbuonomo.viewpagerdotsindicator.BaseDotsIndicator.Pager
            public void setCurrentItem(int item, boolean smoothScroll) {
                attachable.setCurrentItem(item, smoothScroll);
            }
        };
    }

    @Override // com.tbuonomo.viewpagerdotsindicator.attacher.DotsIndicatorAttacher
    public PagerAdapter getAdapterFromAttachable(ViewPager attachable) {
        attachable.getClass();
        return attachable.getAdapter();
    }

    /* JADX INFO: renamed from: registerAdapterDataChangedObserver, reason: avoid collision after fix types in other method */
    public void registerAdapterDataChangedObserver2(ViewPager attachable, PagerAdapter adapter, final Function0<Unit> onChanged) {
        attachable.getClass();
        adapter.getClass();
        onChanged.getClass();
        adapter.registerDataSetObserver(new DataSetObserver() { // from class: com.tbuonomo.viewpagerdotsindicator.attacher.ViewPagerAttacher.registerAdapterDataChangedObserver.1
            @Override // android.database.DataSetObserver
            public void onChanged() {
                super.onChanged();
                onChanged.invoke();
            }
        });
    }

    @Override // com.tbuonomo.viewpagerdotsindicator.attacher.DotsIndicatorAttacher
    public /* bridge */ /* synthetic */ void registerAdapterDataChangedObserver(ViewPager viewPager, PagerAdapter pagerAdapter, Function0 function0) {
        registerAdapterDataChangedObserver2(viewPager, pagerAdapter, (Function0<Unit>) function0);
    }
}
