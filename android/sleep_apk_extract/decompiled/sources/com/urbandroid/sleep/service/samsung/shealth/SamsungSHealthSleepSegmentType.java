package com.urbandroid.sleep.service.samsung.shealth;

import com.urbandroid.sleep.service.health.session.SleepSegmentType;

/* JADX INFO: loaded from: classes5.dex */
public abstract class SamsungSHealthSleepSegmentType {

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.samsung.shealth.SamsungSHealthSleepSegmentType$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$urbandroid$sleep$service$health$session$SleepSegmentType;

        static {
            int[] iArr = new int[SleepSegmentType.values().length];
            $SwitchMap$com$urbandroid$sleep$service$health$session$SleepSegmentType = iArr;
            try {
                iArr[SleepSegmentType.AWAKE_PAUSED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$urbandroid$sleep$service$health$session$SleepSegmentType[SleepSegmentType.LIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$urbandroid$sleep$service$health$session$SleepSegmentType[SleepSegmentType.REM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$urbandroid$sleep$service$health$session$SleepSegmentType[SleepSegmentType.DEEP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static int find(SleepSegmentType sleepSegmentType) {
        int i = AnonymousClass1.$SwitchMap$com$urbandroid$sleep$service$health$session$SleepSegmentType[sleepSegmentType.ordinal()];
        if (i == 2) {
            return 40002;
        }
        if (i != 3) {
            return i != 4 ? 40001 : 40003;
        }
        return 40004;
    }

    public static SleepSegmentType find(int i) {
        switch (i) {
            case 40001:
                return SleepSegmentType.AWAKE_PAUSED;
            case 40002:
                return SleepSegmentType.LIGHT;
            case 40003:
                return SleepSegmentType.DEEP;
            case 40004:
                return SleepSegmentType.REM;
            default:
                return null;
        }
    }
}
