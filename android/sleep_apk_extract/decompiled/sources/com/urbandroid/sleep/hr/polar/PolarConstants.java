package com.urbandroid.sleep.hr.polar;

import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/urbandroid/sleep/hr/polar/PolarConstants;", "", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class PolarConstants {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final UUID POLAR_PMD_CONTROL_CHARACTERISTIC_ID;
    private static final UUID POLAR_PMD_DATA_MTU_CHARACTERISTIC_ID;
    private static final UUID POLAR_PMD_SERVICE_ID;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/urbandroid/sleep/hr/polar/PolarConstants$Companion;", "", "<init>", "()V", "POLAR_PMD_SERVICE_ID", "Ljava/util/UUID;", "getPOLAR_PMD_SERVICE_ID", "()Ljava/util/UUID;", "POLAR_PMD_CONTROL_CHARACTERISTIC_ID", "getPOLAR_PMD_CONTROL_CHARACTERISTIC_ID", "POLAR_PMD_DATA_MTU_CHARACTERISTIC_ID", "getPOLAR_PMD_DATA_MTU_CHARACTERISTIC_ID", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UUID getPOLAR_PMD_CONTROL_CHARACTERISTIC_ID() {
            return PolarConstants.POLAR_PMD_CONTROL_CHARACTERISTIC_ID;
        }

        public final UUID getPOLAR_PMD_DATA_MTU_CHARACTERISTIC_ID() {
            return PolarConstants.POLAR_PMD_DATA_MTU_CHARACTERISTIC_ID;
        }

        public final UUID getPOLAR_PMD_SERVICE_ID() {
            return PolarConstants.POLAR_PMD_SERVICE_ID;
        }

        private Companion() {
        }
    }

    static {
        UUID uuidFromString = UUID.fromString("fb005c80-02e7-f387-1cad-8acd2d8df0c8");
        uuidFromString.getClass();
        POLAR_PMD_SERVICE_ID = uuidFromString;
        UUID uuidFromString2 = UUID.fromString("fb005c81-02e7-f387-1cad-8acd2d8df0c8");
        uuidFromString2.getClass();
        POLAR_PMD_CONTROL_CHARACTERISTIC_ID = uuidFromString2;
        UUID uuidFromString3 = UUID.fromString("fb005c82-02e7-f387-1cad-8acd2d8df0c8");
        uuidFromString3.getClass();
        POLAR_PMD_DATA_MTU_CHARACTERISTIC_ID = uuidFromString3;
    }
}
