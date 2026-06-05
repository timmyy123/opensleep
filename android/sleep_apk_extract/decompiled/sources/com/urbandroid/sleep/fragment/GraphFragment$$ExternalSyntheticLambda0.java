package com.urbandroid.sleep.fragment;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class GraphFragment$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ LazyFragment f$0;

    public /* synthetic */ GraphFragment$$ExternalSyntheticLambda0(LazyFragment lazyFragment, int i) {
        this.$r8$classId = i;
        this.f$0 = lazyFragment;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.$r8$classId;
        LazyFragment lazyFragment = this.f$0;
        switch (i) {
            case 0:
                ((GraphFragment) lazyFragment).lambda$scrollTo$0();
                break;
            default:
                ((NoiseFragment) lazyFragment).lambda$onLayoutChange$0();
                break;
        }
    }
}
