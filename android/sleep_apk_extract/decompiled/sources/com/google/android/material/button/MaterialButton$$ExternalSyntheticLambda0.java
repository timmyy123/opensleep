package com.google.android.material.button;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class MaterialButton$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ MaterialButton f$0;
    public final /* synthetic */ Drawable f$1;

    public /* synthetic */ MaterialButton$$ExternalSyntheticLambda0(MaterialButton materialButton, Drawable drawable, int i) {
        this.$r8$classId = i;
        this.f$0 = materialButton;
        this.f$1 = drawable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.$r8$classId;
        Drawable drawable = this.f$1;
        MaterialButton materialButton = this.f$0;
        switch (i) {
            case 0:
                materialButton.lambda$setSecondaryIcon$3(drawable);
                break;
            default:
                materialButton.lambda$setIcon$2(drawable);
                break;
        }
    }
}
