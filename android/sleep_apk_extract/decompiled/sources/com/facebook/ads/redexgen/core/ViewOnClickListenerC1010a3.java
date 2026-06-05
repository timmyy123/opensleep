package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.a3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class ViewOnClickListenerC1010a3 implements View.OnClickListener {
    public static String[] A01 = {"iZ6FuTOx6FAqmbj1AunCGkamUaDVg3eR", "OTd3wYZwyAdhrzzq5DVZ5RSyL", "m80G0T4tMZ36JM3eeYxY4WN8siPrP01X", "yhwtzpQCbgij9W", "85UkrcR6qg1oy5EdfurKWfofR8ayIayx", "yKANEKxGU", "haLFOFZH1x7UhbGKUD1GobiUu6Nm2S9C", "YnroWKjcyqExTOiVG"};
    public final /* synthetic */ C1011a4 A00;

    public ViewOnClickListenerC1010a3(C1011a4 c1011a4) {
        this.A00 = c1011a4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (WU.A02(this)) {
            return;
        }
        try {
            if (this.A00.A02.getVisibility() == 8) {
                this.A00.A07(0);
                this.A00.A00.postDelayed(this.A00.A08, 1500L);
            } else {
                this.A00.A06();
                this.A00.A00.removeCallbacks(this.A00.A08);
                this.A00.A07(8);
            }
        } catch (Throwable th) {
            String[] strArr = A01;
            if (strArr[5].length() == strArr[3].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[2] = "BS56tA9mEf46ZLpm0pjL0lsj0NMRakTT";
            strArr2[4] = "RRhRbLQv2JGaZTWGxiXTzimfELVMOsxN";
            WU.A00(th, this);
        }
    }
}
