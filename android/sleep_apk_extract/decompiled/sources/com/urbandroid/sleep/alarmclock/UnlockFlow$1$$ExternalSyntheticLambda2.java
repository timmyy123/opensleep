package com.urbandroid.sleep.alarmclock;

import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.urbandroid.sleep.alarmclock.UnlockFlow;
import com.urbandroid.sleep.gui.SeekBarPreference;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class UnlockFlow$1$$ExternalSyntheticLambda2 implements OnUserEarnedRewardListener, SeekBarPreference.IFormatter {
    public final /* synthetic */ Object f$0;

    public /* synthetic */ UnlockFlow$1$$ExternalSyntheticLambda2(Object obj) {
        this.f$0 = obj;
    }

    @Override // com.urbandroid.sleep.gui.SeekBarPreference.IFormatter
    public String format(int i) {
        return ((SetAlarmBedtime) this.f$0).lambda$initPrefs$1(i);
    }

    @Override // com.google.android.gms.ads.OnUserEarnedRewardListener
    public void onUserEarnedReward(RewardItem rewardItem) {
        ((UnlockFlow.AnonymousClass1) this.f$0).lambda$onAdLoaded$1(rewardItem);
    }
}
