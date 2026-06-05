package com.urbandroid.sleep;

import android.view.View;
import androidx.view.result.ActivityResultLauncher;
import com.urbandroid.sleep.PreviewActivity;
import com.urbandroid.sleep.fragment.preview.PreviewPage;
import com.urbandroid.sleep.service.PrefStore;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class PreviewActivity$onCreate$1$$ExternalSyntheticLambda1 implements View.OnClickListener {
    public final /* synthetic */ int $r8$classId = 1;
    public final /* synthetic */ PreviewPage f$0;
    public final /* synthetic */ PreviewActivity f$1;
    public final /* synthetic */ int f$2;
    public final /* synthetic */ Object f$3;

    public /* synthetic */ PreviewActivity$onCreate$1$$ExternalSyntheticLambda1(PreviewActivity previewActivity, PreviewPage previewPage, ActivityResultLauncher activityResultLauncher, int i) {
        this.f$1 = previewActivity;
        this.f$0 = previewPage;
        this.f$3 = activityResultLauncher;
        this.f$2 = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.$r8$classId;
        int i2 = this.f$2;
        Object obj = this.f$3;
        PreviewPage previewPage = this.f$0;
        PreviewActivity previewActivity = this.f$1;
        switch (i) {
            case 0:
                PreviewActivity.AnonymousClass1.onPageSelected$lambda$0$2(previewPage, previewActivity, i2, (PrefStore) obj, view);
                break;
            default:
                PreviewActivity.AnonymousClass1.onPageSelected$lambda$0$3(previewActivity, previewPage, (ActivityResultLauncher) obj, i2, view);
                break;
        }
    }

    public /* synthetic */ PreviewActivity$onCreate$1$$ExternalSyntheticLambda1(PreviewActivity previewActivity, PrefStore prefStore, PreviewPage previewPage, int i) {
        this.f$0 = previewPage;
        this.f$1 = previewActivity;
        this.f$2 = i;
        this.f$3 = prefStore;
    }
}
