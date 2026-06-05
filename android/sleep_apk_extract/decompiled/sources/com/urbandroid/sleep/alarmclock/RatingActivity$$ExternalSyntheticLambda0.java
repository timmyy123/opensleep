package com.urbandroid.sleep.alarmclock;

import android.view.View;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class RatingActivity$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ RatingActivity f$0;

    public /* synthetic */ RatingActivity$$ExternalSyntheticLambda0(RatingActivity ratingActivity, int i) {
        this.$r8$classId = i;
        this.f$0 = ratingActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.$r8$classId;
        RatingActivity ratingActivity = this.f$0;
        switch (i) {
            case 0:
                ratingActivity.lambda$buildActivityFromIntent$0(view);
                break;
            case 1:
                ratingActivity.lambda$buildActivityFromIntent$1(view);
                break;
            case 2:
                ratingActivity.lambda$buildActivityFromIntent$2(view);
                break;
            case 3:
                ratingActivity.lambda$buildActivityFromIntent$4(view);
                break;
            case 4:
                ratingActivity.lambda$loadWeather$6(view);
                break;
            case 5:
                ratingActivity.lambda$cannotGetLocation$7(view);
                break;
            default:
                ratingActivity.lambda$renderWeather$8(view);
                break;
        }
    }
}
