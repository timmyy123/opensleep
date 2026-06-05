package com.urbandroid.sleep.fragment.preview;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;
import com.urbandroid.common.util.Environment;
import com.urbandroid.sleep.R;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractPreviewFragment extends Fragment {
    protected ViewPager vp;

    public abstract int getLayout();

    public abstract List<PreviewPage> getPages(Context context);

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        DotsIndicator dotsIndicator;
        View viewInflate = layoutInflater.inflate(getLayout(), viewGroup, false);
        ViewPager viewPager = (ViewPager) viewInflate.findViewById(R.id.viewpager);
        this.vp = viewPager;
        viewPager.setAdapter(new PreviewPagerAdapter(getActivity().getSupportFragmentManager(), getPages(viewInflate.getContext())));
        if (Environment.isIcsOrGreater()) {
            ViewGroup viewGroup2 = (ViewGroup) viewInflate.findViewById(R.id.indicator_placeholder);
            if (viewInflate.findViewById(R.id.indicator) != null) {
                dotsIndicator = (DotsIndicator) viewInflate.findViewById(R.id.indicator);
            } else {
                DotsIndicator dotsIndicator2 = new DotsIndicator(getContext());
                viewGroup2.addView(dotsIndicator2);
                dotsIndicator = dotsIndicator2;
            }
            dotsIndicator.setViewPager(this.vp);
        }
        return viewInflate;
    }
}
