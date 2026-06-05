package com.urbandroid.sleep.hr;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002¨\u0006\t"}, d2 = {"Lcom/urbandroid/sleep/hr/SPO2Capability;", "Lcom/urbandroid/sleep/hr/Capability;", "", "<init>", "()V", "isValid", "", "spo2", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SPO2Capability extends Capability<Float> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final SPO2Capability instance = new SPO2Capability();

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/urbandroid/sleep/hr/SPO2Capability$Companion;", "", "<init>", "()V", "instance", "Lcom/urbandroid/sleep/hr/SPO2Capability;", "getInstance", "()Lcom/urbandroid/sleep/hr/SPO2Capability;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SPO2Capability getInstance() {
            return SPO2Capability.instance;
        }

        private Companion() {
        }
    }

    private SPO2Capability() {
        super("SPO2", Float.TYPE, null);
    }

    public final boolean isValid(float spo2) {
        return spo2 >= 50.0f && spo2 <= 100.0f;
    }
}
