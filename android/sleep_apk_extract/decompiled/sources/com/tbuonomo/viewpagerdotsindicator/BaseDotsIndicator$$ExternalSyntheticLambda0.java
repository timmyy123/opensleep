package com.tbuonomo.viewpagerdotsindicator;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class BaseDotsIndicator$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ BaseDotsIndicator f$0;

    public /* synthetic */ BaseDotsIndicator$$ExternalSyntheticLambda0(BaseDotsIndicator baseDotsIndicator, int i) {
        this.$r8$classId = i;
        this.f$0 = baseDotsIndicator;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.$r8$classId;
        BaseDotsIndicator baseDotsIndicator = this.f$0;
        switch (i) {
            case 0:
                BaseDotsIndicator.onAttachedToWindow$lambda$0(baseDotsIndicator);
                break;
            case 1:
                BaseDotsIndicator.refreshDots$lambda$1(baseDotsIndicator);
                break;
            default:
                BaseDotsIndicator.onRestoreInstanceState$lambda$3(baseDotsIndicator);
                break;
        }
    }
}
