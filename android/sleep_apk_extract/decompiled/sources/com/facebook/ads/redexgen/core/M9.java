package com.facebook.ads.redexgen.core;

import android.widget.ImageView;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class M9 implements InterfaceC1060ar {
    public static String[] A01 = {"YJvayVN4kVOLxlDJWGwOCabHg1Fqt8we", "dXRRKrs9Ij7YmQRV4DOVJ1oKXH0uRxvN", "n5YXMgelgzgI9ER8zULhKnxSUvKWD7FQ", "MjcTDZ9vVz9cB8bZ6OPiFlfIoErQXBVk", "8uXe0M8gsMoVnVy8oufardLoqnsq8OG9", "SOq47sVgQRT9DF7sN8qUq9bi0IFpLSH7", "zaXV1JxsQyTBZsc16bKnJvrmUTnQXACV", "RKyyTAGKUR4fF8w9wvyslT4CD7IDkjm1"};
    public final /* synthetic */ M8 A00;

    public M9(M8 m8) {
        this.A00 = m8;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1060ar
    public final void ADB(boolean z) {
        this.A00.A0D(z);
        if (this.A00.A0A && this.A00.A00 != null) {
            ImageView imageView = this.A00.A00;
            if (A01[1].charAt(7) != '9') {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[0] = "1z8fFmuPWvqo0Almmab7pMFz1UcwKmNW";
            strArr[3] = "wk5V7hrE3V1AjvcaWXTFKexyEZN6L03E";
            imageView.setEnabled(z);
            this.A00.A00.setAlpha(z ? 1.0f : 0.3f);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1060ar
    public final void ADx(boolean z) {
        this.A00.A0D(z);
        if (this.A00.A0A && this.A00.A02 != null) {
            this.A00.A02.setEnabled(z);
            this.A00.A02.setAlpha(z ? 1.0f : 0.3f);
        }
    }
}
