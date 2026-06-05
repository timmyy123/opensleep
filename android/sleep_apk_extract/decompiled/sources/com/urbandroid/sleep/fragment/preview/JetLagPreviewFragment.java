package com.urbandroid.sleep.fragment.preview;

import android.content.Context;
import com.urbandroid.sleep.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class JetLagPreviewFragment extends AbstractPreviewFragment {
    private String r(Context context, int i) {
        return context.getString(i);
    }

    @Override // com.urbandroid.sleep.fragment.preview.AbstractPreviewFragment
    public int getLayout() {
        return R.layout.fragment_preview;
    }

    @Override // com.urbandroid.sleep.fragment.preview.AbstractPreviewFragment
    public List<PreviewPage> getPages(Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PreviewPage(null, r(context, R.string.jetlag_tutorial_1), R.color.t2a, R.color.t4, R.drawable.preview_jetlag_target, -1));
        arrayList.add(new PreviewPage(null, r(context, R.string.jetlag_tutorial_2), R.color.t2, R.color.t7a, R.drawable.preview_jetlag_calendar, R.anim.rotate));
        arrayList.add(new PreviewPage(null, r(context, R.string.jetlag_tutorial_3), R.color.t1, R.color.black, R.drawable.preview_jetlag_flash, R.anim.flash));
        arrayList.add(new PreviewPage(null, r(context, R.string.jetlag_tutorial_4), R.color.t1a, R.color.black, R.drawable.preview_jetlag_dark, R.anim.slide_down));
        arrayList.add(new PreviewPage(null, r(context, R.string.jetlag_tutorial_5), R.color.t4, R.color.black, R.drawable.preview_jetlag_mask, R.anim.slide_up_slow));
        return arrayList;
    }
}
