package com.urbandroid.sleep.captcha;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class NFCCaptcha$$ExternalSyntheticLambda0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ BaseScanningCaptcha f$0;

    public /* synthetic */ NFCCaptcha$$ExternalSyntheticLambda0(BaseScanningCaptcha baseScanningCaptcha, int i) {
        this.$r8$classId = i;
        this.f$0 = baseScanningCaptcha;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        int i2 = this.$r8$classId;
        BaseScanningCaptcha baseScanningCaptcha = this.f$0;
        switch (i2) {
            case 0:
                ((NFCCaptcha) baseScanningCaptcha).lambda$onCreateDialog$0(dialogInterface, i);
                break;
            case 1:
                ((NFCCaptcha) baseScanningCaptcha).lambda$onCreateDialog$1(dialogInterface, i);
                break;
            default:
                baseScanningCaptcha.lambda$onRequestPermissionsResult$6(dialogInterface, i);
                break;
        }
    }
}
