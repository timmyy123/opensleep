package com.urbandroid.sleep.service.google.healthconnect;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.urbandroid.sleep.service.health.session.SleepSegmentType;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0002*\u00020\u0001¨\u0006\u0004"}, d2 = {"toSleepSegmentType", "Lcom/urbandroid/sleep/service/health/session/SleepSegmentType;", "", "toHealthConnectStageType", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class HealthConnectSleepSegmentTypeKt {

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SleepSegmentType.values().length];
            try {
                iArr[SleepSegmentType.AWAKE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SleepSegmentType.AWAKE_PAUSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SleepSegmentType.AWAKE_WALKING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SleepSegmentType.LIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[SleepSegmentType.REM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[SleepSegmentType.DEEP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final int toHealthConnectStageType(SleepSegmentType sleepSegmentType) {
        sleepSegmentType.getClass();
        switch (WhenMappings.$EnumSwitchMapping$0[sleepSegmentType.ordinal()]) {
            case 1:
            case 2:
                return 1;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 6;
            case 6:
                return 5;
            default:
                Home$$ExternalSyntheticBUOutline0.m();
                return 0;
        }
    }

    public static final SleepSegmentType toSleepSegmentType(int i) {
        switch (i) {
            case 0:
                return null;
            case 1:
                return SleepSegmentType.AWAKE;
            case 2:
                return null;
            case 3:
                return SleepSegmentType.AWAKE_WALKING;
            case 4:
                return SleepSegmentType.LIGHT;
            case 5:
                return SleepSegmentType.DEEP;
            case 6:
                return SleepSegmentType.REM;
            default:
                return null;
        }
    }
}
