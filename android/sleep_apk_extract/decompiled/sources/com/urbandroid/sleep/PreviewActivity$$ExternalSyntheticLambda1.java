package com.urbandroid.sleep;

import com.urbandroid.sleep.fragment.preview.PreviewPageFragment;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class PreviewActivity$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ PreviewActivity$$ExternalSyntheticLambda1(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.$r8$classId;
        Object obj = this.f$0;
        switch (i) {
            case 0:
                PreviewActivity.onCreate$lambda$1((PreviewActivity) obj);
                break;
            case 1:
                FirstUsePreviewActivity.onStart$lambda$0((FirstUsePreviewActivity) obj);
                break;
            case 2:
                ((PreviewPageFragment) obj).animateFirst();
                break;
            default:
                ((QuickStartPreviewActivity) obj).lambda$onStart$0();
                break;
        }
    }
}
