package com.urbandroid.sleep;

import android.content.DialogInterface;
import com.urbandroid.common.BaseActivity;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class Sleep$$ExternalSyntheticLambda0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ BaseActivity f$0;

    public /* synthetic */ Sleep$$ExternalSyntheticLambda0(BaseActivity baseActivity, int i) {
        this.$r8$classId = i;
        this.f$0 = baseActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        int i2 = this.$r8$classId;
        BaseActivity baseActivity = this.f$0;
        switch (i2) {
            case 0:
                ((Sleep) baseActivity).lambda$notifyAboutBluetoothIfRequired$4(dialogInterface, i);
                break;
            default:
                FirstUsePreviewActivity.skip$lambda$0((FirstUsePreviewActivity) baseActivity, dialogInterface, i);
                break;
        }
    }
}
