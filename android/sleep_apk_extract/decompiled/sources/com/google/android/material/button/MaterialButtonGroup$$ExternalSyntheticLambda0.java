package com.google.android.material.button;

import com.urbandroid.sleep.captcha.list.CaptchaRecyclerViewAdapter;
import java.util.Comparator;
import kotlin.coroutines.CombinedContext$$ExternalSyntheticLambda1;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class MaterialButtonGroup$$ExternalSyntheticLambda0 implements Comparator {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ MaterialButtonGroup$$ExternalSyntheticLambda0(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int i = this.$r8$classId;
        Object obj3 = this.f$0;
        switch (i) {
            case 0:
                return ((MaterialButtonGroup) obj3).lambda$new$0((MaterialButton) obj, (MaterialButton) obj2);
            default:
                return CaptchaRecyclerViewAdapter.add$lambda$1((CombinedContext$$ExternalSyntheticLambda1) obj3, obj, obj2);
        }
    }
}
