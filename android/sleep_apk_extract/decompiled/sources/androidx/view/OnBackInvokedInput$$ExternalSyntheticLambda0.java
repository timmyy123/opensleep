package androidx.view;

import android.window.OnBackInvokedCallback;
import com.google.android.material.motion.MaterialBackHandler;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class OnBackInvokedInput$$ExternalSyntheticLambda0 implements OnBackInvokedCallback {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ OnBackInvokedInput$$ExternalSyntheticLambda0(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    public final void onBackInvoked() {
        int i = this.$r8$classId;
        Object obj = this.f$0;
        switch (i) {
            case 0:
                ((OnBackInvokedInput) obj).dispatchOnBackCompleted();
                break;
            default:
                ((MaterialBackHandler) obj).handleBackInvoked();
                break;
        }
    }
}
