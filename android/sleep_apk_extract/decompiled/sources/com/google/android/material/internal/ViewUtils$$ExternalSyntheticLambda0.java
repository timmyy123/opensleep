package com.google.android.material.internal;

import android.view.View;
import com.google.firebase.installations.FirebaseInstallations;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class ViewUtils$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ boolean f$1;

    public /* synthetic */ ViewUtils$$ExternalSyntheticLambda0(int i, Object obj, boolean z) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.$r8$classId;
        boolean z = this.f$1;
        Object obj = this.f$0;
        switch (i) {
            case 0:
                ViewUtils.showKeyboard((View) obj, z);
                break;
            default:
                ((FirebaseInstallations) obj).lambda$doRegistrationOrRefresh$3(z);
                break;
        }
    }
}
