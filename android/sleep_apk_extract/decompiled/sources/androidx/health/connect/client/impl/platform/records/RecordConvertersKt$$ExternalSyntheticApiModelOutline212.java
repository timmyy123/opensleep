package androidx.health.connect.client.impl.platform.records;

import android.health.connect.datatypes.CyclingPedalingCadenceRecord;
import android.health.connect.datatypes.HeartRateRecord;
import android.health.connect.datatypes.PowerRecord;
import android.health.connect.datatypes.SleepSessionRecord;
import android.health.connect.datatypes.SpeedRecord;
import android.health.connect.datatypes.StepsCadenceRecord;
import android.health.connect.datatypes.units.Power;
import android.health.connect.datatypes.units.Velocity;
import j$.time.Instant;
import j$.time.TimeConversions;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class RecordConvertersKt$$ExternalSyntheticApiModelOutline212 {
    public static /* synthetic */ SleepSessionRecord.Stage m(Instant instant, Instant instant2, int i) {
        Object[] objArrM = RecordConvertersKt$$ExternalSyntheticAPIConversion8.m(instant, instant2, i);
        return new SleepSessionRecord.Stage((java.time.Instant) objArrM[0], (java.time.Instant) objArrM[1], ((Integer) objArrM[2]).intValue());
    }

    public static /* synthetic */ void m$1() {
    }

    public static /* synthetic */ void m$2() {
    }

    public static /* synthetic */ void m$3() {
    }

    public static /* synthetic */ void m$4() {
    }

    public static /* synthetic */ void m$5() {
    }

    public static /* synthetic */ HeartRateRecord.HeartRateSample m(Instant instant, long j) {
        return new HeartRateRecord.HeartRateSample(j, TimeConversions.convert(instant));
    }

    public static /* synthetic */ PowerRecord.PowerRecordSample m(Power power, Instant instant) {
        return new PowerRecord.PowerRecordSample(power, TimeConversions.convert(instant));
    }

    public static /* synthetic */ CyclingPedalingCadenceRecord.CyclingPedalingCadenceRecordSample m(Instant instant, double d) {
        return new CyclingPedalingCadenceRecord.CyclingPedalingCadenceRecordSample(d, TimeConversions.convert(instant));
    }

    public static /* synthetic */ SpeedRecord.SpeedRecordSample m(Velocity velocity, Instant instant) {
        return new SpeedRecord.SpeedRecordSample(velocity, TimeConversions.convert(instant));
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ StepsCadenceRecord.StepsCadenceRecordSample m150m(Instant instant, double d) {
        return new StepsCadenceRecord.StepsCadenceRecordSample(d, TimeConversions.convert(instant));
    }

    public static /* synthetic */ void m() {
    }
}
