package com.urbandroid.sleep.hr.berry;

import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/urbandroid/sleep/hr/berry/BerryConstants;", "", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class BerryConstants {
    private static final UUID BERRY_CHARACTERISTIC_ID;
    private static final UUID BERRY_RFCOMM_CHANNEL_ID;
    private static final UUID BERRY_SERVICE_ID;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/urbandroid/sleep/hr/berry/BerryConstants$Companion;", "", "<init>", "()V", "BERRY_SERVICE_ID", "Ljava/util/UUID;", "getBERRY_SERVICE_ID", "()Ljava/util/UUID;", "BERRY_CHARACTERISTIC_ID", "getBERRY_CHARACTERISTIC_ID", "BERRY_RFCOMM_CHANNEL_ID", "getBERRY_RFCOMM_CHANNEL_ID", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UUID getBERRY_CHARACTERISTIC_ID() {
            return BerryConstants.BERRY_CHARACTERISTIC_ID;
        }

        public final UUID getBERRY_RFCOMM_CHANNEL_ID() {
            return BerryConstants.BERRY_RFCOMM_CHANNEL_ID;
        }

        public final UUID getBERRY_SERVICE_ID() {
            return BerryConstants.BERRY_SERVICE_ID;
        }

        private Companion() {
        }
    }

    static {
        UUID uuidFromString = UUID.fromString("49535343-fe7d-4ae5-8fa9-9fafd205e455");
        uuidFromString.getClass();
        BERRY_SERVICE_ID = uuidFromString;
        UUID uuidFromString2 = UUID.fromString("49535343-1e4d-4bd9-ba61-23c647249616");
        uuidFromString2.getClass();
        BERRY_CHARACTERISTIC_ID = uuidFromString2;
        UUID uuidFromString3 = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
        uuidFromString3.getClass();
        BERRY_RFCOMM_CHANNEL_ID = uuidFromString3;
    }
}
