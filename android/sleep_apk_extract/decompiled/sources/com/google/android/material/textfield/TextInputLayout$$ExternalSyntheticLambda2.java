package com.google.android.material.textfield;

import android.view.View;
import android.widget.LinearLayout;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.StaticLayoutBuilderConfigurer;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class TextInputLayout$$ExternalSyntheticLambda2 implements CheckableImageButton.OnFocusableChangedListener, StaticLayoutBuilderConfigurer {
    public final /* synthetic */ LinearLayout f$0;

    public /* synthetic */ TextInputLayout$$ExternalSyntheticLambda2(LinearLayout linearLayout) {
        this.f$0 = linearLayout;
    }

    @Override // com.google.android.material.internal.CheckableImageButton.OnFocusableChangedListener
    public void onFocusableChanged(View view, boolean z) {
        ((StartCompoundLayout) this.f$0).lambda$new$0(view, z);
    }
}
