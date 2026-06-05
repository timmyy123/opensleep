package com.facebook.ads.redexgen.core;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.fi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class ViewOnTouchListenerC1359fi implements View.OnTouchListener {
    public static String[] A01 = {"Bd4iK263MdiqVEckgiEcXaEaZ4uIweBG", "Jp1QSGfkJ8Z9zXekFuJltl48GgKydEoc", "fEEbeUwQeH7COVlxXKNmLl1Z50afP2Mj", "r02s0ULWktGw0R0gNTqzpE9xc", "EB9Y4EIWcixhOmounHH1kGqbNZmcFzXh", "JuYgfl", "oFT1QXZER3M49OH4cjLW2BEWWzLsdZXt", "I5"};
    public final /* synthetic */ TextureViewSurfaceTextureListenerC0420Cy A00;

    public ViewOnTouchListenerC1359fi(TextureViewSurfaceTextureListenerC0420Cy textureViewSurfaceTextureListenerC0420Cy) {
        this.A00 = textureViewSurfaceTextureListenerC0420Cy;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.A00.A0G && this.A00.A0A != null) {
            int action = motionEvent.getAction();
            if (A01[7].length() != 2) {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[0] = "zVWiAAuOepyWFcYkLQ4ZoGrmpQGPeEmc";
            strArr[1] = "wkRU6nfkZfVncc0k3MPDpaJGMcStJhoI";
            if (action == 1) {
                if (this.A00.A0A.isShowing()) {
                    this.A00.A0A.hide();
                } else {
                    this.A00.A0A.show();
                }
            }
        }
        return true;
    }
}
