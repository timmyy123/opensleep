package com.urbandroid.sleep;

import android.view.View;
import com.urbandroid.sleep.SmartWatchActivity;
import com.urbandroid.sleep.smartwatch.Wearable;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class SmartWatchActivity$3$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Serializable f$0;

    public /* synthetic */ SmartWatchActivity$3$$ExternalSyntheticLambda0(Serializable serializable, int i) {
        this.$r8$classId = i;
        this.f$0 = serializable;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.$r8$classId;
        Serializable serializable = this.f$0;
        switch (i) {
            case 0:
                SmartWatchActivity.AnonymousClass3.lambda$run$0((Wearable) serializable, view);
                break;
            default:
                FirstUsePreviewActivity.onCreate$lambda$0((FirstUsePreviewActivity) serializable, view);
                break;
        }
    }
}
