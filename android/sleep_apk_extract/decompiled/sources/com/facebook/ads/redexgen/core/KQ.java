package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class KQ extends AbstractRunnableC0908Wc {
    public static String[] A02 = {"LRx", "usnMdIZ0FvkqiUZevNTWLktoEg5pLAC7", "DXfpDntuFVUaB3iAC9xpEYaXMcysh68b", "KPagnGwIHNxRQqHn90bhIF", "OiThbZ96vqk0YqBrWrlbCPGqj", "zO4ylzajSSdkzzLOGvXbKRrkPLlgkkF6", "2QDKj7W9IPpyibsxcOZVzQQBEZY6mcrJ", "j8cJ2BFMipeHC45SmF0VkU4zcd"};
    public final /* synthetic */ KE A00;
    public final /* synthetic */ boolean A01;

    public KQ(KE ke, boolean z) {
        this.A00 = ke;
        this.A01 = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003e  */
    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC0908Wc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void A07() {
        boolean z;
        AbstractC0956Yb abstractC0956YbA0B = this.A00.A0J.A0B();
        if (abstractC0956YbA0B != null) {
            if (!this.A01) {
                boolean zA0E = abstractC0956YbA0B.A0E();
                if (A02[4].length() != 25) {
                    throw new RuntimeException();
                }
                A02[4] = "GjOMFYo3T7nhomgErVvGRCVPy";
                z = !zA0E;
            }
            abstractC0956YbA0B.setPageDetailsVisible(z);
            abstractC0956YbA0B.setToolbarActionMode(this.A00.getCloseButtonStyle());
        }
    }
}
