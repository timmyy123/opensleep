package com.facebook.ads.redexgen.core;

import android.view.View;
import android.widget.ImageView;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class MR extends C1115bk {
    public static String[] A01 = {"Er9uQMazYAvywc84qssi8CcPD5K", "bpAOsy1ZAool4ZO", "456cLSbicHverE2", "OQn0GSeoKkB55mmrW6XfcsGu8yTW4vwY", "5C5KK7QE3ZVmFSCl85soxjy8aya", "FZZqXqYfqR5sLOGe", "aaYiwVUQ6XuTYr3PnCNNWh", "fICxnQOCOsz8JBbFc5EZnQUEppLIkjem"};
    public ImageView.ScaleType A00;

    public MR(C1421gi c1421gi) {
        super(c1421gi);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
    @Override // android.widget.ImageView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i);
        int heightSpecSize = View.MeasureSpec.getMode(i);
        if (heightSpecSize == 1073741824) {
            int heightSpecSize2 = View.MeasureSpec.getMode(i2);
            if (heightSpecSize2 == 1073741824) {
                int heightSpecSize3 = Math.min(size2, size);
                setMeasuredDimension(heightSpecSize3, heightSpecSize3);
            } else {
                int heightSpecSize4 = View.MeasureSpec.getMode(i);
                if (heightSpecSize4 == 1073741824) {
                    if (size > 0) {
                        size2 = Math.min(size2, size);
                    }
                    setMeasuredDimension(size2, size2);
                } else {
                    int heightSpecSize5 = View.MeasureSpec.getMode(i2);
                    if (heightSpecSize5 == 1073741824) {
                        if (size2 > 0) {
                            size = Math.min(size2, size);
                        }
                        setMeasuredDimension(size, size);
                    } else {
                        super.onMeasure(i, i2);
                    }
                }
            }
        }
        if (this.A00 != null) {
            ImageView.ScaleType scaleType = this.A00;
            int widthSpecSize = A01[2].length();
            if (widthSpecSize != 15) {
                throw new RuntimeException();
            }
            A01[0] = "1TQeY3NJoCywMKTf";
            super.setScaleType(scaleType);
        }
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        this.A00 = scaleType;
    }
}
