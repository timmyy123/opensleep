package com.urbandroid.sleep.alarmclock.settings;

import android.content.Context;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.fragment.preview.AbstractPreviewFragment;
import com.urbandroid.sleep.fragment.preview.PreviewPage;
import com.urbandroid.sleep.service.SharedApplicationContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class NoEscapeFragment extends AbstractPreviewFragment implements Serializable {
    private String r(Context context, int i) {
        return context.getString(i);
    }

    @Override // com.urbandroid.sleep.fragment.preview.AbstractPreviewFragment
    public int getLayout() {
        return R.layout.fragment_preview_no_escape;
    }

    @Override // com.urbandroid.sleep.fragment.preview.AbstractPreviewFragment
    public List<PreviewPage> getPages(Context context) {
        ArrayList arrayList = new ArrayList();
        NoEscapeManager noEscapeManager = new NoEscapeManager(getActivity());
        if (!noEscapeManager.isOverlayEnabled() && SharedApplicationContext.getSettings().isCaptchaNoEscape()) {
            arrayList.add(new PreviewPage(r(context, R.string.permission_overlay), r(context, R.string.overlay_permission_captcha), R.color.t1, R.color.t1a, R.drawable.preview_permission, R.anim.click) { // from class: com.urbandroid.sleep.alarmclock.settings.NoEscapeFragment.1
                @Override // com.urbandroid.sleep.fragment.preview.PreviewPage
                public void action() {
                    new NoEscapeManager(NoEscapeFragment.this.getActivity()).showOverlayDialog(1);
                }
            }.setLayout(R.layout.fragment_preview_page_no_escape).setImageRes(R.drawable.preview_permission));
        }
        if (!noEscapeManager.isAccessibilityEnabled() && SharedApplicationContext.getSettings().isCaptchaNoEscape()) {
            arrayList.add(new PreviewPage(r(context, R.string.permission_accessibility), r(context, R.string.power_off_protection_accessibility_justification), R.color.t2, R.color.t7, R.drawable.preview_permission, R.anim.click) { // from class: com.urbandroid.sleep.alarmclock.settings.NoEscapeFragment.2
                @Override // com.urbandroid.sleep.fragment.preview.PreviewPage
                public void action() {
                    new NoEscapeManager(NoEscapeFragment.this.getActivity()).showAccessibilityDialog(1);
                }
            }.setLayout(R.layout.fragment_preview_page_no_escape).setImageRes(R.drawable.preview_permission));
        }
        if (!noEscapeManager.isDeviceAdminEnabled() && SharedApplicationContext.getSettings().isCaptchaNoEscape()) {
            arrayList.add(new PreviewPage(r(context, R.string.permission_device_admin), r(context, R.string.captcha_no_escape_justification), R.color.t4, R.color.t1a, R.drawable.preview_permission, R.anim.click) { // from class: com.urbandroid.sleep.alarmclock.settings.NoEscapeFragment.3
                @Override // com.urbandroid.sleep.fragment.preview.PreviewPage
                public void action() {
                    new NoEscapeManager(NoEscapeFragment.this.getActivity()).showDeviceAdminDialog(1);
                }
            }.setLayout(R.layout.fragment_preview_page_no_escape).setImageRes(R.drawable.preview_permission));
        }
        return arrayList;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }
}
