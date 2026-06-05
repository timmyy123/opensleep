package com.urbandroid.sleep.captcha;

import androidx.core.content.res.ResourcesCompat;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.sidesheet.SideSheetBehavior;
import com.urbandroid.sleep.alarmclock.AlarmClock;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class LOLCaptcha$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ int f$1;

    public /* synthetic */ LOLCaptcha$$ExternalSyntheticLambda2(Object obj, int i, int i2) {
        this.$r8$classId = i2;
        this.f$0 = obj;
        this.f$1 = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.$r8$classId;
        int i2 = this.f$1;
        Object obj = this.f$0;
        switch (i) {
            case 0:
                LOLCaptcha.displayWarning$lambda$0((LOLCaptcha) obj, i2);
                break;
            case 1:
                ((ResourcesCompat.FontCallback) obj).lambda$callbackFailAsync$1(i2);
                break;
            case 2:
                ((MaterialButton) obj).lambda$setIconSize$1(i2);
                break;
            case 3:
                ((SideSheetBehavior) obj).lambda$setState$0(i2);
                break;
            default:
                ((AlarmClock) obj).lambda$onCreate$3(i2);
                break;
        }
    }
}
