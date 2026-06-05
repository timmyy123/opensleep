package com.urbandroid.sleep.fragment.preview;

import android.content.Context;
import com.urbandroid.sleep.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class NFCTagPreviewFragment extends AbstractPreviewFragment {
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
        arrayList.add(new PreviewPage("1.", r(context, R.string.captcha_nfc_tutorial1), R.color.t2a, R.color.black, R.drawable.preview_captcha_nfc, -1));
        arrayList.add(new PreviewPage("2.", r(context, R.string.captcha_nfc_tutorial3), R.color.positive_dark, R.color.black, R.drawable.preview_captcha_nfc_3, R.anim.click));
        arrayList.add(new PreviewPage("3.", r(context, R.string.captcha_nfc_tutorial2), R.color.t3, R.color.black, R.drawable.preview_captcha_nfc_2, R.anim.fly_in));
        arrayList.add(new PreviewPage("4.", r(context, R.string.captcha_nfc_tutorial4), R.color.dred, R.color.black, R.drawable.preview_captcha_nfc_3, R.anim.click));
        return arrayList;
    }
}
