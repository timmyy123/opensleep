package com.urbandroid.util;

import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.domain.Sensitivity;
import com.urbandroid.sleep.service.Settings;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\u001a2\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001\u001a2\u0010\b\u001a\u00020\t*\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\t¨\u0006\u000e"}, d2 = {"mapSmartWakeupSensitivityChecks", "", "Lcom/urbandroid/sleep/service/Settings;", "value0", "value1", "value2", "value4", "fallbackValue", "mapDeepSleepSensitivity", "", "valueVeryLow", "valueLow", "valueMedium", "valueHigh", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class SettingsExtKt {

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Sensitivity.values().length];
            try {
                iArr[Sensitivity.VERY_LOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Sensitivity.LOW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Sensitivity.MEDIUM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Sensitivity.HIGH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final float mapDeepSleepSensitivity(Settings settings, float f, float f2, float f3, float f4, float f5) {
        settings.getClass();
        Sensitivity deepSleepSensitivity = settings.getDeepSleepSensitivity();
        int i = deepSleepSensitivity == null ? -1 : WhenMappings.$EnumSwitchMapping$0[deepSleepSensitivity.ordinal()];
        if (i == 1) {
            return f;
        }
        if (i == 2) {
            return f2;
        }
        if (i == 3) {
            return f3;
        }
        if (i == 4) {
            return f4;
        }
        Logger.logWarning("Unknown DeepSleepSensitivity: " + deepSleepSensitivity);
        return f5;
    }

    public static final int mapSmartWakeupSensitivityChecks(Settings settings, int i, int i2, int i3, int i4, int i5) {
        settings.getClass();
        int smartWakeupSensitivityChecks = settings.getSmartWakeupSensitivityChecks();
        if (smartWakeupSensitivityChecks == 0) {
            return i;
        }
        if (smartWakeupSensitivityChecks == 1) {
            return i2;
        }
        if (smartWakeupSensitivityChecks == 2) {
            return i3;
        }
        if (smartWakeupSensitivityChecks == 3 || smartWakeupSensitivityChecks == 4 || smartWakeupSensitivityChecks == 8) {
            return i4;
        }
        Logger.logWarning("Unknown SmartWakeupSensitivityChecks: " + smartWakeupSensitivityChecks);
        return i5;
    }
}
