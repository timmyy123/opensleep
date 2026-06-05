package com.google.android.material.timepicker;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class RadialViewGroup$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ RadialViewGroup$$ExternalSyntheticLambda0(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.$r8$classId;
        Object obj = this.f$0;
        switch (i) {
            case 0:
                ((RadialViewGroup) obj).updateLayoutParams();
                break;
            default:
                ((MaterialTimePicker) obj).lambda$onViewCreated$3();
                break;
        }
    }
}
