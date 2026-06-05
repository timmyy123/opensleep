package com.urbandroid.sleep.hr;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0005B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/urbandroid/sleep/hr/AccelCapability;", "Lcom/urbandroid/sleep/hr/Capability;", "Lcom/urbandroid/sleep/hr/AccelBatch;", "<init>", "()V", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AccelCapability extends Capability<AccelBatch> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final AccelCapability instance = new AccelCapability();

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/urbandroid/sleep/hr/AccelCapability$Companion;", "", "<init>", "()V", "instance", "Lcom/urbandroid/sleep/hr/AccelCapability;", "getInstance", "()Lcom/urbandroid/sleep/hr/AccelCapability;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AccelCapability getInstance() {
            return AccelCapability.instance;
        }

        private Companion() {
        }
    }

    private AccelCapability() {
        super("ACCEL", AccelBatch.class, null);
    }
}
