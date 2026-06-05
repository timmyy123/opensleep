package com.urbandroid.sleep.smartlight;

import android.view.View;
import com.urbandroid.sleep.smartwatch.Wearable;
import com.urbandroid.sleep.smartwatch.WearablesListAdapter;
import io.ktor.http.Url$$ExternalSyntheticLambda1;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class DiscoveryActivity$$ExternalSyntheticLambda2 implements View.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ DiscoveryActivity$$ExternalSyntheticLambda2(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.$r8$classId;
        Object obj = this.f$0;
        switch (i) {
            case 0:
                ((Url$$ExternalSyntheticLambda1) obj).invoke();
                break;
            default:
                WearablesListAdapter.lambda$getView$0((Wearable) obj, view);
                break;
        }
    }
}
