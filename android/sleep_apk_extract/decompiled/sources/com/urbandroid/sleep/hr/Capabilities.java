package com.urbandroid.sleep.hr;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/urbandroid/sleep/hr/Capabilities;", "", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class Capabilities {
    private static final AccelCapability ACCEL;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final HRCapability HR;
    private static final RRCapability RR;
    private static final SPO2Capability SPO2;
    private static final List<Capability<? extends Object>> all;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/urbandroid/sleep/hr/Capabilities$Companion;", "", "<init>", "()V", "Lcom/urbandroid/sleep/hr/HRCapability;", "HR", "Lcom/urbandroid/sleep/hr/HRCapability;", "getHR", "()Lcom/urbandroid/sleep/hr/HRCapability;", "Lcom/urbandroid/sleep/hr/SPO2Capability;", "SPO2", "Lcom/urbandroid/sleep/hr/SPO2Capability;", "getSPO2", "()Lcom/urbandroid/sleep/hr/SPO2Capability;", "Lcom/urbandroid/sleep/hr/RRCapability;", "RR", "Lcom/urbandroid/sleep/hr/RRCapability;", "getRR", "()Lcom/urbandroid/sleep/hr/RRCapability;", "Lcom/urbandroid/sleep/hr/AccelCapability;", "ACCEL", "Lcom/urbandroid/sleep/hr/AccelCapability;", "getACCEL", "()Lcom/urbandroid/sleep/hr/AccelCapability;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AccelCapability getACCEL() {
            return Capabilities.ACCEL;
        }

        public final HRCapability getHR() {
            return Capabilities.HR;
        }

        public final RRCapability getRR() {
            return Capabilities.RR;
        }

        public final SPO2Capability getSPO2() {
            return Capabilities.SPO2;
        }

        private Companion() {
        }
    }

    static {
        HRCapability companion = HRCapability.INSTANCE.getInstance();
        HR = companion;
        SPO2Capability companion2 = SPO2Capability.INSTANCE.getInstance();
        SPO2 = companion2;
        RRCapability companion3 = RRCapability.INSTANCE.getInstance();
        RR = companion3;
        AccelCapability companion4 = AccelCapability.INSTANCE.getInstance();
        ACCEL = companion4;
        all = CollectionsKt.listOf((Object[]) new Capability[]{companion, companion2, companion3, companion4});
    }
}
