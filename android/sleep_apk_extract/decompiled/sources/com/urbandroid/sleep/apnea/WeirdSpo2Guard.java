package com.urbandroid.sleep.apnea;

import com.google.gson.Gson$$ExternalSyntheticBUOutline0;
import com.urbandroid.sleep.domain.Sensitivity;
import com.urbandroid.sleep.snoring.feature.FloatFunction;
import com.urbandroid.sleep.snoring.feature.Functions;
import com.urbandroid.sleep.snoring.feature.Moving;

/* JADX INFO: loaded from: classes4.dex */
public class WeirdSpo2Guard {
    private final FloatFunction longerRange;
    private final float longerThreshold;
    private final int longerWindow;
    private final FloatFunction shortRange;
    private final float shortThreshold;
    private final int shortWindow;

    /* JADX INFO: renamed from: com.urbandroid.sleep.apnea.WeirdSpo2Guard$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$urbandroid$sleep$domain$Sensitivity;

        static {
            int[] iArr = new int[Sensitivity.values().length];
            $SwitchMap$com$urbandroid$sleep$domain$Sensitivity = iArr;
            try {
                iArr[Sensitivity.HIGH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$urbandroid$sleep$domain$Sensitivity[Sensitivity.MEDIUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$urbandroid$sleep$domain$Sensitivity[Sensitivity.LOW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$urbandroid$sleep$domain$Sensitivity[Sensitivity.VERY_LOW.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public WeirdSpo2Guard(Sensitivity sensitivity) {
        int i = AnonymousClass1.$SwitchMap$com$urbandroid$sleep$domain$Sensitivity[sensitivity.ordinal()];
        if (i == 1) {
            this.shortWindow = 5;
            this.shortThreshold = 10.0f;
            this.longerWindow = 10;
            this.longerThreshold = 10.0f;
        } else if (i == 2) {
            this.shortWindow = 5;
            this.shortThreshold = 5.0f;
            this.longerWindow = 15;
            this.longerThreshold = 10.0f;
        } else {
            if (i != 3 && i != 4) {
                Gson$$ExternalSyntheticBUOutline0.m("", sensitivity);
                throw null;
            }
            this.shortWindow = 5;
            this.shortThreshold = 4.0f;
            this.longerWindow = 20;
            this.longerThreshold = 10.0f;
        }
        this.shortRange = recentRange(this.shortWindow);
        this.longerRange = recentRange(this.longerWindow);
    }

    private FloatFunction recentRange(int i) {
        return Functions.subtract(Moving.max(i), Moving.min(i));
    }

    public boolean process(float f) {
        return this.shortRange.apply(f) >= this.shortThreshold || this.longerRange.apply(f) >= this.longerThreshold;
    }
}
