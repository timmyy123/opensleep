package com.urbandroid.sleep.ads;

import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.OnPaidEventListener;
import com.urbandroid.sleep.alarmclock.settings.SearchActivity;
import com.urbandroid.sleep.fragment.dashboard.card.NativeAdCard;
import com.urbandroid.sleep.gui.IFilterListAdapter;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class AdMobController$$ExternalSyntheticLambda0 implements OnPaidEventListener, IFilterListAdapter.IFilter {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ String f$0;

    public /* synthetic */ AdMobController$$ExternalSyntheticLambda0(String str, int i) {
        this.$r8$classId = i;
        this.f$0 = str;
    }

    @Override // com.urbandroid.sleep.gui.IFilterListAdapter.IFilter
    public String getFilterString() {
        return SearchActivity.search$lambda$0$0(this.f$0);
    }

    @Override // com.google.android.gms.ads.OnPaidEventListener
    public void onPaidEvent(AdValue adValue) {
        int i = this.$r8$classId;
        String str = this.f$0;
        switch (i) {
            case 0:
                AdMobController.lambda$load$0(str, adValue);
                break;
            default:
                NativeAdCard.createAdBuilder$lambda$0$4(str, adValue);
                break;
        }
    }
}
