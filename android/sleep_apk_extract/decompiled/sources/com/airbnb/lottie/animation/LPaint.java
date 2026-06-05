package com.airbnb.lottie.animation;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.os.LocaleList;
import com.airbnb.lottie.utils.MiscUtils;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;

/* JADX INFO: loaded from: classes.dex */
public class LPaint extends Paint {
    public LPaint(PorterDuff.Mode mode) {
        setXfermode(new PorterDuffXfermode(mode));
    }

    @Override // android.graphics.Paint
    public void setAlpha(int i) {
        if (Build.VERSION.SDK_INT >= 30) {
            super.setAlpha(MiscUtils.clamp(i, 0, PHIpAddressSearchManager.END_IP_SCAN));
        } else {
            setColor((MiscUtils.clamp(i, 0, PHIpAddressSearchManager.END_IP_SCAN) << 24) | (getColor() & 16777215));
        }
    }

    @Override // android.graphics.Paint
    public void setTextLocales(LocaleList localeList) {
    }

    public LPaint(int i) {
        super(i);
    }

    public LPaint() {
    }

    public LPaint(int i, PorterDuff.Mode mode) {
        super(i);
        setXfermode(new PorterDuffXfermode(mode));
    }
}
