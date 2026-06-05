package com.facebook.ads.redexgen.core;

import android.widget.ImageView;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class K3 implements InterfaceC1077b8 {
    public final /* synthetic */ C0584Ji A00;

    public K3(C0584Ji c0584Ji) {
        this.A00 = c0584Ji;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1077b8
    public final void AE7(C1076b7 c1076b7) {
        if (this.A00.A02 != null && c1076b7.A00() != null) {
            this.A00.A02.setImageBitmap(c1076b7.A00());
            this.A00.A02.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.A00.A02.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        }
    }
}
