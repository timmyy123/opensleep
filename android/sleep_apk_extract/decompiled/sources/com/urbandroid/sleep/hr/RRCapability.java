package com.urbandroid.sleep.hr;

import com.urbandroid.sleep.sensor.extra.RRIntervalsDataProducer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002¨\u0006\t"}, d2 = {"Lcom/urbandroid/sleep/hr/RRCapability;", "Lcom/urbandroid/sleep/hr/Capability;", "", "<init>", "()V", "isValid", "", "rr", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RRCapability extends Capability<Float> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final RRCapability instance = new RRCapability();

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/urbandroid/sleep/hr/RRCapability$Companion;", "", "<init>", "()V", "instance", "Lcom/urbandroid/sleep/hr/RRCapability;", "getInstance", "()Lcom/urbandroid/sleep/hr/RRCapability;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RRCapability getInstance() {
            return RRCapability.instance;
        }

        private Companion() {
        }
    }

    private RRCapability() {
        super("RR", Float.TYPE, null);
    }

    public final boolean isValid(float rr) {
        RRIntervalsDataProducer.Companion companion = RRIntervalsDataProducer.INSTANCE;
        return rr >= ((float) companion.getRR_MIN()) && rr <= ((float) companion.getRR_MAX());
    }
}
