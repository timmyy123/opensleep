package com.facebook.ads.redexgen.core;

import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ic, reason: from Kotlin metadata */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0007J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u0005J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/facebook/video/heroplayer/exocustom/ContextAwareXHEAACDRCTypeUtil;", "", "<init>", "()V", "LATE_NIGHT_MODE", "", "LIMITED_PLAYBACK_RANGE", "DRC_EFFECT_OFF", "DRC_EFFECT_GENERAL_COMPRESSION", "getCustomizedDRCEffectType", "customizedDRCEffect", "lateNightLowerThreshold", "lateNightHigherThreshold", "isValidDRCEffectType", "", "shouldUseLateNightMode", "lateNightHourLowerThreshold", "lateNightHourUpperThreshold", "fbandroid.java.com.facebook.video.heroplayer.exocustom.exocustom"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContextAwareXHEAACDRCTypeUtil {
    public static final ContextAwareXHEAACDRCTypeUtil A00 = new ContextAwareXHEAACDRCTypeUtil();

    @JvmStatic
    public static final int A00(int i, int i2, int i3) {
        if (A00.A01(i) && !GlobalSystemVolumeHolder.A01.A00()) {
            return i;
        }
        if (A02(i2, i3)) {
            return 1;
        }
        return 3;
    }

    private final boolean A01(int i) {
        return -1 <= i && i < 7;
    }

    @JvmStatic
    public static final boolean A02(int i, int i2) {
        int i3 = Calendar.getInstance().get(11);
        return i3 >= i || i3 <= i2;
    }
}
