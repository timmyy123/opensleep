package com.urbandroid.sleep.alarmclock;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.urbandroid.sleep.alarmclock.EditActivity;
import com.urbandroid.sleep.alarmclock.UnlockFlow;
import com.urbandroid.sleep.trial.JavaBilling;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class SetAlarm$$ExternalSyntheticLambda11 implements View.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ SetAlarm$$ExternalSyntheticLambda11(Object obj, Object obj2, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.$r8$classId;
        Object obj = this.f$1;
        Object obj2 = this.f$0;
        switch (i) {
            case 0:
                ((SetAlarm) obj2).lambda$onCreatePreference$18((Button) obj, view);
                break;
            case 1:
                EditActivity.AnonymousClass1.lambda$onPostExecute$1((Activity) obj2, (EditText) obj, view);
                break;
            case 2:
                ((UnlockFlow.AnonymousClass1) obj2).lambda$onAdLoaded$2((RewardedAd) obj, view);
                break;
            case 3:
                ((EditActivity) obj2).lambda$buildActivityFromIntent$1((RatingBar) obj, view);
                break;
            default:
                ((UnlockFlow) obj2).lambda$loadPrices$20((JavaBilling) obj, view);
                break;
        }
    }
}
