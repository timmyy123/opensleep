package com.facebook.ads.redexgen.core;

import android.view.View;
import android.widget.RelativeLayout;
import javax.annotation.Nullable;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Rq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class ViewOnLongClickListenerC0795Rq implements View.OnLongClickListener {
    public static String[] A02 = {"kWMETALBgXQPxa1caUNWOxECFuDqqQMg", "ZdkMlJfyQLC9xkOOBWIiDwjfHp6c9jbv", "0ZcfP2jVUcrv9OHIQZTLnU8", "f1ui83cs7IfjD0PNLw4msBb2GPSJERBF", "Csxj5aYvqiT2vPBDwP7", "SUYUZZDjraqMGfRe", "xuktTTnzvvF5Ho58lD7oBLq", ""};

    @Nullable
    public final RelativeLayout A00;

    @Nullable
    public final C1075b6 A01;

    public ViewOnLongClickListenerC0795Rq(C1075b6 c1075b6, RelativeLayout relativeLayout) {
        this.A01 = c1075b6;
        this.A00 = relativeLayout;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        if (this.A01 != null && this.A00 != null) {
            C1075b6 c1075b6 = this.A01;
            int width = this.A00.getWidth();
            RelativeLayout relativeLayout = this.A00;
            String[] strArr = A02;
            if (strArr[0].charAt(28) == strArr[1].charAt(28)) {
                throw new RuntimeException();
            }
            A02[7] = "";
            c1075b6.setBounds(0, 0, width, relativeLayout.getHeight());
            this.A01.A0D(!this.A01.A0E());
        }
        return true;
    }
}
