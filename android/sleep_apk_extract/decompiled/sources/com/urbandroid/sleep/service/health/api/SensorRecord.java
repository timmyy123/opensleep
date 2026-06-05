package com.urbandroid.sleep.service.health.api;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\f\rB\u0019\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0082\u0001\u0002\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/urbandroid/sleep/service/health/api/SensorRecord;", "", "from", "", SDKConstants.PARAM_VALUE, "", "<init>", "(JF)V", "getFrom", "()J", "getValue", "()F", "HeartRate", "SPO2", "Lcom/urbandroid/sleep/service/health/api/SensorRecord$HeartRate;", "Lcom/urbandroid/sleep/service/health/api/SensorRecord$SPO2;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class SensorRecord {
    private final long from;
    private final float value;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/urbandroid/sleep/service/health/api/SensorRecord$HeartRate;", "Lcom/urbandroid/sleep/service/health/api/SensorRecord;", "", "from", "", "ratePerMinute", "<init>", "(JF)V", "J", "getFrom", "()J", "F", "getRatePerMinute", "()F", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class HeartRate extends SensorRecord {
        private final long from;
        private final float ratePerMinute;

        public HeartRate(long j, float f) {
            super(j, f, null);
            this.from = j;
            this.ratePerMinute = f;
        }

        @Override // com.urbandroid.sleep.service.health.api.SensorRecord
        public long getFrom() {
            return this.from;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/urbandroid/sleep/service/health/api/SensorRecord$SPO2;", "Lcom/urbandroid/sleep/service/health/api/SensorRecord;", "", "from", "", "percentage", "<init>", "(JF)V", "J", "getFrom", "()J", "F", "getPercentage", "()F", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class SPO2 extends SensorRecord {
        private final long from;
        private final float percentage;

        public SPO2(long j, float f) {
            super(j, f, null);
            this.from = j;
            this.percentage = f;
        }

        @Override // com.urbandroid.sleep.service.health.api.SensorRecord
        public long getFrom() {
            return this.from;
        }
    }

    private SensorRecord(long j, float f) {
        this.from = j;
        this.value = f;
    }

    public abstract long getFrom();

    public float getValue() {
        return this.value;
    }

    public /* synthetic */ SensorRecord(long j, float f, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, f);
    }
}
