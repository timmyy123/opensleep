package com.urbandroid.sleep.fragment.dashboard.card;

import com.urbandroid.sleep.fragment.dashboard.card.NativeAdCard;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class NativeAdCard$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ NativeAdCard f$0;
    public final /* synthetic */ NativeAdCard.NativeAdViewHolder f$1;

    public /* synthetic */ NativeAdCard$$ExternalSyntheticLambda0(NativeAdCard nativeAdCard, NativeAdCard.NativeAdViewHolder nativeAdViewHolder, int i) {
        this.$r8$classId = i;
        this.f$0 = nativeAdCard;
        this.f$1 = nativeAdViewHolder;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        int i = this.$r8$classId;
        NativeAdCard.NativeAdViewHolder nativeAdViewHolder = this.f$1;
        NativeAdCard nativeAdCard = this.f$0;
        switch (i) {
            case 0:
                return NativeAdCard.bindView$lambda$0(nativeAdCard, nativeAdViewHolder);
            default:
                return NativeAdCard.bindView$lambda$1$0(nativeAdCard, nativeAdViewHolder);
        }
    }
}
