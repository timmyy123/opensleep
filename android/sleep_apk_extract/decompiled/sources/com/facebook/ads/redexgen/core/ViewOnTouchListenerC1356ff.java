package com.facebook.ads.redexgen.core;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ff, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class ViewOnTouchListenerC1356ff implements View.OnTouchListener {
    public final /* synthetic */ TextureViewSurfaceTextureListenerC0421Cz A00;

    public ViewOnTouchListenerC1356ff(TextureViewSurfaceTextureListenerC0421Cz textureViewSurfaceTextureListenerC0421Cz) {
        this.A00 = textureViewSurfaceTextureListenerC0421Cz;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.A00.A09 != null && motionEvent.getAction() == 1) {
            if (this.A00.A09.isShowing()) {
                this.A00.A09.hide();
            } else {
                this.A00.A09.show();
            }
        }
        return true;
    }
}
